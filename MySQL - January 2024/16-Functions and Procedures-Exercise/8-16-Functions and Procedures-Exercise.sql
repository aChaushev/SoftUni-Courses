USE `soft_uni`;
-- soft_uni.accounts and soft_uni.account_holders
-- SUBMIT WITHOUT DELIMITER $$ DELIMITER ;

# 8. Find Full Name
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT 
	CONCAT( first_name, ' ', last_name) AS full_name 
	FROM account_holders
	ORDER BY full_name, id;
END $$
DELIMITER ;
;

-- CALL usp_get_holders_full_name();


# 9. People with Balance Higher Than
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(number DECIMAL(19,4))
BEGIN
	SELECT ah.first_name, ah.last_name
	FROM account_holders AS ah
	LEFT JOIN accounts AS a ON ah.id = a.account_holder_id
	GROUP BY ah.first_name, ah.last_name
	HAVING SUM(a.balance) > number;
END $$
DELIMITER ;
;


# 10. Future Value Function
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (initial_sum DECIMAL(19,4), yearly_interest_rate DOUBLE, number_of_years INT )
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
	RETURN initial_sum * POW((1 + yearly_interest_rate), number_of_years);
END $$
DELIMITER ;
;

/* DECLARE future_sum DECIMAL(19, 4);
SET future_sum := initial_sum * POW(1 + yearly_interest_rate, number_of_years);
RETURN future_sum; */


# 11.	Calculating Interest
DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(input_id INT, interest_rate DECIMAL(19,4))
BEGIN
	SELECT 
	a.id AS account_id,
    ah.first_name,
    ah.last_name,
    a.balance AS current_balance,
    ufn_calculate_future_value(a.balance, interest_rate, 5) AS balance_in_5_years
FROM account_holders AS ah
JOIN accounts AS a ON ah.id = a.account_holder_id
WHERE a.id = input_id;
END $$
DELIMITER ;
;

-- Submit with problem 10 function. Put ; after END;
-- CALL usp_calculate_future_value_for_account(1, 0.1);


# 12. Deposit Money / Transaction
-- внасяне на пари в сметка
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF (money_amount <= 0) THEN ROLLBACK;
    ELSE
		UPDATE accounts SET  balance =  balance + money_amount
        WHERE id = account_id;
	COMMIT;
	END IF;
END $$
DELIMITER ;
;


# 13. Withdraw Money / Transaction
-- теглене на пари от сметка
DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4)) 
BEGIN
	START TRANSACTION;
    IF (money_amount <= 0 OR 
    money_amount > (SELECT balance FROM accounts WHERE id = account_id)) THEN ROLLBACK;
    ELSE
		UPDATE accounts SET balance = balance - money_amount
        WHERE id = account_id;
		COMMIT;
	END IF;
END $$
DELIMITER ;
;


# 14. Money Transfer
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
	START TRANSACTION;
    IF(
    (SELECT COUNT(id) FROM accounts WHERE id = from_account_id) <> 1 --  когато записите са 0 или повече от 1
    OR (SELECT COUNT(id) FROM accounts WHERE id = to_account_id) <> 1 --  когато записите са 0 или повече от 1
    OR from_account_id = to_account_id
    OR amount <= 0
    OR (SELECT balance FROM accounts WHERE id = from_account_id) < amount
    ) THEN ROLLBACK;
	ELSE
		UPDATE accounts SET balance = balance - amount
		WHERE id = from_account_id;
        UPDATE accounts SET balance = balance + amount
		WHERE id = to_account_id;
		COMMIT;
    END IF;
END $$
DELIMITER ;
;


# 15. Log Accounts Trigger
CREATE TABLE logs(
	log_id INT PRIMARY KEY AUTO_INCREMENT, 
	account_id INT NOT NULL,
	old_sum DECIMAL(19, 4) NOT NULL,
	new_sum DECIMAL(19, 4) NOT NULL
);

DELIMITER $$
CREATE TRIGGER tr_change_account_balance
AFTER UPDATE ON accounts
FOR EACH ROW -- всеки ред, който е променен
BEGIN
	INSERT INTO logs (account_id, old_sum, new_sum)
    VALUES (OLD.id, OLD.balance, NEW.balance);
END $$
DELIMITER ;
;


# 16. Emails Trigger
CREATE TABLE notification_emails(
	id INT PRIMARY KEY AUTO_INCREMENT, 
    recipient INT NOT NULL, 
    subject TEXT, 
    body TEXT
);

DELIMITER $$
CREATE TRIGGER tr_create_new_email_when_record_in_logs
AFTER INSERT ON logs
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails (recipient, subject, body)
    VALUES(
		NEW.account_id,
        CONCAT('Balance change for account: ', NEW.account_id),
        CONCAT('On ', NOW(), ' your balance was changed from ', NEW.old_sum, ' to ', NEW.new_sum, '.')
    );

END $$
DELIMITER ;
;

-- Submit with problem 15 logs table and trigger. Put ; after END;



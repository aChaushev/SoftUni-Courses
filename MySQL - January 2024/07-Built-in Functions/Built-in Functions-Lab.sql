USE `book_library`;

# 1.	Find Book Titles
SELECT `title`
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The'
ORDER BY `id`;

# 2.	Replace Titles
SELECT REPLACE(`title`, 'The', '***') AS 'title'
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = 'The' 
ORDER BY `id`;

# 3.	Sum Cost of All Books
SELECT ROUND(SUM(`cost`), 2)
FROM `books`;

# 4.	Days Lived
SELECT 
	CONCAT_WS(' ', `first_name`, `last_name`) AS 'Full Name',
	TIMESTAMPDIFF(DAY, `born`, `died`) AS 'Days Lived'
FROM `authors`;

# 5.	Harry Potter Books
SELECT `title`
FROM `books`
WHERE `title` LIKE 'Harry Potter%';


-- --------------------------------------------------
# EXAMPLES:

# STRING FUNCTIONS
SELECT REPLACE('The title', 'The', '***'); -- -> test function

SELECT LTRIM('     Trimmed');
SELECT RTRIM('Trimmed     ');
SELECT LTRIM(RTRIM('    Trimmed    '));
-- remove only white spaces

SELECT LENGTH('The String'), CHAR_LENGTH('The String'); -- use CHAR_LENGTH for safety

SELECT LEFT('The String', 3), SUBSTRING('The String', 1, 3);
SELECT RIGHT('The String', 3), SUBSTRING('The String', -3);

SELECT `title` FROM `books`
WHERE UPPER(SUBSTRING(`title`, 1, 5)) = 'HARRY';
-- WHERE LOWER(SUBSTRING(`title`, 1, 5)) = 'harry';

SELECT REVERSE('Harry');

-- SELECT REPEAT('Harry', 5);

SELECT LOCATE('RY', 'Harry');
SELECT LOCATE('Ha', 'Harry', 2); -- -> от втора позиция нанатък

SELECT `title`
FROM `books`
WHERE LOCATE('Harry', `title`) > 0; 
-- WHERE LOCATE('Harry', `title`) = 1; -> когато `title` започва с 'Harry'

SELECT INSERT('Harry Potter', 1, 0, 'The ');
SELECT INSERT('Harry Potter', 7, 10, 'Ploter');


# MATH FUNCTION
SELECT 13.5 DIV 5.2; -- целочислено деление
SELECT 13.5 / 5.2;
SELECT 13 MOD 5; -- остатък от делене
SELECT 15 MOD 2 = 0; -- result: 1 -> true; 0 -> false

SELECT PI();

SELECT ABS(5), ABS(-5);

SELECT SQRT(4); 

SELECT POW(5, 3); -- 5 на 3-та степен

SELECT ROUND(2.6578, 2);

SELECT FLOOR(2.6578);

SELECT CEILING(2.6578), CEILING(-2.6578);

SELECT SIGN(-5), SIGN(5);

SELECT RAND();
SELECT ROUND(RAND() * 100); -- random number from 0-99;
SELECT ROUND(RAND() * 7); -- random number from 0-6;
SELECT FLOOR(RAND() * 11) + 5; -- random number from 5-15;

# DATE FUNCTION
SELECT EXTRACT(YEAR FROM '2023-09-12');
SELECT EXTRACT(MINUTE FROM '2023-09-12 13:35');

SELECT TIMESTAMPDIFF(MINUTE, '2023-09-12 13:35', '2023-10-15');

SELECT NOW();

SELECT DATE_FORMAT(`born`, '%D %b %Y')
FROM `authors`;

# WILDCADS
-- '%' - represents zero, one, or multiple characters
-- '_' - represents a single character
-- '\' - prefix
-- '[]' - sequence of characters
-- '![]' - negation - sequence of characters

SELECT `title` FROM `books`
WHERE `title` LIKE 'Harry Potter%';

SELECT `title` FROM `books`
-- WHERE REGEXP_LIKE( `title` '^The [A-Za-z]+');
WHERE `title` REGEXP '^The [A-Za-z]+$';



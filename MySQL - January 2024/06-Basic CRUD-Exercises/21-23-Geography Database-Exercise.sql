USE `geography`;

# 21.  All Mountain Peaks 
SELECT `peak_name`
FROM `peaks`
ORDER BY `peak_name`;

# 22.  Biggest Countries by Population 
SELECT `country_name`, `population`
FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC, `country_name`
LIMIT 30;

# 23.  Countries and Currency (Euro / Not Euro) 
SELECT `country_name`, `country_code`, 
IF(`currency_code` = 'EUR', 'Euro', 'Not Euro') AS 'currency'
FROM `countries`
ORDER BY `country_name`;

/* 
SELECT `country_name`, `country_code`, 
CASE WHEN `currency_code` = 'EUR'
THEN 'Euro' 
ELSE 'Not Euro'
END
AS 'currency'
FROM `countries`
ORDER BY `country_name`; 
*/

USE geography;

# 12. Highest Peaks in Bulgaria
SELECT
	c.country_code,	
	m.mountain_range,
	p.peak_name,
	p.elevation
FROM countries AS c 
JOIN mountains_countries AS mc ON c.country_code = mc.country_code
JOIN mountains AS m ON mc.mountain_id = m.id
JOIN peaks AS p ON m.id = p.mountain_id
WHERE c.country_name = 'Bulgaria'
AND p.elevation > 2835
ORDER BY p.elevation DESC;

/*
SELECT c.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `peaks` AS p
INNER JOIN `mountains` AS m ON p.`mountain_id` = m.`id`
INNER JOIN `mountains_countries` AS c ON m.`id` = c.`mountain_id`
WHERE c.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;
*/

# 13. Count Mountain Ranges
SELECT
	mc.country_code,
	COUNT(m.mountain_range) AS mountain_range
FROM mountains AS m 
JOIN mountains_countries AS mc ON m.id = mc.mountain_id
WHERE mc.country_code IN ('US', 'RU', 'BG')
GROUP BY mc.country_code
ORDER BY mountain_range DESC;


# 14. Countries with Rivers
SELECT
	c.country_name,
	r.river_name
FROM countries AS c 
LEFT JOIN countries_rivers AS cr ON c.country_code = cr.country_code
LEFT JOIN rivers AS r ON cr.river_id = r.id
WHERE c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;


# 16. Countries Without Any Mountains
SELECT
	COUNT(c.country_code) AS country_count
FROM countries AS c 
LEFT JOIN mountains_countries AS mc ON c.country_code = mc.country_code
LEFT JOIN mountains AS m ON mc.mountain_id = m.id
WHERE m.mountain_range IS NULL;
	

# 17. Highest Peak and Longest River by Country
SELECT
	c.country_name,
	MAX(p.elevation) AS 'highest_peak_elevation',
    MAX(r.length) AS 'longest_river_length'
FROM countries AS c 
LEFT JOIN mountains_countries AS mc ON c.country_code = mc.country_code
LEFT JOIN peaks AS p ON mc.mountain_id = p.mountain_id
LEFT JOIN countries_rivers AS cr ON c.country_code = cr.country_code
LEFT JOIN rivers AS r ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, c.country_name
LIMIT 5;

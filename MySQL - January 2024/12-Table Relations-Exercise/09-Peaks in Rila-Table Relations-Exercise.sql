# 9. Peaks in Rila
SELECT m.mountain_range, p.peak_name, p.elevation AS peak_elevation
FROM mountains AS m
JOIN peaks AS p 
ON m.id = p.mountain_id 
AND m.mountain_range = 'Rila' -- WHERE m.mountain_range = 'Rila'
ORDER BY `peak_elevation` DESC;

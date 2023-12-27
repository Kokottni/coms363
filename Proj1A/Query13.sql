SELECT d.name, d.level, COUNT(DISTINCT m.snum) AS num_students
FROM (
    SELECT snum, name, level FROM major
    UNION ALL
    SELECT snum, name, level FROM minor
) AS m
JOIN degrees d ON m.name = d.name AND m.level = d.level
GROUP BY d.name, d.level
HAVING COUNT(DISTINCT m.snum) = (
    SELECT MAX(student_count)
    FROM (
        SELECT COUNT(DISTINCT m.snum) AS student_count
        FROM (
            SELECT snum, name, level FROM major
            UNION ALL
            SELECT snum, name, level FROM minor
        ) AS m
        GROUP BY name, level
    ) AS counts
)
ORDER BY d.name;
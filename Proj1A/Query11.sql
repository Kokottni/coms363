SELECT COUNT(DISTINCT s.snum) AS num_female_students
FROM students s
WHERE s.snum IN (
    SELECT snum FROM major WHERE name = 'Software Engineering'
    UNION
    SELECT snum FROM minor WHERE name = 'Software Engineering'
)
AND s.gender = 'F';
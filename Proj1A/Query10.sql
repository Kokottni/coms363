SELECT c.number, c.name, COUNT(r.snum) AS num_students
FROM courses c
LEFT JOIN register r ON c.number = r.course_number
GROUP BY c.number, c.name
ORDER BY c.number;
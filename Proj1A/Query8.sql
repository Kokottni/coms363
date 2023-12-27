SELECT name, snum, ssn
FROM students
WHERE UPPER(name) LIKE '%N%'
ORDER BY snum;
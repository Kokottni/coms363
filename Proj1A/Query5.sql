select d.name, d.level from degrees d, departments s
where d.department_code=s.code and d.name='Computer Science' order by d.level;
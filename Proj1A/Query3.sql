select c.number, c.name from courses c, departments d
where c.department_code=d.code and d.name='Computer Science' order by c.number;
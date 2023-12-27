update students s set name='Scott' where s.ssn=746897816;

update major m, students s 
set m.name='Computer Science', m.level='MS'
where m.snum=s.snum and s.ssn=746897816;

delete from register where regtime='Spring2021';
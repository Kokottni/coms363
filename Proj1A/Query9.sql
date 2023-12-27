select s.name, s.snum, s.ssn from students s
where s.name >= 'Becky' and s.name <= 'Nicole'
order by s.name;
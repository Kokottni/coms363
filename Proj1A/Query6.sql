select s.snum, s.name from students s, minor m
where s.snum=m.snum order by s.snum;
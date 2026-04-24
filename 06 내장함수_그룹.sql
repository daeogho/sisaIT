select (now);



select date_format(now(), '%y-%m-%d') ;
select date_format(now(), '%y년 %m 월%d'), date_format('20251225', '%y년/%m/월%d'); 
select date_format( '2025-05-05', '%w %m %y') ;
select date_format(now(), '%y-%m-%d h%:%i:%s %p %w %a %d') ;
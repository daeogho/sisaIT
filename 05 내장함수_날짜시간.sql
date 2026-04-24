-- 현재 시스템의 날짜와 시간구하는 함수alter
-- curdate(), curtime() : 년월일
-- now(), sysdate() : 년월일, 시분초
-- date(), time()
select curdate(), curtime();
select now(), sysdate();
select date(now()), time(now());
select date(hiredate), time(hiredate) from emp;

-- 년월일시분초를 각각 알아오기
select year(now()), month(now()), dayofmonth(now()), hour(now()), second(now()), microsecond(now());

-- adddate() : 날짜를 기준으로 더하기
-- subdate() : 날짜를 기준으로 빼기
select adddate(now(), interval 100 day), subdate(now(), interval 50 day);

-- datediff() : 날짜와 날짜의 간격을 일수로 구해준다.
select abs(datediff(now(), '2026-05-28'));

-- timediff() : 시간의 간격을 구해준다.
select timediff(time(now()), '18:20:00');

-- dayofweek() : 요일 구하기 // 1:일, 2:월, 3:화, 4:수
-- monthname() : 월명을 영어로
-- dayofyear() : 올해 몇일째
select dayofweek(now()), monthname(now()), dayofyear(now());
-- last_day() : 해당월 마지막날
-- time_to_sec(시간) : 초로 환산
select last_day(now()), time_to_sec('3:15:15');

-- emp테이블에서 입사년도가 1981, 1982도인 사원을 선택하라.
select * from emp
where year(hiredate) in(1981,1982);


-- emp테이블의 사원을 사원명, 입사일, 근속일수를 구하여 출력하라.
desc emp;
select ename, hiredate, datediff(now(), hiredate) 근속일수 from emp;
show databases;
use employees;
show tables;
-- 2.
select emp_no 사원번호, first_name 사원명, hire_date 입사일 
from employees
order by first_name desc;

-- 3.
select emp_no 사원번호, first_name 사원명, hire_date 입사일 
from employees 
where hire_date like '_____06%' || '____12%';

-- 4.
select * from employees
where first_name like 'A%' and birth_date between '1950%' and'1959%'
order by birth_date desc;

-- 5.
select * from employees
where birth_date like '1960%' and gender in('M');

-- 6.
select * from employees
where birth_date like '_____01%' and gender in('f') order by first_name desc;

-- 7.
use study_db;
show tables;
select * from emp
where hiredate < '1990%' and ename like '%B%' order by hiredate desc ;

-- 8.
show tables;

-- 9.
use employees;
show tables;
select emp_no, first_name, birth_date, hire_date from employees
order by first_name asc, emp_no desc;  

-- 10.
show databases;
use employees;
show tables;

-- 11.
show databases;
-- ==========================11월 27일 과제=======================================

-- 1. emp테이블의 레코드 중 사원명, 담당업무, 급여, 입사일을 선택하고 이름은 마지막 2글자를 **으로 표시하며, 입사일이 빠른순서로 정렬한다.
show databases;
use study_db;
desc emp;
select empno, job, sal, hiredate,
rpad(substring(ename, 1, ceil(char_length(ename)-2)), char_length(ename), '*') from emp
order by hiredate asc;

-- 2. emp 테이블의 사원중 1981년도에 입사한 사원의 사원번호, 사원명, 급여, 보너스, 지급액, 입사년도를 선택하고 사원명을 기준으로 오름차순으로정렬한다.
select hiredate, empno, ename, sal, comm, sal+ifnull(comm,0) from emp
where year(hiredate) in (1981) order by ename desc;

-- 3. emp 테이블의 사원중 MANAGER, SALESMAN업무를 하는 사원의 사원명, 담당업무, 입사일, 근무년수를 선택하고 담당업무 기준으로 오름차순 정렬한다.
select ename, job, hiredate, floor(datediff(now(), hiredate)/365) 근무년수 from emp
where job = 'MANAGER' or job = 'SALESMAN' order by job desc;
select * from emp;


-- =============================11웛 28일 과제==========================

-- 1. 오늘날짜와 시간을 다음 형식으로 표시하라. 보기) 2025년 11월 28일 4시 50분 pm
use study_db;
select now();
select date_format(now(), '%y년 %m월 %d일 %h시 %i분 %p');

-- 2. emp테이블의 레코드 중 이름에 'A', 'B'가 들어 있는 사원의 사원수, 급여의 합계, 최고 급여를 출력하라.
select count(empno) 사원수, sum(sal) "급여의 합계", max(sal) from emp where ename like '%A%' or ename like '%B%';

-- 3. emp테이블의 레코드를 이용하여 부서별(deptno) 사원수, 최고급여, 최저급여, 급여의 평균을 출력하라.
select deptno 부서코드, count(ename) 사원수, max(sal) 최고급여, min(sal), avg(sal) "급여의 평균" from emp group by deptno order by deptno;

-- 4. emp테이블에서 담당업부별 사원수, 급여의합, 급여의 평균을 구하여 사원수가 3명이상인 업무만 선택하라.
select job, count(empno), sum(sal), avg(sal) from emp group by job having count(empno) >=3;

-- 5. emp테이블을 이용하여 새로운 테이블생성하기
-- 테이블 명 : emp_copy8
-- 필요필드 : 사원번호, 사원명, 담당업무, 입사일, 급여
create table emp_copy8
as
select empno, ename, job, hiredate, sal
from emp
where job != 'CLERX';
select * from emp_copy8;

-- 6. emp_copy8테이블에 아래정보의 레코드를 추가하라.
-- 사원번호 : 4545
-- 사원명 : 김연아
-- 입사일 : 오늘
-- 급여 : 5200
insert into emp_copy8(empno, ename, hiredate, sal) values('4545', '김연아', now(), 5200);
desc emp_copy8;

-- 7. emp_copy8테이블에서 'MARTIN'사원을 급여를 20%인상한 금액으로 수정하고, 담당업무를 '마케팅'으로 변경하라.
update emp_copy8 set sal=sal*1.2, job = '마케팅' where ename = 'MARTIN';

-- 8. emp_copy8테이블에서 사원명에 'L'이 포함된 사원을 삭제하라.
delete from emp_copy8 where ename like '%L%';



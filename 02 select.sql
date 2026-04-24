show databases;

show tables;
use study_db;

-- 테이블 레코드 선택하는 쿼리문
select * from emp;
-- 사원번호, 사원명, 급여를 선택한다.
select empno, ename, sal from emp;
--      사원명,   입사일,  급여,  보너스 선택한다.
select ename, hiredate, sal, comm from emp;
-- 테이블구조 확인하기
desc emp;

-- 사원번호, 사원명, 담당업무, 급여를 선택하라.
-- alias = 별명 = 별칭
-- 별칭에 빈칸이 없으면 ""는 생략이 가능하다.
SELECT EMPNO "사원 번호", 
ename as 사원명, job 담당업무, sal 급여 from emp;
-- as는 생략가능
desc emp;

show databases;
use employees;
show tables;
desc employees;

select emp_no, first_name, gender, hire_date from employees;

-- where절 = 조건절 = 레코드 선택
select emp_no, first_name, gender from employees where gender = 'M'; -- 젠더가 m 과 같으면 select 설정한것들 선택해

select count(emp_no) from emplyees;

show databases;
use study_db;
show tables;
select * from emp;
-- 사원번호, 이름, 급여, 급여를 10%인상한 금액을 선택하라.
select empno 사원번호, ename 이름, sal 급여, sal*1.1 인상한지급액 from emp;

-- 사원명, 담당업무, 급여, 보너스, 지급액을 선택하라. 지급액 = 급여+보너스
--      comm필드의 값이 null이면 0으로 처리하라
-- nvl(comm, 0) -> oracle            ifnull(comm, 0) -> mysql
select empno 사원번호, ename 사원명, job 담당업무, sal 급여, comm 보너스, sal+ifnull(comm, 0) 지급액 from emp;

-- 급여가 1000불이상이고 3000불 미만인 사원을 선택하라
select * from emp where sal >=1000 and sal<3000;

-- BETWEEN 연산자 and 
-- 급여가 1500불에서 3000불 사이인 사원을 선택하라.
select * from emp where sal >=1500 and sal<=3000;
select * from emp where sal between 1500 and 3000;
select * from emp where sal not between 1500 and 3000;

-- [문제]
show databases;
use employees;
show tables;
desc employees;
select emp_no, first_name 사원명, hire_date 입사일, gender 성별 
from employees
where emp_no between 40001 and 40010;

use study_db;
show tables;
-- 사원중 사원번호가 7369, 7566, 7782, 7900인 사원을 선택하라.
select * from emp
where empno = 7369 or empno = 7566 or empno = 7782 || empno = 7900;

select * from emp
where empno in(7369, 7566, 7782, 7900);

-- 사원중 담당업무가 MANAGER이거나 SALESMAN인 사원을 선택하라.
select * from emp
where job = 'MANAGER' or job = 'SALESMAN';

select * from emp
where job in('MANAGER', 'SALESMAN');

-- MANAGER, SALESMAN업무가 아닌 사원을 선택하라.
select * from emp
where job not in('MANAGER', 'SALESMAN');

show databases;
use employees;
show tables;
select emp_no, first_name from employees where emp_no in(10005,10009);

select * from employees where first_name like 'A%';
select * from employees where first_name like '%A';
select * from employees where first_name like '%dra%';
select * from employees where first_name like '%v%a%';

-- 이름에 2번째 문자 Z사원을 선택
select * from employees where first_name like '_Z%';

-- 1989년에 입사한 사원을 선택하라.
select * from employees where hire_date like '1989%';

-- 사원번호가 10001~10100 사이이고 생일이 06월인 사원을 선택하라.
select * from employees where emp_no between 10001 and 10100 and birth_date like '_____06%';

show databases;
use study_db;
show tables;
select * from emp;
-- 이름을 오름차순으로 정렬하라.
select * from emp order by ename asc;
-- 급여가 많은 순서로 정렬하라.
select * from emp order by sal desc;
-- 담당업무를 오름차순으로 정렬하고 담당업무가 같으면 급여를 내림차순으로 정렬하라.
select * from emp order by job asc, sal desc, ename asc;

-- [문제] emp 테이블의 사원중 사원번호, 사원명, 담당업무, 지급액을 선택하라.
--          [처리조건] 지급액은 급여+보너스이다.
--                   급여가 1500불에서 3500불 사이인 사원만 선택한다.
--                   이름을 내림차순으로 정렬하라.

show databases;
use study_db;
show tables;
select empno, ename 사원명, job 담당업무, sal 급여, comm 보너스, sal+ifnull(comm, 0) 지급액
from emp 
where sal between 1500 and 3500 order by ename desc; 

-- [문제]
--  1. EMPLOYEES테이블의 레코드 중 사원번호, 사원명, 입사일, 성별을 선택하라.
use employees;
desc employees;
select emp_no, first_name, hire_date, gender from employees;

-- 2. EMPLOYEES테이블의 레코드 중 사원번호, 사원명, 입사일을 선택하라.
--    (단, 사원명을 오름차순으로 정렬하여 선택)
select emp_no, first_name, hire_date from employees
order by first_name asc;

-- 3. EMPLOYEES테이블의 레코드 중 6월, 12월에 입사한 사원의 사원번호, 사원명, 입사일을 선택하라.
select emp_no 사원번호, first_name 사원명, hire_date 입사일 
from employees 
where hire_date like '_____06%' || '____12%';

-- 4.EMPLOYEES테이블의 레코드 중 사원명에 ‘A’로 시작하고 생일이 1950년~1959년 사이인 사원을 나이
--   가 많은 순으로 선택하라.
select * from employees
where first_name like 'A%' and birth_date between '1950-01-01' and '1959-12-31'
order by birth_date desc;

-- 5. EMPLOYEES테이블의 레코드 중 1960년도에 태어난 남자사원을 선택하라.
select * from employees
where birth_date like '1960%' and gender in('M');

-- 6. EMPLOYEES테이블의 사원 중 1월에 태어난 여자 사원을 이름을 오름차순으로 선택하라.
select * from employees
where birth_date like '_____01%' and gender = 'f' order by first_name asc;

-- 7. EMP테이블의 사원 입사일이 1990-01-01이후인 사원과 이름에 B가 포함된 사원을 입사일 기준 내림
--    차순으로 정렬하여 선택하라.
use study_db;
show tables;
select * from emp
where hiredate < '1990%' and ename like '%B%' order by hiredate desc ;

-- 8. 현재 데이터베이스의 테이블 목록을 확인하는 쿼리문을 작성하라.
show tables;

-- 9. EMPLOYEES테이블의 사원 중 사원번호, 이름, 생년월일, 입사일을 이름은 오름차순, 사원번호는 내림
--    차순으로 정렬하여 선택하라
use employees;
show tables;
select emp_no, first_name, birth_date, hire_date from employees
order by first_name asc, emp_no desc; 

-- 10.  EMPLOYEES테이블의 구조를 확인하는 쿼리문을 작성하라.
use employees;
 
-- 11. 현재 계정의 데이터베이스의 목록을 확인하는 쿼리문을 작성하라
show databases;

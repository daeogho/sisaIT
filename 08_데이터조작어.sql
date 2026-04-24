-- 테이블 복사
-- emp테이블의 모든 필드와 모든 레코드를 복사
create table emp_copy
as
select * from emp;
show tables;
select * from emp_copy;

-- emp테이블의 사원번호, 사원명, 급여만 복사
create table emp_copy2
as
select empno, ename, sal from emp;

show tables;
select * from emp_copy2;

-- emp테이블의 레코드중 manager, salesman 업무하는 레코드만 복사
create table emp_copy3
as
select * from emp where job in('MANAGER','SALESMAN');
select * from emp_copy3;

-- emp테이블의 구조만 복사
create table emp_copy4
as
select * from emp where 1=2;

show tables;
select * from emp_copy4;

--  -------------------insert-----------------
-- 사원 추가                    '20250112' '2012/02/14' '2025-04-05'
insert into emp_copy
values(1111,'홍길동','서비스',7839,'20250112',4000,100,40);

insert into emp_copy(ename, sal, deptno, empno,job, mgr, hiredate,comm)
values('세종대왕',6000,10,2222,'놀기',7839,'2000-10-10',10);

insert into emp_copy(empno,ename, sal)
values(3333,'이순신',5500);

insert into dept(deptno, dname,loc) values(50,'기획부','서울');

select @@autocommit;
set autocommit=0;

-- rollback : 쿼리문(insert,update, delete)취소
insert into emp_copy(empno, ename)
values(5555,'김삿갓');
select * from emp_copy;

rollback;
select * from emp_copy;



show tables;
select * from emp_copy;
desc emp_copy;
select * from dept;
desc dept;
-- 자동 COMMIT; -> 레코드 추가, 수정, 삭제를 확정 짓는다.

-- commit, rollback -> 트랜잭션
select @@autocommit;

-- 다른 테이블의 레코드 또 다른 테이블로 원하는 레코드만 한번에 insert하기
show tables ;
select * from emp_copy4 ;

-- job이 manager이거나 salesman인 사원을 emp_copy4에 insert하기
insert into emp_copy4(empno, ename, job, mgr, hiredate, sal ,comm, deptno)
select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp
where job in ('manager', 'salesman') ;


-- --- update : 레코드 수정
set autocommit =0 ;
use study_db;
-- comm을 모두 100불로 수정한다.
update emp_copy set comm=200;
update emp_copy set comm=100 where job= 'MANAGER';
update emp_copy set job='사무직'  where empno=4444;


-- --delete : 레코드 삭제
delete from emp_copy where empno in(1111,3333) ;
delete from emp_copy where job='clerk';


-- 부선번호가 null인 사람을 삭제한다.---
delete from emp_copy where deptno is null ;

delete from emp_copy ;
select @@autocommit;


select * from emp_copy ;
-- --------------------------------------------------------------------


show databases ;
use study_db;
show tables ;
delete from emp_copy ;
delete from emp_copy2 ;
delete from emp_copy3 ;
delete from emp_copy4 ;
select * from emp_copy ;
select * from emp_copy2 ;
select * from emp_copy3 ;
select * from emp_copy4 ;
select empno 사원번호, ename 사원명, job 업무, mgr 매니저번호, hiredate 입사일, sal 급여, comm 보너스,deptno 부서 from emp;
select * from emp ;

-- 1.오늘날짜와 시간을 다음형식으로 표시하라
-- [보기] 2025년 11월 28일 4시 50분 PM
select date_format(now(), '%Y년 %m월 %d일 %h시 %i분 %p');

-- 2.emp테이블의 레코드중 이름에'A','B'가 들어 있는 사원의 사원수, 급여의 합계, 최고 급여를 출력하라.
select count(ename) 사원수, sum(sal) 급여합계, max(sal) 최고급여 from emp
where ename like '%a%' or ename like '%b%';

select ename 사원수, sal 급여 from emp
where ename like '%a%' or ename like '%b%';

-- 3.emp테이블의 레코드를 이용하여 부서별(deptno) 사원수, 최고급여, 최저급여, 급여의 평균을 출력하라.
select deptno 부서, count(ename) 사원수, max(sal) 최고급여, min(sal) 최저급여, avg(sal) from emp
group by deptno ;


-- 4.emp테이블에서 담당업무별 사원수, 급여의합, 급여의 평균을 구하여 사원수가 3명이상인 업무만 선택하라.



-- 5.emp테이블을 이용하여 새로운 테이블생성하기
-- 테이블명 : emp_copy8  필요필드 : 사원번호, 사원명, 담당업무, 입사일, 급여  필요레코드:사무직을 제외한 사원



-- 6.emp_copy8테이블에 아래정보의 레코드를 추가하라.
-- 사원번호:4545   사원명:김연아    입사일:오늘    급여:5200



-- 7.emp_copy8테이블에서 'MARTIN'사원을 급여를 20%인상한 금액으로 수정하고, 담당업무를 '마케팅'으로 변경하라.



-- 8.emp_copy8테이블에서 사원명에 'L'이 포함된 사원 삭제하라.
-- view : 가상테이블 
show databases;
use study_db;
CREATE OR REPLACE view view1_tbl 
as 
select a.ename, b.dname from emp a join dept b on a.deptno= b.deptno and b.deptno = 20;

select * from emp;

select * from dept;

-- emp테이블의 사원번호, 사원명, 입사일, 급여, 부서번호로 가상테이블 생성
create view emp_view
as
select empno, ename, hiredate, sal, deptno from emp; 
show tables;
select * from emp_view;
select * from emp;
-- 사원 정보 수정하기
update emp_view set sal = sal * 1.1 where ename = 'adams';

-- 사원 추가
insert into emp_view value(5555,'홍길동',now(),4500,40); 

-- 사원 삭제
delete from emp_view where empno = 5555;

-- wiht check option : 조건에 해당하는 레코드만 추가 수정이 가능하도록한다.
create view emp_view_2
as
select empno, ename, job, sal, deptno from emp where deptno in(10,20) with check option;
insert into emp_view_2(empno, ename,job,sal,deptno)

values(8888,'AAAA','홍보',3500,10);
insert into emp_view_2(empno,'BBBB','마케팅', 2500,30); 

insert into emp_view_2valusd(4444,'CCCC',no.(), 50000,80;

update emp_view_2 sel set job = '매니저' where job = 'manager';


select * from emp_view_2;

-- with read only : 읽기 전용 view 테이블 생성하기
-- create or replace view emp_view_3
-- as select empno, ename, job, sal, dname, deptno from emp natural join dept read only;
show tables;
select * from user_views;
drop view view1_tbl; 
drop view emp_view; 
drop view emp_view_2;
show tables;
-- table 삭제, buytbl, prodtbl, usertbl
drop table emp_copy8;
drop table prodtbl; 
drop table usertbl;

use study_db;
select avg(sal) from emp; -- 2470.3125

select empno, ename, sal from emp where sal >= 2470.3125;

select empno, ename, sal from emp where sal >= (select avg(sal) from emp);

-- 단일행 서브쿼리 : = , >, >=, <, <=, <>, !=
-- 7369 사원과 같은 업무를 하는 사원을 선택하라.
select * from emp where job=(select job from emp where empno=7369);

-- [문제] 사원테이블에서 scott의 급여보다 많은 사원의 사원번호, 이름, 업무, 급여를 출력하세요.
select * from emp where sal > (select sal from emp where ename = 'scott');


-- [문제] 사원테이블에서 사원명, 입사일, 담당업무, 부서코드를 선택하되 ‘ADAMS’와 같은 업
--       무를 하는 사원이거나 ‘SCOTT’과 같은 부서인 사원을 선택하라.
desc emp;

select ename, hiredate, job, deptno from emp where job =(select job from emp where ename = 'ADAMS') or deptno =(select deptno from emp where ename = 'scott');

-- [문제] 사원테이블에서 사원번호가 7521인 사원과 업무가 같고 급여가 7934인 사원보다 
--       많은 사원의 사번,이름,업무,입사일자,급여를 출력하세요.
select empno, ename, job, hiredate, sal from emp where job = (select job from emp where empno=7521) and sal > (select sal from emp where empno = 7934);

-- 그룹함수를 서브쿼리 적용
-- 사원전체의 평균급여보다 많이 받는 사원을 선택하라.
select empno, ename, job, sal, deptno from emp where sal > (select avg(sal) from emp);

-- [실습] 사원테이블에서 사원의 급여가 20번부서의 최소급여보다 많이 받는 부서를 선택하라
select * from emp order by deptno;
-- 부서별 최소급여
select deptno, min(sal) from emp group by deptno having min(sal) > (select min(sal) from emp where deptno=20);

-- [문제] 사원테이블의 사원의 급여가 10번부서의 평균급여보다 많이 받는 업무를 하는 업무별 평균급여를 선택하라.
select job, avg(sal) from emp group by job having avg(sal) > (select avg(sal) from emp where deptno=10);

select * from emp order by deptno;

-- 다중행 서브쿼리
-- 서브 쿼리의 결과가 여러행일때

-- 부서별로 급여를 가장 많이 받는 사원과 같은 급여를 받는 사원의 사원번호, 사원명, 급여, 부서코드를 출력하라
select empno, ename, sal, deptno from emp where sal in (select max(sal) from emp group by deptno);

select empno, ename, sal, deptno from emp where sal not in (select max(sal) from emp group by deptno);

-- [문제] 업무별로 최대 급여를 받는 사원과 같은 급여를 받는 사원의 사원번호와 이름, 업무, 급여을 출력하세요.

select empno, ename, job, sal from emp
where sal in (select max(sal) from emp group by job) order by job asc;

-- ANY : 여러개의 값중 1개만 만족하면 참
select sal from emp where job = 'salesman'; -- 1600,1250,1250,1500

select ename, sal, deptno from emp where deptno != 20 and sal > any(select sal from emp where job = 'salesman');

desc emp;
-- [문제] 사원테이블의 사원중 / KING속한 부서의 사원보다 / 늦게 입사한 사원의 /사원명, 업무, 급여, 입사일을 선택하라
select ename, job, sal, hiredate from emp
where deptno != 10 and hiredate > any(select hiredate from emp where deptno = (select deptno from emp where ename = 'king'));

-- all 연산자 : 모든 값이 참이여야 한다.
select ename, sal from emp where deptno != 20 and sal > all(select sal from emp where job='salesman');
select ename, sal from emp where deptno != 20 and sal > (select max(sal) from emp where job='salesman');

-- exists : 비교대상이 되는 테이블 양쪽에 정보가 있으면 참이되고 레코드를 선택한다.
-- 관리자인 사원을 선택하다.
select empno, ename, job, mgr from emp e
where exists (select empno from emp where e.empno=mgr);


-- 다중열 서브쿼리
-- 사원테이블에서 /급여와 보너스가 /부서 30에 있는 사원의 /급여, 보너스와 일치하는 사원의 /이름, 부서번호, 급여, 보너스를 출력하세요.
select empno, sal, comm, deptno from emp
where (sal, deptno) in (select sal, deptno from emp where deptno = 30 and comm is not null);

select * from emp order by deptno desc;

-- [문제] 업무별로/ 최소 급여를 받는 사원의/ 사번, 이름, 업무, 부서번호를 출력하세요. / 단, 업무별로 정렬하세요.
select empno, ename, job, sal, deptno from emp
where (job, sal) in (select job, min(sal) from emp group by job)
order by job asc;

use study_db;
select * from emp;

-- from절에 subquery
select empno, ename, job, sal 
from (select empno, ename, job, sal, deptno from emp where deptno in (10,20)) a
where a.sal > 2000;

show tables;
select * from emp;

show databases;
use information_schema;
show tables;
select * from table_constraints where table_name in ('emp', 'dept');

use study_db;
-- 사원번호, 사원명, 급여, 부서명을 선택하라.
select empno, ename, sal, dname from emp, dept where emp.deptno = dept.deptno;

select emp.empno, emp.ename, emp.sal, dept.dname, emp.deptno from emp, dept where emp.deptno = dept.deptno;

select e.empno, e.ename, e.sal, d.dname, e.deptno from emp, dept where e.deptno = d.deptno;

-- 사원번호, 사원명, 담당업부, 부서명, 위치를 선택하라.
select e.empno, e.ename, e.job, d.dname, d.loc
from emp e join dept d on e.deptno=d.deptno;


-- 사원번호, 사원명, 급여, 부서코드, 부서명을 선택하는데 담당업무가 manager이거나 clerk인 사원을 선택하라.
select e.empno, e.ename, e.sal, e.deptno, d.dname from emp e join dept d
on e.deptno = d.deptno where job in ('manager', 'clerk');

select ename, job, A.deptno, B.loc 
from (select ename, job, deptno from emp where job='manager') A join dept B
on A.deptno=B.deptno;

-- SALESMAN의 사원번호, 이름, 급여, 부서명, 근무지를 출력하여라.
desc emp;
select a.empno, a.ename, a.sal, d.dname, d.loc, a.job 
from (select empno, ename, sal, deptno, job from emp where job = 'salesman') a join dept d
on a.deptno = d.deptno;

select e.empno, e.ename, e.sal, dname, d.loc
from emp e join dept d
on e.deptno=d.deptno
where e.job='salesman';

show tables;

select * from salgrade;

-- 비동등 조인
-- 값의 범위를 이용하여 조인하기
-- 사원번호, 이름, 급여, 호봉, losal, hisal를 선택하라.
select e.empno, e.ename, e.sal, s.grade, s.losal, s.hisal from emp e join salgrade s
on e.sal between s.losal and s.hisal;

-- 사원번호, 이름, 급여, 호봉, 담당업무, 부서명, 위치 호봉을 선택하라.
select e.empno, e.ename, e.sal, e.job, d.dname, d.loc, s.grade
from emp e join dept d on  e.deptno = d.deptno 
join salgrade s on e.sal between s.losal and s.hisal;

show tables;
select * from emp;

-- self조인
-- 같은 테이블을 별명을 이용하여 조인가능하다.
-- emp a                     emp b
-- 사원명, 사원명, 담당업무, 급여, 관리자사번, 관리자명,  관리자급여, 관리자입사일을 선택한다.
select a.empno, a.ename, a.job, a.sal, b.empno, b.ename, b.sal, b.hiredate
from emp a join emp b
on a.mgr=b.empno;

-- [문제] emp테이블에서 "누구의 관리자는 누구이다"는 내용을 출력하세요
select * from emp;
select concat(a.ename, '의 관리자는 ', b.ename, ' 이다.') from emp a join emp b
on a.mgr = b.empno;

-- [문제] 사원명, 담당업무, 부서명, 관리자명, 관리자담당업무, 사원의 호봉을 선택하라.
-- 10,20 번 부서의 사원만 선택
show tables;
desc dept;
select * from emp order by deptno asc;

select a.ename 사원명, a.job 담당업무, d.dname 부서명, b.ename 관리자명, b.job 관리자담당업무, s.grade 
from emp a join emp b on a.mgr=b.empno
join dept d on a.deptno = d.deptno
join salgrade s on a.sal between losal and hisal
where a.deptno in(10, 20);

select a.ename 사원명, c.dname 부서명, a.job 업무, b.ename 관리자명, b.job 관리자업무
from (select empno, ename, job, mgr, sal, deptno from emp where deptno in (10, 20)) a join emp b
on a.mgr=b.empno join dept c on a.deptno=c.deptno
join salgrade d on a.sal between d.losal and d.hisal;


-- distinct
select distinct job from emp;
select distinct deptno from emp;
select distinct job, sal from emp order by job;

select * from emp;
select * from dept;

select e.empno, e.ename, e.job, e.deptno, d.deptno, d.dname, d.loc
from dept d join emp e on d.deptno=e.deptno;

select distinct (a.deptno), b.deptno from emp a join dept b on a.deptno=b.deptno;

-- [문제] emp테이블에서 모든 사원에 대한 이름, 부서번호, 부서명을 출력하는 문장을 작성하세요. (부서번호순으로 오름차순 정렬하라.)
select e.ename, e.deptno, d.dname 
from emp e join dept d on e.deptno=d.deptno
order by deptno desc;

-- [문제] emp테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름, 업무, 급여, 부서명을 출력하는 SELECT문을 작성하세요
select * from dept;
select e.ename, e.job, e.sal, d.dname, d.loc
from emp e join dept d on e.deptno = d.deptno
where d.loc = 'new york';

-- [문제]  EMP테이블에서 보너스를 받는 사원에 대하여 이름, 부서명, 위치를 출력하는 SELECT문을 작성하세요
select * from emp;
select e.ename, d.dname, d.loc, e.comm from emp e join dept d on e.deptno = d.deptno
where e.comm > 0; 

-- [문제] EMP테이블에서 이름 중 L자가 있는 사원에 대해 이름, 업무, 부서명, 위치를 출력하는 문장을 작성하세요.
select e.ename, e.job, d.dname, d.loc from emp e join dept d on e.deptno = d.deptno
where e.ename like '%L%';

-- [문제] 아래의 결과를 출력하는 문장을 작성하세요 (관리자가 없는 King을 포함하여 모든 사원을 출력)
select * from emp;
select distinct a.ename Emplyee, a.empno Emp, b.ename Manager, a.mgr Mgr
from emp a left outer join emp b on a.mgr = b.empno;

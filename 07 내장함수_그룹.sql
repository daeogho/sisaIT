use study_db;
-- 그룹함수 : 테이블의 전체 레코드 또는 일부 레코드로 통계를 구할 수 있다.

select * from emp;

-- count() : 행의 수
select count(ename), count( ifnull(comm,0)) from emp ;

-- max() : 제일큰값, min() : 제일잘은값
select max(sal),min(sal),max(hiredate), min(ename) from emp;

-- sum(): 합, avg() : 평균
select sum(sal), avg(sal) from emp;
select sum(sal), round(avg(sal),1) from emp where job='MANAGER';

select * from emp;
-- group by 절
select job, sum(sal) from emp group by job; -- group by절에 있는 필드명은 select 절에 기승 할 수 있다.
-- select job,sum(sal) from emp; -- 그룹함수를 사용하지 않은 field명을 select에 표기할 수 있다.

-- 부서별 사원수, 급여의 합계, 급여의 평균, 최대급여를 구하라.
select deptno 부서코드, sum(sal) 급여의한계, avg(sal) 급여의평균, max(sal) 최고의급여
from emp group by deptno order by deptno;


-- 1981년도 입사한 사람의 업무별 급여의 합계와 급여의 평균, 사원수를 구하라
-- 업무별 오름차순으로 정렬하라.
select job, sum(sal), avg(sal), count(ename) from emp where
year(hiredate)=1981 group by job order by job ;

-- 업무별로 그룹하여  업무, 인원수,  평균 급여액, 최고 급여액,
-- 최저 급여액 및 합계를 출력하라
select job, count(empno) 사원수, avg(sal) 평균급여, min(sal) 최저급여,
	   sum(sal) 급여합계, max(sal) 최고급여 from emp group by job;
       
       
-- having : group 함수의 결과값을 조건싯ㄱ으로 사용할 반드시having절에 기술한다.
-- where  : group by절 -> having절 -> order by 절
-- 업무별 급여의 합계, 급여의 평균, 사원수를 구원하 급여의 평균이 2000불 이상인 업무만 선택하라,담당없무를 오름차순으로 정렬한다.
select job, SUM(sal), avg(sal) , count(empno) from emp group by job having sum(sal)>=5000 order by job asc;
       
select  job, SUM(sal) FROM emp WHERE job NOT IN ('SALESMAN')
	    GROUP BY job HAVING SUM(sal)>=5000  ORDER BY SUM(sal) DESC;
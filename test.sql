show databases;
use study_db;
show tables;
select * from book_tbl; 

-- 보기1] 의 테이블을 참조하여 고유번호, 책제목, 가격, 작가명, 출판일을 선택하는 쿼리문을 DML문을 작성하라.

INSERT INTO publisher_tbl(pub_code)
VALUES(4567);

select isbn, book_name, price, author, pub_day from book_tbl;
insert into book_tbl values(1234, 4567, '개미', 25000, '베르나르베르베르', '1999-12-12');

--  [보기1] book_tbl테이블을 참조하여 고유번호가 1234인 레코드가 가격을 30000, 책제목을 '개미2'로 변경하는 명령문을 작성하라.
update book_tbl set price = 30000 and book_name = '개미2' where isbn = 1234;

-- [보기1] book_tbl테이블을 참조하여 고유번호가 1234이면서 책제목이 '개미2'인 레코드를 삭제하는 쿼리문을 작성하라.
delete from book_tbl where isbn = 1234 and book_name = '개미2';

delete from emp_copy where empno in(1111,3333) ;

select * from emp;
--  EMP테이블에서 그룹함수를 이용하여 담당업무별 급여의 합계와 평균을 구하는 쿼리문을 작성하라.
show databases;
use study_db;
show tables;
select job 직업, sum(sal) 합계, avg(sal) 평균 from emp group by job;

-- EMP테이블에서 'CLARK'사원의 급여보다 많이 받는 사원의 사원명(ENAME), 급여(SAL), 담당업무(JOB)을 조회하는 서브쿼리문을 작성하라.
 
 select ename, sal, job from emp  where sal > (select sal from emp where ename = 'clark');

-- [보기1] 의 테이블을 이용하여 책이름, 작가, 가격, 출판사명, 대표자, 연락처를 선택하는 조인문을 작성하라.
show databases;
use study_db;
show tables;
select book_name, author, price, pub_name, orner, tel 
from book_tbl e join publisher_tbl p
on e.pub_code = p.pub_code;


show databases;
use study_db;
show tables;
desc book_tbl;
 select @autocommit;
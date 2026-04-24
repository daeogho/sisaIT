-- 제약조건 : 필드의 데이터를 유효한 데이터로 보관되도록 설정한다.

show databases;
use information_schema;
show tables;
select * from table_constraints where table_name = 'dept';

use study_db;
insert into dept values(50, '홍보부', '관악구');
select * from dept;
-- dept테이블명에 부서명을 unique제약조건 설정
alter table dept add constraint dept_dname_uk unique(dname);
insert into dept values(60, 'SALESMAN', '서초구');

select * from information_schema.table_constraints where table_name = 'dept';

show databases;
use information_schema;
show tables;

select * from table_constraints where table_name = 'dept';

alter table study_db.dept drop constraint dept_dname_uk;

use study_db;

desc emp;  -- 9999.99
insert into emp(empno, ename, sal) values(7777, '홍길동', 9999);
select * from emp;

update emp set sal=4500 where empno=7777;

 -- check 제약조건 : 범위값을 제약조건으로 설정하기
 alter table emp add constraint emp_sal_ck check(sal>=100 and sal<=7000);
 
 select * from information_schema.table_constraints where table_name = 'emp';
 
 insert into emp (empno, ename, sal) values(8888,'이순신',8000);
 update emp set sal = 6000 where empno= 8888;
 
 select * from dept;
 set sql_safe_updates =0;
 -- dept 테이블의 deptno는 10,20,30,40,50,60,70,80,90만 생설할 수 있도록 제약조건을 설정한다.
 alter table dept add constraint dept_deptno_ck check (deptno in (10,20,30,40,50,60,70,80,90));
 
 insert into dept values(40, '인사부', '종로구');
 insert into dept values(45, '총괄부', '강서구');
 
 select*from emp;
select*from dept order by deptno asc;
update dept set deptno=70 where dname ='홍보부';
delete from dept where dname='인사부';

desc dept;

-- primary key
alter table dept add constraint dept_deptno_pk primary key (deptno);

select * from information_schema.table_constraints where table_name in ('emp', 'dept');
 
 -- 외래키 : 다른 테이블의 데이터를 참조하여 제약조건 설정하기
 -- 		emp 테이블의 deptno가 dept테이블의 deptno를 참조하도록 제약조건을 설정하라.
 alter table emp
 add constraint emp_deptno_dept_fk
 foreign key (deptno) references dept(deptno);

-- on delete cascade : 참조되는 데이터가 삭제 되면 참조하는 레코드도 지워진다.
alter table emp
 add constraint emp_deptno_dept_fk
 foreign key (deptno) references dept(deptno) on delete cascade;
 
 select * from dept;
 insert into emp(empno, ename, deptno) values(5555,'AAAA', 70);
 
 select * from emp;
 select * from dept;
 
 delete from dept where deptno = 70;
 
 alter table emp drop constraint emp_deptno_dept_fk; -- 제약조건 삭제
 alter table emp drop foreign key emp_deptno_dept_fk; 
 
 show tables;
 
 select * from buytbl;
 select * from prodtbl;
 select * from usertbl;
 
 -- buytbl에서 상품명, 회원아이디를 참조하도록 외래키 설정
 desc usertbl;
 desc prodtbl;
 desc buytbl;
 
 alter table buytbl
 add constraint buytbl_userid_usertbl_fk
 foreign key (userid) references usertbl(userid);
 
 alter table buytbl
 add constraint buytbl_productname_prodtbl_fk
 foreign key (productname) references prodtbl (productname);
 
 select * from information_schema.table_constraints where table_name in ('buytbl','usertbl','prodtbl');
 
 desc usertbl;
 desc prodtbl;
 desc buytbl;
 
 insert into buytbl(userid, productname, groupname, price, amount) values('goguma', '노트북', '전자', 2500, 1);
 select * from buytbl;
 insert into usertbl(userid, username, birth, local) values('goguma','고구마','2000', '송파구');
 select * from usertbl;
 insert into prodtbl values('노트북', 2500, '2025-09-10', 'LG', 5);
 select * from prodtbl;
 
 -- 데이터 베이스
 create database yes24;
 
 show databases;
 
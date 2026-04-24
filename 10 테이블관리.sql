use study_db;
show tables;

desc emp_copy;
select * from emp_copy;
-- add : 필드 추가하기
alter table emp_copy add email varchar(50);

select * from emp_copy2;
alter table emp_copy2 add tel varchar(15) not null;
alter table emp_copy2 add email varchar(30);
alter table emp_copy2 add price int;
alter table emp_copy2 add price2 int not null;

desc emp_copy2;
select * from emp_copy2;
-- modify : 컬럼타입, 컬럼크기, not null 수정할 수 있다.
alter table emp_copy2 modify ename varchar(30) not null;
alter table emp_copy2 modify email varchar(30) not null;

-- change : 컬럼명, 데이터타입
alter table emp_copy2 change sal salary decimal(9,1);

-- rename column : 컬럼명 변경
alter table emp_copy2 rename column tel to handphone;

-- drop column : 필드삭제
alter table emp_copy2 drop column price2;
drop table emp_copy;

show tables;
desc emp;
select * from emp;
drop table emp_copy2, emp_copy3, emp_copy4, emp_copy8;
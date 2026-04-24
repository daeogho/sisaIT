use study_db;

-- create table : 테이블 생성
create table member (
-- 필드명, 데이터타입, 제약조건
-- primary key 제약 조건 : 중복데이터 허용하지 않는다.
	m_no int not null primary key auto_increment,
	name varchar(5) not null,
    tel varchar(15) not null, 
    email varchar(50), 
    gender varchar(2) not null,
    birthdate date null,
    writedate datetime default now()
);

show tables;
desc member;

select * from member;
insert into member(name, tel, email, gender, birthdate)
values('홍길동','010-7878-8989','hong@nate.com','M','1900-10-10');
insert into member(name, tel, gender)
values('이순신', '010-7474-1212', 'M');

create table PRODTBL(
	productname varchar(10) primary key,
	price int,
	opendate datetime,
	company varchar(20),
	stock int default 0
);

show tables;
desc usertbl;





-- 트랜잭션alter


-- 현재 트랙잭션alter
-- 1: autocomit 0 : 자동커밋안함
select @@autocommit;

-- 자동커밋 변경
set autocommit = 0;

use study_db;
show tables;

select * from member;

-- savepoint
-- 1. 레코드추가
insert into member(name, tel, gender) values('AAA', '010-7777-7777', '여');

savepoint a;

-- 2. 레코드 수정
update member set birthdate = '1999-09-09' where m_no=2;
savepoint b;
insert into member(name, tel, gender) values('BBB', '010-8888-8888', '여');
rollback to savepoint a;

commit;
select * from member;
desc member;


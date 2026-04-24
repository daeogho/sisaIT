-- ascii() : 문자의 아스키코드 구하기
-- char() : 코드값으 문자로 구하기
select ascii('A'), char(66);
-- bit_length() : bit크기, char _ length() : 문자수, length() : byte수
select bit_length('abc'), char_length('abc'), length('abc');
select bit_length('대한민국'), char_length('대한민국'), length('대한민국');

-- concat() : 문자 연결
-- concat+ws() : 문자열연결시 구분기호 설정
select concat('서울시', '강남구', '강남동'), concat_ws('/', '서울시', '영등포구', '여의도동',123);

use study_db;
select  concat(ename, '님') 사원명, sal+100 from emp;

-- 문자열 위치 찾기
select elt(2, 'S', 'T', 'U', 'M'), field('S', 'T', 'E', 'S', 'T'),
find_in_set('P', 'S,A,M,P,L,E'), instr('APPLE', 'P'), locate('p', 'APPLE');

-- insert() : 특정위치의 문자를 다른 문자로 바꾸기
select empno, ename, insert(ename,2 ,2, '**'), hiredate from emp;
-- reverse() : 문자열을 거꾸로 만든다.
select ename, reverse(ename) from emp;

-- left(), right() : 원하는 수만큼 문자열 얻어오기
select ename, left(ename, 3), right(ename, 3) from emp;

-- LCASE() : 대문자를 소문자로, UCASE() : 소문자를 대문자로
select ename, LCASE(ename) from emp;
select ucase('sql test');

-- LPAD() : 왼쪽에 특정문자 채우기
-- RPAD() : 오른쪽 특정문자 채우기
select ename, LPAD(ename, 10, '-'), RPAD(ename, 10, '*') from emp;

-- substring() : 원하는 문자 구하기
select ename, substring(ename, 2, 3) from emp;

-- substring_index(문자열, 구분자, 횟수) : 원하는 문자 구하기
select job, substring_index(job, 'A', 2), substring_index(job, 'A', -2) from emp;

-- [문제]이름을 글자길이의 50%만큼 출력하고 나머지 문자는 ‘*’으로 표시하여라
select ename, rpad(substring(ename, 1, ceil(char_length(ename)/2)), char_length(ename), '*') from emp;

-- repeat() : 문자열 반복처리한다.
select ename, repeat(ename, 2) from emp;

-- replace() : 특정문자를 다른 문자로 치환
select ename, replace(ename, 'A', '에이') from emp;

-- ltrim(), rtrim(), trim() :  양쪽의 공백을 제거, 특정문자 제거
select ltrim('        TEST'), concat(rtrim('TEST            '), 'AAA'),
trim('         TEST           ');
select trim(both 'a' from 'aaaaabaabaaaaa');

-- [문제] 이메일을 이용하여 아이디와 도메인을 분리하여라.
show tables;
select substring('daeho@naver.com', 1, instr('daeho@naver.com','@')-1) 아이디,
substring_index('daeho@naver.com', '@', -1) 도메인;
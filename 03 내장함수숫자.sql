-- 내장함수
-- abs() : 절대값
select abs(-200) 절대값;
select abs(sal) 절대값 from emp;
-- ceil() : 올림
select ceil(12.2), ceiling(12.1), ceil(-9.2);
-- mod(), %, MOD : 나머지
select mod(15,4), 15%4, 15 mod 4;
-- floor() : 버림
select floor(23.56), floor(-5.3);
-- rand() : 0~1사이의 난수
--          5~15사이의 난수 : rand()*11
select rand(), floor(rand()*11)+5;
-- pow() : 5의 3승
-- sqrt() : 루트
select pow(5,3), sqrt(20);
-- round() : 반올림 round(n, m)
select round(12.563), round(12.233), round(12.568,1), -- (0,~) ~자리에서 반올림
round(425.865, -1), round(425.865, -2);
-- truncate() : 반내림
select truncate(7.56988, 2), truncate(45325.465, -2);
-- format() : 원하는 자리까지 표시, 반올림+1000단위로, 표시
select format(4369.56556, 2), round(4369.56556, 2);

select bin(31), hex(31), oct(31);
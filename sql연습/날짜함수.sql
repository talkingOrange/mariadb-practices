--
-- 날짜 함수
--

-- 날짜만 : curdate(), current_date 
select curdate(), current_date() from dual;

-- 날짜와 시간 : now () vs sysdate()
-- now : 게시판 작성 시간 >> 자바로 하지 말고, DB에서 해야한다. 쿼리 시작 시간
-- sysdate : 호출 시간  
select now(), sysdate() from dual;
select now(), sleep(2), now() from dual; -- sleep 해도 같은 시간이 찍힘
select now(), sleep(2), sysdate() from dual; -- sleep 이후에 2초가 늘어 있다.

-- date_format
-- 2023년 8월 30일 11시 37분 57초
select date_format(now(), '%Y년 %m월 %d일 %h시 %i분 %s초') from dual;

-- period_diff >>  P1과 P2사이 달의 숫자를 반환하는 함수
-- formatting: yymm, YYYYmm
-- 예) 근무 개월(2023년 기준)
select first_name, 
hire_date, 
abs(period_diff(date_format(hire_date, '%y%m'), date_format(curdate(), '%y%m')) ) as month
from employees;

-- date_add(adddate), date_sub(=subdate)
-- 날짜를 date 타입의 컬럼이나 값에 type(year, month, day)의 표현식으로 더하거나 빼기
-- 예) 각 사원의 근속 년 수가 5년이 되는 날에 휴가를 보내준다면 각 사원들의 근속 휴가 날짜는?

select first_name, hire_date, date_add(hire_date, interval 5 year)
from employees;

-- cast (형 변환)
select '12345' + 10, cast('12345' as int) + 10 from dual; -- 결과: 12355, 12355
select date_format(cast('2023-08-30' as date), '%Y년 %m 월 %d일') from dual; -- cast 안 씌워도 됨.
select cast(1-2 as unsigned) from dual; -- 결과: 184467....
select cast(cast(1-2 as unsigned) as signed) from dual; -- 결과: -1 / signed는 int와 integer와 같음.

-- type
-- 문자: varchar, char(전화번호같은 것), text(양이 많을 때), CLOB(사이즈에 전혀 상관없는...)
-- 정수: tiny, medium, int(signed, integer), unsigned, big int
-- 실수: float, double
-- 시간: date, datetime
-- LOB: CLOB(Character Large Object), BLOB(Binary Large Object_이미지)





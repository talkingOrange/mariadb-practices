--
-- 문자열 함수
--


-- upper
select upper('seoul'), ucase('SeOuL') from dual;
select upper(first_name) from employees;

-- lower
select lower('SEOUL'), lcase('SeOuL') from dual;
select lower(first_name) from employees;

-- substring(문자열, index, length) >> index가 1부터 시작함. 
select substring('Hello World', 3, 2) from dual;

 -- 예1: like 검색: employees 테이블에서 1989년에 입사한 직원들의 이름, 입사일을 출력
  select first_name, hire_date
  from employees
  where substring(hire_date, 1, 4) = '1989';
  
  -- lpad, rpad: 정렬함수
  select lpad('1234', 10, '-') from dual; -- 결과 : ------1234
  select lpad('1234', 10, ' ') from dual; -- 결과 :       1234
  
  select rpad('1234', 10, '-') from dual; -- 결과 : 1234------
  select lpad('1234', 10, ' ') from dual; -- 결과 : 1234
  
  -- 예) 직원들의 월급을 오르쪽 정렬
  select lpad(salary, 10, ' ')
  from salaries;
  
  -- trim, ltrim, rtrim
  select 
    concat('---', ltrim('   hello   '), '---'), -- 결과: ---hello   ---
    concat('---', rtrim('   hello   '), '---'), -- 결과: ---   hello---
    concat('---', trim(leading ' ' from '   hello   '), '---'), -- 결과: ---hello   ---
    concat('---', trim(trailing ' ' from '   hello   '), '---'), -- 결과: ---   hello---
    concat('---', trim(both ' ' from '   hello   '), '---') -- 결과: ---hello---
  from dual;

-- length
select length('Hello World') from dual;


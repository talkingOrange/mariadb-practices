select * from employees;

select * from salaries where emp_no='10002';


--
-- SELECT 연습 
--

-- 예1: DEPERTMENTS 테이블의 모든 데이터를 출력 ( LIMIT : 1000) 
SELECT * FROM departments;

-- 프로젝션 (성능에도 영향이 있음; projection)
-- 예2: employyes 테이블에서 직원 이름, 성별, 입사일을 출력
SELECT first_name as '이름', gender  as '성' , hire_date as '입사일' FROM employees;

-- distinct 
-- 예3: titles 테이블에서 모든 직급을 출력하라.
SELECT distinct title from titles;
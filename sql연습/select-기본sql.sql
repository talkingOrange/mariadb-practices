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
-- limit는 상단에 limit to 10rows를 통해 자동으로 붙어서 생략이 가능하다. 대신 붙이면, 시작과 끝 index 설정 가능.
SELECT distinct title from titles limit 0, 10;

-- 예4: titles 테이블에서 모든 직급은 어떤 것들이 있는지 직급이름을 한 번씩만 출력하세요.
select distinct title from titles;

--
-- where 절
--

-- 예제1: 비교연산자: emplyees 테이블에서 1991년 이전에 입사한 직원의 이름, 
--                성별, 입사일을 출력 
select first_name, gender, hire_date
  from employees
  where hire_date < '1991-01-01'
  order by hire_date desc;
  
-- 예제2: 논리연산자: employees 테이블에서 1989년 입사한 여직원의 이름, 성별, 입사일을 출력하세요
  select first_name, gender, hire_date
  from employees
  where hire_date < '1991-01-01' and gender ='f'
  order by hire_date desc;
  
  -- 예제3: in 연산자: dept_emp 테이블에서 부서 번호가 d005이거나 d009에 속한 사원의 사번, 부서 번호를 출력
    select emp_no, dept_no
  from dept_emp
  where dept_no = 'd005' and dept_no ='d009';
  
  -- or
  select emp_no, dept_no
  from dept_emp
  where dept_no in ('d005' , 'd009');
  
  -- 예제4: like 검색: employees 테이블에서 1989년에 입사한 직원들의 이름, 입사일을 출력
  select first_name, hire_date
  from employees
  where hire_date >= '1989-01-01'
  and hire_date <= '1989-12-31';
  
  -- or
  select first_name, hire_date
  from employees
  where hire_date like '1989%';
  
  -- or
  select first_name, hire_date
  from employees
  where hire_date between '1989-01-01'
  and '1989-12-31';
  
  
  --
  -- order by
  --
  -- 예1: employyes 테이블에서 직원 이름, 성별, 입사일을 빠른 순으로 출력
  select concat(first_name, ' ', last_name) as 'full name', gender, hire_date
  from employees
  order by hire_date asc;
  
  -- 예2: salaries 테이블에서 2001년 월급이 가장 높은 순으로 사번월급을 출력
  select emp_no, salary, from_date, to_date
  from salaries
  where to_date like '2001%'
  or from_date like '2001%'
  order by salary desc;
  
  -- 직급은?
  select * from titles where emp_no = 43624;
  
  -- 예3: 남자 직원의 이름, 성별, 입사일을 선임순으로 출력
  select first_name, gender, hire_date
  from employees
  where gender ='m'
  order by hire_date asc;
  
  -- 예4: 직원들의 사번, 월급을 사번 순으로 출력하되 같은 직원의 월급이 높은 순도 반영
  select emp_no, salary
  from salaries
  order by emp_no asc, salary desc;
  
  
  
  
  
-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
 select count(b.salary < (select avg(salary) from salaries where to_date='9999-01-01'))
 from employees a, salaries b
 where a.emp_no=b.emp_no
 and b.to_date = '9999-01-01';	

-- 문제2. (생략)
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select a.first_name, b.dept_no, c.dept_name, d.salary
 from employees a, dept_emp b, departments c, salaries d
 where a.emp_no = b.emp_no
 and b.dept_no = c.dept_no
 and a.emp_no = d.emp_no
 and b.to_date = '9999-01-01'
 and d.to_date = '9999-01-01'
 and(b.dept_no, d.salary) in ( select a.dept_no, max(b.salary)
 from dept_emp a, salaries b
 where a.emp_no = b.emp_no
 and a.to_date = '9999-01-01'
 and b.to_date ='9999-01-01'
 group by a.dept_no)
 order by d.salary;

-- 문제3. (평균연봉을 구하기. from절에서 join..)
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
 select a.emp_no, a.first_name, b.salary
 from employees a, salaries b
 where a.emp_no=b.emp_no
 and b.to_date =  '9999-01-01'
 and b.salary > (select avg(salary) from salaries where to_date='9999-01-01')
 order by b.salary desc;


-- 문제4. (join문제 중요함. 현재 조건 있음) >> 다시풀ㄹ기
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select a.emp_no, a.first_name, e.first_name AS manager_name, d.dept_name
FROM employees a
JOIN dept_emp b ON a.emp_no = b.emp_no AND b.to_date = '9999-01-01'
LEFT JOIN dept_manager c ON b.dept_no = c.dept_no AND c.to_date = '9999-01-01'
LEFT JOIN employees e ON c.emp_no = e.emp_no
JOIN departments d ON b.dept_no = d.dept_no;


-- 문제5. 
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
  select a.title , avg(b.salary) as avg_salary
 from titles a, salaries b
 where a.emp_no=b.emp_no
 and b.to_date =  '9999-01-01'
 and a.to_date = '9999-01-01'
 group by a.title
 having avg_salary = (select min(avg_salary)
	from ( select avg(b.salary) as avg_salary
	from titles a, salaries b
	where a.emp_no=b.emp_no
	and b.to_date =  '9999-01-01'
	and a.to_date = '9999-01-01'
	group by a.title) a);
 


-- 문제6. (equal)
-- 평균 연봉이 가장 높은 부서는? 
SELECT 
    d.dept_name, ROUND(AVG(b.salary)) AS avg_salary
FROM
    employees a,
    salaries b,
    dept_emp c,
    departments d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND c.dept_no = d.dept_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
GROUP BY c.dept_no
HAVING avg_salary = (SELECT 
        MAX(avg_salary)
    FROM
        (SELECT 
            ROUND(AVG(b.salary)) AS avg_salary
        FROM
            employees a, salaries b, dept_emp c
        WHERE
            a.emp_no = b.emp_no
                AND a.emp_no = c.emp_no
                AND b.to_date = '9999-01-01'
                AND c.to_date = '9999-01-01'
        GROUP BY c.dept_no) a);

-- 문제7. (equal)
-- 평균 연봉이 가장 높은 직책?
SELECT 
    c.title, ROUND(AVG(b.salary)) AS avg_salary
FROM
    employees a,
    salaries b,
    titles c
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
GROUP BY c.title
HAVING avg_salary = (SELECT 
        MAX(avg_salary)
    FROM
        (SELECT 
            ROUND(AVG(b.salary)) AS avg_salary
        FROM
            employees a, salaries b, titles c
        WHERE
            a.emp_no = b.emp_no
                AND a.emp_no = c.emp_no
                AND b.to_date = '9999-01-01'
                AND c.to_date = '9999-01-01'
        GROUP BY c.title) a);

-- 문제8. (순수 조인문제)
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
 SELECT 
    f.dept_name AS '부서이름',
    a.first_name AS '사원이름',
    d.salary AS '연봉',
    g.first_name AS '매니저 이름',
    e.salary AS '매니저 연봉'
FROM
    employees a,
    dept_emp b,
    dept_manager c,
    salaries d,
    salaries e,
    departments f,
    employees g
WHERE
    a.emp_no = b.emp_no
        AND c.dept_no = b.dept_no
        AND a.emp_no = d.emp_no
        AND c.emp_no = e.emp_no
        AND c.dept_no = f.dept_no
        AND c.emp_no = g.emp_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND e.to_date = '9999-01-01'
        AND d.salary > e.salary;

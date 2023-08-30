--
-- 수학 함수
--


-- abs 절대값
select abs(1), abs(-1) from dual;

-- floor
select floor(3.14), floor(3.9999) from dual; -- 결과 : 3, 3

-- ceil
select ceil(3.14), ceil(3.9999) from dual; -- 결과 : 4, 4

-- mod
select mod(10, 3) from dual; -- 결과: 1

-- round(x) : x에 가장 가까운 정수
-- round(x, d) : x값 중에 d 자리에 가장 근접한 실수
select round(1.498), round(1.498,1)  from dual; -- 결과: 1, 1.5

-- power(x, y) : x의 y승
select power(2,10), pow(2,10) from dual; -- 결과: 1024, 1024

-- sign(x): 양수 1, 음수 -1, 0 1
select sign(20), sign(-100), sign(0) from dual; -- 결과: 1, -1, 0

-- greatest(x, y, ...) 최대값, least(x,y, ...) 최소값
select greatest(10,40,20,50,30), least(10,  40,30, 50, 40) from dual; -- 결과: 50, 1
select greatest('A', 'C', 'X', 'O', 'N' ), least('hello', 'hela', 'hell') from dual; -- 결과: X, hela




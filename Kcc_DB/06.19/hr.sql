select * from employees;
select employee_id, last_name, salary from employees;

select employee_id as 사원번호, last_name as 사원이름 from employees;

select DISTINCT job_id from employees;

select employee_id, last_name, hire_date 
from employees
where hire_date >= '03/01/01' and last_name = 'King';

select employee_id, last_name, salary
from employees
where salary >= 5000 and salary <= 10000;

select employee_id, last_name, salary
from employees
where salary BETWEEN 5000 and 10000;

select employee_id, last_name, job_id
from employees
where job_id = 'FI_MGR' OR job_id = 'FI_ACCOUNT';

select employee_id, last_name, job_id
from employees
where job_id in ('FI_MGR', 'FI_ACCOUNT');

select employee_id, last_name, commission_pct
from employees
where commission_pct is not null;

-- 07년도 입사한 사원의 목록을 출력하라
select employee_id, last_name, hire_date
from employees
where hire_date between '07/01/01' and '07/12/31';

select employee_id, last_name, hire_date
from employees
where hire_date like '07/%';

-- last_name 컬럼에 'a'가 없는 사원을 출력하라.
select * from employees where last_name not like '%a%';

-- 집합연산자를 이용하여 emp테이블의 내용 중 10번 부서번호의 사원들은 제외한 내용을 출력하라.
select * from employees
MINUS
select * from employees where department_id = 10;

SELECT department_id, avg(salary)
FROM employees
GROUP BY department_id;

-- 부서별로 사원의 수와 커미션을 받는 사원의 수를 부서별로 오름차순으로 출력하라.
select * from employees;

select department_id, count(employee_id), count(commission_pct)
from employees
group by department_id
order by department_id;

-- 부서별 급여 평균이 5000 미만의 부서의 부서번호와 평균급여를 출력하라.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) < 5000;


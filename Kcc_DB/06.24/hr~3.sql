-- ‘Chen’ 사원 보다 salary를 많이 받는 사원 목록을 출력하라.
SELECT
    LAST_NAME,
    SALARY
FROM
    EMPLOYEES
WHERE
    SALARY > (
        SELECT
            SALARY
        FROM
            EMPLOYEES
        WHERE
            LAST_NAME = 'Chen'
    );
    
-- 직무(job_id)별 최대 급여자의 사원내용을 출력하라. (다중 컬럼)
SELECT
    EMPLOYEE_ID,
    LAST_NAME,
    SALARY,
    JOB_ID
FROM
    EMPLOYEES
WHERE
    ( SALARY, JOB_ID ) IN (
        SELECT
            MAX(SALARY), JOB_ID
        FROM
            EMPLOYEES
        GROUP BY
            JOB_ID
    );

-- FROM절 서브쿼리
SELECT
    ROWNUM,
    ALIAS.*
FROM
    (
        SELECT
            EMPLOYEE_ID,
            LAST_NAME,
            HIRE_DATE
        FROM
            EMPLOYEES
        ORDER BY
            HIRE_DATE
    ) ALIAS
WHERE
    ROWNUM <= 5;
    
-- 급여를 많이 받는 사원 3명을 출력하여라.
SELECT
    *
FROM
    (
        SELECT
            *
        FROM
            EMPLOYEES
        ORDER BY
            SALARY DESC
    ) 
WHERE
    ROWNUM <= 3;
    
-- ‘Patel’가 속해있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 출력하라.
select employee_id, last_name, hire_date, salary
from employees
where department_id = (select department_id from employees where last_name = 'Patel');

-- ‘Austin'의 직무(job)와 같은 사람의 이름, 부서명, 급여, 직무를 출력하라.
select last_name, department_name, salary, job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id
and e.job_id = j.job_id
and e.job_id = (select job_id from employees where last_name = 'Austin');

-- 'Seo'의 급여와 같은 사원의 사원번호, 이름, 급여를 출력하라.
select employee_id, last_name, salary
from employees
where last_name != 'Seo'
and salary = (select salary from employees where last_name = 'Seo');

-- 급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호, 이름, 급여를 출력하라.
select employee_id, last_name, salary
from employees
where salary > (select max(salary) from employees where department_id = 30);

-- 급여가 30번 부서의 최저 급여보다 높은 사원의 사원번호, 이름, 급여를 출력하라.
select employee_id, last_name, salary
from employees
where salary > (select min(salary) from employees where department_id = 30);

-- 전체 사원의 평균 임금보다 많은 사원의 사원번호, 이름, 부서명, 입사일, 지역(city), 급여를 출력하라.
select employee_id, last_name, department_name, hire_date, city
from employees e, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and salary > (select avg(salary) from employees);

-- 100번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 출력하라.
select employee_id, last_name, department_name, hire_date, city
from employees e, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and e.department_id = 100
and job_id not in(select job_id from employees where department_id = 30);
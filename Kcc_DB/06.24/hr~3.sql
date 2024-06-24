-- ��Chen�� ��� ���� salary�� ���� �޴� ��� ����� ����϶�.
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
    
-- ����(job_id)�� �ִ� �޿����� ��������� ����϶�. (���� �÷�)
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

-- FROM�� ��������
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
    
-- �޿��� ���� �޴� ��� 3���� ����Ͽ���.
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
    
-- ��Patel���� �����ִ� �μ��� ��� ����� �����ȣ, �̸�, �Ի���, �޿��� ����϶�.
select employee_id, last_name, hire_date, salary
from employees
where department_id = (select department_id from employees where last_name = 'Patel');

-- ��Austin'�� ����(job)�� ���� ����� �̸�, �μ���, �޿�, ������ ����϶�.
select last_name, department_name, salary, job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id
and e.job_id = j.job_id
and e.job_id = (select job_id from employees where last_name = 'Austin');

-- 'Seo'�� �޿��� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
select employee_id, last_name, salary
from employees
where last_name != 'Seo'
and salary = (select salary from employees where last_name = 'Seo');

-- �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
select employee_id, last_name, salary
from employees
where salary > (select max(salary) from employees where department_id = 30);

-- �޿��� 30�� �μ��� ���� �޿����� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.
select employee_id, last_name, salary
from employees
where salary > (select min(salary) from employees where department_id = 30);

-- ��ü ����� ��� �ӱݺ��� ���� ����� �����ȣ, �̸�, �μ���, �Ի���, ����(city), �޿��� ����϶�.
select employee_id, last_name, department_name, hire_date, city
from employees e, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and salary > (select avg(salary) from employees);

-- 100�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���, �Ի���, ������ ����϶�.
select employee_id, last_name, department_name, hire_date, city
from employees e, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and e.department_id = 100
and job_id not in(select job_id from employees where department_id = 30);
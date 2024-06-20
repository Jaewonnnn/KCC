select * from employees;
select employee_id, last_name, salary from employees;

select employee_id as �����ȣ, last_name as ����̸� from employees;

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

-- 07�⵵ �Ի��� ����� ����� ����϶�
select employee_id, last_name, hire_date
from employees
where hire_date between '07/01/01' and '07/12/31';

select employee_id, last_name, hire_date
from employees
where hire_date like '07/%';

-- last_name �÷��� 'a'�� ���� ����� ����϶�.
select * from employees where last_name not like '%a%';

-- ���տ����ڸ� �̿��Ͽ� emp���̺��� ���� �� 10�� �μ���ȣ�� ������� ������ ������ ����϶�.
select * from employees
MINUS
select * from employees where department_id = 10;

SELECT department_id, avg(salary)
FROM employees
GROUP BY department_id;

-- �μ����� ����� ���� Ŀ�̼��� �޴� ����� ���� �μ����� ������������ ����϶�.
select * from employees;

select department_id, count(employee_id), count(commission_pct)
from employees
group by department_id
order by department_id;

-- �μ��� �޿� ����� 5000 �̸��� �μ��� �μ���ȣ�� ��ձ޿��� ����϶�.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) < 5000;


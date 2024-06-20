SELECT 'DataBase', LOWER('DataBase') FROM dual;

-- ���ڿ�, �ε���(1����), ���ڰ���
SELECT SUBSTR('abcdef', 2, 3) FROM dual; -- bcd

SELECT SUBSTR('abcdef', 3) FROM dual; -- cdef

-- ����� �ټӳ��� ����϶�. ��) 10.5��
SELECT last_name "�̸�", ROUND((sysdate -hire_date) / 365, 1) || '��' "�ټӳ�" FROM employees;
-- SYSDATE �� ���� ��¥ ���� / NEXT_DAY(��¥������, ���Ϲ���) / ADD_MONTHS(��¥������, �߰��� ���� ��)
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����') FROM dual;

--TO_CHAR() �� ����, ��¥�� ���ڿ��� ��ȯ
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-dd') FROM dual;
SELECT TO_CHAR(5000000, '$999,999,999') FROM dual;

-- TO_DATE() �� ���ڿ��� ��¥�����ͷ� ��ȯ
SELECT TO_DATE('2024-06-20', 'YYYY/MM/DD') FROM dual;
SELECT TO_DATE('20240622', 'YYYY/MM/DD') FROM dual;

-- 2007�⵵�� �Ի��� ����� ����� ����϶�. TO_CHAR()���
select last_name, to_char(hire_date, 'YYYY/MM/DD') from employees where hire_date between '07/01/01' and '07/12/31';
select * from employees where to_char(hire_date, 'YYYY') = '2007';

-- NVL() �� NULL�� 0 �Ǵ� ��Ÿ ����Ʈ������ ��ȯ
SELECT employee_id, salary, NVL(commission_pct, 0) FROM employees;
-- NVL2(������, exper1, exper2) �� �����Ͱ� NULL�̸� exper2, NULL �ƴϸ� exper1
SELECT employee_id, salary, NVL2(commission_pct, 'O', 'X') FROM employees;
-- DECODE(�÷�, ����1, ���1, ����2, ���2, ����3, ���3..........) 
SELECT job_id, DECODE(job_id, 'SA_MAN', 'Sales DEPT',/ 'SH_CLERK', 'Sales Dept', 'Another') FROM employees;

SELECT job_id,
CASE job_id
WHEN 'SA_MAN' THEN 'sales Dept'
WHEN 'SH_CLERK' THEN 'Sales Dept'
ELSE 'Another2'
END "CASE"
FROM employees;

-- ���̺� ����(���� + ������)
CREATE TABLE emp01 AS SELECT * FROM employees;

-- ���̺� ����(����)
CREATE TABLE emp02 AS SELECT * FROM employees WHERE 1 = 0; -- ��ġ�ϴ� ���� �ϳ��� ���� ����

-- ���̺� ���� ����
ALTER TABLE emp02 ADD(job VARCHAR(50));

-- �÷� ����
ALTER TABLE emp02 MODIFY(job VARCHAR2(100));

-- �÷� ����
ALTER TABLE emp02 DROP COLUMN job;

-- ������ ����
DELETE FROM emp01; -- DML (Ʈ����� O)
ROLLBACK;
truncate table emp01; --> DDL(Ʈ����� X)

-- ���̺� ����
DROP TABLE emp01;

CREATE TABLE dept01 as select * from departments;

-- ������ �߰�
INSERT INTO dept01 VALUES(300, 'Developer', 100, 10);
INSERT INTO dept01(department_id, department_name) VALUES(400, 'Sales');

-- ������ ����
-- UPDATE ���̺� SET �÷���1=������, �÷���2=������ WHRER �������
update dept01 set department_name = 'IT Service' where department_id = 300;

-- employees ���̺��� �����ؼ� emp01���̺��� ���� �� salary�� 3000�̻� ����ڿ��� salary�� 10% �λ�����.
select * from employees;
create table emp01 as select * from employees;
update emp01 set salary = salary * 1.1 where salary >= 3000;
select * from emp01;

select * from dept01;
-- DELETE(������ ����)
-- DELETE FROM ���̺�� WHERE ���� ���
-- dept01 ���̺��� �μ��̸��� 'IT Service' ���� ���� �ο츦 �����ض�
delete from dept01 where department_name = 'IT Service';





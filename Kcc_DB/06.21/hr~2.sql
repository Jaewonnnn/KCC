DROP TABLE EMP01;

CREATE TABLE EMP01 (
    EMPNO  NUMBER,
    ENAME  VARCHAR(20),
    JOB    VARCHAR(20),
    DEPTNO NUMBER
);

INSERT INTO EMP01 VALUES (
    NULL,
    NULL,
    'IT',
    30
);

CREATE TABLE EMP02 (
    EMPNO  NUMBER NOT NULL,
    ENAME  VARCHAR(20) NOT NULL,
    JOB    VARCHAR(20),
    DEPTNO NUMBER
);

--insert into emp02 values(null, null, 'IT', 30); -- NOT NULL �������ǿ� ���� ���� �߻�

-- �����ȣ�� �ߺ��̱� ������ ������ ���Ἲ X
INSERT INTO EMP02 VALUES (
    100,
    'KIM',
    'IT',
    30
);

INSERT INTO EMP02 VALUES (
    100,
    'PARK',
    'IT',
    30
);

CREATE TABLE EMP03 (
    EMPNO  NUMBER UNIQUE,
    ENAME  VARCHAR(20) NOT NULL,
    JOB    VARCHAR(20),
    DEPTNO NUMBER
);

INSERT INTO EMP03 VALUES (
    100,
    'KIM',
    'IT',
    30
);
--insert into emp03 values(100, 'PARK', 'IT', 30); -- UNIQUE �������ǿ� ���� ���� �߻�

-- PRIMARY KEY(�⺻Ű) : UNIQUE + NOT NULL
CREATE TABLE EMP04 (
    EMPNO  NUMBER PRIMARY KEY,
    ENAME  VARCHAR(20) NOT NULL,
    JOB    VARCHAR(20),
    DEPTNO NUMBER
);

--insert into emp04 values(null, 'KIM', 'IT', 30); -- PRIMARY KEY�� ���� ���� �߻�
INSERT INTO EMP04 VALUES (
    100,
    'KIM',
    'IT',
    30
);

-- �������� �ʴ� �μ��̱� ������ ���Ἲ X
-- insert into emp04 values(200, 'KIM', 'IT', 3000);

-- REFERENCES (FOREIGN KEY)
CREATE TABLE EMP05 (
    EMPNO  NUMBER PRIMARY KEY,
    ENAME  VARCHAR(20) NOT NULL,
    JOB    VARCHAR(20),
    DEPTNO NUMBER
        REFERENCES DEPARTMENTS ( DEPARTMENT_ID )
);

INSERT INTO EMP05 VALUES (
    200,
    'KIM',
    'IT',
    3000
); -- REFERENCES�� ���� ���� �߻�

-- ���̺� ���� ��� -> �������� �̸��� ���
CREATE TABLE EMP06 (
    EMPNO  NUMBER,
    ENAME  VARCHAR(20) NOT NULL,
    JOB    VARCHAR(20),
    DEPTNO NUMBER,
    CONSTRAINT EMP06_EMPNO_PK PRIMARY KEY ( EMPNO ),
    CONSTRAINT EMP06_DEPTNO_FK FOREIGN KEY ( DEPTNO )
        REFERENCES DEPARTMENTS ( DEPARTMENT_ID )
);

-- ���̺� ���� ��� 
CREATE TABLE EMP07 (
    EMPNO  NUMBER,
    ENAME  VARCHAR(20),
    JOB    VARCHAR(20),
    DEPTNO NUMBER
);

ALTER TABLE EMP07 ADD CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY ( EMPNO );

ALTER TABLE EMP07
    ADD CONSTRAINT EMP07_DEPTNO_FK FOREIGN KEY ( DEPTNO )
        REFERENCES DEPARTMENTS ( DEPARTMENT_ID );

ALTER TABLE EMP07 MODIFY
    ENAME
        CONSTRAINT EMP07_ENAME_NN NOT NULL;

CREATE TABLE EMP08 (
    EMPNO  NUMBER,
    ENAME  VARCHAR(20),
    JOB    VARCHAR(20),
    DEPTNO NUMBER
);

DROP TABLE EMP08;

alter table emp08
add constraint emp08_empno_pk primary key(empno)
add constraint emp08_deptno_fk foreign key(deptno)
references departments(department_id)
modify ename constraint emp08_ename_nn not null;

-- CHECK ��������(�ǵ��� �����͸� �Է� ����)
create table emp09(
empno NUMBER,
ename VARCHAR(20),
job VARCHAR(20),
deptno NUMBER,
gender CHAR(1) CHECK(gender in('M','F'))
);

insert into emp09(gender) values('MM');

-- DEFAULT �������� (���� �Է����� ������ �⺻ �� ����)
create table emp10(
empno NUMBER,
ename VARCHAR(20),
job VARCHAR(20),
deptno NUMBER,
loc VARCHAR(20) DEFAULT('seoul')
);

insert into emp10(empno, ename, job, deptno) values(1, 'zz', 'zz', 10);

-- 2�� �̻� �ֽĺ��� ����(�⺻Ű�� �����ϴ� �÷��� ����
create table emp11(
empno NUMBER,
ename VARCHAR(20),
job VARCHAR(20),
deptno NUMBER,
loc VARCHAR(20) DEFAULT('seoul'),

constraint emp11_empno_pk primary key(empno, deptno)
);
CREATE TABLE EMP12 (
    EMPNO  NUMBER,
    ENAME  VARCHAR(20),
    JOB    VARCHAR(20),
    DEPTNO NUMBER
);

ALTER TABLE DEPT01 ADD CONSTRAINT DEPT01_DEPARTMENT_ID_PK PRIMARY KEY ( DEPARTMENT_ID );

ALTER TABLE EMP12
    ADD CONSTRAINT EMP12_DEPTNO_FK FOREIGN KEY ( DEPTNO )
        REFERENCES DEPARTMENTS ( DEPARTMENT_ID );

INSERT INTO EMP12 VALUES (
    100,
    'kim',
    'IT',
    30
);
-- emp12���� 30�� �����ϰ� �ֱ� ������ ���� �Ұ�
DELETE FROM DEPT01
WHERE
    DEPARTMENT_ID = 30;

-- �ذ��� 1) emp12 ���̺� �������� deptno = 30�� ���� ���� ���� �� ����(�������� row�� ���� ����)
DELETE FROM EMP12
WHERE
    DEPTNO = 30;

DELETE FROM DEPT01
WHERE
    DEPARTMENT_ID = 30;

-- �ذ��� 2) ���̺� ������ CASCADE�̿�
-- �μ����̺��� �����Ͱ� �����Ǹ� �ڵ����� �����Ǵ� �����͵� ����
CREATE TABLE EMP13 (
    EMPNO  NUMBER,
    ENAME  VARCHAR(20),
    JOB    VARCHAR(20),
    DEPTNO NUMBER
        REFERENCES DEPT01 ( DEPARTMENT_ID )
            ON DELETE CASCADE
);

INSERT INTO EMP13 VALUES (
    100,
    'kim',
    'IT',
    20
);

DELETE FROM dept01
WHERE
    department_id = 20;
    
-- 'King'�� �μ� �̸��� ����Ͻÿ�.
select employee_id, department_id from employees; where last_name = 'King';
SELECT
    DEPARTMENT_ID,
    DEPARTMENT_NAME
FROM
    DEPARTMENTS
WHERE
    DEPARTMENT_ID IN ( 80, 90 );

/*���� �̿� ���
1. ���� ���ϴ� �����ʹ� �����ΰ�? (�÷� ���)
2. ���ϴ� �����Ͱ� ��� ���̺� �ִ��� ã�´�.
3. ���� ���̺� �ִٸ� ������ ���̺��� ���� �÷��� ã�´�.
*/
SELECT
    E.EMPLOYEE_ID,
    E.DEPARTMENT_ID,
    D.DEPARTMENT_NAME
FROM
    EMPLOYEES   E,
    DEPARTMENTS D
WHERE
        E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND LAST_NAME = 'King';
    
-- 3�� �̻� ���̺��� �����Ͽ� ����̸�, �̸���, �μ���ȣ, �μ��̸�, ������ȣ(job_id)
-- ���� �̸�(job_title)�� ����� ����
SELECT
    E.LAST_NAME,
    E.EMAIL,
    E.DEPARTMENT_ID,
    D.DEPARTMENT_NAME,
    J.JOB_ID,
    J.JOB_TITLE
FROM
    EMPLOYEES   E,
    DEPARTMENTS D,
    JOBS        J
WHERE
        E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND E.JOB_ID = J.JOB_ID;

SELECT
    E.LAST_NAME,
    E.EMAIL,
    E.DEPARTMENT_ID,
    D.DEPARTMENT_NAME,
    J.JOB_ID,
    J.JOB_TITLE
FROM
         EMPLOYEES E
    INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
    INNER JOIN JOBS        J ON J.JOB_ID = E.JOB_ID;

-- 'Seattle'(City)�� �ٹ��ϴ� ����̸�, �μ���ȣ, ������ȣ, �����̸�, �����̸��� ����غ���
SELECT
    E.LAST_NAME,
    D.DEPARTMENT_ID,
    J.JOB_ID,
    J.JOB_TITLE,
    L.CITY
FROM
    EMPLOYEES   E,
    DEPARTMENTS D,
    JOBS        J,
    LOCATIONS   L
WHERE
        E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND E.JOB_ID = J.JOB_ID
        AND D.LOCATION_ID = L.LOCATION_ID
            AND L.CITY = 'Seattle';

SELECT
    E.LAST_NAME,
    D.DEPARTMENT_ID,
    J.JOB_ID,
    J.JOB_TITLE,
    L.CITY
FROM
         EMPLOYEES E
    INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
    INNER JOIN JOBS        J ON E.JOB_ID = J.JOB_ID
    INNER JOIN LOCATIONS   L ON D.LOCATION_ID = L.LOCATION_ID
WHERE
    L.CITY = 'Seattle';

SELECT
    A.LAST_NAME
    || '�� �Ŵ����� '
       || B.LAST_NAME
          || '�̴�.'
FROM
    EMPLOYEES A,
    EMPLOYEES B
WHERE
        A.manager_id = B.employee_ID
    AND A.LAST_NAME = 'Kochhar';

-- => 107 row
select * from employees;
 -- => 106 row
select * from employees e, departments d 
where e.department_id = d.department_id;
-- oracle join
select * from employees e, departments d
where e.department_id = d.department_id(+);
-- Ansi
select * from employees e LEFT OUTER
JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

-- 1. �̸��� 'Himuro'�� ����� �μ����� ����϶�.
select e.last_name, d.department_name 
from employees e, departments d
where e.last_name = 'Himuro'
and e.department_id = d.department_id;
-- 2. �������� 'Accountant'�� ����� �̸��� �μ����� ����϶�.

select e.last_name, d.department_name, j.job_title
from employees e, jobs j, departments d
where J.JOB_TITLE = 'Accountant'
and e.job_id = j.job_id
and e.department_id = d.department_id(+);


-- 3. Ŀ�̼��� �޴� ����� �̸��� �װ� ���� �μ��� ����϶�.
select * from employees where commission_pct is not null; -- 35 row
select e.last_name, d.department_name
from employees e left outer join departments d
on e.department_id = d.department_id
where e.commission_pct is not null;
;

-- 4. �޿��� 4000������ ����� �̸�, �޿�, �ٹ����� ����϶�.
select * from employees where salary < 4000; -- 42 row
select e.last_name, e.salary, l.city
from employees e, departments d, locations l
where e.salary < 4000
and e.department_id = d.department_id(+)
and d.location_id = l.location_id;
-- 5. 'Chen'�� ������ �μ����� �ٹ��ϴ� ����� �̸��� ����϶�.4
select * from employees where last_name = 'Chen';
select * from departments where department_id = 100;
select * from employees where department_id = 100; -- 6row

select e1.last_name 
from employees e1, employees e2
where e1.last_name = 'Chen'
and e1.department_id = e2.department_id;



-- 1. ������ ���� ���� �� ���ο� View ���� �� ���� ����
CREATE OR REPLACE VIEW IN_SEATTLE AS
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
    *
FROM
    IN_SEATTLE;
-- 2. employees ���̺��� salary�� ������ View ���� �� ���� ����(View)
CREATE OR REPLACE VIEW EXCLUDE_SALARY AS
    SELECT
        EMPLOYEE_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        PHONE_NUMBER,
        HIRE_DATE,
        JOB_ID,
        COMMISSION_PCT,
        MANAGER_ID,
        DEPARTMENT_ID
    FROM
        EMPLOYEES;

SELECT
    *
FROM
    EXCLUDE_SALARY;

set serveroutput on;

DECLARE
-- ���� ����
    V_NO       NUMBER := 10;
    V_HIREDATE VARCHAR2(30) := TO_CHAR(SYSDATE, 'YYYY/MM/DD');
-- ��� ����
    C_MESSAGE  CONSTANT VARCHAR2(50) := 'Hello PL/SQL!!!';
BEGIN
    DBMS_OUTPUT.PUT_LINE('PL/SQL ����');
    DBMS_OUTPUT.PUT_LINE(C_MESSAGE);
    DBMS_OUTPUT.PUT_LINE(V_HIREDATE);
END;

-- employees ���̺��� �ο츦 �˻��Ͽ� ������ �Ҵ��� ����.
DECLARE
    V_NAME     VARCHAR2(20);
    V_SALARY   NUMBER;
    V_HIREDATE VARCHAR2(30);
BEGIN
    SELECT
        FIRST_NAME,
        SALARY,
        TO_CHAR(SYSDATE, 'YYYY/MM/DD')
    INTO
        V_NAME,
        V_SALARY,
        V_HIREDATE
    FROM
        EMPLOYEES
    WHERE
        FIRST_NAME = 'Ellen';

    DBMS_OUTPUT.PUT_LINE(V_NAME
                         || ' '
                         || V_SALARY
                         || ' '
                         || V_HIREDATE);

END;

-- �����ȣ 100���� �ش��ϴ� ����� �̸��� �μ����� ����Ͻÿ�
DECLARE
    V_NAME            VARCHAR2(20);
    V_DEPARTMENT_NAME VARCHAR(30);
BEGIN
    SELECT
        E.LAST_NAME,
        D.DEPARTMENT_NAME
    INTO
        V_NAME,
        V_DEPARTMENT_NAME
    FROM
        EMPLOYEES   E,
        DEPARTMENTS D
    WHERE
            E.DEPARTMENT_ID = D.DEPARTMENT_ID
        AND E.EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE(V_NAME
                         || ' '
                         || V_DEPARTMENT_NAME);
END;


--------------------������ Ÿ��(�⺻��, ���۷�����)
DECLARE
-- �⺻ ��������
    V_SEARCH VARCHAR(20) := 'Lisa';
-- ���۷�����
    V_NAME   EMPLOYEES.LAST_NAME%TYPE;
    V_SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT
        LAST_NAME,
        SALARY
    INTO
        V_NAME,
        V_SALARY
    FROM
        EMPLOYEES
    WHERE
        FIRST_NAME = V_SEARCH;

    DBMS_OUTPUT.PUT_LINE(V_NAME
                         || ' '
                         || V_SALARY);
END;

-- 1. ������̺��� 201�� ����� �̸��� �̸����� ����϶�(���۷�����)
DECLARE
    V_NAME  EMPLOYEES.LAST_NAME%TYPE;
    V_EMAIL EMPLOYEES.EMAIL%TYPE;
BEGIN
    SELECT
        LAST_NAME,
        EMAIL
    INTO
        V_NAME,
        V_EMAIL
    FROM
        EMPLOYEES
    WHERE
        EMPLOYEE_ID = 201;

    DBMS_OUTPUT.PUT_LINE(V_NAME
                         || ' '
                         || V_EMAIL);
END;
-- 2. employees �� employees2 ����. ������̺��� �����ȣ�� ���� ū ����� ã�� �� �����ȣ +1������ �Ʒ��� ����� �߰��϶�
CREATE TABLE EMPLOYEES2
    AS
        SELECT
            *
        FROM
            EMPLOYEES;

DECLARE
    V_EMPLOYEE_ID EMPLOYEES2.EMPLOYEE_ID%TYPE;
BEGIN
    SELECT
        MAX(EMPLOYEE_ID)
    INTO V_EMPLOYEE_ID
    FROM
        EMPLOYEES2;

    INSERT INTO EMPLOYEES2 (
        EMPLOYEE_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        HIRE_DATE,
        JOB_ID
    ) VALUES (
        V_EMPLOYEE_ID + 1,
        'Hong',
        'gildong',
        'aa@aa.com',
        SYSDATE,
        'AD_VP'
    );

    COMMIT;
END;

---------------- ROWTYPE
SELECT
    *
FROM
    EMPLOYEES2;

DECLARE
    EMPLOYEE_RECORD   EMPLOYEES%ROWTYPE;
    V_DEPARTMENT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE;
BEGIN
    SELECT
        *
    INTO EMPLOYEE_RECORD
    FROM
        EMPLOYEES
    WHERE
        FIRST_NAME = 'Lisa';

    DBMS_OUTPUT.PUT_LINE(EMPLOYEE_RECORD.EMPLOYEE_ID
                         || ' '
                         || EMPLOYEE_RECORD.FIRST_NAME
                         || ' '
                         || EMPLOYEE_RECORD.SALARY);

END;

/*
�������ϱ� �� ROUND(DBMS_RANDOM.VALUE(10, 120),-1))
10~120 ���̿� ������ �μ���ȣ�� �޾Ƽ� �ش� �μ��� ��� �޿��� ���� ����� ��µǵ��� ����.
1~3000 : ����
3000~ 6000 : ����
6000 �̻� : ����
*/
DECLARE
    V_DEPARTMENT_NO NUMBER;
    V_AVG_SAL       EMPLOYEES.SALARY%TYPE;
BEGIN
    V_DEPARTMENT_NO := ROUND(DBMS_RANDOM.VALUE(10, 120), -1);
    SELECT
        AVG(SALARY)
    INTO V_AVG_SAL
    FROM
        EMPLOYEES
    WHERE
        DEPARTMENT_ID = V_DEPARTMENT_NO
    GROUP BY
        DEPARTMENT_ID;
-- IF���
/*IF V_AVG_SAL <= 3000 THEN
DBMS_OUTPUT.PUT_LINE('����');
ELSIF V_AVG_SAL <= 6000 THEN
DBMS_OUTPUT.PUT_LINE('����');
ELSE
DBMS_OUTPUT.PUT_LINE('����');
END IF;*/
    CASE
        WHEN V_AVG_SAL BETWEEN 1 AND 3000 THEN
            DBMS_OUTPUT.PUT_LINE('����');
        WHEN V_AVG_SAL BETWEEN 3000 AND 6000 THEN
            DBMS_OUTPUT.PUT_LINE('����');
        ELSE
            DBMS_OUTPUT.PUT_LINE('����');
    END CASE;

END;

-- �ݺ���(LOOP, WHILE, FOR)
-- LOOP
DECLARE
    I     NUMBER := 0;
    TOTAL NUMBER := 0;
BEGIN
    LOOP
        I := I + 1;
        TOTAL := TOTAL + I;
        EXIT WHEN I >= 10;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(TOTAL);
END;
-- WHILE
DECLARE
    I     NUMBER := 0;
    TOTAL NUMBER := 0;
BEGIN
    WHILE I <= 10 LOOP
        TOTAL := TOTAL + I;
        I := I + 1;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(TOTAL);
END;
-- FOR
DECLARE
    I     NUMBER := 0;
    TOTAL NUMBER := 0;
BEGIN
    FOR I IN 1..10 LOOP -- 1~10����
        TOTAL := TOTAL + I;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(TOTAL);
END;

--LOOP���� �̿��ؼ� ������ 3���� ����ض�
DECLARE
    I NUMBER := 3;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 3;
        EXIT WHEN I >= 30;
    END LOOP;
END;
-- FOR���� �̿��ؼ� ������ ��ü ���
DECLARE BEGIN
    FOR I IN 1..9 LOOP
        FOR J IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(I
                                 || ' x '
                                 || J
                                 || ' = '
                                 || I * J);
        END LOOP;
    END LOOP;
END;

-------------------����(Exception)
DECLARE
    EMPLOYEE_RECORD EMPLOYEES%ROWTYPE;
BEGIN
    SELECT
        EMPLOYEE_ID,
        LAST_NAME,
        DEPARTMENT_ID
    INTO
        EMPLOYEE_RECORD.EMPLOYEE_ID,
        EMPLOYEE_RECORD.LAST_NAME,
        EMPLOYEE_RECORD.DEPARTMENT_ID
    FROM
        EMPLOYEES
    WHERE
        DEPARTMENT_ID = 50;

EXCEPTION
-- UNIQUE ���������� ���� �÷��� �ߺ��� �����͸� INSERT�Ϸ��� �ϴ� ���
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�.');
-- ���ǹ� ��� 2�� �̻��� ROW�� ���ϵǾ �߻��ϴ� ����
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('�˻��� �ο찡 �����ϴ�.');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('�˻��� ����� �����ϴ�.');
-- ELSE
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ ����.');
END;

-- ����ڰ� ������ ���� �߻� => ���� ����
DECLARE
    E_USER_EXCEPTION EXCEPTION;
    CNT NUMBER := 0;
BEGIN
    SELECT
        COUNT(*)
    INTO CNT
    FROM
        EMPLOYEES
    WHERE
        DEPARTMENT_ID = 30;

    IF CNT < 5 THEN
        RAISE E_USER_EXCEPTION;
    END IF;
EXCEPTION
    WHEN E_USER_EXCEPTION THEN
        DBMS_OUTPUT.PUT_LINE('5�� ���� �μ� ����');
END;
-- ���Ի���� �Է½� �߸��� �μ���ȣ�� ���ؼ� ����� ����ó�� �ϼ���
DECLARE
    P_DEPARTMENT_ID NUMBER := 50;
    EX_INVALID_DEPTID EXCEPTION;
    V_CNT           NUMBER := 0;
    V_EMPLOYEE_ID   EMPLOYEES2.EMPLOYEE_ID%TYPE;
BEGIN
    SELECT
        COUNT(*)
    INTO V_CNT
    FROM
        EMPLOYEES2
    WHERE
        DEPARTMENT_ID = P_DEPARTMENT_ID;

    IF V_CNT = 0 THEN
        RAISE EX_INVALID_DEPTID;
    END IF;
    SELECT
        MAX(EMPLOYEE_ID) + 1
    INTO V_EMPLOYEE_ID
    FROM
        EMPLOYEES2;

    INSERT INTO EMPLOYEES2 (
        EMPLOYEE_ID,
        LAST_NAME,
        EMAIL,
        HIRE_DATE,
        JOB_ID,
        DEPARTMENT_ID
    ) VALUES (
        V_EMPLOYEE_ID,
        'AA',
        'AA@AA.COM',
        SYSDATE,
        'AD_VP',
        P_DEPARTMENT_ID
    );

EXCEPTION
    WHEN EX_INVALID_DEPTID THEN
        DBMS_OUTPUT.PUT_LINE('���� �μ���ȣ �Դϴ�.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ ����');
END;

SELECT
    *
FROM
    EMPLOYEES2;

--------------------Ŀ�� LOOP���
DECLARE
-- Ŀ�� ����
    CURSOR DEPARTMENT_CURSORS IS
    SELECT
        DEPARTMENT_ID,
        DEPARTMENT_NAME,
        LOCATION_ID
    FROM
        DEPARTMENTS;
-- CURSOR�� ����ϸ� �׻� ROWTYPE�� ����ؾ� �Ѵ�.
    DEPARTMENT_RECORD DEPARTMENT_CURSORS%ROWTYPE;
BEGIN
-- Ŀ�� ����
    OPEN DEPARTMENT_CURSORS;
    LOOP
        FETCH DEPARTMENT_CURSORS INTO
            DEPARTMENT_RECORD.DEPARTMENT_ID,
            DEPARTMENT_RECORD.DEPARTMENT_NAME,
            DEPARTMENT_RECORD.LOCATION_ID;
        EXIT WHEN DEPARTMENT_CURSORS%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(DEPARTMENT_RECORD.DEPARTMENT_ID
                             || ' '
                             || DEPARTMENT_RECORD.DEPARTMENT_NAME
                             || ' '
                             || DEPARTMENT_RECORD.LOCATION_ID);

    END LOOP;
--Ŀ�� �ݱ�
    CLOSE DEPARTMENT_CURSORS;
END;

--------------------Ŀ�� FOR���
DECLARE
-- Ŀ�� ����
    CURSOR DEPARTMENT_CURSORS IS
    SELECT
        DEPARTMENT_ID,
        DEPARTMENT_NAME,
        LOCATION_ID
    FROM
        DEPARTMENTS;
-- CURSOR�� ����ϸ� �׻� ROWTYPE�� ����ؾ� �Ѵ�.
    DEPARTMENT_RECORD DEPARTMENT_CURSORS%ROWTYPE;
BEGIN
    FOR DEPARTMENT_RECORD IN DEPARTMENT_CURSORS LOOP
        DBMS_OUTPUT.PUT_LINE(DEPARTMENT_RECORD.DEPARTMENT_ID
                             || ' '
                             || DEPARTMENT_RECORD.DEPARTMENT_NAME
                             || ' '
                             || DEPARTMENT_RECORD.LOCATION_ID);
    END LOOP;
END;
-- Ŀ���� �̿��Ͽ� ����� ������ ����϶�(�����ȣ, ����̸�(FIRST_NAME), �޿�, �޿�����)
DECLARE
    CURSOR EMP_CURSORS IS
    SELECT
        EMPLOYEE_ID,
        FIRST_NAME,
        SALARY
    FROM
        EMPLOYEES;

    EMPLOYEE_RECORD EMP_CURSORS%ROWTYPE;
    V_TOTAL_SALARY  NUMBER := 0;
BEGIN
    FOR EMPLOYEE_RECORD IN EMP_CURSORS LOOP
        V_TOTAL_SALARY := V_TOTAL_SALARY + EMPLOYEE_RECORD.SALARY;
        DBMS_OUTPUT.PUT_LINE(EMPLOYEE_RECORD.EMPLOYEE_ID
                             || ' '
                             || EMPLOYEE_RECORD.FIRST_NAME
                             || ' '
                             || EMPLOYEE_RECORD.SALARY
                             || ' '
                             || V_TOTAL_SALARY);       
    END LOOP;
END;
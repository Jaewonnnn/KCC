set serveroutput on;

CREATE OR REPLACE PROCEDURE LISTBYDEPTNO (
    P_DEPTNO IN EMPLOYEES.DEPARTMENT_ID%TYPE
) IS
    CURSOR EMPLOYEE_CURSORS IS
    SELECT
        *
    FROM
        EMPLOYEES
    WHERE
        DEPARTMENT_ID = P_DEPTNO;

    EMPLOYEE_RECORD EMPLOYEE_CURSORS%ROWTYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=========��� ����Ʈ=========');
    FOR EMPLOYEE_RECORD IN EMPLOYEE_CURSORS LOOP
        DBMS_OUTPUT.PUT_LINE(P_DEPTNO
                             || ' '
                             || EMPLOYEE_RECORD.EMPLOYEE_ID
                             || ' '
                             || EMPLOYEE_RECORD.LAST_NAME);
    END LOOP;

END;

-- ���ν��� ����
EXECUTE LISTBYDEPTNO(30);

--���� JOBS �� JOBS2 ����
--���ν����� �̿��Ͽ� job_id, job_title, min_salary, max_salary �Է¹޾� ���̺� ���ο� row�� �߰��� ����.
--('a', 'IT', 100, 1000)
CREATE TABLE JOBS2
    AS
        SELECT
            *
        FROM
            JOBS;

CREATE OR REPLACE PROCEDURE INSERTJOBS (
    P_JOB_ID     IN JOBS2.JOB_ID%TYPE,
    P_JOB_TITLE  IN JOBS2.JOB_TITLE%TYPE,
    P_MIN_SALARY IN JOBS2.MIN_SALARY%TYPE,
    P_MAX_SALARY IN JOBS2.MAX_SALARY%TYPE
) IS
BEGIN
    INSERT INTO JOBS2 VALUES (
        P_JOB_ID,
        P_JOB_TITLE,
        P_MIN_SALARY,
        P_MAX_SALARY
    );

    COMMIT;
END;

EXECUTE INSERTJOBS('a', 'IT', 100, 1000);

SELECT
    *
FROM
    JOBS2;
    
/*
- ���� hr> jobs2 ���̺� job_id ��������(pk) �߰�, ���ν����� �̿��Ͽ� ������ job_id�� üũ
    - NO �� insert ����
    - YES �� update ����
*/
ALTER TABLE JOBS2 ADD CONSTRAINT JOBS2_PK PRIMARY KEY ( JOB_ID );

CREATE OR REPLACE PROCEDURE IS_SAME_JOB_ID (
    P_JOB_ID     IN JOBS2.JOB_ID%TYPE,
    P_JOB_TITLE  IN JOBS2.JOB_TITLE%TYPE,
    P_MIN_SALARY IN JOBS2.MIN_SALARY%TYPE,
    P_MAX_SALARY IN JOBS2.MAX_SALARY%TYPE
) IS
    V_CNT NUMBER := 0;
BEGIN
    -- ������ JOB üũ
    SELECT
        COUNT(*)
    INTO V_CNT
    FROM
        JOBS2
    WHERE
        JOB_ID = P_JOB_ID;

    IF V_CNT = 0 THEN
        INSERT INTO JOBS2 VALUES (
            P_JOB_ID,
            P_JOB_TITLE,
            P_MIN_SALARY,
            P_MAX_SALARY
        );

    ELSE
        UPDATE JOBS2
        SET
            JOB_TITLE = P_JOB_TITLE,
            MIN_SALARY = P_MIN_SALARY,
            MAX_SALARY = P_MAX_SALARY
        WHERE
            JOB_ID = P_JOB_ID;

    END IF;

END;

EXECUTE IS_SAME_JOB_ID('aa', 'IT', 100, 1000);

-- �Ű����� ����Ʈ �� ����
CREATE OR REPLACE PROCEDURE IS_SAME_JOB_ID2 (
    P_JOB_ID     IN JOBS2.JOB_ID%TYPE,
    P_JOB_TITLE  IN JOBS2.JOB_TITLE%TYPE,
    P_MIN_SALARY IN JOBS2.MIN_SALARY%TYPE := 100,
    P_MAX_SALARY IN JOBS2.MAX_SALARY%TYPE := 1000
) IS
    V_CNT NUMBER := 0;
BEGIN
    -- ������ JOB üũ
    SELECT
        COUNT(*)
    INTO V_CNT
    FROM
        JOBS2
    WHERE
        JOB_ID = P_JOB_ID;

    IF V_CNT = 0 THEN
        INSERT INTO JOBS2 VALUES (
            P_JOB_ID,
            P_JOB_TITLE,
            P_MIN_SALARY,
            P_MAX_SALARY
        );

    ELSE
        UPDATE JOBS2
        SET
            JOB_TITLE = P_JOB_TITLE,
            MIN_SALARY = P_MIN_SALARY,
            MAX_SALARY = P_MAX_SALARY
        WHERE
            JOB_ID = P_JOB_ID;

    END IF;

END;

EXECUTE IS_SAME_JOB_ID2('c', 'c');

SELECT
    *
FROM
    JOBS2;
-- OUT, IN �Ű����� ����
CREATE OR REPLACE PROCEDURE IS_SAME_JOB_ID4 (
    P_JOB_ID     IN JOBS2.JOB_ID%TYPE,
    P_JOB_TITLE  IN JOBS2.JOB_TITLE%TYPE,
    P_MIN_SALARY IN JOBS2.MIN_SALARY%TYPE := 100,
    P_MAX_SALARY IN JOBS2.MAX_SALARY%TYPE := 1000,
    P_RESULT     OUT NUMBER
) IS
    V_CNT NUMBER := 0;
BEGIN
    -- ������ JOB üũ
    SELECT
        COUNT(*)
    INTO V_CNT
    FROM
        JOBS2
    WHERE
        JOB_ID = P_JOB_ID;

    IF V_CNT = 0 THEN
        P_RESULT := 1;
        INSERT INTO JOBS2 VALUES (
            P_JOB_ID,
            P_JOB_TITLE,
            P_MIN_SALARY,
            P_MAX_SALARY
        );

    ELSE
        P_RESULT := 2;
        UPDATE JOBS2
        SET
            JOB_TITLE = P_JOB_TITLE,
            MIN_SALARY = P_MIN_SALARY,
            MAX_SALARY = P_MAX_SALARY
        WHERE
            JOB_ID = P_JOB_ID;

    END IF;

END;

-- �ش��ϴ� ���ν��� ����
DECLARE
    P_RESULT NUMBER;
BEGIN
    IS_SAME_JOB_ID4('d', 'd1', 200, 2000, P_RESULT);
    IF P_RESULT = 1 THEN
        DBMS_OUTPUT.PUT_LINE('�߰� �Ǿ����ϴ�.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('���� �Ǿ����ϴ�.');
    END IF;

END;
-----------------�Լ�(FUNCTION)
CREATE OR REPLACE FUNCTION GETSALARY (
    P_NO EMPLOYEES.EMPLOYEE_ID%TYPE
) RETURN NUMBER IS
    V_SALARY NUMBER;
BEGIN
    SELECT
        SALARY
    INTO V_SALARY
    FROM
        EMPLOYEES
    WHERE
        EMPLOYEE_ID = P_NO;

    RETURN V_SALARY;
END;

SELECT
    GETSALARY(100)
FROM
    DUAL;

-- �����ȣ�� �Է� �޾� �̸��� ��ȯ�ϴ� �Լ��� ��������. ����� ������ �� ���ش� ��� ������ ���
CREATE OR REPLACE FUNCTION GETEMPNAME (
    P_EMPLOYEE_ID EMPLOYEES.EMPLOYEE_ID%TYPE
) RETURN EMPLOYEES.LAST_NAME%TYPE IS
    V_LAST_NAME EMPLOYEES.LAST_NAME%TYPE;
BEGIN
    SELECT
        LAST_NAME
    INTO V_LAST_NAME
    FROM
        EMPLOYEES
    WHERE
        EMPLOYEE_ID = P_EMPLOYEE_ID;

    RETURN V_LAST_NAME;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN '�ش� ��� ����';
END;

SELECT
    GETEMPNAME(100)
FROM
    DUAL;
----------------------��Ű��(Package) 
-- ��Ű�� ����
CREATE OR REPLACE PACKAGE MY_PACKAGE IS
    PROCEDURE GETEMPLOYEE (
        IN_ID      IN EMPLOYEES.EMPLOYEE_ID%TYPE,
        OUT_ID     OUT EMPLOYEES.EMPLOYEE_ID%TYPE,
        OUT_NAME   OUT EMPLOYEES.FIRST_NAME%TYPE,
        OUT_SALARY OUT EMPLOYEES.SALARY%TYPE
    );

    FUNCTION GETSALARY (
        P_NO EMPLOYEES.EMPLOYEE_ID%TYPE
    ) RETURN NUMBER;

END;
-- ��Ű�� ����
CREATE OR REPLACE PACKAGE BODY MY_PACKAGE IS

    PROCEDURE GETEMPLOYEE (
        IN_ID      IN EMPLOYEES.EMPLOYEE_ID%TYPE,
        OUT_ID     OUT EMPLOYEES.EMPLOYEE_ID%TYPE,
        OUT_NAME   OUT EMPLOYEES.FIRST_NAME%TYPE,
        OUT_SALARY OUT EMPLOYEES.SALARY%TYPE
    ) IS
    BEGIN
        SELECT
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
        INTO
            OUT_ID,
            OUT_NAME,
            OUT_SALARY
        FROM
            EMPLOYEES
        WHERE
            EMPLOYEE_ID = IN_ID;

    END; -- ���ν��� ����

    FUNCTION GETSALARY (
        P_NO EMPLOYEES.EMPLOYEE_ID%TYPE
    ) RETURN NUMBER IS
        V_SALARY NUMBER;
    BEGIN
        SELECT
            SALARY
        INTO V_SALARY
        FROM
            EMPLOYEES
        WHERE
            EMPLOYEE_ID = P_NO;

        RETURN V_SALARY;
    END; -- �Լ� ����

END; -- ��Ű�� ����

-- �Լ� ����
SELECT
    MY_PACKAGE.GETSALARY(100)
FROM
    DUAL;
-- ���ν��� ����
DECLARE
    P_ID     NUMBER;
    P_NAME   VARCHAR2(50);
    P_SALARY NUMBER;
BEGIN
    MY_PACKAGE.GETEMPLOYEE(100, P_ID, P_NAME, P_SALARY);
    DBMS_OUTPUT.PUT_LINE(P_ID
                         || ' '
                         || P_NAME
                         || ' '
                         || P_SALARY);

END;

---------------------Ʈ����(TRIGGER)
CREATE TABLE EMP14 (
    EMPNO NUMBER PRIMARY KEY,
    ENAME VARCHAR2(20),
    JOB   VARCHAR2(20)
);
-- TRIGGER ����
CREATE OR REPLACE TRIGGER TRG_01 AFTER
    INSERT ON EMP14
BEGIN
    DBMS_OUTPUT.PUT_LINE('���� ����� �߰��Ǿ����ϴ�.');
END;

INSERT INTO EMP14 VALUES (
    1,
    'ȫ�浿',
    '����'
);

CREATE TABLE SAL01 (
    SALNO NUMBER PRIMARY KEY,
    SAL   NUMBER,
    EMPNO NUMBER
        REFERENCES EMP14 ( EMPNO )
)

CREATE SEQUENCE SAL01_SALNO_SEQ;

CREATE OR REPLACE TRIGGER TRG_02 AFTER
    INSERT ON EMP14
    FOR EACH ROW
BEGIN
    INSERT INTO SAL01 VALUES (
        SAL01_SALNO_SEQ.NEXTVAL,
        4000,
        :NEW.EMPNO
    );

END;

INSERT INTO EMP14 VALUES (
    2,
    '�ڱ浿',
    '����'
);

SELECT
    *
FROM
    EMP14;

SELECT
    *
FROM
    SAL01;

-- ����� �����Ǹ� �� ����� �޿� ����(SEL01) ���̺� �ش� ROW�� �Բ� �����ǵ��� Ʈ���Ÿ� ������ ����
CREATE OR REPLACE TRIGGER TRG_03 AFTER
    DELETE ON EMP14
    FOR EACH ROW
BEGIN
    DELETE FROM SAL01
    WHERE
        EMPNO = :OLD.EMPNO;

END;

DELETE FROM EMP14
WHERE
    EMPNO = 2;

SELECT
    *
FROM
    SAL01;

-- employees2���� retire_date �÷��� �߰�����.
ALTER TABLE EMPLOYEES2 ADD (
    RETIRE_DATE DATE
);
-- �׸��� �Ʒ��� ���뿡 �´� package,  procedure ����� ����.
--��Ű�� �����
CREATE OR REPLACE PACKAGE HR_PKG IS
    --�ű� ��� �Է�
    --�űԻ�� ��� => ������(�ִ�)��� + 1
    --�űԻ�� ���
    PROCEDURE NEW_EMP_PROC (
        PS_EMP_NAME  IN VARCHAR2,
        PE_EMAIL     IN VARCHAR2,
        PJ_JOB_ID    IN VARCHAR2,
        PD_HIRE_DATE IN VARCHAR2
    );
    -- TO_DATE(pdhire_date, 'YYYY-MM-DD');

   -- ��� ��� ó��
   --����� ����� ������̺��� �������� �ʰ� �������(retire_date)�� NULL���� ����
    PROCEDURE RETIRE_EMP_PROC (
        PN_EMPLOYEE_ID IN NUMBER
    );

END HR_PKG;

CREATE OR REPLACE PACKAGE BODY HR_PKG IS

    PROCEDURE NEW_EMP_PROC (
        PS_EMP_NAME  IN VARCHAR2,
        PE_EMAIL     IN VARCHAR2,
        PJ_JOB_ID    IN VARCHAR2,
        PD_HIRE_DATE IN VARCHAR2
    ) IS
        V_NEW_EMP_ID EMPLOYEES2.EMPLOYEE_ID%TYPE;
    BEGIN
        SELECT
            NVL(MAX(EMPLOYEE_ID),0)
        INTO V_NEW_EMP_ID
        FROM
            EMPLOYEES2;

        INSERT INTO EMPLOYEES2 (
            EMPLOYEE_ID,
            LAST_NAME,
            EMAIL,
            JOB_ID,
            HIRE_DATE
        ) VALUES (
            V_NEW_EMP_ID + 1,
            PS_EMP_NAME,
            PE_EMAIL,
            PJ_JOB_ID,
            PD_HIRE_DATE
        );

        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('insert error');
            ROLLBACK;
    END;

    PROCEDURE RETIRE_EMP_PROC (
        PN_EMPLOYEE_ID IN NUMBER
    ) IS
    BEGIN
        UPDATE EMPLOYEES2
        SET
            RETIRE_DATE = SYSDATE
        WHERE
            EMPLOYEE_ID = PN_EMPLOYEE_ID;

        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(PN_EMPLOYEE_ID || '�� ������� �ƴմϴ�.');
            ROLLBACK;
    END;

END;

DECLARE BEGIN
    HR_PKG.NEW_EMP_PROC('AA', 'AA@AA.COM', '100', TO_CHAR(SYSDATE, 'YYYY-MM-DD'));
END;

DECLARE BEGIN
    HR_PKG.RETIRE_EMP_PROC(208);
END;
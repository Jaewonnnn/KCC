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
    DBMS_OUTPUT.PUT_LINE('=========사원 리스트=========');
    FOR EMPLOYEE_RECORD IN EMPLOYEE_CURSORS LOOP
        DBMS_OUTPUT.PUT_LINE(P_DEPTNO
                             || ' '
                             || EMPLOYEE_RECORD.EMPLOYEE_ID
                             || ' '
                             || EMPLOYEE_RECORD.LAST_NAME);
    END LOOP;

END;

-- 프로시저 실행
EXECUTE LISTBYDEPTNO(30);

--기존 JOBS ⇒ JOBS2 복사
--프로시저를 이용하여 job_id, job_title, min_salary, max_salary 입력받아 테이블에 새로운 row를 추가해 보자.
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
- 과제 hr> jobs2 테이블 job_id 제약조건(pk) 추가, 프로시저를 이용하여 동일한 job_id를 체크
    - NO ⇒ insert 실행
    - YES ⇒ update 실행
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
    -- 동일한 JOB 체크
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

-- 매개변수 디폴트 값 설정
CREATE OR REPLACE PROCEDURE IS_SAME_JOB_ID2 (
    P_JOB_ID     IN JOBS2.JOB_ID%TYPE,
    P_JOB_TITLE  IN JOBS2.JOB_TITLE%TYPE,
    P_MIN_SALARY IN JOBS2.MIN_SALARY%TYPE := 100,
    P_MAX_SALARY IN JOBS2.MAX_SALARY%TYPE := 1000
) IS
    V_CNT NUMBER := 0;
BEGIN
    -- 동일한 JOB 체크
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
-- OUT, IN 매개변수 설정
CREATE OR REPLACE PROCEDURE IS_SAME_JOB_ID4 (
    P_JOB_ID     IN JOBS2.JOB_ID%TYPE,
    P_JOB_TITLE  IN JOBS2.JOB_TITLE%TYPE,
    P_MIN_SALARY IN JOBS2.MIN_SALARY%TYPE := 100,
    P_MAX_SALARY IN JOBS2.MAX_SALARY%TYPE := 1000,
    P_RESULT     OUT NUMBER
) IS
    V_CNT NUMBER := 0;
BEGIN
    -- 동일한 JOB 체크
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

-- 해당하는 프로시저 실행
DECLARE
    P_RESULT NUMBER;
BEGIN
    IS_SAME_JOB_ID4('d', 'd1', 200, 2000, P_RESULT);
    IF P_RESULT = 1 THEN
        DBMS_OUTPUT.PUT_LINE('추가 되었습니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('수정 되었습니다.');
    END IF;

END;
-----------------함수(FUNCTION)
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

-- 사원번호를 입력 받아 이름을 반환하는 함수를 구현하자. 사원이 없으면 ⇒ ‘해당 사원 없음’ 출력
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
        RETURN '해당 사원 없음';
END;

SELECT
    GETEMPNAME(100)
FROM
    DUAL;
----------------------패키지(Package) 
-- 패키지 선언
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
-- 패키지 본문
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

    END; -- 프로시저 종료

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
    END; -- 함수 종료

END; -- 패키지 종료

-- 함수 실행
SELECT
    MY_PACKAGE.GETSALARY(100)
FROM
    DUAL;
-- 프로시저 실행
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

---------------------트리거(TRIGGER)
CREATE TABLE EMP14 (
    EMPNO NUMBER PRIMARY KEY,
    ENAME VARCHAR2(20),
    JOB   VARCHAR2(20)
);
-- TRIGGER 생성
CREATE OR REPLACE TRIGGER TRG_01 AFTER
    INSERT ON EMP14
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입 사원이 추가되었습니다.');
END;

INSERT INTO EMP14 VALUES (
    1,
    '홍길동',
    '개발'
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
    '박길동',
    '개발'
);

SELECT
    *
FROM
    EMP14;

SELECT
    *
FROM
    SAL01;

-- 사원이 삭제되면 그 사원의 급여 정보(SEL01) 테이블에 해당 ROW도 함께 삭제되도록 트리거를 구현해 보자
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

-- employees2에서 retire_date 컬럼을 추가하자.
ALTER TABLE EMPLOYEES2 ADD (
    RETIRE_DATE DATE
);
-- 그리고 아래의 내용에 맞는 package,  procedure 만들어 보자.
--패키지 선언부
CREATE OR REPLACE PACKAGE HR_PKG IS
    --신규 사원 입력
    --신규사원 사번 => 마지막(최대)사번 + 1
    --신규사원 등록
    PROCEDURE NEW_EMP_PROC (
        PS_EMP_NAME  IN VARCHAR2,
        PE_EMAIL     IN VARCHAR2,
        PJ_JOB_ID    IN VARCHAR2,
        PD_HIRE_DATE IN VARCHAR2
    );
    -- TO_DATE(pdhire_date, 'YYYY-MM-DD');

   -- 퇴사 사원 처리
   --퇴사한 사원은 사원테이블에서 삭제하지 않고 퇴사일자(retire_date)를 NULL에서 갱신
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
            DBMS_OUTPUT.PUT_LINE(PN_EMPLOYEE_ID || '는 퇴사대상이 아닙니다.');
            ROLLBACK;
    END;

END;

DECLARE BEGIN
    HR_PKG.NEW_EMP_PROC('AA', 'AA@AA.COM', '100', TO_CHAR(SYSDATE, 'YYYY-MM-DD'));
END;

DECLARE BEGIN
    HR_PKG.RETIRE_EMP_PROC(208);
END;
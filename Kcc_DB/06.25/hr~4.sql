-- 1. 과도한 조인 예제 ⇒ 새로운 View 생성 ⇒ 쿼리 질의
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
-- 2. employees 테이블에서 salary를 제외한 View 생성 ⇒ 쿼리 질의(View)
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
-- 변수 선언
    V_NO       NUMBER := 10;
    V_HIREDATE VARCHAR2(30) := TO_CHAR(SYSDATE, 'YYYY/MM/DD');
-- 상수 선언
    C_MESSAGE  CONSTANT VARCHAR2(50) := 'Hello PL/SQL!!!';
BEGIN
    DBMS_OUTPUT.PUT_LINE('PL/SQL 수업');
    DBMS_OUTPUT.PUT_LINE(C_MESSAGE);
    DBMS_OUTPUT.PUT_LINE(V_HIREDATE);
END;

-- employees 테이블의 로우를 검색하여 변수에 할당해 보자.
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

-- 사원번호 100번에 해당하는 사원의 이름과 부서명을 출력하시오
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


--------------------데이터 타입(기본형, 레퍼런스형)
DECLARE
-- 기본 데이터형
    V_SEARCH VARCHAR(20) := 'Lisa';
-- 레퍼런스형
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

-- 1. 사원테이블에서 201번 사원의 이름과 이메일을 출력하라(레퍼런스형)
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
-- 2. employees ⇒ employees2 복사. 사원테이블에서 사원번호가 가장 큰 사원을 찾은 후 사원번호 +1번으로 아래의 사원을 추가하라
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
난수구하기 ⇒ ROUND(DBMS_RANDOM.VALUE(10, 120),-1))
10~120 사이에 임의의 부서번호를 받아서 해당 부서의 평균 급여에 따라서 등급이 출력되도록 하자.
1~3000 : 낮음
3000~ 6000 : 보통
6000 이상 : 높음
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
-- IF방식
/*IF V_AVG_SAL <= 3000 THEN
DBMS_OUTPUT.PUT_LINE('낮음');
ELSIF V_AVG_SAL <= 6000 THEN
DBMS_OUTPUT.PUT_LINE('보통');
ELSE
DBMS_OUTPUT.PUT_LINE('높음');
END IF;*/
    CASE
        WHEN V_AVG_SAL BETWEEN 1 AND 3000 THEN
            DBMS_OUTPUT.PUT_LINE('낮음');
        WHEN V_AVG_SAL BETWEEN 3000 AND 6000 THEN
            DBMS_OUTPUT.PUT_LINE('보통');
        ELSE
            DBMS_OUTPUT.PUT_LINE('높음');
    END CASE;

END;

-- 반복문(LOOP, WHILE, FOR)
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
    FOR I IN 1..10 LOOP -- 1~10까지
        TOTAL := TOTAL + I;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(TOTAL);
END;

--LOOP문을 이용해서 구구단 3단을 출력해라
DECLARE
    I NUMBER := 3;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 3;
        EXIT WHEN I >= 30;
    END LOOP;
END;
-- FOR문을 이용해서 구구단 전체 출력
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

-------------------예외(Exception)
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
-- UNIQUE 제약조건을 갖는 컬럼에 중복된 데이터를 INSERT하려고 하는 경우
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('이미 존재하는 사원입니다.');
-- 질의문 결과 2개 이상의 ROW가 리턴되어서 발생하는 문제
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('검색된 로우가 많습니다.');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('검색된 사원이 없습니다.');
-- ELSE
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('기타 예외.');
END;

-- 사용자가 강제로 예외 발생 => 예외 정의
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
        DBMS_OUTPUT.PUT_LINE('5명 이하 부서 금지');
END;
-- 신입사원을 입력시 잘못된 부서번호에 대해서 사용자 예외처리 하세요
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
        DBMS_OUTPUT.PUT_LINE('없는 부서번호 입니다.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('기타 예외');
END;

SELECT
    *
FROM
    EMPLOYEES2;

--------------------커서 LOOP방식
DECLARE
-- 커서 선언
    CURSOR DEPARTMENT_CURSORS IS
    SELECT
        DEPARTMENT_ID,
        DEPARTMENT_NAME,
        LOCATION_ID
    FROM
        DEPARTMENTS;
-- CURSOR를 사용하면 항상 ROWTYPE도 사용해야 한다.
    DEPARTMENT_RECORD DEPARTMENT_CURSORS%ROWTYPE;
BEGIN
-- 커서 열기
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
--커서 닫기
    CLOSE DEPARTMENT_CURSORS;
END;

--------------------커서 FOR방식
DECLARE
-- 커서 선언
    CURSOR DEPARTMENT_CURSORS IS
    SELECT
        DEPARTMENT_ID,
        DEPARTMENT_NAME,
        LOCATION_ID
    FROM
        DEPARTMENTS;
-- CURSOR를 사용하면 항상 ROWTYPE도 사용해야 한다.
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
-- 커서를 이용하여 사원의 정보를 출력하라(사원번호, 사원이름(FIRST_NAME), 급여, 급여누계)
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
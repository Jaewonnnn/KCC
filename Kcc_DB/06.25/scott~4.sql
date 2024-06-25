-- 40번 부서의 부서정보를 ROWTYPE을 이용해서 출력하자. (deptno, dname, loc)
set serveroutput on

DECLARE
    V_DEPT DEPT%ROWTYPE;
BEGIN
    SELECT
        *
    INTO V_DEPT
    FROM
        DEPT
    WHERE
        DEPTNO = 40;

    DBMS_OUTPUT.PUT_LINE(V_DEPT.DEPTNO
                         || ' '
                         || V_DEPT.DNAME
                         || ' '
                         || V_DEPT.LOC);

END;

DECLARE
    V_NO    NUMBER := 7;
    V_SCORE NUMBER := 80;
BEGIN
-- 단수
    /*IF V_NO = 7 THEN
        DBMS_OUTPUT.PUT_LINE('7이다');
    END IF;*/
-- IF ~ ELSE ~ END IF
    /*IF V_NO = 5 THEN
        DBMS_OUTPUT.PUT_LINE('5이다');
    ELSE
        DBMS_OUTPUT.PUT_LINE('5가 아니다');
    END IF;*/
-- IF ~ ELSIF ~ END IF
    IF V_SCORE >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('A학점');
    ELSIF V_SCORE >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('B학점');
    ELSIF V_SCORE >= 70 THEN
        DBMS_OUTPUT.PUT_LINE('C학점');
    ELSE
        DBMS_OUTPUT.PUT_LINE('C학점');
    END IF;
END;


-- 40�� �μ��� �μ������� ROWTYPE�� �̿��ؼ� �������. (deptno, dname, loc)
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
-- �ܼ�
    /*IF V_NO = 7 THEN
        DBMS_OUTPUT.PUT_LINE('7�̴�');
    END IF;*/
-- IF ~ ELSE ~ END IF
    /*IF V_NO = 5 THEN
        DBMS_OUTPUT.PUT_LINE('5�̴�');
    ELSE
        DBMS_OUTPUT.PUT_LINE('5�� �ƴϴ�');
    END IF;*/
-- IF ~ ELSIF ~ END IF
    IF V_SCORE >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('A����');
    ELSIF V_SCORE >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('B����');
    ELSIF V_SCORE >= 70 THEN
        DBMS_OUTPUT.PUT_LINE('C����');
    ELSE
        DBMS_OUTPUT.PUT_LINE('C����');
    END IF;
END;


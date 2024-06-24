-- where�� ��������
-- '������'�� �μ�(dept)�� �ٸ����� ������ ����(job)�� �����ϴ� ��� ����� ����϶�
SELECT
    ENAME,
    DNO,
    JOB
FROM
    EMP
WHERE
        DNO != (
            SELECT
                DNO
            FROM
                EMP
            WHERE
                ENAME = '������'
        )
    AND JOB = (
        SELECT
            JOB
        FROM
            EMP
        WHERE
            ENAME = '������'
    );

-- '����'���� �Ϲ�ȭ�а����� ������ ���� �л��� ����� ����϶�.
SELECT
    SNAME,
    CNAME,
    GRADE
FROM
    STUDENT S,
    SCORE   SC,
    COURSE  C,
    SCGRADE
WHERE
        S.SNO = SC.SNO
    AND SC.CNO = C.CNO
    AND CNAME = '�Ϲ�ȭ��'
    AND RESULT < (
        SELECT
            RESULT
        FROM
            STUDENT S,
            SCORE   SC,
            COURSE  C
        WHERE
                S.SNO = SC.SNO
            AND SC.CNO = C.CNO
            AND CNAME = '�Ϲ�ȭ��'
            AND S.SNAME = '����'
    )
    AND SC.RESULT BETWEEN LOSCORE AND HISCORE;

-- HAVING�� ��������
-- �μ� �߿� ��ձ޿��� ���� ���� �޴� �μ��� �˻��϶�.
SELECT
    DNO
FROM
    EMP
GROUP BY
    DNO
HAVING
    AVG(SAL) = (
        SELECT
            MAX(AVG(SAL))
        FROM
            EMP
        GROUP BY
            DNO
    );
    
-- �л� �ο����� ���� ���� �а��� ����϶�.
SELECT
    MAJOR
FROM
    STUDENT
GROUP BY
    MAJOR
HAVING
    COUNT(SNO) = (
        SELECT
            MAX(COUNT(SNO))
        FROM
            STUDENT
        GROUP BY
            MAJOR
    );

-- �л� �� �⸻��� ��ռ����� ���� ���� �л��� ������ �˻��϶�.
SELECT
    ST.SNO,
    SNAME
FROM
    STUDENT ST,
    SCORE   SC
WHERE
    ST.SNO = SC.SNO
GROUP BY
    ST.SNO,
    SNAME
HAVING
    AVG(RESULT) = (
        SELECT
            MIN(AVG(RESULT))
        FROM
            SCORE SC
        GROUP BY
            SNO
    );

-- ȭ�а� 1�г� �л��߿� ������ ��������� �л��� �˻��϶�.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR = 'ȭ��'
    AND SYEAR = 1
    AND AVR < (
        SELECT
            AVG(AVR)
        FROM
            STUDENT
        WHERE
                SYEAR = 1
            AND MAJOR = 'ȭ��'
    );
    
-- 10�� �μ����� ���� ���� �޿��� ���� �۰� �޴� �޿��ڸ� ����϶�.
-- MIN() ���
SELECT
    *
FROM
    EMP
WHERE
    SAL < (
        SELECT
            MIN(SAL)
        FROM
            EMP
        WHERE
            DNO = 10
    );
-- ALL() ���
SELECT
    *
FROM
    EMP
WHERE
    SAL < ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 10
    );

-- �μ���ȣ 30�� �ִ�޿��� ���� �޿��� ���� ����� ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    SAL > ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 30
    );
-- �μ���ȣ 30�� �ִ�޿��� ���� �޿��� ���� ����� ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    SAL < ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 30
    );
-- '���ϴ�'�� ������ ������(mgr)�� ������ �����鼭 ������ ���� ����� �˻��϶�.
SELECT
    *
FROM
    EMP
WHERE
        MGR = (
            SELECT
                MGR
            FROM
                EMP
            WHERE
                ENAME = '���ϴ�'
        )
    AND JOB = (
        SELECT
            JOB
        FROM
            EMP
        WHERE
            ENAME = '���ϴ�'
    );
-- ȭ�а� �л��� ������ ������ �л��� �˻��϶�.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != 'ȭ��'
    AND AVR IN (
        SELECT
            AVR
        FROM
            STUDENT
        WHERE
            MAJOR = 'ȭ��'
    ); 
-- ȭ��ȭ �л��� ���� �г⿡�� ������ ������ �л��� �˻��϶�.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != 'ȭ��'
    AND ( SYEAR, AVR ) IN (
        SELECT
            SYEAR, AVR
        FROM
            STUDENT
        WHERE
            MAJOR = 'ȭ��'
    );
-- �⸻��� ��ռ����� '��ȭ��' ������� �������� ����� �����ȣ, �����, ��米���� �˻��϶�.
SELECT
    C.CNO,
    C.CNAME,
    PNAME
FROM
    SCORE     SC,
    COURSE    C,
    PROFESSOR P
WHERE
        SC.CNO = C.CNO
    AND C.PNO = P.PNO
GROUP BY
    CNAME,
    C.CNO,
    PNAME
HAVING
    AVG(RESULT) > (
        SELECT
            AVG(RESULT)
        FROM
            SCORE  SC,
            COURSE C
        WHERE
                SC.CNO = C.CNO
            AND CNAME = '��ȭ��'
        GROUP BY
            CNAME
    );
    
create table board(
seq NUMBER,
title VARCHAR2(50),
writer VARCHAR2(50),
contents VARCHAR2(200),
regdate DATE,
hitcount NUMBER
);

insert into board values(1, 'a1', 'a', 'a', sysdate, 0);
insert into board values(2, 'a2', 'a', 'a', sysdate, 0);
insert into board values(3, 'a3', 'a', 'a', sysdate, 0);
insert into board values(4, 'a4', 'a', 'a', sysdate, 0);
insert into board values(5, 'a5', 'a', 'a', sysdate, 0);
insert into board values(6, 'a6', 'a', 'a', sysdate, 0);
insert into board values(7, 'a7', 'a', 'a', sysdate, 0);
insert into board values(8, 'a8', 'a', 'a', sysdate, 0);
insert into board values(9, 'a9', 'a', 'a', sysdate, 0);
insert into board values(10, 'a10', 'a', 'a', sysdate, 0);

SELECT
    *
FROM
    (
        SELECT
            ROWNUM AS ROW_NUM,
            TEMP.*
        FROM
            (
                SELECT
                    *
                FROM
                    BOARD
                ORDER BY
                    SEQ DESC
            ) TEMP
    )
WHERE
    ROW_NUM BETWEEN 6 AND 10;

delete from board;
commit;

create sequence board_seq;
insert into board values (board_seq.nextval, 'a1', 'a1', 'a1', sysdate, 0);
/*
insert into board (seq, title, writer, contents, regdate, hitcount)
(select board_seq.nextval, title, writer, contents, regdate, hitcount from board);
*/
select * from board where seq = 9999;


alter table board add constraint board_seq_pk PRIMARY KEY(seq);

-- board ���̺� 'title' �÷��� ���� �۹�ȣ(seq) 100000���� ���� Ÿ��Ʋ ���� �����ض�
-- title ���� a100000���� �����ϰ�, a100000�� �˻� �� ���� ��ȹ�� Ȯ��
-- => full scan
-- �ε��� ���� �� �ٽ� ��ȸ �� ���� ��ȹ Ȯ��
update board set title = 'a100000' where seq = 100000;

select title from board where title = 'a100000';

create index title_index on board(title);



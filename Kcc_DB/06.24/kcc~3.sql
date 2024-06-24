-- where절 서브쿼리
-- '정의찬'과 부서(dept)가 다르지만 동일한 업무(job)을 수행하는 사원 목록을 출력하라
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
                ENAME = '정의찬'
        )
    AND JOB = (
        SELECT
            JOB
        FROM
            EMP
        WHERE
            ENAME = '정의찬'
    );

-- '관우'보다 일반화학과목의 학점이 낮은 학생의 명단을 출력하라.
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
    AND CNAME = '일반화학'
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
            AND CNAME = '일반화학'
            AND S.SNAME = '관우'
    )
    AND SC.RESULT BETWEEN LOSCORE AND HISCORE;

-- HAVING절 서브쿼리
-- 부서 중에 평균급여를 가장 많이 받는 부서를 검색하라.
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
    
-- 학생 인원수가 가장 많은 학과를 출력하라.
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

-- 학생 중 기말고사 평균성적이 가장 낮은 학생의 정보를 검색하라.
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

-- 화학과 1학년 학생중에 평점이 평균이하인 학생을 검색하라.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR = '화학'
    AND SYEAR = 1
    AND AVR < (
        SELECT
            AVG(AVR)
        FROM
            STUDENT
        WHERE
                SYEAR = 1
            AND MAJOR = '화학'
    );
    
-- 10번 부서에서 가장 작은 급여자 보다 작게 받는 급여자를 출력하라.
-- MIN() 사용
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
-- ALL() 사용
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

-- 부서번호 30번 최대급여자 보다 급여가 높은 사원을 출력하라.
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
-- 부서번호 30번 최대급여자 보다 급여가 작은 사원을 출력하라.
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
-- '손하늘'과 동일한 관리자(mgr)의 관리를 받으면서 업무도 같은 사원을 검색하라.
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
                ENAME = '손하늘'
        )
    AND JOB = (
        SELECT
            JOB
        FROM
            EMP
        WHERE
            ENAME = '손하늘'
    );
-- 화학과 학생과 평점이 동일한 학생을 검색하라.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != '화학'
    AND AVR IN (
        SELECT
            AVR
        FROM
            STUDENT
        WHERE
            MAJOR = '화학'
    ); 
-- 화학화 학생과 같은 학년에서 평점이 동일한 학생을 검색하라.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != '화학'
    AND ( SYEAR, AVR ) IN (
        SELECT
            SYEAR, AVR
        FROM
            STUDENT
        WHERE
            MAJOR = '화학'
    );
-- 기말고사 평균성적이 '핵화학' 과목평균 성적보다 우수한 과목번호, 과목명, 담당교수를 검색하라.
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
            AND CNAME = '핵화학'
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

-- board 테이블 'title' 컬럼에 대한 글번호(seq) 100000번에 대해 타이틀 값을 수정해라
-- title 값을 a100000으로 수정하고, a100000을 검색 후 실행 계획을 확인
-- => full scan
-- 인덱스 생성 후 다시 조회 후 실행 계획 확인
update board set title = 'a100000' where seq = 100000;

select title from board where title = 'a100000';

create index title_index on board(title);



-- emp테이블 job컬럼 문자열 중 첫 번째 ~ 두 번째 문자, 5번째 문자 이후 문자 출력
select job, substr(job, 1, 2), substr(job, 5), substr(job, -3) from emp;
--1.1
SELECT empno, rpad(substr(empno,1, 2),length(empno), '*') "masking_empno", 
    ename, rpad(substr(ename,1,1),length(ename), '*') "masked_ename"
FROM emp 
WHERE LENGTH(ename) >= 5 AND LENGTH(ename) < 6;
--1.2
select empno, ename, sal, trunc(sal / 21.5 ,2)"DAY_PAY", round((sal/21.5)/8 ,1) "TIME_PAY"  
from emp;
--1.3
select empno, ename, 
to_char(hiredate, 'YYYY-MM-DD') "hiredate", 
to_char(next_day(add_months(hiredate, 3), '월요일'), 'YYYY-MM-DD') "R_JOB", 
nvl(to_char(comm), 'N/A') as "comm"
from emp;
--1.4
select empno, ename, mgr, 
case substr(to_char(mgr),1, 2)
when '75' then '5555'
when '76' then '6666'
when '77' then '7777'
when '78' then '8888'
else to_char(mgr)
end "chg_mgr"
from emp;
--2.1
select deptno, trunc(avg(sal))"avg_sal",max(sal)"max_sal",min(sal)"min_sal", count(sal)"cnt" from emp group by deptno;
--2.2
select job, count(*) from emp group by job having count(job) >= 3;
--2.3
select to_char(hiredate, 'YYYY') "hire_year",deptno, count(empno)"cnt" 
from emp 
group by to_char(hiredate, 'YYYY'), deptno;
--2.4
SELECT NVL2(COMM, 'O', 'X') AS EXIST_COMM,
       COUNT(*) AS CNT
  FROM EMP
GROUP BY NVL2(COMM, 'O', 'X'); 
--2.5
SELECT DEPTNO,
       TO_CHAR(HIREDATE, 'YYYY') AS HIRE_YEAR,
       COUNT(*) AS CNT,
       MAX(SAL) AS MAX_SAL,
       SUM(SAL) AS SUM_SAL,
       AVG(SAL) AS AVG_SAL
  FROM EMP
GROUP BY ROLLUP(DEPTNO, TO_CHAR(HIREDATE, 'YYYY')); 

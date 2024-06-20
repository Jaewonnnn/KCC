-- emp테이블을 사용하여 20번, 30번 부서에 근무하고 있는 사원 중 급여(sal가 2000 초과인 사원을
-- 다음 두 가지 방식의 select문을 사용하여 사원번호, 급여, 부서번호를 출력하라.
-- 1. 집합연산자를 사용하지 않은 방식
select empno, sal, deptno from emp
where deptno in(20, 30) and sal >= 2000;
-- 2. 집합연산자를 사용한 방식
select empno, sal, deptno from emp where deptno = 20 and sal > 2000
union
select empno, sal, deptno from emp where deptno = 30 and sal > 2000;

select * from emp;
--1. 문제) 부서번호가 10번인 부서의 사람 중 사원번호, 이름, 월급을 출력하라
select empno as 사원번호, ename as 이름, sal as 월급 from emp where deptno = 10;
--2. 문제) 사원번호가 7369인 사람 중 이름, 입사일, 부서번호를 출력하라.
select ename as 이름, hiredate as 입사일, deptno as 부서번호 from emp where empno = '7369';
--3. 문제) 이름이 ALLEN인 사람의 모든 정보를 출력하라.
select * from emp where ename = 'ALLEN';
--5. 문제) 직업이 MANAGER가 아닌 사람의 모든 정보를 출력하라.
select * from emp where job != 'MANAGER';
--6. 문제) 입사일이 81/04/02 이후에 입사한 사원의 정보를 출력하라.
select * from emp where hiredate >= '81/04/02' order by hiredate;
--7. 문제) 급여가 $800 이상인 사람의 이름, 급여, 부서번호를 출력하라.
select ename as 이름, sal as 급여, deptno as 부서번호 from emp where sal >= 800;
--8. 문제) 부서번호가 20번 이상인 사원의 모든 정보를 출력하라.
select * from emp where deptno >= 20;
--10. 문제) 입사일이 81/12/09 보다 먼저 입사한 사람들의 모든 정보를 출력하라.
select * from emp where hiredate <= '81/12/09' order by hiredate desc;
--11. 문제) 입사번호가 7698보다 작거나 같은 사람들의 입사번호와 이름을 출력하라.
select mgr as 입사번호, ename as 이름 from emp where mgr <= 7698;
--12. 문제) 입사일이 81/04/02 보다 늦고 82/12/09 보다 빠른 사원의 이름, 월급, 부서번호를 출력하라.
select ename as 이름, sal as 월급, deptno as 부서번호 from emp where hiredate BETWEEN '81/04/02' and '82/12/09';
--13. 문제) 급여가 $1,600보다 크고 $3,000보다 작은 사람의 이름, 직업, 급여를 출력하라.
select ename as 이름, job as 직업, sal as 급여 from emp where sal >= 1600 and sal <3000;
--14. 문제) 사원번호가 7654와 7782 사이 이외의 사원의 모든 정보를 출력하라.
select * from emp where empno between 7654 and 7782;
--15. 문제) 이름이 B와 J 사이의 모든 사원의 정보를 출력하라.
select * from emp;
--16. 문제) 입사일이 81년 이외에 입사한 사람의 모든 정보를 출력하라.
select * from emp where hiredate not between '81/01/01' and '81/12/31';
--17. 문제) 직업이 MANAGER와 SALESMAN인 사람의 모든 정보를 출력하라.
select * from emp where job in('MANAGER', 'SALESMAN');
--18. 문제) 부서번호와 20, 30번을 제외한 모든 사람의 이름, 사원번호, 부서번호를 출력하라.
select ename, empno, deptno from emp where deptno not in(20,30);
--19. 문제) 이름이 S로 시작하는 사원의 사원번호, 이름, 입사일, 부서번호를 출력하라.
select empno, ename, hiredate, deptno from emp where ename like 'S%';
--20. 문제) 입사일이 81년도인 사람의 모든 정보를 출력하라
select * from emp where hiredate between '81/01/01' and '81/12/31';
--21. 문제) 이름 중 S자가 들어가 있는 사람만 모든 정보를 출력하라
select * from emp where ename like '%S%';
--23. 문제) 첫 번째 문자는 관계없고, 두 번째 문자가 A인 사람의 정보를 출력하라.
select * from emp where ename like '_A%';
--24. 문제) 커미션이 NULL인 사람의 정보를 출력하라.
select * from emp where comm is null;
--25. 문제) 커미션이 NULL이 아닌 사람의 모든 정보를 출력하라.
select * from emp where comm is not null;
--26. 문제) 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서 ,월급을 출력하라.
select ename, deptno, sal from emp where deptno = 30 and sal >= 1500;
--27. 문제) 이름의 첫 글자가 K로 시작하거나 부서번호가 30인 사람의 사원번호, 이름, 부서번호를 출력하라.
select empno, ename, deptno from emp where ename like 'K%' or deptno = 30;
--28. 문제) 급여가 $1,500 이상이고 부서번호가 30번인 사원 중 직업이 MANAGER인 사람의 정보를 출력하라
select * from emp where sal >= 1500 and empno = 30
union
select * from emp where job = 'MANAGER';
--29. 문제) 부서번호가 30인 사람 중 사원번호 SORT하라.
select * from emp where deptno = 30 order by empno;
--30. 문제) 급여가 많은 순으로 SORT하라.
select * from emp order by sal desc;


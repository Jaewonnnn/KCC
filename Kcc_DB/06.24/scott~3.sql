-- 전체 사원 중 ALLEN과 같은 직책(job)인 사원들의 사원 정보, 부서 정보를 출력
select job, empno, ename, sal, e.deptno, dname
from emp e, dept d
where e.deptno = d.deptno 
and job = (select job from emp where ename = 'ALLEN');

-- 전체 사원의 평균 급여(sal)보다 높은 급여를 받는 사원들의 사원 정보, 부서 정보, 급여 등급 정보를 출력
select empno, ename, d.dname, e.hiredate, d.loc, sal, grade
from emp e, dept d, salgrade
where e.deptno = d.deptno
and sal > (select avg(sal) from emp)
and sal between losal and hisal
order by sal desc;

-- 10번 부서에 근무하는 사원 중 30번 부서에는 존재하지 않는 직책을 가진 사원들의 사원 정보, 부서 정보를 출력
select empno, ename, job, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno
and d.deptno = 10
and job not in (select job from emp where deptno = 30);

-- 직책이 SALESMAN인 사람들의 최고 급여보다 높은 급여를 받는 사원들의 사원 정보, 급여 등급 정보를 출력
select max(sal) from emp where job = 'SALESMAN';
select empno, ename, sal, grade
from emp, salgrade
where sal > (select max(sal) from emp where job = 'SALESMAN')
and sal between losal and hisal
order by empno;
SELECT ename, sal, grade
FROM emp, salgrade
WHERE sal BETWEEN losal AND hisal
ORDER BY grade;

select * from emp;
select * from salgrade;
select * from dept;
-- 급여(sal)가 2000 초과인 사원들의 부서 정보, 사원 정보를 출력
select * from emp where sal >= 2000; -- 5 row
select d.deptno, d.dname, e.empno, e.ename, e.sal
from emp e, dept d
where e.sal >=2000
and e.deptno = d.deptno;
-- 각 부서별 평균 급여, 최대 급여, 최소 급여, 사원수 출력
select d.deptno, d.dname, trunc(avg(e.sal)) avg_sal, max(e.sal) max_sal, min(e.sal) min_sal, count(e.sal) cnt
from emp e, dept d
where e.deptno = d.deptno
group by d.deptno, d.dname
;

-- 모든 부서 정보와 사원 정보를 부서 번호, 사원 이름순으로 정렬하여 출력
select d.deptno, d.dname, e.empno, e.ename, job, e.sal
from emp e, dept d
where e.deptno(+) = d.deptno

order by d.deptno, d.dname, e.ename;

-- 모든 부서 정보, 사원 정보, 급여 등급 정보, 각 사원의 직속 상관의 정보를 부서 번호,
-- 사원 번호 순서로 정렬하여 출력



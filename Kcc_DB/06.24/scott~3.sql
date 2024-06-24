-- ��ü ��� �� ALLEN�� ���� ��å(job)�� ������� ��� ����, �μ� ������ ���
select job, empno, ename, sal, e.deptno, dname
from emp e, dept d
where e.deptno = d.deptno 
and job = (select job from emp where ename = 'ALLEN');

-- ��ü ����� ��� �޿�(sal)���� ���� �޿��� �޴� ������� ��� ����, �μ� ����, �޿� ��� ������ ���
select empno, ename, d.dname, e.hiredate, d.loc, sal, grade
from emp e, dept d, salgrade
where e.deptno = d.deptno
and sal > (select avg(sal) from emp)
and sal between losal and hisal
order by sal desc;

-- 10�� �μ��� �ٹ��ϴ� ��� �� 30�� �μ����� �������� �ʴ� ��å�� ���� ������� ��� ����, �μ� ������ ���
select empno, ename, job, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno
and d.deptno = 10
and job not in (select job from emp where deptno = 30);

-- ��å�� SALESMAN�� ������� �ְ� �޿����� ���� �޿��� �޴� ������� ��� ����, �޿� ��� ������ ���
select max(sal) from emp where job = 'SALESMAN';
select empno, ename, sal, grade
from emp, salgrade
where sal > (select max(sal) from emp where job = 'SALESMAN')
and sal between losal and hisal
order by empno;
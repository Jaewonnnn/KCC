SELECT ename, sal, grade
FROM emp, salgrade
WHERE sal BETWEEN losal AND hisal
ORDER BY grade;

select * from emp;
select * from salgrade;
select * from dept;
-- �޿�(sal)�� 2000 �ʰ��� ������� �μ� ����, ��� ������ ���
select * from emp where sal >= 2000; -- 5 row
select d.deptno, d.dname, e.empno, e.ename, e.sal
from emp e, dept d
where e.sal >=2000
and e.deptno = d.deptno;
-- �� �μ��� ��� �޿�, �ִ� �޿�, �ּ� �޿�, ����� ���
select d.deptno, d.dname, trunc(avg(e.sal)) avg_sal, max(e.sal) max_sal, min(e.sal) min_sal, count(e.sal) cnt
from emp e, dept d
where e.deptno = d.deptno
group by d.deptno, d.dname
;

-- ��� �μ� ������ ��� ������ �μ� ��ȣ, ��� �̸������� �����Ͽ� ���
select d.deptno, d.dname, e.empno, e.ename, job, e.sal
from emp e, dept d
where e.deptno(+) = d.deptno

order by d.deptno, d.dname, e.ename;

-- ��� �μ� ����, ��� ����, �޿� ��� ����, �� ����� ���� ����� ������ �μ� ��ȣ,
-- ��� ��ȣ ������ �����Ͽ� ���



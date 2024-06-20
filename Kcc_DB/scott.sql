-- emp���̺��� ����Ͽ� 20��, 30�� �μ��� �ٹ��ϰ� �ִ� ��� �� �޿�(sal�� 2000 �ʰ��� �����
-- ���� �� ���� ����� select���� ����Ͽ� �����ȣ, �޿�, �μ���ȣ�� ����϶�.
-- 1. ���տ����ڸ� ������� ���� ���
select empno, sal, deptno from emp
where deptno in(20, 30) and sal >= 2000;
-- 2. ���տ����ڸ� ����� ���
select empno, sal, deptno from emp where deptno = 20 and sal > 2000
union
select empno, sal, deptno from emp where deptno = 30 and sal > 2000;

select * from emp;
--1. ����) �μ���ȣ�� 10���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶�
select empno as �����ȣ, ename as �̸�, sal as ���� from emp where deptno = 10;
--2. ����) �����ȣ�� 7369�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����϶�.
select ename as �̸�, hiredate as �Ի���, deptno as �μ���ȣ from emp where empno = '7369';
--3. ����) �̸��� ALLEN�� ����� ��� ������ ����϶�.
select * from emp where ename = 'ALLEN';
--5. ����) ������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.
select * from emp where job != 'MANAGER';
--6. ����) �Ի����� 81/04/02 ���Ŀ� �Ի��� ����� ������ ����϶�.
select * from emp where hiredate >= '81/04/02' order by hiredate;
--7. ����) �޿��� $800 �̻��� ����� �̸�, �޿�, �μ���ȣ�� ����϶�.
select ename as �̸�, sal as �޿�, deptno as �μ���ȣ from emp where sal >= 800;
--8. ����) �μ���ȣ�� 20�� �̻��� ����� ��� ������ ����϶�.
select * from emp where deptno >= 20;
--10. ����) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����϶�.
select * from emp where hiredate <= '81/12/09' order by hiredate desc;
--11. ����) �Ի��ȣ�� 7698���� �۰ų� ���� ������� �Ի��ȣ�� �̸��� ����϶�.
select mgr as �Ի��ȣ, ename as �̸� from emp where mgr <= 7698;
--12. ����) �Ի����� 81/04/02 ���� �ʰ� 82/12/09 ���� ���� ����� �̸�, ����, �μ���ȣ�� ����϶�.
select ename as �̸�, sal as ����, deptno as �μ���ȣ from emp where hiredate BETWEEN '81/04/02' and '82/12/09';
--13. ����) �޿��� $1,600���� ũ�� $3,000���� ���� ����� �̸�, ����, �޿��� ����϶�.
select ename as �̸�, job as ����, sal as �޿� from emp where sal >= 1600 and sal <3000;
--14. ����) �����ȣ�� 7654�� 7782 ���� �̿��� ����� ��� ������ ����϶�.
select * from emp where empno between 7654 and 7782;
--15. ����) �̸��� B�� J ������ ��� ����� ������ ����϶�.
select * from emp;
--16. ����) �Ի����� 81�� �̿ܿ� �Ի��� ����� ��� ������ ����϶�.
select * from emp where hiredate not between '81/01/01' and '81/12/31';
--17. ����) ������ MANAGER�� SALESMAN�� ����� ��� ������ ����϶�.
select * from emp where job in('MANAGER', 'SALESMAN');
--18. ����) �μ���ȣ�� 20, 30���� ������ ��� ����� �̸�, �����ȣ, �μ���ȣ�� ����϶�.
select ename, empno, deptno from emp where deptno not in(20,30);
--19. ����) �̸��� S�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �μ���ȣ�� ����϶�.
select empno, ename, hiredate, deptno from emp where ename like 'S%';
--20. ����) �Ի����� 81�⵵�� ����� ��� ������ ����϶�
select * from emp where hiredate between '81/01/01' and '81/12/31';
--21. ����) �̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����϶�
select * from emp where ename like '%S%';
--23. ����) ù ��° ���ڴ� �������, �� ��° ���ڰ� A�� ����� ������ ����϶�.
select * from emp where ename like '_A%';
--24. ����) Ŀ�̼��� NULL�� ����� ������ ����϶�.
select * from emp where comm is null;
--25. ����) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����϶�.
select * from emp where comm is not null;
--26. ����) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�, �μ� ,������ ����϶�.
select ename, deptno, sal from emp where deptno = 30 and sal >= 1500;
--27. ����) �̸��� ù ���ڰ� K�� �����ϰų� �μ���ȣ�� 30�� ����� �����ȣ, �̸�, �μ���ȣ�� ����϶�.
select empno, ename, deptno from emp where ename like 'K%' or deptno = 30;
--28. ����) �޿��� $1,500 �̻��̰� �μ���ȣ�� 30���� ��� �� ������ MANAGER�� ����� ������ ����϶�
select * from emp where sal >= 1500 and empno = 30
union
select * from emp where job = 'MANAGER';
--29. ����) �μ���ȣ�� 30�� ��� �� �����ȣ SORT�϶�.
select * from emp where deptno = 30 order by empno;
--30. ����) �޿��� ���� ������ SORT�϶�.
select * from emp order by sal desc;


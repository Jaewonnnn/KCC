
-- select, as
-- 1. �� �л��� ������ �˻��϶�(�й�, �̸�, ����): student -> ��Ī ���
select sno as �й�, sname as �̸�, avr as ���� from student;

-- 2. �� ������ ������ �˻��϶�(�����ȣ, �����, ������): course -> ��Ī
select cno as �����ȣ, cname as �����, st_num as ������ from course;

-- 3. �� ������ ������ �˻��϶�(������ȣ, �����̸�, ����): professor -> ��Ī
select pno as ������ȣ, pname as �����̸�, orders as ���� from professor;

-- 4. �޿��� 10% �λ����� �� �� �������� ���� ���޵Ǵ� �޿��� �˻��϶�: emp
-- (�����ȣ, ����̸�, ����)-> ��Ī
select eno as �����ȣ, ename as ����̸�, sal*1.1 as ���� from emp;

-- ���� �л��� ������ 4.0 �����̴�. �̸� 4.5 �������� ȯ���ؼ� �˻��϶�: student
-- (�й�, �̸�, ȯ������) -> ��Ī
select sno as �й�, sname as �̸�, (avr / 4) * 4.5 as ȯ������ from student;

-- order by
select eno, ename, sal from emp order by sal desc;

-- �� �а����� ������ ������ �������ڼ����� �˻�
select section, pname, hiredate from professor order by section, hiredate;

-- 2, 3�г� �л� �߿��� ������ 2.0���� 3.0 ������ �л��� �˻��϶�.
select * from student where syear in(2,3) and avr between 2.0 and 3.0;
-- ȭ��, �����а� �л��߿� 1, 2�г� �л��� ���� ������ �˻��϶�.
select * from student where major in('ȭ��', '����') and syear in (1, 2) order by avr desc;
-- ȭ�а� �������� �˻��϶�
select * from professor where section = 'ȭ��' and orders = '������';

-- ȭ�а� �л� �߿� ���� '��'���� �л��� �˻��϶�.
select * from student where major = 'ȭ��' and sname like '��%';
-- �������� 1995�� ������ �������� �˻��϶�.
select * from  professor where orders = '������' and hiredate <= '95/12/12';
-- ���� �̸��� ���� 1������ ������ �˻��϶�
select * from professor where pname like '__';
-- ȭ�а� �л� �߿� 4.5 ȯ�� ������ 3.5 �̻��� �л��� �˻��϶�
select * from student where major = 'ȭ��' and (avr / 4) * 4.5 >= 3.5;
-- ȭ�а� �̿� �а� �л��� ������ �� �а��� �׸��� �г⺰ ������ ����϶�.
select * from student where not major = 'ȭ��' order by major, syear;


select eno, ename, dno
from emp
where dno = 10
UNION 
select eno, ename, dno
from emp
where dno = 20;

-- 1. ȭ�а� �г⺰ ��� ������ �˻��϶�.
select syear, major, avg(avr) from student
where major = 'ȭ��'
group by syear, major;
-- 2. �� �а��� �л����� �˻��϶�.
select major, count(sno) 
from student
group by major;
-- 3. ȭ�а� �����а� �л��� 4.5ȯ�� ������ ����� ���� �˻��϶�.
select major, (avg(avr) / 4.0) * 4.5 
from student
where major in ('ȭ��', '����')
group by major;

-- 1. ȭ�а��� ������ �л����� ���� ��������� �˻��϶�.
select major, avg(avr)
from student
group by major
having major != 'ȭ��';
-- 2. ȭ�а��� ������ �� �а��� ���� �߿� ������ 2.0�̻� �а������� �˻��϶�.
select major, avg(avr) 
from student
group by major
having major != 'ȭ��' and avg(avr) >= 2.0;
-- 3. �ٹ����� ���� 3�� �̻��� �μ��� �˻��϶�(emp)
select dno, count(*)
from emp
group by dno
having count(*) >= 3;



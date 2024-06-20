
-- select, as
-- 1. 각 학생의 평점을 검색하라(학번, 이름, 학점): student -> 별칭 사용
select sno as 학번, sname as 이름, avr as 학점 from student;

-- 2. 각 과목의 학점을 검색하라(과목번호, 과목명, 학점수): course -> 별칭
select cno as 과목번호, cname as 과목명, st_num as 학점수 from course;

-- 3. 각 교수의 직위를 검색하라(교수번호, 교수이름, 직위): professor -> 별칭
select pno as 교수번호, pname as 교수이름, orders as 직위 from professor;

-- 4. 급여를 10% 인상했을 때 각 직원마다 연간 지급되는 급여를 검색하라: emp
-- (사원번호, 사원이름, 연봉)-> 별칭
select eno as 사원번호, ename as 사원이름, sal*1.1 as 연봉 from emp;

-- 현재 학생의 평점은 4.0 만점이다. 이를 4.5 만점으로 환산해서 검색하라: student
-- (학번, 이름, 환산학점) -> 별칭
select sno as 학번, sname as 이름, (avr / 4) * 4.5 as 환산학점 from student;

-- order by
select eno, ename, sal from emp order by sal desc;

-- 각 학과별로 교수의 정보를 부임일자순으로 검색
select section, pname, hiredate from professor order by section, hiredate;

-- 2, 3학년 학생 중에서 학점이 2.0에서 3.0 사이의 학생을 검색하라.
select * from student where syear in(2,3) and avr between 2.0 and 3.0;
-- 화학, 물리학과 학생중에 1, 2학년 학생을 성적 순으로 검색하라.
select * from student where major in('화학', '물리') and syear in (1, 2) order by avr desc;
-- 화학과 정교수를 검색하라
select * from professor where section = '화학' and orders = '정교수';

-- 화학과 학생 중에 성이 '관'씨인 학생을 검색하라.
select * from student where major = '화학' and sname like '관%';
-- 부임일이 1995년 이전의 정교수를 검색하라.
select * from  professor where orders = '정교수' and hiredate <= '95/12/12';
-- 성과 이름이 각각 1글자인 교수를 검색하라
select * from professor where pname like '__';
-- 화학과 학생 중에 4.5 환산 학점이 3.5 이상인 학생을 검색하라
select * from student where major = '화학' and (avr / 4) * 4.5 >= 3.5;
-- 화학과 이외 학과 학생의 평점을 각 학과별 그리고 학년별 순서로 출력하라.
select * from student where not major = '화학' order by major, syear;


select eno, ename, dno
from emp
where dno = 10
UNION 
select eno, ename, dno
from emp
where dno = 20;

-- 1. 화학과 학년별 평균 학점을 검색하라.
select syear, major, avg(avr) from student
where major = '화학'
group by syear, major;
-- 2. 각 학과별 학생수를 검색하라.
select major, count(sno) 
from student
group by major;
-- 3. 화학과 생물학과 학생을 4.5환산 학점의 평균을 각각 검색하라.
select major, (avg(avr) / 4.0) * 4.5 
from student
where major in ('화학', '생물')
group by major;

-- 1. 화학과를 제외한 학생들의 과별 평점평균을 검색하라.
select major, avg(avr)
from student
group by major
having major != '화학';
-- 2. 화학과를 제외한 각 학과별 평점 중에 평점이 2.0이상 학과정보를 검색하라.
select major, avg(avr) 
from student
group by major
having major != '화학' and avg(avr) >= 2.0;
-- 3. 근무중인 직원 3명 이상인 부서를 검색하라(emp)
select dno, count(*)
from emp
group by dno
having count(*) >= 3;



SELECT 'DataBase', LOWER('DataBase') FROM dual;

-- 문자열, 인덱스(1부터), 문자갯수
SELECT SUBSTR('abcdef', 2, 3) FROM dual; -- bcd

SELECT SUBSTR('abcdef', 3) FROM dual; -- cdef

-- 사원의 근속년을 출력하라. 예) 10.5년
SELECT last_name "이름", ROUND((sysdate -hire_date) / 365, 1) || '년' "근속년" FROM employees;
-- SYSDATE → 현재 날짜 리턴 / NEXT_DAY(날짜데이터, 요일문자) / ADD_MONTHS(날짜데이터, 추가할 개월 수)
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토요일') FROM dual;

--TO_CHAR() → 숫자, 날짜를 문자열로 변환
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-dd') FROM dual;
SELECT TO_CHAR(5000000, '$999,999,999') FROM dual;

-- TO_DATE() → 문자열을 날짜데이터로 변환
SELECT TO_DATE('2024-06-20', 'YYYY/MM/DD') FROM dual;
SELECT TO_DATE('20240622', 'YYYY/MM/DD') FROM dual;

-- 2007년도에 입사한 사원의 목록을 출력하라. TO_CHAR()사용
select last_name, to_char(hire_date, 'YYYY/MM/DD') from employees where hire_date between '07/01/01' and '07/12/31';
select * from employees where to_char(hire_date, 'YYYY') = '2007';

-- NVL() → NULL을 0 또는 기타 디폴트값으로 변환
SELECT employee_id, salary, NVL(commission_pct, 0) FROM employees;
-- NVL2(데이터, exper1, exper2) → 데이터가 NULL이면 exper2, NULL 아니면 exper1
SELECT employee_id, salary, NVL2(commission_pct, 'O', 'X') FROM employees;
-- DECODE(컬럼, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3..........) 
SELECT job_id, DECODE(job_id, 'SA_MAN', 'Sales DEPT',/ 'SH_CLERK', 'Sales Dept', 'Another') FROM employees;

SELECT job_id,
CASE job_id
WHEN 'SA_MAN' THEN 'sales Dept'
WHEN 'SH_CLERK' THEN 'Sales Dept'
ELSE 'Another2'
END "CASE"
FROM employees;

-- 테이블 복사(구조 + 데이터)
CREATE TABLE emp01 AS SELECT * FROM employees;

-- 테이블 복사(구조)
CREATE TABLE emp02 AS SELECT * FROM employees WHERE 1 = 0; -- 일치하는 값이 하나도 없기 때문

-- 테이블 구조 수정
ALTER TABLE emp02 ADD(job VARCHAR(50));

-- 컬럼 수정
ALTER TABLE emp02 MODIFY(job VARCHAR2(100));

-- 컬럼 삭제
ALTER TABLE emp02 DROP COLUMN job;

-- 데이터 삭제
DELETE FROM emp01; -- DML (트랜잭션 O)
ROLLBACK;
truncate table emp01; --> DDL(트랜잭션 X)

-- 테이블 삭제
DROP TABLE emp01;

CREATE TABLE dept01 as select * from departments;

-- 데이터 추가
INSERT INTO dept01 VALUES(300, 'Developer', 100, 10);
INSERT INTO dept01(department_id, department_name) VALUES(400, 'Sales');

-- 데이터 수정
-- UPDATE 테이블 SET 컬럼명1=수정값, 컬럼명2=수정값 WHRER 수정대상
update dept01 set department_name = 'IT Service' where department_id = 300;

-- employees 테이블을 복사해서 emp01테이블을 생성 후 salary가 3000이상 대상자에게 salary를 10% 인상하자.
select * from employees;
create table emp01 as select * from employees;
update emp01 set salary = salary * 1.1 where salary >= 3000;
select * from emp01;

select * from dept01;
-- DELETE(데이터 삭제)
-- DELETE FROM 테이블명 WHERE 삭제 대상
-- dept01 테이블에서 부서이름이 'IT Service' 값을 가진 로우를 삭제해라
delete from dept01 where department_name = 'IT Service';





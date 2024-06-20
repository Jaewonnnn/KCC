-- course 테이블에서 과목명(cname) 마지막 글자를 제외하고 출력
select cname, substr(cname, 1, length(cname)-1) from course;

SELECT ROUND(4323.4323, -2) FROM dual;

SELECT SYSDATE -1 "어제", SYSDATE "오늘", SYSDATE +1 "내일" FROM dual;
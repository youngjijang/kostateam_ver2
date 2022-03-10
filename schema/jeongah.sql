select * from course;
select * from student;
select * from sugang;

drop sequence sugang_seq;
create sequence sugang_seq;

create table sugang(
 SUGANG_NO NUMBER constraint sugang_no_pk Primary key,
 COURSE_CODE VARCHAR2(4) constraint sugang_coursecode_FK REFERENCES course(course_code) ON DELETE CASCADE,
 S_ID VARCHAR2(20 BYTE) constraint sugang_studentid_FK references student(s_id) on delete cascade,
 SCORE NUMBER
);

--뷰 생성
select course_code, course_name, t_name, course_capa, course_hour, course_content, to_char(course_start, 'YYYY-MM-DD'), to_char(course_end, 'YYYY-MM-DD') from course join teacher using(course_code);

select * from course join teacher using(course_code);

create or replace view course_with_tname_view
as select *
from course natural join teacher;

select * from course_with_tname_view;

--초기 데이터
insert into student values('초보사냥꾼', 1234, '김자바', '010-1111-1111', '컴공');
insert into student values('거북이', 1234, '박자바', '010-2222-1111', '미디어');
insert into student values('오레오', 1234, '강자바', '010-2222-3333', '미디어');


insert into course values('A100', '웹기초', 30, 160, '기초를 배운다', '2020-01-01', '2020-06-20');
insert into course values('A200', 'GitHub기초', 30, 160, '협업을 배운다', '2020-01-01', '2020-01-31');

delete sugang where sugang_no = 2;
insert into sugang values(sugang_seq.nextval, 'A100', '초보사냥꾼', 100);
insert into sugang values(sugang_seq.nextval, 'A100', '거북이', null);
insert into sugang values(sugang_seq.nextval, 'A100', '오레오', null);
update sugang set course_code = 'A200' where s_id = '오레오';

--강사 기능
--1)학생id로 이름, 연락처, 전공 검색
--selectStudentByStudentId=
select s_id, s_name, s_tel, s_major from student where s_id = '초보사냥꾼';

--2)강의 코드로 수강생 정보 검색
--selectStudentByCourseCode=
select s_id, s_name, s_tel, s_major
from student where s_id in (select s_id from sugang where course_code ='A100');

--3)강사 id로 담당 강의 정보 검색
--teacher테이블 생기면 테스트
--selectCourseByTeacherId
select * from course where course_code in (select course_code from teacher where t_id = '딸기');
select * from teacher;
--4)성적, 학생이름을 받아서 성적 입력(수정할때도 사용)
--insertScore
update sugang set score = 90 where s_id = (select s_id from student where s_name = '김자바');
select * from sugang;

--학생기능
--1)강의 전체 검색
--selectAllCourse
select * from course;

--2)강의코드를 받아서 수강 신청
--insertSugang
select * from sugang;
insert into sugang values(sugang_seq.nextval, 'A200', '초보사냥꾼', null);

--3)학생아이디, 강의코드를 받아 수강신청 취소
--deleteSugang
delete sugang where s_id = '초보사냥꾼' and course_code = 'A200';

--4)학생아이디를 받아 신청한 강의목록 검색
--selectSugang
select * from sugang where s_id = '초보사냥꾼';

--5)학생 id로 강의명과 성적 검색
--selectScore
select course_name, score from sugang join course using(course_code) where s_id = '초보사냥꾼';

commit;

--------0306------------------------
select * from student;
select * from teacher;
select * from course;


--초기 데이터 추가
insert into course values ('A300', '데이터 모델링', 25, 160, 'DB구축을 배운다', '2020-03-01', '2020-08-01');
insert into course values ('A400', 'SW 품질 관리', 35, 80, '현직자 능력 향상', '2020-06-01', '2020-09-01');
insert into course values ('A500', '고급 SQL', 25, 80, '현직자 능력 향상', '2020-06-01', '2020-09-01');

update course set course_hour = 40, course_end = '2020-04-01' where course_code = 'A200';
update course set course_start = '2020-03-01', course_end = '2020-08-01' where course_code = 'A200';
update course set course_hour = 40, course_end = '2020-04-01' where course_code = 'A300';

insert into teacher values('수박', 1234, '황자바', '010-1111-1234', 'A300');
insert into teacher values('포도', 1234, '안자바', '010-2222-2222', 'A400');
insert into teacher values('오이', 1234, '민자바', '010-3333-3333', 'A500');

--기능 추가
--1)회원등록(학생만)
--insertStudent
insert into student values ('마리오', 1234, '김학생', '010-1234-1234', '행정');

--2)개인정보 수정하기(학생, 강사 둘 다)
-----1)과 동일하되 물음표 위치 다르게 하기


commit;

--제약조건 추가
alter table course modify course_capa check(course_capa>0);

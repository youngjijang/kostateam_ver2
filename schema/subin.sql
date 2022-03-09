-- 강사 테이블 생성
create table teacher(
    t_id varchar2(20) constraint TEACHER_ID_PK primary key,
    t_pwd number not null,
    t_name varchar2(10),
    t_tel varchar2(13),
    course_code varchar(4) constraint TEACHER_COURSE_FK references course(course_code)
);

-- 공지게시판 테이블 생성 
create table board(
    board_no number constraint BOARD_NO_PK primary key,
    board_content varchar2(30),
    board_date date,
    board_pwd number not null,
    t_id varchar2(20) constraint BOARD_TEACHER_ID_FK references teacher(t_id)
);
drop table board;
create sequence board_seq;
drop sequence board_seq;

-- 댓글 테이블 생성
create table reply(
    reply_no number constraint REPLY_NO_PK primary key,
    reply_content varchar2(20) not null,
    board_no number constraint REPLY_BOARD_NO_FK references board(board_no) not null,
    reply_writer varchar2(20) not null,
    reply_pwd number not null
); 

drop table reply;
create sequence reply_seq;
drop sequence reply_seq;

-- 매니저 테이블 생성 
create table manager(
    m_id varchar2(20) constraint MANAGER_ID_PK primary key,
    m_pwd number not null,
    m_name varchar2(20),
    m_tel varchar2(13),
    m_task varchar2(20)
);
drop table manager;

select * from teacher;
select * from board;
select * from reply;
select * from manager;



-- 초기데이터 세팅 
insert into teacher values('감자', 1234, '김자바', '010-1234-5678', 'A100');
insert into teacher values('딸기', 1234, '이자바', '010-1234-5678', 'A200');

insert into board values(board_seq.nextval, '안녕하세요', sysdate, 1234, '감자');
insert into board values(board_seq.nextval, '반가워요', sysdate, 1234, '딸기');

insert into reply values(reply_seq.nextval, '안녕하십니까', 1, '익명이', 1234);
insert into reply values(reply_seq.nextval, '배고파용', 1, '익명이2', 1234);
insert into reply values(reply_seq.nextval, '어려워요', 1, '익명이3', 1234);

insert into reply values(reply_seq.nextval, '하잉', 2, '익명이', 1234);
insert into reply values(reply_seq.nextval, '졸령', 2, '익명이2', 1234);
insert into reply values(reply_seq.nextval, '바잉', 2, '익명이3', 1234);

insert into manager values('개설중', 1234, '김개설', '010-1234-5678', '강의 개설');
insert into manager values('관리중', 1234, '박관리', '010-1234-5678', '게시판 관리');

commit;

-- 게시판, 댓글 기능 추가(등록, 수정, 삭제)
select * from board;

-- 1. 게시글 등록
insert into board values(board_seq.nextval, '하이잉', sysdate, 1234, '딸기');

-- 2. 게시글 수정 
update board set board_content = '수정했어요!' where board_no = 1 and board_pwd = 1234;

-- 3. 게시글 삭제
delete board where board_no = 3 and board_pwd = 1234;

-- 4. 댓글 등록
select * from reply;

insert into reply values(reply_seq.nextval, '댓글 등록!', 1, '익명이4', 1234);

-- 5. 댓글 수정
update reply set reply_content = '댓글 수정!' where reply_no = 1 and reply_pwd = 1234;

-- 6. 댓글 삭제 
delete reply where reply_no = 4 and reply_pwd = 1234;

commit;




-- 회원
insert into tblUser (id, pw, name, email, lv, pic, intro, ing)
    values('hong', '1111', '홍길동', 'hong@gamil.com', '1', default, '자바를 공부하는 학생입니다', default);
    
select * from tblUser;

update tblUser set lv = 2 where id = 'admin';

commit;


update tblUser set ing = 'y' where id = 'su';


-- 게시판

insert into tblBoard (seq, subject, content, regdate, readcount, id) values (seqBoard.nextVal, '게시판입니다', '내용입니다', default, default, 'hong');
    
select * from tblBoard;

commit;

select * from vwBoard;

update tblBoard set regdate = regdate - 1 where seq <= 3;


-- 게시판 검색

select * from vwBoard --목록보기

select * from vwBoard where subject like '%게시판%'; -검색




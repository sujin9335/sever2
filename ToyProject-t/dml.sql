
-- ToyProject > dml.sql

-- 회원
insert into tblUser (id, pw, name, email, lv, pic, intro, ing)
    values ('hong', '1111', '홍길동', 'hong@gmail.com'
        , '1', default,  '자바를 공부하는 학생입니다.', default);
        
select * from tblUser;

update tblUser set ing = 'y';

commit;



insert into tblBoard (seq, subject, content, regdate, readcount, id)
    values (seqBoard.nextVal, '게시판입니다.', '내용입니다.', default, default, 'hong');

select * from tblBoard;

delete from tblBoard where seq in (2, 3);

commit;


select * from vwBoard;

update tblBoard set regdate = regdate - 1 where seq <= 6;

commit;





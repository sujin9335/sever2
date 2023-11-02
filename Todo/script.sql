-- todo > script.sql

drop table tblTodo;
drop sequence seqTodo;

-- ���� ���̺�
create table tblTodo (
    seq number primary key,             --��ȣ
    todo varchar2(1000) not null,       --����
    state char(1) default 'n' not null, --�̿Ϸ�(n) �Ϸ�(y)
    regdate date default sysdate not null
    
);

create sequence seqTodo;

insert into tblTodo (seq, todo, state, regdate)
    values (seqTodo.nextVal, '�����Դϴ�', default, default);
    
select * from tblTodo order by seq desc;

select * from tblTodo order by state asc, seq desc;


update tblTodo set state = 'y' where seq = 8;

delete from tblTodo where seq = 1;

commit;








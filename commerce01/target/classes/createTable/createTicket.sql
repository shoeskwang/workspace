-- oracle ��
create table tbl_board(
bno number not null,
title varchar2(200) not null,
content varchar2(4000),
writer varchar2(50) not null,
regdate date default sysdate,
viewcnt number default 0,
primary key(bno)
);









create table tbl_ticket(
tno varchar2(20) not null,
title varchar2(200) not null,
summary varchar2(200) not null,
sdate date not null,
edate date not null,
location varchar2(20) not null,
tclass varchar2(20) not null,
genre varchar2(20) not null,
rtime varchar2(20) not null,
rdate date default sysdate,
state varchar2(20) not null,
theme varchar2(20) not null,
content varchar2(4000),
poster varchar2(50) not null,
tcount number default 0,
tprice number not null,
primary key(tno)
);

insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t001','����01','����01�Դϴ�.',to_date('2017-06-08','YYYY-MM-DD'),to_date('2017-06-10','YYYY-MM-DD'),'1','4','5','100',to_date('2017-05-01','YYYY-MM-DD'),'1','1','����01 �������Դϴ�.','t001',35,200000);

insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t002','����02','����02�Դϴ�.',to_date('2017-06-09','YYYY-MM-DD'),to_date('2017-06-12','YYYY-MM-DD'),'2','2','4','100',to_date('2017-05-03','YYYY-MM-DD'),'1','2','����02 �������Դϴ�.','t002',40,190000);

insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t003','����03','����03�Դϴ�.',to_date('2017-06-10','YYYY-MM-DD'),to_date('2017-06-14','YYYY-MM-DD'),'3','3','3','100',to_date('2017-05-05','YYYY-MM-DD'),'1','3','����03 �������Դϴ�.','t003',45,180000);

insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t004','����04','����04�Դϴ�.',to_date('2017-06-11','YYYY-MM-DD'),to_date('2017-06-16','YYYY-MM-DD'),'4','1','2','100',to_date('2017-05-07','YYYY-MM-DD'),'1','4','����04 �������Դϴ�.','t004',40,170000);

insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t005','����05','����05�Դϴ�.',to_date('2017-06-12','YYYY-MM-DD'),to_date('2017-06-18','YYYY-MM-DD'),'5','4','1','100',to_date('2017-05-09','YYYY-MM-DD'),'1','3','����05 �������Դϴ�.','t005',55,160000);


insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t006','����06','����06�Դϴ�.',to_date('2017-06-13','YYYY-MM-DD'),to_date('2017-06-20','YYYY-MM-DD'),'4','2','5','100',to_date('2017-05-11','YYYY-MM-DD'),'2','4','����06 �������Դϴ�.','t006',60,150000);


insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t007','����07','����07�Դϴ�.',to_date('2017-06-14','YYYY-MM-DD'),to_date('2017-06-22','YYYY-MM-DD'),'3','1','4','100',to_date('2017-05-13','YYYY-MM-DD'),'2','3','����07 �������Դϴ�.','t007',65,140000);

insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t008','����08','����08�Դϴ�.',to_date('2017-06-15','YYYY-MM-DD'),to_date('2017-06-24','YYYY-MM-DD'),'2','1','3','100',to_date('2017-05-15','YYYY-MM-DD'),'2','2','����08 �������Դϴ�.','t008',70,130000);

insert 
into tbl_ticket (tno,title,summary,sdate,edate,location,tclass,genre,rtime,rdate,state,theme,content,poster,tcount,tprice)
values('t005','����05','����05�Դϴ�.',to_date('2017-06-12','YYYY-MM-DD'),to_date('2017-06-18','YYYY-MM-DD'),'5','4','1','100',to_date('2017-05-09','YYYY-MM-DD'),'1','3','����05 �������Դϴ�.','t005',55,160000);
t002,����02,����02�Դϴ�.,42895,42898,2,2,4,100,42858,1,2,����02 �������Դϴ�.,t002,40,190000


t003,����03,����03�Դϴ�.,42896,42900,3,3,3,100,42860,1,3,����03 �������Դϴ�.,t003,45,180000

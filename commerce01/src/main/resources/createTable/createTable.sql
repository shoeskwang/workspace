create table tbl_board(
bno number not null,              -- �Խù� ��ȣ
title varchar2(200) not null,     -- ����
content varchar2(4000),           -- ����
writer varchar2(50) not null,     -- �̸�
regdate date default sysdate,     -- �ۼ�����  
viewcnt number default 0,         -- ��ȸ��
primary key(bno)                  -- �⺻Ű ����
);

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

-- mysql��

create table member(
	user_id VARCHAR(20) NOT NULL PRIMARY KEY,
	user_pw VARCHAR(20) NOT NULL,
	user_name VARCHAR(20) NOT NULL,
	user_email VARCHAR(40) NOT NULL,
	user_regdate DATE NOT NULL
);

create table tbl_board(
	bno INT NOT NULL PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	content TEXT NOT NULL,
	writer VARCHAR(30) NOT NULL,
	regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
	viewcnt INT DEFAULT '0'
);

create table date_test(
	id VARCHAR(30) NOT NULL PRIMARY KEY,
	regdate DATETIME DEFAULT CURRENT_TIMESTAMP
);



--���� ������
insert into tbl_board (bno,title,content,writer) values (3,'title3','content�Դϴ�3','kwang33');

-- reply
create table tbl_reply(
	rno INT NOT NULL PRIMARY KEY,
	bno INT NOT NULL,
	replytext VARCHAR(50) NOT NULL,
	replyer VARCHAR(50) NOT NULL,
	user_name VARCHAR(50) NOT NULL,
	regdate DATETIME DEFAULT CURRENT_TIMESTAMP
);

create table tbl_reply(
rno number not null,     
bno number not null,              
replytext varchar2(200) not null, 
replyer varchar2(200) not null,
regdate date default sysdate,       
secret_reply varchar2(20),
primary key(rno)                 
);

CREATE SEQUENCE ..  -- reply_seq �� ����ϱ����� �ʿ���

SELECT reply_seq.CURRVAL FROM DUAL;

INSERT INTO tbl_reply (rno, bno, replytext, replyer, secret_reply)
		VALUES (reply_seq.NEXTVAL, 18, '2222', 'lee', 'y')
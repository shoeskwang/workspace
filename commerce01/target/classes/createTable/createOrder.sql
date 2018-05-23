-- oracle ��
create table tbl_member(
	user_id varchar2(20) not null,
	user_pw varchar2(20) not null,
	user_name varchar2(20) not null,
	user_email varchar2(50) not null,
	user_regdate date default sysdate,
	primary key(user_id)
);

create table tbl_cart(
	cart_id NUMBER not null,
	user_id varchar2(20) not null,
	tno varchar2(20) not null,
	amount NUMBER DEFAULT 1,
	primary key(cart_id)
);


create table tbl_order(
	order_id NUMBER not null,
	user_id varchar2(20) not null,
	tno varchar2(20) not null,
	amount NUMBER DEFAULT 1,
	order_state varchar2(20) not null,
	primary key(order_id)
);



CREATE SEQUENCE seq_cart START WITH 10 INCREMENT BY 1;
CREATE SEQUENCE seq_order START WITH 1000 INCREMENT BY 1;


-- �ܷ�Ű ���� ( ������ ���� )
ALTER TABLE tbl_cart ADD CONSTRAINT cart_userid_fk FOREIGN KEY(user_id) REFERENCES tbl_member(user_id);
ALTER TABLE tbl_cart ADD CONSTRAINT cart_ticket_fk FOREIGN KEY(tno) REFERENCES tbl_ticket(tno);
COMMIT;

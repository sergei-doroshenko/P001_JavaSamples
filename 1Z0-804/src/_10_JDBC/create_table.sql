create table contact (
	id int not null auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30),
	email varchar(30),
	phone_no varchar(30),
	primary key(id)
);
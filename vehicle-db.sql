-- Creating database and tables

create database vehicle_db;
use vehicle_db;
create table user(
	u_id varchar(20) primary key, 
	u_name varchar(30), 
    pass varchar(40), 
    ph_no real, 
    address varchar(50), 
    u_role varchar(10)
);
create table brand(
	b_id int primary key,
    b_name varchar(30) 
);
create table category( 
	c_id int primary key, 
    c_type varchar(100)
);	
create table vehicle( 
	v_no varchar(20) primary key, 
    v_category int, 
    v_brand int, 
    v_year varchar(20), 
    v_price int, 
    v_insurance bool, 
    v_condition int, 
    u_status varchar(20),
    foreign key(v_brand) references brand(b_id) on delete cascade,
    foreign key(v_category) references category(c_id) on delete cascade
);
create table sold (
	v_no varchar(20),
    u_id varchar(20),
    time varchar(30),
    price int,
    primary key(v_no, u_id),
    foreign key(v_no) references vehicle(v_no) on delete cascade,
    foreign key(u_id) references user(u_id) on delete cascade
);

create table bought (
	v_no varchar(20),
    u_id varchar(20),
    time varchar(30),
    primary key(v_no, u_id),
    foreign key(v_no) references vehicle(v_no) on delete cascade,
    foreign key(u_id) references user(u_id) on delete cascade
);


-- Inserting (default) values into tables

insert into user values('admin', 'Manish Choudhary O', 'admin', 9880929175, 'hebbal', 'admin');
insert into user values('mani2001', 'Manish  O', 'manish1', 9880929175, 'hebbal', 'user');
insert into user values('mani2002', 'Choudhary O', 'manish2', 9880929175, 'hebbal', 'user');
insert into user values('mani2003', ' O', 'manish3', 9880929175, 'hebbal', 'user');

insert into brand values( 1, 'Honda' );
insert into brand values( 2, 'Hero' );
insert into brand values( 3, 'Tvs' );
insert into brand values( 4, 'Enfield' );
insert into brand values( 5, 'Bajaj' );
insert into brand values( 6, 'Suzuki' );

insert into category values( 2, 'Two Wheeler');
insert into category values( 3, 'Three Wheeler');
insert into category values( 4, 'Four Wheeler');
insert into category values( 6, 'Six Wheeler');

insert into vehicle values('KA-55-9343', 2, 2,  '2016', 30000, 1, 3.5, 'ok');
insert into vehicle values('KA-57-9343', 3, 3,  '2017', 31000, 1, 3.7, 'pending');
insert into vehicle values('KA-59-9343', 4, 5,  '2010', 50000, 1, 3.3, 'ok');
insert into vehicle values('KA-52-9343', 6, 1,  '2015', 23000, 1, 4.9, 'ok');
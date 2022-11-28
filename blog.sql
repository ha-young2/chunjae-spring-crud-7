drop table if exists blog;
create table blog (
	id integer auto_increment,
	title varchar(500),
	contents mediumtext,
	created timestamp default current_timestamp(),
	updated timestamp default current_timestamp() on update current_timestamp(),
	primary key(id)
);

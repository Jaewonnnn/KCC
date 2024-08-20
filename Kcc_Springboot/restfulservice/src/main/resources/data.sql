insert into users(id, name, join_date, password, ssn) values(9001, 'kim', now(), 'pass1', '123456-1234567');
insert into users(id, name, join_date, password, ssn) values(9002, 'park', now(), 'pass1', '123456-1234567');
insert into users(id, name, join_date, password, ssn) values(9003, 'lee', now(), 'pass1', '123456-1234567');

insert into post(description, user_id) values('My first post', 9001);
insert into post(description, user_id) values('My second post', 9001);
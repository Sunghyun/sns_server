create table files(
num number primary key,
id varchar(20),
fid varchar(500),
loc varchar(500)
);

create sequence file_seq
increment by 1
start with 1
maxvalue 9999;

delete table files;

drop table files;
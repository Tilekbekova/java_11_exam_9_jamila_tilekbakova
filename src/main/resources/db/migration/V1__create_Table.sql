
create table status_table (id  bigserial not null, status varchar(255), primary key (id));


CREATE TABLE user_table (
                            id bigserial NOT NULL,
                            email varchar(128) NOT NULL,
                            password varchar(128) NOT NULL,
                            fullname varchar(128) NOT NULL default ' ',
                            enabled boolean NOT NULL default true,
                            role varchar(16) NOT NULL,
                            primary key (id));
create UNIQUE index email_unique on user_table(email ASC);



create table task_table (id  bigserial not null,
                         name varchar(255),
                         date_add date,
                         user_id int8,
                         status_id int8,
                         primary key (id));

alter table task_table add constraint status_fk foreign key (status_id) references status_table on delete cascade;
alter table task_table add constraint user_fk foreign key (user_id) references user_table on delete cascade;


create table workloqs_table (id  bigserial not null,
                             description varchar(255),
                             date_add date,
                             task_id int8,
                             primary key (id));

alter table workloqs_table add constraint task_fk foreign key (task_id) references task_table on delete cascade;
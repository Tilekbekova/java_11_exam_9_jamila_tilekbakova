create table workloqs_table (id  bigserial not null,
                             description varchar(255),
                             date_add time,
                             task_id int8,
                             primary key (id));

alter table workloqs_table add constraint task_fk foreign key (task_id) references task_table on delete cascade;
drop table if exists task;

create sequence todo_id_seq start 10001;

create table task
(
    id          integer not null DEFAULT nextval('todo_id_seq'),
    due_date    date,
    name        varchar(255),
    task_status integer,
    primary key (id)
);

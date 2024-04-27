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

--insert into task
--(due_date, name, task_status)
--values
--('2021-01-01','task 1',1),
--('2021-01-02','task 2',2),
--('2021-01-03','task 3',3);

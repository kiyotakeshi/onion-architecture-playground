create sequence hibernate_sequence start with 1000 increment by 1;

create table task
(
    id          integer not null,
    due_date    date,
    name        varchar(255),
    task_status integer,
    primary key (id)
);

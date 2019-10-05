create table newton_invest.newton_employees
(
    id         int auto_increment
        primary key,
    firstname  varchar(30) null,
    lastname   varchar(30) null,
    gender     varchar(20) null,
    email      varchar(60) null,
    position   varchar(40) null,
    updated_at date        null,
    phone_no   int         null
);




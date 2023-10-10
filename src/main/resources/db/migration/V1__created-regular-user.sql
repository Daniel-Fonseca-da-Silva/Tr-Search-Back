create table regular_users (
        id uuid not null,
        cellphone varchar(20),
        created_at TIMESTAMP,
        documentation varchar(15) not null,
        email varchar(100) not null,
        name varchar(100) not null,
        last_login TIMESTAMP,
        password varchar(255) not null,
        photo varchar(255),
        roles varchar(255),
        status boolean not null,
        updated_at TIMESTAMP,
        birthday TIMESTAMP,
        gender varchar(20) not null check (gender in ('MASCULINE','FEMININE','OTHER')),
        primary key (id)
)

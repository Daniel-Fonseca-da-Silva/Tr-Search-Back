create table corporate_users (
        id uuid not null,
        cellphone varchar(20),
        created_at TIMESTAMP,
        documentation varchar(15) not null,
        email varchar(100) not null,
        first_name varchar(100) not null,
        last_login TIMESTAMP,
        last_name varchar(100) not null,
        password varchar(100) not null,
        photo varchar(255),
        roles varchar(255),
        status boolean not null,
        updated_at TIMESTAMP,
        premium varchar(20) not null check (premium in ('SIMPLE','BRONZE','SILVER','GOLD')),
        telephone varchar(15),
        primary key (id)
    )

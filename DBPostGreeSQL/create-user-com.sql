CREATE TABLE user_com(
	id SERIAL PRIMARY KEY,
    name_com VARCHAR(40) NOT NULL,
    surname_com VARCHAR(40) NOT NULL,
    birthday_com DATE NOT NULL,
    cpf_com CHAR(15) NOT NULL,
    gender_com CHAR(2) NOT NULL,
    login_com VARCHAR(12) NOT NULL,
    email_com VARCHAR(100) NOT NULL,
	password_com VARCHAR(12) NOT NULL
);

ALTER TABLE user_com
ADD CONSTRAINT constraint_name UNIQUE (cpf_com, login_com, password_com);

SELECT * FROM user_com;


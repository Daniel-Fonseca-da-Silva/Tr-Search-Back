CREATE TABLE userCommon(
	id SERIAL PRIMARY KEY,
    name_com VARCHAR(20) NOT NULL,
    surname_com VARCHAR(20) NOT NULL,
    birthday_com DATE NOT NULL,
    cpf_com VARCHAR(15) NOT NULL,
    gender_com CHAR(2) NOT NULL,
    login_com VARCHAR(20) NOT NULL,
    email_com VARCHAR(40) NOT NULL,
	password_com VARCHAR(12) NOT NULL
);

SELECT * FROM user_common;


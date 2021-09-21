CREATE TABLE user_corp(
	id SERIAL PRIMARY KEY,
    name_corp VARCHAR(40) NOT NULL,
    cnpj_corp VARCHAR(20) NOT NULL,
    login_corp VARCHAR(20) NOT NULL,
    email_corp VARCHAR(50) NOT NULL,
    password_corp CHAR(12) NOT NULL
);

SELECT * FROM user_corp;


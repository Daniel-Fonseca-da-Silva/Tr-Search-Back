CREATE TABLE user_corp(
	id SERIAL PRIMARY KEY,
        cnpj_corp CHAR(20) NOT NULL,
        email_corp VARCHAR(100) NOT NULL,
        login_corp VARCHAR(12) NOT NULL,
        name_corp VARCHAR(40) NOT NULL,
        password_corp VARCHAR(12) NOT NULL
);

ALTER TABLE user_corp
ADD CONSTRAINT constraint_name UNIQUE (cnpj_corp, email_corp, login_corp, name_corp, password_corp);

SELECT * FROM user_corp;


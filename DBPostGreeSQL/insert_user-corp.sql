INSERT INTO user_corp(
	name_corp,
	cnpj_corp,
	login_corp,
	email_corp,
	password_corp
) 
VALUES
(
    'Levi e Benício Marcenaria ME',
    '39.219.520/0001-25',
    'admin',
		'cceciliamayapeixoto@amure.com.br',
    '$2a$10$1OgWngg4nAEnjcaY1tTMwOh7R4fGZVRMMyqR1LQzDYUZc2yV.7UYi'
);

SELECT * FROM user_corp;

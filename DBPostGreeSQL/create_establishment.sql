CREATE TABLE establishment(
	id SERIAL PRIMARY KEY,
    name_est VARCHAR(40) NOT NULL,
    site_est VARCHAR(60),
    address_est VARCHAR(60) NOT NULL,
    number_est VARCHAR(10) NOT NULL,
    cep_est VARCHAR(10) NOT NULL,
	email_est VARCHAR(40),
	tel_est VARCHAR(15),
	cel_est VARCHAR(16),
	district_est VARCHAR(40) NOT NULL,
	city_est VARCHAR(30) NOT NULL,
	state_est VARCHAR(20) NOT NULL,
	category_est VARCHAR(30) NOT NULL,
	img_url_est VARCHAR(255),
	description TEXT NOT NULL,
	data_insert DATE DEFAULT CURRENT_DATE
);

SELECT * FROM establishment;


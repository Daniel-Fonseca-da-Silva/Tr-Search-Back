CREATE TABLE establishment(
	id SERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    site VARCHAR(60),
    address VARCHAR(60) NOT NULL,
    number VARCHAR(10) NOT NULL,
    cep CHAR(10) NOT NULL,
	email VARCHAR(100),
	tel VARCHAR(14),
	cel VARCHAR(14),
	district VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state CHAR(2) NOT NULL,
	category VARCHAR(50) NOT NULL,
	imgurl VARCHAR(255) NOT NULL,
	description TEXT(300) NOT NULL,
	score FLOAT8,
	actived BOOLEAN DEFAULT FALSE,
	datainsert DATE DEFAULT CURRENT_DATE
);


CREATE TABLE establishment(
	id SERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    site VARCHAR(60),
    address VARCHAR(60) NOT NULL,
    numberr VARCHAR(10) NOT NULL,
    cep CHAR(10) NOT NULL,
	email VARCHAR(100),
	tel VARCHAR(15),
	cel VARCHAR(15),
	district VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state CHAR(2) NOT NULL,
	category VARCHAR(50) NOT NULL,
	imgurl VARCHAR(255) NOT NULL,
	description VARCHAR(300) NOT NULL,
	score FLOAT8,
	actived BOOLEAN NOT NULL,
	dataest DATE NOT NULL
);


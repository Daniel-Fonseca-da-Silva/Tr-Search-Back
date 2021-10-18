INSERT INTO establishment(
    name,
    site,
    address,
    numberr,
    cep,
	email,
	tel,
	cel,
	district,
	city,
	state,
	category,
	imgurl,
	description,
	score
) 
VALUES
(
	'José e Mariana Restaurante ME',
	'www.joseemarianarestauranteme.com.br',
	'Rua do Planetas',
	'465',
	'06702-260',
	'estoque@joseemarianarestauranteme.com.br',
	'(11)3913-7551',
	'(11)99701-1502',
	'Residencial Palma de Maiorca',
	'Cotia',
	'sp',
	'Lanchonete',
	'https://cdn.pixabay.com/photo/2015/04/20/13/30/kitchen-731351_960_720.jpg',
	'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.',
	100
);

SELECT * FROM establishment;


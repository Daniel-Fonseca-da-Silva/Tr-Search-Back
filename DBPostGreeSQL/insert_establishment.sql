INSERT INTO establishment(
    name_est,
    site_est,
    address_est,
    number_est,
    cep_est,
	email_est,
	tel_est,
	cel_est,
	district_est,
	city_est,
	state_est,
	category_est,
	img_url_est,
	description
) 
VALUES
(
	'José e Mariana Restaurante ME',
	'www.joseemarianarestauranteme.com.br',
	'Rua do Planetas',
	'465',
	'06702-260',
	'estoque@joseemarianarestauranteme.com.br',
	'(11) 3913-7551',
	'(11) 99701-1502',
	'Residencial Palma de Maiorca',
	'Cotia',
	'São Paulo',
	'Lanchonete',
	'https://cdn.pixabay.com/photo/2015/04/20/13/30/kitchen-731351_960_720.jpg',
	'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
);

SELECT * FROM establishment;


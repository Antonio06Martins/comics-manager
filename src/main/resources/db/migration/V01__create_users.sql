CREATE TABLE users (
	code BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(35) NOT NULL,
	cpf VARCHAR(20) NOT NULL,
	birth_date DATE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO users (name, email, cpf, birth_date) values ('Antonio Martins', 'antonio.martins@email.com', '06432684994', '1988-10-06');

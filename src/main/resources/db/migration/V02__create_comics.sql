CREATE TABLE comics (
	code_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	comic_id BIGINT NOT NULL,
	title VARCHAR(50) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	authors VARCHAR(50) NOT NULL,
	isbn VARCHAR(50) NOT NULL,
	description VARCHAR(100) NOT NULL,
	discount_day VARCHAR(50) NOT NULL,
	active_discount BOOLEAN NOT NULL,
	code_users BIGINT NOT NULL,
    FOREIGN KEY (code_users) REFERENCES users(code)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO comics (comic_id, title, price, authors, isbn, description, discount_day, active_discount, code_users) values (1, 'title', 25, 'authors', 'isbn', 'description', 'discount_day', true, 1);
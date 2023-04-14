CREATE TABLE products(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    price double NOT NULL,
    cart_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (cart_id) REFERENCES carts(id));


CREATE TABLE carts(
    id int NOT NULL AUTO_INCREMENT,
       PRIMARY KEY (id));
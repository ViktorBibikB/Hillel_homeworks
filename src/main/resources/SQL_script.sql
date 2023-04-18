create table t_orders(
order_id bigint not null auto_increment,
order_date datetime not null,
cost double not null,
primary key (order_id));

create table t_products(
product_id bigint not null auto_increment,
name varchar(250) not null,
cost double not null,
order_id bigint,
primary key (product_id),
foreign key (order_id) references t_orders(order_id));
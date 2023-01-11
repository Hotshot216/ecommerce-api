INSERT INTO product (code, name, price) values ('HOME111','Bed',150.00);
INSERT INTO product (code, name, price) values ('HOME222','Table',50.00);
INSERT INTO product (code, name, price) values ('TECH111','Laptop',650.00);
INSERT INTO product (code, name, price) values ('TECH222','Keyboard',130.00);
INSERT INTO product (code, name, price) values ('HOME333','Lamp',20.00);
INSERT INTO product (code, name, price) values ('GAME111','Chessboard',14.99);
INSERT INTO product (code, name, price) values ('TECH333','Headphones',79.99);
INSERT INTO product (code, name, price) values ('OUT111','Skateboard',80.00);
INSERT INTO product (code, name, price) values ('HOME444','Mug',8.00);
INSERT INTO product (code, name, price) values ('OFFICE111','Pen',2.50);

INSERT INTO client (first_name, last_name, address, email, nif) values('Bruno','Simões','Rua Teste','teste@email.com','123456789');

INSERT INTO order_table (delivery_date, initial_date, order_price, client_id) values ('2001-05-12', '1999-02-12', 212.00, 1);


INSERT INTO order_item (order_item_price, product_id, product_name, quantity, order_id) values (2000.00, 1, 'Test',2,1);
INSERT INTO order_item (order_item_price, product_id, product_name, quantity, order_id) values (5020.10, 3, 'sdasda',3,1);


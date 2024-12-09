insert into usuario(email,username,password,rol) values ('alejandrobp2004@gmail.com','jandro','$2a$12$PYUpifu7G2NfFE3peSoy7OIywY4fytGKHcJHoGidtfQYV1lJjwqTW','ADMIN');
insert into usuario(email,username,password,rol) values ('maribalo043@gmail.com','mario','$2a$12$ZNJVVpCuZHLMgSMPRoMa1eJSajHEyWTfBUEw6VEQVOhmo0O/TScG6','USER');
insert into usuario(email,username,password,rol) values ('fifaplj2003@gmail.com','pablo','$2a$12$qGNAI1N4UIF4.GYLCsxGMOrWpzIfTQUdIpEBM9pxfxLmg41/GeF.W','USER');
insert into usuario(email,username,password,rol) values ('luisfelguera9@gmail.com','luis','$2a$12$EaTPCG3PUhoozm1ImcB.bevHXZEsWzdFvqqx3SAHDLWOgTRHRKSdO','USER');
insert into usuario(email,username,password,rol) values ('luisguera9@gmail.com','luis2','$2a$12$EaTPCG3PUhoozm1ImcB.bevHXZEsWzdFvqqx3SAHDLWOgTRHRKSdO','USER');

INSERT INTO vendedor(nombre,telefono,logo,info,usuario_id) values ('HOLA',1,'HOLA','HOLA',3);
INSERT INTO vendedor(nombre,telefono,logo,info,usuario_id) values ('HOLA_1',1,'HOLA_1','HOLA_1',5);
INSERT INTO vendedor(nombre,telefono,logo,info,usuario_id) values ('HOLA_2',1,'HOLA_2','HOLA_2',4);


INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba','prueba','prueba',0.99,'prueba',1);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba1','prueba1','prueba1',2.99,'prueba1',1);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba2','prueba2','prueba2',0.50,'prueba2',2);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba3','prueba3','prueba3',1.00,'prueba3',2);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba4','prueba4','prueba4',4.49,'prueba4',3);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba5','prueba5','prueba5',0.10,'prueba5',1);

INSERT INTO cliente(nombre,usuario_id) VALUES ('chus',2);
INSERT INTO cliente(nombre,usuario_id) VALUES ('gordi',1);

INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('2024-12-10', 'C/ Prueba - nº1 - 1A', 1);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('2024-12-12', 'C/ Prueba1 - nº11 - 2B', 2);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('2024-12-14', 'C/ Prueba2 - nº111 - 3C', 1);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('2024-12-13', 'C/ Prueba3 - nº1111 - 4D', 1);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('2024-12-15', 'C/ Prueba4 - nº11111 - 5E', 2);

INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (1, 1, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (1, 2, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (1, 3, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (1, 4, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (2, 1, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (2, 3, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (3, 5, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (3, 1, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (4, 1, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (4, 2, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (4, 3, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (4, 4, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (4, 5, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (5, 1, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (5, 2, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (5, 3, 1);
INSERT INTO contiene(pedido_id, producto_id, cantidad) VALUES (5, 4, 1);



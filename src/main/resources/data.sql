INSERT INTO vendedor(nombre,correo_electronico,contrasenia,telefono,logo,info) values ('HOLA','HOLA','HOLA',1,'HOLA','HOLA');
INSERT INTO vendedor(nombre,correo_electronico,contrasenia,telefono,logo,info) values ('HOLA_1','HOLA_1','HOLA_1',1,'HOLA_1','HOLA_1');
INSERT INTO vendedor(nombre,correo_electronico,contrasenia,telefono,logo,info) values ('HOLA_2','HOLA_2','HOLA_2',1,'HOLA_2','HOLA_2');


INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba','prueba','prueba',0.99,'prueba',1);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba1','prueba1','prueba1',2.99,'prueba1',1);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba2','prueba2','prueba2',0.50,'prueba2',2);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba3','prueba3','prueba3',1.00,'prueba3',2);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba4','prueba4','prueba4',4.49,'prueba4',3);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba5','prueba5','prueba5',0.10,'prueba5',1);

INSERT INTO cliente(nombre,correo_electronico,contrasenia) VALUES ('chus','monomacaco@chus.com','1234');
INSERT INTO cliente(nombre,correo_electronico,contrasenia) VALUES ('gordi','obesobola@gordi.com','5678');

INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('01/01/2001', 'C/ Prueba - nº1 - 1A', 1);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('02/02/2002', 'C/ Prueba1 - nº11 - 2B', 2);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('03/03/2003', 'C/ Prueba2 - nº111 - 3C', 1);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('04/04/2004', 'C/ Prueba3 - nº1111 - 4D', 1);
INSERT INTO pedido(fecha_realizado, direccion, FK_CLIENTE) VALUES ('05/05/2005', 'C/ Prueba4 - nº11111 - 5E', 2);

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



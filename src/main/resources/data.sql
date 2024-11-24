INSERT INTO vendedor(nombre,correo_electronico,contrasenia,logo,telefono,info) values ('HOLA','HOLA','HOLA','HOLA',0,'HOLA');
INSERT INTO vendedor(nombre,correo_electronico,contrasenia,logo,telefono,info) values ('HOLA_1','HOLA_1','HOLA_1','HOLA_1',1,'HOLA_1');
INSERT INTO vendedor(nombre,correo_electronico,contrasenia,logo,telefono,info) values ('HOLA_2','HOLA_2','HOLA_2','HOLA_2',2,'HOLA_2');


INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba','prueba','prueba',0.99,'prueba',1);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba1','prueba1','prueba1',2.99,'prueba1',1);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba2','prueba2','prueba2',0.50,'prueba2',2);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba3','prueba3','prueba3',1.00,'prueba3',2);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba4','prueba4','prueba4',4.49,'prueba4',3);
INSERT INTO producto(nombre,descripcion,color,precio,imagen,FK_VENDEDOR) VALUES ('prueba5','prueba5','prueba5',0.10,'prueba5',1);

INSERT INTO cliente(nombre,telefono,correo_electronico,contrasenia) VALUES ('chus',666666666,'monomacaco@chus.com','1234')

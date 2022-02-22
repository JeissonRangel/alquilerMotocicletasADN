create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table motocicleta (
 id int(10) not null auto_increment,
 nombre varchar(20),
 valorMotocicleta DOUBLE,
 anioModelo varchar(4),
 disponible BOOLEAN,
 primary key (id)
);

create table alquiler (
 id int(10) not null auto_increment,
 personaId int(10) not null,
 motocicletaID int(20) not null,
 cantidadDiasAlquiler int(2) not null,
 fechaDevolucion datetime null,
 planeaSalirDeLaCiudad BOOLEAN,
 planeaLlevarParrillero BOOLEAN,
 primary key (id)
);

create table factura (
 id int(10) not null auto_increment,
 idAlquiler int(10) not null,
 valorTotal int(10) not null,
 seguroVehiculo int(10) not null,
 polizaPersonal int(10) not null,
 fechaCompra datetime null,
 primary key (id)
);


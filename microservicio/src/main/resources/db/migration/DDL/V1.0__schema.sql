create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
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

create table motocicleta (
 id int(10) not null auto_increment,
 valorMotocicleta DOUBLE,
 anioModelo varchar(4),
 disponible BOOLEAN,
 primary key (id)
);
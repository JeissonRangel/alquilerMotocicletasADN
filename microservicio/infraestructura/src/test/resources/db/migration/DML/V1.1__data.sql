insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());

insert into motocicleta(id,nombre,valorMotocicleta,anioModelo,disponible)
values(1,'YAMAHA R1M',1000,2020,true);

insert into alquiler(id,personaId,motocicletaId,cantidadDiasAlquiler,fechaDevolucion,planeaSalirDeLaCiudad,planeaLlevarParrillero)
values(1,1,1,10,null,true,true);

insert into factura(id, idAlquiler, valorTotal, seguroVehiculo, polizaPersonal, fechaCompra)
values (1,1,1000,200,300,now())
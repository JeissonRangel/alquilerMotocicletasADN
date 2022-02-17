select a.id, a.personaId, a.motocicletaId, a.cantidadDiasAlquiler, a.fechaDevolucion,
a.planeaSalirDeLaCiudad, a.planeaLlevarParrillero
from alquiler a
where a.id = :id
select top 1 id, nombre, valorMotocicleta, anioModelo, disponible
from motocicleta
where disponible = :disponible;
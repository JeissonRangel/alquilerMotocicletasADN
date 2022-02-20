select top 1 id, valorMotocicleta, anioModelo, disponible
from motocicleta
where disponible = :disponible;
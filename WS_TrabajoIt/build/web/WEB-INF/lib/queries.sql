-- Obtener el listado de ejercicios
SELECT id, nombre, descripcion FROM ejercicios;

-- Obtener los registros para un ejercicio concreto obtienendo algunos detalles sobre el o la atleta 
SELECT r.idAtleta, a.edad, a.genero, r.peso, r.fecha FROM registros r INNER JOIN atletas a ON r.idAtleta = a.id WHERE r.idEjercicio = 1;

-- Obtener los registros asociados a un o una atleta, incluyendo el nombre del ejercicio
SELECT e.nombre, r.peso, r.fecha FROM registros r INNER JOIN ejercicios e ON r.idEjercicio = e.id WHERE r.idAtleta = 1;

-- Obtener todos los registros del histórico filtrando por atleta y ejercicio
SELECT r.idAtleta, r.idEjercicio, r.fecha, r.peso FROM registros r WHERE r.idAtleta = 1 AND r.idEjercicio = 1;

-- Crear la base de datos y seleccionarla par ser usada de aquí en adelante
CREATE DATABASE halterofilia;
USE halterofilia;

-- Tabla de Ejercicios (Diccionario de Movimientos de Halterofilia)
CREATE TABLE ejercicios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL
);

-- Tabla de Atletas
CREATE TABLE atletas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    edad INT NOT NULL,
    altura INT NOT NULL,
    peso DECIMAL(5,2) NOT NULL,
    genero ENUM('M', 'F', 'Otro') NOT NULL
);

-- Tabla de Registros de Levantamiento
CREATE TABLE registros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idAtleta INT NOT NULL,
    idEjercicio INT NOT NULL,
    fecha DATE NOT NULL,
    peso DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (idAtleta) REFERENCES atletas(id) ON DELETE CASCADE,
    FOREIGN KEY (idEjercicio) REFERENCES ejercicios(id) ON DELETE CASCADE
);

-- Insertar Ejercicios
INSERT INTO ejercicios (nombre, descripcion) VALUES
('Deadlift', 'Peso muerto convencional, base del levantamiento con barra'),
('Back Squat', 'Sentadilla con barra en la espalda'),
('Front Squat', 'Sentadilla con barra en el frente'),
('Push Press', 'Press de hombros con impulso de piernas'),
('Thruster', 'Sentadilla frontal seguida de press de hombros'),
('Power Clean', 'Cargada hasta rack position sin hacer sentadilla profunda'),
('Squat Clean', 'Cargada con sentadilla completa antes de recibir la barra'),
('Overhead Squat', 'Sentadilla con barra sobre la cabeza'),
('Snatch', 'Arrancada olímpica en un solo movimiento'),
('Clean & Jerk', 'Cargada y envión (Squat Clean + Jerk), movimiento completo de halterofilia'),
('Cluster', 'Cargada más un Thruster (Squat Clean + Thruster)');

-- Insertar Atletas
INSERT INTO atletas (edad, altura, peso, genero) VALUES
(28, 175, 78.5, 'M'),
(25, 165, 62.3, 'F'),
(35, 182, 85.2, 'M'),
(30, 160, 55.7, 'F'),
(22, 170, 67.0, 'F'),
(40, 180, 90.1, 'M'),
(27, 168, 73.5, 'F'),
(33, 176, 82.4, 'M');

-- Insertar Registros de Levantamientos
INSERT INTO registros (idAtleta, idEjercicio, fecha, peso) VALUES
(1, 1, '2024-02-01', 140.00),
(1, 4, '2024-01-15', 180.00),
(2, 2, '2024-02-10', 85.00),
(2, 5, '2024-02-20', 50.00),
(3, 6, '2024-03-05', 110.00),
(3, 7, '2024-03-12', 95.00),
(4, 3, '2024-03-15', 60.00),
(4, 8, '2024-03-18', 100.00),
(5, 9, '2024-03-25', 70.00),
(5, 10, '2024-03-28', 90.00),
(6, 1, '2024-04-02', 130.00),
(6, 3, '2024-04-06', 80.00),
(6, 5, '2024-04-10', 55.00),
(7, 2, '2024-04-12', 100.00),
(7, 4, '2024-04-15', 190.00),
(8, 6, '2024-04-20', 120.00),
(8, 7, '2024-04-22', 105.00),
(8, 9, '2024-04-24', 85.00),
(1, 10, '2024-04-26', 95.00),
(2, 1, '2024-04-28', 135.00),
(3, 3, '2024-04-30', 75.00),
(4, 5, '2024-05-02', 65.00),
(5, 7, '2024-05-04', 110.00),
(6, 9, '2024-05-06', 80.00),
(7, 10, '2024-05-08', 100.00),
(8, 2, '2024-05-10', 105.00),
(1, 4, '2024-05-12', 175.00),
(2, 6, '2024-05-14', 115.00),
(3, 8, '2024-05-16', 95.00),
(4, 9, '2024-05-18', 78.00);

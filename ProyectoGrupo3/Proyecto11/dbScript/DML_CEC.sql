-- database: ../database/dbCEC.sqlite

INSERT INTO NivelIngles(Nivel) VALUES
    ('Básico 1'),
    ('Básico 2'),
    ('Intermedio 1'),
    ('Intermedio 2'),
    ('Avanzado 1'),
    ('Avanzado 2'),
    ('Academico 1'),
    ('Academico 2'),
    ('Academico 3'),
    ('Academico 4');

INSERT INTO Ciclo(Ciclo,FechaInicio,FechaFin) VALUES
    ('Ciclo 1-2025','14/01/2025','14/03/2025'),
    ('Ciclo 2-2025','25/03/2025','20/05/2025'),
    ('Ciclo 3-2025','03/06/2025','28/07/2025'),
    ('Ciclo 4-2025','13/08/2025','07/10/2025'),
    ('Ciclo 5-2025','21/10/2026','15/12/2026'),
    ('Ciclo 1-2026','13/01/2027','11/03/2027');

INSERT INTO Estudiante(IdNivelIngles,IdCiclo,Cedula,Nombre,Apellido,Usuario,Clave) VALUES
    (1,1,'1727200355','Juan','Perez','1727200355JuanPerez','1234'),
    (2,1,'1727200356','Maria','Garcia','1727200356MariaGarcia','1234');

INSERT INTO Factura(IdEstudiante,NumeroFactura) VALUES
    (1,'001-100-00317616'),
    (2,'001-100-00317617');

INSERT INTO Foto (IdEstudiante, PathFoto, Estado, FechaCreacion, FechaModifica) VALUES
    (1, 'Proyecto11\database\Fotobl\Foto1727200355JuanPerez.jpg', 'A', datetime('now','localtime'), datetime('now','localtime')),
    (2, 'Proyecto11\database\Fotobl\Foto1727200356MariaGarcia.jpg', 'A', datetime('now','localtime'), datetime('now','localtime'));


SELECT  E.IdEstudiante,
        Nl.Nivel,
        Cl.Ciclo,
        E.Cedula,
        E.Nombre,
        E.Apellido,
        E.Usuario,
        E.Clave
FROM Estudiante AS E
JOIN Ciclo  AS Cl ON Cl.IdCiclo = E.IdCiclo
JOIN NivelIngles  AS Nl ON Nl.IdNivelIngles = E.IdNivelIngles;
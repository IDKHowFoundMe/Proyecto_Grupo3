-- database: ../database/dbCEC.sqlite

DROP TABLE IF EXISTS NivelIngles;
DROP TABLE IF EXISTS Ciclo;
DROP TABLE IF EXISTS Estudiante;
DROP TABLE IF EXISTS Factura;
DROP TABLE IF EXISTS Foto;

CREATE TABLE NivelIngles (
    IdNivelIngles INTEGER PRIMARY KEY AUTOINCREMENT,
    Nivel VARCHAR(50) NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
    FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica  DATETIME DEFAULT(CURRENT_DATE)
);

CREATE TABLE Ciclo (
    IdCiclo INTEGER PRIMARY KEY AUTOINCREMENT,
    Ciclo VARCHAR(30) NOT NULL,
    FechaInicio DATETIME,
    FechaFin DATETIME,
    Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
    FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica  DATETIME DEFAULT(CURRENT_DATE)
);
CREATE TABLE Estudiante (
    IdEstudiante INTEGER PRIMARY KEY AUTOINCREMENT,
    IdNivelIngles INTEGER NOT NULL REFERENCES NivelIngles (IdNivelIngles),
    IdCiclo INTEGER NOT NULL REFERENCES Ciclo (IdCiclo),
    Cedula VARCHAR(15) NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Apellido VARCHAR(30) NOT NULL,
    Usuario VARCHAR(30) NOT NULL,
    Clave VARCHAR(30) NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
    FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica  DATETIME DEFAULT(CURRENT_DATE)
);

CREATE TABLE Factura(
    IdFactura INTEGER PRIMARY KEY AUTOINCREMENT,
    IdEstudiante INTEGER NOT NULL REFERENCES Estudiante (IdEstudiante),
    NumeroFactura VARCHAR(20) NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
    FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime')),
    FechaModifica  DATETIME DEFAULT(CURRENT_DATE)
    );

CREATE TABLE Foto (
    IdFoto INTEGER PRIMARY KEY AUTOINCREMENT,
    IdEstudiante INTEGER NOT NULL REFERENCES Estudiante (IdEstudiante),
    PathFoto VARCHAR(255) NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
    FechaCreacion DATETIME NOT NULL DEFAULT (datetime('now','localtime')),
    FechaModifica DATETIME DEFAULT (CURRENT_DATE)
);
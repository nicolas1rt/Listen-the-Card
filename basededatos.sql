DROP DATABASE prueba;
CREATE DATABASE prueba;

create table nino(
correo VARCHAR(50) NOT NULL,
contrasena VARCHAR(50) NOT NULL,
nicname VARCHAR (20) NOT NULL,
saldo int NOT NULL,
avatar int NOT NULL,

CONSTRAINT pk_nino PRIMARY KEY  (correo)
);

CREATE TABLE avance(
  partida VARCHAR (50) NOT NULL,
  tiempo VARCHAR (50) NOT NULL,
  puntaje CHARACTER (20) NOT NULL,
  fecha SMALLINT NOT NULL,
  fk_nino_N VARCHAR(50) NOT NULL,

CONSTRAINT pk_avance PRIMARY KEY (partida),
CONSTRAINT fk_avance_nino FOREIGN KEY (fk_nino_N)
  REFERENCES nino (correo)
);
  
INSERT INTO nino
(correo, contrasena, nicname, saldo, avatar)
VALUES
('administrador1','123456','ADMI',999,1);

-- Creazione del database studentiDB
CREATE DATABASE IF NOT EXISTS studentiDB;

-- Utilizzo del database appena creato
USE studentiDB;

-- Creazione della tabella studenti
CREATE TABLE IF NOT EXISTS studenti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    utente VARCHAR(10) NOT NULL,
    password VARCHAR(8) NOT NULL
);

INSERT INTO studenti VALUES (1, 'Mario', 'Rossi', '1234567890', 'mario.rossi', 'password1');
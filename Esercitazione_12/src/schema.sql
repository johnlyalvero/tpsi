CREATE DATABASE IF NOT EXISTS azienda;
USE azienda;

CREATE TABLE IF NOT EXISTS dipendenti (
    nome VARCHAR(50),
    cognome VARCHAR(50),
    id INT PRIMARY KEY,
    eta INT,
    stipendio DOUBLE
);
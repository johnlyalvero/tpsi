CREATE DATABASE IF NOT EXISTS azienda;
USE azienda;

CREATE TABLE IF NOT EXISTS dipendenti (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    eta INT,
    stipendio DOUBLE
);

-- Esempio inserimento
-- INSERT INTO dipendenti (id, nome, cognome, eta, stipendio) 
-- VALUES (1, 'Mario', 'Rossi', 30, 3000.50);
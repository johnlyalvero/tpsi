-- Test script for schema.sql

-- Use the azienda database
USE azienda;

-- Test 1: Check if the database exists
SELECT SCHEMA_NAME 
FROM INFORMATION_SCHEMA.SCHEMATA 
WHERE SCHEMA_NAME = 'azienda';

-- Test 2: Check if the dipendenti table exists
SELECT TABLE_NAME 
FROM INFORMATION_SCHEMA.TABLES 
WHERE TABLE_SCHEMA = 'azienda' AND TABLE_NAME = 'dipendenti';

-- Test 3: Check the structure of the dipendenti table
DESCRIBE dipendenti;

-- Test 4: Insert a sample record into the dipendenti table
INSERT INTO dipendenti (id, nome, cognome, eta, stipendio) 
VALUES (1, 'Mario', 'Rossi', 30, 3000.50);

-- Test 5: Verify the inserted record
SELECT * FROM dipendenti WHERE id = 1;

-- Test 6: Clean up the test data
DELETE FROM dipendenti WHERE id = 1;
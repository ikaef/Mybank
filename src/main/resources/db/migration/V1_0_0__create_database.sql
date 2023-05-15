DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS compte;
DROP TABLE IF EXISTS client;


CREATE TABLE client
(
    id_client INTEGER PRIMARY KEY,
    prenom      VARCHAR(50),
    nom         VARCHAR(50)
);

CREATE TABLE compte
(
    numero_compte   INTEGER PRIMARY KEY,
    id_client VARCHAR(10) REFERENCES client (id_client),
    solde           DECIMAL(10, 2)
);

CREATE TABLE transaction
(
    id_transaction UUID PRIMARY KEY,
    operation VARCHAR (10),
    numero_compte   VARCHAR(10) REFERENCES compte(numero_compte),
    montant             DECIMAL(10, 2)
);

CREATE SEQUENCE my_sequence START WITH 5 INCREMENT BY 1;

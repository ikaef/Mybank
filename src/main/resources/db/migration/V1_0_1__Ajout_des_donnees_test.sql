INSERT INTO client (id_client, prenom, nom) VALUES ('1', 'Ibrahima', 'FALL');
INSERT INTO client (id_client, prenom, nom) VALUES ('2', 'Jean', 'Bon');
INSERT INTO client (id_client, prenom, nom) VALUES ('3', 'Al', 'Kollyck');
INSERT INTO client (id_client, prenom, nom) VALUES ('4', 'Simon', 'Strueux');
INSERT INTO client (id_client, prenom, nom) VALUES ('5', 'Vic', 'Tim');
INSERT INTO client (id_client, prenom, nom) VALUES ('6', 'Daisy', 'Draté');
INSERT INTO client (id_client, prenom, nom) VALUES ('7', 'Paul', 'Honnay');

INSERT INTO compte (numero_compte, id_client, solde) VALUES ('1', '1', 3800);
INSERT INTO compte (numero_compte, id_client, solde) VALUES ('2', '1', 14325.35);
INSERT INTO compte (numero_compte, id_client, solde) VALUES ('3', '2', 1234.56);
INSERT INTO compte (numero_compte, id_client, solde) VALUES ('4', '3', 987.65);
INSERT INTO compte (numero_compte, id_client, solde) VALUES ('5', '4', 24680.08);
INSERT INTO compte (numero_compte, id_client, solde) VALUES ('6', '5', -30.08);
INSERT INTO compte (numero_compte, id_client, solde) VALUES ('7', '6', -1230.08);

INSERT INTO transaction (id_transaction, operation, numero_compte, montant) VALUES ('1124d9e8-6266-4bcf-8035-37a02ba75c69', 'RETRAIT', '1', 250);
INSERT INTO transaction (id_transaction, operation, numero_compte, montant) VALUES ('2124d9e8-6266-4bcf-8035-37a02ba75c69', 'RETRAIT', '3', 120);
INSERT INTO transaction (id_transaction, operation, numero_compte, montant) VALUES ('3124d9e8-6266-4bcf-8035-37a02ba75c69', 'DEPOT', '6', 250);
INSERT INTO transaction (id_transaction, operation, numero_compte, montant) VALUES ('4124d9e8-6266-4bcf-8035-37a02ba75c69', 'DEPOT', '7', 2350);

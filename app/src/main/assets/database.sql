--
-- File generated with SQLiteStudio v3.1.1 on dim. avr. 29 11:19:42 2018
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: choix
DROP TABLE IF EXISTS choix;
CREATE TABLE choix (ID_question integer NOT NULL REFERENCES contenu (ID_question), ID_sondage integer NOT NULL REFERENCES sondage (ID_sondage), données REFERENCES réponse (données), ID_participant text NOT NULL REFERENCES utilisateur (identifiant), score INTEGER);
INSERT INTO choix (ID_question, ID_sondage, données, ID_participant, score) VALUES (1, 1, 'Margherita', 'floflo', 1);
INSERT INTO choix (ID_question, ID_sondage, données, ID_participant, score) VALUES (1, 1, '4 Fromaggi', 'floflo', 2);
INSERT INTO choix (ID_question, ID_sondage, données, ID_participant, score) VALUES (2, 1, 'Star Wars', 'floflo', 1);
INSERT INTO choix (ID_question, ID_sondage, données, ID_participant, score) VALUES (2, 1, 'Avengers', 'floflo', 2);
INSERT INTO choix (ID_question, ID_sondage, données, ID_participant, score) VALUES (3, 2, '11.35 millions', 'Quentin', 1);
INSERT INTO choix (ID_question, ID_sondage, données, ID_participant, score) VALUES (4, 3, 'bleu', 'Edouard', 1);

-- Table: contenu
DROP TABLE IF EXISTS contenu;
CREATE TABLE contenu (ID_question integer PRIMARY KEY NOT NULL, ID_sondage integer NOT NULL REFERENCES sondage (ID_sondage), type text NOT NULL);
INSERT INTO contenu (ID_question, ID_sondage, type) VALUES (1, 1, 'sondage');
INSERT INTO contenu (ID_question, ID_sondage, type) VALUES (2, 1, 'sondage');
INSERT INTO contenu (ID_question, ID_sondage, type) VALUES (3, 2, 'questionnaire');
INSERT INTO contenu (ID_question, ID_sondage, type) VALUES (4, 3, 'aide à un ami');

-- Table: liste_amis
DROP TABLE IF EXISTS liste_amis;
CREATE TABLE liste_amis (identifiant_1 text NOT NULL REFERENCES utilisateur (identifiant), identifiant_2 text NOT NULL REFERENCES utilisateur (identifiant), statut text NOT NULL);
INSERT INTO liste_amis (identifiant_1, identifiant_2, statut) VALUES ('floflo', 'Baptiste', 'en cours');
INSERT INTO liste_amis (identifiant_1, identifiant_2, statut) VALUES ('floflo', 'Edouard', 'accepte');
INSERT INTO liste_amis (identifiant_1, identifiant_2, statut) VALUES ('Soukéina', 'Edouard', 'accepte');
INSERT INTO liste_amis (identifiant_1, identifiant_2, statut) VALUES ('Sara', 'Quentin', 'accepte');

-- Table: liste_participants
DROP TABLE IF EXISTS liste_participants;
CREATE TABLE liste_participants (identifiant text NOT NULL REFERENCES utilisateur (identifiant), ID_sondage integer NOT NULL REFERENCES sondage (ID_sondage), statut text NOT NULL);
INSERT INTO liste_participants (identifiant, ID_sondage, statut) VALUES ('floflo', 1, 'en attente');
INSERT INTO liste_participants (identifiant, ID_sondage, statut) VALUES ('Sara', 1, 'en attente');
INSERT INTO liste_participants (identifiant, ID_sondage, statut) VALUES ('Soukeina', 2, 'en attente');
INSERT INTO liste_participants (identifiant, ID_sondage, statut) VALUES ('Quentin', 2, 'a repondu');
INSERT INTO liste_participants (identifiant, ID_sondage, statut) VALUES ('Edouard', 3, 'a repondu');
INSERT INTO liste_participants (identifiant, ID_sondage, statut) VALUES ('floflo', 3, 'en attente');

-- Table: question
DROP TABLE IF EXISTS question;
CREATE TABLE question (ID_question integer NOT NULL REFERENCES contenu (ID_question), énoncé text NOT NULL, nombreRéponses INTEGER NOT NULL DEFAULT (1));
INSERT INTO question (ID_question, énoncé, nombreRéponses) VALUES (1, 'Quelle type de pizza ce soir ?', 2);
INSERT INTO question (ID_question, énoncé, nombreRéponses) VALUES (2, 'Quel film va-t on regarder ce soir?', 2);
INSERT INTO question (ID_question, énoncé, nombreRéponses) VALUES (4, 'Bleu ou rouge ?', 1);
INSERT INTO question (ID_question, énoncé, nombreRéponses) VALUES (3, 'Population de la Belgique ?', 1);

-- Table: réponse
DROP TABLE IF EXISTS réponse;
CREATE TABLE réponse (ID_question integer NOT NULL REFERENCES contenu (ID_question), format text NOT NULL, données NOT NULL PRIMARY KEY, catégorie text);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (1, 'texte', 'Margherita', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (1, 'texte', '4 Fromaggi', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (1, 'texte', 'Prosciutto', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (1, 'texte', 'Hawai', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (2, 'texte', 'Star Wars', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (2, 'texte', 'Avengers', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (2, 'texte', 'Inglourious Basterds', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (4, 'texte', 'rouge', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (4, 'texte', 'bleu', NULL);
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (3, 'texte', 150, 'mauvaise');
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (3, 'texte', '1.000.000.000.000', 'mauvaise');
INSERT INTO réponse (ID_question, format, données, catégorie) VALUES (3, 'texte', '11.35 millions', 'bonne');

-- Table: sondage
DROP TABLE IF EXISTS sondage;
CREATE TABLE sondage (ID_sondage integer PRIMARY KEY NOT NULL, créateur text NOT NULL REFERENCES utilisateur (identifiant), résultat text, statut text NOT NULL);
INSERT INTO sondage (ID_sondage, créateur, résultat, statut) VALUES (1, 'Quentin', NULL, 'ouvert');
INSERT INTO sondage (ID_sondage, créateur, résultat, statut) VALUES (2, 'Sara', '', 'ouvert');
INSERT INTO sondage (ID_sondage, créateur, résultat, statut) VALUES (3, 'floflo', '', 'ouvert');

-- Table: utilisateur
DROP TABLE IF EXISTS utilisateur;
CREATE TABLE utilisateur(identifiant text not null primary key,
			mail text not null unique,
			nom text not null,
			prenom text not null,
			mdp text not null,
			photo BLOB,
			meilleur_ami text);
INSERT INTO utilisateur (identifiant, mail, nom, prenom, mdp, photo, meilleur_ami) VALUES ('floflo', 'florentin.delcourt@student.uclouvain.be', 'delcourt', 'florentin', 'MotDePasse', NULL, 'Baptiste');
INSERT INTO utilisateur (identifiant, mail, nom, prenom, mdp, photo, meilleur_ami) VALUES ('Edouard', 'chatzopoulos.edouard@student.uclouvain.be', 'chatzopoulos', 'edouard', 'Ed1234', NULL, 'floflo');
INSERT INTO utilisateur (identifiant, mail, nom, prenom, mdp, photo, meilleur_ami) VALUES ('Quentin', 'quentin.dessain@student.uclouvain.be', 'dessain', 'quentin', '12345', NULL, 'Soukéina');
INSERT INTO utilisateur (identifiant, mail, nom, prenom, mdp, photo, meilleur_ami) VALUES ('Sara', 'sara.kaczynska@student.uclouvain.be', 'kaczynska', 'sara', 'SaRa33', NULL, 'Quentin');
INSERT INTO utilisateur (identifiant, mail, nom, prenom, mdp, photo, meilleur_ami) VALUES ('Baptiste', 'baptiste.standaert@student.uclouvain.be', 'standaert', 'baptiste', '123Bap', NULL, 'Edouard');
INSERT INTO utilisateur (identifiant, mail, nom, prenom, mdp, photo, meilleur_ami) VALUES ('Soukeina', 'soukeina.bojabza@student.uclouvain.be', 'bojabza', 'soukeina', 'Souki17', NULL, 'Sara');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;

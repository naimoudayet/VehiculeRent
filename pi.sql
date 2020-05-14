DROP TABLE reservation;
DROP TABLE bus;
DROP TABLE voiture;
DROP TABLE vehicule;
DROP TABLE administrateur;
DROP TABLE client;
DROP TABLE utilisateur;

CREATE TABLE utilisateur(
	id VARCHAR(40) PRIMARY KEY,
	num_cin VARCHAR(8), 
	nom VARCHAR(20), 
	prenom VARCHAR(20),
	num_tel VARCHAR(8)
);

CREATE TABLE client( 
	id VARCHAR(40) PRIMARY KEY, 
	id_utilisateur VARCHAR(40) REFERENCES utilisateur(id)
);

CREATE TABLE administrateur( 
	id VARCHAR(40) PRIMARY KEY, 
	id_utilisateur VARCHAR(40) REFERENCES utilisateur(id)
);


CREATE TABLE vehicule(
	matricule VARCHAR(40) PRIMARY KEY,
	marque VARCHAR(20), 
	modele VARCHAR(20),
	puissance VARCHAR(20), 
	assurance VARCHAR(20), 
	prix_jour INT, 
	penalisation_jour INT
);


CREATE TABLE bus (
	id VARCHAR(40) PRIMARY KEY,
	matricule VARCHAR(40) REFERENCES Vehicule(matricule)
);


CREATE TABLE Voiture(	
	id VARCHAR(40) PRIMARY KEY,
	matricule VARCHAR(40) REFERENCES Vehicule(matricule)
);


CREATE TABLE Reservation( 
	id VARCHAR(40) PRIMARY KEY,
	id_client VARCHAR(40) REFERENCES Client(id),
	matricule VARCHAR(40) REFERENCES Vehicule(matricule),
	date_debut DATE , 
	date_fin DATE ,
	prix_total INT 
);
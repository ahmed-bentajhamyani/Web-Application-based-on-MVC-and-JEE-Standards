<p align="center">
	<img src="https://user-images.githubusercontent.com/101653735/202849820-dfeaabcf-4dd9-4452-a847-5a767462fd9d.png" >
</p>

# Web Application based on MVC and JEE Standards

This is an implementation of a web application that manages orders from several clients, the developed web application must respect the MVC design pattern.

## Table of contents
[Class diagram](#class-diagram)
[Database schema](#database-schema)
[Testing the Application](#testing-the-application)
* [Articles](#articles)
* [Clients](#clients)
* [Commandes](#commandes)
* [Ligne Commandes](#ligne-commandes)

## Class diagram

The class diagram used to implement this web application composed of four classes "Client", "Commande", "Article" and "LigneCmd":

<p align="center">
	<img width="938" alt="image" src="https://user-images.githubusercontent.com/101653735/202849709-90be382e-0663-457c-980e-5486a859115f.png">
</p>

## Database schema

The database schema based on the class diagram:

<p align="center">
	<img width="791" alt="Database Schema II" src="https://user-images.githubusercontent.com/101653735/203131784-4501c611-1181-4200-a176-fd8d949b4508.png">
</p>

To implement this schema to a MYSQL Database Management System:

```
CREATE DATABASE minimarketplace;
USE minimarketplace;

CREATE TABLE client (
	code_cli bigInt NOT NULL AUTO_INCREMENT,
	nom_cli varchar(25),
	prenom_cli varchar(25),
	tele_cli varchar(15),
	adresse_cli varchar(50),
	PRIMARY KEY (code_cli)
);

CREATE TABLE article (
	code_art bigInt NOT NULL AUTO_INCREMENT,
	nom_art varchar(25),
	description varchar(60),
	prix_unitaire float(10,2),
	qte_art int(10),
	PRIMARY KEY (code_art)
);

CREATE TABLE commande (
	num_cmd bigInt NOT NULL AUTO_INCREMENT,
	date_cmd DATE,
	code_cli bigInt,
	PRIMARY KEY (num_cmd),
	FOREIGN KEY (code_cli) REFERENCES client(code_cli) ON DELETE CASCADE
);

CREATE TABLE ligne_cmd (
	num_ligne bigInt NOT NULL AUTO_INCREMENT,
	qte_cmd int(10),
	code_art bigInt,
	num_cmd bigInt,
	PRIMARY KEY (num_ligne),
	FOREIGN KEY (code_art) REFERENCES article(code_art) ON DELETE CASCADE,
	FOREIGN KEY (num_cmd) REFERENCES commande(num_cmd) ON DELETE CASCADE
);
```

## Testing the Application

### Articles

The list is empty in first time:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/203139469-50f0a693-2047-4dc0-ac5c-65975c57b1ae.png">
</p>

To add an article we click on "Add New Article":

<p align="center">
	<img width="960" alt="2" src="https://user-images.githubusercontent.com/101653735/203139097-c3469139-eee1-4cda-9dc9-d53e14acb241.png">
</p>

And we click save:

<p align="center">
	<img width="960" alt="3" src="https://user-images.githubusercontent.com/101653735/203139197-1848054e-e2ff-44eb-8021-db11678182ec.png">
</p>

### Clients

The same as articles we added a client to the list:

<p align="center">
	<img width="960" alt="5" src="https://user-images.githubusercontent.com/101653735/203140133-67e05054-918c-498d-a85e-d6a62f3e283e.png">
</p>

We can edit and delete any client we want so let's edit this client:

<p align="center">
	<img width="960" alt="6" src="https://user-images.githubusercontent.com/101653735/203140256-962d5156-7fb5-4b29-8694-fa9e921fed16.png">
</p>

And ...

<p align="center">
	<img width="960" alt="7" src="https://user-images.githubusercontent.com/101653735/203140314-c68a4d89-b4de-42ae-ada2-c434331e4ab1.png">
</p>

### Commandes

To add a commande we have to specify the client who ordered by his id and of course the date of the order:

<p align="center">
	<img width="960" alt="8" src="https://user-images.githubusercontent.com/101653735/203140593-a9c753e9-b631-4024-ae6b-ae6c6ec9e563.png">
</p>

And we save:

<p align="center">
	<img width="960" alt="9" src="https://user-images.githubusercontent.com/101653735/203140677-c81d697a-955b-4f97-b761-d0c2de98bc21.png">
</p>

### Ligne Commandes

The same as commande, to add a ligne of commande we have to specify the article in this ligne commande, its amount "quantité" and the id of the commande that belongs to it:

<p align="center">
	<img width="960" alt="10" src="https://user-images.githubusercontent.com/101653735/203142087-382dea83-5c7a-4fe9-a065-860fbc94edd6.png">
</p>

And we save:

<p align="center">
	<img width="960" alt="11" src="https://user-images.githubusercontent.com/101653735/203142116-3bff2399-85d5-4f67-965e-6248a0f792cc.png">
</p>

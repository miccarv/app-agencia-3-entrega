create database javaprojcrud;
use javaprojcrud;

CREATE TABLE clientes (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL unique,
  `senha` varchar(30) NOT NULL,
  `endereco` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE destination (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    destination VARCHAR (40) not null,
    date VARCHAR(30) not null,
    duration varchar (30) not null,
    email varchar (60) unique
);
 
ALTER TABLE destination ADD CONSTRAINT FK_destination_1
    FOREIGN KEY (email)
    REFERENCES clientes (email);
    
INSERT INTO `clientes` VALUES (null,'Teste','teste@email','xxxx','teste');
INSERT INTO `destination` VALUES (null,'Rio de Janeiro','22/01/2021','2 semanas','teste@email');
select * from clientes;
select * from destination;
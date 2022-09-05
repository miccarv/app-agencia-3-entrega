create database java1;
use java1;

CREATE TABLE tab_clients (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL unique,
  `password` varchar(30) NOT NULL,
  `address` varchar(60) NOT NULL,
  `state` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE travel (
    destiny VARCHAR (60) not null,
    date VARCHAR(30) not null,
    duration varchar (30) not null,
    fk_Client_id INT PRIMARY KEY
);
 
ALTER TABLE travel ADD CONSTRAINT FK_travel_1
    FOREIGN KEY (fk_Client_id)
    REFERENCES tab_clients (id)
    ON DELETE RESTRICT;
    
INSERT INTO `tab_clients` VALUES (null,'Eduardo','edu@email','dddd','rua 1','RJ');
INSERT INTO `travel` VALUES ('Rio de Janeiro','22/01/2021','2 semanas',1);
select * from tab_clients;
select * from travel;
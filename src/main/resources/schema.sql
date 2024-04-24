CREATE TABLE USERS(
	id INT AUTO_INCREMENT PRIMARY KEY,
	firstname VARCHAR(250) NOT NULL,
	lastname VARCHAR(250),
	emailaddress VARCHAR(250) DEFAULT NULL
);
CREATE TABLE TRAIN(
	id INT PRIMARY KEY,
	name VARCHAR(250)
);
CREATE TABLE TRAIN_SEATS(
	id INT AUTO_INCREMENT PRIMARY KEY,
	trainid INT,
	seatnumber VARCHAR(250),
	section CHAR,
	foreign key (trainid) references train(id)
);

ALTER TABLE TRAIN_SEATS ADD CONSTRAINT SEAT_SECTIONS CHECK (SECTION IN ('A','B'));
CREATE TABLE TICKETS(
	id INT AUTO_INCREMENT PRIMARY KEY,
	fromcity VARCHAR(250),
	tocity VARCHAR(250),
	price DOUBLE,
	userid INT,
	seatid INT,
	foreign key (userid) references USERS(id),
	foreign key (seatid) references TRAIN_SEATS(id)
);

BEGIN TRANSACTION;



DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS castle;
DROP TABLE IF EXISTS castle_img;
DROP TABLE IF EXISTS img;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE castle (
	castle_id serial primary key,
	castle_name varchar(50) NOT NULL,
	castle_banner_photo varchar(250) NOT NULL,
	short_desc varchar(250) NOT NULL,
	long_desc text,
	address varchar(255) NOT NULL,
	longitude varchar(50),
	latitude varchar(50),
	site_url varchar(255)
);


CREATE TABLE img (
	img_id serial primary key,
	img_name varchar(50) NOT NULL,
	img_path varchar(50) NOT NULL
);

CREATE TABLE castle_img (
	img_id int,
	castle_id int,
	FOREIGN KEY (img_id) REFERENCES img (img_id),
	FOREIGN KEY (castle_id) REFERENCES castle(castle_id)
);

COMMIT TRANSACTION;


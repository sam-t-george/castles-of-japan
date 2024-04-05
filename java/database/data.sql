BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

insert into castle (castle_name, castle_banner_photo, short_desc, long_desc, address) 
values('Nijō Castle','https://dskyoto.s3.amazonaws.com/gallery/full/1514/5559/8500/04-20140407_NijoCastle-32.jpg', 'dope castle', 'Really dope castle', '541 Nijojocho, Nakagyo Ward, Kyoto');



COMMIT TRANSACTION;

insert into Role (name) values ('ROLE_ADMIN');
insert into Role (name) values ('ROLE_USER');
insert into address(city, street) values('Wrocław', 'Kochanowskie 27a/6');

insert into user (email, password, user_name, address_id) values ('admin@gmail.com',
'$2y$12$BBfJ4aSjpMTrWbKdXULBwuqRwrW9hDY57F28lHVS7bKCy3u/6PzBu', 'admin', 1);
insert into user_roles(user_id, role_id) values(1, 1);

insert  into category(name) values ('B10');
insert  into category(name) values ('B15');
insert  into category(name) values ('B20');


insert into product(name,file_name,price,category_id) values('B10','xiaomi.jpg',12000, 1);


insert  into Configurations(title,subtitle,produit_id) values ('Performance','Choose your batterie',1);
insert  into Configurations(title,subtitle,produit_id) values ('Cargo space','Exterior',1);
insert  into Configurations(title,subtitle,produit_id) values ('Cockpit','Doors',1);
insert  into Configurations(title,subtitle,produit_id) values ('Additional','Connectivity',1);

insert  into Type(description,price,config_id) values ('2.5 kWh - 100 km',0,1);
insert  into Type(description,price,config_id) values ('5 kWh - 150 km',3000,1);
insert  into Type(description,price,config_id) values ('7.5 kWh - 200 km',6000,1);


insert  into Type(description,price,config_id) values ('Standard',0,2);
insert  into Type(description,price,config_id) values ('Pickup',3000,2);

insert  into Type(description,price,config_id) values ('No Doors',0,3);
insert  into Type(description,price,config_id) values ('Doors',500,3);

insert  into Type(description,price,config_id) values ('Mobile application',0,4);
insert  into Type(description,price,config_id) values ('Fleet management',500,4);






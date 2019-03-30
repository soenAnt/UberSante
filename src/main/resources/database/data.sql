INSERT IGNORE INTO users VALUES (1, 'Boris', 'Fitzgerald','goat360', 'patient', 0,'Westmount');
INSERT IGNORE INTO users VALUES (2, 'Felix', 'Roscinante','pass123', 'patient', 0,'Westmount');
INSERT IGNORE INTO users VALUES (3, 'Alicia', 'Mayoris','osmosis', 'patient', 0,'Westmount');
INSERT IGNORE INTO users VALUES (4, 'Jerome', 'Damien', 'toothpaste', 'patient', 0,'Westmount');
INSERT IGNORE INTO users VALUES (5, 'Matthew', 'Colson','goawayhackers', 'patient', 0,'Westmount');
INSERT IGNORE INTO users VALUES (6, 'Claire', 'Titheradge','cardioc', 'doctor', 0,'Westmount');
INSERT IGNORE INTO users VALUES (7, 'Mikayla', 'Borella','mikay01', 'doctor', 0,'Westmount');
INSERT IGNORE INTO users VALUES (8, 'William', 'Petchy','doctor123', 'doctor', 0,'Westmount');
INSERT IGNORE INTO users VALUES (9, 'Sean', 'Pocock','marcopolo', 'doctor', 0,'Westmount');
INSERT IGNORE INTO users VALUES (10, 'Lara', 'Mingay','crying2019', 'doctor', 0,'Westmount');
INSERT IGNORE INTO users VALUES (11, 'Matilda', 'Fanny','fannypack', 'doctor', 0,'Westmount');
INSERT IGNORE INTO users VALUES (12, 'Zachary', 'Ludowici','toes300', 'doctor', 0,'Westmount');
INSERT IGNORE INTO users VALUES (13, 'Rita', 'Rodriguez', 'nursing101', 'nurse', 0,'Westmount');
INSERT IGNORE INTO users VALUES (14, 'Gwendolyn', 'Shoop', 'costco', 'nurse', 0,'Westmount');
INSERT IGNORE INTO users VALUES (15, 'William', 'Kline', 'ubereats', 'nurse', 0,'Westmount');

INSERT IGNORE INTO clinics VALUES ('Westmount',0,0,5,0);
INSERT IGNORE INTO clinics VALUES ('Mont-Royal',0,0,10,0);
INSERT IGNORE INTO clinics VALUES ('Outremont',0,0,15,0);

INSERT IGNORE INTO patients VALUES (1,'1959-12-21', 'Male', '514-344-9140',
'boris_the_goat@gmail.com', '2345 Mcintosh Street S8D 2L3, Montreal QC.', 'BORF 1145 1180');
INSERT IGNORE INTO patients VALUES (2, '1980-05-05', 'Male', '514-370-7785',
'felix77@gmail.com', '5989 Elway Street H2S 1K9, Montreal QC.', 'FELR 0022 2765');
INSERT IGNORE INTO patients VALUES (3, '1996-04-15', 'Female', '438-560-2021',
'alimay@gmail.com', '349 Durbians Avenue F8T 1H4, Montreal QC.', 'ALIM 7135 1854');
INSERT IGNORE INTO patients VALUES (4,  '1990-10-10', 'Male', '514-612-5527',
'JeromeD@dayrep.com', '3326 De la Providence Avenue J8H 2J7, Montreal QC.', 'JERD 4485 1200');
INSERT IGNORE INTO patients VALUES (5,  '1984-07-23', 'Male', '438-955-6541',
'angel-lessons@outlook.com', '1544 Victoria Park Ave M2J 3T7, Montreal QC.', 'MATC 4888 7556');

INSERT IGNORE INTO doctors VALUES (6, 'Cardiology', 'Montreal', '1141833');
INSERT IGNORE INTO doctors VALUES (7, 'General practice', 'Montreal', '2748499');
INSERT IGNORE INTO doctors VALUES (8, 'Gastroenterology', 'Montreal', '5986621');
INSERT IGNORE INTO doctors VALUES (9, 'Endocrinology', 'Montreal', '4508102');
INSERT IGNORE INTO doctors VALUES (10, 'Paediatrics', 'Montreal', '9856221');
INSERT IGNORE INTO doctors VALUES (11, 'Internal medicine', 'Montreal', '7391852');
INSERT IGNORE INTO doctors VALUES (12, 'Orthopaedics', 'Montreal', '1223554');

INSERT IGNORE INTO nurses VALUES (13, 'DHG88451');
INSERT IGNORE INTO nurses VALUES (14, 'IUE15447');
INSERT IGNORE INTO nurses VALUES (15, 'KMN12805');

INSERT IGNORE INTO appointments VALUES(1, 1, '2019-09-09', '10:20', '10:40', "walk-in", "Westmount", "");
INSERT IGNORE INTO appointments VALUES(2, 2, '2019-06-21', '16:00', '17:00', "annual", "Westmount", "");
INSERT IGNORE INTO appointments VALUES(3, 3, '2019-04-04', '15:00', '15:20', 'walk-in', "Westmount", "");
INSERT IGNORE INTO appointments VALUES(4, 3, '2019-08-10', '15:00', '16:00', 'annual', "Westmount", "");
INSERT IGNORE INTO appointments VALUES(5, 4, '2019-06-14', '9:00', '9:20', 'walk-in', "Westmount", "toe fungus");
INSERT IGNORE INTO appointments VALUES(6, 5, '2019-05-15', '18:00', '18:20', 'walk-in', "Westmount", "");

INSERT IGNORE INTO bookings VALUES(1, 6, 3, 3, 1);
INSERT IGNORE INTO bookings VALUES(2, 7, 4, 5, 1);

INSERT IGNORE INTO schedules VALUES (1, 6, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (2, 6, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (3, 6, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (4, 6, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (5, 6, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (6, 6, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (7, 6, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (8, 7, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (9, 7, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (10, 7, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (11, 7, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (12, 7, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (13, 7, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (14, 7, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (15, 8, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (16, 8, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (17, 8, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (18, 8, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (19, 8, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (20, 8, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (21, 8, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (22, 9, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (23, 9, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (24, 9, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (25, 9, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (26, 9, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (27, 9, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (28, 9, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (29, 10, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (30, 10, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (31, 10, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (32, 10, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (33, 10, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (34, 10, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (35, 10, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (36, 11, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (37, 11, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (38, 11, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (39, 11, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (40, 11, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (41, 11, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (42, 11, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (43, 12, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (44, 12, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (45, 12, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (46, 12, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (47, 12, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (48, 12, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (49, 12, 'Saturday', '9:00', '17:00');
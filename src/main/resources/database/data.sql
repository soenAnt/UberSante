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
INSERT IGNORE INTO users VALUES (16, 'Amanda', 'Banana', 'applesandbananas', 'nurse', 0, 'Mont-Royal');
INSERT IGNORE INTO users VALUES (17, 'Daniella', 'Rug', 'itsme123', 'nurse', 0, 'Mont-Royal');
INSERT IGNORE INTO users VALUES (18, 'Kristine', 'Lalo', 'nursesrule', 'nurse', 0, 'Mont-Royal');
INSERT IGNORE INTO users VALUES (19, 'Carmen', 'Larsen', 'cooldoc123', 'doctor', 0, 'Mont-Royal');
INSERT IGNORE INTO users VALUES (20, 'Anthony', 'Fugaz', 'doc4lyf', 'doctor', 0, 'Mont-Royal');
INSERT IGNORE INTO users VALUES (21, 'Mike', 'Champ', 'heyholetsgo', 'doctor', 0, 'Mont-Royal');
INSERT IGNORE INTO users VALUES (22, 'Mer', 'Pink', 'georgy123', 'nurse', 0, 'Outremont');
INSERT IGNORE INTO users VALUES (23, 'Cristina', 'Ho', 'peace123', 'nurse', 0, 'Outremont');
INSERT IGNORE INTO users VALUES (24, 'Andrew', 'Loo', 'schoolrox', 'nurse', 0, 'Outremont');
INSERT IGNORE INTO users VALUES (25, 'Lina', 'Coin', 'lamps876', 'doctor', 0, 'Outremont');
INSERT IGNORE INTO users VALUES (26, 'Elena', 'Vamp', 'doors1234', 'doctor', 0, 'Outremont');
INSERT IGNORE INTO users VALUES (27, 'Park', 'Rec', 'creativity-1', 'doctor', 0, 'Outremont');




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

INSERT IGNORE INTO doctors VALUES (6, 'Cardiology', 'Montreal', '1111111');
INSERT IGNORE INTO doctors VALUES (7, 'General practice', 'Montreal', '2222222');
INSERT IGNORE INTO doctors VALUES (8, 'Gastroenterology', 'Montreal', '3333333');
INSERT IGNORE INTO doctors VALUES (9, 'Endocrinology', 'Montreal', '4444444');
INSERT IGNORE INTO doctors VALUES (10, 'Paediatrics', 'Montreal', '5555555');
INSERT IGNORE INTO doctors VALUES (11, 'Internal medicine', 'Montreal', '6666666');
INSERT IGNORE INTO doctors VALUES (12, 'Orthopaedics', 'Montreal', '7777777');
INSERT IGNORE INTO doctors VALUES (19, 'Neurologist', 'Montreal', '8888888');
INSERT IGNORE INTO doctors VALUES (20, 'Oncologist', 'Montreal', '9999999');
INSERT IGNORE INTO doctors VALUES (21, 'Osteopath', 'Montreal', '1234567');
INSERT IGNORE INTO doctors VALUES (25, 'Plastic surgeon', 'Montreal', '7654321');
INSERT IGNORE INTO doctors VALUES (26, 'Radiologist', 'Montreal', '1112223');
INSERT IGNORE INTO doctors VALUES (27, 'Urologist', 'Montreal', '1231234');


INSERT IGNORE INTO nurses VALUES (13, 'DHG88451');
INSERT IGNORE INTO nurses VALUES (14, 'IUE15447');
INSERT IGNORE INTO nurses VALUES (15, 'KMN12805');
INSERT IGNORE INTO nurses VALUES (16, 'ABC89076');
INSERT IGNORE INTO nurses VALUES (17, 'DEF12758');
INSERT IGNORE INTO nurses VALUES (18, 'GHI75901');
INSERT IGNORE INTO nurses VALUES (22, 'JKL56227');
INSERT IGNORE INTO nurses VALUES (23, 'MNO77221');
INSERT IGNORE INTO nurses VALUES (24, 'PQR88007');


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
INSERT IGNORE INTO schedules VALUES (50, 19, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (51, 19, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (52, 19, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (53, 19, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (54, 19, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (55, 19, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (56, 19, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (57, 20, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (58, 20, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (59, 20, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (60, 20, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (61, 20, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (62, 20, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (63, 20, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (64, 21, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (65, 21, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (66, 21, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (67, 21, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (68, 21, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (69, 21, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (70, 21, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (71, 25, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (72, 25, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (73, 25, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (74, 25, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (75, 25, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (76, 25, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (77, 25, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (78, 26, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (79, 26, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (80, 26, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (81, 26, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (82, 26, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (83, 26, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (84, 26, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (85, 27, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (86, 27, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (87, 27, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (88, 27, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (89, 27, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (90, 27, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (91, 27, 'Saturday', '9:00', '17:00');

UPDATE clinics SET num_doctors=(SELECT count(doctors.user_id) FROM doctors LEFT JOIN users ON doctors.user_id=users.user_id WHERE users.location="Outremont") WHERE name="Outremont";
UPDATE clinics SET num_doctors=(SELECT count(doctors.user_id) FROM doctors LEFT JOIN users ON doctors.user_id=users.user_id WHERE users.location="Mont-royal") WHERE name="Mont-Royal";
UPDATE clinics SET num_doctors=(SELECT count(doctors.user_id) FROM doctors LEFT JOIN users ON doctors.user_id=users.user_id WHERE users.location="Westmount") WHERE name="Westmount";

UPDATE clinics SET num_nurses=(SELECT count(nurses.user_id) FROM nurses LEFT JOIN users ON nurses.user_id=users.user_id WHERE users.location="Outremont") WHERE name="Outremont";
UPDATE clinics SET num_nurses=(SELECT count(nurses.user_id) FROM nurses LEFT JOIN users ON nurses.user_id=users.user_id WHERE users.location="Mont-royal") WHERE name="Mont-Royal";
UPDATE clinics SET num_nurses=(SELECT count(nurses.user_id) FROM nurses LEFT JOIN users ON nurses.user_id=users.user_id WHERE users.location="Westmount") WHERE name="Westmount";

UPDATE clinics SET num_bookings=(SELECT count(bookings.booking_id) FROM bookings LEFT JOIN appointments ON bookings.appointment_id=appointments.appointment_id WHERE appointments.location="Outremont") WHERE name="Outremont";
UPDATE clinics SET num_bookings=(SELECT count(bookings.booking_id) FROM bookings LEFT JOIN appointments ON bookings.appointment_id=appointments.appointment_id WHERE appointments.location="Mont-royal") WHERE name="Mont-Royal";
UPDATE clinics SET num_bookings=(SELECT count(bookings.booking_id) FROM bookings LEFT JOIN appointments ON bookings.appointment_id=appointments.appointment_id WHERE appointments.location="Westmount") WHERE name="Westmount";
INSERT IGNORE INTO patients VALUES (1, 'Boris', 'Fitzgerald', '1959-12-21', 'M', '514-344-9140',
'boris_the_goat@gmail.com', '2345 Mcintosh Street S8D 2L3, Montreal QC.', 'BORF 1145 1180', 'goat360');
INSERT IGNORE INTO patients VALUES (2, 'Felix', 'Roscinante', '1980-05-05', 'M', '514-370-7785',
'felix77@gmail.com', '5989 Elway Street H2S 1K9, Montreal QC.', 'FELR 0022 2765', 'pass123');
INSERT IGNORE INTO patients VALUES (3, 'Alicia', 'Mayoris', '1996-04-15', 'F', '438-560-2021',
'alimay@gmail.com', '349 Durbians Avenue F8T 1H4, Montreal QC.', 'ALIM 7135 1854', 'osmosis');
INSERT IGNORE INTO patients VALUES (4, 'Jerome', 'Damien', '1990-10-10', 'M', '514-612-5527',
'JeromeD@dayrep.com', '3326 De la Providence Avenue J8H 2J7, Montreal QC.', 'JERD 4485 1200', 'toothpaste');
INSERT IGNORE INTO patients VALUES (5, 'Matthew', 'Colson', '1984-07-23', 'M', '438-955-6541',
'angel-lessons@outlook.com', '1544 Victoria Park Ave M2J 3T7, Montreal QC.', 'MATC 4888 7556', 'goawayhackers');

INSERT IGNORE INTO doctors VALUES (1, 'Claire', 'Titheradge', 'Cardiology', 'Montreal', '1141833','cardioc');
INSERT IGNORE INTO doctors VALUES (2, 'Mikayla', 'Borella', 'General practice', 'Montreal', '2748499','mikay01');
INSERT IGNORE INTO doctors VALUES (3, 'William', 'Petchy', 'Gastroenterology', 'Montreal', '5986621','doctor123');
INSERT IGNORE INTO doctors VALUES (4, 'Sean', 'Pocock', 'Endocrinology', 'Montreal', '4508102','marcopolo');
INSERT IGNORE INTO doctors VALUES (5, 'Lara', 'Mingay', 'Paediatrics', 'Montreal', '9856221','crying2019');
INSERT IGNORE INTO doctors VALUES (6, 'Matilda', 'Fanny', 'Internal medicine', 'Montreal', '7391852','fannypack');
INSERT IGNORE INTO doctors VALUES (7, 'Zachary', 'Ludowici', 'Orthopaedics', 'Montreal', '1223554','toes300');

INSERT IGNORE INTO nurses VALUES (1, 'DHG88451', 'nursing101');
INSERT IGNORE INTO nurses VALUES (2, 'IUE15447', 'costco');
INSERT IGNORE INTO nurses VALUES (3, 'KMN12805', 'ubereats');

INSERT IGNORE INTO appointments VALUES (1, 3, 7, '2019-05-04', '16:00', '16:20', 1, 'walk-in', 'toe fungus infection.');

INSERT IGNORE INTO schedules VALUES (1, 1, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (2, 1, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (3, 1, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (4, 1, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (5, 1, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (6, 1, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (7, 1, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (8, 2, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (9, 2, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (10, 2, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (11, 2, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (12, 2, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (13, 2, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (14, 2, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (15, 3, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (16, 3, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (17, 3, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (18, 3, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (19, 3, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (20, 3, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (21, 3, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (22, 4, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (23, 4, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (24, 4, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (25, 4, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (26, 4, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (27, 4, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (28, 4, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (29, 5, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (30, 5, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (31, 5, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (32, 5, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (33, 5, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (34, 5, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (35, 5, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (36, 6, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (37, 6, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (38, 6, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (39, 6, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (40, 6, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (41, 6, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (42, 6, 'Saturday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (43, 7, 'Sunday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (44, 7, 'Monday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (45, 7, 'Tuesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (46, 7, 'Wednesday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (47, 7, 'Thursday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (48, 7, 'Friday', '9:00', '17:00');
INSERT IGNORE INTO schedules VALUES (49, 7, 'Saturday', '9:00', '17:00');
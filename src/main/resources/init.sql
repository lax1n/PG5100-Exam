INSERT INTO User (id, email, password, usertype) VALUES (1, 'mari@test.com', '123ABc', 'STUDENT');
INSERT INTO User (id, email, password, usertype) VALUES (2, 'ole@test.com', 'abC123', 'TEACHER');
INSERT INTO User (id, email, password, usertype) VALUES (3, 'kari@test.com', '1234Abc', 'STUDENT');
INSERT INTO User (id, email, password, usertype) VALUES (4, 'marianne@test.com', '1234Abc', 'STUDENT');

INSERT INTO Location (id, building, room) VALUES (1, 'Galleriet', '82');
INSERT INTO Location (id, building, room) VALUES (2, 'Galleriet', '81');

INSERT INTO Subject (id, name, FK_LOCATION) VALUES (1, 'PG5100', 1);
INSERT INTO Subject (id, name, FK_LOCATION) VALUES (2, 'PG6100', 2);

INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (1, 1);
INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (2, 1);
INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (1, 2);
INSERT INTO USR_SUB (SUBJECTS_ID, USERS_ID) VALUES (2, 3);


INSERT INTO Event (id, title, type, FK_SUBJECT, description) VALUES (1, 'Eksamen', 'FORELESNING', 1, 'Feiring av vel fullført eksamen!');
INSERT INTO Event_details (id, startDate, endDate) VALUES (1, '2015-01-12 21:10:00.0',  '2015-01-12 23:10:00.0');
INSERT INTO Event (id, title, type, FK_SUBJECT, description) VALUES (2, 'The aftermath', 'EGENTRENING', 1, 'Se tilbake på det siste semesterets bragder.');
INSERT INTO Event_details (id, startDate, endDate) VALUES (2, '2015-01-13 13:10:00.0',  '2015-01-13 16:10:00.0');


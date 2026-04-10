INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Major.15', 'Tarragona', 'Fusión', '43100');
INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Major.25', 'Tarragona', 'JCS', '43100');
INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Major.35', 'Tarragona', 'Yelmus', '43100');
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 1', 120, 1);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 2', 120, 1);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 3', 120, 1);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 1', 120, 2);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 2', 120, 2);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 3', 120, 2);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 1', 120, 3);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 2', 120, 3);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 3', 120, 3);
INSERT INTO MOVIE (
        TITLE,
        duration_minutes,
        GENER,
        DESCRIPCION,
        release_date,
        POSTER_URL
    )
VALUES (
        'Dune: Part Two',
        166,
        'Sci-Fi',
        'Paul Atreides une fuerzas con los Fremen para vengar la destrucción de su familia.',
        '2024-03-01',
        'dune.webp'
    );
INSERT INTO MOVIE (
        TITLE,
        duration_minutes,
        GENER,
        DESCRIPCION,
        release_date,
        POSTER_URL
    )
VALUES (
        'Blade Runner',
        117,
        'Sci-Fi',
        'Un blade runner debe retirar replicantes ilegales que regresan a la Tierra.',
        '1982-06-25',
        'blade.webp'
    );
INSERT INTO MOVIE (
        TITLE,
        duration_minutes,
        GENER,
        DESCRIPCION,
        release_date,
        POSTER_URL
    )
VALUES (
        'Interstellar',
        169,
        'Sci-Fi',
        'Un grupo de astronautas viaja a través de un agujero de gusano para salvar a la humanidad.',
        '2014-11-07',
        'interestellar.webp'
    );
INSERT INTO MOVIE (
        TITLE,
        duration_minutes,
        GENER,
        DESCRIPCION,
        release_date,
        POSTER_URL
    )
VALUES (
        'Inception',
        148,
        'Sci-Fi',
        'Un ladrón roba secretos infiltrándose en los sueños de las personas.',
        '2010-07-16',
        'inception.webp'
    );
INSERT INTO MOVIE (
        TITLE,
        duration_minutes,
        GENER,
        DESCRIPCION,
        release_date,
        POSTER_URL
    )
VALUES (
        'The Dark Knight',
        152,
        'Action',
        'Batman se enfrenta al Joker, un criminal que busca sembrar el caos en Gotham.',
        '2008-07-18',
        'batman.webp'
    );
INSERT INTO MOVIE (
        TITLE,
        duration_minutes,
        GENER,
        DESCRIPCION,
        release_date,
        POSTER_URL
    )
VALUES (
        'The Matrix',
        136,
        'Sci-Fi',
        'Un hacker descubre que la realidad es una simulación creada por máquinas.',
        '1999-03-31',
        'matrix.webp'
    );

    INSERT INTO MOVIE (
        TITLE,
        duration_minutes,
        GENER,
        DESCRIPCION,
        release_date,
        POSTER_URL
    )
VALUES (
        'Dune: Part Three',
        170,
        'Sci-Fi',
        'Doce años después de su victoria, Paul se enfrenta a una conspiración que pretende derrocarlo y acabar con su dinastía, con un atentado con una bomba atómica, que lo deja gravemente herido. ',
        '2026-12-18',
        'dune3.webp'
    );
    
-- ═══ SEATS (Salas 1-3 · Oscars) ═══
-- Filas A-B: Standard · Filas C-E: Premium · Filas F-H: Standard · Adaptados en extremos de A y H
INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,1),('A',2,'Standard',2,1,false,1),('A',3,'Standard',3,1,false,1),('A',4,'Standard',4,1,false,1),('A',5,'Standard',5,1,false,1),('A',6,'Standard',6,1,false,1),('A',7,'Standard',7,1,false,1),('A',8,'Standard',8,1,false,1),('A',9,'Standard',9,1,false,1),('A',10,'Adapted',10,1,false,1),
('B',1,'Standard',1,2,false,1),('B',2,'Standard',2,2,false,1),('B',3,'Standard',3,2,false,1),('B',4,'Standard',4,2,false,1),('B',5,'Standard',5,2,false,1),('B',6,'Standard',6,2,false,1),('B',7,'Standard',7,2,false,1),('B',8,'Standard',8,2,false,1),('B',9,'Standard',9,2,false,1),('B',10,'Standard',10,2,false,1),
('C',1,'Premium',1,3,false,1),('C',2,'Premium',2,3,false,1),('C',3,'Premium',3,3,false,1),('C',4,'Premium',4,3,false,1),('C',5,'Premium',5,3,false,1),('C',6,'Premium',6,3,false,1),('C',7,'Premium',7,3,false,1),('C',8,'Premium',8,3,false,1),('C',9,'Premium',9,3,false,1),('C',10,'Premium',10,3,false,1),
('D',1,'Premium',1,4,false,1),('D',2,'Premium',2,4,false,1),('D',3,'Premium',3,4,false,1),('D',4,'Premium',4,4,false,1),('D',5,'Premium',5,4,false,1),('D',6,'Premium',6,4,false,1),('D',7,'Premium',7,4,false,1),('D',8,'Premium',8,4,false,1),('D',9,'Premium',9,4,false,1),('D',10,'Premium',10,4,false,1),
('E',1,'Premium',1,5,false,1),('E',2,'Premium',2,5,false,1),('E',3,'Premium',3,5,false,1),('E',4,'Premium',4,5,false,1),('E',5,'Premium',5,5,false,1),('E',6,'Premium',6,5,false,1),('E',7,'Premium',7,5,false,1),('E',8,'Premium',8,5,false,1),('E',9,'Premium',9,5,false,1),('E',10,'Premium',10,5,false,1),
('F',1,'Standard',1,6,false,1),('F',2,'Standard',2,6,false,1),('F',3,'Standard',3,6,false,1),('F',4,'Standard',4,6,false,1),('F',5,'Standard',5,6,false,1),('F',6,'Standard',6,6,false,1),('F',7,'Standard',7,6,false,1),('F',8,'Standard',8,6,false,1),('F',9,'Standard',9,6,false,1),('F',10,'Standard',10,6,false,1),
('G',1,'Standard',1,7,false,1),('G',2,'Standard',2,7,false,1),('G',3,'Standard',3,7,false,1),('G',4,'Standard',4,7,false,1),('G',5,'Standard',5,7,false,1),('G',6,'Standard',6,7,false,1),('G',7,'Standard',7,7,false,1),('G',8,'Standard',8,7,false,1),('G',9,'Standard',9,7,false,1),('G',10,'Standard',10,7,false,1),
('H',1,'Adapted',1,8,false,1),('H',2,'Standard',2,8,false,1),('H',3,'Standard',3,8,false,1),('H',4,'Standard',4,8,false,1),('H',5,'Standard',5,8,false,1),('H',6,'Standard',6,8,false,1),('H',7,'Standard',7,8,false,1),('H',8,'Standard',8,8,false,1),('H',9,'Standard',9,8,false,1),('H',10,'Adapted',10,8,false,1);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,2),('A',2,'Standard',2,1,false,2),('A',3,'Standard',3,1,false,2),('A',4,'Standard',4,1,false,2),('A',5,'Standard',5,1,false,2),('A',6,'Standard',6,1,false,2),('A',7,'Standard',7,1,false,2),('A',8,'Standard',8,1,false,2),('A',9,'Standard',9,1,false,2),('A',10,'Adapted',10,1,false,2),
('B',1,'Standard',1,2,false,2),('B',2,'Standard',2,2,false,2),('B',3,'Standard',3,2,false,2),('B',4,'Standard',4,2,false,2),('B',5,'Standard',5,2,false,2),('B',6,'Standard',6,2,false,2),('B',7,'Standard',7,2,false,2),('B',8,'Standard',8,2,false,2),('B',9,'Standard',9,2,false,2),('B',10,'Standard',10,2,false,2),
('C',1,'Premium',1,3,false,2),('C',2,'Premium',2,3,false,2),('C',3,'Premium',3,3,false,2),('C',4,'Premium',4,3,false,2),('C',5,'Premium',5,3,false,2),('C',6,'Premium',6,3,false,2),('C',7,'Premium',7,3,false,2),('C',8,'Premium',8,3,false,2),('C',9,'Premium',9,3,false,2),('C',10,'Premium',10,3,false,2),
('D',1,'Premium',1,4,false,2),('D',2,'Premium',2,4,false,2),('D',3,'Premium',3,4,false,2),('D',4,'Premium',4,4,false,2),('D',5,'Premium',5,4,false,2),('D',6,'Premium',6,4,false,2),('D',7,'Premium',7,4,false,2),('D',8,'Premium',8,4,false,2),('D',9,'Premium',9,4,false,2),('D',10,'Premium',10,4,false,2),
('E',1,'Premium',1,5,false,2),('E',2,'Premium',2,5,false,2),('E',3,'Premium',3,5,false,2),('E',4,'Premium',4,5,false,2),('E',5,'Premium',5,5,false,2),('E',6,'Premium',6,5,false,2),('E',7,'Premium',7,5,false,2),('E',8,'Premium',8,5,false,2),('E',9,'Premium',9,5,false,2),('E',10,'Premium',10,5,false,2),
('F',1,'Standard',1,6,false,2),('F',2,'Standard',2,6,false,2),('F',3,'Standard',3,6,false,2),('F',4,'Standard',4,6,false,2),('F',5,'Standard',5,6,false,2),('F',6,'Standard',6,6,false,2),('F',7,'Standard',7,6,false,2),('F',8,'Standard',8,6,false,2),('F',9,'Standard',9,6,false,2),('F',10,'Standard',10,6,false,2),
('G',1,'Standard',1,7,false,2),('G',2,'Standard',2,7,false,2),('G',3,'Standard',3,7,false,2),('G',4,'Standard',4,7,false,2),('G',5,'Standard',5,7,false,2),('G',6,'Standard',6,7,false,2),('G',7,'Standard',7,7,false,2),('G',8,'Standard',8,7,false,2),('G',9,'Standard',9,7,false,2),('G',10,'Standard',10,7,false,2),
('H',1,'Adapted',1,8,false,2),('H',2,'Standard',2,8,false,2),('H',3,'Standard',3,8,false,2),('H',4,'Standard',4,8,false,2),('H',5,'Standard',5,8,false,2),('H',6,'Standard',6,8,false,2),('H',7,'Standard',7,8,false,2),('H',8,'Standard',8,8,false,2),('H',9,'Standard',9,8,false,2),('H',10,'Adapted',10,8,false,2);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,3),('A',2,'Standard',2,1,false,3),('A',3,'Standard',3,1,false,3),('A',4,'Standard',4,1,false,3),('A',5,'Standard',5,1,false,3),('A',6,'Standard',6,1,false,3),('A',7,'Standard',7,1,false,3),('A',8,'Standard',8,1,false,3),('A',9,'Standard',9,1,false,3),('A',10,'Adapted',10,1,false,3),
('B',1,'Standard',1,2,false,3),('B',2,'Standard',2,2,false,3),('B',3,'Standard',3,2,false,3),('B',4,'Standard',4,2,false,3),('B',5,'Standard',5,2,false,3),('B',6,'Standard',6,2,false,3),('B',7,'Standard',7,2,false,3),('B',8,'Standard',8,2,false,3),('B',9,'Standard',9,2,false,3),('B',10,'Standard',10,2,false,3),
('C',1,'Premium',1,3,false,3),('C',2,'Premium',2,3,false,3),('C',3,'Premium',3,3,false,3),('C',4,'Premium',4,3,false,3),('C',5,'Premium',5,3,false,3),('C',6,'Premium',6,3,false,3),('C',7,'Premium',7,3,false,3),('C',8,'Premium',8,3,false,3),('C',9,'Premium',9,3,false,3),('C',10,'Premium',10,3,false,3),
('D',1,'Premium',1,4,false,3),('D',2,'Premium',2,4,false,3),('D',3,'Premium',3,4,false,3),('D',4,'Premium',4,4,false,3),('D',5,'Premium',5,4,false,3),('D',6,'Premium',6,4,false,3),('D',7,'Premium',7,4,false,3),('D',8,'Premium',8,4,false,3),('D',9,'Premium',9,4,false,3),('D',10,'Premium',10,4,false,3),
('E',1,'Premium',1,5,false,3),('E',2,'Premium',2,5,false,3),('E',3,'Premium',3,5,false,3),('E',4,'Premium',4,5,false,3),('E',5,'Premium',5,5,false,3),('E',6,'Premium',6,5,false,3),('E',7,'Premium',7,5,false,3),('E',8,'Premium',8,5,false,3),('E',9,'Premium',9,5,false,3),('E',10,'Premium',10,5,false,3),
('F',1,'Standard',1,6,false,3),('F',2,'Standard',2,6,false,3),('F',3,'Standard',3,6,false,3),('F',4,'Standard',4,6,false,3),('F',5,'Standard',5,6,false,3),('F',6,'Standard',6,6,false,3),('F',7,'Standard',7,6,false,3),('F',8,'Standard',8,6,false,3),('F',9,'Standard',9,6,false,3),('F',10,'Standard',10,6,false,3),
('G',1,'Standard',1,7,false,3),('G',2,'Standard',2,7,false,3),('G',3,'Standard',3,7,false,3),('G',4,'Standard',4,7,false,3),('G',5,'Standard',5,7,false,3),('G',6,'Standard',6,7,false,3),('G',7,'Standard',7,7,false,3),('G',8,'Standard',8,7,false,3),('G',9,'Standard',9,7,false,3),('G',10,'Standard',10,7,false,3),
('H',1,'Adapted',1,8,false,3),('H',2,'Standard',2,8,false,3),('H',3,'Standard',3,8,false,3),('H',4,'Standard',4,8,false,3),('H',5,'Standard',5,8,false,3),('H',6,'Standard',6,8,false,3),('H',7,'Standard',7,8,false,3),('H',8,'Standard',8,8,false,3),('H',9,'Standard',9,8,false,3),('H',10,'Adapted',10,8,false,3);

INSERT INTO SCREENING (screening_date_time, precio, movie_id, room_id)
VALUES -- Dune Part Two (id=1)
    ('2026-04-10T18:00', 8.50, 1, 1),
    ('2026-04-10T21:30', 9.50, 1, 1),
    ('2026-04-11T17:00', 8.50, 1, 2),
    ('2026-04-11T20:30', 9.50, 1, 2),
    ('2026-04-12T18:30', 9.00, 1, 3),
    -- Blade Runner (id=2)
    ('2026-04-10T19:00', 7.50, 2, 2),
    ('2026-04-10T22:00', 8.50, 2, 2),
    ('2026-04-11T18:00', 7.50, 2, 3),
    ('2026-04-11T21:00', 8.50, 2, 3),
    ('2026-04-12T20:00', 8.00, 2, 1),
    -- Interstellar (id=3)
    ('2026-04-10T17:30', 8.50, 3, 3),
    ('2026-04-10T21:00', 9.50, 3, 3),
    ('2026-04-11T16:30', 8.50, 3, 1),
    ('2026-04-11T20:00', 9.50, 3, 1),
    ('2026-04-12T19:00', 9.00, 3, 2),
    -- Inception (id=4)
    ('2026-04-10T20:00', 8.00, 4, 1),
    ('2026-04-10T22:45', 9.00, 4, 1),
    ('2026-04-11T18:30', 8.50, 4, 2),
    ('2026-04-11T21:30', 9.00, 4, 2),
    ('2026-04-12T17:30', 8.00, 4, 3),
    -- The Dark Knight (id=5)
    ('2026-04-10T19:30', 9.00, 5, 3),
    ('2026-04-10T22:30', 10.00, 5, 3),
    ('2026-04-11T19:45', 9.50, 5, 1),
    ('2026-04-11T22:15', 10.00, 5, 1),
    ('2026-04-12T20:30', 9.50, 5, 2),
    -- The Matrix (id=6)
    ('2026-04-10T16:30', 7.50, 6, 2),
    ('2026-04-10T19:00', 8.00, 6, 2),
    ('2026-04-11T17:00', 7.50, 6, 3),
    ('2026-04-11T20:00', 8.50, 6, 3),
    ('2026-04-12T18:00', 8.00, 6, 1),
    -- Dune: Part Three (id=7)
    ('2026-04-13T18:00', 9.50, 7, 1),
    ('2026-04-13T21:30', 10.00, 7, 2),
    ('2026-04-14T17:00', 9.50, 7, 3);
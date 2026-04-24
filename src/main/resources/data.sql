INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Carrer de Pere Martell, 66', 'Tarragona', 'IMPERIAL TARRAGONA', '43005');
INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Carrer de la Marina, 324', 'BARCELONA', 'IMPERIAL BARCELONA', '08024');
INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Calle de Alcalá, 123', 'MADRID', 'IMPERIAL MADRID', '28043');
INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Avenida de Francia, 30', 'VALENCIA', 'IMPERIAL VALENCIA', '46023');
INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Calle de la Buhaira, 2', 'SEVILLA', 'IMPERIAL SEVILLA', '41004');



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
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 1', 120, 4);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 2', 120, 4);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 3', 120, 4);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 1', 120, 5);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 2', 120, 5);
INSERT INTO ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES ('Sala 3', 120, 5);
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

-- ═══ SEATS (Salas 1-3 · Barcelona) ═══
INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,4),('A',2,'Standard',2,1,false,4),('A',3,'Standard',3,1,false,4),('A',4,'Standard',4,1,false,4),('A',5,'Standard',5,1,false,4),('A',6,'Standard',6,1,false,4),('A',7,'Standard',7,1,false,4),('A',8,'Standard',8,1,false,4),('A',9,'Standard',9,1,false,4),('A',10,'Adapted',10,1,false,4),
('B',1,'Standard',1,2,false,4),('B',2,'Standard',2,2,false,4),('B',3,'Standard',3,2,false,4),('B',4,'Standard',4,2,false,4),('B',5,'Standard',5,2,false,4),('B',6,'Standard',6,2,false,4),('B',7,'Standard',7,2,false,4),('B',8,'Standard',8,2,false,4),('B',9,'Standard',9,2,false,4),('B',10,'Standard',10,2,false,4),
('C',1,'Premium',1,3,false,4),('C',2,'Premium',2,3,false,4),('C',3,'Premium',3,3,false,4),('C',4,'Premium',4,3,false,4),('C',5,'Premium',5,3,false,4),('C',6,'Premium',6,3,false,4),('C',7,'Premium',7,3,false,4),('C',8,'Premium',8,3,false,4),('C',9,'Premium',9,3,false,4),('C',10,'Premium',10,3,false,4),
('D',1,'Premium',1,4,false,4),('D',2,'Premium',2,4,false,4),('D',3,'Premium',3,4,false,4),('D',4,'Premium',4,4,false,4),('D',5,'Premium',5,4,false,4),('D',6,'Premium',6,4,false,4),('D',7,'Premium',7,4,false,4),('D',8,'Premium',8,4,false,4),('D',9,'Premium',9,4,false,4),('D',10,'Premium',10,4,false,4),
('E',1,'Premium',1,5,false,4),('E',2,'Premium',2,5,false,4),('E',3,'Premium',3,5,false,4),('E',4,'Premium',4,5,false,4),('E',5,'Premium',5,5,false,4),('E',6,'Premium',6,5,false,4),('E',7,'Premium',7,5,false,4),('E',8,'Premium',8,5,false,4),('E',9,'Premium',9,5,false,4),('E',10,'Premium',10,5,false,4),
('F',1,'Standard',1,6,false,4),('F',2,'Standard',2,6,false,4),('F',3,'Standard',3,6,false,4),('F',4,'Standard',4,6,false,4),('F',5,'Standard',5,6,false,4),('F',6,'Standard',6,6,false,4),('F',7,'Standard',7,6,false,4),('F',8,'Standard',8,6,false,4),('F',9,'Standard',9,6,false,4),('F',10,'Standard',10,6,false,4),
('G',1,'Standard',1,7,false,4),('G',2,'Standard',2,7,false,4),('G',3,'Standard',3,7,false,4),('G',4,'Standard',4,7,false,4),('G',5,'Standard',5,7,false,4),('G',6,'Standard',6,7,false,4),('G',7,'Standard',7,7,false,4),('G',8,'Standard',8,7,false,4),('G',9,'Standard',9,7,false,4),('G',10,'Standard',10,7,false,4),
('H',1,'Adapted',1,8,false,4),('H',2,'Standard',2,8,false,4),('H',3,'Standard',3,8,false,4),('H',4,'Standard',4,8,false,4),('H',5,'Standard',5,8,false,4),('H',6,'Standard',6,8,false,4),('H',7,'Standard',7,8,false,4),('H',8,'Standard',8,8,false,4),('H',9,'Standard',9,8,false,4),('H',10,'Adapted',10,8,false,4);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,5),('A',2,'Standard',2,1,false,5),('A',3,'Standard',3,1,false,5),('A',4,'Standard',4,1,false,5),('A',5,'Standard',5,1,false,5),('A',6,'Standard',6,1,false,5),('A',7,'Standard',7,1,false,5),('A',8,'Standard',8,1,false,5),('A',9,'Standard',9,1,false,5),('A',10,'Adapted',10,1,false,5),
('B',1,'Standard',1,2,false,5),('B',2,'Standard',2,2,false,5),('B',3,'Standard',3,2,false,5),('B',4,'Standard',4,2,false,5),('B',5,'Standard',5,2,false,5),('B',6,'Standard',6,2,false,5),('B',7,'Standard',7,2,false,5),('B',8,'Standard',8,2,false,5),('B',9,'Standard',9,2,false,5),('B',10,'Standard',10,2,false,5),
('C',1,'Premium',1,3,false,5),('C',2,'Premium',2,3,false,5),('C',3,'Premium',3,3,false,5),('C',4,'Premium',4,3,false,5),('C',5,'Premium',5,3,false,5),('C',6,'Premium',6,3,false,5),('C',7,'Premium',7,3,false,5),('C',8,'Premium',8,3,false,5),('C',9,'Premium',9,3,false,5),('C',10,'Premium',10,3,false,5),
('D',1,'Premium',1,4,false,5),('D',2,'Premium',2,4,false,5),('D',3,'Premium',3,4,false,5),('D',4,'Premium',4,4,false,5),('D',5,'Premium',5,4,false,5),('D',6,'Premium',6,4,false,5),('D',7,'Premium',7,4,false,5),('D',8,'Premium',8,4,false,5),('D',9,'Premium',9,4,false,5),('D',10,'Premium',10,4,false,5),
('E',1,'Premium',1,5,false,5),('E',2,'Premium',2,5,false,5),('E',3,'Premium',3,5,false,5),('E',4,'Premium',4,5,false,5),('E',5,'Premium',5,5,false,5),('E',6,'Premium',6,5,false,5),('E',7,'Premium',7,5,false,5),('E',8,'Premium',8,5,false,5),('E',9,'Premium',9,5,false,5),('E',10,'Premium',10,5,false,5),
('F',1,'Standard',1,6,false,5),('F',2,'Standard',2,6,false,5),('F',3,'Standard',3,6,false,5),('F',4,'Standard',4,6,false,5),('F',5,'Standard',5,6,false,5),('F',6,'Standard',6,6,false,5),('F',7,'Standard',7,6,false,5),('F',8,'Standard',8,6,false,5),('F',9,'Standard',9,6,false,5),('F',10,'Standard',10,6,false,5),
('G',1,'Standard',1,7,false,5),('G',2,'Standard',2,7,false,5),('G',3,'Standard',3,7,false,5),('G',4,'Standard',4,7,false,5),('G',5,'Standard',5,7,false,5),('G',6,'Standard',6,7,false,5),('G',7,'Standard',7,7,false,5),('G',8,'Standard',8,7,false,5),('G',9,'Standard',9,7,false,5),('G',10,'Standard',10,7,false,5),
('H',1,'Adapted',1,8,false,5),('H',2,'Standard',2,8,false,5),('H',3,'Standard',3,8,false,5),('H',4,'Standard',4,8,false,5),('H',5,'Standard',5,8,false,5),('H',6,'Standard',6,8,false,5),('H',7,'Standard',7,8,false,5),('H',8,'Standard',8,8,false,5),('H',9,'Standard',9,8,false,5),('H',10,'Adapted',10,8,false,5);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,6),('A',2,'Standard',2,1,false,6),('A',3,'Standard',3,1,false,6),('A',4,'Standard',4,1,false,6),('A',5,'Standard',5,1,false,6),('A',6,'Standard',6,1,false,6),('A',7,'Standard',7,1,false,6),('A',8,'Standard',8,1,false,6),('A',9,'Standard',9,1,false,6),('A',10,'Adapted',10,1,false,6),
('B',1,'Standard',1,2,false,6),('B',2,'Standard',2,2,false,6),('B',3,'Standard',3,2,false,6),('B',4,'Standard',4,2,false,6),('B',5,'Standard',5,2,false,6),('B',6,'Standard',6,2,false,6),('B',7,'Standard',7,2,false,6),('B',8,'Standard',8,2,false,6),('B',9,'Standard',9,2,false,6),('B',10,'Standard',10,2,false,6),
('C',1,'Premium',1,3,false,6),('C',2,'Premium',2,3,false,6),('C',3,'Premium',3,3,false,6),('C',4,'Premium',4,3,false,6),('C',5,'Premium',5,3,false,6),('C',6,'Premium',6,3,false,6),('C',7,'Premium',7,3,false,6),('C',8,'Premium',8,3,false,6),('C',9,'Premium',9,3,false,6),('C',10,'Premium',10,3,false,6),
('D',1,'Premium',1,4,false,6),('D',2,'Premium',2,4,false,6),('D',3,'Premium',3,4,false,6),('D',4,'Premium',4,4,false,6),('D',5,'Premium',5,4,false,6),('D',6,'Premium',6,4,false,6),('D',7,'Premium',7,4,false,6),('D',8,'Premium',8,4,false,6),('D',9,'Premium',9,4,false,6),('D',10,'Premium',10,4,false,6),
('E',1,'Premium',1,5,false,6),('E',2,'Premium',2,5,false,6),('E',3,'Premium',3,5,false,6),('E',4,'Premium',4,5,false,6),('E',5,'Premium',5,5,false,6),('E',6,'Premium',6,5,false,6),('E',7,'Premium',7,5,false,6),('E',8,'Premium',8,5,false,6),('E',9,'Premium',9,5,false,6),('E',10,'Premium',10,5,false,6),
('F',1,'Standard',1,6,false,6),('F',2,'Standard',2,6,false,6),('F',3,'Standard',3,6,false,6),('F',4,'Standard',4,6,false,6),('F',5,'Standard',5,6,false,6),('F',6,'Standard',6,6,false,6),('F',7,'Standard',7,6,false,6),('F',8,'Standard',8,6,false,6),('F',9,'Standard',9,6,false,6),('F',10,'Standard',10,6,false,6),
('G',1,'Standard',1,7,false,6),('G',2,'Standard',2,7,false,6),('G',3,'Standard',3,7,false,6),('G',4,'Standard',4,7,false,6),('G',5,'Standard',5,7,false,6),('G',6,'Standard',6,7,false,6),('G',7,'Standard',7,7,false,6),('G',8,'Standard',8,7,false,6),('G',9,'Standard',9,7,false,6),('G',10,'Standard',10,7,false,6),
('H',1,'Adapted',1,8,false,6),('H',2,'Standard',2,8,false,6),('H',3,'Standard',3,8,false,6),('H',4,'Standard',4,8,false,6),('H',5,'Standard',5,8,false,6),('H',6,'Standard',6,8,false,6),('H',7,'Standard',7,8,false,6),('H',8,'Standard',8,8,false,6),('H',9,'Standard',9,8,false,6),('H',10,'Adapted',10,8,false,6);

-- ═══ SEATS (Salas 1-3 · Madrid) ═══
INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,3),('A',2,'Standard',2,1,false,3),('A',3,'Standard',3,1,false,3),('A',4,'Standard',4,1,false,3),('A',5,'Standard',5,1,false,3),('A',6,'Standard',6,1,false,3),('A',7,'Standard',7,1,false,3),('A',8,'Standard',8,1,false,3),('A',9,'Standard',9,1,false,3),('A',10,'Adapted',10,1,false,3),
('B',1,'Standard',1,2,false,3),('B',2,'Standard',2,2,false,3),('B',3,'Standard',3,2,false,3),('B',4,'Standard',4,2,false,3),('B',5,'Standard',5,2,false,3),('B',6,'Standard',6,2,false,3),('B',7,'Standard',7,2,false,3),('B',8,'Standard',8,2,false,3),('B',9,'Standard',9,2,false,3),('B',10,'Standard',10,2,false,3),
('C',1,'Premium',1,3,false,3),('C',2,'Premium',2,3,false,3),('C',3,'Premium',3,3,false,3),('C',4,'Premium',4,3,false,3),('C',5,'Premium',5,3,false,3),('C',6,'Premium',6,3,false,3),('C',7,'Premium',7,3,false,3),('C',8,'Premium',8,3,false,3),('C',9,'Premium',9,3,false,3),('C',10,'Premium',10,3,false,3),
('D',1,'Premium',1,4,false,3),('D',2,'Premium',2,4,false,3),('D',3,'Premium',3,4,false,3),('D',4,'Premium',4,4,false,3),('D',5,'Premium',5,4,false,3),('D',6,'Premium',6,4,false,3),('D',7,'Premium',7,4,false,3),('D',8,'Premium',8,4,false,3),('D',9,'Premium',9,4,false,3),('D',10,'Premium',10,4,false,3),
('E',1,'Premium',1,5,false,3),('E',2,'Premium',2,5,false,3),('E',3,'Premium',3,5,false,3),('E',4,'Premium',4,5,false,3),('E',5,'Premium',5,5,false,3),('E',6,'Premium',6,5,false,3),('E',7,'Premium',7,5,false,3),('E',8,'Premium',8,5,false,3),('E',9,'Premium',9,5,false,3),('E',10,'Premium',10,5,false,3),
('F',1,'Standard',1,6,false,3),('F',2,'Standard',2,6,false,3),('F',3,'Standard',3,6,false,3),('F',4,'Standard',4,6,false,3),('F',5,'Standard',5,6,false,3),('F',6,'Standard',6,6,false,3),('F',7,'Standard',7,6,false,3),('F',8,'Standard',8,6,false,3),('F',9,'Standard',9,6,false,3),('F',10,'Standard',10,6,false,3),
('G',1,'Standard',1,7,false,3),('G',2,'Standard',2,7,false,3),('G',3,'Standard',3,7,false,3),('G',4,'Standard',4,7,false,3),('G',5,'Standard',5,7,false,3),('G',6,'Standard',6,7,false,3),('G',7,'Standard',7,7,false,3),('G',8,'Standard',8,7,false,3),('G',9,'Standard',9,7,false,3),('G',10,'Standard',10,7,false,3),
('H',1,'Adapted',1,8,false,3),('H',2,'Standard',2,8,false,3),('H',3,'Standard',3,8,false,3),('H',4,'Standard',4,8,false,3),('H',5,'Standard',5,8,false,3),('H',6,'Standard',6,8,false,3),('H',7,'Standard',7,8,false,3),('H',8,'Standard',8,8,false,3),('H',9,'Standard',9,8,false,3),('H',10,'Adapted',10,8,false,3);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,7),('A',2,'Standard',2,1,false,7),('A',3,'Standard',3,1,false,7),('A',4,'Standard',4,1,false,7),('A',5,'Standard',5,1,false,7),('A',6,'Standard',6,1,false,7),('A',7,'Standard',7,1,false,7),('A',8,'Standard',8,1,false,7),('A',9,'Standard',9,1,false,7),('A',10,'Adapted',10,1,false,7),
('B',1,'Standard',1,2,false,7),('B',2,'Standard',2,2,false,7),('B',3,'Standard',3,2,false,7),('B',4,'Standard',4,2,false,7),('B',5,'Standard',5,2,false,7),('B',6,'Standard',6,2,false,7),('B',7,'Standard',7,2,false,7),('B',8,'Standard',8,2,false,7),('B',9,'Standard',9,2,false,7),('B',10,'Standard',10,2,false,7),
('C',1,'Premium',1,3,false,7),('C',2,'Premium',2,3,false,7),('C',3,'Premium',3,3,false,7),('C',4,'Premium',4,3,false,7),('C',5,'Premium',5,3,false,7),('C',6,'Premium',6,3,false,7),('C',7,'Premium',7,3,false,7),('C',8,'Premium',8,3,false,7),('C',9,'Premium',9,3,false,7),('C',10,'Premium',10,3,false,7),
('D',1,'Premium',1,4,false,7),('D',2,'Premium',2,4,false,7),('D',3,'Premium',3,4,false,7),('D',4,'Premium',4,4,false,7),('D',5,'Premium',5,4,false,7),('D',6,'Premium',6,4,false,7),('D',7,'Premium',7,4,false,7),('D',8,'Premium',8,4,false,7),('D',9,'Premium',9,4,false,7),('D',10,'Premium',10,4,false,7),
('E',1,'Premium',1,5,false,7),('E',2,'Premium',2,5,false,7),('E',3,'Premium',3,5,false,7),('E',4,'Premium',4,5,false,7),('E',5,'Premium',5,5,false,7),('E',6,'Premium',6,5,false,7),('E',7,'Premium',7,5,false,7),('E',8,'Premium',8,5,false,7),('E',9,'Premium',9,5,false,7),('E',10,'Premium',10,5,false,7),
('F',1,'Standard',1,6,false,7),('F',2,'Standard',2,6,false,7),('F',3,'Standard',3,6,false,7),('F',4,'Standard',4,6,false,7),('F',5,'Standard',5,6,false,7),('F',6,'Standard',6,6,false,7),('F',7,'Standard',7,6,false,7),('F',8,'Standard',8,6,false,7),('F',9,'Standard',9,6,false,7),('F',10,'Standard',10,6,false,7),
('G',1,'Standard',1,7,false,7),('G',2,'Standard',2,7,false,7),('G',3,'Standard',3,7,false,7),('G',4,'Standard',4,7,false,7),('G',5,'Standard',5,7,false,7),('G',6,'Standard',6,7,false,7),('G',7,'Standard',7,7,false,7),('G',8,'Standard',8,7,false,7),('G',9,'Standard',9,7,false,7),('G',10,'Standard',10,7,false,7),
('H',1,'Adapted',1,8,false,7),('H',2,'Standard',2,8,false,7),('H',3,'Standard',3,8,false,7),('H',4,'Standard',4,8,false,7),('H',5,'Standard',5,8,false,7),('H',6,'Standard',6,8,false,7),('H',7,'Standard',7,8,false,7),('H',8,'Standard',8,8,false,7),('H',9,'Standard',9,8,false,7),('H',10,'Adapted',10,8,false,7);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,8),('A',2,'Standard',2,1,false,8),('A',3,'Standard',3,1,false,8),('A',4,'Standard',4,1,false,8),('A',5,'Standard',5,1,false,8),('A',6,'Standard',6,1,false,8),('A',7,'Standard',7,1,false,8),('A',8,'Standard',8,1,false,8),('A',9,'Standard',9,1,false,8),('A',10,'Adapted',10,1,false,8),
('B',1,'Standard',1,2,false,8),('B',2,'Standard',2,2,false,8),('B',3,'Standard',3,2,false,8),('B',4,'Standard',4,2,false,8),('B',5,'Standard',5,2,false,8),('B',6,'Standard',6,2,false,8),('B',7,'Standard',7,2,false,8),('B',8,'Standard',8,2,false,8),('B',9,'Standard',9,2,false,8),('B',10,'Standard',10,2,false,8),
('C',1,'Premium',1,3,false,8),('C',2,'Premium',2,3,false,8),('C',3,'Premium',3,3,false,8),('C',4,'Premium',4,3,false,8),('C',5,'Premium',5,3,false,8),('C',6,'Premium',6,3,false,8),('C',7,'Premium',7,3,false,8),('C',8,'Premium',8,3,false,8),('C',9,'Premium',9,3,false,8),('C',10,'Premium',10,3,false,8),
('D',1,'Premium',1,4,false,8),('D',2,'Premium',2,4,false,8),('D',3,'Premium',3,4,false,8),('D',4,'Premium',4,4,false,8),('D',5,'Premium',5,4,false,8),('D',6,'Premium',6,4,false,8),('D',7,'Premium',7,4,false,8),('D',8,'Premium',8,4,false,8),('D',9,'Premium',9,4,false,8),('D',10,'Premium',10,4,false,8),
('E',1,'Premium',1,5,false,8),('E',2,'Premium',2,5,false,8),('E',3,'Premium',3,5,false,8),('E',4,'Premium',4,5,false,8),('E',5,'Premium',5,5,false,8),('E',6,'Premium',6,5,false,8),('E',7,'Premium',7,5,false,8),('E',8,'Premium',8,5,false,8),('E',9,'Premium',9,5,false,8),('E',10,'Premium',10,5,false,8),
('F',1,'Standard',1,6,false,8),('F',2,'Standard',2,6,false,8),('F',3,'Standard',3,6,false,8),('F',4,'Standard',4,6,false,8),('F',5,'Standard',5,6,false,8),('F',6,'Standard',6,6,false,8),('F',7,'Standard',7,6,false,8),('F',8,'Standard',8,6,false,8),('F',9,'Standard',9,6,false,8),('F',10,'Standard',10,6,false,8),
('G',1,'Standard',1,7,false,8),('G',2,'Standard',2,7,false,8),('G',3,'Standard',3,7,false,8),('G',4,'Standard',4,7,false,8),('G',5,'Standard',5,7,false,8),('G',6,'Standard',6,7,false,8),('G',7,'Standard',7,7,false,8),('G',8,'Standard',8,7,false,8),('G',9,'Standard',9,7,false,8),('G',10,'Standard',10,7,false,8),
('H',1,'Adapted',1,8,false,8),('H',2,'Standard',2,8,false,8),('H',3,'Standard',3,8,false,8),('H',4,'Standard',4,8,false,8),('H',5,'Standard',5,8,false,8),('H',6,'Standard',6,8,false,8),('H',7,'Standard',7,8,false,8),('H',8,'Standard',8,8,false,8),('H',9,'Standard',9,8,false,8),('H',10,'Adapted',10,8,false,8);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,9),('A',2,'Standard',2,1,false,9),('A',3,'Standard',3,1,false,9),('A',4,'Standard',4,1,false,9),('A',5,'Standard',5,1,false,9),('A',6,'Standard',6,1,false,9),('A',7,'Standard',7,1,false,9),('A',8,'Standard',8,1,false,9),('A',9,'Standard',9,1,false,9),('A',10,'Adapted',10,1,false,9),
('B',1,'Standard',1,2,false,9),('B',2,'Standard',2,2,false,9),('B',3,'Standard',3,2,false,9),('B',4,'Standard',4,2,false,9),('B',5,'Standard',5,2,false,9),('B',6,'Standard',6,2,false,9),('B',7,'Standard',7,2,false,9),('B',8,'Standard',8,2,false,9),('B',9,'Standard',9,2,false,9),('B',10,'Standard',10,2,false,9),
('C',1,'Premium',1,3,false,9),('C',2,'Premium',2,3,false,9),('C',3,'Premium',3,3,false,9),('C',4,'Premium',4,3,false,9),('C',5,'Premium',5,3,false,9),('C',6,'Premium',6,3,false,9),('C',7,'Premium',7,3,false,9),('C',8,'Premium',8,3,false,9),('C',9,'Premium',9,3,false,9),('C',10,'Premium',10,3,false,9),
('D',1,'Premium',1,4,false,9),('D',2,'Premium',2,4,false,9),('D',3,'Premium',3,4,false,9),('D',4,'Premium',4,4,false,9),('D',5,'Premium',5,4,false,9),('D',6,'Premium',6,4,false,9),('D',7,'Premium',7,4,false,9),('D',8,'Premium',8,4,false,9),('D',9,'Premium',9,4,false,9),('D',10,'Premium',10,4,false,9),
('E',1,'Premium',1,5,false,9),('E',2,'Premium',2,5,false,9),('E',3,'Premium',3,5,false,9),('E',4,'Premium',4,5,false,9),('E',5,'Premium',5,5,false,9),('E',6,'Premium',6,5,false,9),('E',7,'Premium',7,5,false,9),('E',8,'Premium',8,5,false,9),('E',9,'Premium',9,5,false,9),('E',10,'Premium',10,5,false,9),
('F',1,'Standard',1,6,false,9),('F',2,'Standard',2,6,false,9),('F',3,'Standard',3,6,false,9),('F',4,'Standard',4,6,false,9),('F',5,'Standard',5,6,false,9),('F',6,'Standard',6,6,false,9),('F',7,'Standard',7,6,false,9),('F',8,'Standard',8,6,false,9),('F',9,'Standard',9,6,false,9),('F',10,'Standard',10,6,false,9),
('G',1,'Standard',1,7,false,9),('G',2,'Standard',2,7,false,9),('G',3,'Standard',3,7,false,9),('G',4,'Standard',4,7,false,9),('G',5,'Standard',5,7,false,9),('G',6,'Standard',6,7,false,9),('G',7,'Standard',7,7,false,9),('G',8,'Standard',8,7,false,9),('G',9,'Standard',9,7,false,9),('G',10,'Standard',10,7,false,9),
('H',1,'Adapted',1,8,false,9),('H',2,'Standard',2,8,false,9),('H',3,'Standard',3,8,false,9),('H',4,'Standard',4,8,false,9),('H',5,'Standard',5,8,false,9),('H',6,'Standard',6,8,false,9),('H',7,'Standard',7,8,false,9),('H',8,'Standard',8,8,false,9),('H',9,'Standard',9,8,false,9),('H',10,'Adapted',10,8,false,9);

-- ═══ SEATS (Salas 1-3 · Valencia) ═══
INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,10),('A',2,'Standard',2,1,false,10),('A',3,'Standard',3,1,false,10),('A',4,'Standard',4,1,false,10),('A',5,'Standard',5,1,false,10),('A',6,'Standard',6,1,false,10),('A',7,'Standard',7,1,false,10),('A',8,'Standard',8,1,false,10),('A',9,'Standard',9,1,false,10),('A',10,'Adapted',10,1,false,10),
('B',1,'Standard',1,2,false,10),('B',2,'Standard',2,2,false,10),('B',3,'Standard',3,2,false,10),('B',4,'Standard',4,2,false,10),('B',5,'Standard',5,2,false,10),('B',6,'Standard',6,2,false,10),('B',7,'Standard',7,2,false,10),('B',8,'Standard',8,2,false,10),('B',9,'Standard',9,2,false,10),('B',10,'Standard',10,2,false,10),
('C',1,'Premium',1,3,false,10),('C',2,'Premium',2,3,false,10),('C',3,'Premium',3,3,false,10),('C',4,'Premium',4,3,false,10),('C',5,'Premium',5,3,false,10),('C',6,'Premium',6,3,false,10),('C',7,'Premium',7,3,false,10),('C',8,'Premium',8,3,false,10),('C',9,'Premium',9,3,false,10),('C',10,'Premium',10,3,false,10),
('D',1,'Premium',1,4,false,10),('D',2,'Premium',2,4,false,10),('D',3,'Premium',3,4,false,10),('D',4,'Premium',4,4,false,10),('D',5,'Premium',5,4,false,10),('D',6,'Premium',6,4,false,10),('D',7,'Premium',7,4,false,10),('D',8,'Premium',8,4,false,10),('D',9,'Premium',9,4,false,10),('D',10,'Premium',10,4,false,10),
('E',1,'Premium',1,5,false,10),('E',2,'Premium',2,5,false,10),('E',3,'Premium',3,5,false,10),('E',4,'Premium',4,5,false,10),('E',5,'Premium',5,5,false,10),('E',6,'Premium',6,5,false,10),('E',7,'Premium',7,5,false,10),('E',8,'Premium',8,5,false,10),('E',9,'Premium',9,5,false,10),('E',10,'Premium',10,5,false,10),
('F',1,'Standard',1,6,false,10),('F',2,'Standard',2,6,false,10),('F',3,'Standard',3,6,false,10),('F',4,'Standard',4,6,false,10),('F',5,'Standard',5,6,false,10),('F',6,'Standard',6,6,false,10),('F',7,'Standard',7,6,false,10),('F',8,'Standard',8,6,false,10),('F',9,'Standard',9,6,false,10),('F',10,'Standard',10,6,false,10),
('G',1,'Standard',1,7,false,10),('G',2,'Standard',2,7,false,10),('G',3,'Standard',3,7,false,10),('G',4,'Standard',4,7,false,10),('G',5,'Standard',5,7,false,10),('G',6,'Standard',6,7,false,10),('G',7,'Standard',7,7,false,10),('G',8,'Standard',8,7,false,10),('G',9,'Standard',9,7,false,10),('G',10,'Standard',10,7,false,10),
('H',1,'Adapted',1,8,false,10),('H',2,'Standard',2,8,false,10),('H',3,'Standard',3,8,false,10),('H',4,'Standard',4,8,false,10),('H',5,'Standard',5,8,false,10),('H',6,'Standard',6,8,false,10),('H',7,'Standard',7,8,false,10),('H',8,'Standard',8,8,false,10),('H',9,'Standard',9,8,false,10),('H',10,'Adapted',10,8,false,10);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,11),('A',2,'Standard',2,1,false,11),('A',3,'Standard',3,1,false,11),('A',4,'Standard',4,1,false,11),('A',5,'Standard',5,1,false,11),('A',6,'Standard',6,1,false,11),('A',7,'Standard',7,1,false,11),('A',8,'Standard',8,1,false,11),('A',9,'Standard',9,1,false,11),('A',10,'Adapted',10,1,false,11),
('B',1,'Standard',1,2,false,11),('B',2,'Standard',2,2,false,11),('B',3,'Standard',3,2,false,11),('B',4,'Standard',4,2,false,11),('B',5,'Standard',5,2,false,11),('B',6,'Standard',6,2,false,11),('B',7,'Standard',7,2,false,11),('B',8,'Standard',8,2,false,11),('B',9,'Standard',9,2,false,11),('B',10,'Standard',10,2,false,11),
('C',1,'Premium',1,3,false,11),('C',2,'Premium',2,3,false,11),('C',3,'Premium',3,3,false,11),('C',4,'Premium',4,3,false,11),('C',5,'Premium',5,3,false,11),('C',6,'Premium',6,3,false,11),('C',7,'Premium',7,3,false,11),('C',8,'Premium',8,3,false,11),('C',9,'Premium',9,3,false,11),('C',10,'Premium',10,3,false,11),
('D',1,'Premium',1,4,false,11),('D',2,'Premium',2,4,false,11),('D',3,'Premium',3,4,false,11),('D',4,'Premium',4,4,false,11),('D',5,'Premium',5,4,false,11),('D',6,'Premium',6,4,false,11),('D',7,'Premium',7,4,false,11),('D',8,'Premium',8,4,false,11),('D',9,'Premium',9,4,false,11),('D',10,'Premium',10,4,false,11),
('E',1,'Premium',1,5,false,11),('E',2,'Premium',2,5,false,11),('E',3,'Premium',3,5,false,11),('E',4,'Premium',4,5,false,11),('E',5,'Premium',5,5,false,11),('E',6,'Premium',6,5,false,11),('E',7,'Premium',7,5,false,11),('E',8,'Premium',8,5,false,11),('E',9,'Premium',9,5,false,11),('E',10,'Premium',10,5,false,11),
('F',1,'Standard',1,6,false,11),('F',2,'Standard',2,6,false,11),('F',3,'Standard',3,6,false,11),('F',4,'Standard',4,6,false,11),('F',5,'Standard',5,6,false,11),('F',6,'Standard',6,6,false,11),('F',7,'Standard',7,6,false,11),('F',8,'Standard',8,6,false,11),('F',9,'Standard',9,6,false,11),('F',10,'Standard',10,6,false,11),
('G',1,'Standard',1,7,false,11),('G',2,'Standard',2,7,false,11),('G',3,'Standard',3,7,false,11),('G',4,'Standard',4,7,false,11),('G',5,'Standard',5,7,false,11),('G',6,'Standard',6,7,false,11),('G',7,'Standard',7,7,false,11),('G',8,'Standard',8,7,false,11),('G',9,'Standard',9,7,false,11),('G',10,'Standard',10,7,false,11),
('H',1,'Adapted',1,8,false,11),('H',2,'Standard',2,8,false,11),('H',3,'Standard',3,8,false,11),('H',4,'Standard',4,8,false,11),('H',5,'Standard',5,8,false,11),('H',6,'Standard',6,8,false,11),('H',7,'Standard',7,8,false,11),('H',8,'Standard',8,8,false,11),('H',9,'Standard',9,8,false,11),('H',10,'Adapted',10,8,false,11);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,12),('A',2,'Standard',2,1,false,12),('A',3,'Standard',3,1,false,12),('A',4,'Standard',4,1,false,12),('A',5,'Standard',5,1,false,12),('A',6,'Standard',6,1,false,12),('A',7,'Standard',7,1,false,12),('A',8,'Standard',8,1,false,12),('A',9,'Standard',9,1,false,12),('A',10,'Adapted',10,1,false,12),
('B',1,'Standard',1,2,false,12),('B',2,'Standard',2,2,false,12),('B',3,'Standard',3,2,false,12),('B',4,'Standard',4,2,false,12),('B',5,'Standard',5,2,false,12),('B',6,'Standard',6,2,false,12),('B',7,'Standard',7,2,false,12),('B',8,'Standard',8,2,false,12),('B',9,'Standard',9,2,false,12),('B',10,'Standard',10,2,false,12),
('C',1,'Premium',1,3,false,12),('C',2,'Premium',2,3,false,12),('C',3,'Premium',3,3,false,12),('C',4,'Premium',4,3,false,12),('C',5,'Premium',5,3,false,12),('C',6,'Premium',6,3,false,12),('C',7,'Premium',7,3,false,12),('C',8,'Premium',8,3,false,12),('C',9,'Premium',9,3,false,12),('C',10,'Premium',10,3,false,12),
('D',1,'Premium',1,4,false,12),('D',2,'Premium',2,4,false,12),('D',3,'Premium',3,4,false,12),('D',4,'Premium',4,4,false,12),('D',5,'Premium',5,4,false,12),('D',6,'Premium',6,4,false,12),('D',7,'Premium',7,4,false,12),('D',8,'Premium',8,4,false,12),('D',9,'Premium',9,4,false,12),('D',10,'Premium',10,4,false,12),
('E',1,'Premium',1,5,false,12),('E',2,'Premium',2,5,false,12),('E',3,'Premium',3,5,false,12),('E',4,'Premium',4,5,false,12),('E',5,'Premium',5,5,false,12),('E',6,'Premium',6,5,false,12),('E',7,'Premium',7,5,false,12),('E',8,'Premium',8,5,false,12),('E',9,'Premium',9,5,false,12),('E',10,'Premium',10,5,false,12),
('F',1,'Standard',1,6,false,12),('F',2,'Standard',2,6,false,12),('F',3,'Standard',3,6,false,12),('F',4,'Standard',4,6,false,12),('F',5,'Standard',5,6,false,12),('F',6,'Standard',6,6,false,12),('F',7,'Standard',7,6,false,12),('F',8,'Standard',8,6,false,12),('F',9,'Standard',9,6,false,12),('F',10,'Standard',10,6,false,12),
('G',1,'Standard',1,7,false,12),('G',2,'Standard',2,7,false,12),('G',3,'Standard',3,7,false,12),('G',4,'Standard',4,7,false,12),('G',5,'Standard',5,7,false,12),('G',6,'Standard',6,7,false,12),('G',7,'Standard',7,7,false,12),('G',8,'Standard',8,7,false,12),('G',9,'Standard',9,7,false,12),('G',10,'Standard',10,7,false,12),
('H',1,'Adapted',1,8,false,12),('H',2,'Standard',2,8,false,12),('H',3,'Standard',3,8,false,12),('H',4,'Standard',4,8,false,12),('H',5,'Standard',5,8,false,12),('H',6,'Standard',6,8,false,12),('H',7,'Standard',7,8,false,12),('H',8,'Standard',8,8,false,12),('H',9,'Standard',9,8,false,12),('H',10,'Adapted',10,8,false,12);

-- ═══ SEATS (Salas 1-3 · Sevilla) ═══
INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,13),('A',2,'Standard',2,1,false,13),('A',3,'Standard',3,1,false,13),('A',4,'Standard',4,1,false,13),('A',5,'Standard',5,1,false,13),('A',6,'Standard',6,1,false,13),('A',7,'Standard',7,1,false,13),('A',8,'Standard',8,1,false,13),('A',9,'Standard',9,1,false,13),('A',10,'Adapted',10,1,false,13),
('B',1,'Standard',1,2,false,13),('B',2,'Standard',2,2,false,13),('B',3,'Standard',3,2,false,13),('B',4,'Standard',4,2,false,13),('B',5,'Standard',5,2,false,13),('B',6,'Standard',6,2,false,13),('B',7,'Standard',7,2,false,13),('B',8,'Standard',8,2,false,13),('B',9,'Standard',9,2,false,13),('B',10,'Standard',10,2,false,13),
('C',1,'Premium',1,3,false,13),('C',2,'Premium',2,3,false,13),('C',3,'Premium',3,3,false,13),('C',4,'Premium',4,3,false,13),('C',5,'Premium',5,3,false,13),('C',6,'Premium',6,3,false,13),('C',7,'Premium',7,3,false,13),('C',8,'Premium',8,3,false,13),('C',9,'Premium',9,3,false,13),('C',10,'Premium',10,3,false,13),
('D',1,'Premium',1,4,false,13),('D',2,'Premium',2,4,false,13),('D',3,'Premium',3,4,false,13),('D',4,'Premium',4,4,false,13),('D',5,'Premium',5,4,false,13),('D',6,'Premium',6,4,false,13),('D',7,'Premium',7,4,false,13),('D',8,'Premium',8,4,false,13),('D',9,'Premium',9,4,false,13),('D',10,'Premium',10,4,false,13),
('E',1,'Premium',1,5,false,13),('E',2,'Premium',2,5,false,13),('E',3,'Premium',3,5,false,13),('E',4,'Premium',4,5,false,13),('E',5,'Premium',5,5,false,13),('E',6,'Premium',6,5,false,13),('E',7,'Premium',7,5,false,13),('E',8,'Premium',8,5,false,13),('E',9,'Premium',9,5,false,13),('E',10,'Premium',10,5,false,13),
('F',1,'Standard',1,6,false,13),('F',2,'Standard',2,6,false,13),('F',3,'Standard',3,6,false,13),('F',4,'Standard',4,6,false,13),('F',5,'Standard',5,6,false,13),('F',6,'Standard',6,6,false,13),('F',7,'Standard',7,6,false,13),('F',8,'Standard',8,6,false,13),('F',9,'Standard',9,6,false,13),('F',10,'Standard',10,6,false,13),
('G',1,'Standard',1,7,false,13),('G',2,'Standard',2,7,false,13),('G',3,'Standard',3,7,false,13),('G',4,'Standard',4,7,false,13),('G',5,'Standard',5,7,false,13),('G',6,'Standard',6,7,false,13),('G',7,'Standard',7,7,false,13),('G',8,'Standard',8,7,false,13),('G',9,'Standard',9,7,false,13),('G',10,'Standard',10,7,false,13),
('H',1,'Adapted',1,8,false,13),('H',2,'Standard',2,8,false,13),('H',3,'Standard',3,8,false,13),('H',4,'Standard',4,8,false,13),('H',5,'Standard',5,8,false,13),('H',6,'Standard',6,8,false,13),('H',7,'Standard',7,8,false,13),('H',8,'Standard',8,8,false,13),('H',9,'Standard',9,8,false,13),('H',10,'Adapted',10,8,false,13);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,14),('A',2,'Standard',2,1,false,14),('A',3,'Standard',3,1,false,14),('A',4,'Standard',4,1,false,14),('A',5,'Standard',5,1,false,14),('A',6,'Standard',6,1,false,14),('A',7,'Standard',7,1,false,14),('A',8,'Standard',8,1,false,14),('A',9,'Standard',9,1,false,14),('A',10,'Adapted',10,1,false,14),
('B',1,'Standard',1,2,false,14),('B',2,'Standard',2,2,false,14),('B',3,'Standard',3,2,false,14),('B',4,'Standard',4,2,false,14),('B',5,'Standard',5,2,false,14),('B',6,'Standard',6,2,false,14),('B',7,'Standard',7,2,false,14),('B',8,'Standard',8,2,false,14),('B',9,'Standard',9,2,false,14),('B',10,'Standard',10,2,false,14),
('C',1,'Premium',1,3,false,14),('C',2,'Premium',2,3,false,14),('C',3,'Premium',3,3,false,14),('C',4,'Premium',4,3,false,14),('C',5,'Premium',5,3,false,14),('C',6,'Premium',6,3,false,14),('C',7,'Premium',7,3,false,14),('C',8,'Premium',8,3,false,14),('C',9,'Premium',9,3,false,14),('C',10,'Premium',10,3,false,14),
('D',1,'Premium',1,4,false,14),('D',2,'Premium',2,4,false,14),('D',3,'Premium',3,4,false,14),('D',4,'Premium',4,4,false,14),('D',5,'Premium',5,4,false,14),('D',6,'Premium',6,4,false,14),('D',7,'Premium',7,4,false,14),('D',8,'Premium',8,4,false,14),('D',9,'Premium',9,4,false,14),('D',10,'Premium',10,4,false,14),
('E',1,'Premium',1,5,false,14),('E',2,'Premium',2,5,false,14),('E',3,'Premium',3,5,false,14),('E',4,'Premium',4,5,false,14),('E',5,'Premium',5,5,false,14),('E',6,'Premium',6,5,false,14),('E',7,'Premium',7,5,false,14),('E',8,'Premium',8,5,false,14),('E',9,'Premium',9,5,false,14),('E',10,'Premium',10,5,false,14),
('F',1,'Standard',1,6,false,14),('F',2,'Standard',2,6,false,14),('F',3,'Standard',3,6,false,14),('F',4,'Standard',4,6,false,14),('F',5,'Standard',5,6,false,14),('F',6,'Standard',6,6,false,14),('F',7,'Standard',7,6,false,14),('F',8,'Standard',8,6,false,14),('F',9,'Standard',9,6,false,14),('F',10,'Standard',10,6,false,14),
('G',1,'Standard',1,7,false,14),('G',2,'Standard',2,7,false,14),('G',3,'Standard',3,7,false,14),('G',4,'Standard',4,7,false,14),('G',5,'Standard',5,7,false,14),('G',6,'Standard',6,7,false,14),('G',7,'Standard',7,7,false,14),('G',8,'Standard',8,7,false,14),('G',9,'Standard',9,7,false,14),('G',10,'Standard',10,7,false,14),
('H',1,'Adapted',1,8,false,14),('H',2,'Standard',2,8,false,14),('H',3,'Standard',3,8,false,14),('H',4,'Standard',4,8,false,14),('H',5,'Standard',5,8,false,14),('H',6,'Standard',6,8,false,14),('H',7,'Standard',7,8,false,14),('H',8,'Standard',8,8,false,14),('H',9,'Standard',9,8,false,14),('H',10,'Adapted',10,8,false,14);

INSERT INTO SEAT (SEATROW, SEAT_NUMBER, TYPE, X, Y, ESTADO, ROOM_ID) VALUES
('A',1,'Adapted',1,1,false,15),('A',2,'Standard',2,1,false,15),('A',3,'Standard',3,1,false,15),('A',4,'Standard',4,1,false,15),('A',5,'Standard',5,1,false,15),('A',6,'Standard',6,1,false,15),('A',7,'Standard',7,1,false,15),('A',8,'Standard',8,1,false,15),('A',9,'Standard',9,1,false,15),('A',10,'Adapted',10,1,false,15),
('B',1,'Standard',1,2,false,15),('B',2,'Standard',2,2,false,15),('B',3,'Standard',3,2,false,15),('B',4,'Standard',4,2,false,15),('B',5,'Standard',5,2,false,15),('B',6,'Standard',6,2,false,15),('B',7,'Standard',7,2,false,15),('B',8,'Standard',8,2,false,15),('B',9,'Standard',9,2,false,15),('B',10,'Standard',10,2,false,15),
('C',1,'Premium',1,3,false,15),('C',2,'Premium',2,3,false,15),('C',3,'Premium',3,3,false,15),('C',4,'Premium',4,3,false,15),('C',5,'Premium',5,3,false,15),('C',6,'Premium',6,3,false,15),('C',7,'Premium',7,3,false,15),('C',8,'Premium',8,3,false,15),('C',9,'Premium',9,3,false,15),('C',10,'Premium',10,3,false,15),
('D',1,'Premium',1,4,false,15),('D',2,'Premium',2,4,false,15),('D',3,'Premium',3,4,false,15),('D',4,'Premium',4,4,false,15),('D',5,'Premium',5,4,false,15),('D',6,'Premium',6,4,false,15),('D',7,'Premium',7,4,false,15),('D',8,'Premium',8,4,false,15),('D',9,'Premium',9,4,false,15),('D',10,'Premium',10,4,false,15),
('E',1,'Premium',1,5,false,15),('E',2,'Premium',2,5,false,15),('E',3,'Premium',3,5,false,15),('E',4,'Premium',4,5,false,15),('E',5,'Premium',5,5,false,15),('E',6,'Premium',6,5,false,15),('E',7,'Premium',7,5,false,15),('E',8,'Premium',8,5,false,15),('E',9,'Premium',9,5,false,15),('E',10,'Premium',10,5,false,15),
('F',1,'Standard',1,6,false,15),('F',2,'Standard',2,6,false,15),('F',3,'Standard',3,6,false,15),('F',4,'Standard',4,6,false,15),('F',5,'Standard',5,6,false,15),('F',6,'Standard',6,6,false,15),('F',7,'Standard',7,6,false,15),('F',8,'Standard',8,6,false,15),('F',9,'Standard',9,6,false,15),('F',10,'Standard',10,6,false,15),
('G',1,'Standard',1,7,false,15),('G',2,'Standard',2,7,false,15),('G',3,'Standard',3,7,false,15),('G',4,'Standard',4,7,false,15),('G',5,'Standard',5,7,false,15),('G',6,'Standard',6,7,false,15),('G',7,'Standard',7,7,false,15),('G',8,'Standard',8,7,false,15),('G',9,'Standard',9,7,false,15),('G',10,'Standard',10,7,false,15),
('H',1,'Adapted',1,8,false,15),('H',2,'Standard',2,8,false,15),('H',3,'Standard',3,8,false,15),('H',4,'Standard',4,8,false,15),('H',5,'Standard',5,8,false,15),('H',6,'Standard',6,8,false,15),('H',7,'Standard',7,8,false,15),('H',8,'Standard',8,8,false,15),('H',9,'Standard',9,8,false,15),('H',10,'Adapted',10,8,false,15);

INSERT INTO SCREENING (screening_date_time, precio, movie_id, room_id)
VALUES -- Dune Part Two (id=1)
    ('2026-04-30T18:00', 8.50, 1, 1),
    ('2026-04-30T21:30', 9.50, 1, 1),
    ('2026-05-01T17:00', 8.50, 1, 2),
    ('2026-05-01T20:30', 9.50, 1, 2),
    ('2026-05-02T18:30', 9.00, 1, 3),
    -- Blade Runner (id=2)
    ('2026-05-01T19:00', 7.50, 2, 2),
    ('2026-05-01T22:00', 8.50, 2, 2),
    ('2026-05-02T18:00', 7.50, 2, 3),
    ('2026-05-02T21:00', 8.50, 2, 3),
    ('2026-05-03T20:00', 8.00, 2, 1),
    -- Interstellar (id=3)
    ('2026-05-01T17:30', 8.50, 3, 3),
    ('2026-05-01T21:00', 9.50, 3, 3),
    ('2026-05-02T16:30', 8.50, 3, 1),
    ('2026-05-02T20:00', 9.50, 3, 1),
    ('2026-05-03T19:00', 9.00, 3, 2),
    -- Inception (id=4)
    ('2026-05-01T20:00', 8.00, 4, 1),
    ('2026-05-01T22:45', 9.00, 4, 1),
    ('2026-05-02T18:30', 8.50, 4, 2),
    ('2026-05-02T21:30', 9.00, 4, 2),
    ('2026-05-03T17:30', 8.00, 4, 3),
    -- The Dark Knight (id=5)
    ('2026-05-01T19:30', 9.00, 5, 3),
    ('2026-05-01T22:30', 10.00, 5, 3),
    ('2026-05-02T19:45', 9.50, 5, 1),
    ('2026-05-02T22:15', 10.00, 5, 1),
    ('2026-05-03T20:30', 9.50, 5, 2),
    -- The Matrix (id=6)
    ('2026-05-01T16:30', 7.50, 6, 2),
    ('2026-05-01T19:00', 8.00, 6, 2),
    ('2026-05-02T17:00', 7.50, 6, 3),
    ('2026-05-02T20:00', 8.50, 6, 3),
    ('2026-05-03T18:00', 8.00, 6, 1),
    -- Dune: Part Three (id=7)
    ('2026-05-01T18:00', 9.50, 7, 1),
    ('2026-05-01T21:30', 10.00, 7, 2),
    ('2026-05-02T17:00', 9.50, 7, 3);
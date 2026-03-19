INSERT INTO CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES ('Major.15', 'Tarragona', 'Oscars', '43100');
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
    
INSERT INTO SCREENING (screening_date_time, precio, movie_id, room_id)
VALUES -- Dune Part Two (id=1)
    ('2026-03-20T18:00', 8.50, 1, 1),
    ('2026-03-20T21:30', 9.50, 1, 1),
    ('2026-03-21T17:00', 8.50, 1, 2),
    ('2026-03-21T20:30', 9.50, 1, 2),
    ('2026-03-22T18:30', 9.00, 1, 3),
    -- Blade Runner (id=2)
    ('2026-03-20T19:00', 7.50, 2, 2),
    ('2026-03-20T22:00', 8.50, 2, 2),
    ('2026-03-21T18:00', 7.50, 2, 3),
    ('2026-03-21T21:00', 8.50, 2, 3),
    ('2026-03-22T20:00', 8.00, 2, 1),
    -- Interstellar (id=3)
    ('2026-03-20T17:30', 8.50, 3, 3),
    ('2026-03-20T21:00', 9.50, 3, 3),
    ('2026-03-21T16:30', 8.50, 3, 1),
    ('2026-03-21T20:00', 9.50, 3, 1),
    ('2026-03-22T19:00', 9.00, 3, 2),
    -- Inception (id=4)
    ('2026-03-20T20:00', 8.00, 4, 1),
    ('2026-03-20T22:45', 9.00, 4, 1),
    ('2026-03-21T18:30', 8.50, 4, 2),
    ('2026-03-21T21:30', 9.00, 4, 2),
    ('2026-03-22T17:30', 8.00, 4, 3),
    -- The Dark Knight (id=5)
    ('2026-03-20T19:30', 9.00, 5, 3),
    ('2026-03-20T22:30', 10.00, 5, 3),
    ('2026-03-21T19:45', 9.50, 5, 1),
    ('2026-03-21T22:15', 10.00, 5, 1),
    ('2026-03-22T20:30', 9.50, 5, 2),
    -- The Matrix (id=6)
    ('2026-03-20T16:30', 7.50, 6, 2),
    ('2026-03-20T19:00', 8.00, 6, 2),
    ('2026-03-21T17:00', 7.50, 6, 3),
    ('2026-03-21T20:00', 8.50, 6, 3),
    ('2026-03-22T18:00', 8.00, 6, 1);
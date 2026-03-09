INSERT INTO
    CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES
    ('Major.15', 'Tarragona', 'Oscars', '43100');

INSERT INTO
    CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES
    ('Major.25', 'Tarragona', 'JCS', '43100');

INSERT INTO
    CINEMA (ADDRESS, CITY, CINEMA_NAME, POSTAL_CODE)
VALUES
    ('Major.35', 'Tarragona', 'Yelmus', '43100');

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 1', 120, 1);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 2', 120, 1);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 3', 120, 1);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 1', 120, 2);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 2', 120, 2);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 3', 120, 2);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 1', 120, 3);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 2', 120, 3);

INSERT INTO
    ROOM (NAME, CAPACITY, CINEMA_ID)
VALUES
    ('Sala 3', 120, 3);

INSERT INTO
    MOVIE (TITLE, duration_minutes , GENER, DESCRIPCION, release_date , POSTER_URL)
VALUES
    (
        'Dune: Part Two',
        166,
        'Sci-Fi',
        'Paul Atreides une fuerzas con los Fremen para vengar la destrucción de su familia.',
        '2024-03-01','dune.webp'
    );

INSERT INTO
    MOVIE (TITLE, duration_minutes , GENER, DESCRIPCION, release_date , POSTER_URL)
VALUES
    (
        'Blade Runner',
        117,
        'Sci-Fi',
        'Un blade runner debe retirar replicantes ilegales que regresan a la Tierra.',
        '1982-06-25','blade.webp'
    );

INSERT INTO
    MOVIE (TITLE, duration_minutes , GENER, DESCRIPCION, release_date , POSTER_URL)
VALUES
    (
        'Interstellar',
        169,
        'Sci-Fi',
        'Un grupo de astronautas viaja a través de un agujero de gusano para salvar a la humanidad.',
        '2014-11-07','interestellar.webp'
    );

INSERT INTO
    MOVIE (TITLE, duration_minutes , GENER, DESCRIPCION, release_date , POSTER_URL)
VALUES
    (
        'Inception',
        148,
        'Sci-Fi',
        'Un ladrón roba secretos infiltrándose en los sueños de las personas.',
        '2010-07-16','inception.webp'
    );

INSERT INTO
    MOVIE (TITLE, duration_minutes , GENER, DESCRIPCION, release_date , POSTER_URL)
VALUES
    (
        'The Dark Knight',
        152,
        'Action',
        'Batman se enfrenta al Joker, un criminal que busca sembrar el caos en Gotham.',
        '2008-07-18','batman.webp'
    );

INSERT INTO
    MOVIE (TITLE, duration_minutes , GENER, DESCRIPCION, release_date , POSTER_URL)
VALUES
    (
        'The Matrix',
        136,
        'Sci-Fi',
        'Un hacker descubre que la realidad es una simulación creada por máquinas.',
        '1999-03-31','matrix.webp'
    );
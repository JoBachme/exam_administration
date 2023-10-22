USE exam_system;

DROP TABLE notification_sample, students, tests, students_tests;

CREATE TABLE notification_sample (
    notification_name VARCHAR(300) PRIMARY KEY DEFAULT "notification_sample",
    text_sample TEXT
);

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(300) NOT NULL CHECK (LENGTH(first_name) > 0),
    last_name VARCHAR(300) NOT NULL CHECK (LENGTH(last_name) > 0)
);

CREATE TABLE tests (
    id INT PRIMARY KEY AUTO_INCREMENT,
    test_name VARCHAR(300) NOT NULL CHECK (LENGTH(test_name) > 0),
    pruef BOOLEAN DEFAULT false
);

CREATE TABLE students_tests (
    student_id INT REFERENCES students (id) ON DELETE CASCADE,
    test_id INT REFERENCES tests (id) ON DELETE CASCADE,
    passed_flag BOOLEAN DEFAULT false,
    tries INT CHECK (tries < 4) DEFAULT 0,
    PRIMARY KEY (student_id, test_id)
);



INSERT INTO
    students (first_name, last_name)
VALUES
    ("Jörn", "Bachmeier"),
    ("Nikolai", "Killer"),
    ("Stefan", "Sieber"),
    ("Eli", "Else"),
    ("Henrik", "Henrikson"),
    ("Karl", "Alles"),
    ("Tobias", "Abel");

INSERT INTO
    tests (test_name)
VALUES
    ("Big Data"),
    ("Software Engineering"),
    ("Logik"),
    ("NLP"),
    ("Gestalte, Genese und Info"),
    ("Physik"),
    ("Chemie"),
    ("Biologie");

INSERT INTO
    notification_sample (text_sample)
VALUES
    ("Lieber $vorname $nachname,\n Sie haben den Test $testname $ergebnis.\n Liebe Grüße ihr TypeFlowTeam.");

INSERT INTO
    students_tests (student_id, test_id, passed_flag, tries)
VALUES
    (1, 3, True, 1), (1, 4, False, 2), (1, 5, True, 1), (1, 7, False, 3), (1, 8, False, 3),
    (2, 1, False, 1), (2,6, True, 2), (2, 7, False, 1), (2, 8, True, 1),
    (3, 2, False, 1), (3, 4, True, 1), (3, 6, True, 1), (3, 7, False, 3),
    (4, 1, True, 1), (4, 3, True, 1), (4, 4, False, 3),
    (5, 1, False, 2), (5, 2, False, 1), (5, 3, False, 3), (5, 6, False, 2), (5, 7, True, 2), (5, 8, True, 1),
    (7, 2, True, 1), (7, 3, True, 1), (7, 5, False, 3), (7, 6, True, 1);

INSERT INTO
    students_tests (student_id, test_id)
VALUES
    (1, 1), (1, 2), (2, 2), (2, 3), (3, 1), (4, 8), (6, 1), (6, 3), (6, 5), (7, 7), (7, 8);
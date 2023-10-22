USE exam_system;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(300) NOT NULL CHECK (LENGTH(first_name) > 0),
    last_name VARCHAR(300) NOT NULL CHECK (LENGTH(last_name) > 0)
);

-- CREATE TABLE tests (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     test_name VARCHAR(300) NOT NULL CHECK (LENGTH(test_name) > 0),
--     pruef BOOLEAN DEFAULT false
-- );

-- CREATE TABLE students_tests (
--     student_id INT REFERENCES students (id) ON DELETE CASCADE,
--     test_id INT REFERENCES tests (id) ON DELETE CASCADE,
--     passed_flag BOOLEAN DEFAULT false,
--     tries INT CHECK (tries < 4) DEFAULT 0,
--     PRIMARY KEY (student_id, test_id)
-- );

-- CREATE TABLE notification_sample (
--     notification_name VARCHAR(300) PRIMARY KEY DEFAULT "notification_sample",
--     text_sample TEXT
-- );
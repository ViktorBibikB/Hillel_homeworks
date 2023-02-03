DROP DATABASE IF EXISTS TEST_MYSQL_DB;
CREATE DATABASE IF NOT EXISTS TEST_MYSQL_DB;
USE TEST_MYSQL_DB;

DROP TABLE IF EXISTS TEST_MYSQL_DB.Homework;
CREATE TABLE Homework (
	id INT NOT NULL AUTO_INCREMENT, 
	name varchar(50) NOT NULL, 
    description varchar(256) NOT NULL,
    PRIMARY KEY (id) USING BTREE
) ENGINE=INNODB;

INSERT INTO TEST_MYSQL_DB.Homework (name, description)
	VALUES ('Geography home work', 'Described geographycal home work.'),
		   ('English home work', 'Described english home work.'),
		   ('Math home work', 'Described mathematical home work.');

DROP TABLE IF EXISTS TEST_MYSQL_DB.Lesson;
CREATE TABLE Lesson (
	id INT NOT NULL AUTO_INCREMENT, 
    name varchar(50) NOT NULL, 
    updatedAt DATETIME NOT NULL,
    homework_id INT UNIQUE,
    PRIMARY KEY (id) USING BTREE,
    CONSTRAINT `FK_ID` FOREIGN KEY (homework_id) 
        REFERENCES Homework(id)
        ON DELETE CASCADE
) ENGINE=INNODB;

INSERT INTO TEST_MYSQL_DB.Lesson (name, updatedAt, homework_id)
	VALUES ('Geography', '2022-01-01 12:45:36', 1),
		   ('English', '2022-01-01 12:45:36', 2),
		   ('Math', '2022-01-01 12:45:36', 3);

DROP TABLE IF EXISTS TEST_MYSQL_DB.Schedule;
CREATE TABLE Schedule (
	id INT NOT NULL AUTO_INCREMENT, 
    name varchar(50)  NOT NULL, 
    updatedAt DATETIME  NOT NULL, 
    lessons INT,
    PRIMARY KEY (id) USING BTREE,
    FOREIGN KEY (lessons)
        REFERENCES Lesson(id)
        ON DELETE CASCADE
) ENGINE=INNODB;

INSERT INTO TEST_MYSQL_DB.Schedule (name, updatedAt, lessons)
	VALUES ('First_schedule', '2022-01-01 15:45:36', 1),
		   ('Second_schedule', '2022-01-01 15:45:36', 2),
		   ('Third_schedule', '2022-01-01 15:45:36', 3);

DROP TABLE IF EXISTS TEST_MYSQL_DB.Lessons_Schedule;
CREATE TABLE Lessons_Schedule (
	id INT NOT NULL AUTO_INCREMENT, 
    lessonId INT NOT NULL, 
    scheduleId INT NOT NULL,
	updatedAt DATETIME  NOT NULL,
    PRIMARY KEY (id) USING BTREE,
    FOREIGN KEY (lessonId)
        REFERENCES Lesson(id)
        ON DELETE CASCADE,
	FOREIGN KEY (scheduleId)
        REFERENCES Schedule(id)
        ON DELETE CASCADE
) ENGINE=INNODB;

INSERT INTO TEST_MYSQL_DB.Lessons_Schedule (lessonId, scheduleId, updatedAt)
	VALUES (2, 1, '2022-01-01 15:45:36'),
		   (2, 2, '2022-01-01 15:45:36'),
		   (2, 3, '2022-01-01 15:45:36'),
		   (2, 1, '2022-01-02 15:45:36'),
		   (3, 1, '2022-01-01 15:45:36'),
		   (3, 2, '2022-01-01 15:45:36'),
		   (3, 3, '2022-01-01 15:45:36'),
		   (3, 1, '2022-01-02 15:45:36'),
		   (1, 1, '2022-01-01 15:45:36'),
		   (1, 2, '2022-01-01 15:45:36'),
		   (1, 3, '2022-01-01 15:45:36'),
		   (1, 1, '2022-01-02 15:45:36');
		   
		   
SELECT l.name AS Lesson_name
	  ,s.name AS SCHEDULE_NAME
      ,COUNT(s.name) AS schedule_count
FROM lessons_schedule ls
	JOIN lesson l ON l.id = ls.lessonId
    JOIN schedule s ON s.id = ls.scheduleId
GROUP BY Lesson_name
		,SCHEDULE_NAME
HAVING COUNT(SCHEDULE_NAME) > 1;

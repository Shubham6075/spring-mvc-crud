use employee_directory;

DROP TABLE IF EXISTS `student2`;

CREATE TABLE `student2` (
  `id` int NOT NULL auto_increment,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


INSERT INTO student2 (id, first_name, last_name, email)
VALUES
  (1, 'John', 'Doe', 'john.doe@example.com'),
  (2, 'Jane', 'Smith', 'jane.smith@example.com'),
  (3, 'Alice', 'Johnson', 'alice.johnson@example.com'),
  (4, 'Bob', 'Williams', 'bob.williams@example.com'),
  (5, 'Eva', 'Brown', 'eva.brown@example.com'),
  (6, 'Charlie', 'Miller', 'charlie.miller@example.com'),
  (7, 'Olivia', 'Davis', 'olivia.davis@example.com'),
  (8, 'Daniel', 'Garcia', 'daniel.garcia@example.com'),
  (9, 'Sophia', 'Martinez', 'sophia.martinez@example.com'),
  (10, 'Liam', 'Taylor', 'liam.taylor@example.com');
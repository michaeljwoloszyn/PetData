CREATE TABLE pet(
     id INT AUTO_INCREMENT PRIMARY KEY,
     pet_name VARCHAR (255) NOT NULL,
     pet_kind VARCHAR (255) NOT NULL,
     gender VARCHAR (255) NOT NULL,
     vaccine_status BOOLEAN
);
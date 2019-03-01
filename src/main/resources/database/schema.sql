CREATE DATABASE IF NOT EXISTS UberSante;

ALTER DATABASE UberSante
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON UberSante.* TO soen@localhost IDENTIFIED BY 's344';

USE UberSante;

CREATE TABLE IF NOT EXISTS users (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_type` VARCHAR(45) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS patients (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `birthday` DATE NOT NULL,
  `gender` VARCHAR(12) NOT NULL,
  `phone_number` VARCHAR(12) NOT NULL,
  `email` VARCHAR(45) UNIQUE NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `health_card_number` VARCHAR(14) UNIQUE NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS doctors (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `specialty` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `physician_permit_number` INT(7) UNIQUE NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS nurses (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `access_id` VARCHAR(8) UNIQUE NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS appointments (
  `appointment_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `patient_id`INT UNSIGNED NOT NULL,
  `date` DATE NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  `appointment_type` VARCHAR(10) NOT NULL,
  `description` VARCHAR(255) NULL,
  FOREIGN KEY (patient_id) REFERENCES patients(user_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS bookings (
  `booking_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `doctor_id` INT UNSIGNED NOT NULL,
  `patient_id` INT UNSIGNED NOT NULL,
  `appointment_id` INT UNSIGNED NOT NULL,
  `room` INT NOT NULL,
  FOREIGN KEY (patient_id) REFERENCES patients(user_id),
  FOREIGN KEY (doctor_id) REFERENCES doctors(user_id),
  FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS schedules (
  `schedule_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `doctor_id` INT UNSIGNED NOT NULL,
  `day_of_week` VARCHAR(9) NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  FOREIGN KEY (doctor_id) REFERENCES doctors(user_id)
) ENGINE=InnoDB;
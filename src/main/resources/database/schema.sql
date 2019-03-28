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
  `user_type` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL
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
  `description` VARCHAR(140) NULL,
  FOREIGN KEY (patient_id) REFERENCES patients(user_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS bookings (
  `booking_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `doctor_id` INT UNSIGNED NOT NULL,
  `patient_id` INT UNSIGNED NOT NULL,
  `appointment_id` INT UNSIGNED NOT NULL,
  `room` INT NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  FOREIGN KEY (patient_id) REFERENCES patients(user_id),
  FOREIGN KEY (doctor_id) REFERENCES doctors(user_id),
  FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id),
  FOREIGN KEY (location) REFERENCES users(location)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS schedules (
  `schedule_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `doctor_id` INT UNSIGNED NOT NULL,
  `day_of_week` VARCHAR(9) NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  FOREIGN KEY (doctor_id) REFERENCES doctors(user_id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS clinics (
  `clinic_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,  
  `name` VARCHAR(45) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS clinic_info (
  `clinic_id` INT UNSIGNED NOT NULL,
  `num_doctors` INT UNSIGNED NOT NULL,
  `num_nurses` INT UNSIGNED NOT NULL,
  `num_rooms` INT UNSIGNED NOT NULL,
  `num_bookings` INT UNSIGNED NOT NULL,
  FOREIGN KEY (clinic_id) REFERENCES clinics(clinic_id)
) ENGINE=InnoDB;

UPDATE clinic_info SET num_doctors = (SELECT count(doctor_id) FROM doctors WHERE users.location = "Westmount") WHERE name="Westmount";
UPDATE clinic_info SET num_nurses = (SELECT count(nurse_id) FROM nurses WHERE users.location = "Westmount") WHERE name="Westmount";
UPDATE clinic_info SET num_bookings = (SELECT count(appointment_id) FROM bookings WHERE bookings.location = "Westmount") WHERE name="Westmount";
UPDATE clinic_info SET num_rooms = (SELECT count(room) FROM bookings WHERE bookings.location = "Westmount") WHERE name="Westmount";

UPDATE clinic_info SET num_doctors = (SELECT count(doctor_id) FROM doctors WHERE users.location = "Mont-Royal") WHERE name="Mont-Royal";
UPDATE clinic_info SET num_nurses = (SELECT count(nurse_id) FROM nurses WHERE users.location = "Mont-Royal") WHERE name="Mont-Royal";
UPDATE clinic_info SET num_bookings = (SELECT count(appointment_id) FROM bookings WHERE bookings.location = "Mont-Royal") WHERE name="Mont-Royal";
UPDATE clinic_info SET num_rooms = (SELECT count(room) FROM bookings WHERE bookings.location = "Mont-Royal") WHERE name="Mont-Royal";

UPDATE clinic_info SET num_doctors = (SELECT count(doctor_id) FROM doctors WHERE users.location = "Outremont") WHERE name="Outremont";
UPDATE clinic_info SET num_nurses = (SELECT count(nurse_id) FROM nurses WHERE users.location = "Outremont") WHERE name="Outremont";
UPDATE clinic_info SET num_bookings = (SELECT count(appointment_id) FROM bookings WHERE bookings.location = "Outremont") WHERE name="Outremont";
UPDATE clinic_info SET num_rooms = (SELECT count(room) FROM bookings WHERE bookings.location = "Outremont") WHERE name="Outremont";







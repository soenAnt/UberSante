CREATE DATABASE IF NOT EXISTS ubersante;

ALTER DATABASE ubersante
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON ubersante.* TO soen@localhost IDENTIFIED BY 's344';

USE ubersante;

CREATE TABLE IF NOT EXISTS patients (
  `patientId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `gender` CHAR(1) NULL,
  `phoneNumber` VARCHAR(12) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `healthCardNumber` VARCHAR(12) NULL,
  `password` VARCHAR(45) NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS doctors (
  `doctorId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `specialty` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `physicianPermitNumber` INT(7) NULL,
  `password` VARCHAR(45) NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS nurses (
  `nurseId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `accessId` VARCHAR(8) NULL,
  `password` VARCHAR(45) NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS appointments (
  `appointmentId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `patientId` INT UNSIGNED NOT NULL,
  `doctorId` INT UNSIGNED NOT NULL,
  `date` DATE NULL,
  `startTime` TIME NOT NULL,
  `endTime` TIME NOT NULL,
  `room` INT(1) NULL,
  `appointmentType` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  FOREIGN KEY (patientId) REFERENCES patients(patientId),
  FOREIGN KEY (doctorId) REFERENCES doctors(doctorId)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS carts (
  `cartId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `patientId` INT UNSIGNED NOT NULL,
  `datetime` TIMESTAMP NULL,
  `appointmentType` VARCHAR(45) NULL,
  FOREIGN KEY (patientId) REFERENCES patients(patientId)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS schedules (
  `scheduleId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `doctorId` INT UNSIGNED NOT NULL,
  `dayOfWeek` VARCHAR(9) NULL,
  `startTime` TIME NULL,
  `endTime` TIME NULL,
  FOREIGN KEY (doctorId) REFERENCES doctors(doctorId)
) ENGINE=InnoDB;
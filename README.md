CREATE TABLE `user` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `role` ENUM('ADMIN','PATIENT','DOCTOR') DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`))
 
CREATE TABLE `patient` (
  `patientid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `dateOfBirth` DATE DEFAULT NULL,
  `gender` VARCHAR(255) DEFAULT NULL,
  `contactNumber` VARCHAR(15) DEFAULT NULL,
  `address` VARCHAR(255) DEFAULT NULL,
  `medicalHistory` TEXT,
  `contact_number` VARCHAR(255) DEFAULT NULL,
  `date_of_birth` DATE DEFAULT NULL,
  `medical_history` TEXT,
  `userid` INT NOT NULL,
  PRIMARY KEY (`patientid`),
  KEY `fk_userid` (`userid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`))
 
CREATE TABLE `doctor` (
  `doctorid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `specialization` VARCHAR(255) DEFAULT NULL,
  `contactNumber` VARCHAR(15) DEFAULT NULL,
  `availabilitySchedule` TEXT,
  `availability_schedule` TEXT,
  `contact_number` VARCHAR(255) DEFAULT NULL,
  `userid` INT NOT NULL,
  PRIMARY KEY (`doctorid`),
  KEY `fk_doctor_userid` (`userid`),
  CONSTRAINT `fk_doctor_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`))
 
CREATE TABLE `appointment` (
  `appointmentid` INT NOT NULL AUTO_INCREMENT,
  `patientid` INT NOT NULL,
  `doctorid` INT NOT NULL,
  `appointmentDate` DATE DEFAULT NULL,
  `timeSlot` VARCHAR(20) DEFAULT NULL,
  `status` ENUM('CONFIRMED','CANCELLED') DEFAULT NULL,
  `appointment_date` DATE DEFAULT NULL,
  `time_slot` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`appointmentid`),
  KEY `patientid` (`patientid`),
  KEY `doctorid` (`doctorid`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`doctorid`) REFERENCES `doctor` (`doctorid`))
 
CREATE TABLE `bill` (
  `billid` INT NOT NULL AUTO_INCREMENT,
  `patientid` INT DEFAULT NULL,
  `totalAmount` DECIMAL(10,2) DEFAULT NULL,
  `paymentStatus` ENUM('PAID','UNPAID') DEFAULT NULL,
  `billDate` DATE DEFAULT NULL,
  `bill_date` DATETIME(6) DEFAULT NULL,
  `payment_status` ENUM('PAID','UNPAID') DEFAULT NULL,
  `total_amount` DOUBLE NOT NULL,
  PRIMARY KEY (`billid`),
  KEY `patientid` (`patientid`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`patientid`) REFERENCES `patient` (`patientid`)) 
 

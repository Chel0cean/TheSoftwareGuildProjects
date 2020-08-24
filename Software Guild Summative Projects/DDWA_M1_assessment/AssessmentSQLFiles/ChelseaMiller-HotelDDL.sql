DROP SCHEMA IF EXISTS `HotelReservationSchema` ;
CREATE SCHEMA IF NOT EXISTS `HotelReservationSchema`; 
USE `HotelReservationSchema` ;

CREATE TABLE IF NOT EXISTS `Type` (
  `size` VARCHAR(7) NOT NULL,
  `StandardOccupancy` INT NULL,
  `MaxOccupancy` INT NULL,
  `Price` DECIMAL(5,2) NULL,
  `AdditionalPersonFee` DECIMAL(4,2) NULL,
  PRIMARY KEY (`size`));


CREATE TABLE IF NOT EXISTS `Room` (
  `RoomNumber` INT NOT NULL,
  `Type_size` VARCHAR(7) NOT NULL,
  `ADAAccessible` BIT(1) NULL,
  PRIMARY KEY (`RoomNumber`, `Type_size`),
  FOREIGN KEY (`Type_size`)
  REFERENCES `Type` (`size`));
  
  CREATE TABLE IF NOT EXISTS `Amenities` (
  `idAmenity` INT NOT NULL AUTO_INCREMENT,
  `Amenity` VARCHAR(45) NULL,
  `AdditionalCharge` DECIMAL(5,2) NULL,
  PRIMARY KEY (`idAmenity`));
  
  CREATE TABLE IF NOT EXISTS `Guest` (
  `idGuest` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `Address` VARCHAR(45) NULL,
  `City` VARCHAR(45) NULL,
  `State` CHAR(2) NULL,
  `ZipCode` VARCHAR(5) NULL,
  `Phone` CHAR(14) NULL,
  PRIMARY KEY (`idGuest`));
  
  
  CREATE TABLE IF NOT EXISTS `Reservations` (
  `idReservations` INT NOT NULL AUTO_INCREMENT,
  `Guest_idGuest` INT NOT NULL,
  `Room_RoomNumber` INT NOT NULL,
  `Adults` INT NULL,
  `Children` INT NULL,
  `StartDate` DATETIME NULL,
  `EndDate` DATETIME NULL,
  `TotalRoomCost` DECIMAL(6,2) NULL,
  PRIMARY KEY (`idReservations`),
    FOREIGN KEY (`Guest_idGuest`)
    REFERENCES `HotelReservationSchema`.`Guest` (`idGuest`),
    FOREIGN KEY (`Room_RoomNumber`)
    REFERENCES `HotelReservationSchema`.`Room` (`RoomNumber`));
    
    CREATE TABLE IF NOT EXISTS `RoomAmenities` (
  `Room_RoomNumber` INT NOT NULL,
  `Amenities_idAmenity` INT NOT NULL,
  PRIMARY KEY (`Room_RoomNumber`, `Amenities_idAmenity`),
    FOREIGN KEY (`Room_RoomNumber`)
    REFERENCES `HotelReservationSchema`.`Room` (`RoomNumber`),
    FOREIGN KEY (`Amenities_idAmenity`)
    REFERENCES `HotelReservationSchema`.`Amenities` (`idAmenity`));
    
    
    
  
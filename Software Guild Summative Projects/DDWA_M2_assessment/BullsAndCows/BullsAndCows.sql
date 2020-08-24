
DROP SCHEMA IF EXISTS `bullsandcowsdb` ;

CREATE SCHEMA IF NOT EXISTS `bullsandcowsdb` DEFAULT CHARACTER SET utf8 ;
USE `bullsandcowsdb` ;

CREATE TABLE IF NOT EXISTS `bullsandcowsdb`.`Game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Answer` CHAR(4) NOT NULL,
  `Status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `bullsandcowsdb`.`Round` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Game_id` INT NOT NULL,
   `TimeOfGuess` CHAR(30) NULL,
  `Guess` CHAR(4) NOT NULL,
  `Score` CHAR(7) NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`Game_id`)
    REFERENCES `bullsandcowsdb`.`Game` (`id`));


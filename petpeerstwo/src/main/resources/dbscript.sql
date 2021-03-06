DROP SCHEMA IF EXISTS `petsdb`;

CREATE SCHEMA `petsdb`;

use `petsdb`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `PET_USER`;

CREATE TABLE `PET_USER` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(55) NOT NULL UNIQUE,
  `USER_PASSWORD` varchar(55) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `PETS`;


CREATE TABLE `PETS` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `PET_NAME` varchar(55) NOT NULL,
  `PET_AGE` int(2),
  `PET_PLACE` varchar(55),
  `PET_OWNERID` int(5) NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DETAIL_idx` (`PET_OWNERID`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`PET_OWNERID`) 
  REFERENCES `PET_USER` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
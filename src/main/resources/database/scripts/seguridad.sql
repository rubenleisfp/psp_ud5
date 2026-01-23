CREATE DATABASE IF NOT EXISTS `seguridad`;
USE `seguridad`;

CREATE TABLE `seguridad`.`usuario` (
  `ID` INT NOT NULL,
  `USERNAME` VARCHAR(45) NULL,
  `PASSWORD` VARCHAR(255) NULL,
  PRIMARY KEY (`ID`));

INSERT INTO `seguridad`.`usuario` (`ID`, `USERNAME`, `PASSWORD`) VALUES (1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'), (2, 'user', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');


--Update de para trabajar con HASH
-- UPDATE seguridad.usuario SET PASSWORD = '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918' WHERE ID = 1;
-- UPDATE seguridad.usuario SET PASSWORD = '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb' WHERE ID = 2;

--Update de passwords para trabajar con AES
-- UPDATE seguridad.usuario SET PASSWORD = '2uUG/cVwhFszCEBOo6QmHA==' WHERE ID = 1;
-- UPDATE seguridad.usuario SET PASSWORD = 'qPVRW3RUKjoOF93iOb6haA==' WHERE ID = 2;
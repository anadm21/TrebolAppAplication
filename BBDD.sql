-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: trebolapp
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `beneficiario`
--

DROP TABLE IF EXISTS `beneficiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beneficiario` (
  `IDBeneficiario` int(11) NOT NULL AUTO_INCREMENT,
  `DNIBeneficiario` varchar(10) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Fecha_nac` varchar(20) DEFAULT NULL,
  `Fecha_antiguedad` varchar(20) DEFAULT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`IDBeneficiario`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficiario`
--

LOCK TABLES `beneficiario` WRITE;
/*!40000 ALTER TABLE `beneficiario` DISABLE KEYS */;
INSERT INTO `beneficiario` VALUES (1,'33254799-N','Pedro','Donoso Guapo',26,'1996-03-25','2017-10-29','Avenida Unamuno, 225','695988748'),(2,'32547854-H','Maria','Ramírez Agosto',20,'2002-03-25','2017-10-29','Avenida de la Paz, 5','674874478'),(3,'62547887-N','Lucas','Mohedano Rodríguez',18,'2004-03-24','2009-10-28','Calle Real, 90','965887874'),(4,'62547888-H','Martina','Mohedano Rodríguez',14,'2008-03-24','2015-10-28','Calle Real, 90','965887874'),(5,'06587416-O','Carlos','Vázquez Manzano',27,'1995-05-13','2014-08-21','Calle Ponce de León, 12','658774772'),(6,'21189634-D','Laura','Méndez Habbari',31,'1990-07-19','2012-11-14','Calle Guadalajara, 981','655987714'),(7,'51988322-G','Lucía','Pérez San Juan',16,'2006-05-19','2011-06-27','Paseo de los Curas, 5','872245889'),(8,'54788796-R','Raúl','Sanchez Merino',32,'1990-06-12','2010-02-08','Calle San Antón, 85','661248853'),(9,'72988598-V','Belén','Meraz Roido',12,'2010-07-03','2006-01-08','Ronda Norte, 30','722548796'),(12,'04188563-G','Ana María','Guillén Ramos',40,'1982-10-02','2004-07-29','Calle Gaspar Sanz, 244','716548892'),(14,'74874485-B','Víctor','Martín de Urturi',33,'1989-02-08','2015-08-24','Calle Moliner, 1','699587473'),(23,'09166587-M','Rosario','Calvo Morán',20,'2001-06-24','2017-07-10','Calle Menéndez Pelayo, 3','725991055'),(25,'05899715-K','Arturo','Domínguez Dávila',8,'2005-02-25','2008-06-23','Calle Platón, 29','665877489');
/*!40000 ALTER TABLE `beneficiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socio` (
  `IDSocio` int(11) NOT NULL AUTO_INCREMENT,
  `DNISocio` varchar(10) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Cuota` double NOT NULL,
  `Fecha_nac` varchar(20) DEFAULT NULL,
  `Cuenta_bancaria` varchar(20) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`IDSocio`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (3,'33254799-N','Pedro','Donoso Guapo',260,'1996-03-24','ES219947854788325415','Avenida Unamuno, 225','695988748'),(4,'62547887-N','Lucas','Mohedano Rodríguez',18,'1995-03-23','ES653254471103620058','Calle Real, 90','965887874'),(5,'62547888-H','Martina','Mohedano Rodríguez',10,'1975-03-23','ES358554774106885163','Calle Real, 90','965887874'),(6,'06587416-O','Carlos','Vázquez Manzano',25,'1995-05-12','ES547878552156985324','Calle Ponce de León, 12','658774772'),(7,'21189634-D','Laura','Méndez Habbari',13,'1990-07-18','ES254788985785412365','Calle Guadalajara, 981','655987714'),(8,'51988322-G','Lucía','Pérez San Juan',60,'1960-05-18','ES872544785412556985','Paseo de los Curas, 5','872245889'),(9,'54788796-R','Raúl','Sanchez Merino',82,'1990-06-11','ES254144257896587741','Calle San Antón, 85','661248853'),(10,'72988598-V','Belén','Meraz Roido',5,'2000-07-02','ES3255478544125698','Ronda Norte, 30','722548796'),(11,'04188563-G','Ana María','Guillén Ramos',40,'1982-10-01','ES451254478541255698','Calle Gaspar Sanz, 244','716548892'),(12,'74874485-B','Víctor','Martín de Urturi',33,'1989-02-07','ES352447854785523655','Calle Moliner, 1','699587473'),(13,'09166587-M','Rosario','Calvo Morán',20,'2001-06-23','ES659885441478552310','Calle Menéndez Pelayo, 3','725991055'),(14,'05899715-K','Arturo','Domínguez Dávila',10,'2001-02-24','ES859885412547890012','Calle Platón, 29','665877489');
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador` (
  `IDTrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `DNITrabajador` varchar(10) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Salario` double NOT NULL,
  `Fecha_nac` varchar(20) DEFAULT NULL,
  `Fecha_antiguedad` varchar(20) DEFAULT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  `Turno` varchar(45) NOT NULL,
  `Tipo_contrato` varchar(45) NOT NULL,
  `Num_SS` varchar(45) NOT NULL,
  `Cuenta_bancaria` varchar(20) NOT NULL,
  PRIMARY KEY (`IDTrabajador`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES (4,'32547854-H','Maria','Ramírez Agosto',1300,'2001-03-24','2017-09-15','Avenida de la Paz, 5','674874478','Partido Mañana','Indefinido','28992145','ES356589747854788213'),(5,'62547887-N','Lucas','Mohedano Rodríguez',960,'1995-03-23','2015-04-17','Calle Real, 90','965887874','Tarde','Formación','28996845','ES653254471103620058'),(6,'62547888-H','Martina','Mohedano Rodríguez',1300,'1975-03-23','2009-03-20','Calle Real, 90','965887874','Tarde','Formación','28332587','ES358554774106885163'),(7,'06587416-O','Carlos','Vázquez Manzano',2500,'1995-05-12','2010-07-13','Calle Ponce de León, 12','658774772','Mañana','Obra y Servicio','28411790','ES547878552156985324'),(8,'21189634-D','Laura','Méndez Habbari',1370,'1990-07-18','2007-09-28','Calle Guadalajara, 981','655987714','Mañana','Obra y Servicio','28650012','ES254788985785412365'),(9,'51988322-G','Lucía','Pérez San Juan',1025,'1960-05-18','1999-06-12','Paseo de los Curas, 5','872245889','Mañana','Fijo Discontinuo','28665874','ES872544785412556985'),(10,'54788796-R','Raúl','Sanchez Merino',820,'1990-06-11','2022-02-20','Calle San Antón, 85','661248853','Noche','Formación','28002145','ES254144257896587741'),(11,'72988598-V','Belén','Meraz Roido',570,'2000-07-02','2019-09-02','Ronda Norte, 30','722548796','Partido Tarde','Indefinido','28214458','ES3255478544125698'),(12,'04188563-G','Ana María','Guillén Ramos',400,'1982-10-01','2005-02-20','Calle Gaspar Sanz, 244','716548892','Partido Mañana','Obra y Servicio','28325547','ES451254478541255698'),(13,'74874485-B','Víctor','Martín de Urturi',2300,'1989-02-07','2016-03-27','Calle Moliner, 1','699587473','Tarde','Fijo Discontinuo','28998547','ES352447854785523655'),(14,'09166587-M','Rosario','Calvo Morán',2000,'2001-06-23','2020-01-13','Calle Menéndez Pelayo, 3','725991055','Mañana','Indefinido','28654414','ES659885441478552310'),(15,'05899715-K','Arturo','Domínguez Dávila',1069,'2001-02-24','2021-06-19','Calle Platón, 29','665877489','Noche','Obra y Servicio','28025479','ES859885412547890012');
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `IDUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `User` varchar(20) NOT NULL,
  `Passwd` varchar(20) NOT NULL,
  `Role` varchar(45) NOT NULL,
  PRIMARY KEY (`IDUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voluntario`
--

DROP TABLE IF EXISTS `voluntario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voluntario` (
  `IDVoluntario` int(11) NOT NULL AUTO_INCREMENT,
  `DNIVoluntario` varchar(10) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Fecha_nac` varchar(20) DEFAULT NULL,
  `Fecha_antiguedad` varchar(20) DEFAULT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`IDVoluntario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voluntario`
--

LOCK TABLES `voluntario` WRITE;
/*!40000 ALTER TABLE `voluntario` DISABLE KEYS */;
INSERT INTO `voluntario` VALUES (2,'33254799-N','Pedro','Donoso Guapo',25,'1996-02-15','2017-02-25','Avenida Unamuno, 225','658745842'),(3,'32547854-H','Maria','Ramírez Agosto',20,'2002-03-24','2017-10-28','Avenida de la Paz, 5','674874478'),(4,'62547887-N','Lucas','Mohedano Rodríguez',18,'2004-03-23','2009-10-27','Calle Real, 90','965887874'),(5,'62547888-H','Martina','Mohedano Rodríguez',14,'2008-03-23','2015-10-27','Calle Real, 90','965887874'),(6,'06587416-O','Carlos','Vázquez Manzano',27,'1995-05-12','2014-08-20','Calle Ponce de León, 12','658774772'),(7,'21189634-D','Laura','Méndez Habbari',31,'1990-07-18','2012-11-13','Calle Guadalajara, 981','655987714'),(8,'51988322-G','Lucía','Pérez San Juan',16,'2006-05-18','2011-06-26','Paseo de los Curas, 5','872245889'),(9,'54788796-R','Raúl','Sanchez Merino',32,'1990-06-11','2010-02-07','Calle San Antón, 85','661248853'),(10,'72988598-V','Belén','Meraz Roido',12,'2010-07-02','2006-01-07','Ronda Norte, 30','722548796'),(11,'04188563-G','Ana María','Guillén Ramos',40,'1982-10-01','2004-07-28','Calle Gaspar Sanz, 244','716548892'),(12,'74874485-B','Víctor','Martín de Urturi',33,'1989-02-07','2015-08-23','Calle Moliner, 1','699587473'),(13,'09166587-M','Rosario','Calvo Morán',20,'2001-06-23','2017-07-09','Calle Menéndez Pelayo, 3','725991055'),(14,'05899715-K','Arturo','Domínguez Dávila',8,'2005-02-24','2008-06-22','Calle Platón, 29','665877489');
/*!40000 ALTER TABLE `voluntario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-04  1:42:02

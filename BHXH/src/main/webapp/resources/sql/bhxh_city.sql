-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: bhxh
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (2,'An Giang'),(3,'Bà Rịa-Vũng Tàu'),(4,'Bạc Liêu'),(5,'Bắc Kạn'),(6,'Bắc Giang'),(7,'Bắc Ninh'),(8,'Bến Tre'),(9,'Bình Dương'),(10,'Bình Định'),(11,'Bình Phước'),(12,'Bình Thuận'),(13,'Cà Mau'),(14,'Cao Bằng'),(15,'Cần Thơ'),(16,'Đà Nẵng'),(17,'Đắk Lắk'),(18,'Đắk Nông'),(19,'Điện Biên'),(20,'Đồng Nai'),(21,'Đồng Tháp'),(22,'Gia Lai '),(23,'Hà Giang'),(24,'Hà Nam'),(25,'Hà Nội '),(26,'Hà Tây'),(27,'Hà Tĩnh'),(28,'Hải Dương'),(29,'Hải Phòng '),(30,'Hòa Bình'),(31,'Hồ Chí Minh '),(32,'Hậu Giang'),(33,'Hưng Yên'),(34,'Khánh Hòa'),(35,'Kiên Giang'),(36,'Kon Tum '),(37,'Lai Châu'),(38,'Lào Cai'),(39,'Lạng Sơn'),(40,'Lâm Đồng'),(41,'Long An'),(42,'Nam Định'),(43,'Nghệ An'),(44,'Ninh Bình'),(45,'Ninh Thuận'),(46,'Phú Thọ'),(47,'Phú Yên'),(48,'Quảng Bình'),(49,'Quảng Nam'),(50,'Quảng Ngãi'),(51,'Quảng Ninh'),(52,'Quảng Trị'),(53,'Sóc Trăng'),(54,'Sơn La'),(55,'Tây Ninh'),(56,'Thái Bình'),(57,'Thái Nguyên'),(58,'Thanh Hóa'),(59,'Thừa Thiên - Huế'),(60,'Tiền Giang'),(61,'Trà Vinh'),(62,'Tuyên Quang'),(63,'Vĩnh Long'),(64,'Vĩnh Phúc'),(65,'Yên Bái');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-20  0:50:22

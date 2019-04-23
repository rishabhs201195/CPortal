

CREATE DATABASE  IF NOT EXISTS `complaintportal` /*!40100 DEFAULT CHARACTER SET latin1 */;
GRANT ALL PRIVILIGES on complaintportal.* TO 'root'@'%' IDENTIFIED BY 'Naman@11396' WITH GRANT OPTION;
USE `complaintportal`;
-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: complaintportal
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complaint` (
  `id` int(11) NOT NULL,
  `ctype` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `hostel` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `roll` varchar(255) DEFAULT NULL,
  `room` int(11) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `compbody` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
INSERT INTO `complaint` VALUES (1,'hhgh','hvhv','hvhv','hvh','120',120,NULL,NULL,NULL,NULL),(2,'hhgh','hvhv','hvhv','hvf','121',180,NULL,NULL,NULL,NULL),(3,'mess','hvhv','hvhv','hvf','121',180,' scs','accept',NULL,NULL),(4,'canteen','hvhv','hvhv','hvf','121',180,NULL,NULL,NULL,NULL),(5,'mess','anjn','njn','jnn','452',452,'devevf','accept',NULL,NULL),(6,'electric','amam','jnjn','mosip','mt2018067',201,NULL,NULL,NULL,'11-04-2019 00:16:18'),(7,'cleaning','amam','jnjn','Namanraj Varshney','MT2018067',145,NULL,NULL,NULL,'11-04-2019 00:16:18'),(8,'bathroom','amam','jnjn','mosip','mt2018068',201,NULL,NULL,'eveevedvevev',NULL),(9,'cleaning','mmm','naman','Raja','mt2018069',452,NULL,NULL,'namanaaa',NULL),(10,'bathroom','b.tech','bhaskara','raju','mt2015806',45,NULL,NULL,'ssssjsjsj',NULL),(11,'cleaning','ww','naana','niraj','mt2018069',452,NULL,NULL,'xmdmddd',NULL),(12,'cleaning','bmbm','vbvbv','rajaji','mt2018078',452,NULL,NULL,'dnd deee',NULL),(13,'electric','m.tech','jnjn','mosip','mt2018074',201,NULL,NULL,'svsv',NULL),(17,'cleaning','amam','jnjn','mosip','mt2018067',201,NULL,NULL,'ssvvsv','11-04-2019 00:16:18'),(16,'cleaning','amam','jnjn','mosip','MT2018067',201,NULL,NULL,'ssvvsv','11-04-2019 00:16:18'),(18,'mess','m.tech','jnjn','namanraj11396','MT2018067',145,'cnjcmnc','Accepted','dfdb','11-04-2019 00:16:18'),(19,'sac','m.tech','Lilavati','namanraj11396','mt2018067',145,'hvvh','accept','dfdb','11-04-2019 00:16:18'),(20,'sac','m.tech','Bhaskara','Namanraj Varshney','MT2018067',505,NULL,NULL,'awwwwww','11-04-2019 00:16:18'),(21,'mess','m.tech','bhaskara','Namanraj Varshney','MT2018067',201,'ajajsnjbjece','Rejected','sdxsfcfcefef','11-04-2019 00:16:18'),(22,'mess','M.Tech','Bhaskara','Namanraj Varshney','MT2018067',505,NULL,NULL,'food ','11-04-2019 00:16:18'),(48,'sac',NULL,'Bhaskara','Namanraj Varshney','MT2018067',505,NULL,NULL,'hdhdhhd','11-04-2019 00:16:18'),(49,'mess',NULL,'Bhaskara','Namanraj Varshney','MT2018067',505,NULL,NULL,'naannnana','11-04-2019 00:16:18'),(50,'mess',NULL,'Bhaskara','Namanraj Varshney','MT2018067',505,NULL,'Pending','anamma','11-04-2019 00:16:18'),(51,'mess',NULL,'Bhaskara','Namanraj Varshney','MT2018067',505,NULL,'Resolved','dnjnn\r\n','11-04-2019 00:21:59'),(52,'mess',NULL,'Bhaskara','Namanraj Varshney','MT2018067',505,'No message','Pending','food kharab hai','12-04-2019 11:23:25'),(54,'mess',NULL,'Bhaskara','Aman Gupta','MT2018008',371,'jbjbjbj','Resolved','food bekar hai','15-04-2019 17:59:13');
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-16 11:23:19

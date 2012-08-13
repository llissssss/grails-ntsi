-- MySQL dump 10.13  Distrib 5.5.19, for Win32 (x86)
--
-- Host: localhost    Database: ntsi
-- ------------------------------------------------------
-- Server version	5.5.19

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,1,'Futbol'),(2,1,'Running');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comanda` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `adreca` varchar(200) NOT NULL,
  `adreca_fact` varchar(255) NOT NULL,
  `cognom_env` varchar(255) NOT NULL,
  `cognom_fact` varchar(255) NOT NULL,
  `data` datetime NOT NULL,
  `data_lliurament` datetime DEFAULT NULL,
  `data_recepcio` datetime DEFAULT NULL,
  `estat` varchar(255) NOT NULL,
  `lliure` varchar(255) DEFAULT NULL,
  `metode_enviament` varchar(50) NOT NULL,
  `nif_fact` varchar(255) NOT NULL,
  `nom_env` varchar(255) NOT NULL,
  `nom_fact` varchar(255) NOT NULL,
  `poblacio_env` varchar(255) NOT NULL,
  `poblacio_fact` varchar(255) NOT NULL,
  `preu_total` decimal(19,2) NOT NULL,
  `usuari_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK38A09A6BB4DFB896` (`usuari_id`),
  CONSTRAINT `FK38A09A6BB4DFB896` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
INSERT INTO `comanda` VALUES (1,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2011-06-20 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',20.00,1),(2,1,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2011-06-02 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(3,1,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2011-06-14 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(4,1,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2011-06-09 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(5,1,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2011-06-30 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(6,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2012-06-01 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(7,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2012-06-17 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(8,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2012-06-25 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(9,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2012-06-20 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(10,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2012-06-16 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(11,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2012-06-18 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1),(12,0,'session.dadesEnvia.adreca','session.usuari.adreca','sabria','session.usuari.cognom','2012-06-22 20:04:30',NULL,NULL,'en proces',NULL,'UPS','addfakdfaf','jordi','session.usuari.nom','girona','Girona',40.00,1);
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda_linies_comanda`
--

DROP TABLE IF EXISTS `comanda_linies_comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comanda_linies_comanda` (
  `comanda_linies_comanda_id` bigint(20) DEFAULT NULL,
  `linies_comanda_id` bigint(20) DEFAULT NULL,
  KEY `FK11952A267803A750` (`linies_comanda_id`),
  KEY `FK11952A26C6D0242` (`comanda_linies_comanda_id`),
  CONSTRAINT `FK11952A26C6D0242` FOREIGN KEY (`comanda_linies_comanda_id`) REFERENCES `comanda` (`id`),
  CONSTRAINT `FK11952A267803A750` FOREIGN KEY (`linies_comanda_id`) REFERENCES `linies_comanda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda_linies_comanda`
--

LOCK TABLES `comanda_linies_comanda` WRITE;
/*!40000 ALTER TABLE `comanda_linies_comanda` DISABLE KEYS */;
INSERT INTO `comanda_linies_comanda` VALUES (1,2),(1,1),(2,4),(2,3),(3,5),(4,6),(5,7),(5,8);
/*!40000 ALTER TABLE `comanda_linies_comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `adreca` varchar(255) NOT NULL,
  `cp` varchar(255) NOT NULL,
  `data` datetime NOT NULL,
  `poblacio` varchar(255) NOT NULL,
  `preu_base_general` decimal(19,2) NOT NULL,
  `preu_base_reduit` decimal(19,2) NOT NULL,
  `preu_base_superreduit` decimal(19,2) NOT NULL,
  `preu_total_general` decimal(19,2) NOT NULL,
  `preu_total_reduit` decimal(19,2) NOT NULL,
  `preu_total_superreduit` decimal(19,2) NOT NULL,
  `usuari` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linies_comanda`
--

DROP TABLE IF EXISTS `linies_comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linies_comanda` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `id_producte` varchar(255) NOT NULL,
  `preu` decimal(19,2) NOT NULL,
  `producte` varchar(255) NOT NULL,
  `quantitat` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linies_comanda`
--

LOCK TABLES `linies_comanda` WRITE;
/*!40000 ALTER TABLE `linies_comanda` DISABLE KEYS */;
INSERT INTO `linies_comanda` VALUES (1,0,'1',60.00,'Samarreta Barça 2012',2),(2,0,'2',50.00,'Samarreta Milan 2011',2),(3,0,'1',60.00,'Samarreta Barça 2012',2),(4,0,'2',50.00,'Samarreta Milan 2011',2),(5,0,'1',60.00,'Samarreta Barça 2012',2),(6,0,'2',50.00,'Samarreta Milan 2011',2),(7,0,'1',60.00,'Samarreta Barça 2012',2),(8,0,'2',50.00,'Samarreta Milan 2011',2);
/*!40000 ALTER TABLE `linies_comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linies_factura`
--

DROP TABLE IF EXISTS `linies_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linies_factura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `preu` decimal(19,2) NOT NULL,
  `producte` varchar(255) NOT NULL,
  `quantitat` int(11) NOT NULL,
  `tipus_iva` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linies_factura`
--

LOCK TABLES `linies_factura` WRITE;
/*!40000 ALTER TABLE `linies_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `linies_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oferta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `data_fi_oferta` datetime DEFAULT NULL,
  `data_inici_oferta` datetime NOT NULL,
  `descompte` decimal(19,2) NOT NULL,
  `preu_oferta` decimal(19,2) NOT NULL,
  `producte_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC336EE31559DAF0B` (`producte_id`),
  CONSTRAINT `FKC336EE31559DAF0B` FOREIGN KEY (`producte_id`) REFERENCES `producte` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
INSERT INTO `oferta` VALUES (1,1,'2012-06-09 00:00:00','2012-05-04 00:00:00',10.00,54.00,1),(2,1,'2012-06-22 00:00:00','2012-05-09 00:00:00',15.00,42.50,2),(3,1,NULL,'2012-05-29 00:00:00',10.00,102.60,5),(4,1,'2012-06-30 00:00:00','2012-05-19 00:00:00',11.00,6.57,7),(5,1,'2012-06-30 00:00:00','2012-06-27 00:00:00',12.00,42.50,2);
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producte`
--

DROP TABLE IF EXISTS `producte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producte` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `data_alta` datetime NOT NULL,
  `data_baixa` datetime DEFAULT NULL,
  `descripcio_comercial` longtext NOT NULL,
  `descripcio_detallada` longtext NOT NULL,
  `nom` varchar(50) NOT NULL,
  `preu_cataleg` decimal(19,2) NOT NULL,
  `subcategoria_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC42BD156ABBF7D6B` (`subcategoria_id`),
  CONSTRAINT `FKC42BD156ABBF7D6B` FOREIGN KEY (`subcategoria_id`) REFERENCES `subcategoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producte`
--

LOCK TABLES `producte` WRITE;
/*!40000 ALTER TABLE `producte` DISABLE KEYS */;
INSERT INTO `producte` VALUES (1,0,'2012-06-01 00:00:00',NULL,'El sistema mostra els productes de la cistella de lusuari. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Lusuari escull un producte duna llista de productes. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Samarreta Barça 2012',60.00,2),(2,0,'2012-06-01 00:00:00',NULL,'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.','El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.','Samarreta Milan 2012',50.00,2),(3,0,'2012-06-01 00:00:00',NULL,'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Pilota Nike 2012',24.00,1),(4,0,'2012-06-01 00:00:00',NULL,'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Asics Trabuco Gel',124.00,3),(5,0,'2012-06-01 00:00:00',NULL,'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Mizuno wave',114.00,3),(6,0,'2012-06-01 00:00:00',NULL,'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Salomon compressor',26.00,6),(7,0,'2012-06-01 00:00:00',NULL,'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Domyos socks',7.30,4),(8,0,'2012-06-01 00:00:00',NULL,'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.','El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.','Samarreta R Madrid 2011',1.00,2),(9,0,'2012-06-01 00:00:00',NULL,'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.','El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.','Samarreta Chelsea 2011',104.00,2),(10,0,'2012-06-01 00:00:00',NULL,'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.','El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.','Samarreta Málaga 2011',85.00,2),(11,0,'2012-06-01 00:00:00',NULL,'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.','El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.','Samarreta Sel·lecció Alemanya Eurocopa 2012',48.00,2),(12,0,'2012-06-01 00:00:00',NULL,'El personal de comercial gestionarà (altes, baixes i modificacions) el catàleg de productes i realitzarà les ofertes dels productes indicant-ne la durada, ampliantla o reduint-la quan calgui. Un mateix producte podrà tenir planificadesdiverses ofertes que no es poden solapar en el temps.El personal administració disposarà de la possibilitat de obtenir llistats defacturació sobre períodes variables, es podrà escollir el període que es vulgui.Un cop es visualitzi el llistat es podrà exportar el mateix en mode text amb les columnes separades per punt i comes. El llistat de facturació és un llistat acumulatper client de les comandes en el període indicat.De la mateixa manera, el personal de comercial, podrà treure llistats acumulats per categories o productes venuts entre dues dates indicades.','El sistema mostra un formulari de cerca on lsuari pot introduir el nom, una o varies categories de qualsevol nivell i/o el preu mínim i màxim dels productes que vol cercar. Lusuari pot introduir, si vol, dos paraules per el nom i el preu màxim. El sistema cerca al catàleg de productes aquells productes que tenen alnom les dues paraules de la cerca (en qualsevol ordre) i el preu actual de venda (el doferta o de catàleg) i mostra la llista dels productes. Luari pot avançar i retrocedir per totes les pàgines dels productes cercats. Els productes estaran ordenats tant per cent de descompte, data finalització oferta (primer aquells que caduca primer) i per nom. A totes les pàgines es mostra el formulari decerca omplert amb les dades que ha omplert lusuari.','Samarreta Sel·lecció Espanyola Eurocopa 2012',0.50,2),(13,0,'2012-06-01 00:00:00',NULL,'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Pilota Adidas 2011',17.00,1),(14,0,'2011-06-09 00:00:00',NULL,'Aquesta pilota es la ostia neng. Els productes es presentenamb tota la ruta de categories a la que pertany, una foto, el nom, ladescripció comercial i el preu actual indicant lestalvi individual de cada producte,la quantitat del producte a la cistella i el preu total (quantitat per preu).Al final de la llista de productes de la cistella i trobem limport acumulat delpreu total i de lestalvi total per la cistella. Quan lusuari prem continuar compranttornem a la llista de productes don es provenia, encara que hagués passatper una fitxa de producte. A la llista es torna amb els filtres actius que hipogués haver i a la pàgina don provenia.','Pero la ostia en patinet. El sistema mostra tota la informació disponible del producte: el nom, la foto a màxima visualització, la descripció comercial, la descripció detallada, el preu de catàleg, el preu doferta i la finalització de la mateixa. Lusuari té la opció de tornar al llistat o de afegirel producte a la cistella sempre i quan es tracti dun visitant.','Mitjons de mercat',500.00,4);
/*!40000 ALTER TABLE `producte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategoria`
--

DROP TABLE IF EXISTS `subcategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `categoria_id` bigint(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `FK62C52AF3D5E6DDE9` (`categoria_id`),
  CONSTRAINT `FK62C52AF3D5E6DDE9` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategoria`
--

LOCK TABLES `subcategoria` WRITE;
/*!40000 ALTER TABLE `subcategoria` DISABLE KEYS */;
INSERT INTO `subcategoria` VALUES (1,0,1,'Pilotes'),(2,0,1,'Samarretes equips'),(3,0,2,'Sabates'),(4,0,2,'Mitjons'),(5,0,1,'Sin nada'),(6,0,2,'Malles');
/*!40000 ALTER TABLE `subcategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuari`
--

DROP TABLE IF EXISTS `usuari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuari` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `adreca` varchar(200) NOT NULL,
  `cognom` varchar(25) NOT NULL,
  `data_naixement` datetime NOT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(10) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `password2` varchar(10) NOT NULL,
  `poblacio` varchar(255) NOT NULL,
  `rol` varchar(13) NOT NULL,
  `sexe` varchar(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuari`
--

LOCK TABLES `usuari` WRITE;
/*!40000 ALTER TABLE `usuari` DISABLE KEYS */;
INSERT INTO `usuari` VALUES (1,0,'c/novadelli, 27 17257','Sabria','3880-11-02 00:00:00','jsp@jsp.com','client','7737279a','Jordi','secret','secret','Torroella de Montgri','client','H'),(2,0,'c/novadelli, 42 17200','Capell','3884-11-02 00:00:00','dcp@dcp.com','magatzem','564544a','Dani','secret','secret','Girona','magatzem','H'),(3,0,'c/lluny, 42 17200','Casadesus','3886-11-08 00:00:00','acc@acc.com','comercial','78787b','Albert','secret','secret','Molt_lluny','comercial','H'),(4,0,'c/aprop, 42 17200','Riu','3886-11-08 00:00:00','xr@xr.com','admin','888777b','Xevi','secret','secret','Girona','administracio','H');
/*!40000 ALTER TABLE `usuari` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-06-20 20:08:05

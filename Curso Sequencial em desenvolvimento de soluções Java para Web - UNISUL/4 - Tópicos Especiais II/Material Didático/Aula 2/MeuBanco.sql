-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema meubanco
--

CREATE DATABASE IF NOT EXISTS meubanco;
USE meubanco;

--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `cdFuncionario` decimal(9,0) NOT NULL default '0',
  `cdPessoa` decimal(9,0) default NULL,
  `dtAdmissao` date default NULL,
  `vlSalario` decimal(9,2) default NULL,
  `obs` varchar(20) default NULL,
  PRIMARY KEY  (`cdFuncionario`),
  KEY `FKFUNCIONARIOPESSOA` (`cdPessoa`),
  CONSTRAINT `FKFUNCIONARIOPESSOA` FOREIGN KEY (`cdPessoa`) REFERENCES `pessoa` (`cdPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`cdFuncionario`,`cdPessoa`,`dtAdmissao`,`vlSalario`,`obs`) VALUES 
 ('99','1','2008-02-15','982.35',NULL),
 ('101','2','2008-05-01','415.00',NULL),
 ('102','3','2008-05-01','8150.30',NULL),
 ('103','4','2008-06-01','900.00',NULL);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `cdPessoa` decimal(9,0) NOT NULL,
  `nmPessoa` varchar(50) NOT NULL,
  `flSexo` char(1) default NULL,
  `fone` varchar(20) default NULL,
  PRIMARY KEY  (`cdPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pessoa`
--

/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`cdPessoa`,`nmPessoa`,`flSexo`,`fone`) VALUES 
 ('1','Maria Madalena','D',NULL),
 ('2','José João da Silva','D',NULL),
 ('3','Pedro Silveira','D',NULL),
 ('4','José João da Silva','D',NULL),
 ('5','Dirceu Sehnem Hoepers','D',NULL),
 ('101','Nova pessoa',NULL,NULL);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

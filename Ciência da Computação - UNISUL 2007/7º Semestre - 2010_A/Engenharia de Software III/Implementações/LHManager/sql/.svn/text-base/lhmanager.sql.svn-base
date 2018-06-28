/*
SQLyog Community Edition- MySQL GUI v6.15
MySQL - 5.0.51b-community-nt : Database - lhmanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `lhmanager`;

USE `lhmanager`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `cpf` varchar(14) NOT NULL COMMENT 'cpf do cliente',
  `nm_cli` varchar(30) NOT NULL COMMENT 'nome do cliente',
  `dt_nas` date NOT NULL COMMENT 'data de nascimento do cliente',
  `tt_cre` double default NULL COMMENT 'total de créditos que o cliente possui',
  `fone` varchar(50) NOT NULL COMMENT 'telefone do cliente',
  `email` varchar(100) NOT NULL COMMENT 'email do cliente',
  `endereco` varchar(200) NOT NULL COMMENT 'endereço resumido do cliente',
  PRIMARY KEY  (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

/*Table structure for table `cliente_credito` */

DROP TABLE IF EXISTS `cliente_credito`;

CREATE TABLE `cliente_credito` (
  `cd_cli` int(5) NOT NULL COMMENT 'código do cliente',
  `cd_cre` int(5) NOT NULL COMMENT 'código do credito',
  PRIMARY KEY  (`cd_cli`,`cd_cre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente_credito` */

/*Table structure for table `credito` */

DROP TABLE IF EXISTS `credito`;

CREATE TABLE `credito` (
  `cd_cre` int(5) NOT NULL COMMENT 'código de identificação dos créditos',
  `vl_cre` double NOT NULL COMMENT 'valor do crédito',
  `horas` double NOT NULL COMMENT 'horas a que equivale o crédito',
  `cd_pro` int(5) default NULL COMMENT 'código da promoção atual sobre os créditos',
  PRIMARY KEY  (`cd_cre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `credito` */

/*Table structure for table `despesa` */

DROP TABLE IF EXISTS `despesa`;

CREATE TABLE `despesa` (
  `cd_des` int(5) NOT NULL auto_increment COMMENT 'codigo de identificação da despesa',
  `ds_des` varchar(200) NOT NULL COMMENT 'descrição da despesa',
  `vl_des` double NOT NULL COMMENT 'valor da despesa',
  `dt_pagto` date default NULL COMMENT 'data de pagamento da despesa',
  `tp_des` int(5) NOT NULL COMMENT 'tipo da despesa',
  PRIMARY KEY  (`cd_des`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `despesa` */

insert  into `despesa`(`cd_des`,`ds_des`,`vl_des`,`dt_pagto`,`tp_des`) values (1,'Despesa com um novo mouse para a máquina 3.',20,'2010-06-16',1),(2,'Despesa apenas de teste.',21.1,'2010-06-15',3),(3,'Despesa para arrumar a janela quebrada por vândalos.',0,'2010-06-23',2);

/*Table structure for table `promocao` */

DROP TABLE IF EXISTS `promocao`;

CREATE TABLE `promocao` (
  `cd_pro` int(5) NOT NULL COMMENT 'código de identificação da promoção',
  `ds_pro` varchar(200) NOT NULL COMMENT 'descrição da promoção',
  `dt_ini` date default NULL COMMENT 'data de início da promoção',
  `dt_fim` date default NULL COMMENT 'data de término da promoção',
  PRIMARY KEY  (`cd_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `promocao` */

/*Table structure for table `tipo_despesa` */

DROP TABLE IF EXISTS `tipo_despesa`;

CREATE TABLE `tipo_despesa` (
  `cd_tp_des` int(5) NOT NULL COMMENT 'código de identificação do tipo de despesa',
  `ds_tp_des` varchar(200) NOT NULL COMMENT 'descrição do tipo de despesa',
  PRIMARY KEY  (`cd_tp_des`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_despesa` */

insert  into `tipo_despesa`(`cd_tp_des`,`ds_tp_des`) values (1,'Manutenção'),(2,'Vandalismo'),(3,'Outros');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;

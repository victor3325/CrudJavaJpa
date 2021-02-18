-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.5.8-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para mysql
CREATE DATABASE IF NOT EXISTS `mysql` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mysql`;

-- Copiando estrutura para tabela mysql.alunos
CREATE TABLE IF NOT EXISTS `alunos` (
  `IDALUNO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMEALUNO` varchar(20) DEFAULT NULL,
  `SOBRENOME` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`IDALUNO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela mysql.espaco
CREATE TABLE IF NOT EXISTS `espaco` (
  `IDESPACO` int(11) NOT NULL AUTO_INCREMENT,
  `LOTACAO` int(11) DEFAULT NULL,
  `NOMEESPACO` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDESPACO`),
  UNIQUE KEY `NOMEESPACO` (`NOMEESPACO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela mysql.salas
CREATE TABLE IF NOT EXISTS `salas` (
  `IDSALA` int(11) NOT NULL AUTO_INCREMENT,
  `LOTACAO` int(11) DEFAULT NULL,
  `NOMESALA` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDSALA`),
  UNIQUE KEY `NOMESALA` (`NOMESALA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

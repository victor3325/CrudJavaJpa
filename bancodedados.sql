-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.17-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para mydb
CREATE DATABASE IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mydb`;

-- Copiando estrutura para tabela mydb.alunoetapaespaco
CREATE TABLE IF NOT EXISTS `alunoetapaespaco` (
  `idEspaco` int(11) NOT NULL,
  `idAluno` int(11) NOT NULL,
  `idEtapa` int(11) NOT NULL,
  PRIMARY KEY (`idEspaco`,`idAluno`,`idEtapa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela mydb.alunoetapaespaco: ~38 rows (aproximadamente)
/*!40000 ALTER TABLE `alunoetapaespaco` DISABLE KEYS */;
INSERT INTO `alunoetapaespaco` (`idEspaco`, `idAluno`, `idEtapa`) VALUES
	(1, 1, 1),
	(1, 2, 1),
	(1, 3, 1),
	(1, 17, 1),
	(1, 24, 1),
	(1, 25, 1),
	(1, 26, 1),
	(1, 27, 1),
	(1, 28, 1),
	(1, 29, 1),
	(2, 5, 1),
	(2, 10, 1),
	(2, 30, 1),
	(2, 31, 1),
	(2, 32, 1),
	(2, 33, 1),
	(2, 34, 1),
	(2, 35, 1),
	(2, 36, 1);
/*!40000 ALTER TABLE `alunoetapaespaco` ENABLE KEYS */;

-- Copiando estrutura para tabela mydb.alunoetapasala
CREATE TABLE IF NOT EXISTS `alunoetapasala` (
  `idAluno` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `idEtapa` int(11) NOT NULL,
  PRIMARY KEY (`idAluno`,`idSala`,`idEtapa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela mydb.alunoetapasala: ~38 rows (aproximadamente)
/*!40000 ALTER TABLE `alunoetapasala` DISABLE KEYS */;
INSERT INTO `alunoetapasala` (`idAluno`, `idSala`, `idEtapa`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 2, 1),
	(5, 2, 1),
	(10, 1, 1),
	(17, 2, 1),
	(24, 1, 1),
	(25, 2, 1),
	(26, 2, 1),
	(27, 2, 1),
	(28, 2, 1),
	(29, 2, 1),
	(30, 1, 1),
	(31, 2, 1),
	(32, 1, 1),
	(33, 1, 1),
	(34, 2, 1),
	(35, 1, 1),
	(36, 1, 1);
/*!40000 ALTER TABLE `alunoetapasala` ENABLE KEYS */;

-- Copiando estrutura para tabela mydb.alunos
CREATE TABLE IF NOT EXISTS `alunos` (
  `IDALUNO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMEALUNO` varchar(20) DEFAULT NULL,
  `SOBRENOME` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`IDALUNO`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela mydb.alunos: ~19 rows (aproximadamente)
/*!40000 ALTER TABLE `alunos` DISABLE KEYS */;
INSERT INTO `alunos` (`IDALUNO`, `NOMEALUNO`, `SOBRENOME`) VALUES
	(1, ' Victor', 'Fernando Goncalves'),
	(2, 'Maico', 'Ricardo Borba'),
	(3, 'Luiz', 'Silva'),
	(5, ' Ruan', 'Alves'),
	(10, ' Lucas', 'Rodrigues'),
	(17, ' Lucas', 'Nascimento'),
	(24, 'Marcos', 'Souza'),
	(25, ' Luana', 'Goncalves'),
	(26, 'Marilia', 'Alves dos Santos'),
	(27, 'Jocelí', 'Marcondes'),
	(28, 'Jessica', 'Silverio'),
	(29, 'Cristina', 'Barbosa'),
	(30, 'José', 'De Almeida Junior'),
	(31, 'Gustavo', 'Ferraz'),
	(32, 'Cecilia', 'Maria Da Silva'),
	(33, ' Jennifer', 'Santos'),
	(34, 'Gabriel', 'Silvano'),
	(35, 'Joao', 'Marcelino'),
	(36, 'Pedro', 'Gustavo Dos Santos');
/*!40000 ALTER TABLE `alunos` ENABLE KEYS */;

-- Copiando estrutura para tabela mydb.espaco
CREATE TABLE IF NOT EXISTS `espaco` (
  `IDESPACO` int(11) NOT NULL AUTO_INCREMENT,
  `LOTACAO` int(11) DEFAULT NULL,
  `NOMEESPACO` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDESPACO`),
  UNIQUE KEY `NOMEESPACO` (`NOMEESPACO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela mydb.espaco: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `espaco` DISABLE KEYS */;
INSERT INTO `espaco` (`IDESPACO`, `LOTACAO`, `NOMEESPACO`) VALUES
	(1, 27, 'Cantina 1'),
	(2, 25, 'Cantina 2');
/*!40000 ALTER TABLE `espaco` ENABLE KEYS */;

-- Copiando estrutura para tabela mydb.etapa
CREATE TABLE IF NOT EXISTS `etapa` (
  `IDETAPA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDETAPA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela mydb.etapa: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `etapa` DISABLE KEYS */;
INSERT INTO `etapa` (`IDETAPA`, `DESCRICAO`) VALUES
	(1, 'Etapa 1'),
	(2, 'Etapa 2');
/*!40000 ALTER TABLE `etapa` ENABLE KEYS */;

-- Copiando estrutura para tabela mydb.salas
CREATE TABLE IF NOT EXISTS `salas` (
  `IDSALA` int(11) NOT NULL AUTO_INCREMENT,
  `LOTACAO` int(11) DEFAULT NULL,
  `NOMESALA` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDSALA`),
  UNIQUE KEY `NOMESALA` (`NOMESALA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela mydb.salas: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` (`IDSALA`, `LOTACAO`, `NOMESALA`) VALUES
	(1, 25, 'Lab 01'),
	(2, 30, 'Lab 02');
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

-- --------------------------------------------------------
-- Host:                         192.168.2.223
-- Versión del servidor:         8.0.27-0ubuntu0.20.04.1 - (Ubuntu)
-- SO del servidor:              Linux
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para CryptoManager
CREATE DATABASE IF NOT EXISTS `CryptoManager` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `CryptoManager`;

-- Volcando estructura para tabla CryptoManager.moneda
CREATE TABLE IF NOT EXISTS `moneda` (
  `nick` varchar(6) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `logo` blob NOT NULL,
  PRIMARY KEY (`nick`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla CryptoManager.tp_trans
CREATE TABLE IF NOT EXISTS `tp_trans` (
  `id_tipo` int NOT NULL,
  `nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla CryptoManager.trans
CREATE TABLE IF NOT EXISTS `trans` (
  `cant_mon` int NOT NULL,
  `fecha` date NOT NULL,
  `id_trans` int NOT NULL,
  `prec_tot` float NOT NULL,
  `nick_mon` varchar(6) NOT NULL,
  `id_tipo` int NOT NULL,
  PRIMARY KEY (`fecha`),
  KEY `nick_mon` (`nick_mon`),
  KEY `id_tipo` (`id_tipo`),
  CONSTRAINT `trans_ibfk_1` FOREIGN KEY (`nick_mon`) REFERENCES `moneda` (`nick`),
  CONSTRAINT `trans_ibfk_2` FOREIGN KEY (`id_tipo`) REFERENCES `tp_trans` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

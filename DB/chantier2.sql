-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 30 mars 2024 à 16:49
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `chantier2`
--

-- --------------------------------------------------------

--
-- Structure de la table `chantier`
--

DROP TABLE IF EXISTS `chantier`;
CREATE TABLE IF NOT EXISTS `chantier` (
  `directeur_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `proprietaire_id` bigint DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs9a8ripb626gm94di2l8r76dk` (`directeur_id`),
  KEY `FK5d7gxwuf5ndmcfv1rh95350ff` (`proprietaire_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `chantier`
--

INSERT INTO `chantier` (`directeur_id`, `id`, `proprietaire_id`, `adresse`, `nom`) VALUES
(1, 1, 2, '20 rue des maguettes', 'Reconstruction Batiment');

-- --------------------------------------------------------

--
-- Structure de la table `chantier_seq`
--

DROP TABLE IF EXISTS `chantier_seq`;
CREATE TABLE IF NOT EXISTS `chantier_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `chantier_seq`
--

INSERT INTO `chantier_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Structure de la table `consommable`
--

DROP TABLE IF EXISTS `consommable`;
CREATE TABLE IF NOT EXISTS `consommable` (
  `id` bigint NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `consommable`
--

INSERT INTO `consommable` (`id`, `nom`) VALUES
(1, 'Grue'),
(2, 'Camion'),
(3, 'Ciment');

-- --------------------------------------------------------

--
-- Structure de la table `consommable_seq`
--

DROP TABLE IF EXISTS `consommable_seq`;
CREATE TABLE IF NOT EXISTS `consommable_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `consommable_seq`
--

INSERT INTO `consommable_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

DROP TABLE IF EXISTS `operation`;
CREATE TABLE IF NOT EXISTS `operation` (
  `date` date DEFAULT NULL,
  `chantier_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `tache_id` bigint DEFAULT NULL,
  `utilisateur_id` bigint DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc7g9vvutrw1b2o7t3i2gtb6mm` (`chantier_id`),
  KEY `FKf4q7ocld6b1yghhdc4h2as78` (`tache_id`),
  KEY `FK4ne4xqvto1j515xyucqa75y62` (`utilisateur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`date`, `chantier_id`, `id`, `tache_id`, `utilisateur_id`, `nom`) VALUES
('2024-03-10', 1, 1, 1, 4, 'Construction');

-- --------------------------------------------------------

--
-- Structure de la table `operation_seq`
--

DROP TABLE IF EXISTS `operation_seq`;
CREATE TABLE IF NOT EXISTS `operation_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `operation_seq`
--

INSERT INTO `operation_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `designation`) VALUES
(1, 'Directeur'),
(2, 'Proprietaire'),
(3, 'Chef de chantier'),
(4, 'Ouvrier');

-- --------------------------------------------------------

--
-- Structure de la table `role_seq`
--

DROP TABLE IF EXISTS `role_seq`;
CREATE TABLE IF NOT EXISTS `role_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `role_seq`
--

INSERT INTO `role_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
  `temps` int DEFAULT NULL,
  `id` bigint NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`temps`, `id`, `nom`) VALUES
(5000, 1, 'Reconstruction');

-- --------------------------------------------------------

--
-- Structure de la table `tache_consommable`
--

DROP TABLE IF EXISTS `tache_consommable`;
CREATE TABLE IF NOT EXISTS `tache_consommable` (
  `consommable_id` bigint NOT NULL,
  `tache_id` bigint NOT NULL,
  PRIMARY KEY (`consommable_id`,`tache_id`),
  KEY `FKgq78h76v1u5e30w0t68175wo8` (`tache_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `tache_consommable`
--

INSERT INTO `tache_consommable` (`consommable_id`, `tache_id`) VALUES
(1, 1),
(2, 1),
(3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `tache_seq`
--

DROP TABLE IF EXISTS `tache_seq`;
CREATE TABLE IF NOT EXISTS `tache_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `tache_seq`
--

INSERT INTO `tache_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` bigint NOT NULL,
  `role_id` bigint DEFAULT NULL,
  `motDePasse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4gj83vcjpifherbm85but3cco` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `role_id`, `motDePasse`, `nom`) VALUES
(1, 1, '$2a$10$xbG/tViC9dO.zakVy7BGcug0AB8d7izD7/MwrC7KqUU8DtN4epjFy', 'SOUIHI'),
(2, 2, '$2a$10$4GfbHbjVjcH7A.rHTh3w7uS3VbjCSouDDqenG8.AuA3jDEomz5nJW', 'DUPONT'),
(3, 3, '$2a$10$BowZScjxFaTb4NB24FQmxunZRq9KEvoB.06SylUklbZAWLgyv8/2O', 'KOULIBALY'),
(4, 4, '$2a$10$0g4yOHpEjXa5FdyHuHUNGegzzUt1educk.VaNZ4ZEDYonnrbmfdNy', 'GONCALVEZ');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_seq`
--

DROP TABLE IF EXISTS `utilisateur_seq`;
CREATE TABLE IF NOT EXISTS `utilisateur_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur_seq`
--

INSERT INTO `utilisateur_seq` (`next_val`) VALUES
(51);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chantier`
--
ALTER TABLE `chantier`
  ADD CONSTRAINT `FK5d7gxwuf5ndmcfv1rh95350ff` FOREIGN KEY (`proprietaire_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKs9a8ripb626gm94di2l8r76dk` FOREIGN KEY (`directeur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `FK4ne4xqvto1j515xyucqa75y62` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKc7g9vvutrw1b2o7t3i2gtb6mm` FOREIGN KEY (`chantier_id`) REFERENCES `chantier` (`id`),
  ADD CONSTRAINT `FKf4q7ocld6b1yghhdc4h2as78` FOREIGN KEY (`tache_id`) REFERENCES `tache` (`id`);

--
-- Contraintes pour la table `tache_consommable`
--
ALTER TABLE `tache_consommable`
  ADD CONSTRAINT `FKgq78h76v1u5e30w0t68175wo8` FOREIGN KEY (`tache_id`) REFERENCES `tache` (`id`),
  ADD CONSTRAINT `FKsebalcgov6s4myux15o0k1c41` FOREIGN KEY (`consommable_id`) REFERENCES `consommable` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK4gj83vcjpifherbm85but3cco` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

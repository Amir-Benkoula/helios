-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 17 jan. 2022 à 10:12
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `heliosbd`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `formation_acronyme` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2x4bwxiqh6c53cjqlyd6e3t5g` (`formation_acronyme`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `adresse`, `mail`, `nom`, `prenom`, `telephone`, `formation_acronyme`) VALUES
(1, '12 rue du bonheur 13013 Marseille', 'maiga@mail.com', 'Maiga', 'Fouseini', '0345678909', 'SLAM2'),
(2, '14 rue de la vie 13013 Marseille', 'diallo@mail.com', 'Diallo', 'Mamoudou', '0645678468', 'SLAM2'),
(3, '24 rue du soleil 13013 Marseille', 'hugo@mail.com', 'Hugo', 'Victor', '06465890', 'SLAM2'),
(4, '34 rue de la lune 13013 Marseille', 'proust@mail.com', 'Proust', 'Marcel', '0687946324', 'SLAM2'),
(5, '23 rue marguerite  13013 Marseille', 'djian@mail.com', 'Djian', 'Philippe', '0612345676', 'SLAM1'),
(6, '14 rue tournesol 13013 Marseille', 'zidane@mail.com', 'Zidane', 'Zinedine', '0678436709', 'SLAM1'),
(7, '15 rue de la rose 13013 Marseille', 'balzac@mail.com', 'De Balzac', 'honoré', '0784675844', 'SLAM2'),
(8, '16 rue valentin 13013 Marseille', 'camus@mail.com', 'Camus', 'Albert', '0876574822', 'SLAM2'),
(9, '12 rue du bonheur 13013 Marseille', 'zola@mail.com', 'Zola', 'Emile', '02468024', 'SLAM1'),
(10, '69 rue du bocage 13013 Marseille', 'sartre@mail.com', 'Sartre', 'Jean-Paul', '0345678909', 'SLAM1'),
(11, '67 rue bovin 13013 Marseille', 'rabelais@mail.com', 'Rabelais', 'François', '08695847', 'SLAM1'),
(12, '26 rue castafiore 13013 Marseille', 'sand@mail.com', 'Sand', 'Goarges', '0234567890', 'SLAM1'),
(13, '14 rue de la soif 13013 Marseille', 'shakespeare@mail.com', 'Shakespeare', 'William', '0123456789', 'SLAM2'),
(14, '98 rue du palais 13013 Marseille', 'baudelaire@mail.com', 'Baudelaire', 'Charles', '0457382904', 'SLAM2'),
(15, '46 rue de l\'entrain 13013 Marseille', 'dumas@mail.com', 'Dumas', 'Alexandre', '0987654321', 'SLAM1'),
(16, '53 rue du retour 13013 Marseille', 'appolinaire@mail.com', 'Appolinaire', 'Guillaume', '0239467412', 'SLAM1'),
(17, '58 rue druot 13013 Marseille', 'flaubert@mail.com', 'Flaubert', 'Gustave', '04566783920', 'SISR1'),
(18, '68 rue lindet 13013 Marseille', 'rousseau@mail.com', 'Rousseau', 'Jean-Jacques', '0135860456', 'SISR1'),
(19, '35 rue de la pompe 13013 Marseille', 'yourcenar@mail.com', 'Yourcenar', 'Marguerite', '0192837465', 'SISR1'),
(20, '90 rue du maréchal 13013 Marseille', 'eluard@mail.com', 'Eluard', 'Paul', '02938475610', 'SISR2'),
(21, '56 rue sérénité 13013 Marseille', 'maiga@mail.com', 'Aragon', 'Louis', '0345678909', 'SISR2'),
(22, '96 rue du dépassement 13013 Marseille', 'aragon@mail.com', 'Prévert', 'Jacques', '0695847362', 'SISR2'),
(23, '63 rue de la renaissance 13013 Marseille', 'desnos@mail.com', 'Desnos', 'Robert', '0796859403', 'SISR2'),
(24, '14 rue du coq 13013 Marseille', 'breton@mail.com', 'Breton', 'André', '0283745682', 'SISR2'),
(25, '17 rue ariel 13013 Marseille', 'queneau@mail.com', 'Queneau', 'Raymond', '0195738465', 'INUM3'),
(26, '26 rue dindon 13013 Marseille', 'mercoeur@mail.com', 'Mercoeur', 'Elisa', '098049586', 'INUM3'),
(27, '18 rue du chemin vert 13013 Marseille', 'labe@mail.com', 'Labé', 'Louise', '0493867244', 'INUM4'),
(28, '12 rue de la coulée rouge 13013 Marseille', 'vivien@mail.com', 'Vivien', 'Renée', '0691029384', 'INUM4');

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `acronyme` varchar(255) NOT NULL,
  `description` longtext,
  `intitule` varchar(255) DEFAULT NULL,
  `nbrHeure` int(11) NOT NULL,
  PRIMARY KEY (`acronyme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`acronyme`, `description`, `intitule`, `nbrHeure`) VALUES
('INUM3', '	L\'ingénieur en électronique numérique conçoit des circuits imprimés, \n	utilisant des puces électroniques programmables et d\'autres composants. \n	Ces montages électroniques se trouvent dans de nombreux produits et applications : \r\n	consoles de jeux, pass transport sans contact, drones, téléphones portables, etc. \r\n	Lors de la conception, il s\'appuie sur un cahier des charges. \r\n	Il définit ensuite l\'architecture matérielle et fonctionnelle de la partie numérique \r\n	du système électronique, puis il choisit les composants et détermine leur organisation.', 'Ingénieur du numérique quatrième année', 840),
('INUM4', '	Les majeures proposées permettent de se spécialiser et d’approfondir \r\n	des compétences métiers (300h).\r\n	Cybersécurité et réseaux\r\n	Objets connectés et systèmes intelligents\r\n	Big Data & Data Science\r\n	Intelligence artificielle\r\n	Transition numérique', 'Ingénieur du numérique quatrième année', 860),
('INUM5', '	Compétences acquises\r\n	Savoir mettre en œuvre un dispositif de réalité virtuelle et de réalité augmentée\r\n	Savoir mettre en œuvre une application permettant de répondre à un besoin industriel\r\n	Savoir mettre en œuvre un protocole expérimental de validation de méthodes et \r\n	outils de réalité virtuelle/réalité augmentée (savoir développer une démarche scientifique).\r\n	Savoir développer et gérer un projet de recherche et développement, en lien \r\n	avec des entreprises', 'Ingénieur du numérique cinquième année', 560),
('SISR1', '    Participer à la production et à la fourniture de services en réalisant ou en adaptant des solutions d’infrastructure \r\n    et en assurant le fonctionnement optimal des équipements et des services informatiques\r\n    Intervenir plus particulièrement dans : \r\n    L’installation, l’intégration, l’administration, la sécurisation des équipements et des services informatiques,\r\n    L’exploitation, la supervision et la maintenance d\'une infrastructure systèmes et réseaux,\r\n    Le choix et la mise en œuvre de solutions d’hébergement,\r\n    La définition et la configuration des postes clients, des serveurs et des équipements d’interconnexion, leur déploiement \n    et leur maintenance.\r\n    La gestion des actifs de l’infrastructure,\r\n    La recherche de réponses adaptées à des besoins d’évolution de l’infrastructure ou à des problèmes liés à la mise à \n    disposition des services informatiques,\r\n    La résolution des incidents et l’assistance des utilisateurs,\r\n    Le maintien de la qualité des services informatiques,\r\n    La détection, la réaction et l’investigation pour donner suite à un incident de sécurité.\r\n', 'Bts Sio SISR première année', 780),
('SISR2', '	Participer à la production et à la fourniture de services en réalisant \n	ou en adaptant des solutions d’infrastructure et en assurant le fonctionnement\n	optimal des équipements et des services informatiques\r\n	Intervenir plus particulièrement dans : \r\n	L’installation, l’intégration, l’administration, la sécurisation des équipements \n	et des services informatiques,\r\n	L’exploitation, la supervision et la maintenance d\'une infrastructure systèmes et réseaux,\r\n	Le choix et la mise en œuvre de solutions d’hébergement,\r\n	La définition et la configuration des postes clients, des serveurs et des équipements d’interconnexion,\r\n	leur déploiement et leur maintenance,\r\n	La gestion des actifs de l’infrastructure,\r\n	La recherche de réponses adaptées à des besoins d’évolution de l’infrastructure ou à des problèmes liés à \r\n	la mise à disposition des services informatiques,\r\n	La résolution des incidents et l’assistance des utilisateurs,\r\n	Le maintien de la qualité des services informatiques,\r\n	La détection, la réaction et l’investigation pour donner suite à un incident de sécurité.\r\n', 'Bts Sio SLAM deuxiéme année', 890),
('SLAM1', '	Participer à la production et à la fourniture de services en développant, en adaptant ou en maintenant des\r\n 	solutions applicatives.\n	Elle intervient plus particulièrement dans :\r\n	La définition des spécifications techniques à partir de l’expression des besoins des utilisateurs et des \r\n	contraintes de l’organisation préalablement recensés, notamment liées à la sécurité,\r\n	La réalisation, l’adaptation, la sécurisation puis la validation de solutions applicatives à l’aide des cadres \r\n	applicatifs (frameworks) retenus,\r\n	La gestion du patrimoine applicatif,\r\n	La rédaction de la documentation d’une solution applicative,\r\n	La recherche de réponses adaptées à des problèmes liés à la fourniture et à la sécurisation des services informatiques,\r\n	L’accompagnement et l’assistance des utilisateurs,\r\n	Le maintien de la qualité des services applicatifs.', 'Bts Sio SLAM première année', 780),
('SLAM2', '	Participer à la production et à la fourniture de services en développant, en adaptant ou en maintenant des solutions \n	applicatives.\r\n 	Elle intervient plus particulièrement dans :	La définition des spécifications techniques à partir de l’expression des besoins des utilisateurs et des contraintes\r\n	de l’organisation préalablement recensés,notamment liées à la sécurité\r\n	La réalisation, l’adaptation, la sécurisation puis la validation de solutions applicatives à l’aide des cadres\r\n	applicatifs (frameworks) retenus,\r\n	La gestion du patrimoine applicatif,\r\n	La rédaction de la documentation d’une solution applicative,\r\n	La recherche de réponses adaptées à des problèmes liés à la fourniture et à la sécurisation des services informatiques,\r\n	L’accompagnement et l’assistance des utilisateurs,\r\n	Le maintien de la qualité des services applicatifs.', 'Bts Sio SLAM deuxiéme année', 890);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK2x4bwxiqh6c53cjqlyd6e3t5g` FOREIGN KEY (`formation_acronyme`) REFERENCES `formation` (`acronyme`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

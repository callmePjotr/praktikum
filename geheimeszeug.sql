-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 02. Sep 2022 um 14:15
-- Server-Version: 10.4.24-MariaDB
-- PHP-Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `geheim`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `geheimeszeug`
--

CREATE TABLE `geheimeszeug` (
  `id` int(255) UNSIGNED NOT NULL,
  `mail` varchar(80) NOT NULL,
  `password` varchar(800) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `geheimeszeug`
--

INSERT INTO `geheimeszeug` (`id`, `mail`, `password`) VALUES
(1, 'xyz@gmail.com', '5bfa585b9ce43fa46e4215bc98aed1099c0329dceeba088a2f19f5648f8cdd28');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `geheimeszeug`
--
ALTER TABLE `geheimeszeug`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `geheimeszeug`
--
ALTER TABLE `geheimeszeug`
  MODIFY `id` int(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

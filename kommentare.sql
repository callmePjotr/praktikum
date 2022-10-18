--
-- Tabellenstruktur für Tabelle `kommentare`
--

CREATE TABLE `kommentare` (
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `kommentar` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `kommentare`
--

INSERT INTO `kommentare` (`name`, `email`, `kommentar`) VALUES
('Leon', 'xyz@gmail.com', 'Dies ist ein Kommentar!'),
('ich', 'xyz@gmail.com', 'This is my second comment'),
('angreifer', 'altgr@hack.io', '<script>alert(\\\"hello there\\\") </script>'),
('html', 'hallo@mail.com', '<p> diesen Tag bitte so ausgeben </p>'),
('Leon', 'xyz@gmail.com', 'This nqwd biqwdq d qwdqiw bd qwbd qbwidqb diqwbd qib dqbid  qbw dqbdwi qdbi qbdu qwbid'),
('Toni', 'tonermail@gmail.de', 'Does this work? <script>alert(\\\"hello there\\\") </script>'),
('ich', 'xyz@gmail.com', 'wird die Anzahl erhöht?');
COMMIT;

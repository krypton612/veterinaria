-- phpMyAdmin SQL Dump
-- version 5.1.1deb4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 01, 2021 at 12:49 PM
-- Server version: 10.5.9-MariaDB-1
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `veterinaria2`
--

-- --------------------------------------------------------

--
-- Table structure for table `diagnostico`
--

CREATE TABLE `diagnostico` (
  `id_diagnostico` int(11) NOT NULL,
  `id_genera` int(11) DEFAULT 0,
  `descripcion` varchar(225) DEFAULT NULL,
  `enfermedad` varchar(225) DEFAULT NULL,
  `conclusion` varchar(225) DEFAULT NULL,
  `conector` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diagnostico`
--

INSERT INTO `diagnostico` (`id_diagnostico`, `id_genera`, `descripcion`, `enfermedad`, `conclusion`, `conector`) VALUES
(1, 1, 'fasf', 'asdsa', 'dasdas', 0),
(2, 1, 'asfsaf', 'fsaf', 'safsa', 0),
(3, 1, 'asfsaf', 'fsaf', 'safsa', 0),
(4, 1, 'dsa', 'faasfas', 'asd', 0),
(5, 1, 'asdas', 'adsdas', 'dasd', 0),
(6, 1, 'sad', 'dasd', 'dsad', 3),
(7, 1, 'dasd', 'dasd', 'asdas', 2);

-- --------------------------------------------------------

--
-- Table structure for table `genera`
--

CREATE TABLE `genera` (
  `id_genera` int(11) NOT NULL,
  `id_paciente` int(11) DEFAULT 0,
  `estado` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL DEFAULT 0,
  `fecha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genera`
--

INSERT INTO `genera` (`id_genera`, `id_paciente`, `estado`, `precio`, `fecha`) VALUES
(1, 1, 'vivo', 0, ''),
(2, 1, 'vivo', 0, ''),
(3, 1, 'vivo', 0, ''),
(4, 1, 'vivo', 0, ''),
(5, 1, 'vivo', 0, ''),
(6, 1, 'vivo', 0, ''),
(7, 1, 'vivo', 123, '2021-11-4');

-- --------------------------------------------------------

--
-- Table structure for table `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL,
  `id_registrar` int(11) DEFAULT 0,
  `nombre` varchar(40) DEFAULT NULL,
  `especie` varchar(40) NOT NULL,
  `raza` varchar(40) NOT NULL,
  `color` varchar(40) NOT NULL,
  `edad` varchar(40) DEFAULT NULL,
  `sexo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `id_registrar`, `nombre`, `especie`, `raza`, `color`, `edad`, `sexo`) VALUES
(1, 1, 'general', 'Canino', 'macur', 'negro', '0', 'Macho'),
(2, 1, 'carlos', 'Canino', 'nuget', 'verde', '0', 'Macho'),
(3, 1, 'carlo', 'Canino', 'nuget', 'verde', '0', 'Macho'),
(4, 4, 'asfsa', 'Canino', 'fasf', 'asfas', '0', 'Macho'),
(5, 6, 'dasdas', 'Canino', 'dasd', 'asda', '0', 'Macho'),
(6, 3, 'asdd', 'Canino', 'dasd', '1dsa', '0', 'Macho'),
(7, 3, 'asdasd', 'Ovino', 'asdasd', 'negro', '0', 'Hembra'),
(8, 3, 'asdasd', 'Ovino', 'asdasd', 'negro', '0', 'Hembra'),
(9, 2, 'sadasd', 'Canino', 'asd', '2dasd', '0', 'Macho');

-- --------------------------------------------------------

--
-- Table structure for table `propietario`
--

CREATE TABLE `propietario` (
  `id_propietario` int(11) NOT NULL,
  `nombre` varchar(225) NOT NULL,
  `cedula_identidad` varchar(10) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `propietario`
--

INSERT INTO `propietario` (`id_propietario`, `nombre`, `cedula_identidad`, `direccion`, `telefono`) VALUES
(1, 'Ronald Diaz Otrillas', '7897246', 'San marcos', '67584475'),
(2, 'Jhon peter Mogrovejo', '7844458', 'Shinahota calle 13, bolivia', '68784894'),
(3, 'Moises Flores', '9878484', 'Ivirgarzama 13, bolivia', '68947778'),
(4, 'Itamar', '7844575', 'Calle coca, shinahota', '67445555'),
(5, 'Jose marcelo velazques', '7848484', 'Calle antezana', '78942645'),
(6, 'Marcelo juarez', '6874478', 'Shinahota barrio petrolero', '76784874'),
(7, 'Carlos marquez', '7897454', 'Chimore calle 134', '78484844');

-- --------------------------------------------------------

--
-- Table structure for table `registrar`
--

CREATE TABLE `registrar` (
  `id_registrar` int(11) NOT NULL,
  `id_user` int(11) DEFAULT 0,
  `id_propietario` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registrar`
--

INSERT INTO `registrar` (`id_registrar`, `id_user`, `id_propietario`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 1, 3),
(4, 1, 6),
(5, 1, 2),
(6, 1, 2),
(7, 1, 2),
(8, 1, 2),
(9, 1, 6),
(10, 1, 2),
(11, 1, 2),
(12, 1, 2),
(13, 1, 3),
(14, 1, 2),
(15, 1, 3),
(16, 1, 3),
(17, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `email`, `password`) VALUES
(1, 'admin', 'admin@gmail.com', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD PRIMARY KEY (`id_diagnostico`),
  ADD KEY `id_genera` (`id_genera`);

--
-- Indexes for table `genera`
--
ALTER TABLE `genera`
  ADD PRIMARY KEY (`id_genera`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`),
  ADD KEY `id_registrar` (`id_registrar`);

--
-- Indexes for table `propietario`
--
ALTER TABLE `propietario`
  ADD PRIMARY KEY (`id_propietario`);

--
-- Indexes for table `registrar`
--
ALTER TABLE `registrar`
  ADD PRIMARY KEY (`id_registrar`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_propietario` (`id_propietario`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diagnostico`
--
ALTER TABLE `diagnostico`
  MODIFY `id_diagnostico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `genera`
--
ALTER TABLE `genera`
  MODIFY `id_genera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `propietario`
--
ALTER TABLE `propietario`
  MODIFY `id_propietario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `registrar`
--
ALTER TABLE `registrar`
  MODIFY `id_registrar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD CONSTRAINT `diagnostico_ibfk_1` FOREIGN KEY (`id_genera`) REFERENCES `genera` (`id_genera`);

--
-- Constraints for table `genera`
--
ALTER TABLE `genera`
  ADD CONSTRAINT `genera_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`);

--
-- Constraints for table `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`id_registrar`) REFERENCES `registrar` (`id_registrar`);

--
-- Constraints for table `registrar`
--
ALTER TABLE `registrar`
  ADD CONSTRAINT `registrar_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `registrar_ibfk_2` FOREIGN KEY (`id_propietario`) REFERENCES `propietario` (`id_propietario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

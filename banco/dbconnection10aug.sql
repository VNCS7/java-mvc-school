-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2018 at 07:58 AM
-- Server version: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbconnection10aug`
--

-- --------------------------------------------------------

--
-- Table structure for table `aluno`
--

CREATE TABLE `aluno` (
  `idAluno` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `rg` varchar(200) NOT NULL,
  `cpf` varchar(200) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `bairro` varchar(200) NOT NULL,
  `cep` varchar(200) NOT NULL,
  `idCurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aluno`
--

INSERT INTO `aluno` (`idAluno`, `nome`, `rg`, `cpf`, `endereco`, `bairro`, `cep`, `idCurso`) VALUES
(7, 'Vinicius Alves Rodrigues', '37.600.640-7', '473.140.228/01', 'R. Milagre dos Peixes,52', 'Castro Alves', '08474-120', 1);

-- --------------------------------------------------------

--
-- Table structure for table `curso`
--

CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `cargaHoraria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `curso`
--

INSERT INTO `curso` (`idCurso`, `nome`, `cargaHoraria`) VALUES
(1, 'Técnico em Informática', 1500);

-- --------------------------------------------------------

--
-- Table structure for table `disciplina`
--

CREATE TABLE `disciplina` (
  `idDisciplina` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  `nomeDisciplina` varchar(200) NOT NULL,
  `cargaHoraria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disciplina`
--

INSERT INTO `disciplina` (`idDisciplina`, `idCurso`, `nomeDisciplina`, `cargaHoraria`) VALUES
(1, 1, 'Programação de Computadores', 5);

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE `professor` (
  `idProfessor` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `rg` varchar(200) NOT NULL,
  `cpf` varchar(200) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `bairro` varchar(200) NOT NULL,
  `cep` varchar(200) NOT NULL,
  `idCurso` int(11) NOT NULL,
  `idDisciplina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`idProfessor`, `nome`, `rg`, `cpf`, `endereco`, `bairro`, `cep`, `idCurso`, `idDisciplina`) VALUES
(1, 'Jeferson', '00.000.000-0', '000.000.000/00', 'Av. Águia de Haia', 'Cidade A.E Carvalho', '00000-000', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`idAluno`),
  ADD KEY `idCurso` (`idCurso`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idCurso`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`idDisciplina`),
  ADD KEY `idCurso` (`idCurso`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`idProfessor`),
  ADD KEY `idDisciplina` (`idDisciplina`),
  ADD KEY `idCurso` (`idCurso`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `idAluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `curso`
--
ALTER TABLE `curso`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `idDisciplina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `idProfessor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`);

--
-- Constraints for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD CONSTRAINT `disciplina_ibfk_1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`);

--
-- Constraints for table `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`idDisciplina`) REFERENCES `disciplina` (`idDisciplina`),
  ADD CONSTRAINT `professor_ibfk_2` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

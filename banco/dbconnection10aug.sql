

CREATE TABLE `aluno` (
  `idAluno` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `rg` varchar(200) NOT NULL,
  `cpf` varchar(200) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `bairro` varchar(200) NOT NULL,
  `cep` varchar(200) NOT NULL,
  `idCurso` int(11) NOT NULL,
    FOREIGN KEY (idCurso) REFERENCES curso(idCurso)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
--

--
CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `cargaHoraria` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
--

--
CREATE TABLE `disciplina` (
  `idDisciplina` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  `nomeDisciplina` varchar(200) NOT NULL,
  `cargaHoraria` int(11) NOT NULL,
    FOREIGN KEY (idCurso) REFERENCES curso(idCurso)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
--

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
  `idDisciplina` varchar(200) NOT NULL,
    FOREIGN KEY (idCurso) REFERENCES curso(idCurso),
    FOREIGN KEY (idDisciplina) REFERENCES disciplina(idDisciplina)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
--

--
ALTER TABLE `aluno`
    ADD PRIMARY KEY (`idAluno`);
--
ALTER TABLE `curso`
    ADD PRIMARY KEY (`idCurso`);
--
ALTER TABLE `disciplina`
    ADD PRIMARY KEY (`idDisciplina`);
--
ALTER TABLE `professor`
    ADD PRIMARY KEY (`idProfessor`);
--
ALTER TABLE `aluno`
  MODIFY `idAluno` int(11) NOT NULL AUTO_INCREMENT;
--
ALTER TABLE `curso`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT;
--
ALTER TABLE `disciplina`
  MODIFY `idDisciplina` int(11) NOT NULL AUTO_INCREMENT;
--
ALTER TABLE `professor`
  MODIFY `idProfessor` int(11) NOT NULL AUTO_INCREMENT;


INSERT INTO `aluno` (`idAluno`, `nome`, `rg`, `cpf`, `endereco`, `bairro`, `cep`, `idCurso`) VALUES
(7, 'Vinícius Alves Rodrigues', '11.111.111-7', '111.111.111/11', 'R. Antiga Três, 52', 'C. Alves', '11111-111', 5);

--

--

INSERT INTO `curso` (`idCurso`, `nome`, `cargaHoraria`) VALUES
(5, 'Técnico em Informática', 1500);

--

--

INSERT INTO `disciplina` (`idDisciplina`, `idCurso`, `nomeDisciplina`, `cargaHoraria`) VALUES
(6, 5, 'Programação de Computadores II', 5);

--

--

INSERT INTO `professor` (`idProfessor`, `nome`, `rg`, `cpf`, `endereco`, `bairro`, `cep`, `idCurso`, `idDisciplina`) VALUES
(1, 'Jeferson', '22.222.222-2', '222.222.222/22', 'Av. Águia de Haia, 2633', 'Cidade A.E Carvalho', '22222-222', 5, '6');

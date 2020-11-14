-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Nov-2020 às 20:54
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `locadora`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `endereco` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nome`, `cpf`, `telefone`, `endereco`) VALUES
(1, 'Raquel', '03866263082', '55997235209', 'Rua Osório Martins - 90');

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme`
--

CREATE TABLE `filme` (
  `idFilme` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `tempo` int(11) NOT NULL,
  `imagem3d` tinyint(1) NOT NULL,
  `dublado` tinyint(1) NOT NULL,
  `sinopse` varchar(400) NOT NULL,
  `categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `filme`
--

INSERT INTO `filme` (`idFilme`, `titulo`, `tempo`, `imagem3d`, `dublado`, `sinopse`, `categoria`) VALUES
(1, 'teste', 17, 0, 1, 'testandooooo	', 'suspense');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Índices para tabela `filme`
--
ALTER TABLE `filme`
  ADD PRIMARY KEY (`idFilme`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `filme`
--
ALTER TABLE `filme`
  MODIFY `idFilme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

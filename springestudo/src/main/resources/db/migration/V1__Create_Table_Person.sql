CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(100) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `genero` varchar(6) NOT NULL,
  `sobrenome` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) 
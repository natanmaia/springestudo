CREATE TABLE `pessoa`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `genero` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `nome` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `sobrenome` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
)
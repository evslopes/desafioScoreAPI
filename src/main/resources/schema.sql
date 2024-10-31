CREATE TABLE IF NOT EXISTS usuario
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role     VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS pessoa
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome       VARCHAR(100) NOT NULL,
    idade      INT          NOT NULL,
    cep        VARCHAR(10)  NOT NULL,
    estado     VARCHAR(2),
    cidade     VARCHAR(100),
    bairro     VARCHAR(100),
    logradouro VARCHAR(100),
    telefone   VARCHAR(15),
    score      INT CHECK (score BETWEEN 0 AND 1000),
    ativo      BOOLEAN DEFAULT TRUE
);

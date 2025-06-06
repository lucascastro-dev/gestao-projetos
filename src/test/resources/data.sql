CREATE TABLE funcionario (
    id_funcionario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(11),
    email VARCHAR(100),
    salario DECIMAL(10, 2)
);

CREATE TABLE projeto (
    id_projeto BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_criacao DATE
);

CREATE TABLE projeto_funcionario (
    id_projeto BIGINT NOT NULL,
    id_funcionario BIGINT NOT NULL,
    PRIMARY KEY (id_projeto, id_funcionario),
    CONSTRAINT fk_projeto FOREIGN KEY (id_projeto) REFERENCES projeto(id_projeto) ON DELETE CASCADE,
    CONSTRAINT fk_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario) ON DELETE CASCADE
);

INSERT INTO funcionario (id_funcionario, nome, cpf, email, salario)
VALUES
    (1, 'João Silva', '12345678901', 'joao.silva@example.com', 5000.00),
    (2, 'Maria Oliveira', '98765432100', 'maria.oliveira@example.com', 7000.00);

INSERT INTO projeto (id_projeto, nome, data_criacao)
VALUES
    (1, 'Projeto A', '2025-06-06'),
    (2, 'Projeto B', '2025-06-05');

INSERT INTO projeto_funcionario (id_projeto, id_funcionario)
VALUES
  (1, 1),
  (2, 2);

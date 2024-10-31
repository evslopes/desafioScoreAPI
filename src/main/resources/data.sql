-- Usuários
INSERT INTO usuario (username, password, role)
VALUES ('admin', '$2a$10$D9Zjx8zjLKSNNYPqEy7YoOuHcb.d/wPQ8uLNYOd4bCrbo59X2BPI6', 'ROLE_ADMIN'), -- Senha: admin123
       ('user', '$2a$10$ExuM9GqLjjRX9ghyZV9IOOm9URyqUzpQUbO1LbJ1/jEzG.EyXp3zK', 'ROLE_USER');
-- Senha: user123

-- Dados iniciais para a tabela Pessoa
INSERT INTO pessoa (nome, idade, cep, estado, cidade, bairro, logradouro, telefone, score, ativo)
VALUES ('João Silva', 30, '12345000', 'SP', 'São Paulo', 'Centro', 'Rua A', '11987654321', 450, true),
       ('Maria Oliveira', 25, '12346000', 'RJ', 'Rio de Janeiro', 'Zona Sul', 'Avenida B', '21987654321', 750, true),
       ('Carlos Santos', 40, '12347000', 'MG', 'Belo Horizonte', 'Savassi', 'Rua C', '31987654321', 200, true),
       ('Ana Costa', 22, '12348000', 'PR', 'Curitiba', 'Batel', 'Rua D', '41987654321', 300, true);

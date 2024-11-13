insert into perfis(id, nome)
values (1, 'ROLE_ADMIN');
insert into perfis(id, nome)
values (2, 'ROLE_USER');

insert into usuarios(id, nome, sobrenome, email, senha, is_confirmado)
values (1, 'Admin', 'do Sistema', 'admin@email.com', '$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe', true);
insert into usuarios(id, nome, sobrenome, email, senha, is_confirmado)
values (2, 'Usuario', 'do Sistema', 'user@email.com', '$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe', true);
insert into usuarios_perfis(usuarios_id, perfis_id)
values (1, 1);
insert into usuarios_perfis(usuarios_id, perfis_id)
values (2, 2);

-- Populating the 'fabricantes' table
INSERT INTO fabricantes (nome) VALUES ('Fabricante A');
INSERT INTO fabricantes (nome) VALUES ('Fabricante B');
INSERT INTO fabricantes (nome) VALUES ('Fabricante C');

-- Populating the 'modelos_carros' table
INSERT INTO modelos_carros (descricao, categoria, fabricante_id) VALUES ('Modelo A', 'SEDAN_GRANDE', 1);
INSERT INTO modelos_carros (descricao, categoria, fabricante_id) VALUES ('Modelo B', 'MINIVAN', 2);
INSERT INTO modelos_carros (descricao, categoria, fabricante_id) VALUES ('Modelo C', 'ESPORTIVO', 3);

-- Populating the 'pessoas' table
INSERT INTO pessoas (nome, cpf, data_nascimento, sexo) VALUES ('João Silva', '12345678901', '1980-01-01', 'MASCULINO');
INSERT INTO pessoas (nome, cpf, data_nascimento, sexo) VALUES ('Maria Oliveira', '23456789012', '1990-02-02', 'FEMININO');
INSERT INTO pessoas (nome, cpf, data_nascimento, sexo) VALUES ('Carlos Souza', '34567890123', '1985-03-03', 'MASCULINO');

-- Populating the 'funcionarios' table
INSERT INTO funcionarios (pessoa_id, matricula) VALUES (1, 'MAT001');
INSERT INTO funcionarios (pessoa_id, matricula) VALUES (2, 'MAT002');

-- Populating the 'motoristas' table
INSERT INTO motoristas (pessoa_id, numeroCNH) VALUES (3, 'CNH001');

-- Populating the 'carros' table
INSERT INTO carros (placa, chassi, cor, valor_diaria, modelo_id) VALUES ('ABC-1234', 'CHASSI001', 'Preto', 100.00, 1);
INSERT INTO carros (placa, chassi, cor, valor_diaria, modelo_id) VALUES ('DEF-5678', 'CHASSI002', 'Branco', 150.00, 2);
INSERT INTO carros (placa, chassi, cor, valor_diaria, modelo_id) VALUES ('GHI-9012', 'CHASSI003', 'Vermelho', 200.00, 3);

-- Populating the 'acessorios' table
INSERT INTO acessorios (descricao) VALUES ('Ar Condicionado');
INSERT INTO acessorios (descricao) VALUES ('Direção Hidráulica');
INSERT INTO acessorios (descricao) VALUES ('Vidro Elétrico');

-- Populating the 'carros_acessorios' table
INSERT INTO carros_acessorios (carro_id, acessorio_id) VALUES (1, 1);
INSERT INTO carros_acessorios (carro_id, acessorio_id) VALUES (1, 2);
INSERT INTO carros_acessorios (carro_id, acessorio_id) VALUES (2, 2);
INSERT INTO carros_acessorios (carro_id, acessorio_id) VALUES (2, 3);
INSERT INTO carros_acessorios (carro_id, acessorio_id) VALUES (3, 1);
INSERT INTO carros_acessorios (carro_id, acessorio_id) VALUES (3, 3);

-- Populating the 'alugueis' table
INSERT INTO alugueis (data_pedido, data_entrega, data_devolucao, valor_total, valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo, motorista_id, carro_id)
VALUES ('2023-01-01', '2023-01-02', '2023-01-10', 1000.00, 200.00, true, true, true, 1, 1);
INSERT INTO alugueis (data_pedido, data_entrega, data_devolucao, valor_total, valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo, motorista_id, carro_id)
VALUES ('2023-02-01', '2023-02-02', '2023-02-10', 1500.00, 300.00, true, false, true, 1, 2);
INSERT INTO alugueis (data_pedido, data_entrega, data_devolucao, valor_total, valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo, motorista_id, carro_id)
VALUES ('2023-03-01', '2023-03-02', '2023-03-10', 2000.00, 400.00, false, true, false, 1, 3);


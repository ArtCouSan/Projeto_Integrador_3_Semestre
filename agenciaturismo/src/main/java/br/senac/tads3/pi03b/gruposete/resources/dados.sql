--adiciona Voos pré definidos
INSERT INTO Voo (data_ida, data_volta, destino, origem, preco, ativo) 
VALUES ('10/10/1010', '10/10/1111', 'são paulo', 'chile', 123.45, true);

--adiciona Hotéis pré definidos
INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, ativo) 
VALUES ('five stars', '10/10/1010', '10/10/1011', 10, 1, 123.45, true);

--adiciona Funcionários pré definidos
INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, bairro, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Vendedor', 'Vendas', 'SP', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal de sp', 'jardim', 'SP', '-', 'Rafael', '012.123.123-12', 'M', true, '12/12/1212', 'admin', 'admin', 'MASTER');

--adiciona Clientes pré definidos
INSERT INTO Cliente (celular, telefone, email, numero, cep, rua, 
bairro, cidade, complemento, nome, cpf, sexo, ativo, data_nasc) 
VALUES ('(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal de sp', 'jardim', 'SP', '-', 'Rafael', '012.123.123-12', 'M', true, '12/12/1212');

--adiciona Vendas pré definidas
INSERT INTO Venda (id_cliente, id_funcionario, ativo, total_preco, data_venda) 
VALUES (1, 1, true, 100.10, '10/10/1010');
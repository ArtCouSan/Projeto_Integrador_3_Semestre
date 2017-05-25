--adiciona um usuario "MASTER" e um "BASICO"
INSERT INTO Usuario (nome, login, senha, acesso) VALUES ('Master', 'admin', 'admin', 'MASTER');
INSERT INTO Usuario (nome, login, senha, acesso) VALUES ('Basico', 'basico', 'basico', 'BASICO');

--adiciona Voos pré definidos
INSERT INTO Voo (data_ida, data_volta, destino, origem, preco, ativo) VALUES ();

--adiciona Hotéis pré definidos
INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, ativo) VALUES ();

--adiciona Funcionários pré definidos
INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, rua, bairro, cidade, complemento, nome, cpf, sexo, ativo, data_nasc) VALUES ();

--adiciona Clientes pré definidos
INSERT INTO Cliente (celular, telefone, email, numero, cep, rua, bairro, cidade, complemento, nome, cpf, sexo, ativo, data_nasc) VALUES ();
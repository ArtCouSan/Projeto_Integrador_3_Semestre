CREATE DATABASE Agencia DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;;
USE Agencia;

CREATE TABLE Funcionario(
id_funcionario INT(3) NOT NULL AUTO_INCREMENT,
cargo VARCHAR(100) NOT NULL,
departamento VARCHAR(100) NOT NULL,
filial VARCHAR(100) NOT NULL,
celular VARCHAR(15),
telefone VARCHAR(14),
email VARCHAR(50),
numero INT(3) NOT NULL,
cep VARCHAR(10) NOT NULL,
cidade VARCHAR(100) NOT NULL,
rua VARCHAR(50) NOT NULL,
estado VARCHAR(2) NOT NULL,
complemento VARCHAR(20),
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
sexo VARCHAR(10) NOT NULL,
ativo TINYINT(1) NOT NULL,
data_nasc VARCHAR(11) NOT NULL,
login VARCHAR(20) NOT NULL,
senha VARCHAR(20) NOT NULL,
acesso VARCHAR(100) NOT NULL,
PRIMARY KEY (id_funcionario),
UNIQUE KEY id_funcionario (id_funcionario)
);

CREATE TABLE Cliente(
id_cliente INT(3) NOT NULL AUTO_INCREMENT,
celular VARCHAR(14),
telefone VARCHAR(13),
email VARCHAR(50),
numero INT(3) NOT NULL,
cep VARCHAR(9) NOT NULL,
cidade VARCHAR(100) NOT NULL,
rua VARCHAR(50) NOT NULL,
estado VARCHAR(2) NOT NULL,
complemento VARCHAR(20),
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
sexo VARCHAR(10) NOT NULL,
ativo TINYINT(1) NOT NULL,
data_nasc VARCHAR(11) NOT NULL,
PRIMARY KEY (id_cliente),
UNIQUE KEY id_cliente (id_cliente)
);

CREATE TABLE Voo(
id_voo INT(3) NOT NULL AUTO_INCREMENT,    
data_volta VARCHAR(50),
data_ida VARCHAR(50),
destino VARCHAR(50),
origem VARCHAR(50),
preco FLOAT(3.2) NOT NULL,
ativo TINYINT(1) NOT NULL,    
quantidade_passagens INT(3) NOT NULL,
PRIMARY KEY (id_voo)
);

CREATE TABLE Hotel(
id_hotel INT(3) NOT NULL AUTO_INCREMENT,
nome_hotel VARCHAR(50),
data_entrada VARCHAR(50),
data_saida VARCHAR(50),
ativo TINYINT(1) NOT NULL,
preco FLOAT(3.2) NOT NULL,
quantidade_quartos INT(3),
quantidade_hospedes INT(3),
PRIMARY KEY (id_hotel)
);


CREATE TABLE Venda(
id_venda INT(3) NOT NULL AUTO_INCREMENT,
id_cliente INT(3) NOT NULL,
id_funcionario INT(3) NULL,
ativo TINYINT(1) NOT NULL,
total_preco FLOAT(3.2) NOT NULL,
data_venda VARCHAR(10),    
PRIMARY KEY (id_venda),
FOREIGN KEY id_cliente (id_cliente) REFERENCES Cliente(id_cliente),
UNIQUE KEY id_venda (id_venda)
);

CREATE TABLE Itens_Venda (
id_lista INT(5) NOT NULL AUTO_INCREMENT,
id_venda INT(5) NOT NULL,
id_produto INT(5) NOT NULL,
tipo VARCHAR(1),
quantidade INT(50) NOT NULL,
preco FLOAT(3.2) NOT NULL,
PRIMARY KEY  (id_lista)
);

CREATE TABLE relatorioMudancas (
mudanca VARCHAR(100) NOT NULL,
id_funcionario INT(5) NOT NULL,
data_m VARCHAR(10), 
FOREIGN KEY id_funcionario (id_funcionario) REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE sla (
id_sla INT(5) NOT NULL AUTO_INCREMENT,
mensagem VARCHAR(100) NOT NULL,
id_funcionario INT(5) NOT NULL,
data_m VARCHAR(10),
PRIMARY KEY  (id_sla)
);

INSERT INTO Voo (data_ida, data_volta, destino, origem, preco, ativo, quantidade_passagens) 
VALUES ('2017-09-02', '2017-08-01', 'São paulo', 'Síria', 100.00, true, 10);

INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, ativo) 
VALUES ('Beto Carrero Palace', '2017-11-01', '2017-12-11', 10, 1, 100.00, true);

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Administrador', 'Administrador', 'SP', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal', 'SP', 'SP', '-', 'JeffersonRIP', '818.872.789-07', 'M', true, '1212-12-12', 'admin', 'admin', 'Master');

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Vendedor', 'Vendas', 'RJ', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal', 'RJ', 'RJ', '-', 'Carlos', '624.656.819-07', 'M', true, '1212-12-12', 'vendedor', 'vendedor', 'Vendedor');

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Gerente', 'Vendas', 'SP', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal', 'SP', 'SP', '-', 'Daniel', '866.701.467-28', 'M', true, '1212-12-12', 'gerentev', 'gerentev', 'Gerente_Venda');

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Suporte', 'TI', 'RJ', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal', 'RJ', 'RJ', '-', 'Antonio', '202.642.226-52', 'M', true, '1212-12-12', 'suportei', 'suportei', 'Suporte_Informatica');

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Gerente', 'TI', 'SP', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal', 'TO', 'TO', '-', 'Sergio', '761.756.670-00', 'M', true, '1212-12-12', 'gerentei', 'gerentei', 'Gerente_Informatica');

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Retaguarda', 'Produtos', 'SP', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal', 'TO', 'TO', '-', 'Rafael', '186.858.266-32', 'M', true, '1212-12-12', 'retaguarda', 'retaguarda', 'Retaguarda');

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Gerente', 'Produtos', 'RJ', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal', 'RJ', 'RJ', '-', 'Arthur', '872.951.730-30', 'M', true, '1212-12-12', 'gerenter', 'gerenter', 'Gerente_Retaguarda');


INSERT INTO Cliente (celular, telefone, email, numero, cep, rua, 
estado, cidade, complemento, nome, cpf, sexo, ativo, data_nasc) 
VALUES ('(11)15715-7157', '(11)1571-5715', 'pirulito@paodoce.com', 654, '23132-312', 
'Churrascaria', 'SP', 'SP', '-', 'Temer', '437.931.688-24', 'F', true, '1111-12-13');

CREATE DATABASE Agencia;
USE Agencia;

CREATE TABLE Funcionario(
cargo VARCHAR(100) NOT NULL,
departamento VARCHAR(100) NOT NULL,
filial VARCHAR(100) NOT NULL,
celular VARCHAR(15),
telefone VARCHAR(14),
email VARCHAR(50),
numero INT(3),
cep VARCHAR(9),
rua VARCHAR(50), 
estado VARCHAR(2), 
cidade VARCHAR(100), 
complemento VARCHAR(20),
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
sexo CHAR(1),
ativo TINYINT(1) NOT NULL,    
data_nasc VARCHAR(10) NOT NULL,
login VARCHAR(20) NOT NULL,
senha VARCHAR(20) NOT NULL,
acesso VARCHAR(100) NOT NULL,
PRIMARY KEY (cpf),
UNIQUE KEY cpf (cpf)  
);

CREATE TABLE Cliente(
id_cliente INT(3) NOT NULL AUTO_INCREMENT, 
celular VARCHAR(15),
telefone VARCHAR(14),
email VARCHAR(50),
numero INT(3),
cep VARCHAR(10),
cidade VARCHAR(100),
rua VARCHAR(50), 
estado VARCHAR(2),  
complemento VARCHAR(20),
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
sexo CHAR(1),
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
data_venda TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,    
PRIMARY KEY (id_venda),
FOREIGN KEY id_cliente (id_cliente) REFERENCES Cliente(id_cliente),
UNIQUE KEY id_venda (id_venda)
);

CREATE TABLE Itens_Venda (
id_lista INT(5) NOT NULL AUTO_INCREMENT,
id_venda INT(5) NOT NULL,
id_produto INT(5) NOT NULL,
quantidade INT(50) NOT NULL,
preco FLOAT(3.2) NOT NULL,
PRIMARY KEY  (id_lista)
);

INSERT INTO Voo (data_ida, data_volta, destino, origem, preco, ativo) 
VALUES ('10/10/1010', '10/10/1111', 'são paulo', 'chile', 123.45, true);

INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, ativo) 
VALUES ('five stars', '10/10/1010', '10/10/1011', 10, 1, 123.45, true);

INSERT INTO Funcionario (cargo, departamento, filial, celular, telefone, email, numero, cep, 
rua, ESTADO, cidade, complemento, nome, cpf, sexo, ativo, data_nasc, login, senha, acesso) 
VALUES ('Vendedor', 'Vendas', 'SP', '(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal de sp', 'sp', 'SP', '-', 'Rafael', '012.123.123-12', 'M', true, '12/12/1212', 'admin', 'admin', 'MASTER');

INSERT INTO Cliente (celular, telefone, email, numero, cep, rua, 
estado, cidade, complemento, nome, cpf, sexo, ativo, data_nasc) 
VALUES ('(11)13213-4654', '(11)1323-4654', 'aohfa@aosfi.com', 654, '23132-312', 
'rua tal de sp', 'SP', 'SP', '-', 'Rafael', '012.123.123-12', 'M', true, '12/12/1212');

INSERT INTO Venda (id_cliente, id_funcionario, ativo, total_preco, data_venda) 
VALUES (1, 1, true, 100.10, '10/10/1010');

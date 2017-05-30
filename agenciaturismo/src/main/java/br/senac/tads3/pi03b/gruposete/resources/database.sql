CREATE DATABASE Agencia;
USE Agencia;

CREATE TABLE Funcionario(
id_func INT(3) NOT NULL AUTO_INCREMENT,
cargo VARCHAR(100) NOT NULL,
departamento VARCHAR(100) NOT NULL,
filial VARCHAR(100) NOT NULL,
celular VARCHAR(15),
telefone VARCHAR(14),
email VARCHAR(50),
numero INT(3),
cep VARCHAR(9),
rua VARCHAR(50), 
bairro VARCHAR(50), 
cidade VARCHAR(100), 
complemento VARCHAR(20),
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
sexo CHAR(1),
ativo TINYINT(1) NOT NULL,    
data_nasc VARCHAR(10) NOT NULL,
PRIMARY KEY (id_func),
UNIQUE KEY id_func (id_func)  
);

CREATE TABLE Cliente(
id_cliente INT(3) NOT NULL AUTO_INCREMENT, 
celular VARCHAR(9),
telefone VARCHAR(8),
email VARCHAR(50),
numero INT(3),
cep VARCHAR(10),
cidade VARCHAR(100),
rua VARCHAR(50), 
bairro VARCHAR(50),  
complemento VARCHAR(20),
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(15) NOT NULL,
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
quantidade_quartos VARCHAR(50),
quantidade_hospedes VARCHAR(50),
PRIMARY KEY (id_hotel)
);


CREATE TABLE Venda(
id_venda INT(3) NOT NULL AUTO_INCREMENT,
id_cliente INT(3) NOT NULL,
id_funcionario INT(3) NULL,
ativo TINYINT(1) NOT NULL,
total_preco FLOAT(3.2) NOT NULL,
data_venda DATE NOT NULL,    
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

CREATE TABLE Usuario(
id_usuario INT(3) NOT NULL AUTO_INCREMENT,
nome VARCHAR(255) NOT NULL,
login VARCHAR(20) NOT NULL,
senha VARCHAR(20) NOT NULL,
acesso VARCHAR(100) NOT NULL,
caminhos VARCHAR(50) NOT NULL,
icones  VARCHAR(50) NOT NULL,
PRIMARY KEY(id_usuario)
);

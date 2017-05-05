CREATE TABLE Funcionario(
id_func INT(3) NOT NULL AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(11) NOT NULL,
sexo VARCHAR(11),
data_nasc VARCHAR(10),
numero INT(3),
cep VARCHAR(3),
rua VARCHAR(3), 
bairro VARCHAR(3), 
cidade VARCHAR(20),
logradouro VARCHAR(3),
complemento VARCHAR(5),
celular VARCHAR(9),
telefone VARCHAR(8),
email VARCHAR(50),
cargo VARCHAR(100) NOT NULL,
filial VARCHAR(100) NOT NULL,
departamento VARCHAR(100) NOT NULL,    
ativo TINYINT(1) NOT NULL,
PRIMARY KEY (id_func),
UNIQUE KEY id_func (id_func)  
);

CREATE TABLE Cliente(
id_cliente INT(3) NOT NULL AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(11) NOT NULL,
sexo CHAR(11),
data_nasc VARCHAR(10),
numero INT(3),
cep VARCHAR(3),
rua VARCHAR(3), 
bairro VARCHAR(3), 
cidade VARCHAR(20),
logradouro VARCHAR(3),
complemento VARCHAR(5),
celular VARCHAR(9),
telefone VARCHAR(8),
email VARCHAR(50),
ativo TINYINT(1) NOT NULL,
PRIMARY KEY (id_cliente),
UNIQUE KEY id_cliente (id_cliente)
);

CREATE TABLE Voo(
id_voo INT(3) NOT NULL AUTO_INCREMENT,    
data_volta VARCHAR(10),
data_ida VARCHAR(10),
destino VARCHAR(50),
origem VARCHAR(50),
quantidade_passagens INT(3) NOT NULL,
PRIMARY KEY (id_voo)
);

CREATE TABLE Hotel(
id_hotel INT(3) NOT NULL AUTO_INCREMENT,
nome_hotel VARCHAR(50),
data_entrada VARCHAR(10),
data_saida VARCHAR(10),
quantidade_quartos VARCHAR(50),
quantidade_hospedes VARCHAR(50),
PRIMARY KEY (id_hotel)
);

CREATE TABLE Produto(
id_produto INT(3) NOT NULL AUTO_INCREMENT,   
id_voo INT(3),
id_hotel INT(3),
ativo TINYINT(1) NOT NULL,
PRIMARY KEY (id_produto),
FOREIGN KEY id_voo (id_voo) REFERENCES Voo(id_voo),
FOREIGN KEY id_hotel (id_hotel) REFERENCES Hotel(id_hotel),
UNIQUE KEY id_produto (id_produto)
);

CREATE TABLE Venda(
id_venda INT(3) NOT NULL AUTO_INCREMENT,
id_produto INT(3) NOT NULL,
id_cliente INT(3) NOT NULL,
id_func INT(3) NOT NULL,
ativo TINYINT(1) NOT NULL,
preco FLOAT(3.2) NOT NULL,    
PRIMARY KEY (id_venda),
FOREIGN KEY id_produto (id_produto) REFERENCES Produto(id_produto),
FOREIGN KEY id_cliente (id_cliente) REFERENCES Cliente(id_cliente),
FOREIGN KEY id_func (id_func) REFERENCES Funcionario(id_funcionario),
UNIQUE KEY id_venda (id_venda)
);

CREATE TABLE Usuario(
id_usuario INT(3) NOT NULL AUTO_INCREMENT,
nome VARCHAR(255) NOT NULL,
login VARCHAR(20) NOT NULL,
senha VARCHAR(20) NOT NULL,
email VARCHAR(100) NOT NULL,
PRIMARY KEY(id_usuario)
);
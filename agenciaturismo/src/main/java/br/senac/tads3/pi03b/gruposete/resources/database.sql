CREATE TABLE Funcionario(
id_func INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
sexo VARCHAR(9),
data_nasc VARCHAR(10),
numero INT,
cep VARCHAR(9),
rua VARCHAR(100), 
bairro VARCHAR(30), 
cidade VARCHAR(20),
logradouro VARCHAR(10),
complemento VARCHAR(100),
celular VARCHAR(14),
telefone VARCHAR(13),
email VARCHAR(50),
cargo VARCHAR(100) NOT NULL,
filial VARCHAR(100) NOT NULL,
departamento VARCHAR(100) NOT NULL,    
ativo BOOLEAN NOT NULL,
PRIMARY KEY (id_func)
);

CREATE TABLE Cliente(
id_cliente INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cpf VARCHAR(14) NOT NULL,
sexo VARCHAR(9),
data_nasc VARCHAR(10),
numero INT,
cep VARCHAR(9),
rua VARCHAR(100), 
bairro VARCHAR(30), 
cidade VARCHAR(20),
logradouro VARCHAR(10),
complemento VARCHAR(100),
celular VARCHAR(14),
telefone VARCHAR(13),
email VARCHAR(50),
ativo BOOLEAN NOT NULL,
PRIMARY KEY (id_cliente)
);

CREATE TABLE Voo(
id_voo INT NOT NULL AUTO_INCREMENT,
data_volta VARCHAR(10),
data_ida VARCHAR(10),
destino VARCHAR(50),
origem VARCHAR(50),
quantidade_passagens INT NOT NULL,
preco DOUBLE(5,2) NOT NULL,
ativo BOOLEAN NOT NULL,
PRIMARY KEY (id_voo)
);

CREATE TABLE Hotel(
id_hotel INT NOT NULL AUTO_INCREMENT,
nome_hotel VARCHAR(50),
data_entrada VARCHAR(10),
data_saida VARCHAR(10),
quantidade_quartos INT,
quantidade_hospedes INT,
preco DOUBLE(5,2) NOT NULL,
ativo BOOLEAN NOT NULL,
PRIMARY KEY (id_hotel)
);

CREATE TABLE Produto(
id_produto INT NOT NULL AUTO_INCREMENT,
id_voo INT,
id_hotel INT,
preco DOUBLE(5,2) NOT NULL,
FOREIGN KEY (id_voo) REFERENCES Voo(id_voo),
FOREIGN KEY (id_hotel) REFERENCES Hotel(id_hotel),
PRIMARY KEY (id_produto)
);

CREATE TABLE Venda(
id_venda INT NOT NULL AUTO_INCREMENT,
id_produto INT NOT NULL,
id_cliente INT NOT NULL,
id_func INT NOT NULL,
preco DOUBLE(5,2) NOT NULL,    
FOREIGN KEY (id_produto) REFERENCES Produto(id_produto),
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
FOREIGN KEY (id_func) REFERENCES Funcionario(id_func),
PRIMARY KEY (id_venda)
);

CREATE TABLE Usuario(
id_usuario INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(255) NOT NULL,
login VARCHAR(20) NOT NULL,
senha VARCHAR(20) NOT NULL,
acesso VARCHAR(10) NOT NULL,
PRIMARY KEY (id_usuario)
);
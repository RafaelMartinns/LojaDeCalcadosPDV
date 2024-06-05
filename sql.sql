
drop database lojacalcados;

CREATE DATABASE lojacalcados;
USE lojacalcados;

CREATE TABLE Produto (
	idProduto INT NOT NULL AUTO_INCREMENT,
    nomeProduto VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    sexo VARCHAR(20) NOT NULL,
    PRIMARY KEY(idProduto)
);

INSERT INTO Produto (nomeProduto, marca, preco, sexo) VALUES
('Air Max 270', 'Nike', 699.99, 'Masculino'),
('UltraBoost 21', 'Adidas', 799.99, 'Masculino'),
('RS-X3', 'Puma', 549.99, 'Masculino'),
('Gel-Kayano 27', 'Asics', 649.99, 'Feminino'),
('Classic Leather', 'Reebok', 399.99, 'Feminino'),
('Chuck Taylor All Star', 'Converse', 299.99, 'Unissex'),
('Fresh Foam 1080v11', 'New Balance', 699.99, 'Unissex'),
('Metcon 6', 'Nike', 599.99, 'Masculino'),
('Speed TR', 'Reebok', 449.99, 'Unissex'),
('Pegasus Trail 3', 'Nike', 749.99, 'Feminino');

CREATE TABLE produto_tamanho (
    idProduto_tamanho INT PRIMARY KEY AUTO_INCREMENT,
    fk_produto INT,
    tamanho INT,
    quantidade INT,
    FOREIGN KEY (fk_produto) REFERENCES Produto(idProduto) ON DELETE CASCADE
);

INSERT INTO produto_tamanho (fk_produto, tamanho, quantidade) VALUES
(1, 38, 10),
(1, 39, 15),
(1, 40, 12),
(2, 40, 20),
(2, 41, 18),
(3, 39, 14),
(3, 40, 10),
(3, 41, 12),
(4, 42, 10),
(4, 43, 8),
(5, 41, 15),
(5, 42, 10),
(6, 38, 20),
(6, 39, 25),
(7, 40, 12),
(7, 41, 18),
(8, 42, 14),
(8, 43, 16),
(9, 41, 15),
(9, 42, 10),
(10, 43, 12),
(10, 44, 8);


CREATE TABLE cliente (
    idCliente INT NOT NULL AUTO_INCREMENT,
    nomeCliente VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    cpf VARCHAR(100) UNIQUE NOT NULL,
    sexo VARCHAR(100) NOT NULL,
    estadoCivil VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    nascimento DATE,
    PRIMARY KEY (idCliente)
);

CREATE TABLE venda (
    idVenda INT NOT NULL AUTO_INCREMENT,
    fk_cliente INT NOT NULL,
    vlFinal DECIMAL(10,2) NOT NULL,
    dhPedido DATETIME NOT NULL,
    PRIMARY KEY(idVenda),
    FOREIGN KEY (fk_cliente) REFERENCES Cliente(idCliente)
);


CREATE TABLE ItemVenda (
    idItemVenda INT NOT NULL AUTO_INCREMENT,
    fkVenda INT NOT NULL,
    fkProdutoTamanho INT NOT NULL,
    qtd INT NOT NULL,
    precoUnit DOUBLE NOT NULL,
    PRIMARY KEY (idItemVenda),
    FOREIGN KEY (fkVenda) REFERENCES Venda(idVenda),
    FOREIGN KEY (fkProdutoTamanho) REFERENCES Produto_Tamanho(idProduto_Tamanho)
);








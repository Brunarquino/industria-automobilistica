CREATE TABLE tb_cliente (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255),
cpf VARCHAR(11) ,
cep VARCHAR(255),
uf VARCHAR(255) ,
cidade VARCHAR(255) ,
bairro VARCHAR(255) ,
logradouro VARCHAR(255) ,
numero VARCHAR(255) ,
complemento VARCHAR(255)
);

CREATE TABLE tb_fornecedor (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) ,
cnpj VARCHAR(14) ,
pontuacao INT ,
nacionalidade VARCHAR(255) ,
cep VARCHAR(255) ,
uf VARCHAR(255) ,
cidade VARCHAR(255) ,
bairro VARCHAR(255) ,
logradouro VARCHAR(255) ,
numero VARCHAR(255) ,
complemento VARCHAR(255)
);

INSERT INTO tb_fornecedor(id, nome, cnpj, pontuacao, nacionalidade, cep, uf, cidade, bairro, logradouro,
numero, complemento)
VALUES (1, 'Industria Automobilistica Matriz', '12345678905235', 10, 'Brasileira', '1111111', 'sp',
'São Paulo', 'Bairro A', 'Rua A', '111', '');


CREATE TABLE tb_estoque (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
produto_id BIGINT,
quantidade INT NOT NULL
);

CREATE TABLE tb_produto (
produto_id BIGINT AUTO_INCREMENT PRIMARY KEY,
tipo_produto VARCHAR(255) NOT NULL,
nome VARCHAR(255) NOT NULL,
estoque_id BIGINT ,
FOREIGN KEY(estoque_id) REFERENCES tb_estoque(id)
);

ALTER TABLE tb_estoque ADD CONSTRAINT produto_id
FOREIGN KEY(produto_id) REFERENCES tb_produto(produto_id);

CREATE TABLE tb_produto_peca (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
produto_id BIGINT ,
FOREIGN KEY(produto_id) REFERENCES tb_produto(produto_id)
);

CREATE TABLE tb_produto_veiculo (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
produto_id BIGINT ,
status VARCHAR(255) NOT NULL,
valor_insumo INT NOT NULL,
FOREIGN KEY(produto_id) REFERENCES tb_produto(produto_id)
);

CREATE TABLE tb_compra (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
valor_total DECIMAL(19,2) NOT NULL,
fornecedor_id BIGINT ,
FOREIGN KEY(fornecedor_id) REFERENCES tb_fornecedor(id)
);

CREATE TABLE tb_venda (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
valor_total DECIMAL(19,2) NOT NULL,
cliente_id BIGINT,
lucro_por_venda DECIMAL(19,2) NOT NULL,
FOREIGN KEY(cliente_id) REFERENCES tb_cliente(id)
);

CREATE TABLE tb_veiculos_pecas (
veiculo_id BIGINT NOT NULL,
peca_id BIGINT NOT NULL,
CONSTRAINT pk_veiculos_pecas PRIMARY KEY (veiculo_id, peca_id),
CONSTRAINT fk_veiculo FOREIGN KEY (veiculo_id) REFERENCES tb_produto_veiculo(id),
CONSTRAINT fk_pecas FOREIGN KEY (peca_id) REFERENCES tb_produto_peca(id)
);

CREATE TABLE tb_item_compra (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
produto_id BIGINT NOT NULL,
quantidade INT NOT NULL,
valor_compra DECIMAL(19,2) NOT NULL,
quantidade_de_itens_disponiveis_para_venda INT NOT NULL,
compra_id BIGINT,
FOREIGN KEY(produto_id) REFERENCES tb_produto(produto_id),
FOREIGN KEY(compra_id) REFERENCES tb_compra(id)
);

CREATE TABLE tb_item_venda (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
produto_id BIGINT NOT NULL,
quantidade INT NOT NULL,
valor_venda DECIMAL(19,2) NOT NULL,
lucro_por_item DECIMAL(19,2) NOT NULL,
venda_id BIGINT,
FOREIGN KEY(produto_id) REFERENCES tb_produto(produto_id),
FOREIGN KEY(venda_id) REFERENCES tb_venda(id)
);

CREATE TABLE tb_nota (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
cliente_id BIGINT,
fornecedor_id BIGINT,
valor_total DECIMAL(19,2) NOT NULL,
FOREIGN KEY(cliente_id) REFERENCES tb_cliente(id),
FOREIGN KEY(fornecedor_id) REFERENCES tb_fornecedor(id)
);

CREATE TABLE tb_nota_item (
nota_id BIGINT NOT NULL,
item_id BIGINT NOT NULL,
CONSTRAINT pk_nota_itens PRIMARY KEY (nota_id, item_id),
CONSTRAINT fk_nota FOREIGN KEY (nota_id) REFERENCES tb_nota(id),
CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES tb_item_venda(id)
);
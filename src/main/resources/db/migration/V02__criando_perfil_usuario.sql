CREATE TABLE tb_perfil(
id BIGINT PRIMARY KEY,
nome VARCHAR(255) NOT NULL
);

INSERT INTO tb_perfil(id, nome) VALUES (1, 'ADMIN');
INSERT INTO tb_perfil(id, nome) VALUES (2, 'VENDEDOR');

CREATE TABLE tb_usuario(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
perfil_id BIGINT,
FOREIGN KEY (perfil_id) REFERENCES tb_perfil(id)
);

INSERT INTO tb_usuario(id, email, senha, perfil_id)
VALUES (1, 'admin@gft.com', '$2a$10$Ye1mEWJsM4z2yTdxCpZ5fuflCqjiFqQWL6W67rMZAMDzjKrfl7hsW', 1);
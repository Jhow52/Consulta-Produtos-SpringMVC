CREATE DATABASE loja;
USE loja;

CREATE TABLE IF NOT EXISTS produto (
    id        BIGINT        NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(150)  NOT NULL,
    descricao TEXT          NOT NULL,
    preco     DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO produto (nome, descricao, preco) VALUES
('Smartphone Galaxy S24',    'Tela AMOLED 6.2 polegadas, 256GB, camera 50MP.',      3499.90),
('Notebook Dell Inspiron',   'Intel Core i7, 16GB RAM, SSD 512GB, tela 15.6.',      4299.00),
('Fone Bluetooth JBL Tune',  'Sem fio, cancelamento de ruido, bateria 40 horas.',    349.90),
('Smart TV LG 55 4K',        'Tela NanoCell 4K, webOS, HDR10, 3 entradas HDMI.',   2799.00),
('Teclado Mecanico Redragon','Switches red, iluminacao RGB, layout ABNT2.',          259.90);
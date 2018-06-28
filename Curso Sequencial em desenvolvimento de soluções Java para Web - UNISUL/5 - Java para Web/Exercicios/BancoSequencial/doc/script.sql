

CREATE TABLE usuario (
	codigo NUMERIC(5),
	nome VARCHAR(100),
	login VARCHAR(40),
	senha VARCHAR(40),
	email VARCHAR(100),
	tipo NUMERIC(10)
);

CREATE TABLE produto (
	codigo NUMERIC(5),
	descricao VARCHAR(100),
	genero VARCHAR(50),
	valor NUMERIC(9,2)
);

CREATE TABLE noticia (
	codigo NUMERIC(5),
	nome VARCHAR(50),
	descricao VARCHAR(500)
);

ALTER TABLE usuario
	ADD CONSTRAINT cli_pk
	PRIMARY KEY (codigo);
	
ALTER TABLE produto
	ADD CONSTRAINT pro_pk
	PRIMARY KEY (codigo);

ALTER TABLE noticia
	ADD CONSTRAINT not_pk
	PRIMARY KEY (codigo);
	
	
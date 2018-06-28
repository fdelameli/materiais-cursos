
CREATE TABLE transportadora (
	cd_transp NUMERIC(5) NOT NULL,
	nm_transp VARCHAR(50) NOT NULL
);

CREATE TABLE caminhao (
	cd_cam NUMERIC(5) NOT NULL,
	ds_cam VARCHAR(50) NOT NULL
);

CREATE TABLE frete (
	cd_fre NUMERIC(5) NOT NULL,
	km_fre NUMERIC(9,2) NOT NULL,
	vl_fre NUMERIC(9,2) NOT NULL,
	cd_transp NUMERIC(5) NOT NULL,
	cd_cam NUMERIC(5) NOT NULL,
	cd_user NUMERIC(5) NOT NULL
);

CREATE TABLE usuario (
	cd_user NUMERIC(5) NOT NULL,
	nm_user VARCHAR(50) NOT NULL,
	email_user VARCHAR(100) NOT NULL,
	senha_user VARCHAR(50) NOT NULL,
	endereco_user VARCHAR(100),
	cidade_user VARCHAR(50),
	uf_user VARCHAR(50),
	tipo_user NUMERIC(2) NOT NULL
);

CREATE TABLE duvida (
	codigo NUMERIC(5) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	empresa VARCHAR(100),
	ddd VARCHAR(5),
	fone VARCHAR(20),
	assunto VARCHAR(50) NOT NULL,
	menssagem VARCHAR(1000) NOT NULL
);


ALTER TABLE usuario
	ADD CONSTRAINT user_pk
	PRIMARY KEY (cd_user);

ALTER TABLE transportadora
	ADD CONSTRAINT transp_pk
	PRIMARY KEY (cd_transp);
	
ALTER TABLE caminhao
	ADD CONSTRAINT cam_pk
	PRIMARY KEY (cd_cam);
	
ALTER TABLE duvida
	ADD CONSTRAINT duv_pk
	PRIMARY KEY (codigo);
	
ALTER TABLE frete
	ADD CONSTRAINT fre_pk
	PRIMARY KEY (cd_fre);
	
ALTER TABLE frete
	ADD CONSTRAINT fre_transp_fk
	FOREIGN KEY (cd_transp)
	REFERENCES transportadora (cd_transp);

ALTER TABLE frete
	ADD CONSTRAINT fre_cam_fk
	FOREIGN KEY (cd_cam)
	REFERENCES caminhao (cd_cam);
	
ALTER TABLE frete
	ADD CONSTRAINT fre_user_fk
	FOREIGN KEY (cd_user)
	REFERENCES usuario (cd_user);
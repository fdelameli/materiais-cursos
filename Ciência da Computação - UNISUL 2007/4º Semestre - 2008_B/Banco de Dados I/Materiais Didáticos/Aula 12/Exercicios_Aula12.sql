
-- CRIAÇÃO DAS TABELAS --

CREATE TABLE cidade (
	cd_cid NUMBER(5) NOT NULL,
	nm_cid VARCHAR2(30) NOT NULL,
	cd_uf VARCHAR2(2) NOT NULL
);


CREATE TABLE cliente (
	cd_cli NUMBER(5) NOT NULL,
	nm_cli VARCHAR2(30) NOT NULL,
	dt_nas DATE NOT NULL,
	nm_logr VARCHAR2(50) NOT NULL,
	nr_logr NUMBER(5),
	nm_bair VARCHAR2(30) NOT NULL,
	nr_cep VARCHAR2(10) NOT NULL,
	cd_cid NUMBER(5) NOT NULL
);


CREATE TABLE classe (
	cd_cla NUMBER(5) NOT NULL,
	nm_cla VARCHAR2(30) NOT NULL
);


CREATE TABLE produto (
	cd_pro NUMBER(5) NOT NULL,
	nm_pro VARCHAR2(30) NOT NULL,
	tp_un_med VARCHAR2(5) NOT NULL,
	nm_fabr VARCHAR2(30),
	dt_valid DATE,
	qt_est NUMBER(5) NOT NULL,
	cd_cla NUMBER(5) NOT NULL
);


CREATE TABLE venda (
	cd_ven NUMBER(5) NOT NULL,
	dt_ven DATE NOT NULL,
	vl_ven NUMBER(9,2) NOT NULL,
	cd_cli NUMBER(5) NOT NULL
);


CREATE TABLE item_venda (
	cd_ven NUMBER(5) NOT NULL,
	cd_pro NUMBER(5) NOT NULL,
	qt_itv NUMBER(5) NOT NULL
);


CREATE TABLE parcela (
	cd_par NUMBER(5) NOT NULL,
	cd_ven NUMBER(5) NOT NULL,
	dt_vcto DATE NOT NULL,
	vl_par NUMBER(9,2) NOT NULL,
	dt_pgto DATE,
	vl_pgto NUMBER(9,2)
);



-- ADIÇÃO DAS PRIMARY KEYS NAS TABELAS --

ALTER TABLE cidade
	ADD CONSTRAINT cid_pk PRIMARY KEY(cd_cid);
	
	
ALTER TABLE cliente
	ADD CONSTRAINT cli_pk PRIMARY KEY(cd_cli);
	
	
ALTER TABLE classe
	ADD CONSTRAINT cla_pk PRIMARY KEY(cd_cla);
	
	
ALTER TABLE produto
	ADD CONSTRAINT pro_pk PRIMARY KEY(cd_pro);

	
ALTER TABLE venda
	ADD CONSTRAINT ven_pk PRIMARY KEY(cd_ven);
	
	
ALTER TABLE item_venda
	ADD CONSTRAINT itv_pk PRIMARY KEY(cd_ven, cd_pro);
	
	
ALTER TABLE parcela
	ADD CONSTRAINT par_pk PRIMARY KEY(cd_par, cd_ven);

	
	
-- ADIÇÃO DAS FOREIGN KEYS NAS TABELAS --
	
ALTER TABLE cliente
	ADD CONSTRAINT cli_cid_fk FOREIGN KEY(cd_cid) REFERENCES cidade (cd_cid);
	

ALTER TABLE produto
	ADD CONSTRAINT pro_cla_fk FOREIGN KEY(cd_cla) REFERENCES classe (cd_cla);
	  
	 
ALTER TABLE venda
	ADD CONSTRAINT ven_cli_fk FOREIGN KEY(cd_cli) REFERENCES cliente (cd_cli);
	
	
ALTER TABLE item_venda
	ADD CONSTRAINT itv_pro_fk FOREIGN KEY(cd_pro) REFERENCES produto (cd_pro);
	

ALTER TABLE item_venda
	ADD CONSTRAINT itv_ven_fk FOREIGN KEY(cd_ven) REFERENCES venda (cd_ven);
	
	
ALTER TABLE parcela
	ADD CONSTRAINT par_ven_fk FOREIGN KEY(cd_ven) REFERENCES venda (cd_ven);
	
	
	
-- ADIÇÃO DAS CHECK CONSTRAINTS NAS TABELAS --
	
ALTER TABLE produto
	ADD CONSTRAINT pro_tp_un_med CHECK(tp_un_med IN ('KG', 'ML', 'PCT', 'UN'));
	
	
	
-- CRIAÇÃO DOS ÍNDICES NAS TABELAS --
	
CREATE INDEX cli_cid_fk_i ON cliente (cd_cid);

CREATE INDEX pro_cla_fk_i ON produto (cd_cla);

CREATE INDEX ven_cli_fk_i ON venda (cd_cli);

CREATE INDEX itv_pro_fk_i ON item_venda (cd_pro);

CREATE INDEX itv_ven_fk_i ON item_venda (cd_ven);

CREATE INDEX par_ven_fk_i ON parcela (cd_ven);
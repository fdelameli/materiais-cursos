CREATE TABLE usuario
(
  codigo serial NOT NULL,
  nome character varying(100) NOT NULL,
  "login" character varying(100) NOT NULL,
  senha character varying(100) NOT NULL,
  email character varying(100) NOT NULL,
  tipo numeric(10) NOT NULL,
  CONSTRAINT "usuarioPk" PRIMARY KEY (codigo)
)
WITH (OIDS=FALSE);
ALTER TABLE usuario OWNER TO postgres;

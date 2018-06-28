CREATE TABLE Veiculo
(
	cdVeiculo DECIMAL(9) NOT NULL,
	cdMontadora DECIMAL(9) NOT NULL,
	cdCategoria DECIMAL(9) NOT NULL,
	dsVeiculo VARCHAR(200),
	anoFabricacao DECIMAL(4) NOT NULL,
	anoModelo DECIMAL(4) NOT NULL,
	valorVeiculo DECIMAL(9,2) NOT NULL,
	corVeiculo VARCHAR(30),
	PRIMARY KEY (cdVeiculo),
	KEY (cdCategoria),
	KEY (cdMontadora)
) 
;


CREATE TABLE Montadora
(
	cdMontadora DECIMAL(9) NOT NULL,
	dsMontadora VARCHAR(200),
	PRIMARY KEY (cdMontadora)
) 
;


CREATE TABLE Categoria
(
	cdCategoria DECIMAL(9) NOT NULL,
	dsCategoria VARCHAR(200),
	PRIMARY KEY (cdCategoria)
) 
;






ALTER TABLE Veiculo ADD CONSTRAINT FK_Veiculo_Categoria 
	FOREIGN KEY (cdCategoria) REFERENCES Categoria (cdCategoria)
;

ALTER TABLE Veiculo ADD CONSTRAINT FK_Veiculo_Montadora 
	FOREIGN KEY (cdMontadora) REFERENCES Montadora (cdMontadora)
;

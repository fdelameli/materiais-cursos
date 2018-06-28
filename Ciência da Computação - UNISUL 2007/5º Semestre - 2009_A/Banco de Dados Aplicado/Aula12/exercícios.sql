-- 1) Construa um bloco PL/SQL para listar o nome dos clientes e o nome da cidade onde mora.

DECLARE
  
  CURSOR C_CLI IS
    SELECT NM_CLI, NM_CID FROM CLIENTE;

BEGIN

  FOR WR_CLI IN C_CLI LOOP
  
    DBMS_OUTPUT.PUT_LINE(WR_CLI.NM_CLI||'  -  '||WR_CLI.NM_CID);
  
  END LOOP;

END;



-- 2) Altere o exercício 1 para que a listagem seja ordenada decrescentemente 
--    pelo nome da cidade e também para imprimir ao final o número de clientes listados.

DECLARE
  
  CURSOR C_CLI IS
    SELECT NM_CLI, NM_CID
	FROM CLIENTE
	ORDER BY NM_CID DESC;
	
  NR_CLI NUMBER(3);

BEGIN

  FOR WR_CLI IN C_CLI LOOP
  
    DBMS_OUTPUT.PUT_LINE(WR_CLI.NM_CLI||'  -  '||WR_CLI.NM_CID);
  
  END LOOP;
  
  SELECT COUNT(*) INTO NR_CLI FROM CLIENTE;
  DBMS_OUTPUT.PUT_LINE('Qtd. clientes: '||NR_CLI);

END;


-- 3) Construa um bloco PL/SQL para listar o nome de todos os vendedores e o valor do seu salário.


DECLARE

  CURSOR C_VDD IS
    SELECT NM_VDD, VL_SAL
	FROM VENDEDOR;

BEGIN

  FOR WR_VDD IN C_VDD LOOP
  
    DBMS_OUTPUT.PUT_LINE('Vendedor: '||WR_VDD.NM_VDD||'  -  '||'Salário: '||WR_VDD.VL_SAL);
  
  END LOOP;

END;


-- 4) Altere o exercício e para listar também o número de vendas que o vendedor obteve no
--    ano de 2005 caso o seu salário seja maior que R$500,00.

DECLARE

  CURSOR C_VDD IS
    SELECT CD_VDD, NM_VDD, VL_SAL
	FROM VENDEDOR;
	
  NR_VEN NUMBER(3);

BEGIN

  FOR WR_VDD IN C_VDD LOOP
  
    SELECT COUNT(*) INTO NR_VEN FROM VENDA
	 WHERE CD_VDD = WR_VDD.CD_VDD
	 AND DT_VEN BETWEEN '01/01/2005' AND '31/12/2005';
	
	IF WR_VDD.VL_SAL > 500 THEN
  	  DBMS_OUTPUT.PUT_LINE(WR_VDD.NM_VDD||'  -  Sal.: '||WR_VDD.VL_SAL||'  -  Qtd. vendas: '||NR_VEN);
	ELSE
	  DBMS_OUTPUT.PUT_LINE(WR_VDD.NM_VDD||'  -  Sal.: '||WR_VDD.VL_SAL);
	END IF;
  
  END LOOP;

END;


-- 5) Construa um bloco PL/SQL para listar o nome da loja, o código da venda, a data da venda, 
--    o número de parcelas vencidas e não pagas. Se o número de parcelas vencidas e não pagas 
--    superar em 50% do número total de parcelas, listar também a mensagem 'Atenção, venda problemática!!!'

DECLARE

  CURSOR C_VEN IS
    SELECT CD_LOJ, CD_VEN, DT_VEN
	FROM VENDA;
	
  NR_PAR NUMBER(3);
  NR_PAR_TOT NUMBER(3);

BEGIN

  FOR WR_VEN IN C_VEN LOOP
  
    SELECT COUNT(*) INTO NR_PAR FROM PARCELA
	 WHERE CD_VEN = WR_VEN.CD_VEN
	  AND CD_LOJ = WR_VEN.CD_LOJ
	  AND DT_VCTO < SYSDATE
	  AND VL_PAGO IS NULL
	;
	
	SELECT COUNT(*) INTO NR_PAR_TOT FROM PARCELA
	 WHERE CD_VEN = WR_VEN.CD_VEN
	  AND CD_LOJ = WR_VEN.CD_LOJ
	;
	
	IF NR_PAR > (NR_PAR_TOT * 0.5) THEN
	  DBMS_OUTPUT.PUT_LINE('Loja: '||WR_VEN.CD_LOJ||'  -  Venda: '||WR_VEN.CD_VEN
			||'  -  Dt_ven.: '||WR_VEN.DT_VEN||'  -  Parcelas venc.: '||NR_PAR
			||'  -->  VENDA PROBLEMÁTICA');
	ELSE
	  DBMS_OUTPUT.PUT_LINE('Loja: '||WR_VEN.CD_LOJ||'  -  Venda: '||WR_VEN.CD_VEN
			||'  -  Dt_ven.: '||WR_VEN.DT_VEN||'  -  Parcelas venc.: '||NR_PAR);
	END IF;
  
  END LOOP;

END;
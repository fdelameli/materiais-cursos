	// Variaveis de configuracao
	var DEaff="parimaster";	// Affiliate
	var DEchan="";		// Canal quando existe
	var DEsubc="outros";	// Subcanal capa ou outros.
	var Expble=1;		// Alterar para 0 se não houver 240 pixels de espaço abaixo do 468x60 até o final da pagina
	var DEcmpng=1;		// Alterar para 1 se participa de qualquer campanha vendida pelo UOL "cmpng"
	var DEGroup=6;		// Grupo de afinidade "group"
	// Fim da configuracao 
	
	
	/* NAO ALTERAR DAQUI PARA BAIXO, apenas remova os comentarios se precisar.
	A linha abaixo deve obrigatoriamente ficar fora da função o valor de 
	"DErand" nao pode ser diferente para os banners de uma mesma pagina */
	d=document; var DEt=new Date(); DEt=DEt.getTime(); DErand=Math.floor(DEt*1000*Math.random());
	
	// Verifica tipo de conexao do usuario
	var DEconn=d.body; DEconn.style.behavior='url(#default#clientCaps)'; DEconn=(DEconn.connectionType=='lan')?1:0;
	
	// Verifica resolucao de tela
	var scw=0,sch=0; if(screen.height){scw=screen.width;sch=screen.height;}
	
	// Funcao que exibe o banner
	function DEshow(ad,pos){
	d.write('<scr'+'ipt language="JavaScript1.1" src="http://bn.uol.com.br/js.ng/site=par&chan='+DEchan+'&subchan='+DEsubc+'&affiliate='+DEaff+'&size='+ad+'&page='+pos+'&conntype='+DEconn+'&expble='+Expble+'&reso='+scw+'x'+sch+'&cmpng='+DEcmpng+'&group='+DEGroup+'&tile='+DErand+'?"></scr'+'ipt>');
	}

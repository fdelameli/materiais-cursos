if (typeof barraUol == "undefined") {
barraUol={

f : '',
c : 'http://click.uol.com.br/?rf=barrageral&u=',
i : '<img src="http://img.uol.com.br/b/imgs1024v3.gif" width="1" height="1" border="0" />',
init : function(){
  this.css();
  this.getParseJSURL(document.getElementsByTagName('script')[document.getElementsByTagName('script').length - 1].src,"_JS");
  this.UolBarRefBusca = typeof(_REQUEST_JS['ref'])=='undefined' ? _REQUEST_JS['ref']='parceiro' : typeof(_REQUEST_JS['refbusca'])=='undefined' ? _REQUEST_JS['ref'] : _REQUEST_JS['refbusca'];
  this.UolBarAuto = typeof(_REQUEST_JS['auto'])!='undefined' ? _REQUEST_JS['auto'] : false;
  this.barraLight = (typeof(_REQUEST_JS['light'])=='undefined' || _REQUEST_JS['light']!='1') ? '0' : '1';
},

getParseJSURL : function(src,v){
  eval("_REQUEST"+v+"=[];\n"+(unescape(src).indexOf("?")>=0?unescape(src).replace(/.*?\?/,"?").replace(/((\&|\?)\&?[^\=]*?(\&|$))/g,"").replace(/(\&|\?)*(([^\&]*?)\=(.*?))(\&|$)/g,"_REQUEST"+v+"['$3']=\"$4\";\n"):""));
},

combo : function(){
var uolEst = new Array('fotos.uol.com.br/','&Aacute;lbum de Fotos',
'seguranca.uol.com.br/','Antiv&iacute;rus e Firewall',
'ferramentas.uol.com.br/','Aplicativos',
'assistenciatecnica.uol.com.br/','Assist&ecirc;ncia T&eacute;cnica',
'diversao.uol.com.br/bandalarga/','Banda Larga',
'batepapo.uol.com.br/','Bate-papo UOL',
'estilo.uol.com.br/beleza/','Beleza',
'biblioteca.uol.com.br/','Biblioteca',
'bichos.uol.com.br/','Bichos',
'blog.uol.com.br/','Blogosfera',
'busca.uol.com.br/','Busca',
'carros.uol.com.br/','Carros',
	'carros.uol.com.br/fipe/','&nbsp;&nbsp;- Tabela Fipe',
	'compare.carros.uol.com.br/','&nbsp;&nbsp;- Comparar Carros',
'cartoes.uol.com.br/','Cart&otilde;es',
'casaeimoveis.uol.com.br/','Casa e Im&oacute;veis',
'celebridades.uol.com.br/','Celebridades',
'celular.uol.com.br/','Celular',
'cienciaesaude.uol.com.br/','Ci&ecirc;ncia e Sa&uacute;de',
'cinema.uol.com.br/','Cinema e Filmes',
'clube.uol.com.br/','Clube UOL',
'shopping.uol.com.br/?&rtrk=src:13;size:18;chn:0;creative:link_fixo;thm:shopping_menu;','Comparar Pre&ccedil;os',
'copadomundo.uol.com.br/','Copa do Mundo',
'criancas.uol.com.br/','Crian&ccedil;as',
'downloads.uol.com.br/','Downloads',
'economia.uol.com.br/','Economia',
	'economia.uol.com.br/cotacoes/','&nbsp;&nbsp;- Cota&ccedil;&otilde;es',
	'uolinvest.economia.uol.com.br/','&nbsp;&nbsp;- UOL Invest',
'educacao.uol.com.br/','Educa&ccedil;&atilde;o',
	'educacao.uol.com.br/dicionarios/','&nbsp;&nbsp;- Dicion&aacute;rios',
	'vestibular.uol.com.br/','&nbsp;&nbsp;- Vestibular',
'eleicoes.uol.com.br/','Elei&ccedil;&otilde;es 2010',
'email.uol.com.br/','E-Mail',
'noticias.uol.com.br/empregos/','Empregos',
	'empregocerto.uol.com.br/','&nbsp;&nbsp;- Enviar curr&iacute;culo',
'entretenimento.uol.com.br/','Entretenimento',
	'guia.uol.com.br/','&nbsp;&nbsp;- Guia Cultural SP',
'esporte.uol.com.br/','Esporte',
	'bolao.esporte.uol.com.br/','&nbsp;&nbsp;- Bol&atilde;o',
	'esporte.uol.com.br/futebol/campeonatos/brasileiro/2010/serie-a/','&nbsp;&nbsp;- Brasileir&atilde;o',
	'esporte.uol.com.br/f1/','&nbsp;&nbsp;- F&oacute;rmula 1',
	'esporte.uol.com.br/futebol/','&nbsp;&nbsp;- Futebol',
	'esporte.uol.com.br/futebol/campeonatos/libertadores/2010/','&nbsp;&nbsp;- Libertadores',
'estilo.uol.com.br/','Estilo',
	'estilo.uol.com.br/moda/','&nbsp;&nbsp;- Moda',
'www.folha.uol.com.br/','Folha.com', 
'fotoblog.uol.com.br/','Fotoblog',
'gay.uol.com.br/','Gay',
	'clicklogger.rm.uol.com.br/?prd=29&grp=src:28;chn:0;creative:menu-home-gay&msr=Cliques%20de%20Origem:1&oper=11&redir=http://mig.uol.com.br/?skin=mig','&nbsp;&nbsp;- Namoro gay',
'horoscopo.uol.com.br/','Hor&oacute;scopo',
'humor.uol.com.br/','Humor',
'indice.uol.com.br/','&Iacute;ndice',
'jogos.uol.com.br','Jogos',
	'jogos.uol.com.br/jogosonline/','&nbsp;&nbsp;- Jogos Online',
	'jogos.uol.com.br/loja/','&nbsp;&nbsp;- Loja de jogos',
'noticias.uol.com.br/jornais/','Jornais',
	'noticias.uol.com.br/internacional/','&nbsp;&nbsp;- Internacionais',
'jovem.uol.com.br','Jovem',
'mapas.uol.com.br/','Mapas',
'musica.uol.com.br/','M&uacute;sica',
	'musica.uol.com.br/artistas/','&nbsp;&nbsp;- Artistas',
'namoro.uol.com.br/','Namoro',
'noticias.uol.com.br/','Not&iacute;cias',
	'noticias.uol.com.br/cotidiano/','&nbsp;&nbsp;- Cotidiano',
	'noticias.uol.com.br/internacional/','&nbsp;&nbsp;- Internacional',
	'noticias.uol.com.br/jornais/','&nbsp;&nbsp;- Jornais',
	'noticias.uol.com.br/politica/','&nbsp;&nbsp;- Pol&iacute;tica',
	'noticias.uol.com.br/ultnot/noticias.jhtm','&nbsp;&nbsp;- &Uacute;ltimas Not&iacute;cias',
'www.radio.uol.com.br/','R&aacute;dio UOL',
'receitas.uol.com.br/','Receitas',
'noticias.uol.com.br/revistas/','Revistas',
'sac.uol.com.br/','SAC',
'servicos.uol.com.br/','Servi&ccedil;os',
'sexo.uol.com.br/','Sexo',
'sites.uol.com.br/','Sites Pessoais',
'tecnologia.uol.com.br/','Tecnologia',
'televisao.uol.com.br/','Televis&atilde;o',
	'televisao.uol.com.br/novelas.jhtm','&nbsp;&nbsp;- Novelas',
	'televisao.uol.com.br/programacao/','&nbsp;&nbsp;- Programa&ccedil;&atilde;o',
'www3.uol.com.br/tempo/','Tempo e Tr&acirc;nsito',
'tvuol.uol.com.br/','TV UOL',
'uolk.uol.com.br/','UOL K',
'mais.uol.com.br/','UOL Mais',
'viagem.uol.com.br/','Viagem',
'tvuol.uol.com.br/','V&iacute;deos',
'voip.uol.com.br/','Voip',
'wifi.uol.com.br/','Wi-Fi');

var printer='<option value="0">&Iacute;NDICE PRINCIPAL</option>';
for(var i=0;i<uolEst.length;i+=2) {
if (uolEst[i] == "shopping.uol.com.br/") uolEst[i] += '?&rtrk=src:13;sze:18;chn:103;creative:link_fixo;thm:barra_navegacao' + this.f;
if (this.barraLight==1 && uolEst[i+1].match(/sexo|namoro|gay|hor&oacute;scopo|horóscopo/i)) {i+=2;continue;}
printer+='<option value="'+uolEst[i]+'">'+uolEst[(i+1)]+'</option>';
}
return printer;
},

openEs : function(t){
  if(t[t.selectedIndex].value!=0)
    top.location = 'http://click.uol.com.br/?rf=barrageral-drop&u=http://'+t[t.selectedIndex].value;
},

css : function(){
document.write('<style>'+
'.buol {position:relative;font-size:10px;width:98.8em;}'+
'.buol.auto {width:auto;margin:0 auto;}'+
'.buol .buolbg {height:2.4em;overflow:hidden;}'+
'.buol .buolbg img{width:100%;height:15.9em;}'+
'.buol .ico {overflow:hidden;position:absolute;top:0;left:0.3em;z-index:2;width:2em}'+
'.buoli li a.ico, .buoli li a.ico:visited {margin:0;padding:0;position:absolute;}'+
'.buol .ico img{width:5.1em;height:15.9em;border:0;}'+
'.buoli {height:2.4em;width:98.8em;overflow:hidden;margin:0 auto;font:normal 1em arial,sans-serif;color:#fff;position:relative;position:absolute;top:0;left:0;z-index:1;}'+
'.buol.auto .buoli{left:50%;margin-left:-49.4em}'+
'.buoli form{display:inline}'+
'.buoli .busca form .it,'+
'.buoli .busca form .tb,'+
'.buoli .indice select {font:normal 1em arial,sans-serif}'+
'.buoli ul {margin:0;padding:0;list-style:none;width:98.8em;}'+
'.buoli ul li {margin:0;padding:0;float:left;padding:0;border-right:0.1em solid #02264b;border-left:0.1em solid #486d92;position:relative;height:2.4em;}'+
'.buoli .assine {padding:0 1.1em}'+
'.buoli a, .buoli a:visited{font-size:1em !important; color:#fff !important;text-decoration:none !important;display:block;padding:0.5em 0.4em 0.6em 0.4em;height:2.4em;float:left;}'+
'.buoli a:hover{text-decoration:underline !important;}'+
'.buoli .p {border-left:none;}'+
'.buoli .u {border-right :none;}'+
'.buoli .logo {position:relative;width:6.1em;}'+
'.buoli .logo a {padding:2.5em 0 0 0;width:6.1em;position:absolute;top:0;left:0;z-index:3;'+(navigator.userAgent.indexOf("MSIE")>=0?'background-color:#fff;filter:alpha(opacity=0)':'')+(navigator.userAgent.indexOf("Opera")>=0?'background-color:#fff;opacity: 0;':'')+'}'+
'.buol .buoli .logo .ico {width:5.5em}'+
'.buoli .logo .ico {left:0.4em;}'+
'.buoli .logo .ico img {margin-top:-2.4em;}'+
'.buoli .busca {padding:0.3em 0.5em 0.4em 0.5em;}'+
'.buol .buoli .busca .ico {left:16em;top:.4em;padding:0;width:1.6em;cursor:default;}'+
'.buoli .busca .ico img{margin-top:-14.4em}'+
'.buoli .busca form .it {border:0.1em solid #50728e;float:left;margin:0.1em 0.4em 0 0;_margin-right:0.1em;width:14.8em;*width:14.7em;overflow:hidden;padding:0;}'+
'.buoli .busca form .tb {color:#fff;height:1.7em;border-top:0.1em solid #b3cbe1;border-right:0.1em solid #000;border-bottom:0.1em solid #000;border-left:0.1em solid #b3cbe1;background-color:#50728e;margin:0;padding-left:1.5em;*padding-left:.8em;width:7.1em;*width:7.2em;}'+
'.buoli .messenger .t, .buoli .messenger .t:visited {padding-left:2.3em;position:relative;}'+
'.buoli .messenger .ico img{margin-top:-4.8em}'+
'.buoli .voip .t, .buoli .voip .t:visited {padding-left:2.2em;}'+
'.buoli .voip .ico img{margin-top:-7.2em}'+
'.buoli .email .t, .buoli .email .t:visited {padding-left:2.1em;}'+
'.buoli .email .ico img{margin-top:-9.6em}'+
'.buoli .shop .t, .buoli .shop .t:visited {padding-left:3.2em;}'+
'.buoli .shop .ico {width:2.7em;}'+
'.buoli .shop .ico img{margin-top:-12em}'+
'.buoli .indice {height:2.4em;}'+
'.buoli .indice select {background-color:#50728e;color:#fff;border:0.1em solid #7f9db9;margin:0.3em 0 0 0.5em;height:1.7em;width:13.8em;overflow:hidden;}'+
' #copyright { width:98.8em;color:black;text-align:center;margin:0.5em; }'+
'</style>');
},

ico : function(l){
  if(typeof(l)!="undefined")
    return '<a href="'+l+'" class="ico">'+this.i+'</a>';
  else
    return '<div class="ico">'+this.i+'</div>';
},

li : function(n,c,l,i){
  return '<li'+(c?' class="'+c+'"':'')+'>'+(i?this.ico(l):'')+'<a href="'+this.c+l+'" class="t" target="_top">'+n+'</a></li>';
},

write : function(){

var f = this.f;
var c = this.c;
var l = '';
var h = '';
var a = arguments[0]['auto'];

h=''+
  '<div id="barrauol'+f+'" class="buol'+(a?" auto":"")+'">'+
  '<div class="buolbg">'+this.i+'></div>'+
  '<div class="buoli">'+
  '<ul>'+
  '<li class="p logo">'+this.ico()+'<a href="'+c+'http://www.uol.com.br/" target="_top" title="UOL">UOL</a></li>'+
  this.li('ASSINE 0800 703 3000','assine','http://clicklogger.rm.uol.com.br/?prd=1&grp=src:10;creative:barrauol&msr=Cliques%20de%20Origem:1&oper=11&redir=http://assine.uol.com.br/index.htm?eos=yes&promo=117570810&sg=300016192&sa=UOL-barra-assine&promochild=PROMOCOMBIAVSS',false)+
  this.li('BATE-PAPO',false,'http://batepapo.uol.com.br/',false)+
  this.li('E-MAIL',false,'http://email.uol.com.br/',false)+
  this.li('SAC',false,'https://sac.uol.com.br/',false)+
  '<li class="busca">'+(navigator.userAgent.indexOf("Safari")>=0?'':this.ico('javascript:document.formbbuol'+f+'.submit();'))+'<form action="http://busca.uol.com.br/www/index.html" method="get" target="_blank" name="formbbuol'+f+'" onSubmit="buscaClick()"><input type="hidden" name="ad" value="on"><input type="hidden" name="ref" value="'+this.UolBarRefBusca+'"><input type="hidden" value="barrauol" name="origem"/><input type="text" name="q" class="it"><input type="submit" class="tb" value="BUSCAR"></form></li>'+
  this.li('VOIP','voip','http://clicklogger.rm.uol.com.br/?prd=5&grp=src:13;chn:103;creative:link_voip;pos:barra&msr=Cliques%20de%20Origem:1&oper=7&redir=http://voip.uol.com.br/',true)+
  this.li('E-MAIL GR&Aacute;TIS','email','http://www.bol.uol.com.br/',true)+
  this.li('SHOPPING','shop','http://shopping.uol.com.br/?&rtrk=src:13;sze:18;chn:103;creative:link_fixo;thm:barra_navegacao'+f,true)+
  '<li class="u indice"><form name="fm_uol'+f+'" target="_top"><select onchange="barraUol.openEs(this)">'+this.combo()+'</select></form></li>'+
  '</ul>'+
  '</div>'+
  '</div><div style="clear: left;"></div>';

  document.write(h);
  
  this.f==''?this.f=1:this.f++;

}

};
}

writeUolBar = writeUOLBar = function (){
  barraUol.write({'auto': _REQUEST_JS['auto'] });
}

buscaClick = function(){
	var busclick = document.createElement('img');
	document.getElementsByTagName('body')[0].appendChild(busclick);
	busclick.src = 'http://click.uol.com.br/?rf=buscaBarraUOLp&u=http://home.img.uol.com.br/h3/x.gif';
}

barraUol.init();
writeUolBar();

//EOF

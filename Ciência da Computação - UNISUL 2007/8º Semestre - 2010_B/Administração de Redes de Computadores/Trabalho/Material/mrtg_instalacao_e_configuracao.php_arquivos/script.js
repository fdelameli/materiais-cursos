try{
var Pal1481455152hw = {};function loadCssHOTWords(filename){
var fileref=document.createElement("link");
fileref.setAttribute("rel", "stylesheet");
fileref.setAttribute("type", "text/css");
fileref.setAttribute("href", filename);
var head = document.getElementsByTagName('head')[0];
if (head != null) {
if (head.firstChild != null) {
head.insertBefore(fileref, head.lastChild);
} else {
head.appendChild(fileref);
}
}
}
function css_start(){
loadCssHOTWords('http://img.hotwords.com.br/img/hw_csspadrao_0_v15.css');
var imgBalaoBG = new Image;
imgBalaoBG.src = "http://img.hotwords.com.br/img/balao_0_gif.gif";
}
var hotwordsEliminaDesaparecerXY = true; 
var qtdAnuncios=0;
var maxQtdAnuncios= 4;
var tek=true;
function hideBL(divids){ 
var divids2 = 'HOTWordsTitle';
if (divids2 != undefined){ 
var ziob = document.getElementById(divids2);
if (ziob != undefined){ 
ziob.style.visibility='hidden'; 
var ziob2 = document.getElementById(divids2 + 'Text'); 
if (ziob2 != undefined){
ziob2.innerHTML = ''; 
}
}
}
}
Pal1481455152hw.hideTitle=function(s){
if(!hotwordsEliminaDesaparecerXY){return; }
if (this.tek){ return; }
window.status = '';
hideBL(s);
hotwordsEliminaDesaparecerXY = true;
}
Pal1481455152hw.showSure=function(){this.tek=true;}
Pal1481455152hw.hideMaybe=function(s, p){
this.tek=false;
setTimeout("Pal1481455152hw.hideTitle('" + s + "')",500);
}
function detectarFlashInstall() {
var flashinstalled = 0;
var flashversion = 0;
if(navigator.plugins && navigator.plugins.length){
x = navigator.plugins["Shockwave Flash"];
if (x){
flashinstalled = 2;
if (x.description){
y = x.description;
flashversion = y.charAt(y.indexOf('.')-1);
}
}
else{
if (navigator.plugins["Shockwave Flash 2.0"]){
flashinstalled = 2;
}
}
}
else if (navigator.mimeTypes && navigator.mimeTypes.length){
x = navigator.mimeTypes['application/x-shockwave-flash'];
if (x && x.enabledPlugin){
flashinstalled = 2;
}
else{
flashinstalled = 1;
}
}
else {
if((navigator.appName == "Microsoft Internet Explorer") && 
(navigator.appVersion.indexOf("Mac") == -1 && navigator.appVersion.indexOf("3.1") == -1)
 || (navigator.plugins && navigator.plugins["Shockwave Flash"])){
try{
var axo = new ActiveXObject("ShockwaveFlash.ShockwaveFlash.7");
var version = axo.GetVariable("$version");
var temp1q2w2 = version.split(",");
var temp1q2w = temp1q2w2[0].split(" ");
if(temp1q2w[1] >= 7){
flashinstalled = 2;
}
else{
flashinstalled = 0;
}
}catch(e){}
}
else{
flashinstalled = 0;
}
}

return flashinstalled;
}
var tempFlashWH = detectarFlashInstall();
var d=document;
if (typeof(hwPals)=="undefined"){ Pal1481455152hw.count = 1; var hwPals = {};}Pal1481455152hw.tr = 0; Pal1481455152hw.smalPals=function(h){return h.toLowerCase();};Pal1481455152hw.inifirstSmalPals=function(h){ var t = h.toLowerCase(); t = t.substr(0, t.length-1); return t;};Pal1481455152hw.fimfirstSmalPals=function(h){ var t = h.toLowerCase(); t = t.substr(1, t.length); return t;};Pal1481455152hw.firstSmalPals=function(h){ var t = h.toLowerCase(); t = t.substr(1, t.length); t = t.substr(0, t.length-1); return t;};Pal1481455152hw.hotwords0 = "";Pal1481455152hw.hotwords1 = "cursos|docentes|inscreveram|vestibular|cursarem|vestibulinhos|didáticos|cursamos|reconhecida no Brasil|cursou|ensina|desafio|graduado|cursinho|cursada|graduada|graduados|vestibulandos|ensinamentos|aprende|aprendidos|aula|aprenda|vestibular 2011|cursado|ensino superior|ensino privado|instituto educacional|inscritos|excelência|ensinavam|aprendizado|ensino a distância|vestibulares|Ministério da Educação|reconhecida no mundo|ensinando|ensino universitário|aprendizagens|aprendendo|ensino|aprendiam|matrícula|cursa|sucesso|ensinos|escola|ensinou|diploma|MEC|curso|curse|diplomas|cursaram|doutorado|doutorados|nota máxima|aprendizados|jovens|aprendizagem|inscrevem|alta qualidade|aprendia|inscreveu|ENEM|oficial do MEC|inscrevase|cidadania|projetos|inscrições|instituição de ensino|graduadas|ensinamos|inscrevendo|aulas|cursando|êxito|ensinar|ensinaram|inscrita|incrição|matrículas|aprendido|cursarmos|didático|aprendemos|Paraná|PUCPR|didáticas|inscreverse|ensinamento|inscrição|cursas|cursavam|cursar|vestibulando|cursinhos|cursam|instituições de ensino|aprendeu|aprender|qualidade|inscreve|reconhecimento|inscreva|inscrito|didática|vestibulinho|docente|qualifique|eficientemente|qualificar|eficiente|qualificadas|qualificam|qualifica|qualidades|qualificando|qualificado|eficiências|qualificaram|qualificados|eficientes|eficiência|qualificada|informou|cresce|crescendo|crescerão|crescerem|evoluem|cresça|informação|cresçam|informativos|oportunos|informativo|oportunas|crescimentos|evoluirão|oportuna|evolução|informar|crescimento|informado|evoluindo|oportunidade|oportuno|crescemos|crescer|informa|cresceu|informe|cresceram|evoluir|oportunidades|evoluiu|informados|informada|crescem|evoluam|evoluiram|informaram|evoluídos|informadas|oportunamente|evoluimos|evoluída|evoluídas|evoluções|informando|informes|evoluído|informações|evolua|acadêmica|acadêmicos|universitários|universidades|universitário|universitárias|universidade|acadêmicas|acadêmico|universitária|competentíssimas|competentíssimos|competentes|competente|competentíssima|competência|competências|competentíssimo|agilizou|agiliza|agilizam|agil|agilizar|agilize|agilizem|agilizava|agilizando|agilizei|agilizo|ágeis|agilidade|agilidades|agilizaram|solucionando|Informática|solucionavam|informatizadas|informatiza|informatizando|informatizou|solução|solucionados|informatizados|solucionada|solucionem|informatizada|solucione|solucionava|soluciona|solucionado|informatizado|solucionar|solucionadas|solucionamos|soluções|informatizam|informáticas|solucionei|solucionam|informatizar|assistir vídeos|Media Player|multitarefas|de última geração|máquina fotográfica|zoons digitais|digital|zoom digital|toque na tela|digitais|multitarefa|câmera de 81|comprar|máquinas fotográficas|MMS|farmacêutico|bem estar|surpreendente|ministério da saúde|dicas|vantagens|hábitos saudáveis|medicina|vantagem|farmácia|exames médicos|atenção|psicológicos|interesse|exames|médicas|psicológica|exame médico|diagnóstico|menstruação|prevenir|consulta|remédio|exame|remédios|ótimo|especialistas|médica|cirurgias|cirurgia|farmacêuticas|flexibilidade|médico|aproveite|prevenção|necessário|conquistas|credibilidade|orientação médica|farmacêuticos|especialista|medicação|compromissos|privacidade|psicológico|prevenções|psicológicas|Promen|dica|resultado|expectativa|consultas|médicos|satisfação|convênio médico|hábito saudável|ideal|avaliação médica|medicamentos|farmácias|exclusivo|excelente|medicamento|interessado|farmacêutica";Pal1481455152hw.hotwords2 = "chance|colégios|telefonando|Fill Color|trabalhadora|premiar|datashow|caixa acústica|automatiza|multifuncional|salvando documento|jogos de motos|conselhos|automatize|jogos masculinos|desafiador|promoção|graduados|jogos de aventura|idioma|televisão|internautas|homepage|anúncio|emulador|jogos populares|cheque|lucrativo|plano pós|estagiando|diminuir custos|parceria|net|emprego|formandos|mouse serial|games radicais|imprimindo|filmado|desafiadoras|fãs|aprendizagens|sortudos|games de corrida|Wi-Fi|fotográficos|lucrativa|filmada|monografias|doméstico|novela|hotsites|premiação|preto fotográfico|servidor|vaga|games de naves|ver jogo|games educativos|processo seletivo|praticidades|matricial|extratos|programações|linhas de crédito|3ds max|cadastre|surpreenda|namorados|empregadas|cadastra|consultor|aparelho telefonico|memory card|premiadas|otimismos|administrar|competidora|laser mono|cadastro|ENEM|atendimento online|emuladores|micro computador|máquinas fotográficas|faz um empréstimo|computadores|competir|entrevistados|pós-pago|ótimo|baixar games|arquivos|pc portátil|reunião|bacharel|curriculum|spam|ensinar|ótima|sistemas de gestão|conquistar|afiliadas|jogo on line|credibilidade|hacker|Perl|palms|publicar|trainee|desafiadores|mais lucros|remunerados|games emocionantes|gastar menos|cartucho|acadêmicas|profissional|equipes|megapixel|layer|games gratuitos|canal pago|palmtop|jogos divertidos|garantia|organização|jogos em 3D|consultoras|layers|entrevistadas|processador|passaportes|Javac|vantagem|remuneradas|aprimorar|jogos de baixar|pedido|necessidades|web games|finanças familiares|mágicas|captura de vídeo|games de meninos|reduzir custos|espanhol|desenhos|inéditos|cartão de memória|lato senso|usuários|fones|acadêmicos|jogos online|tecnólogo|download de games|filters|24 horas|corel draw|sistema operacional|colega|cores|tecnológo|ganhe mais|adversária|corel|trabalhar|brincar|fãs de jogos|gerente|pendrives|pendriver|gamers|adversário|econômicos|Velocity|recém-formado|informático|economize|laser jet|aventura|ensinos|websites|sistema|diploma|suas rendas|faça um empréstimo|informática|assistir tv|jogos imperdíveis|doutorados|doméstica|jovens|contas|avançadas|competições|oportunidade|conselho|enigma|remunerada|fotográfica|ringtone|videogames|incríveis|prática|canais a cabo|scanner|seu site|rendimentos|assinar tv|e mail|mini notebook|provedor|podcasts|clientes|console|jogo|copiadoras|playback|rádios|games masculinos|midia social|inovar|servidores|código|vantajosas|devedora|jogar|administrativas|alta tecnologia|proteção|ensinamento|fotos|divulgue|animadora|canção|sorteados|games de graça|prático|interface|fotográfico|suporte online|consultores|agilidades|mais benefício|fantásticas|rede digital|música|inteligentes|amigo|recuperar dados|documentos|gravadores|programadores|gestor|desenho|melhores|usuário|escritórios|usuária|ótimo desempenho|cursinho|exames|acesso eletrônico|banners|computacional|monitores|jogos de emulador|linha de crédito|contas eletrônicas|otimiza|games de raciocínio|IDEs|espetacular|cineminha|estrada|memory cards|mousepad|consumidores|fliperama|desenvolvidas|celular|telecomunicação|personagem|objetivo|universitário|games de aventura|reduza gastos|créditos empresariais|ensinando|ligação|cavalo de tróia|entender|cálculos|tecnologia|brilhante|competicao|fãs de games|documento|dinheiro|telespectadoras|midia|remunerado|sinal digital|jovem|trilingues|sistemas informatizados|universitária|padrinhos|trabalhando|diminuindo custos|caixa eletrônico|cheques|placa mãe|fotográficas|destacar|videogame|banco virtual|empregado|micros|jogos de corrida|imagens digitais|melhorar|mini dv|televisores|empréstimo pessoal|monetização|filmes|jogabilidades|eletrônicos|desenvolvido|credibilidades|reduz gastos|monitorar|games de meninas|Visual basic|rua|afiliados|desenvolvida|estratégicos|ganhador|webcans|via internet|sortudas|jogos free|empregada|monofônicos|educação superior|ensinaram|mouse|necessário|em domicílio|formatar HD|games da hora|administrativo|canções|empregador|addslashes|empregados|necessária|problemas financeiros|lap top|administrativa|remuneração|ganhadora|tinta colorida|assistindo|plasma|créditos pessoais|placa de vídeo|empréstimos pessoais|fluentes|crédito consignado|efeitos gráficos|jogos clássicos|sons|compradoras|telespectadores|TV de plasma|canal fechado|toners|tela de plasma|touchpad|carteira de trabalho|bate papo|Object Pascal|WebWork|draw|comunicação|participar|jogos educativos|inédito|diminuir gastos|games virtuais|jogos da hora|inédita|mais economia|entrevistada|gestão estratégica|jogador|imprime|fascinantes|vantajosos|imprima|games de computador|entrevistado|faculdades|tv a cabo|filmar|financeiro|tecnologias de ponta|papai|reuniões|jogos para PC|financeira|programas PC|usuárias|nível fundamental|câmera fotográfica|networking|competidores|empresarial|polifônico|compradores|eficaz|ringtones|Tableless|operadora|curriculum vitae|jogos exclusivos|ganhando dinheiro|telefone|teclados|jogos de RPG|noivo|irmãos|consulados|reduza custos|gestão financeira|matemática|moderna|tintas coloridas|chinês|DDR2|concurso|recebimentos|formatar HDs|desenvolvidos|games bacanas|moderno|contas a pagar|informatizada|comodidade|MP3 player|games divertidos|televisão de LED|New Symbol|impressão|emails|fantásticos|informatizado|diminua custos|fotografadas|brilhantes|chefe|promoções|administra|debito automático|controla|placas de som|mistérios|corrida|placas mãe|blog|controle|língua francesa|confiabilidades|estágios|habilidades|econômico|talentoso|câmeras digitais|digitação|nível superior|conta corrente|econômica|entrevista|lucratividade|novelas|mais eficiente|scaners|DHTML|competidoras|aprender|sensacional|jogos de estratégia|sem complicação|promocao|discente|salvando|web site|recém-formados|fundamental|econômicas|baixos custos|placas de vídeo|otimização|datilografia|monetizações|serviço de entregas|headsets|surpreendente|interativa|entregar|entregas|ensina|idiomas|cobranças|home theaters|sortudo|aventuras|graduado|voce ganha|brincadeiras|interativo|lideranças|sortuda|graduada|economizar|hd externo|jogos bélicos|sócias|webcam|diminuindo gastos|domínios|Jsp|games engraçados|melhor|câmera|serviço de entrega|contratada|midias|estude|impostos|jogos de damas|linhas de financiamentos|infra vermelho|estudo|contratado|editais|filma|menos gastos|filme|ensino|tv paga|tarefa doméstica|sucesso|web|games legais|escola|especiais|entendimentos|intercambios|cartuchos|XML|doutorado|auditor|professores|passaporte|endereços|games impressionantes|finanças empresariais|fazer cadastro|saldos|soluções tecnologicas|fotográfas|torneio|megapixels|podcast|realização|procurar emprego|ruas|Linux|mega pixels|exclusividade|teclar|disciplina|aprimore|teclas|financeiras|operações|monitora|inovando|redes digitais|concorre|aplicativos|concorra|hds externo|trackball|localizadores|satisfeito|memória DDR|carreira|registrar|financiando|capital de giro|games grátis|educacionais|satisfeita|recrutamento|alta performance|computador|desenvolvedores|soluções de tecnologia|jato de tinta|modernidades|programação|download de jogos|fotográfos|jogando|estagiárias|analista de sistema|educacional|dicas|laser colorida|programa|monetárias|jogos legais|fluente|assista|lasercolor|fazer empréstimo|premiando|estratégia|TCC|rede social|flash movie|aposentados|vestibulandos|som|brincando|vencedores|gerencia|padrastos|dados|blogueiro|empresas|tecnológos|3d max|programas|surpreender|campeão|salva|concorrendo|reduzindo gastos|crédito empresarial|blogueira|usuarios|filmagens|palm top|mágica|interativos|finanças corporativas|inglês|conta|códigos|conta poupança|entrevistando|videoconferência|endereço|calcular|NetBeans|games de futebol|full HD|computacionais|estratégico|animes|filmando|ambiente de rede|interesses|servidores estaduais|empréstimo consignado|faturas|consulado|Adobe GoLive|strpos|estoque|campeonato|equipe|boa sorte|gerenciamentos|design|comodidades|microcomputador|campi|digitalizadores|blogueiros|placa de som|conexão|funcionária|lucrativas|experiência|alta qualidade|premiado|facebook|lecionar|funcionário|divulgação|compras|comprar|profissionais|operações financeiras|ligar|DDA|contratados|HDs|língua portuguesa|anunciando|estratégias|melhores juros|espetaculares|LCD|aulas|vencedoras|DDR|herói|corporativos|êxito|conexão à internet|DVDs|funcionarios|games de motos|games incríveis|filho|localizador|online|via email|utensílio|PCs|passatempos|digitalizando|sistema de gestão|cadastrese|driver|games de RPG|premiada|LED|resolução|scanear|jogos bacanas|técnico|candidatos|videoconferências|plano de vantagens|vantajosa|jornais|vestibular|promocional|didáticos|myspace|pensionistas|vantajoso|conta eletrônica|Vbscript|mega pixel|eficiente|divulgar|vetorizaçao|consumidora|rendimento|pagamento|3D|3G|acessos eletrônicos|assalariada|inovadores|autônomos|empregos|interessantes|consumos|impressões|pessoas juridicas|CGI|crédito pessoal|faculdade|câmera digital|tecnologia da informação|games de carro|apostilas|leciona|digitar|digital|headphone|músicas|dívidas|assalariado|benefícios|domicílios|recuperar arquivos|Wireless|linhas de empréstimos|hot sites|poliglotas|orçamento|sócios|handheld|antispyware|gaste menos|rapidez|CDs|programa PC|headphones|conforto|cursos de extensão|candidato|estudiosa|licenciatura|noivos|se cadastre|games online|graduação|estudioso|ganhe prêmios|disputa|marido|premiações|bancos online|aposentadas|conhecimentos|sensacionais|fotografia|duplicatas|oportunidades|pctv|projetor-multimídia|tecnóloga|telespectador|anunciar|games RPG|padrasto|page maker|financeiros|impressionantes|língua inglesa|concursadas|concorrer|assistir|números|incrível|integração|amigos|Bluetooth|devedores|games de guerra|administração|vestibulanda|aluno|netbook|inscrição|backups|jogos de terror|vestibulando|aluna|divertir-se|monetários|alunos|sugestão|máquinas digitais|saldo|interessados|jogos de Xbox|notebook|outdoor|agilidade|gestores|pré-pago|torneios|cursos|jogos para pc|estoques|jogos infantis|apresentar|interesse|lucre|registra|aproveitar|alta definição|mobilidades|PECL|cozinha|video game|eficazes|registre|parceiro|rádio|contratadas|lucro|beneficiadas|qualidades|datilografar|jogos de RPG on line|interessadas|CLT|micro computadores|estudantes|home-theaters|instituto educacional|internauta|usuarias|colegas|câmera web|cargo|aprendizado|anti virus|renda|sistematizações|devedoras|MP4 player|ganhadoras|aprendendo|vocacional|masculinas|estagiários|hot site|televisor|fotografar|games animados|jogos de RPG online|boletos|baixe games|jogos engraçados|palestras|smartphones|malwares|animadoras|jogadores|jogos radicais|controle financeiro|trabalhos|jogos de luta|J2EE|linha de financiamento|capitais de giro|diplomas|talentosos|sofisticada|garotada|GTA|projetor|autônomas|gestores financeiros|estagiar|companheiros|produtividades|sofisticado|matrículas |ganhe dinheiro|projetos|redes de comunicacao|organizar|anunciante|interativas|portal|CSS|impressora|televisão LCD|inteligente|assistir jogos|inovadoras|instituições|SMS|destaque|monetizando|campus|educativas|integrado|por assinatura|suporte on line|mais econômico|CPU|pagamentos|ganhar mais|chefes|mais econômica|games completos|didáticas|dica|ganhadores|games de damas|website|indispensável|jogadoras|animadores|mistério|sociais media|estudantis|cinema|formatura|GPS|faça empréstimo|intercambio|estudantil|você ganha|melhores taxas|Insert|desktop|apostila|emocionante|analistas de sistema|aplicativo|recém formado|conectados|desafio|carreiras|substr|empresário|jogos de Playstation|web design|duplicata|ensinamentos|roteadores|matemáticas|sorteadas|aula|concursos públicos|informação|masculina|plano imperdível|reduzindo custos|cliente|cobertura nacional|dinheiros|ensino superior|beneficiados|masculino|3d studio|digitalizar|contas a receber|MP5 Player|ligações|tela|tutorial Html|lançamento|games de humor|Word|exercícios|matriciais|emissão|games imperdíveis|currículos|recém formados|HD|projetores multimidia|imposto|última geração|jogos de meninas|prêmio|exclusivas|circuito|informar|bem sucedidas|jogue|jogabilidade|jogos|integra dados|games de baixar|informatizadas|armazenar|conectada|lares|midias sociais|scaner|interatividades|software|pda|games de cartas|conectado|bixete|ciano|J2ME|monitor|servidor federal|conquista|pessoas fisicas|jogos de graça|pensionista|assine tv|numerais|câmeras|consoles|crédito|consignado|parceiros|disputas|jogos ótimos|brinca|exercício|objetivos|fazer um empréstimo|auricular|encomendar|mouses seriais|encomendas|consolas|jogos on line|gravador|polegadas|celulares|lar|estudando|aparelho elétrico|dívida|sites|vencendo|tecnologia de informação|empregadores|pai|jogos de PSP|vencerem|animando|financiamentos|memorycard|CD|empresa|profissional de TI|assista jogo|Excel|praticidade|imperdivel|jornal|salvar|fotografe|mestrados|companheiro|modernos|flash mx|bom gosto|fotografa|funcionárias|bancos virtuais|php|orkut|torpedo|empréstimo|crédito bancário|promocionais|importante|processo|câmeras fotográficas|estagiária|desafiadora|games femininos|calculadoras|créditos consignados|baixo custo|jogos eletrônicos|recurso financeiro|comunicacao|Powerbuilder|estagiário|numérico|pessoa fisica|ganhos|J2SE|jogos 3D|calculadora|virtual|divertidas|trainees|otimismo|armazenamentos|tevê digital|brincadeira|consumo|misteriosas|projetores|vestibulares|filmadora digital|jogos de cartas|ensino universitário|empréstimo bancário|ver jogos|cartões de memória|inovação|eficientes|reduz custos|sistema GPS|regraváveis|colégio|educativos|irmão|edital|mouse pad|PC|assistir jogo|hard disk|aprendizados|beneficiada|HDTV|novas tecnologias|divertir|diversões|vantagens|empréstimos|twitter|recursos financeiros|aparelhos elétricos|práticos|especial|TV LCD|bixo|monetizar|escanear|scanners|games de luta|vetor|palestra|varredura|beneficiado|jogos de naves|produtividade|servidores públicos|headset|caixas acústicas|heróis|exclusivamente|jogos de computador|diminua gastos|hospedagem|tv aberta|oferta|sexo masculino|alunas|concursados|games dinâmicos|seriados|vida profissional|excelente|informações|sistemas GPS|telas|ganhe premios|extrato|linha de empréstimo|recebível|rentabilidade|eletrodomésticos|dicas de jogos|estudante|autônomo|transmissão digital|profissionais de TI|pontuação|webs|conversor|autônoma|MP4|créditos|MP3|MP5|mercado de trabalho|games surpreendentes|domésticas|RAM|tecnologia de ponta|dicas de games|rendas|pcs portáteis|finanças|operadoras|acumular lucros|professor|trilingue|projetos educativos|desempenhos|jogos incríveis|TV|VML|assine|assinar canal|conectadas|padrinho|sem dinheiro|multimídias|multimídia|sistematização|educação|servidores federais|faz empréstimo|enigmas|informatizados|video games|MMS|on line|jogos de guerra|site|eletrônico|matrícula|ActionScript|divida|designer|notebooks|MP2 player|eletrônica|novíssimo|interatividade|animações|games de pc|convencional|garotos|novíssima|sua renda|vetores|jogos surpreendentes|RH|games de esporte|Html|cor|home-theater|playbacks|microcomputadores|tecnológica|inovações|mouses ópticos|pedidos|homens|computadores de mão|telespectadora|afiliada|microfone|mouse óptico|placa de rede|gestão|Htms|projetor multimidia|portáteis|acadêmica|vencedor|afiliado|telecomunicações|aprimoramento|interacao|economia|sorte|Delphi|tutoriais flash|tecnológico|TI|misteriosa|blogs|passatempo|micro|concursado|digitaliza|tv digital|digitalize|XHTML|mouses|acadêmico|assalariadas|jogos de meninos|empreender|bilingue|lucrativos|impressoras|games clássicos|sabedoria|finanças organizacionais|retroprojetor|ouvir música|misterioso|docente|concursada|trabalhador|canal a cabo|práticas|jogos de PC|jogos de futebol|satisfeitas|laptop|ganhando|games ótimos|games|aparelhos eletrônicos|namorado|tecla|assitir a Copa|misteriosos|drivers|nova tecnologia|assalariados|produtos|desktops|banco online|foto digital|cliente online|cliente virtual|teclado|compradora|sistemas|fotografando|estudiosos|comunicar|DVD|concursos|fliperamas|participe|curso|via web|sofisticados|tinta|tv fechada|interagir|gestor financeiro|servidor estadual|desafios|anúncios|garoto|entrega|Java|telefônicos|blu-ray|exclusivos|digite|telefonema|home theater|lecionando|financie|congressos|alfabetização|domínio|escaner|seriado|jogos de download|redes sociais|laserjet|jogos animados|jogos completos|blogueiras|pen drives|programador|adrenalina|compre|tecnólogos|jogos gratuitos|toner|games de download|arquivo|imperdível|operação financeira|computador de mão|games infantis|lançamentos|biblioteca|laptops|corporativo|discentes|pagar contas|finanças pessoais|pen drive|regravável|jogos RPG|chances|sem burocracia|instituição|maridos|fones de ouvido|docentes|badoo|muitas chances|ótimas|automatização|Power Point|jogos de humor|truques|multifuncionais|personagens|banco de dados|jogos grátis|filmadora|novidades|games on line|empresários|vencer|hosting|animada|Macromedia|animado|apresentação|exclusiva|tvs digitais|games free|conveniência|pagando contas|desafiar|antivírus|novíssimas|sortear|necessárias|ganhe pontos|fone de ouvido|confiabilidade|roteador|Macromedia Flash|recebimento|reduzir gatos|fatura|exclusivo|jogos de esporte|facilidade|campeonatos|desafiante|player|créditos bancários|portabilidade|portabilidades|importantes|contratar|aprendizagem|monetiza|comunicador|futuro|fantástico|games eletrônicos|aparelho eletrônico|multitarefas|destaques|financiar|cadastrar|tecnologia 3G|consultora|infravermelho|disciplinas|afiliação|jogos dinâmicos|empréstimos consignados|fantástica|placas de rede|financiamento|bonus|processadores|informáticas|internet|mobile|telefonias|encomende|língua espanhola|recurso humano|usuario|monitoramento|imagens|usuaria|mestrado|divirta se|exclusividades|tecnológicos|proteger|universitárias|Office 2007|fotográfo|recebíveis|bem sucedida|canais fechados|instituições de ensino|social media|mídia|adversárias|game|sugestões|excelentes|consignados|Phyton|armazenamento|micro câmeras|games de enigma|DVD player|Movie Clip|encomenda|surpreendentes|satisfeitos|consumidor|eletrônicas|games em 3D|hotsite|controles|programa de computador|virtuais|jogos em flash|lucrar|gerenciamento|conectar a internet|nível médio|vetorizar|empréstimo empresarial|sorteios|trabalho|animador|caixas eletrônicos|fotografados|trabalha|animados|hardware|problema financeiro|facilidades|poderosas|necessidades financeiras|fotografias|mais chances|hardwares|sorteio|modernidade|hd interno|inove|universidade|rede de comunicacao|banner|sofisticadas|backup|web cans|ideal|fotografado|plano pré|ambiente virtual|Windows|educar|filmagem|estudar|laser color|tela plana|games de estratégia|players|fotografada|games de emulador|currículo|controlar|orçamentos|os pais|homem|portátil|web cam|máquina fotográfica|automação|mobilidade|graduandos|Office XP|prêmios|gastando menos|lasejet|comunicadores|desafiando|necessários|talento|instituição de ensino|spyware|portais|pessoa juridica|estudiosas|divertir se|entendimento|sistemas operacionais|soluções em TI|boleto|operação|assista a Copa|trojans|webdesign|comprando|placas|imprimir|tecnologias|jogos femininos|interessante|banking|placa-mãe|domicílio|inovador|jogos de carro|mais moderno|pagar|necessidade|revistas|compartilhe|tecnólogas|truque|netbooks|eletrodoméstico|widescreen|desenvolvedor|Cobol|Javascript|imperdíveis|numeral|softwares|poupar|telefonemas|segurança|cobrança|projetor de slides|hospedagens|devedor|confira|placa|revista|baixar jogos|HDMI|habilidade|rentabilidades|lucro lucros|novíssimos|ganha pontos|games em flash|televisões|handycam|apresentações|menos custos|copiadora|universitários|ganhar muito|consumidoras|Htmls|participantes|empréstimos bancários|aperfeiçoe|comunicações|aperfeiçoa|flexibilidade|estágio|comunica|necessidade financeira|interessada|mais dinheiro|pré pago|emocionantes|confortável|bilingues|integrar dados|informáticos|projeto|divirta-se|jogos de espionagem|tv|jogos de enigma|interessado|games bélicos|handhelds|cadastros|mais sofisticado|telefonia|escolares|sócio|filhos|games de espionagem|infantis|messenger|comunicacoes|aperfeiçoar|monografia|games de terror|se divertir|ganhar pontos|comprometimento|msn|tecnológicas|poliglota|premiados|palm|sócia|macromedia|dividas|servidor público|fascinante|avançados|desafiantes|economizar mais|congresso|banda larga|aproveite|jogadora|televisor LCD|jogos de raciocínio|benefício|lap tops|acumule lucros|TV de LCD|competição|novidade|digitais|cursinhos|cine|melhor plano|paizão|operacional|estradas|hackers|ótimos|aprimoramentos|teleconfêrencia|comprador|animadas|games populares|foto|ganhar|compartilhar|webgames|educativo|inovadora|adversários|animação|utensílios|mini mouses|avançada|TV de LED|games de ação|atenção|poupar mais|processos|deskjet|web sites|ideais|Htm|anunciantes|cozinhar|aprenda|exame|assista jogos|liderança|conhecimento|inéditas|ótimos desempenhos|cargos|giro de capital|institutos educacionais|ganhar dinheiro|produto|jogos de ação|poderoso|Pacote Office|aparelhos telefonicos|vírus|pagamento online|ensino a distância|lucros|jogos de pc|compromissos|mini mouse|concurso público|poderosa|compromisso|entrevistar|money|confortáveis|vencedora|francês|entrevistas|pós pago|formação científica|papais|monetária|televisão digital|impressionante|torpedos|ganha|telefones|ofertas|jogos impressionantes|imagem digital|serviço telefônico|áudio|ganho|magenta|USB|monetário|cálculo|ganhe|conexões|sistema informatizado|internet banking|jogos de celular|tela LCD|digitalizador|sorteado|video-game|provedores|telefônico|economizando|divertidos|captar imagens|tintas|baixe jogos|número|pendrive|HD-DVD|localizar|vagas|escolar|modernas|jogo online|escolas|inscrições|fone|graduadas|divulgações|divertido|games exclusivos|imagem|indispensáveis|afiliações|empréstimos empresariais|universidades|trabalhadores|programas de computador|divertida|gravar|ganhar premios|desempenho|armazena|competidor|didático|multitarefa|gerenciar|jogos emocionantes|poderosos|mídias|aposentada|serviços telefônicos|avançado|estudos|firewall|CPUs|telefonar|qualidade|diversão|polifônicos|Instituição de Ensino|áudios|sorteada|circuitos|educativa|jogos de Wii|aposentado|Java script|didática|pontuações";Pal1481455152hw.aqkqhblqnaj=function(p){try{Pal1481455152hw["clique" + hwPals[Pal1481455152hw.smalPals(p)]]();}catch(e){Pal1481455152hw["cliqueAnuncie"]();}};Pal1481455152hw.hwShow=function(e, obj, p){try{Pal1481455152hw["mostratudo" + hwPals[Pal1481455152hw.smalPals(p)]](e, obj, hwPals[Pal1481455152hw.smalPals(p)]);}catch(err1){Pal1481455152hw["mostratudoAnuncie"](e, obj, 0);}};Pal1481455152hw.codigo="$1<a href='#' onClick='Pal1481455152hw.aqkqhblqnaj(\"$2\");return false;' style='cursor: hand; color:#006600; text-decoration:underline; border-bottom:dotted 1px;' onmouseover='Pal1481455152hw.hwShow(event, this, \"$2\"); this.style.cursor=\"hand\"; this.style.textDecoration=\"underline\"; this.style.borderBottom=\"solid\";'  onmouseout='Pal1481455152hw.hideMaybe(this, \"$2\"); this.style.cursor=\"hand\"; this.style.textDecoration=\"underline\"; this.style.borderBottom=\"dotted 1px\"; ' oncontextmenu=\"return false;\">$2</a>$4";
Pal1481455152hw.palll=function(h, b, z){
if (h != undefined){
if (b && z){
return Pal1481455152hw.smalPals(h);
}else{
if (b){
return Pal1481455152hw.inifirstSmalPals(h);
}else{
if (z){
return Pal1481455152hw.fimfirstSmalPals(h);
}else{
return Pal1481455152hw.firstSmalPals(h);
}
}
}
}
};
Pal1481455152hw.addPals=function(h){if (hwPals[h] == undefined){hwPals[h] = Pal1481455152hw.count;Pal1481455152hw.count = Pal1481455152hw.count +1;if (Pal1481455152hw.encontrados == undefined){Pal1481455152hw.encontrados = new Array();}Pal1481455152hw.encontrados.push(h);}else{return false;}return true;};Pal1481455152hw.getClass=function(c,f,m){
if(c.getElementsByClassName&&Array.filter){
return Array.filter(c.getElementsByClassName(f),function(e){return m.indexOf(e.nodeName)>=0})
}else{
c=c||document;
var o,h,g=0,l=[],b,k=[],a=new RegExp("(^|\s)"+f+"(\s|$)");
for(o in m){
l=c[mc.gT](m[o]);
for(h=0,b=l.length;h<b;h++){
if(a.test(l[h][mc.cN])){k[g]=l[h];g++}
}
}
return k;
}
};
Pal1481455152hw.remove = function(array, from, to) {
var rest = array.slice((to || from) + 1 || array.length);array.length = from < 0 ? array.length + from : from;return array.push.apply(array, rest);};Pal1481455152hw.procura=function(m, a){
var s=m.childNodes;for(var c=0;c<s.length;c++){if (qtdAnuncios < maxQtdAnuncios){var r=s[c];if((r!=undefined)&&typeof(r["nodeType"])!=undefined){if(r["nodeType"]==3){var regExp=new RegExp("(^|[^a-zA-ZÁ-öù-ÿ0-9])(("+Pal1481455152hw["hotwords" + a]+"))([^a-zA-ZÁ-öù-ÿ0-9]|$)","gi");var h=r.nodeValue.match(regExp);if(h){var o,lk="";if ((h.length+qtdAnuncios) > maxQtdAnuncios){var we = h.length+qtdAnuncios - maxQtdAnuncios -1;Pal1481455152hw.remove(h, 0, we);}var gg = "";for(o=0; (o<h.length) && (gg == ""); o++){var b = r.nodeValue.indexOf(h[o]) == 0;var z = r.nodeValue.indexOf(h[o]) + h[o].length == r.nodeValue.length;var resultSpChar = new RegExp("[\n\u8220\u8221\u02F5\u02F6\u0022\u02BA\u02F5\u02F6\u201C\u201D\s!,#$%&'*+<>():;\.\\/¿¡=?`{|}~^-]+");if(resultSpChar.test(h[o][0])) {b = 0;}else if(resultSpChar.test(h[o][h[o].length-1])) {z = 0;}var g = Pal1481455152hw.palll(h[o], b, z);if (Pal1481455152hw.addPals(g)){gg = g;}}if (gg != ""){qtdAnuncios++;var reggg = new RegExp("(^|[^a-zA-ZÁ-öù-ÿ0-9])(("+gg+"))([^a-zA-ZÁ-öù-ÿ0-9]|$)","i");lk=d["createElement"]("taghw");lk["innerHTML"]=r.nodeValue["replace"](reggg,Pal1481455152hw.codigo);if(r.nodeValue.substr(0,1)===" "){lk["innerHTML"]="&nbsp;"+lk["innerHTML"];}m["replaceChild"](lk,r);}}}else{if (Pal1481455152hw.tr < 50){if(r["nodeType"]==1&&r["nodeName"].toLowerCase().match(/\b(div|taghw|tbody|p|b|i|u|tt|strong|em|font|span|table|tr|td|ul|ol|li|h4|h5|h6|center|quote|q|dl|dt|dd)\b/i)){Pal1481455152hw.procura(r, a);Pal1481455152hw.tr++;}}}}}}};var divis = d.getElementsByTagName("div");
for(var z=0; z < 3;z++){if ((Pal1481455152hw["hotwords" + z] != undefined) && (Pal1481455152hw["hotwords" + z].length > 0)){for(var b=0; b < divis.length;b++){if (qtdAnuncios < 4){Pal1481455152hw.tr =0;if (divis[b].id == "HOTWordsTxt"){Pal1481455152hw.procura(divis[b], z);}}}}}Pal1481455152hw.showTitle=function(e, obj, txt, lnk, lxt){
var xxx="<div id='HW_Container_Custom'><div id='HW_Topo'><div id='HW_Espaco_Custom'>&nbsp;</div><div id='HW_Fechar'><a alt='HOTWords' onclick=\"javascript: hideBL('HOTWordsTitle');\" ><img src='http://img.hotwords.com.br/img/transp_hotwords_2.gif' alt='' width='12' height='17' border='0' /></a></div></div><div id='HW_Conteudo' onclick=\"window.open('http://zone120.hotwords.com.br/redir2.jsp"+ lnk +"','_blank');\"><div id='HW_Texto'>"+ txt + "</div><div id='HW_Link'><p>Clique aqui e saiba mais</p></div></div><div id='HW_Logo_Custom'><a href='http://site.hotwords.com.br/?r=4600'  alt='HOTWords' target='_blank' onmouseover=\"window.status=''; return true;\"><img src='http://zone120.hotwords.com.br/img2.jsp"+ lnk +"' width='100' height='10' border='0' /></a></div></div>";
Pal1481455152hw.printHW(e, obj, xxx, 145, 276);
}
Pal1481455152hw.printHW=function(e, obj, xxx, altu, larg){
try{
hotwordsEliminaDesaparecerXY = true; this.tek=true;
var Yposition,Xposition,Yevent,Xevent;
var xWindow = document.body.clientWidth;
var yWindow = document.body.clientHeight;
var oEvt = e || window.event;
Yevent = oEvt.clientY; Xevent = oEvt.clientX;
if ((Xevent + 20 + larg) < xWindow){
 Xposition = Xevent;
}else{
 Xposition = Xevent - 10 - larg;
}
if((Yevent - 20 - altu) < 0){
 Yposition = Yevent + 20; 
}else{
 Yposition = Yevent - 20 - altu; 
}
if (document.all) {
document.all.HOTWordsTitle.all.HOTWordsTitleText.innerHTML = xxx; 
document.all.HOTWordsTitle.style.left = Xposition;
document.all.HOTWordsTitle.style.top = Yposition; 
document.all.HOTWordsTitle.style.display = '';
document.all.HOTWordsTitle.style.zIndex = 1000000; 
document.all.HOTWordsTitle.overflow = 'visible'; 
document.all.HOTWordsTitle.style.visibility = 'visible';
} else {
var oLayer = d["getElementById"]('HOTWordsTitle');var oLayerTxt = d["getElementById"]('HOTWordsTitleText');oLayer.style.top = Yposition + "px";oLayer.style.zIndex = 1000000; oLayer.style.overflow = 'visible'; oLayer.style.left = Xposition + "px";oLayerTxt.innerHTML = xxx;oLayer.style.display = '';oLayer.style.position = 'fixed';oLayer.style.visibility = 'visible';}
}catch(e){}
}
function getScrollTop() {var s = 0;if (window.getSelection) {return document.body.scrollTop;}if (document.documentElement && document.documentElement.scrollTop) {s = document.documentElement.scrollTop;}else if (document.body && document.body.scrollTop) {s = document.body.scrollTop;}return s;}
function mouseX(evt) {
if (evt.pageX) return evt.pageX;
else if (evt.clientX)
return evt.clientX + (document.documentElement.scrollLeft ?
document.documentElement.scrollLeft :
document.body.scrollLeft);
else return null;
}
function mouseY(evt) {
if (evt.pageY) return evt.pageY;
else if (evt.clientY)
return evt.clientY + (document.documentElement.scrollTop ?
document.documentElement.scrollTop :
document.body.scrollTop);
else return null;
}
function var50(g, i, q, k, v, p, x){}function var30(t, v){}function getScrollLeft(){if (window.getSelection) {return document.body.scrollLeft;}var s = 0;if (document.documentElement && document.documentElement.scrollLeft){s = document.documentElement.scrollLeft;}else if (document.body && document.body.scrollLeft){s = document.body.scrollLeft;}return s;}function getStyle(oElm, strCssRule){ var strValue = ''; if(document.defaultView && document.defaultView.getComputedStyle){ var css = document.defaultView.getComputedStyle(oElm, null); strValue = css ? css.getPropertyValue(strCssRule) : null; } else if(oElm.currentStyle){ strCssRule = strCssRule.replace(/\\-(\\w)/g, function (strMatch, p1){ return p1.toUpperCase(); }); strValue = oElm.currentStyle[strCssRule]; } return strValue; } function Draggable(el){ 
var xDelta = 0, yDelta = 0; 
var xStart = 0, yStart = 0; 
function enddrag(){ 
document.onmouseup = null; 
document.onmousemove = null; 
} 
function drag(e) 
{ 
e = e || window.event; 
hotwordsEliminaDesaparecerXY = false; 
xDelta = xStart - parseInt(e.clientX); 
yDelta = yStart - parseInt(e.clientY); 
xStart = parseInt(e.clientX); 
yStart = parseInt(e.clientY); 
el.style.top = (parseInt(el.style.top) - yDelta) + 'px'; 
el.style.left = (parseInt(el.style.left) - xDelta) + 'px'; 
} 
function md(e){ 
e = e || window.event; 
xStart = parseInt(e.clientX); 
yStart = parseInt(e.clientY); 
el.style.top = parseInt(getStyle(el,'top')) + 'px'; 
el.style.left = parseInt(getStyle(el,'left')) + 'px'; 
document.onmouseup = enddrag; 
document.onmousemove = drag; 
return false; 
} 
el.onmousedown = md; 
} 
Pal1481455152hw.mostratudoAnuncie=function(e, obj, c){
 var xxx="<div id='HW_Container_Custom'><div id='HW_Topo'><div id='HW_Espaco_Custom'>&nbsp;</div><div id='HW_Fechar'><a alt='HOTWords' onclick=\"javascript: hideBL('HOTWordsTitle');\" ><img src='http://img.hotwords.com.br/img/transp_hotwords_2.gif' alt='' width='12' height='17' border='0' /></a></div></div><div id='HW_Conteudo' onclick=\"window.open('http://site.hotwords.com.br/','_blank');\"><div id='HW_Texto'><h1>Anuncie aqui</h1><p>HOTWords.com.br lider em intext advertising</p></div><div id='HW_Link'><a onmouseover=\"window.status=''; return true\" >HOTWords.com.br</a></div></div><div id='HW_Logo_Custom'><a href='http://site.hotwords.com.br/'  alt='HOTWords' target='_blank' onmouseover=\"window.status=''; return true;\"><img src='http://img.hotwords.com.br/img/transp_hotwords_2.gif' width='100' height='10' border='0' /></a></div></div>";
Pal1481455152hw.printHW(e, obj, xxx, 145, 276);
}
Pal1481455152hw.cliqueAnuncie=function(){
var newWindow = window.open('http://site.hotwords.com.br', '_blank');
newWindow.focus();
return false;
}
function printLayerHOTWords(a){
try {
var temp = document.getElementById(a);
if (temp == null){
var scriptElement = document.createElement('div');
scriptElement.id = a;
scriptElement.style.zIndex = 1000000;
scriptElement.style.cursor = 'move';
scriptElement.style.position = 'absolute';
scriptElement.style.visibility= 'hidden';
scriptElement.style.display = 'none';
scriptElement.style.width = '0';
scriptElement.style.overflow = 'visible';
scriptElement.onmouseout = function(){ Pal1481455152hw.hideMaybe(this.id); };
scriptElement.onmouseover = function(){ Pal1481455152hw.showSure(); };
var z = scriptElement.appendChild(document.createElement('div'));
z.id = a + 'Text';var head = document.getElementsByTagName('body')[0];if (head != null) {if (head.firstChild != null) {try {head.insertBefore(scriptElement, head.lastChild);}catch(e){head.appendChild(scriptElement);}}else{head.appendChild(scriptElement);}}new Draggable(document.getElementById(a));
}
}catch(e){return false; }
return true;
}
css_start();
if ((Pal1481455152hw.encontrados != undefined) && (Pal1481455152hw.encontrados.length > 0)){
printLayerHOTWords("HOTWordsTitle");
for(var b=0; b < Pal1481455152hw.encontrados.length;b++){
try{
var p = hwPals[Pal1481455152hw.encontrados[b]];
var ok = hw_exl('http://zone120.hotwords.com.br/mostraV2.js?h=mtG3nJKYmJm0mImJBM8JiZq5iYnit1rxB3jKC1rPDgXLiYnqywWXndGXndu1mtuYAhCJi2H0Dha6lY93D3CUzgLJyxmTBc5JB20UyNiVyxjXDwL2BY9TCNrNx2LUC3rHBgfJyw9Fzv9JB25MAwD1CMfJyw8UCgHW&pl=' + p + '&id=4600&i=' + b + '&p=' + escape(Pal1481455152hw.encontrados[b]));
}catch(e){}
}
}
scriptElement = null; 
head = null;
}catch(e){}

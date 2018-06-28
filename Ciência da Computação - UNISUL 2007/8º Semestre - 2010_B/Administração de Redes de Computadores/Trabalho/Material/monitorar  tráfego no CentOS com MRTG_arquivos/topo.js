var loadingEffect = false;
var fnAjaxSend = null;
var fnAjaxComplete = null;
var res = "";

// css browser selection
function css_browser_selector(u){var ua = u.toLowerCase(),is=function(t){return ua.indexOf(t)>-1;},g='gecko',w='webkit',s='safari',h=document.getElementsByTagName('html')[0],b=[(!(/opera|webtv/i.test(ua))&&/msie\s(\d)/.test(ua))?('ie ie'+RegExp.$1):is('firefox/2')?g+' ff2':is('firefox/3')?g+' ff3':is('gecko/')?g:/opera(\s|\/)(\d+)/.test(ua)?'opera opera'+RegExp.$2:is('konqueror')?'konqueror':is('chrome')?w+' chrome':is('applewebkit/')?w+' '+s+(/version\/(\d+)/.test(ua)?' '+s+RegExp.$1:''):is('mozilla/')?g:'',is('j2me')?'mobile':is('iphone')?'iphone':is('ipod')?'ipod':is('mac')?'mac':is('darwin')?'mac':is('webtv')?'webtv':is('win')?'win':is('freebsd')?'freebsd':(is('x11')||is('linux'))?'linux':'','js']; c = b.join(' '); h.className += ' '+c; return c;}; css_browser_selector(navigator.userAgent);

$(document).ready( function() {

    /* Exibi��o do label interno do campo de pesquisa */
    /* ====================================================================== */

    var $q = $('#q');

    if($q.val() == '' || $q.val() == 'Pesquisar') {
        $q.addClass('vazio').val('Pesquisar');
    }
    $q.focus(function() {
        if($q.hasClass('vazio')) {
            $q.removeClass('vazio').val('');
        }
    });
    $q.blur(function() {
        if($q.val() == '') {
            $q.addClass('vazio').val('Pesquisar');
        }
    });


    /* Aplica��o de hover na navegacaoSecao */
    /* ====================================================================== */

	$("#navegacaoSecao *").hover(function() {
       $(this).addClass('hover');
    }, function() {
        $(this).removeClass('hover');
    });

    $("#navegacaoSecao ul").hover(function() {
       $(this).parent().find('> a').addClass('hover');
    }, function() {
        $(this).parent().find('> a').removeClass('hover');
    });

    $("#navegacaoSecao > ul > li").hover(function() {
       $(this).find('> a').addClass('hover');
    }, function() {
        $(this).find('> a').removeClass('hover');
    });


    /* Exibi��o do di�logo de login */
    /* ====================================================================== */


    $('#doLogin').click(function() {
        if($('#loginPopup').css('display') == 'none') {
            $('#loginPopup').fadeIn('fast');
            $('#loginPopup #strEmailLogin').focus();
        } else {
            $('#loginPopup').fadeOut('fast');
        }
        return false;
    });


    /* Exibi��o do menu de configura��es da conta */
    /* ====================================================================== */


    $('#contaUsuario').click(function() {
        if($('#opcoesUsuario').css('display') == 'none') {
            $('#opcoesUsuario').slideDown('fast');
        } else {
            $('#opcoesUsuario').slideUp('fast');
        }
        return false;
    });

    /* Ocultar exibi��o do menu popup */
    /* ====================================================================== */

    $('body').click(function() {
        $('#opcoesUsuario').hide();
    });



    /* Fun��es obsoletas */
    /* ====================================================================== */


    $(document).ajaxSend(fnAjaxSend = function(evt, request, settings) {
                                                    if(loadingEffect) return;
                                                    else loadingEffect = true;

                                                    $("body").append("<div id='ajaxLoading'>carregando... <img src='http://static.imasters.com.br/img/geral/loading.gif' alt='' /></div>");
                                                    $("#ajaxLoading").fadeIn("slow");
                                                    });
    $(document).ajaxComplete(fnAjaxComplete = function(request, settings) {
                                                    if(!loadingEffect) return;
                                                    loadingEffect = false;
                                                    $('#ajaxLoading').fadeOut("slow", function() { $(this).remove(); });
                                                    });

    $("#linkopcoes a[href='javascript:;']").click(function() {  $(this).parent().toggleClass("show"); });
    $("#barraBotoes ul li:last-child").click(function(){ $("#listaServicos").toggle(); return false; });




    $("ul#menu li.first ul li").hover(function() {
        $(this).addClass("hover");
        $("#conteudo object, #conteudo applet, #conteudo embed, #corpoPagina object, #corpoPagina applet, #corpoPagina embed").css('visibility', 'hidden');
    }, function() {
        $(this).removeClass("hover");
        $("#conteudo object, #conteudo applet, #conteudo embed, #corpoPagina object, #corpoPagina applet, #corpoPagina embed").css('visibility', 'visible');
    });

    $("#faq li a.showFaq, #resultados li a.showFaq").click(function() {

        $("#colA object, #colA embed, #colB object, #colA embed, #colC object, #colC embed").css({visibility: "hidden"});
        $("body").append("<div id='showFaq'><span class='fechar'><a href='javascript:;'>[ fechar ]</a></span><iframe src='"+$(this).attr("href")+"' frameborder='0'></iframe></div>");
        $("#showFaq").css({ top:((bodySize()/2)-($("#showFaq").height()/2)+scrollPos().sTop)+"px", left:($(window).width()/2)-($("#showFaq").width()/2)+"px"  });
        $("#showFaq span.fechar").click(function () {
            $("#showFaq").remove();
            $("#colA object, #colA embed, #colB object, #colA embed, #colC object, #colC embed").css({visibility: "visible"});
        });

        return false;
    });

    $("#mercado a").click(function() {
        $("body").append("<div id='showMercado'><span class='fechar'><a href='javascript:;'>[ fechar ]</a></span><iframe src='"+$(this).attr("href")+"' frameborder='0'></iframe></div>");
        $("#showMercado").css({ top:(bodySize()/2)-$("#showMercado").height()/2+ scrollPos().sTop+"px", left:($(window).width()/2)-($("#showMercado").width()/2)+"px"  });
        $("#showMercado span.fechar").click(function () { $("#showMercado").remove(); });
        return false;
    });

    //$("#formBusca").submit(function() { eval($("#q").val()); return false; } );

    $("#formIndique").submit(function()
            {
                $.post($(this).attr("action"), $(this).serialize()+"&indAjax=1",function(data){alert(data);});
                return false;
            });

    $(".acompanhe").change(acompanhamento);
});


function acompanhamento(){
	$.get(window.location+"","ajax_c&acompanhe="+($(this).attr("checked") ?1 :0)+"&codConteudo="+$("#codConteudo").val(),function(data){$(".acompanhe").attr('checked',data);})}

function scrollPos()
{
	var l, t;

	try
	{
		l = document.documentElement.scrollLeft;
		t = document.documentElement.scrollTop;
	}
	catch(e)
	{
		l = window.scrollX;
		t = window.scrollY;
	}

	return {sLeft: l, sTop:t};
}
function bodySize() {

  if( typeof( window.innerWidth ) == 'number' ) {
    //Non-IE
    myWidth = window.innerWidth;
    myHeight = window.innerHeight;
  } else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
    //IE 6+ in 'standards compliant mode'
    myWidth = document.documentElement.clientWidth;
    myHeight = document.documentElement.clientHeight;
  } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
    //IE 4 compatible
    myWidth = document.body.clientWidth;
    myHeight = document.body.clientHeight;
  }
  return myHeight;
}

function hideLayer(id)
{
	$("#"+id).hide();
}


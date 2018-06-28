$(document).ready( function() {

    /*
	 * Visualiza��o de respostas dos coment�rios em �rvore
	 */


	$('#listaDeComentarios a.respostas').live("click", function() {
		$(this).parent().parent().find('div.respostas').slideToggle();

		return false;
	});


	/*
	 * Exibi��o do formul�rio de resposta de coment�rio
	 */


	$('#listaDeComentarios a.responder').live("click", function() {
		$(this).parent().parent().find('.espacoResposta').append($('.formComentario')).hide().fadeIn();

		$('.formComentario .titulo h3').html('Responder coment&aacute;rio');
		$('.formComentario .submit').attr('value', 'Enviar resposta');
		$('.formComentario input[name="codComentarioAnterior"]').val($(this).attr('rel'));

		//alert($(window).height());
		$('html, body').animate({
			scrollTop: ($('.formComentario .submit').offset().top - $(window).height() + 45)
		}, 500, function() {
			if($('.formComentario input[name="indStatusLogin"]').val() == '0') {
				$('.formComentario input[name="strNomeComentario"]').focus();
			}
		});
		return false;
	});


	/*
	 * A��o do cancelamento do formul�rio de resposta de coment�rio
	 */


	$('.formComentario a.cancelarResposta').live("click", function() {

		if($('.formComentario input[name="codComentarioAnterior"]').val() != '') {
			$('#blocoComentario').append($('#listaDeComentarios .formComentario')).hide().fadeIn();
		}

		$('.formComentario .titulo h3').html('O que voc&ecirc; achou deste artigo?');
		$('.formComentario .submit').attr('value', 'Enviar coment&aacute;rio');
		$('.formComentario input[name="codComentarioAnterior"]').val('');

		return false;
	});


	/*
	 * Aplica��o dos labels dos campos "T�tulo" e "Coment�rio" dentro dos pr�prios campos
	 */


	var $strComentario = $('.formComentario .strComentario');

	// T�tulo interno dos campos de coment�rio

    if($strComentario.val() == '' || $strComentario.val() == 'Mensagem') {
        $strComentario.addClass('vazio').val('Mensagem');
    }
    $strComentario.focus(function() {
        if($strComentario.hasClass('vazio')) {
            $strComentario.removeClass('vazio').val('');
        }
    });
    $strComentario.blur(function() {
        if($strComentario.val() == '') {
            $strComentario.addClass('vazio').val('Mensagem');
        }
    });
	
	/*
	 * A��o de verifica��o de conta
	 */
	 
	function verificarConta() {


		if($('.formComentario input[name="strEnderecoComentario"]').val() != '') {
		
			$('.formComentario .status').removeClass('alerta').addClass('carregando').html('');
			
			$.ajax({
				type: "POST",
				url: "/ajax_login.php",
				data: {'ajax': 1, 'strEmail': $('.formComentario input[name="strEnderecoComentario"]').val(), 'verificarConta': 1},
				dataType: 'json',
				success: function(data){
					if(data['contaExiste'] == true)
					{
						$('.formComentario .campoStrSenha').fadeIn().addClass('ativo');
						$('.formComentario .status').removeClass('alerta').removeClass('carregando').html('');
						
						if($('.formComentario input[name="indStatusLogin"]').val() == '0') {
							$('.formComentario input[name="indStatusEnvio"]').val('0');
						}
					}
					else
					{
						if(data['erro'] == 'emailInvalido')
						{
							$('.formComentario .campoStrSenha').hide().removeClass('ativo').find('input').val('');
							$('.formComentario .status').addClass('alerta').removeClass('carregando').html('Email inv&aacute;lido.');
							
							$('.formComentario input[name="indStatusEnvio"]').val('0');
						}
						else
						{
							$('.formComentario .campoStrSenha').hide().removeClass('ativo').find('input').val('');
							$('.formComentario .status').removeClass('alerta').removeClass('carregando').html('');
							
							$('.formComentario input[name="indStatusEnvio"]').val('1');
						}
					}
				}
			});
		
		}
	}


	/*
	 * A��o de login dentro do formul�rio de coment�rio
	 */


	function fazerLogin() {
		if($('.formComentario input[name="strEnderecoComentario"]').val() != '' && $('.formComentario input[name="strSenhaComentario"]').val() != '' && $('.formComentario input[name="indStatusLogin"]').val() == '0') {
			$('.formComentario .status').removeClass('alerta').addClass('carregando').html('');

			$.ajax({
				type: "POST",
				url: "/ajax_login.php",
				data: {'ajax': 1, 'strEmail': $('.formComentario input[name="strEnderecoComentario"]').val(), 'strSenha': $('.formComentario input[name="strSenhaComentario"]').val(), 'indLogin': 1},
				dataType: 'json',
				success: function(data){
					if(data['estaLogado'] == true) {
						$('.formComentario input[name="indStatusLogin"]').val('1');
						$('.formComentario input[name="indStatusEnvio"]').val('1');
						$('.formComentario .avisoLogin').hide();
						$('.formComentario .status').removeClass('carregando').removeClass('alerta').html('');
						$('.formComentario .login').hide().html('<div class="status externo"></div><div class="dados">Usu&aacute;rio<br /><strong>'+ data['nome']+'</strong></div><div class="dados">E-mail:<br />'+data['email']+'</div>').fadeIn();
						
					} else {
						$('.formComentario input[name="indStatusLogin"]').val('0');
						$('.formComentario input[name="indStatusEnvio"]').val('0');

						if(data['erro'] == 'dadosIncorretos')
						{
							$('.formComentario .status').removeClass('carregando').addClass('alerta').html('Senha incorreta.');
						}
						else if(data['erro'] == 'semCadastro')
						{
							verificarConta();
						}
						else if(data['erro'] == 'emailInvalido')
						{
							$('.formComentario .status').removeClass('carregando').addClass('alerta').html('Email inv&aacute;lido.');
						}
					}
				}
			});
		}
	}
	
	$('.formComentario input[name="strEnderecoComentario"]').live("change", verificarConta);

	$('.formComentario input[name="strEnderecoComentario"], .formComentario input[name="strSenhaComentario"]').live("change", fazerLogin);


	/*
	 * Envio do coment�rio
	 */

	$('#formComentario').live("submit", function() {
		$('#formComentario .submit').attr('disabled', false);
		$('.formComentario .status').removeClass('carregando').removeClass('alerta').html('');
	
		if($('.formComentario input[name="strNomeComentario"]').val() == '') {
			$('.formComentario .status').removeClass('carregando').addClass('alerta').html('Dados obrigat&oacute;rios.');
			return false;
		}
		if($('.formComentario input[name="indStatusEnvio"]').val() == '0') {
			$('.formComentario .status').removeClass('carregando').addClass('alerta').html('Dados obrigat&oacute;rios.');
			return false;
		}

        if($strComentario.hasClass('vazio')) {
            $('.formComentario .status').removeClass('carregando').addClass('alerta').html('A mensagem &eacute; obrigat&oacute;ria.');
            return false;
        }

        $('#formComentario .submit').attr('disabled', true);
        $.ajax({
			type: "POST",
			url: $(this).attr("action"),
			data: $(this).serialize()+"&ajax=1",
            dataType: 'json',
			success: function(data) {
				atualizarComentarios(data['htmlComentarios']);
                $('#comment-'+data['codComentario']).hide().fadeIn('slow');
			}
		});
		return false;
	});

    function atualizarComentarios(data) {
        $('#comentarios').html(data);
        //atualizarTituloInternoCamposComentario();
    }

});
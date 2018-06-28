$(document).ready( function() {

    prettyPrint();

    /*
     * Exibição de todos os artigos do mesmo autor
     */

    $('#outrosArtigos .verMais').click(function() {
        $.ajax({
            type: "POST",
            url: "/conteudo_artigo.php",
            data: {'ajax': 1, 'ajaxOpt': 'outrosArtigos', 'codUsuario': $(this).attr('rel'), 'codConteudo': $('#codConteudo').val()},
            dataType: 'json',
            success: function(data){
                $('#outrosArtigos ul').addClass('expandido');
                $('#outrosArtigos .verMais').hide();
                $('#outrosArtigos ul').html('');
                jQuery.each(data, function(i, val) {
                    $('#outrosArtigos ul').append('<li><a href="'+val['link']+'" title="'+val['titulo']+'">'+val['titulo']+'</a></li>');
                });
            }
        });

        return false;
    });

	

	
});
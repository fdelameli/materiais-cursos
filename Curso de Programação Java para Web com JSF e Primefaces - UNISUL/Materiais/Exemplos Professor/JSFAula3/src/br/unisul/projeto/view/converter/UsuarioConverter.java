package br.unisul.projeto.view.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unisul.projeto.core.entity.UsuarioEntity;
import br.unisul.projeto.view.backbean.SelecaoUsuarioBack;

@FacesConverter(value = "UsuarioConverter")
public class UsuarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
					UIComponent component, String value) {
		if(value != null && !value.equals("")){
			//Poderia buscar direto do banco de dados o objeto
			//UsuarioEntity usuario = buscaDoBancoPorId(Long.parseLong(value));

			//Maneira "alternativa" de buscar o objeto equivalente
			SelecaoUsuarioBack selecao = new SelecaoUsuarioBack();
			selecao.inicializar();
			List<UsuarioEntity> usuarios = selecao.getUsuarios();
			
			//Se for o usuario de id equivalente, retorna o objeto
			Long idSelecionado = Long.parseLong(value);
			for (UsuarioEntity usuarioEntity : usuarios) {
				if(usuarioEntity.getId() == idSelecionado){
					return usuarioEntity;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent component, Object value) {
		if(value != null && !value.equals(""))
			return ""+((UsuarioEntity)value).getId();
		else
			return null;
	}

}




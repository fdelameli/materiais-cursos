package br.unisul.projeto.view.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "EmailValidator")
public class EmailValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, 
			Object value)
			throws ValidatorException {

		String email = (String)value;
		Pattern mask = null;
		mask = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = mask.matcher(email);
		 
		if (!matcher.matches()) {
		FacesMessage message = new FacesMessage();
		message.setDetail("Inserir email valido");
		message.setSummary("Email não é valido");
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(message);
		}
		
	}

}

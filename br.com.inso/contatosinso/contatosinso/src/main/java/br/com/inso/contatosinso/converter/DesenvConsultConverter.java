package br.com.inso.contatosinso.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


import br.com.inso.contatosinso.modelo.DesenvConsult;
import br.com.inso.contatosinso.repositorio.DesenvConsults;



@FacesConverter(forClass = DesenvConsult.class)
public class DesenvConsultConverter implements Converter{

	@Inject
	private DesenvConsults desenvs;
	
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		DesenvConsult desen = null;	
		
		if (value != null) {
			
			int valor = Integer.valueOf(value);			
			desen = this.desenvs.porPk(valor);
			
			
		}
		return desen;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			int codigo = ((DesenvConsult) value).getId();
			return (codigo == 0 ? null : String.valueOf(codigo));
			
		}
		return "";
	}

}

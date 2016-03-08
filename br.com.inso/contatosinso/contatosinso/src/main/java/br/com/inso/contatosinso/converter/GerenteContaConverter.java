package br.com.inso.contatosinso.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.GerenteConta;
import br.com.inso.contatosinso.repositorio.GerentesContas;

@FacesConverter(forClass = GerenteConta.class)
public class GerenteContaConverter implements Converter 
{

	@Inject
	private GerentesContas gerentes;

	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		GerenteConta gerente = null;	
		
		if (value != null) {			
			int valor = Integer.valueOf(value);			
			gerente = this.gerentes.porPk(valor);		
		}
		return gerente;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			int codigo = ((GerenteConta) value).getIdGerente();
			return (codigo == 0 ? null : String.valueOf(codigo));			
		}
		return "";
	}

}

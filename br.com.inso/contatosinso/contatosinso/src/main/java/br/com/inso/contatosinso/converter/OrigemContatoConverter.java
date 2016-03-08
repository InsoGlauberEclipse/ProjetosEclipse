package br.com.inso.contatosinso.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.inso.contatosinso.modelo.OrigemContato;
import br.com.inso.contatosinso.repositorio.OrigemContatos;
import br.com.inso.contatosinso.util.Util;


@FacesConverter(forClass = OrigemContato.class)
public class OrigemContatoConverter implements Converter{

	@Inject
	private OrigemContatos contatosService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		OrigemContato origem = null;	
		
		if (value != null) {
			if (Util.tryParseInt(value))
			{
				int valor = Integer.valueOf(value);
				origem = this.contatosService.porPk(valor);
			}
			else
			{
			    origem = this.contatosService.porOrigemContato(value.trim());
			}
			
		}
		return origem;

	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		if (value != null) {
			int codigo = ((OrigemContato) value).getIdOrigemContato();
			return (codigo == 0 ? null : String.valueOf(codigo));			
		}
		return "";
	}

}

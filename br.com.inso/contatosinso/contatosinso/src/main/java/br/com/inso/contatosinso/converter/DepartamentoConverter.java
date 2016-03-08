package br.com.inso.contatosinso.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;



import br.com.inso.contatosinso.modelo.Departamento;
import br.com.inso.contatosinso.repositorio.Departamentos;


@FacesConverter(forClass = Departamento.class)
public class DepartamentoConverter implements Converter 
{
	
	@Inject
	private Departamentos depts;

	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		Departamento depto = null;	
		
		if (value != null) {
			
			int valor = Integer.valueOf(value);			
			depto = this.depts.porPk(valor);
			
			
		}
		return depto;


	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			int codigo = ((Departamento) value).getIdDepartamento();
			String retorno = (codigo == 0 ? null : String.valueOf(codigo));
			
			return retorno;
		}
		
		return "";

		
	}

}

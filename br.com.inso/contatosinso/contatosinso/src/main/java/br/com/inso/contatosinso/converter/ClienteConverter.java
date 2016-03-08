package br.com.inso.contatosinso.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.inso.contatosinso.modelo.Cliente;
import br.com.inso.contatosinso.repositorio.Clientes;




@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {
	
	
	@Inject
	private Clientes clientes;

	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Cliente cliente = null;	
		
		if (value != null) {
			
			Long valor = Long.valueOf(value);			
			cliente = this.clientes.porPk(valor);
//			System.out.println("Converter->Cliente->IdCliente:"+ cliente.getIdCliente());			
//			System.out.println("Converter->Cliente->Nome:"+ cliente.getRazaoSocial());
			
			
		}
		return cliente;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		
		
		
		if (value != null) {
			
//			System.out.println("Converter->getAsString->Value:"+ value.toString());
			
			Long codigo = ((Cliente) value).getIdCliente();
			return (codigo == null ? null : String.valueOf(codigo));			
			
		}
		
		return "";
	}
	
	

}

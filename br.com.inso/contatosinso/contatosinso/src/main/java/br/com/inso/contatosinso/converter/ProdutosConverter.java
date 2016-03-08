package br.com.inso.contatosinso.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.Produtos;
import br.com.inso.contatosinso.repositorio.Produtoss;

@FacesConverter(forClass = Produtos.class)
public class ProdutosConverter implements Converter {
	
	
	
	@Inject
	private Produtoss produtos;

	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		Produtos produto = null;	
		
		if (value != null) {
			
			int valor = Integer.valueOf(value);			
			produto = this.produtos.porPk(valor);
//			System.out.println("Converter->Cliente->IdCliente:"+ cliente.getIdCliente());			
//			System.out.println("Converter->Cliente->Nome:"+ cliente.getRazaoSocial());
			
			
		}
		return produto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		if (value != null) {
			
//			System.out.println("Converter->getAsString->Value:"+ value.toString());
			
			int codigo = ((Produtos) value).getId();
			return (codigo == 0 ? null : String.valueOf(codigo));			
			
		}
		
		return "";
	}

}

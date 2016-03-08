package br.com.inso.contatosinso.servicos;

import java.io.Serializable;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.OrigemContato;
import br.com.inso.contatosinso.repositorio.OrigemContatos;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class OrigemContatoServico implements Serializable {


	private static final long serialVersionUID = 3165797450974462987L;
	
	
	@Inject
	private OrigemContatos contatos;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(OrigemContato origem)
	{
		contatos.guardar(origem);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(OrigemContato origem)
	{
		contatos.remover(origem);
	}
	
	
}

package br.com.inso.contatosinso.servicos;

import java.io.Serializable;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.Linguagem;
import br.com.inso.contatosinso.repositorio.Linguagens;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class LinguagemServico implements Serializable {


	private static final long serialVersionUID = 3165797450974462987L;
	
	
	@Inject
	private Linguagens linguagens;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Linguagem linguagem)
	{
		linguagens.guardar(linguagem);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Linguagem linguagem)
	{
		linguagens.remover(linguagem);
	}
	
	
}

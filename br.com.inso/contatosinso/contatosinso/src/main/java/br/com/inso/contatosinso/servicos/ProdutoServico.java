package br.com.inso.contatosinso.servicos;

import java.io.Serializable;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.Produtos;
import br.com.inso.contatosinso.repositorio.Produtoss;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class ProdutoServico implements Serializable {


	private static final long serialVersionUID = 3939007801108553806L;

	@Inject
	private Produtoss produtos;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Produtos produto)
	{
		produtos.guardar(produto);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Produtos produto)
	{
		produtos.remover(produto);
	}
	
	
}

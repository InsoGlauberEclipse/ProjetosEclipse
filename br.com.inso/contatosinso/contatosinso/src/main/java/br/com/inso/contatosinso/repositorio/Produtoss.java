package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.inso.contatosinso.modelo.Produtos;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class Produtoss implements Serializable  {

	
	private static final long serialVersionUID = 6315055182499542031L;
	
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Produtos porPk(int id) {
		return manager.find(Produtos.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Produtos> todas() {
		return manager.createQuery("from Produtos order by Produto", Produtos.class).getResultList();
	}


	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Linguagem Objeto a ser persistido. 
     */
	
	public Produtos guardar(Produtos produto) {
		return manager.merge(produto);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Linguagem Objeto a ser removido. 
     */
	
	public void remover(Produtos produto) {
		produto = porPk(produto.getId());
		manager.remove(produto);
	}
	
	
}

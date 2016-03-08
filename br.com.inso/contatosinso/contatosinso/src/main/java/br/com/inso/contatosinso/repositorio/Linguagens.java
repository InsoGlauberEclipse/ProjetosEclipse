package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.inso.contatosinso.modelo.Linguagem;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class Linguagens implements Serializable  {

	private static final long serialVersionUID = 5624857272850678478L;

	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Linguagem porPk(int id) {
		return manager.find(Linguagem.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Linguagem> todas() {
		return manager.createQuery("from Linguagem", Linguagem.class).getResultList();
	}

    /*
     * Retorna o próximo valor para ser utilizado em operação de insert.
     * 
     * @return Próximo valor. 
     */
	
	public int proximoPkAutoIncremento() 
	{
		return (Integer) manager.createQuery("select max(l.IdLinguagem) + 1 from Linguagem l").getSingleResult();		
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Linguagem Objeto a ser persistido. 
     */
	
	public Linguagem guardar(Linguagem linguagem) {
		return manager.merge(linguagem);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Linguagem Objeto a ser removido. 
     */
	
	public void remover(Linguagem linguagem) {
		linguagem = porPk(linguagem.getIdLinguagem());
		manager.remove(linguagem);
	}
	
	
}

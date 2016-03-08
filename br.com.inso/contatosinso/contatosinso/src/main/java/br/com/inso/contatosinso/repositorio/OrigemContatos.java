package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.inso.contatosinso.modelo.OrigemContato;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class OrigemContatos implements Serializable  {

	private static final long serialVersionUID = 7704139639010254995L;
	
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public OrigemContato porPk(int id) {
		return manager.find(OrigemContato.class, id);
	}
	
    /*
     * Retorna um objeto com base na pesquisa pelo campo descrição.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public OrigemContato porOrigemContato(String origem) 
	{
		Query query = manager.createQuery("from OrigemContato where OrigemContato = '" + origem +"'", OrigemContato.class);
		//query.setParameter("origemcontato", origem.trim());
		
		OrigemContato gambiarra = (OrigemContato) query.getSingleResult();
		
		return porPk(gambiarra.getIdOrigemContato());
		
	}

	
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<OrigemContato> todas() {
		return manager.createQuery("from OrigemContato", OrigemContato.class).getResultList();
	}

    /*
     * Retorna o próximo valor para ser utilizado em operação de insert.
     * 
     * @return Próximo valor. 
     */
	
	public int proximoPkAutoIncremento() 
	{
		return (Integer) manager.createQuery("select max(o.IdOrigemContato) + 1 from OrigemContato o").getSingleResult();		
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Linguagem Objeto a ser persistido. 
     */
	
	public OrigemContato guardar(OrigemContato origem) {
		return manager.merge(origem);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Linguagem Objeto a ser removido. 
     */
	
	public void remover(OrigemContato origem) {
		origem = porPk(origem.getIdOrigemContato());
		manager.remove(origem);
	}
	
	
}

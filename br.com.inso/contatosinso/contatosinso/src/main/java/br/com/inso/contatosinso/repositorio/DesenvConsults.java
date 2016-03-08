package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.com.inso.contatosinso.modelo.DesenvConsult;

public class DesenvConsults implements Serializable {
	
	

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7871391327450808631L;
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public DesenvConsult porPk(int id) {
		return manager.find(DesenvConsult.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<DesenvConsult> todas() {
		return manager.createQuery("from DesenvConsult", DesenvConsult.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<DesenvConsult> todasOrdenadoPorNome() {
		return manager.createQuery("from DesenvConsult order by nome", DesenvConsult.class).getResultList();
	}
	
	
    /*
     * Retorna uma lista com todos os registros da tabela ordernada pelo nome.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<DesenvConsult> todasPorNome() {
		return manager.createQuery("from DesenvConsult order by Nome", DesenvConsult.class).getResultList();
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Cargo Objeto a ser persistido. 
     */
	
	public DesenvConsult guardar(DesenvConsult desenv) {
		return manager.merge(desenv);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Cargo Objeto a ser removido. 
     */
	
	public void remover(DesenvConsult desenv) {
		desenv = porPk(desenv.getId());
		manager.remove(desenv);
	}
	

}

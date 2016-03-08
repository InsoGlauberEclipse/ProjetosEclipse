package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.com.inso.contatosinso.modelo.Status;

public class Estatus implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7025724726832511154L;

	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Status porPk(int id) {
		return manager.find(Status.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Status> todas() {
		return manager.createQuery("from Status", Status.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Status> todasOrdenadoPorDescricao() {
		return manager.createQuery("from Status order by Descricao", Status.class).getResultList();
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser persistido. 
     */
	
	public Status guardar(Status stat) {
		return manager.merge(stat);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser removido. 
     */
	
	public void remover(Status stat) {
		stat = porPk(stat.getIdStatus());
		manager.remove(stat);
	}
	
	
	
}

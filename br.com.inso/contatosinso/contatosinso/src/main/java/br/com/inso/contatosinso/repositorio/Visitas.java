package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.inso.contatosinso.modelo.Visita;
import br.com.inso.contatosinso.util.jpa.Transacional;

public class Visitas implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1523994409411439701L;

	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Visita porPk(Long id) {
		return manager.find(Visita.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Visita> todas() {
		return manager.createQuery("from Visita v inner join fetch v.cliente c inner join fetch v.produto p  inner join fetch v.funcionario f ", Visita.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Visita> todasOrdenadoPorIdVisitaDecrecente() {
		return manager.createQuery("from Visita v inner join fetch v.cliente c inner join fetch v.produto p  inner join fetch v.funcionario f  order by IdVisita desc", Visita.class).getResultList();
	}

	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser persistido. 
     */
	
	@Transacional
	public Visita guardar(Visita visita) {
		return manager.merge(visita);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser removido. 
     */
	
	@Transacional
	public void remover(Visita visita) {
		visita = porPk(visita.getIdVisita());
		manager.remove(visita);
	}
	

	
}

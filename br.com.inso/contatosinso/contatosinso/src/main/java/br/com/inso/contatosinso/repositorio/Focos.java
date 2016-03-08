package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.inso.contatosinso.modelo.Foco;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class Focos implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4807713591383262965L;
	
	

	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Foco porPk(int id) {
		return manager.find(Foco.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Foco> todas() {
		return manager.createQuery("from Foco", Foco.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Foco> todasOrdenadoPorFoco() {
		return manager.createQuery("from Foco order by Foco", Foco.class).getResultList();
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Cargo Objeto a ser persistido. 
     */
	
	public Foco guardar(Foco foco) {
		return manager.merge(foco);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Cargo Objeto a ser removido. 
     */
	
	public void remover(Foco foco) {
		foco = porPk(foco.getIdFoco());
		manager.remove(foco);
	}
	
	
}

package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.inso.contatosinso.modelo.Cargo;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class Cargos implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1438502135255291990L;

	
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Cargo porPk(int id) {
		return manager.find(Cargo.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Cargo> todas() {
		return manager.createQuery("from Cargos", Cargo.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Cargo> todasOrdernadoPorCargo() {
		return manager.createQuery("from Cargos order by Cargo", Cargo.class).getResultList();
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Cargo Objeto a ser persistido. 
     */
	
	public Cargo guardar(Cargo cargo) {
		return manager.merge(cargo);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Cargo Objeto a ser removido. 
     */
	
	public void remover(Cargo cargo) {
		cargo = porPk(cargo.getIdCargo());
		manager.remove(cargo);
	}
	
	
}

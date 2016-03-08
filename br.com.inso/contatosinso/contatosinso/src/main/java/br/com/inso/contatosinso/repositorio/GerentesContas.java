package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.com.inso.contatosinso.modelo.GerenteConta;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class GerentesContas implements Serializable  {

	private static final long serialVersionUID = -3326871781492814486L;

	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public GerenteConta porPk(int id) {
		return manager.find(GerenteConta.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<GerenteConta> todas() {
		return manager.createQuery("from GerenteConta", GerenteConta.class).getResultList();
	}

	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Cargo Objeto a ser persistido. 
     */
	
	public GerenteConta guardar(GerenteConta gerente) {
		return manager.merge(gerente);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Cargo Objeto a ser removido. 
     */
	
	public void remover(GerenteConta gerente) {
		gerente = porPk(gerente.getIdGerente());
		manager.remove(gerente);
	}
	
	
}

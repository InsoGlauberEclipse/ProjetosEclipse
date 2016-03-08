package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.inso.contatosinso.modelo.RamoAtividade;

public class RamosAtividades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6198030351183810140L;
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public RamoAtividade porPk(int id) {
		return manager.find(RamoAtividade.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<RamoAtividade> todas() {
		return manager.createQuery("from RamosAtividade", RamoAtividade.class).getResultList();
	}

	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param RamoAtividade Objeto a ser persistido. 
     */
	
	public RamoAtividade guardar(RamoAtividade atividade) {
		return manager.merge(atividade);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param RamoAtividade Objeto a ser persistido. 
     */
	
	public void remover(RamoAtividade atividade) {
		atividade = porPk(atividade.getIdAtividade());
		manager.remove(atividade);
	}
	
	

}

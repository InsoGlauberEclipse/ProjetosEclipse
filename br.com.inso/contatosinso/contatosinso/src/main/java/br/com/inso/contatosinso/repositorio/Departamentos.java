package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.inso.contatosinso.modelo.Departamento;



/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class Departamentos implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6478751642145360804L;
	
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Departamento porPk(int id) {
		return manager.find(Departamento.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Departamento> todas() {
		return manager.createQuery("from Departamento", Departamento.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Departamento> todasOrdernadoPorDepartamento() {
		return manager.createQuery("from Departamento order by Departamento", Departamento.class).getResultList();
	}
	
	
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Departamento> todosPorDepartamento() {
		return manager.createQuery("from Departamento order by Departamento", Departamento.class).getResultList();
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Cargo Objeto a ser persistido. 
     */
	
	public Departamento guardar(Departamento dep) {
		return manager.merge(dep);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Cargo Objeto a ser removido. 
     */
	
	public void remover(Departamento dep) {
		dep = porPk(dep.getIdDepartamento());
		manager.remove(dep);
	}
	
	
}

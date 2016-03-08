package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.inso.contatosinso.modelo.AmbienteOperacional;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class AmbientesOperacionais implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1281221294185293436L;
	
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public AmbienteOperacional porPk(Long id) {
		return manager.find(AmbienteOperacional.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<AmbienteOperacional> todas() {
		return manager.createQuery("from AmbienteOperacional", AmbienteOperacional.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<AmbienteOperacional> todasOrdenadoPorAmbiente() {
		return manager.createQuery("from AmbienteOperacional order by Ambiente", AmbienteOperacional.class).getResultList();
	}

	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param ambiente Objeto a ser persistido. 
     */
	
	public AmbienteOperacional guardar(AmbienteOperacional ambiente) {
		return manager.merge(ambiente);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param ambiente Objeto a ser removido. 
     */
	
	public void remover(AmbienteOperacional ambiente) {
		ambiente = porPk(ambiente.getIdAmbiente());
		manager.remove(ambiente);
	}
	
	
}

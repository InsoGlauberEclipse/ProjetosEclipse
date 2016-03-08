package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.inso.contatosinso.modelo.Aplicacao;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */
public class Aplicacoes implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1535517784016940696L;
	
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Aplicacao porPk(int id) {
		return manager.find(Aplicacao.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Aplicacao> todas() {
		return manager.createQuery("from Aplicacao", Aplicacao.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Aplicacao> todasOrdenadoPorDescricao() {
		return manager.createQuery("from Aplicacao order by Descricao", Aplicacao.class).getResultList();
	}

	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser persistido. 
     */
	
	public Aplicacao guardar(Aplicacao aplicacao) {
		return manager.merge(aplicacao);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser removido. 
     */
	
	public void remover(Aplicacao aplicacao) {
		aplicacao = porPk(aplicacao.getIdAplicacao());
		manager.remove(aplicacao);
	}
	
	
}

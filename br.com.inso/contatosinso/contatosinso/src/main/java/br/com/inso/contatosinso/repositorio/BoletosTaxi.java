package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.inso.contatosinso.modelo.BoletoTaxi;

/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */

public class BoletosTaxi implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6299352618471447085L;

	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public BoletoTaxi porPk(String id) {
		return manager.find(BoletoTaxi.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<BoletoTaxi> todosBoletosIdBoletoDesc() {
		return manager.createQuery("from BoletoTaxi order by IdBoleto Desc", BoletoTaxi.class).getResultList();
	}

    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<BoletoTaxi> todosBoletosIdBoletoAsc() {
		return manager.createQuery("from BoletoTaxi order by IdBoleto Desc", BoletoTaxi.class).getResultList();
	}

	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser persistido. 
     */
	
	public BoletoTaxi guardar(BoletoTaxi boleto) {
		return manager.merge(boleto);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param aplicacao Objeto a ser removido. 
     */
	
	public void remover(BoletoTaxi boleto) {
		boleto = porPk(boleto.getIdBoleto());
		manager.remove(boleto);
	}
	

	
	
}

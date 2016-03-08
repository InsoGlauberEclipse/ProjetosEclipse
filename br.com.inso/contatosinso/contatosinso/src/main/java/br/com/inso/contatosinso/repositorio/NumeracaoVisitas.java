package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.inso.contatosinso.modelo.NumeracaoVisita;

public class NumeracaoVisitas implements Serializable   {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6095345976458652970L;

	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public NumeracaoVisita porPk(Long id) {
		return manager.find(NumeracaoVisita.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<NumeracaoVisita> todasNumeracoes() {
		return manager.createQuery("from NumeracaoVisita n order by n.Ano ", NumeracaoVisita.class).getResultList();
	}

	
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Cargo Objeto a ser persistido. 
     */
	
	public NumeracaoVisita guardar(NumeracaoVisita numeracao) {
		return manager.merge(numeracao);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Cargo Objeto a ser removido. 
     */
	
	public void remover(NumeracaoVisita numeracao) {
		numeracao = porPk(numeracao.getAno());
		manager.remove(numeracao);
	}
	
	

}

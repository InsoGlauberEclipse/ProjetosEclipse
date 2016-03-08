package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.inso.contatosinso.modelo.Aplicacao;
import br.com.inso.contatosinso.repositorio.Aplicacoes;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class AplicacaoServico implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -6627769174597164285L;
	
	
	@Inject
	private Aplicacoes apps;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Aplicacao app)
	{
		apps.guardar(app);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Aplicacao app)
	{
		apps.remover(app);
	}
	
	
}

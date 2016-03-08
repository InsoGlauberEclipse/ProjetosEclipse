package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;


import br.com.inso.contatosinso.modelo.Status;
import br.com.inso.contatosinso.repositorio.Estatus;
import br.com.inso.contatosinso.util.jpa.Transacional;

public class EstatusServico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6806021518427552759L;

	@Inject
	private Estatus estat;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Status stat)
	{
		estat.guardar(stat);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Status stat)
	{
		estat.remover(stat);
	}
	
	
	
}

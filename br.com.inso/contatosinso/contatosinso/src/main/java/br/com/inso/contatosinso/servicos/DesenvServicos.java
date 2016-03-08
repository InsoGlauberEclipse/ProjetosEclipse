package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;


import br.com.inso.contatosinso.modelo.DesenvConsult;

import br.com.inso.contatosinso.repositorio.DesenvConsults;
import br.com.inso.contatosinso.util.jpa.Transacional;

public class DesenvServicos implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4585932950122118636L;
	@Inject
	private DesenvConsults desenvs;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(DesenvConsult desenv)
	{
		desenvs.guardar(desenv);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(DesenvConsult desenv)
	{
		desenvs.remover(desenv);
	}
	
	
	

}

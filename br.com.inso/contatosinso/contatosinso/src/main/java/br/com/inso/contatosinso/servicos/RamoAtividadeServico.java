package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;


import br.com.inso.contatosinso.modelo.RamoAtividade;

import br.com.inso.contatosinso.repositorio.RamosAtividades;
import br.com.inso.contatosinso.util.jpa.Transacional;

public class RamoAtividadeServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3630001451320854430L;

	
	@Inject
	private RamosAtividades ramos;

	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(RamoAtividade ramo)
	{
		ramos.guardar(ramo);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(RamoAtividade ramo)
	{
		ramos.remover(ramo);
	}
	
	
}

package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.inso.contatosinso.modelo.Cargo;
import br.com.inso.contatosinso.repositorio.Cargos;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class CargoServico implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -6627769174597164285L;
	
	
	@Inject
	private Cargos cargos;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Cargo cargo)
	{
		cargos.guardar(cargo);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Cargo cargo)
	{
		cargos.remover(cargo);
	}
	
	
}

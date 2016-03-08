package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;


import br.com.inso.contatosinso.modelo.BoletoTaxi;
import br.com.inso.contatosinso.repositorio.BoletosTaxi;
import br.com.inso.contatosinso.util.jpa.Transacional;


/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class BoletosTaxiServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7166258107670817710L;
	
	@Inject
	BoletosTaxi boletosService;
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(BoletoTaxi boleto)
	{
		boletosService.guardar(boleto);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(BoletoTaxi boleto)
	{
		boletosService.remover(boleto);
	}
	
	

}

package br.com.inso.contatosinso.servicos;

import java.io.Serializable;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.GerenteConta;
import br.com.inso.contatosinso.repositorio.GerentesContas;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class GerenteContaServico implements Serializable {


	private static final long serialVersionUID = 3324752432526738458L;

	
	@Inject
	private GerentesContas gerentes;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(GerenteConta gerente)
	{
		gerentes.guardar(gerente);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(GerenteConta gerente)
	{
		gerentes.remover(gerente);
	}
	
	
}

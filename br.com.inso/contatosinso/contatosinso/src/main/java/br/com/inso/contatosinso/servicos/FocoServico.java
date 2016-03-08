package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;


import br.com.inso.contatosinso.modelo.Foco;
import br.com.inso.contatosinso.repositorio.Focos;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class FocoServico implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5211857103843125443L;

	
	@Inject
	private Focos focos;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Foco foco)
	{
		focos.guardar(foco);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Foco foco)
	{
		focos.remover(foco);
	}
	
	
}

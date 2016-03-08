package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.inso.contatosinso.modelo.AmbienteOperacional;
import br.com.inso.contatosinso.repositorio.AmbientesOperacionais;
import br.com.inso.contatosinso.util.jpa.Transacional;


/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class AmbienteOperacionalServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -293337368458753997L;

	
	@Inject
	private AmbientesOperacionais ambientes;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(AmbienteOperacional ambiente)
	{
		ambientes.guardar(ambiente);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(AmbienteOperacional ambiente)
	{
		ambientes.remover(ambiente);
	}
	
	
}

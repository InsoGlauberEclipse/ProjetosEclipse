package br.com.inso.contatosinso.servicos;

import java.io.Serializable;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.Departamento;
import br.com.inso.contatosinso.repositorio.Departamentos;
import br.com.inso.contatosinso.util.jpa.Transacional;

/*
 * 
 * Classe que consiste na camada de regra de negócio.
 *  
 */

public class DepartamentoServico implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6635182150962903777L;
	
	
	
	@Inject
	private Departamentos deptos;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Departamento depto)
	{
		deptos.guardar(depto);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Departamento depto)
	{
		deptos.remover(depto);
	}
	
	
}

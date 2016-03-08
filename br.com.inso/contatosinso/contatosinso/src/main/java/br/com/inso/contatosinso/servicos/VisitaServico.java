package br.com.inso.contatosinso.servicos;

import java.io.Serializable;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.Visita;
import br.com.inso.contatosinso.repositorio.Visitas;


public class VisitaServico implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2927234147169317245L;
	
	@Inject
	private Visitas visitas;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	
	public void salvar(Visita visita)
	{
		visitas.guardar(visita);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	
	public void excluir(Visita visita)
	{
		visitas.remover(visita);
	}
	


}

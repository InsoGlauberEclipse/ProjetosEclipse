package br.com.inso.contatosinso.servicos;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.inso.contatosinso.modelo.Cliente;
import br.com.inso.contatosinso.repositorio.Clientes;
import br.com.inso.contatosinso.util.jpa.Transacional;

public class ClientesServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3788642549014789942L;
	
	@Inject
	private Clientes clientes;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(Cliente cli)
	{
		clientes.guardar(cli);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(Cliente cli)
	{
		clientes.remover(cli);
	}
	
	
	

}

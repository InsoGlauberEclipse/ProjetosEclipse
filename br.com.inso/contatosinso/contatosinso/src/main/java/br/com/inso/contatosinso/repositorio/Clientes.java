package br.com.inso.contatosinso.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.inso.contatosinso.modelo.Cliente;
import br.com.inso.contatosinso.util.jpa.Transacional;


/*
 * 
 * Classe responsável pela operações com a tabela.
 * 
 */

public class Clientes implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7471027883029680037L;
	
	@Inject
	private EntityManager manager;
	
    /*
     * Retorna um objeto com base na pesquisa pela chave primária.
     * 
     * @return Objeto resultado da pesquisa. 
     */
	public Cliente porPk(Long id) {
		return manager.find(Cliente.class, id);
	}
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Cliente> todosClientes() {
		return manager.createQuery("from Clientes c inner join fetch c.gerenteconta g   ", Cliente.class).getResultList();
	}

	
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Cliente> todosClientesOrdenadoPorRazaoSocial() 
	{
		
		// 
		//return manager.createQuery("from Clientes c inner join fetch c.gerenteconta g  where c.IdCliente = 30111 order by c.RazaoSocial ", Cliente.class).getResultList();
	  return manager.createQuery("from Clientes c inner join fetch c.gerenteconta g  order by c.RazaoSocial ", Cliente.class).getResultList();
	}
	
	
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Cliente> todasAtivosOrdernadoPorRazaoSocial() {
		return manager.createQuery("from Clientes c  inner join fetch c.gerenteconta g  where c.FlAtivo = 'S' or c.FlAtivo = 'Y'  order by c.RazaoSocial", Cliente.class).getResultList();
	}
	
	
    /*
     * Retorna uma lista com todos os registros da tabela.
     * 
     * @return Lista com todos os objetos. 
     */
	
	public List<Cliente> todosAtivosPorIdCliente() {
		return manager.createQuery("from Clientes c where c.FlAtivo = 'S' or c.FlAtivo = 'Y' order by c.IdCliente", Cliente.class).getResultList();
	}
	
	
	/*
     * Efetiva a gravação de um objeto na tabela.
     * 
     * @param Cargo Objeto a ser persistido. 
     */
	@Transacional	
	public Cliente guardar(Cliente cli) {
//		manager.persist(cli);
//		return cli;
		return manager.merge(cli);
	}

	/*
     * Remove um objeto na tabela.
     * 
     * @param Cargo Objeto a ser removido. 
     */
	
	public void remover(Cliente cli) {
		cli = porPk(cli.getIdCliente());
		manager.remove(cli);
	}
	
	
	

}

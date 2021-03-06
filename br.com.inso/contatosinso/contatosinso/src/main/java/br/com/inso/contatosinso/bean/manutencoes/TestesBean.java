package br.com.inso.contatosinso.bean.manutencoes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;






import br.com.inso.contatosinso.modelo.Cliente;
//import br.com.inso.contatosinso.modelo.Departamento;
//import br.com.inso.contatosinso.modelo.DesenvConsult;


import br.com.inso.contatosinso.modelo.GerenteConta;
import br.com.inso.contatosinso.modelo.OrigemContato;
import br.com.inso.contatosinso.repositorio.Clientes;
//import br.com.inso.contatosinso.repositorio.Departamentos;
//import br.com.inso.contatosinso.repositorio.DesenvConsults;
import br.com.inso.contatosinso.repositorio.GerentesContas;
import br.com.inso.contatosinso.repositorio.OrigemContatos;
import br.com.inso.contatosinso.util.FacesMessages;

/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("TestesBean")
@ViewScoped

public class TestesBean implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 9051458221384951498L;
	
	// Injeção de dependencia das classes necessária
	
//	@Inject
//	private Departamentos departs;

	
//	@Inject
//	private DesenvConsults desenvs;

	@Inject
	private GerentesContas gerentes;	
	
	@Inject
	private Clientes clientes;

	@Inject
	private FacesMessages messages;
	
	@Inject
	private OrigemContatos origemService;
	
	
	
	
	private Cliente objetoEdicao = new Cliente();
	private Cliente objetoSelecionado;
	
//	private List<DesenvConsult> todosDesenvolvedores;
//	private List<Departamento> todosDepartamentos;

	// Listas para grid e combos
	
	private List<GerenteConta> todosGerentes;
	private List<Cliente> todosClientes;
	private List<OrigemContato> todasOrigens;
	
	

	
	/*
	 * Preencher o combo com os dados da Origem de Conta.
	 * 
	 */
	public List<OrigemContato> getTodasOrigens() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todasOrigens = origemService.todas();
		}
		return todasOrigens;
	}

	
	
	/*
	 * Preencher o combo com os dados dos Gerentes de Conta.
	 * 
	 */
	public List<GerenteConta> getTodosGerentes() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosGerentes = gerentes.todas();
		}
		return todosGerentes;
	}

	

	
	
	/*
	 * Preencher o combo com os dados dos Departamentos.
	 * 
	 */
/*	
	public List<Departamento> getTodosDepartamentos() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosDepartamentos = departs.todosPorDepartamento();
		}
		return todosDepartamentos;
	}
*/
	
	/*
	 * Preencher o combo com os dados dos Funcionarios.
	 * 
	 */
/*	
	public List<DesenvConsult> getTodosFuncionarios() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosDesenvolvedores = desenvs.todasPorNome();
		}
		return todosDesenvolvedores;
	}
*/


	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		objetoEdicao = new Cliente();
		objetoEdicao.setIdCliente(0L);
		
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		clientes.guardar(objetoEdicao);
		

		consultar();
/*		
        System.out.println("ObjetoEdicao:" + objetoEdicao.toString());	
        
*/        
		
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Boletos-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {

		if (null != objetoEdicao)
		{
			clientes.remover(objetoEdicao);
			consultar();
			messages.info("Registro excluído com sucesso!");
		}
				
		objetoEdicao = null;		
		
		
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	/**
	 * @return the todosClientes
	 */
	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}


	public void consultar() {

		todosClientes = clientes.todosClientesOrdenadoPorRazaoSocial();
		
		
		
	}

	/**
	 * @return the objetoEdicao
	 */
	public Cliente getObjetoEdicao() {
		return objetoEdicao;
	}

	/**
	 * @param objetoEdicao the objetoEdicao to set
	 */
	public void setObjetoEdicao(Cliente objetoEdicao) {
		this.objetoEdicao = objetoEdicao;
	}

	/**
	 * @return the objetoSelecionado
	 */
	public Cliente getObjetoSelecionado() {
		return objetoSelecionado;
	}

	/**
	 * @param objetoSelecionado the objetoSelecionado to set
	 */
	public void setObjetoSelecionado(Cliente objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}




}

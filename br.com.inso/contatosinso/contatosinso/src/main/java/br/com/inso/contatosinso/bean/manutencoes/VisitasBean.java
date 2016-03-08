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
import br.com.inso.contatosinso.modelo.DesenvConsult;
import br.com.inso.contatosinso.modelo.Produtos;
import br.com.inso.contatosinso.modelo.Visita;
import br.com.inso.contatosinso.repositorio.Clientes;
import br.com.inso.contatosinso.repositorio.DesenvConsults;
import br.com.inso.contatosinso.repositorio.Produtoss;
import br.com.inso.contatosinso.repositorio.Visitas;
import br.com.inso.contatosinso.servicos.NumeracaoVisitaServico;
import br.com.inso.contatosinso.servicos.VisitaServico;
import br.com.inso.contatosinso.util.FacesMessages;

@Named("VisitasBean")
@ViewScoped
public class VisitasBean implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2312346794388187135L;

	// Injeção dos objetos principais
	
	
	@Inject
	private VisitaServico visitaServico;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	NumeracaoVisitaServico numeracaoServico;
	
	@Inject
	Visitas visitasConsultas;

	
	// Injeção dos serviços para chamada das consultas com o objetivo de montar os combos
	
	
	@Inject
	private Clientes clientesConsultas;
	
	@Inject Produtoss produtoConsultas;
	
	@Inject
	private DesenvConsults desenvConsultas;

	
	// Lista para alimentar os combos
	
	
	private List<Cliente> todosClientes;
	private List<Produtos> todosProdutos;
	private List<DesenvConsult> todosDesenv;
	
	
	// Objeto de Edição e Seleção
	
	
	private Visita objetoEdicao = new Visita();
	private Visita objetoSelecionado;
	
	
	// Lista de Visitas
	
	private List<Visita> todasVisitas;
	
	
	
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() 
	{
		System.out.println("Entrou no metodo prepararNovoCadastro().");
		
		objetoEdicao = new Visita();
		objetoEdicao.setIdVisita(0L);
		objetoEdicao.setRelatorioNumero(numeracaoServico.getNumeroVisita());		
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		System.out.println("Entrou no metodo salvar.");
		
		if (null == objetoEdicao)
		{
			System.out.println("Objeto de Edição é nulo.");
		}
		
		System.out.println("Vai chamar salvar.");
		visitaServico.salvar(objetoEdicao);
		System.out.println("Vai chamar consultar.");
		consultar();		
		System.out.println("Vai retornar mensagem de sucesso.");
		
		messages.info("Registro salvo com sucesso!");		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Visitas-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {

		if (null != objetoEdicao)
		{
			visitaServico.excluir(objetoEdicao);
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
	 * @return the todasVisitas
	 */
	public List<Visita> getTodasVisitas() {
		return todasVisitas;
	}


	/*
	 * Preencher a grid principal e chamar os metodos de preenchimeto de listas para combos 
	 * 
	 */
	
	
	public void consultar() 
	{
		
		System.out.println("Entrou no metodo consultar().");
		
		todasVisitas = visitasConsultas.todasOrdenadoPorIdVisitaDecrecente();
		
		getTodosClientes();
		getTodosDesenvolv();
		getTodosProdutos();
		
	}

	
	/*
	 * Preencher o combo com os dados de clientes.
	 * 
	 */
	public List<Cliente> getTodosClientes() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosClientes = clientesConsultas.todasAtivosOrdernadoPorRazaoSocial();
		}
		return todosClientes;
	}

	

	/*
	 * Preencher o combo com os dados dos produtos.
	 * 
	 */
	public List<Produtos> getTodosProdutos() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosProdutos = produtoConsultas.todas();
		}
		return todosProdutos;
	}
	
	
	/*
	 * Preencher o combo com os dados dos Funcionarios.
	 * 
	 */
	public List<DesenvConsult> getTodosDesenvolv() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosDesenv = desenvConsultas.todas();
		}
		return todosDesenv;
	}
	
	
	
	
	// Get & Set de Objeto de edição e objeto de seleção
	
	/**
	 * @return the objetoEdicao
	 */
	public Visita getObjetoEdicao() {
		return objetoEdicao;
	}


	/**
	 * @param objetoEdicao the objetoEdicao to set
	 */
	public void setObjetoEdicao(Visita objetoEdicao) {
		this.objetoEdicao = objetoEdicao;
	}

	/**
	 * @return the objetoSelecionado
	 */
	public Visita getObjetoSelecionado() {
		return objetoSelecionado;
	}

	/**
	 * @param objetoSelecionado the objetoSelecionado to set
	 */
	public void setObjetoSelecionado(Visita objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}


	
	
}

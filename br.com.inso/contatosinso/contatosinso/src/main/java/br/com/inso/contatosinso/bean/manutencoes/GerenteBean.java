package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.GerenteConta;
import br.com.inso.contatosinso.repositorio.GerentesContas;
import br.com.inso.contatosinso.servicos.GerenteContaServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("GerenteBean")
@ViewScoped
public class GerenteBean implements Serializable {
	
	private static final long serialVersionUID = 6054319108067515826L;
	
	
	// Injeção de dependencia das classes necessária


	@Inject
	private GerentesContas gerentes;
	
	@Inject
	private GerenteContaServico cadastroGerente;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<GerenteConta> todosGerentes;
	private GerenteConta gerenteEdicao = new GerenteConta();
	private GerenteConta gerenteSelecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		gerenteEdicao = new GerenteConta();
		gerenteEdicao.setIdGerente(0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		cadastroGerente.salvar(gerenteEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Gerentes-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroGerente.excluir(gerenteSelecionado);
		gerenteSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosGerentes = gerentes.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosGerentes
	 */
	
	public List<GerenteConta> gettodosGerentes() {
		return todosGerentes;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return todosGerentes
	 */
	
	public GerenteConta getGerenteEdicao() {
		return gerenteEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param focoEdicao Objeto do tipo GerenteConta
	 */

	public void setGerenteEdicao(GerenteConta gerente) {
		this.gerenteEdicao = gerente;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return gerenteSelecionado
	 */

	public GerenteConta getGerenteSelecionado() {
		return gerenteSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param focoSelecionado Objeto do tipo GerenteConta
	 */

	public void setGerenteSelecionado(GerenteConta gerente) 
	{
		this.gerenteSelecionado = gerente;
	}

	

}

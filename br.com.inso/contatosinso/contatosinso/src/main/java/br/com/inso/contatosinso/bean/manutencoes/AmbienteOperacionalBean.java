package br.com.inso.contatosinso.bean.manutencoes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.inso.contatosinso.modelo.AmbienteOperacional;
import br.com.inso.contatosinso.repositorio.AmbientesOperacionais;
import br.com.inso.contatosinso.servicos.AmbienteOperacionalServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("AmbienteOperacionalBean")
@ViewScoped
public class AmbienteOperacionalBean implements Serializable {
	
	
	
	private static final long serialVersionUID = -2753615167662003330L;
	
	// Injeção de dependencia das classes necessária
	
	@Inject
	private AmbientesOperacionais ambientes;
	
	@Inject
	private AmbienteOperacionalServico cadastroAmbiente;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<AmbienteOperacional> todosAmbientes;
	private AmbienteOperacional ambienteEdicao = new AmbienteOperacional();
	private AmbienteOperacional ambienteSelecionado;
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		ambienteEdicao = new AmbienteOperacional();
		ambienteEdicao.setIdAmbiente((long) 0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		
		
		cadastroAmbiente.salvar(ambienteEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:AmbienteOperacionals-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroAmbiente.excluir(ambienteSelecionado);
		ambienteSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosAmbientes = ambientes.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosAmbientes
	 */
	
	public List<AmbienteOperacional> gettodosAmbientes() {
		return todosAmbientes;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return todosAmbientes
	 */
	
	public AmbienteOperacional getAmbienteEdicao() {
		return ambienteEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param ambienteEdicao Objeto do tipo AmbienteOperacional
	 */

	public void setAmbienteEdicao(AmbienteOperacional ambienteEdicao) {
		this.ambienteEdicao = ambienteEdicao;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return ambienteSelecionado
	 */

	public AmbienteOperacional getAmbienteSelecionado() {
		return ambienteSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param ambienteSelecionado Objeto do tipo AmbienteOperacional
	 */

	public void setAmbienteSelecionado(AmbienteOperacional ambienteSelecionado) {
		this.ambienteSelecionado = ambienteSelecionado;
	}

	/**
	 * 
	 * Retorna todos os ambientes.
	 * 
	 * @return the todosAmbientes
	 */
	public List<AmbienteOperacional> getTodosAmbientes() {
		return todosAmbientes;
	}
	

	
	

}

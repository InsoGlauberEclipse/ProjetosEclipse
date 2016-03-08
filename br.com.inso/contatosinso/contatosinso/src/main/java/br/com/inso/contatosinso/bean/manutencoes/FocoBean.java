package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.Foco;
import br.com.inso.contatosinso.repositorio.Focos;
import br.com.inso.contatosinso.servicos.FocoServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("FocoBean")
@ViewScoped
public class FocoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -20371034876188265L;
	
	
	// Injeção de dependencia das classes necessária


	@Inject
	private Focos focos;
	
	@Inject
	private FocoServico cadastroFoco;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Foco> todosFocos;
	private Foco focoEdicao = new Foco();
	private Foco focoSelecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		focoEdicao = new Foco();
		focoEdicao.setIdFoco(0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		
		
		cadastroFoco.salvar(focoEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Focos-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroFoco.excluir(focoSelecionado);
		focoSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosFocos = focos.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosFocos
	 */
	
	public List<Foco> gettodosFocos() {
		return todosFocos;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return todoscargos
	 */
	
	public Foco getFocoEdicao() {
		return focoEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param focoEdicao Objeto do tipo Foco
	 */

	public void setFocoEdicao(Foco focoEdicao) {
		this.focoEdicao = focoEdicao;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return focoSelecionado
	 */

	public Foco getfocoSelecionado() {
		return focoSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param focoSelecionado Objeto do tipo Foco
	 */

	public void setfocoSelecionado(Foco focoSelecionado) {
		this.focoSelecionado = focoSelecionado;
	}

	

}

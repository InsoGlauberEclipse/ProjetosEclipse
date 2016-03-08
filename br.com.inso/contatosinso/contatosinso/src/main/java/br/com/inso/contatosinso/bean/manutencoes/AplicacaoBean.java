package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.Aplicacao;
import br.com.inso.contatosinso.repositorio.Aplicacoes;
import br.com.inso.contatosinso.servicos.AplicacaoServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("AplicacaoBean")
@ViewScoped
public class AplicacaoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5870579198727723580L;

	// Injeção de dependencia das classes necessária
	
	@Inject
	private Aplicacoes apps;
	
	@Inject
	private AplicacaoServico cadastroAplicacao;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Aplicacao> todosApps;
	private Aplicacao AplicacaoEdicao = new Aplicacao();
	private Aplicacao appSelecionado;
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		AplicacaoEdicao = new Aplicacao();
		AplicacaoEdicao.setIdAplicacao( 0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		
		
		cadastroAplicacao.salvar(AplicacaoEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Aplicacaos-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroAplicacao.excluir(appSelecionado);
		appSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosApps = apps.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosApps
	 */
	
	public List<Aplicacao> gettodosApps() {
		return todosApps;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return todosApps
	 */
	
	public Aplicacao getAplicacaoEdicao() {
		return AplicacaoEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param AplicacaoEdicao Objeto do tipo Aplicacao
	 */

	public void setAplicacaoEdicao(Aplicacao AplicacaoEdicao) {
		this.AplicacaoEdicao = AplicacaoEdicao;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return appSelecionado
	 */

	public Aplicacao getappSelecionado() {
		return appSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param appSelecionado Objeto do tipo Aplicacao
	 */

	public void setappSelecionado(Aplicacao appSelecionado) {
		this.appSelecionado = appSelecionado;
	}

	/**
	 * 
	 * Retorna todos os apps.
	 * 
	 * @return the todosApps
	 */
//	public List<Aplicacao> gettodosApps() {
//		return todosApps;
//	}
	

	
	

}

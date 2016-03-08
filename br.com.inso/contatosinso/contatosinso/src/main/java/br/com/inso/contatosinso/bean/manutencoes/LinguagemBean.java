package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.Linguagem;
import br.com.inso.contatosinso.repositorio.Linguagens;
import br.com.inso.contatosinso.servicos.LinguagemServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("LinguagemBean")
@ViewScoped
public class LinguagemBean implements Serializable {
	
	
	private static final long serialVersionUID = -6422707016445935926L;
	
	
	// Injeção de dependencia das classes necessária



	@Inject
	private Linguagens linguagens;
	
	@Inject
	private LinguagemServico cadastroLinguagem;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Linguagem> todosLinguagem;
	private Linguagem linguagemEdicao = new Linguagem();
	private Linguagem linguagemSelecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		linguagemEdicao = new Linguagem();
		linguagemEdicao.setIdLinguagem(linguagens.proximoPkAutoIncremento());
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		cadastroLinguagem.salvar(linguagemEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Linguagens-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroLinguagem.excluir(linguagemSelecionado);
		linguagemSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosLinguagem = linguagens.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosLinguagens
	 */
	
	public List<Linguagem> gettodosLinguagens() {
		return todosLinguagem;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return linguagemEdicao
	 */
	
	public Linguagem getLinguagemEdicao() {
		return linguagemEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param linguagem Objeto do tipo Linguagem.
	 */

	public void setLinguagemEdicao(Linguagem linguagem) {
		this.linguagemEdicao = linguagem;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return linguagemSelecionado
	 */

	public Linguagem getLinguagemSelecionado() {
		return linguagemSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param focoSelecionado Objeto do tipo GerenteConta
	 */

	public void setLinguagemSelecionado(Linguagem linguagem) 
	{
		this.linguagemSelecionado = linguagem;
	}

	

}

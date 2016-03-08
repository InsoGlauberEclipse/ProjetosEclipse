package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.OrigemContato;
import br.com.inso.contatosinso.repositorio.OrigemContatos;
import br.com.inso.contatosinso.servicos.OrigemContatoServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("OrigemContatoBean")
@ViewScoped
public class OrigemContatoBean implements Serializable {
	
	
	private static final long serialVersionUID = -5064534209046344411L;

	
	// Injeção de dependencia das classes necessária


	@Inject
	private OrigemContatos origens;
	
	@Inject
	private OrigemContatoServico cadastroOrigem;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<OrigemContato> todosOrigem;
	private OrigemContato origemEdicao = new OrigemContato();
	private OrigemContato origemSelecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		origemEdicao = new OrigemContato();
		origemEdicao.setIdOrigemContato(0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		cadastroOrigem.salvar(origemEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Origem-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroOrigem.excluir(origemSelecionado);
		origemSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosOrigem = origens.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosLinguagens
	 */
	
	public List<OrigemContato> gettodosOrigem() {
		return todosOrigem;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return linguagemEdicao
	 */
	
	public OrigemContato getOrigemEdicao() {
		return origemEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param linguagem Objeto do tipo Linguagem.
	 */

	public void setOrigemEdicao(OrigemContato origem) {
		this.origemEdicao = origem;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return linguagemSelecionado
	 */

	public OrigemContato getOrigemSelecionado() {
		return origemSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param focoSelecionado Objeto do tipo GerenteConta
	 */

	public void setOrigemSelecionado(OrigemContato origem) 
	{
		this.origemSelecionado = origem;
	}

	

}

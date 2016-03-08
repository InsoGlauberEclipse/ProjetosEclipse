package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.inso.contatosinso.modelo.Produtos;
import br.com.inso.contatosinso.repositorio.Produtoss;
import br.com.inso.contatosinso.servicos.ProdutoServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("ProdutoBean")
@ViewScoped
public class ProdutoBean implements Serializable {
	
	
	private static final long serialVersionUID = -6508780002912395785L;

	
	// Injeção de dependencia das classes necessária



	@Inject
	private Produtoss produtos;
	
	@Inject
	private ProdutoServico cadastroProduto;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Produtos> todosProduto;
	private Produtos produtoEdicao = new Produtos();
	private Produtos produtoSelecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		produtoEdicao = new Produtos();
		produtoEdicao.setId(0);
		produtoEdicao.setBuild(0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		cadastroProduto.salvar(produtoEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Produto-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroProduto.excluir(produtoSelecionado);
		produtoSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosProduto = produtos.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosLinguagens
	 */
	
	public List<Produtos> gettodosProduto() {
		return todosProduto;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return linguagemEdicao
	 */
	
	public Produtos getProdutoEdicao() {
		return produtoEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param linguagem Objeto do tipo Linguagem.
	 */

	public void setProdutoEdicao(Produtos produto) 
	{
		this.produtoEdicao = produto;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return linguagemSelecionado
	 */

	public Produtos getProdutoSelecionado() {
		return produtoSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param focoSelecionado Objeto do tipo GerenteConta
	 */

	public void setProdutoSelecionado(Produtos produto) 
	{
		this.produtoSelecionado = produto;
	}

	

}

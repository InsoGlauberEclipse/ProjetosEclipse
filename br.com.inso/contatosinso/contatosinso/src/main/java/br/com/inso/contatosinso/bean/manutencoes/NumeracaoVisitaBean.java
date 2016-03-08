package br.com.inso.contatosinso.bean.manutencoes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.NumeracaoVisita;
import br.com.inso.contatosinso.repositorio.NumeracaoVisitas;
import br.com.inso.contatosinso.servicos.NumeracaoVisitaServico;
import br.com.inso.contatosinso.util.FacesMessages;

@Named("NumeracaoVisitaBean")
@ViewScoped
public class NumeracaoVisitaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3696766391126917007L;

	
	@Inject
	private NumeracaoVisitas numeracoes;
	
	@Inject
	private NumeracaoVisitaServico cadastroNumeracao;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<NumeracaoVisita> todasNumeracoes;
	private NumeracaoVisita numeracaoVisitaEdicao = new NumeracaoVisita();
	private NumeracaoVisita numeracaoVisitaSelecionada;
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		
		numeracaoVisitaEdicao = new NumeracaoVisita();
		numeracaoVisitaEdicao.setAno(0L );
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		
		
		cadastroNumeracao.salvar(numeracaoVisitaEdicao);
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
		cadastroNumeracao.excluir(numeracaoVisitaSelecionada);
		numeracaoVisitaSelecionada = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todasNumeracoes = numeracoes.todasNumeracoes();
	}

	/**
	 * @return the todasNumeracoes
	 */
	public List<NumeracaoVisita> getTodasNumeracoes() {
		return todasNumeracoes;
	}

	/**
	 * @param todasNumeracoes the todasNumeracoes to set
	 */
	public void setTodasNumeracoes(List<NumeracaoVisita> todasNumeracoes) {
		this.todasNumeracoes = todasNumeracoes;
	}

	/**
	 * @return the numeracaoVisitaEdicao
	 */
	public NumeracaoVisita getNumeracaoVisitaEdicao() {
		return numeracaoVisitaEdicao;
	}

	/**
	 * @param numeracaoVisitaEdicao the numeracaoVisitaEdicao to set
	 */
	public void setNumeracaoVisitaEdicao(NumeracaoVisita numeracaoVisitaEdicao) {
		this.numeracaoVisitaEdicao = numeracaoVisitaEdicao;
	}

	/**
	 * @return the numeracaoVisitaSelecionada
	 */
	public NumeracaoVisita getNumeracaoVisitaSelecionada() {
		return numeracaoVisitaSelecionada;
	}

	/**
	 * @param numeracaoVisitaSelecionada the numeracaoVisitaSelecionada to set
	 */
	public void setNumeracaoVisitaSelecionada(
			NumeracaoVisita numeracaoVisitaSelecionada) {
		this.numeracaoVisitaSelecionada = numeracaoVisitaSelecionada;
	}

	
	
}

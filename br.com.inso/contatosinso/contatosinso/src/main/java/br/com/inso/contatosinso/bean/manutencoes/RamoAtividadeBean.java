package br.com.inso.contatosinso.bean.manutencoes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.RamoAtividade;
import br.com.inso.contatosinso.repositorio.RamosAtividades;
import br.com.inso.contatosinso.servicos.RamoAtividadeServico;
import br.com.inso.contatosinso.util.FacesMessages;


@Named("RamoAtividadeBean")
@ViewScoped
public class RamoAtividadeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6825555337841360846L;
	
	// Injeção de dependencia das classes necessária
	
	@Inject
	private RamosAtividades ramos;
	
	@Inject
	private RamoAtividadeServico cadastroRamo;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<RamoAtividade> todosramos;
	private RamoAtividade objetoEdicao = new RamoAtividade();
	private RamoAtividade objetoSelecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		objetoEdicao = new RamoAtividade();
		objetoEdicao.setIdAtividade(0);;
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		System.out.println("Executou Salvar " );
		
		cadastroRamo.salvar(objetoEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Ramoss-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroRamo.excluir(objetoSelecionado);
		objetoSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosramos = ramos.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todoscargos
	 */
	
	public List<RamoAtividade> gettodosRamos() {
		return todosramos;
	}

	/**
	 * @return the objetoEdicao
	 */
	public RamoAtividade getObjetoEdicao() {
		return objetoEdicao;
	}

	/**
	 * @param objetoEdicao the objetoEdicao to set
	 */
	public void setObjetoEdicao(RamoAtividade objetoEdicao) {
		this.objetoEdicao = objetoEdicao;
	}

	/**
	 * @return the objetoSelecionado
	 */
	public RamoAtividade getObjetoSelecionado() {
		return objetoSelecionado;
	}

	/**
	 * @param objetoSelecionado the objetoSelecionado to set
	 */
	public void setObjetoSelecionado(RamoAtividade objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	
	
	
	

}

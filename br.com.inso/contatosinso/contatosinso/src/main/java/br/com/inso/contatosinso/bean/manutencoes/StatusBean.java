package br.com.inso.contatosinso.bean.manutencoes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.Status;
import br.com.inso.contatosinso.repositorio.Estatus;
import br.com.inso.contatosinso.servicos.EstatusServico;
import br.com.inso.contatosinso.util.FacesMessages;

@Named("StatusBean")
@ViewScoped

public class StatusBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3381266483287013677L;

	
	@Inject
	private Estatus estatus;
	
	@Inject
	private EstatusServico cadastroStatus;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Status> todosstatus;
	private Status objetoEdicao = new Status();
	private Status objetoSelecionado;
	
	private boolean bloquearCodigo = false; 
	
	
	
	public void bloquearCodigo()
	{
		bloquearCodigo = true;
	}
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		bloquearCodigo = false;
		objetoEdicao = new Status();
		objetoEdicao.setIdStatus(0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		bloquearCodigo = false;
		
		cadastroStatus.salvar(objetoEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Status-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		
		bloquearCodigo = false;
		
		cadastroStatus.excluir(objetoSelecionado);
		objetoSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosstatus = estatus.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todoscargos
	 */
	
	public List<Status> gettodosStatus() {
		return todosstatus;
	}

	/**
	 * @return the objetoEdicao
	 */
	public Status getObjetoEdicao() {
		return objetoEdicao;
	}

	/**
	 * @param objetoEdicao the objetoEdicao to set
	 */
	public void setObjetoEdicao(Status objetoEdicao) {
		this.objetoEdicao = objetoEdicao;
	}

	/**
	 * @return the objetoSelecionado
	 */
	public Status getObjetoSelecionado() {
		return objetoSelecionado;
	}

	/**
	 * @param objetoSelecionado the objetoSelecionado to set
	 */
	public void setObjetoSelecionado(Status objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	/**
	 * @return the editarCodigo
	 */
	public boolean getEditarCodigo() {
		return bloquearCodigo;
	}



	
	
}

package br.com.inso.contatosinso.bean.manutencoes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.DesenvConsult;
import br.com.inso.contatosinso.repositorio.DesenvConsults;
import br.com.inso.contatosinso.servicos.DesenvServicos;
import br.com.inso.contatosinso.util.FacesMessages;

/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("DesenvConsultBean")
@ViewScoped
public class DesenvConsultBean implements Serializable
{



	/**
	 * 
	 */
	private static final long serialVersionUID = 5768169250058955849L;

	
	// Injeção de dependencia das classes necessária
	
	@Inject
	private DesenvConsults desenvs;
	
	@Inject
	private DesenvServicos cadastroDesenv;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<DesenvConsult> todosDesenv;
	private DesenvConsult desenvEdicao = new DesenvConsult();
	private DesenvConsult desenvSelecionado;
	

	
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		desenvEdicao = new DesenvConsult();
		desenvEdicao.setId( 0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		
		
		cadastroDesenv.salvar(desenvEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Desenvs-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroDesenv.excluir(desenvSelecionado);
		desenvSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosDesenv = desenvs.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosdesenv
	 */
	
	public List<DesenvConsult> gettodosDesenv() {
		return todosDesenv;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return DesenvConsult
	 */
	
	public DesenvConsult getDesenvEdicao() {
		return desenvEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param DesenvEdicao Objeto do tipo DesenvConsult
	 */

	public void setDesenvEdicao(DesenvConsult DesenvEdicao) {
		this.desenvEdicao = DesenvEdicao;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return desenvselecionado
	 */

	/**
	 * @return the desenvSelecionado
	 */
	public DesenvConsult getdesenvSelecionado() {
		return desenvSelecionado;
	}

	/**
	 * @param desenvSelecionado the desenvSelecionado to set
	 */
	public void setdesenvSelecionado(DesenvConsult desenvSelecionado) {
		this.desenvSelecionado = desenvSelecionado;
	}


	
	
	
	
}

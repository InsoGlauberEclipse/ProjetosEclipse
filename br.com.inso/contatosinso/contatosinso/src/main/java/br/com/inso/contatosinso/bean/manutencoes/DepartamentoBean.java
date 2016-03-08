package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.inso.contatosinso.modelo.Departamento;
import br.com.inso.contatosinso.repositorio.Departamentos;
import br.com.inso.contatosinso.servicos.DepartamentoServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("DepartamentoBean")
@ViewScoped
public class DepartamentoBean implements Serializable {
	
	
	// Injeção de dependencia das classes necessária
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9041760769256281231L;

	@Inject
	private Departamentos deptos;
	
	@Inject
	private DepartamentoServico cadastroDepartamento;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Departamento> todosdeptos;
	private Departamento departamentoEdicao = new Departamento();
	private Departamento deptoselecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		departamentoEdicao = new Departamento();
		departamentoEdicao.setIdDepartamento(0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		
		
		cadastroDepartamento.salvar(departamentoEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:deptos-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroDepartamento.excluir(deptoselecionado);
		deptoselecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todosdeptos = deptos.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todosdeptos
	 */
	
	public List<Departamento> gettodosdeptos() {
		return todosdeptos;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return todosdeptos
	 */
	
	public Departamento getdepartamentoEdicao() {
		return departamentoEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param departamentoEdicao Objeto do tipo Cargo
	 */

	public void setdepartamentoEdicao(Departamento departamentoEdicao) {
		this.departamentoEdicao = departamentoEdicao;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return deptoselecionado
	 */

	public Departamento getdeptoselecionado() {
		return deptoselecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param deptoselecionado Objeto do tipo Cargo
	 */

	public void setdeptoselecionado(Departamento deptoselecionado) {
		this.deptoselecionado = deptoselecionado;
	}

	

}

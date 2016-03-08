package br.com.inso.contatosinso.bean.manutencoes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.inso.contatosinso.modelo.BoletoTaxi;
import br.com.inso.contatosinso.modelo.Cliente;
import br.com.inso.contatosinso.modelo.Departamento;
import br.com.inso.contatosinso.modelo.DesenvConsult;
import br.com.inso.contatosinso.repositorio.BoletosTaxi;
import br.com.inso.contatosinso.repositorio.Clientes;
import br.com.inso.contatosinso.repositorio.Departamentos;
import br.com.inso.contatosinso.repositorio.DesenvConsults;
import br.com.inso.contatosinso.servicos.BoletosTaxiServico;
import br.com.inso.contatosinso.util.FacesMessages;

@Named("BoletosBean")
@ViewScoped

public class BoletosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -480416991022653355L;
	
	
	// Injeção de dependencia das classes necessária

	@Inject
	private BoletosTaxi boletosConsultas;	
	
	
	@Inject
	private BoletosTaxiServico boletosServico;	
	
	@Inject
	private DesenvConsults desenvs;

	@Inject
	private Departamentos departs;
	
	@Inject
	private Clientes clientes;

	@Inject
	private FacesMessages messages;
	
	
	private List<BoletoTaxi> todosBoletos;
	private BoletoTaxi objetoEdicao = new BoletoTaxi();
	private BoletoTaxi objetoSelecionado;
	
	private List<DesenvConsult> todosDesenvolvedores;
	private List<Departamento> todosDepartamentos;
	private List<Cliente> todosClientes;
	
	private boolean bloquearCodigo = false;
	
	
	
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		objetoEdicao = new BoletoTaxi();
		objetoEdicao.setIdBoleto("");
		objetoEdicao.setQru("");
		objetoEdicao.setCarro("");
		objetoEdicao.setData(new Date());
		objetoEdicao.setDestino("");
		objetoEdicao.setHrFinal("");
		objetoEdicao.setHrInicial("");
		objetoEdicao.setKmFinal("");
		objetoEdicao.setKmInicial("");
		objetoEdicao.setObservacao("");
		objetoEdicao.setOrigem("");
		objetoEdicao.setPlacaVeiculo("");
		objetoEdicao.setQru("");
		objetoEdicao.setValor(0.00);
		objetoEdicao.setCliente(new Cliente());
		objetoEdicao.setDepto(new Departamento());
		objetoEdicao.setFuncionario(new DesenvConsult());
		
		bloquearCodigo = false;
		
	}

	
	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		bloquearCodigo = false;	
		
		boletosServico.salvar(objetoEdicao);

		consultar();
/*		
        System.out.println("ObjetoEdicao:" + objetoEdicao.toString());	
        System.out.println("Id Boleto..:"+ objetoEdicao.getIdBoleto());
        System.out.println("Carro......:"+ objetoEdicao.getCarro());
        System.out.println("Destino....:"+ objetoEdicao.getDestino());
        System.out.println("Hr.Final...:"+ objetoEdicao.getHrFinal());
        System.out.println("Hr.Inicial.:"+ objetoEdicao.getHrInicial());
        System.out.println("KM.Final.....:"+ objetoEdicao.getKmFinal());
        System.out.println("KM.Inicial...:"+ objetoEdicao.getKmInicial());
        System.out.println("Observacao...:"+ objetoEdicao.getObservacao());
        System.out.println("Orgiem.......:"+ objetoEdicao.getOrigem());
        System.out.println("Hr.Inicial...:"+ objetoEdicao.getPlacaVeiculo());
        System.out.println("Qru..........:"+ objetoEdicao.getQru());
        System.out.println("Valor........:"+ objetoEdicao.getValor());
        System.out.println("Cliente......:"+ objetoEdicao.getCliente());
        System.out.println("Data.........:"+ objetoEdicao.getData());
        System.out.println("Departamento.:"+ objetoEdicao.getDepto());
        System.out.println("Funcionario..:"+ objetoEdicao.getFuncionario());
        
*/        
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Boletos-table"));
	}
	

	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		
		if (null != objetoEdicao)
		{
			boletosServico.excluir(objetoEdicao);
			consultar();			
			messages.info("Registro excluído com sucesso!");	
		}
		
		objetoEdicao = null;		
		bloquearCodigo = false;
		
	}
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {

		todosBoletos = boletosConsultas.todosBoletosIdBoletoDesc();
		
	}
		
	

	/**
	 * Deixa o campo IdBoleto readonly
	 * 
	 */	
	public void bloquearCodigo()
	{
		bloquearCodigo = true;
	}

	/*
	 * Preencher o combo com os dados dos Departamentos.
	 * 
	 */
	public List<Departamento> getTodosDepartamentos() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosDepartamentos = departs.todosPorDepartamento();
		}
		return todosDepartamentos;
	}

	
	/*
	 * Preencher o combo com os dados dos Funcionarios.
	 * 
	 */
	public List<DesenvConsult> getTodosFuncionarios() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosDesenvolvedores = desenvs.todasPorNome();
		}
		return todosDesenvolvedores;
	}


	/*
	 * Preencher o combo com os dados dos Clientes.
	 * 
	 */
	public List<Cliente> getTodosClientes() 
	{
		if (!FacesContext.getCurrentInstance().isPostback()) {
			todosClientes = clientes.todasAtivosOrdernadoPorRazaoSocial();
		}

		return todosClientes;
	}
	

	// Gets & Sets

	
	/**
	 * @return the objetoEdicao
	 */
	public BoletoTaxi getObjetoEdicao() {
		return objetoEdicao;
	}

	/**
	 * @param objetoEdicao the objetoEdicao to set
	 */
	public void setObjetoEdicao(BoletoTaxi objetoEdicao) {
		this.objetoEdicao = objetoEdicao;
	}

	/**
	 * @return the objetoSelecionado
	 */
	public BoletoTaxi getObjetoSelecionado() {
		return objetoSelecionado;
	}

	/**
	 * @param objetoSelecionado the objetoSelecionado to set
	 */
	public void setObjetoSelecionado(BoletoTaxi objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	/**
	 * @return the todosBoletos
	 */
	public List<BoletoTaxi> getTodosBoletos() {
		return todosBoletos;
	}

	
	/**
	 * Retorna a propriedade para controlar a Edição do campo IdBoleto
	 * @return the bloquearCodigo
	 */
	public boolean getBloquearCodigo() {
		return bloquearCodigo;
	}

	
	
	
	

}

package br.com.inso.contatosinso.bean.manutencoes;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import br.com.inso.contatosinso.modelo.Cargo;
import br.com.inso.contatosinso.repositorio.Cargos;
import br.com.inso.contatosinso.servicos.CargoServico;
import br.com.inso.contatosinso.util.FacesMessages;


/**
 * Classe responsável pela comunicação entre a tela e a camada de negócio. 
 */

@Named("CargoBean")
@ViewScoped
public class CargoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5870579198727723580L;

	// Injeção de dependencia das classes necessária
	
	@Inject
	private Cargos cargos;
	
	@Inject
	private CargoServico cadastroCargo;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Cargo> todoscargos;
	private Cargo cargoEdicao = new Cargo();
	private Cargo cargoSelecionado;
	
	
	/*
	 * Prepara o objeto para edição de um novo registro.
	 * 
	 */
	
	public void prepararNovoCadastro() {
		cargoEdicao = new Cargo();
		cargoEdicao.setIdCargo( 0);
	}

	/*
	 * Salva o objeto de edição corrente.
	 * 
	 */
	
	public void salvar() {
		
		
		
		cadastroCargo.salvar(cargoEdicao);
		consultar();
		
		messages.info("Registro salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:Cargos-table"));
	}
	
	/*
	 * Exclui o objeto de edição corrente.
	 * 
	 */

	public void excluir() {
		cadastroCargo.excluir(cargoSelecionado);
		cargoSelecionado = null;
		
		consultar();
		
		messages.info("Registro excluído com sucesso!");
	}
	
	
	/*
	 * Popula a lista de objetos para alimentar a grid.
	 * 
	 */

	public void consultar() {
		todoscargos = cargos.todas();
	}

	/**
	 * 
	 * Obtem todos so registros.
	 * 
	 * @return todoscargos
	 */
	
	public List<Cargo> gettodosCargos() {
		return todoscargos;
	}

	/**
	 * 
	 * Retorna o objeto de edição corrente.
	 * 
	 * @return todoscargos
	 */
	
	public Cargo getCargoEdicao() {
		return cargoEdicao;
	}
	/**
	 * 
	 * Seta o objeto de edição corrente.
	 * 
	 * @param CargoEdicao Objeto do tipo Cargo
	 */

	public void setCargoEdicao(Cargo CargoEdicao) {
		this.cargoEdicao = CargoEdicao;
	}
	/**
	 * 
	 * Retorna o objeto de selecionado.
	 * 
	 * @return cargoselecionado
	 */

	public Cargo getcargoSelecionado() {
		return cargoSelecionado;
	}
	/**
	 * 
	 * Seta o objeto selecionado.
	 * 
	 * @param cargoselecionado Objeto do tipo Cargo
	 */

	public void setcargoSelecionado(Cargo cargoselecionado) {
		this.cargoSelecionado = cargoselecionado;
	}

	

}

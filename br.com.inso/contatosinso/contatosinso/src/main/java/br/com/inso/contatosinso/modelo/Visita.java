package br.com.inso.contatosinso.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity (name="Visita")
public class Visita implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1981802729623402331L;
	
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdVisita", nullable = false)
	private Long IdVisita;
	
	
	@NotNull
	@Column(name="RelNumero")
	private Long RelatorioNumero;


	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="Data")
	private Date Data;


	@ManyToOne (fetch = FetchType.LAZY )
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;

	
	@NotNull
	@Column(name="Endereco", nullable = false, length=50)
	private String Endereco;
	
	
	@ManyToOne (fetch = FetchType.LAZY )
	@JoinColumn(name = "IdProduto")
	private Produtos produto;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_desenvconsult")	
	private DesenvConsult funcionario;
	
	
	@NotNull
	@Column(name="Assunto")
	private String Assunto;

	
	@Column(name="HrInicial1", nullable = false, length=10)
	private String HrInicial1;
	
	
	@Column(name="HrFinal1", nullable = false, length=10)
	private String HrFinal1;


	@Column(name="HrInicial2", nullable = false, length=10)
	private String HrInicial2;
	
	
	@Column(name="HrFinal2", nullable = false, length=10)
	private String HrFinal2;
	

	@Column(name="HrInicial3", nullable = false, length=10)
	private String HrInicial3;
	
	
	@Column(name="HrFinal3", nullable = false, length=10)
	private String HrFinal3;
	
	
	@Column(name="FaturaHoras", nullable = false, length=1)
	private String FaturaHoras;

	
	@Column(name="QtdHorasFaturar")
	private int QtdHorasFaturar;

	
	
	@Column(name="NomeCliente", nullable = false, length=50)
	private String NomeCliente;

	
	@Temporal(TemporalType.DATE)
	@Column(name="DataCliente")
	private Date DataCliente;

	
	@Column(name="HoraCliente", nullable = false, length=10)
	private String HoraCliente;

	
	@Column(name="AtividadesEnvolvida")
	private String AtividadesEnvolvida;


	@Column(name="PendenciasComentarios")
	private String PendenciasComentarios;
	
	
	@Column(name="Passagem", nullable = false, precision=10, scale=2)
	private Double Passagem;

	
	@Column(name="Taxi", nullable = false, precision=10, scale=2)
	private Double Taxi;

	
	@Column(name="Pedagio", nullable = false, precision=10, scale=2)
	private Double Pedagio;

	
	@Column(name="Estacionamento", nullable = false, precision=10, scale=2)
	private Double Estacionamento;
	
	
	@Column(name="Combustivel", nullable = false, precision=10, scale=2)
	private Double Combustivel;
	
	
	@Column(name="Refeicao", nullable = false, precision=10, scale=2)
	private Double Refeicao;

	
	@Column(name="Hotel", nullable = false, precision=10, scale=2)
	private Double Hotel;

	
	@Column(name="KmRodado", nullable = false, precision=10, scale=2)
	private Double KmRodado;


	@Column(name="Diversas", nullable = false, precision=10, scale=2)
	private Double Diversas;

	
	@Column(name="ReembolsoAutorizacao", nullable = false, length=50)
	private String ReembolsoAutorizacao;

	
	@Temporal(TemporalType.DATE)
	@Column(name="ReembolsoData")
	private Date ReembolsoData;

	
	@Column(name="ReembolsoHora", nullable = false, length=10)
	private String ReembolsoHora;
	

	@Temporal(TemporalType.DATE)
	@Column(name="DataPagamento")
	private Date DataPagamento;


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdVisita == null) ? 0 : IdVisita.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visita other = (Visita) obj;
		if (IdVisita == null) {
			if (other.IdVisita != null)
				return false;
		} else if (!IdVisita.equals(other.IdVisita))
			return false;
		return true;
	}


	/**
	 * @return the idVisita
	 */
	public Long getIdVisita() {
		return IdVisita;
	}


	/**
	 * @param idVisita the idVisita to set
	 */
	public void setIdVisita(Long idVisita) {
		IdVisita = idVisita;
	}


	/**
	 * @return the relatorioNumero
	 */
	public Long getRelatorioNumero() {
		return RelatorioNumero;
	}


	/**
	 * @param relatorioNumero the relatorioNumero to set
	 */
	public void setRelatorioNumero(Long relatorioNumero) {
		RelatorioNumero = relatorioNumero;
	}


	/**
	 * @return the data
	 */
	public Date getData() {
		return Data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		Data = data;
	}


	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}


	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * @return the produto
	 */
	public Produtos getProduto() {
		return produto;
	}


	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}


	/**
	 * @return the funcionario
	 */
	public DesenvConsult getFuncionario() {
		return funcionario;
	}


	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(DesenvConsult func) {
		funcionario = func;
	}


	/**
	 * @return the assunto
	 */
	public String getAssunto() {
		return Assunto;
	}


	/**
	 * @param assunto the assunto to set
	 */
	public void setAssunto(String assunto) {
		Assunto = assunto;
	}


	/**
	 * @return the hrInicial1
	 */
	public String getHrInicial1() {
		return HrInicial1;
	}


	/**
	 * @param hrInicial1 the hrInicial1 to set
	 */
	public void setHrInicial1(String hrInicial1) {
		HrInicial1 = hrInicial1;
	}


	/**
	 * @return the hrFinal1
	 */
	public String getHrFinal1() {
		return HrFinal1;
	}


	/**
	 * @param hrFinal1 the hrFinal1 to set
	 */
	public void setHrFinal1(String hrFinal1) {
		HrFinal1 = hrFinal1;
	}


	/**
	 * @return the hrInicial2
	 */
	public String getHrInicial2() {
		return HrInicial2;
	}


	/**
	 * @param hrInicial2 the hrInicial2 to set
	 */
	public void setHrInicial2(String hrInicial2) {
		HrInicial2 = hrInicial2;
	}


	/**
	 * @return the hrFinal2
	 */
	public String getHrFinal2() {
		return HrFinal2;
	}


	/**
	 * @param hrFinal2 the hrFinal2 to set
	 */
	public void setHrFinal2(String hrFinal2) {
		HrFinal2 = hrFinal2;
	}


	/**
	 * @return the hrInicial3
	 */
	public String getHrInicial3() {
		return HrInicial3;
	}


	/**
	 * @param hrInicial3 the hrInicial3 to set
	 */
	public void setHrInicial3(String hrInicial3) {
		HrInicial3 = hrInicial3;
	}


	/**
	 * @return the hrFinal3
	 */
	public String getHrFinal3() {
		return HrFinal3;
	}


	/**
	 * @param hrFinal3 the hrFinal3 to set
	 */
	public void setHrFinal3(String hrFinal3) {
		HrFinal3 = hrFinal3;
	}


	/**
	 * @return the faturaHoras
	 */
	public String getFaturaHoras() {
		return FaturaHoras;
	}


	/**
	 * @param faturaHoras the faturaHoras to set
	 */
	public void setFaturaHoras(String faturaHoras) {
		FaturaHoras = faturaHoras;
	}


	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return NomeCliente;
	}


	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}


	/**
	 * @return the dataCliente
	 */
	public Date getDataCliente() {
		return DataCliente;
	}


	/**
	 * @param dataCliente the dataCliente to set
	 */
	public void setDataCliente(Date dataCliente) {
		DataCliente = dataCliente;
	}


	/**
	 * @return the horaCliente
	 */
	public String getHoraCliente() {
		return HoraCliente;
	}


	/**
	 * @param horaCliente the horaCliente to set
	 */
	public void setHoraCliente(String horaCliente) {
		HoraCliente = horaCliente;
	}


	/**
	 * @return the atividadesEnvolvida
	 */
	public String getAtividadesEnvolvida() {
		return AtividadesEnvolvida;
	}


	/**
	 * @param atividadesEnvolvida the atividadesEnvolvida to set
	 */
	public void setAtividadesEnvolvida(String atividadesEnvolvida) {
		AtividadesEnvolvida = atividadesEnvolvida;
	}


	/**
	 * @return the pendenciasComentarios
	 */
	public String getPendenciasComentarios() {
		return PendenciasComentarios;
	}


	/**
	 * @param pendenciasComentarios the pendenciasComentarios to set
	 */
	public void setPendenciasComentarios(String pendenciasComentarios) {
		PendenciasComentarios = pendenciasComentarios;
	}


	/**
	 * @return the passagem
	 */
	public Double getPassagem() {
		return Passagem;
	}


	/**
	 * @param passagem the passagem to set
	 */
	public void setPassagem(Double passagem) {
		Passagem = passagem;
	}


	/**
	 * @return the taxi
	 */
	public Double getTaxi() {
		return Taxi;
	}


	/**
	 * @param taxi the taxi to set
	 */
	public void setTaxi(Double taxi) {
		Taxi = taxi;
	}


	/**
	 * @return the pedagio
	 */
	public Double getPedagio() {
		return Pedagio;
	}


	/**
	 * @param pedagio the pedagio to set
	 */
	public void setPedagio(Double pedagio) {
		Pedagio = pedagio;
	}


	/**
	 * @return the estacionamento
	 */
	public Double getEstacionamento() {
		return Estacionamento;
	}


	/**
	 * @param estacionamento the estacionamento to set
	 */
	public void setEstacionamento(Double estacionamento) {
		Estacionamento = estacionamento;
	}


	/**
	 * @return the combustivel
	 */
	public Double getCombustivel() {
		return Combustivel;
	}


	/**
	 * @param combustivel the combustivel to set
	 */
	public void setCombustivel(Double combustivel) {
		Combustivel = combustivel;
	}


	/**
	 * @return the refeicao
	 */
	public Double getRefeicao() {
		return Refeicao;
	}


	/**
	 * @param refeicao the refeicao to set
	 */
	public void setRefeicao(Double refeicao) {
		Refeicao = refeicao;
	}


	/**
	 * @return the hotel
	 */
	public Double getHotel() {
		return Hotel;
	}


	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Double hotel) {
		Hotel = hotel;
	}


	/**
	 * @return the kmRodado
	 */
	public Double getKmRodado() {
		return KmRodado;
	}


	/**
	 * @param kmRodado the kmRodado to set
	 */
	public void setKmRodado(Double kmRodado) {
		KmRodado = kmRodado;
	}


	/**
	 * @return the diversas
	 */
	public Double getDiversas() {
		return Diversas;
	}


	/**
	 * @param diversas the diversas to set
	 */
	public void setDiversas(Double diversas) {
		Diversas = diversas;
	}


	/**
	 * @return the reembolsoAutorizacao
	 */
	public String getReembolsoAutorizacao() {
		return ReembolsoAutorizacao;
	}


	/**
	 * @param reembolsoAutorizacao the reembolsoAutorizacao to set
	 */
	public void setReembolsoAutorizacao(String reembolsoAutorizacao) {
		ReembolsoAutorizacao = reembolsoAutorizacao;
	}


	/**
	 * @return the reembolsoData
	 */
	public Date getReembolsoData() {
		return ReembolsoData;
	}


	/**
	 * @param reembolsoData the reembolsoData to set
	 */
	public void setReembolsoData(Date reembolsoData) {
		ReembolsoData = reembolsoData;
	}


	/**
	 * @return the reembolsoHora
	 */
	public String getReembolsoHora() {
		return ReembolsoHora;
	}


	/**
	 * @param reembolsoHora the reembolsoHora to set
	 */
	public void setReembolsoHora(String reembolsoHora) {
		ReembolsoHora = reembolsoHora;
	}


	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return DataPagamento;
	}


	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		DataPagamento = dataPagamento;
	}


	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return Endereco;
	}


	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}


	/**
	 * @return the qtdHorasFaturar
	 */
	public int getQtdHorasFaturar() {
		return QtdHorasFaturar;
	}


	/**
	 * @param qtdHorasFaturar the qtdHorasFaturar to set
	 */
	public void setQtdHorasFaturar(int qtdHorasFaturar) {
		QtdHorasFaturar = qtdHorasFaturar;
	}
	
	
	
	
	
	
}

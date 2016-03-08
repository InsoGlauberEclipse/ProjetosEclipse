package br.com.inso.contatosinso.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/*
 * 
 * Classe responsável pelo mapeamento O.R.
 * 
 */

@Entity (name="BoletoTaxi")
public class BoletoTaxi implements Serializable
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 965760985529130146L;


	@Id
	@NotNull	
	@Column(name="IdBoleto", nullable = false, length=10)
	private String IdBoleto;

	

	@NotNull
	@Column(name="Qru", nullable = false, length=10)
	private String Qru;


	@NotNull
	@Column(name="Carro", nullable = false, length=10)
	private String Carro;

	@NotNull
	@Column(name="Valor", nullable = false, precision=10, scale=2)
	private Double Valor;
	

	@NotNull
	@Column(name="HrInicial", nullable = false, length=10)
	private String HrInicial;
	

	@NotNull
	@Column(name="HrFinal", nullable = false, length=10)
	private String HrFinal;

	

	@NotNull
	@Column(name="KmInicial", nullable = false, length=7)
	private String KmInicial;
	

	@NotNull
	@Column(name="KmFinal", nullable = false, length=7)
	private String KmFinal;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_depto")	
	private Departamento Depto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_desenvconsult")	
	private DesenvConsult Funcionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IdCliente")	
	private Cliente cliente;	
	

	@NotNull
	@Column(name="Origem", nullable = false, length=50)
	private String Origem;
	

	@NotNull
	@Column(name="Destino", nullable = false, length=50)
	private String Destino;
	
	@Column(name="Observacao", nullable = true, length=4000)
	private String Observacao;
	
	

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="Data")
	private Date Data;

	@Column(name="PlacaVeiculo", nullable = true, length=10)
	private String PlacaVeiculo;

	/**
	 * @return the idBoleto
	 */
	public String getIdBoleto() {
		return IdBoleto;
	}

	/**
	 * @param i the idBoleto to set
	 */
	public void setIdBoleto(String i) {
		IdBoleto = i;
	}

	/**
	 * @return the qru
	 */
	public String getQru() {
		return Qru;
	}

	/**
	 * @param qru the qru to set
	 */
	public void setQru(String qru) {
		Qru = qru;
	}

	/**
	 * @return the carro
	 */
	public String getCarro() {
		return Carro;
	}

	/**
	 * @param carro the carro to set
	 */
	public void setCarro(String carro) {
		Carro = carro;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return Valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		Valor = valor;
	}

	/**
	 * @return the hrInicial
	 */
	public String getHrInicial() {
		return HrInicial;
	}

	/**
	 * @param hrInicial the hrInicial to set
	 */
	public void setHrInicial(String hrInicial) {
		HrInicial = hrInicial;
	}

	/**
	 * @return the hrFinal
	 */
	public String getHrFinal() {
		return HrFinal;
	}

	/**
	 * @param hrFinal the hrFinal to set
	 */
	public void setHrFinal(String hrFinal) {
		HrFinal = hrFinal;
	}

	/**
	 * @return the kmInicial
	 */
	public String getKmInicial() {
		return KmInicial;
	}

	/**
	 * @param kmInicial the kmInicial to set
	 */
	public void setKmInicial(String kmInicial) {
		KmInicial = kmInicial;
	}

	/**
	 * @return the kmFinal
	 */
	public String getKmFinal() {
		return KmFinal;
	}

	/**
	 * @param i the kmFinal to set
	 */
	public void setKmFinal(String i) {
		KmFinal = i;
	}

	/**
	 * @return the depto
	 */
	public Departamento getDepto() {
		return Depto;
	}

	/**
	 * @param depto the depto to set
	 */
	public void setDepto(Departamento depto) {
		Depto = depto;
	}

	/**
	 * @return the funcionario
	 */
	public DesenvConsult getFuncionario() {
		return Funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(DesenvConsult funcionario) {
		Funcionario = funcionario;
	}

	/**
	 * @return the origem
	 */
	public String getOrigem() {
		return Origem;
	}

	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(String origem) {
		Origem = origem;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return Destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		Destino = destino;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return Observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		Observacao = observacao;
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
	 * @return the placaVeiculo
	 */
	public String getPlacaVeiculo() {
		return PlacaVeiculo;
	}

	/**
	 * @param placaVeiculo the placaVeiculo to set
	 */
	public void setPlacaVeiculo(String placaVeiculo) {
		PlacaVeiculo = placaVeiculo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdBoleto == null) ? 0 : IdBoleto.hashCode());
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
		BoletoTaxi other = (BoletoTaxi) obj;
		if (IdBoleto == null) {
			if (other.IdBoleto != null)
				return false;
		} else if (!IdBoleto.equals(other.IdBoleto))
			return false;
		return true;
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


	
	

	
	
	
}

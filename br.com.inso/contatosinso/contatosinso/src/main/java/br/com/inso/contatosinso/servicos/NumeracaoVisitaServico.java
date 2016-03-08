package br.com.inso.contatosinso.servicos;

import java.io.Serializable;
import java.util.Calendar;
import javax.inject.Inject;
import br.com.inso.contatosinso.modelo.NumeracaoVisita;
import br.com.inso.contatosinso.repositorio.NumeracaoVisitas;
import br.com.inso.contatosinso.util.jpa.Transacional;

public class NumeracaoVisitaServico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6492144456177034944L;

	
	@Inject
	private NumeracaoVisitas numeracao;
	
	
	/*
	 * Persiste um objeto.
	 * 
	 * @param ambiente Objeto a ser persistido.
	 * 
	 */
	
	@Transacional
	public void salvar(NumeracaoVisita num)
	{
		numeracao.guardar(num);
	}

	/*
	 * Remove um objeto.
	 * 
	 * @param ambiente Objeto a ser removido.
	 * 
	 */
	
	@Transacional
	public void excluir(NumeracaoVisita num)
	{
		numeracao.remover(num);
	}
	
	
	/*
	 * Retorna um número de visita válido para uso.
	 * 
	 * 
	 * 
	 */
	
	@Transacional
	public Long getNumeroVisita()
	{
		
		Long retorno = 1L;
		int ano = Calendar.getInstance().get(Calendar.YEAR); 
		
		NumeracaoVisita num = numeracao.porPk(new Long(ano));
		
		if (null == num)
		{
			num = new NumeracaoVisita();
			num.setAno(new Long(ano));
			num.setUltimoRelatorio(1L);			
		}
		else
		{
			num.setUltimoRelatorio(num.getUltimoRelatorio() + 1);
			retorno = num.getUltimoRelatorio();
		}
		
		numeracao.guardar(num);
		
		return retorno;
		
	}

	
	
}

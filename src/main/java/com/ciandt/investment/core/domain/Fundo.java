package com.ciandt.investment.core.domain;

import java.math.BigDecimal;

public class Fundo {
	
	private String cnpj;
	private BigDecimal captacaoLiquida = BigDecimal.ZERO;
	
	public Fundo(String cnpj) {
		this.cnpj = cnpj;
	}
	

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public BigDecimal getCaptacaoLiquida() {
		return captacaoLiquida;
	}
	public void setCaptacaoLiquida(BigDecimal captacaoLiquida) {
		this.captacaoLiquida = captacaoLiquida;
	}
}

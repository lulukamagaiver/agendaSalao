package com.mvsistemas.agendaSalao.enums;

public enum TipoPessoaEnum {
	F("Fisica"),
	J("Juridica");

	private String descricao;

	TipoPessoaEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}

package com.mvsistemas.agendaSalao.model;

import java.math.BigDecimal;

import com.mvsistemas.agendaSalao.dao.ProdutoServicoDao;
import com.mvsistemas.agendaSalao.dao.impl.ProdutoServicoDaoImpl;

public class Teste {

	public static void main(String[] args) {
		ProdutoServico ps = new ProdutoServico();
		ps.setId(1);
		ps.setNomeProdServ("Corte de Cabelo");
		ps.setValor(new BigDecimal("15.00"));
		
		System.out.println(ps.toString());
		
		ProdutoServicoDao psdb = new ProdutoServicoDaoImpl();
		psdb.guardar(ps);

	}

}

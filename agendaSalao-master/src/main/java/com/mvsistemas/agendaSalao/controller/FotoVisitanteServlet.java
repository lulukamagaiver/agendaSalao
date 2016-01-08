package com.mvsistemas.agendaSalao.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.mvsistemas.agendaSalao.dao.impl.Visitantes;
import com.mvsistemas.agendaSalao.model.Visitante;

@WebServlet(urlPatterns = "/foto-visitante")
public class FotoVisitanteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private Visitantes visitantes;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Long idVisitante = Long.valueOf(req.getParameter("visitante"));
		
		Visitante visitante = visitantes.porId(idVisitante);
		
		resp.setContentType("image/jpeg");
		IOUtils.write(visitante.getFoto(), resp.getOutputStream());
	}
	
}

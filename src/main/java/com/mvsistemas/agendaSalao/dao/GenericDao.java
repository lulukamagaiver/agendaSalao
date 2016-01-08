package com.mvsistemas.agendaSalao.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,I extends Serializable> {
	
	/** Guradar no Banco um Objeto */
	public T guardar(T Class);
	
	/** Listar do banco os Objetos */
	public List<T> todos(Class<T> classe);
	
	/** Pegar o Objeto por ID*/
	public T porId(Class<T> classe,Long identificador);
}

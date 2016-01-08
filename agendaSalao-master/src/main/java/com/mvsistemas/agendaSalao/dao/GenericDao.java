package com.mvsistemas.agendaSalao.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDao<T,I extends Serializable> {
	
	/**
	 * Guradar no Banco um Objeto  
	 * @param Class
	 * @return
	 */
	public T guardar(T Class);
	
	/**
	 * Remover um Objeto do Banco
	 * @param entity
	 */
	public void remover(T entity);
	
	/**
	 * Listar do banco os Objetos 
	 * @param classe
	 * @return
	 */
	public List<T> todos(Class<T> classe);
	
	/**
	 * Pegar o Objeto por ID
	 * @param classe
	 * @param identificador
	 * @return
	 */
	public T porId(Class<T> classe,Long identificador);
	
	public EntityManager getEntityManager();
}

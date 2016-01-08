package com.mvsistemas.agendaSalao.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.mvsistemas.agendaSalao.dao.GenericDao;
import com.mvsistemas.agendaSalao.util.Conexao;

public class GenericDaoImpl<T, I extends Serializable> implements
		GenericDao<T, I> {

	@Inject
	private EntityManager manager;

	private Conexao conexao;

	@Override
	public T guardar(T Class) {
		T saved = null;
		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(Class);
		getEntityManager().getTransaction().commit();
		return saved;
	}
	

	@Override
	public void remover(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> todos(Class<T> classe) {
		return manager.createQuery("from " + classe.getSimpleName())
				.getResultList();
	}

	@Override
	public T porId(Class<T> classe, Long identificador) {
		return manager.find(classe, identificador);
	}

	@SuppressWarnings("unchecked")
	public List<T> todos(Class<T> classe, String orderBy) {
		return manager.createQuery(
				"from " + classe.getSimpleName() + " order by " + orderBy
						+ " desc").getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		if (conexao == null) {
			conexao = new Conexao();
		}
		return conexao.getEntityManager();
	}


}

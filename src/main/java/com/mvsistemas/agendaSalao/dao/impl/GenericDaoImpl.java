package com.mvsistemas.agendaSalao.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.mvsistemas.agendaSalao.dao.GenericDao;

public class GenericDaoImpl<T, I extends Serializable> implements GenericDao<T, I>{
	
	@Inject
	private EntityManager manager;

	@Override
	public T guardar(T Class) {
		manager.getTransaction().begin();
		Class = manager.merge(Class);
		manager.getTransaction().commit();
		return Class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> todos(Class<T> classe) {
		return manager.createQuery("from "+classe.getSimpleName()).getResultList();
	}

	@Override
	public T porId(Class<T> classe,Long identificador) {
		return manager.find(classe, identificador);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> todos(Class<T> classe, String orderBy) {
		return manager.createQuery("from "+classe.getSimpleName()+" order by "+orderBy+" desc").getResultList();
	}

}

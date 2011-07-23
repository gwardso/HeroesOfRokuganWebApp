package com.wardso.persistence;

import javax.jdo.Transaction;


public class PersistenceManager <T>{
	private javax.jdo.PersistenceManager persistenceManager;
	private Class<T> classType;
	
	public PersistenceManager(javax.jdo.PersistenceManager persistenceManager, Class<T> classType){
		this.classType = classType;
		this.persistenceManager = persistenceManager;
	}

	@SuppressWarnings("unchecked")
	public T getObjectById(Object id){
		return this.persistenceManager.getObjectById(classType, id);
	}
	
	public Query<T> newQuery(){
		return new Query<T>(this.persistenceManager.newQuery(this.classType));
	}

	public void close() {
		this.persistenceManager.close();
	}

	public T makePersistent(T entity) {
		Transaction tx = this.persistenceManager.currentTransaction();
		tx.begin();
		T finalEntity = this.persistenceManager.makePersistent(entity);
		tx.commit();
		return finalEntity;
	}
}

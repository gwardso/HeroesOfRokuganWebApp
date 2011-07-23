package com.wardso.persistence;

import java.util.List;

public class Query <T> {
	private javax.jdo.Query query;
	
	public Query(javax.jdo.Query query) {
		this.query = query;
	}

	public void setFilter(String filter) {
		this.query.setFilter(filter);
	}

	public void declareParameters(String parameterString) {
		this.query.declareParameters(parameterString);
	}

	@SuppressWarnings("unchecked")
	public List<T> execute(Object value) {
		return (List<T>)this.query.execute(value);
	}

	public void closeAll() {
		this.query.closeAll();
	}	
}
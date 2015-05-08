package hu.sed.prf.javaeedemo.controller.core;

import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDataModel<EntityType, ID extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = -1162381107575635107L;
	
	private List<EntityType> list;
	
	public void load() {
		setList(getEntityDao().list());
	}
	
	protected abstract AbstractGenericDAO<EntityType, ID> getEntityDao();
	
	public List<EntityType> getList() {
		return list;
	}
	
	public void setList(List<EntityType> list) {
		this.list = list;
	}

}

package hu.sed.prf.javaeedemo.controller.core;

import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;

public abstract class AbstractEntityAction<EntityType, ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = -1990165498495936667L;
	
	@Inject
	private Logger logger;

	private ID id;
	
	private EntityType entity;
	
	private Class<EntityType> entityClass;
	
	/**
	 * Erre a konstruktorra csak azert van szukseg, mert a CDI meg akkor is megkoveteli az abstract osztalyoktol, 
	 * hogy legyen parameter nelkuli konstruktoruk, ha valojaban a leszarmazott osztalyok konstruktorai nem is 
	 * hasznalnak azt.
	 */
	public AbstractEntityAction() {
		// Nothing to do here.
	}
	
	public AbstractEntityAction(Class<EntityType> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void load() {
		if (null == id) {
			try {
				entity = entityClass.newInstance();
				afterCreation();
			} catch (InstantiationException e) {
				logger.severe("Cannot instantiate entity.");
			} catch (IllegalAccessException e) {
				logger.severe("Illegal access during instantiation.");
			}
		} else {
			entity = getEntityDao().findEntity(id);
		}
	}
	
	protected void afterCreation() {
		// Nothing to do here.
	}
	
	public String persist() {
		getEntityDao().saveOrUpdate(getEntity());
		getEntityDao().flush();
		return getNavigationTargetAfterPersist();
	}
	
	protected void beforeDeletion(EntityType entityToDelete) {
		// Nothing to do here.
	}
	
	public void delete(ID identifier) {
		EntityType entityToDelete = getEntityDao().findEntity(identifier);
		beforeDeletion(entityToDelete);
		getEntityDao().delete(entityToDelete);
		getEntityDao().flush();
	}
	
	protected abstract AbstractGenericDAO<EntityType, ID> getEntityDao();
	
	protected abstract String getNavigationTargetAfterPersist();
	
	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	public EntityType getEntity() {
		return entity;
	}

}

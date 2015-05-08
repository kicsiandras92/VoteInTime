package hu.sed.prf.vote.contoller.user;


import hu.sed.prf.javaeedemo.controller.core.AbstractEntityAction;
import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;
import hu.sed.prf.javaeedemo.dao.measurement.MeasurementDataDAO;
import hu.sed.prf.javaeedemo.dao.person.PatientDAO;
import hu.sed.prf.javaeedemo.entity.person.Patient;
import hu.sed.prf.javaeedemo.entity.place.Address;
import hu.sed.prf.vote.dao.user.UserDAO;
import hu.sed.prf.vote.entity.User;

import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped
public class UserAction extends AbstractEntityAction<User, Long> {
	
	private static final long serialVersionUID = -7067061243883686127L;
	
	@Inject
	private User user = new User("","");
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Inject
	private UserDAO userDAO;
	
	public UserAction() {
		super(User.class);
	}
	
	@Override
	protected void afterCreation() {
	}
	
	@Override
	protected void beforeDeletion(User entityToDelete) {
	}
	
	@Override
	protected AbstractGenericDAO<User, Long> getEntityDao() {
		return userDAO;
	}

	@Override
	protected String getNavigationTargetAfterPersist() {
		return "/home?faces-redirect=true";
	}
	
	public String persist() {
		getEntityDao().saveOrUpdate(user);
		getEntityDao().flush();
		return getNavigationTargetAfterPersist();
	}

}

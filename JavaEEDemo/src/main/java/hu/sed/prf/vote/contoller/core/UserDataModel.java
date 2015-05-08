package hu.sed.prf.vote.contoller.core;

import hu.sed.prf.javaeedemo.controller.core.AbstractDataModel;
import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;
import hu.sed.prf.vote.dao.user.UserDAO;
import hu.sed.prf.vote.entity.User;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped
public class UserDataModel extends AbstractDataModel<User, Long> {
	
	private static final long serialVersionUID = -7210487598216166015L;
	
	@Inject
	private UserDAO patientDAO;

	@Override
	protected AbstractGenericDAO<User, Long> getEntityDao() {
		return patientDAO;
	}

	
}

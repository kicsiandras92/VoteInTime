package hu.sed.prf.vote.dao.user;

import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;
import hu.sed.prf.vote.entity.User;

public class UserDAO extends AbstractGenericDAO<User, Long> {

	private static final long serialVersionUID = -5859058016736013679L;

	public UserDAO() {
		super(User.class);
	}

}

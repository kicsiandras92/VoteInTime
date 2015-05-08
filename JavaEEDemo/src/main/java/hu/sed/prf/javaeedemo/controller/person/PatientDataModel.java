package hu.sed.prf.javaeedemo.controller.person;

import hu.sed.prf.javaeedemo.controller.core.AbstractDataModel;
import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;
import hu.sed.prf.javaeedemo.dao.person.PatientDAO;
import hu.sed.prf.javaeedemo.entity.person.Patient;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PatientDataModel extends AbstractDataModel<Patient, Long> {
	
	private static final long serialVersionUID = -7210487598216166015L;
	
	@Inject
	private PatientDAO patientDAO;

	@Override
	protected AbstractGenericDAO<Patient, Long> getEntityDao() {
		return patientDAO;
	}

}

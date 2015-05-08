package hu.sed.prf.javaeedemo.dao.measurement;

import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;
import hu.sed.prf.javaeedemo.entity.measurement.MeasurementData;
import hu.sed.prf.javaeedemo.entity.person.Patient;

import java.util.List;

import org.hibernate.criterion.Restrictions;

public class MeasurementDataDAO extends AbstractGenericDAO<MeasurementData, Long> {

	private static final long serialVersionUID = -7092750617722161406L;

	public MeasurementDataDAO() {
		super(MeasurementData.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<MeasurementData> findByPatient(Patient patient) {
		return getSession().createCriteria(getPersistentClass())
				.add(Restrictions.eq("patient", patient))
				.list();
	}
	
	public void deleteByPatient(Patient patient) {
		List<MeasurementData> measurementDataList = findByPatient(patient);
		for (MeasurementData measurementData : measurementDataList) {
			delete(measurementData);
		}
	}

}

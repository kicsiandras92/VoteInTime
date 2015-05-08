package hu.sed.prf.javaeedemo.dao.measurement;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import hu.sed.prf.javaeedemo.dao.core.AbstractGenericDAO;
import hu.sed.prf.javaeedemo.entity.measurement.WeightData;
import hu.sed.prf.javaeedemo.entity.person.Patient;

public class WeightDataDAO extends AbstractGenericDAO<WeightData, Long> {

	private static final long serialVersionUID = 1286322127054098460L;

	public WeightDataDAO() {
		super(WeightData.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<WeightData> findByPatient(Patient patient) {
		return getSession().createCriteria(getPersistentClass())
				.add(Restrictions.eq("patient", patient))
				.list();
	}

}

package hu.sed.prf.javaeedemo.controller.measurement;

import hu.sed.prf.javaeedemo.controller.person.SelectedPatientContainer;
import hu.sed.prf.javaeedemo.dao.measurement.WeightDataDAO;
import hu.sed.prf.javaeedemo.entity.measurement.WeightData;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named
@ViewScoped
public class WeightDataChartModel implements Serializable {
	
	private static final long serialVersionUID = -7163076716074474372L;
	
	@Inject
	private WeightDataDAO weightDataDAO;
	
	@Inject
	private SelectedPatientContainer selectedPatientContainer;
	
	private LineChartModel chartModel;
	
	public void initialize() {
		chartModel = new LineChartModel();
		
		DateAxis dateAxis = new DateAxis();
		dateAxis.setTickAngle(-50);
		chartModel.getAxes().put(AxisType.X, dateAxis);
		
		LineChartSeries lineChartSeries = new LineChartSeries();
		List<WeightData> weightDataList = weightDataDAO.findByPatient(selectedPatientContainer.getSelectedPatient());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (WeightData weightData : weightDataList) {
			lineChartSeries.set(dateFormat.format(weightData.getDate()), weightData.getWeight());
		}
		chartModel.addSeries(lineChartSeries);
	}
	
	public LineChartModel getChartModel() {
		return chartModel;
	}

}

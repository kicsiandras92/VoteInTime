package hu.sed.prf.javaeedemo.util.locale;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class LanguageSelector implements Serializable {

	private static final long serialVersionUID = -8878641077025689842L;
	
	private static final String DEFAULT_LANGUAGE = "hu";
	
	private Locale selectedLocale = new Locale(DEFAULT_LANGUAGE);
	
	public void selectLanguage(String language) {
		selectedLocale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(selectedLocale);
	}
	
	public Locale getSelectedLocale() {
		return selectedLocale;
	}
	
	public void setSelectedLocale(Locale selectedLocale) {
		this.selectedLocale = selectedLocale;
	}

}

package pl.shop.javaee.domain;

import java.util.Date;

public class Newsletter {

	private Date odCzasu = null;
	private Date doCzasu = null;
	private String czestotliwosc = "";
	private boolean nowe_produkty = false;
	private boolean nowe_promocje = false;
	public Newsletter() {
		super();
	}
	public Newsletter(Date odCzasu, Date doCzasu, String czestotliwosc, boolean nowe_produkty, boolean nowe_promocje) {
		super();
		this.odCzasu = odCzasu;
		this.doCzasu = doCzasu;
		this.czestotliwosc = czestotliwosc;
		this.nowe_produkty = nowe_produkty;
		this.nowe_promocje = nowe_promocje;
	}
	public Date getOdCzasu() {
		return odCzasu;
	}
	public void setOdCzasu(Date odCzasu) {
		this.odCzasu = odCzasu;
	}
	public Date getDoCzasu() {
		return doCzasu;
	}
	public void setDoCzasu(Date doCzasu) {
		this.doCzasu = doCzasu;
	}
	public String getCzestotliwosc() {
		return czestotliwosc;
	}
	public void setCzestotliwosc(String czestotliwosc) {
		this.czestotliwosc = czestotliwosc;
	}
	public boolean isNowe_produkty() {
		return nowe_produkty;
	}
	public void setNowe_produkty(boolean nowe_produkty) {
		this.nowe_produkty = nowe_produkty;
	}
	public boolean isNowe_promocje() {
		return nowe_promocje;
	}
	public void setNowe_promocje(boolean nowe_promocje) {
		this.nowe_promocje = nowe_promocje;
	}
	
	
}

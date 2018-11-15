package pl.shop.javaee.domain;

import java.util.Date;

public class Newsletter {

	private Date odCzasu = null;
	private Date doCzasu = null;
	private String czestotliwosc = "";
	private String tematy = "";
	public Newsletter() {
		super();
	}
	public Newsletter(Date odCzasu, Date doCzasu, String czestotliwosc, String tematy) {
		super();
		this.odCzasu = odCzasu;
		this.doCzasu = doCzasu;
		this.czestotliwosc = czestotliwosc;
		this.tematy = tematy;
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
	public String getTematy() {
		return tematy;
	}
	public void setTematy(String tematy) {
		this.tematy = tematy;
	}
	
}

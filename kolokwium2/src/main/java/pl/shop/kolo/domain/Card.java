package pl.shop.kolo.domain;

import java.util.Date;

public class Card {

	private Date produkcja = null;
	private Double cena = null;
	private String producent = null;
	private int qty = 0;
	private String[] kolory =null;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(Date produkcja, Double cena, String producent, int qty, String[] kolory) {
		super();
		this.produkcja = produkcja;
		this.cena = cena;
		this.producent = producent;
		this.qty = qty;
		this.kolory = kolory;
	}
	public Date getProdukcja() {
		return produkcja;
	}
	public void setProdukcja(Date produkcja) {
		this.produkcja = produkcja;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
	public String getProducent() {
		return producent;
	}
	public void setProducent(String producent) {
		this.producent = producent;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String[] getKolory() {
		return kolory;
	}
	public void setKolory(String[] kolory) {
		this.kolory = kolory;
	}
	
	
}

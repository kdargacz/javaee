package pl.shop.javaee.domain;

import java.util.Date;

public class Tree {
	private String treeName = "unknown";
	private boolean isLeafy = true;
	private Date dataSiewu = null;
	private double cena = 0.0;
	private int qty = 0;

	public Tree() {
		super();
	}

	public Tree(String name, boolean isLeafy, Date dataSiewu, double cena, int qty) {
		super();
		this.treeName = name;
		this.isLeafy = isLeafy;
		this.dataSiewu = dataSiewu;
		this.cena = cena;
		this.qty = qty;
	}

	public String getName() {
		return treeName;
	}

	public void setName(String name) {
		this.treeName = name;
	}

	public boolean isLeafy() {
		return isLeafy;
	}

	public void setLeafy(boolean isLeafy) {
		this.isLeafy = isLeafy;
	}

	public Date getDataSiewu() {
		return dataSiewu;
	}

	public void setDataSiewu(Date dataSiewu) {
		this.dataSiewu = dataSiewu;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
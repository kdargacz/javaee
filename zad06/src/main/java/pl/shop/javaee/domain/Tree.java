package pl.shop.javaee.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Tree {

	private Long id;

	private String name;

	private boolean leafy;

	private Date dataSiewu;

	private double cena;

	private int qty;

	public Tree() {
		super();
	}

	public Tree(Long id, String name, boolean leafy, Date dataSiewu, double cena, int qty) {
		super();
		this.id = id;
		this.name = name;
		this.leafy = leafy;
		this.dataSiewu = dataSiewu;
		this.cena = cena;
		this.qty = qty;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getLeafy() {
		return leafy;
	}

	public void setLeafy(boolean leafy) {
		this.leafy = leafy;
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
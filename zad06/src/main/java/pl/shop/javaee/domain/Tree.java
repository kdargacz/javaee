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
	private String treeName = "unknown";
	private boolean isLeafy = true;
	private Date dataSiewu = null;
	private double cena = 0.0;
	private int qty = 0;

	public Tree() {
		super();
	}

	public Tree(Long id, String name, boolean isLeafy) {
		super();
		this.id = id;
		this.treeName = name;
		this.isLeafy = isLeafy;
	}
	
	public Tree(Long id, String name, boolean isLeafy, Date dataSiewu, double cena, int qty) {
		super();
		this.id = id;
		this.treeName = name;
		this.isLeafy = isLeafy;
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
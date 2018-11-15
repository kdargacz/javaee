package pl.shop.javaee.domain;

public class Rodo {

	private boolean zgoda1 = false; //zgoda cookies
	private boolean zgoda2 = false; //zgoda RODO
	private boolean zgoda3 = false; //zgoda newsletter
	
	public Rodo() {
		super();
	}

	public Rodo(boolean zgoda1, boolean zgoda2, boolean zgoda3) {
		super();
		this.zgoda1 = zgoda1;
		this.zgoda2 = zgoda2;
		this.setZgoda3(zgoda3);
	}

	public boolean isZgoda1() {
		return zgoda1;
	}

	public void setZgoda1(boolean zgoda1) {
		this.zgoda1 = zgoda1;
	}

	public boolean isZgoda2() {
		return zgoda2;
	}

	public void setZgoda2(boolean zgoda2) {
		this.zgoda2 = zgoda2;
	}

	public boolean isZgoda3() {
		return zgoda3;
	}

	public void setZgoda3(boolean zgoda3) {
		this.zgoda3 = zgoda3;
	}	
}

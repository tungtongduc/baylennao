package webTest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import webTest.enumClass.ZeitEinheit;

@Entity
@Table(name = "poll")
public class Wiederholung extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private int abstand;
	private ZeitEinheit zeiteinheit;
	
	public int getAbstand() {
		return abstand;
	}

	public void setAbstand(int abstand) {
		this.abstand = abstand;
	}

	public ZeitEinheit getZeiteinheit() {
		return zeiteinheit;
	}

	public void setZeiteinheit(ZeitEinheit zeiteinheit) {
		this.zeiteinheit = zeiteinheit;
	}

	
}

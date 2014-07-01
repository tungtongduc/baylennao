package webTest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "zeitraum")
public class Zeitraum extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private int dauerInMin;
	private Date startZeitPunkt;	

	public int getDauerInMin() {
		return dauerInMin;
	}

	public void setDauerInMin(int dauerInMin) {
		this.dauerInMin = dauerInMin;
	}

	public Date getStartZeitPunkt() {
		return startZeitPunkt;
	}

	public void setStartZeitPunkt(Date startZeitPunkt) {
		this.startZeitPunkt = startZeitPunkt;
	}
	
	
		
}

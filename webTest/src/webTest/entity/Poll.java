package webTest.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "poll")
public class Poll extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String beschreibung;
	private Date deadline;
	private Wiederholung frequenz;
	private List<Zeitraum> moeglicheZeitraeume;
	private Zeitraum ermittelterZeitraum;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="polls")
	private List<User> users;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="polls")
	private List<Group> groups;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Wiederholung getFrequenz() {
		return frequenz;
	}
	public void setFrequenz(Wiederholung frequenz) {
		this.frequenz = frequenz;
	}
	public List<Zeitraum> getMoeglicheZeitraeume() {
		return moeglicheZeitraeume;
	}
	public void setMoeglicheZeitraeume(List<Zeitraum> moeglicheZeitraeume) {
		this.moeglicheZeitraeume = moeglicheZeitraeume;
	}
	public Zeitraum getErmittelterZeitraum() {
		return ermittelterZeitraum;
	}
	public void setErmittelterZeitraum(Zeitraum ermittelterZeitraum) {
		this.ermittelterZeitraum = ermittelterZeitraum;
	}
		
	
}

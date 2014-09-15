package de.txa.eventmanager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseEntity {
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getID(){
		return id;
	}
}

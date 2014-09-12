package de.txa.web;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class EventEntity {
	
	private String name;
	private Date time;
	private String location;
	private long duration;
	
	
}

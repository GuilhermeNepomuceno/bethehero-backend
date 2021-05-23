package br.com.bethehero.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Incident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	private Double value;
	
	@ManyToOne
	private Ong ong;
	
	public Incident() {}

	public Incident(String title, String description, Double value) {
		super();
		this.title = title;
		this.description = description;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Incident [id=" + id + ", title=" + title + ", description=" + description + ", value=" + value + "]";
	}
}

package br.com.bethehero.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String email;
	private String whatsapp;
	private String city;
	private String uf;
	
	@OneToMany(mappedBy = "ong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Incident> incidents;
	
	public Ong() {}

	public Ong(String name, String email, String whatsapp, String city, String uf) {
		super();
		this.name = name;
		this.email = email;
		this.whatsapp = whatsapp;
		this.city = city;
		this.uf = uf;
		this.incidents = new ArrayList<Incident>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public List<Incident> getIncidents() {
		return incidents;
	}

	@Override
	public String toString() {
		return "Ong [id=" + id + ", name=" + name + ", email=" + email + ", whatsapp=" + whatsapp + ", city=" + city
				+ ", uf=" + uf + "]";
	}
	
	
	
}

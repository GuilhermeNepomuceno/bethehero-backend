package br.com.bethehero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bethehero.models.Incident;
import br.com.bethehero.repositories.IncidentRepository;
import br.com.bethehero.repositories.OngRepository;

@RestController
public class IncidentController {
	
	private final IncidentRepository incidentRepository;

	@Autowired
	public IncidentController(IncidentRepository incidentRepository) {
		this.incidentRepository = incidentRepository;
	}
	
	@PostMapping(path = "/incident")
	public ResponseEntity<Incident> insertIncident(@RequestBody Incident incident){
		Incident newIncident = new Incident(incident.getTitle(),
				incident.getDescription(),
				incident.getValue());
		incidentRepository.save(newIncident);
		
		return new ResponseEntity<Incident>(newIncident, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/incident")
	public ResponseEntity<Iterable<Incident>> listIncidents(){
		return new ResponseEntity<Iterable<Incident>>(incidentRepository.findAll(), HttpStatus.OK);
	}

}

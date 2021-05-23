package br.com.bethehero.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bethehero.models.Ong;
import br.com.bethehero.repositories.OngRepository;

@RestController
public class OngController {

	private final OngRepository ongRepository;

	@Autowired
	public OngController(OngRepository ongRepository) {
		this.ongRepository = ongRepository;
	}

	@GetMapping(path = "/ong")
	public List<Ong> listOng() {
		return ongRepository.findAll();
	}

	@GetMapping(path = "/ong/{id}")
	public ResponseEntity<Ong> listOng(@PathVariable Long id) {
		Ong ong = ongRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return new ResponseEntity<Ong>(ong, HttpStatus.OK);
	}
	
	@PostMapping(path = "/ong") 
	public ResponseEntity<Ong> insertOng(@RequestBody Ong newOng) { 
//		Ong ong = new Ong("Guilherme", "gui@mail.com","34988884444", "Uberabinha", "MG");
		Ong ong = new Ong(newOng.getName(),
				newOng.getEmail(),
				newOng.getWhatsapp(),
				newOng.getCity(),
				newOng.getUf());
		ongRepository.save(ong);
		return new ResponseEntity<Ong>(ong, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/ong/{id}")
	public void deleteOng(@PathVariable Long id) {
		ongRepository.deleteById(id);
	}
	
	@PutMapping(path = "/ong/{id}")
	public ResponseEntity<Ong> updateOng(@PathVariable Long id, @RequestBody Ong newOng){
		Ong ong = ongRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		ong.setCity(newOng.getCity());
		ong.setEmail(newOng.getEmail());
		ong.setName(newOng.getName());
		ong.setUf(newOng.getUf());
		ong.setWhatsapp(newOng.getWhatsapp());
		
		Ong saveOng = ongRepository.save(ong);
		return new ResponseEntity<Ong>(saveOng, HttpStatus.OK);
	}
}

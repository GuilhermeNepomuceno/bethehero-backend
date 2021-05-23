package br.com.bethehero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bethehero.models.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long>{

}

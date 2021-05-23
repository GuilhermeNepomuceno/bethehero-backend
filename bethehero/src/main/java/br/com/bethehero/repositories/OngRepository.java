package br.com.bethehero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bethehero.models.Ong;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long>{
	

}

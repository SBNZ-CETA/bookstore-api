package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.facts.Writer;

public interface WritersRepository extends JpaRepository<Writer,Long>{
    
}

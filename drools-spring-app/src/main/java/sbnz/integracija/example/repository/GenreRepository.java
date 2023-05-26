package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.facts.Genre;

public interface GenreRepository extends JpaRepository<Genre,Long>{
    
}

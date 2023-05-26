package sbnz.integracija.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import demo.facts.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long>{

    @Query(value="select * from ratings where book_id=?1", nativeQuery = true)
    Optional<List<Rating>> FindAllByBookId (Long BookId);  
}

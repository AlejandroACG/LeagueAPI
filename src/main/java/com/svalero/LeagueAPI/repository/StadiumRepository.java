package com.svalero.LeagueAPI.repository;
import com.svalero.LeagueAPI.domain.Stadium;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {
    @NonNull
    List<Stadium> findAll();
    List<Stadium> findByNameContainingIgnoreCase(String name);
}

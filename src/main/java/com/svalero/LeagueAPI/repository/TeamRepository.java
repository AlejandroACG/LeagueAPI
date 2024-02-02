package com.svalero.LeagueAPI.repository;
import com.svalero.LeagueAPI.domain.Team;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    @NonNull
    List<Team> findAll();
    List<Team> findByNameContainingIgnoreCase(String name);
}

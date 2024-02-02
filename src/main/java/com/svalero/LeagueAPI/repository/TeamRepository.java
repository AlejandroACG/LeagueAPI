package com.svalero.LeagueAPI.repository;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    @NonNull
    List<Team> findAll();
    List<Team> findByNameContainingIgnoreCase(String name);
}

package com.svalero.LeagueAPI.repository;

import lombok.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {
    @NonNull
    List<Stadium> findAll();
    List<Stadium> findByNameContainingIgnoreCase(String name);
}

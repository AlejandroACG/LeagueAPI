package com.svalero.LeagueAPI.service;
import com.svalero.LeagueAPI.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumService {
    @Autowired
    private StadiumRepository stadiumRepository;

}

package com.svalero.LeagueAPI.service;
import com.svalero.LeagueAPI.domain.Stadium;
import com.svalero.LeagueAPI.dto.StadiumOutDto;
import com.svalero.LeagueAPI.repository.StadiumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StadiumService {
    @Autowired
    private StadiumRepository stadiumRepository;
    @Autowired
    private ModelMapper modelMapper;
    private static final String ENTITY = "Stadium";

    public List<Stadium> getStadiums(String name) {
        List<Stadium> stadiumList;
        if (name == null) {
            stadiumList = stadiumRepository.findAll();
        } else {
            stadiumList = stadiumRepository.findByNameContainingIgnoreCase(name);
        }
        List<StadiumOutDto> stadiumOutDtoList = new ArrayList<>();
        for (Stadium stadium : stadiumList) {
            stadiumOutDtoList.add(modelMapper.map(stadium, StadiumOutDto.class));
        }
    }
}

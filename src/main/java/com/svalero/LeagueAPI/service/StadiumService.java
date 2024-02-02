package com.svalero.LeagueAPI.service;
import com.svalero.LeagueAPI.domain.Stadium;
import com.svalero.LeagueAPI.domain.Team;
import com.svalero.LeagueAPI.dto.StadiumInDto;
import com.svalero.LeagueAPI.dto.StadiumOutDto;
import com.svalero.LeagueAPI.exception.EntityNotFoundException;
import com.svalero.LeagueAPI.repository.StadiumRepository;
import com.svalero.LeagueAPI.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StadiumService {
    @Autowired
    private StadiumRepository stadiumRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TeamRepository teamRepository;
    private static final String ENTITY = "Stadium";

    public List<StadiumOutDto> getStadiums(String name) {
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
        return stadiumOutDtoList;
    }

    public StadiumOutDto addStadium(StadiumInDto stadiumInDto) {
        Stadium stadium = modelMapper.map(stadiumInDto, Stadium.class);

        List<Long> teamIds = stadiumInDto.getTeamIds();
        if (teamIds.isEmpty()) {
            stadium.getTeams().clear();
        } else {
            for (long teamId : teamIds) {
                Optional<Team> teamOptional = teamRepository.findById(teamId);
                if (teamOptional.isPresent()) {
                    stadium.getTeams().add(teamOptional.get());
                } else {
                    throw new EntityNotFoundException("Team", teamId);
                }
            }
        }
        return modelMapper.map(stadiumRepository.save(stadium), StadiumOutDto.class);
    }

    public StadiumOutDto getStadiumById(long id) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(id);
        if (stadiumOptional.isPresent()) {
            return modelMapper.map(stadiumOptional.get(), StadiumOutDto.class);
        } else {
            throw new EntityNotFoundException(ENTITY, id);
        }
    }

    public StadiumOutDto updateStadium(long id, StadiumInDto stadiumInDto) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(id);
        if (stadiumOptional.isPresent()) {
            Stadium stadium =stadiumOptional.get();
            modelMapper.map(stadiumInDto, stadium);
            List<Long> teamIds = stadiumInDto.getTeamIds();
            if (teamIds.isEmpty()) {
                stadium.getTeams().clear();
            } else {
                List<Team> teams = new ArrayList<>();
                for (long teamId : teamIds) {
                    Optional<Team> teamOptional = teamRepository.findById(teamId);
                    if (teamOptional.isPresent()) {
                        teams.add(teamOptional.get());
                    } else {
                        throw new EntityNotFoundException("Team", id);
                    }
                }
                stadium.setTeams(teams);
            }
            return modelMapper.map(stadiumRepository.save(stadium), StadiumOutDto.class);
        } else {
            throw new EntityNotFoundException(ENTITY, id);
        }
    }

    public void deleteStadium(long id) {
        if (stadiumRepository.existsById(id)) {
            stadiumRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(ENTITY, id);
        }
    }
}

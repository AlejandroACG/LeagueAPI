package com.svalero.LeagueAPI.service;
import com.svalero.LeagueAPI.domain.Team;
import com.svalero.LeagueAPI.dto.TeamInDto;
import com.svalero.LeagueAPI.dto.TeamOutDto;
import com.svalero.LeagueAPI.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TeamOutDto> getTeams(String name) {
        List<Team> teamList;
        if (name == null) {
            teamList = teamRepository.findAll();
        } else {
            teamList = teamRepository.findByNameContainingIgnoreCase(name);
        }

        List <TeamOutDto> teamOutDtoList = new ArrayList<>();
        for (Team team : teamList) {
            teamOutDtoList.add(modelMapper.map(team, TeamOutDto.class));
        }
        return teamOutDtoList;
    }

    public TeamOutDto addTeam(TeamInDto teamInDto) {

    }
}

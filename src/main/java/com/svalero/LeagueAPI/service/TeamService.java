package com.svalero.LeagueAPI.service;
import com.svalero.LeagueAPI.domain.Team;
import com.svalero.LeagueAPI.dto.TeamInDto;
import com.svalero.LeagueAPI.dto.TeamOutDto;
import com.svalero.LeagueAPI.exception.EntityNotFoundException;
import com.svalero.LeagueAPI.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ModelMapper modelMapper;
    private static final String ENTITY = "Team";

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
        Team team = modelMapper.map(teamInDto, Team.class);
        return modelMapper.map(teamRepository.save(team), TeamOutDto.class);
    }

    public TeamOutDto getTeamById(long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            return modelMapper.map(teamOptional.get(), TeamOutDto.class);
        } else {
            throw new EntityNotFoundException(ENTITY, id);
        }
    }

    public TeamOutDto updateTeam(long id, TeamInDto teamInDto) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            modelMapper.map(teamInDto, team);
            return modelMapper.map(teamRepository.save(team), TeamOutDto.class);
        } else {
            throw new EntityNotFoundException(ENTITY, id);
        }
    }

    public void deleteTeam(long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(ENTITY, id);
        }
    }
}

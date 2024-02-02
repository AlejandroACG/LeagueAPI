package com.svalero.LeagueAPI.controller;
import com.svalero.LeagueAPI.dto.TeamInDto;
import com.svalero.LeagueAPI.dto.TeamOutDto;
import com.svalero.LeagueAPI.service.TeamService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    private final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @GetMapping("/teams")
    public ResponseEntity<List<TeamOutDto>> getTeams(@RequestParam(required = false) String name) {
        logger.info("ini GET /teams");
        List<TeamOutDto> teamOutDtoList = teamService.getTeams(name);
        logger.info("end GET /teams");
        return ResponseEntity.ok(teamOutDtoList);
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamOutDto> addTeam(@Valid @RequestBody TeamInDto teamInDto) {
        logger.info("ini POST /teams");
        TeamOutDto teamOutDto = teamService.addTeam(teamInDto);
        logger.info("end POST /teams");
        return ResponseEntity.status(HttpStatus.CREATED).body(teamOutDto);
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<TeamOutDto> getTeamById(@PathVariable long id) {
        logger.info("ini GET /team/" + id);
        TeamOutDto teamOutDto = teamService.getTeamById(id);
        logger.info("end GET /team/" + id);
        return ResponseEntity.ok(teamOutDto);
    }

    @PutMapping("/team/{id}")
    public ResponseEntity<TeamOutDto> updateTeam(@PathVariable long id,
                                                 @Valid @RequestBody TeamInDto teamInDto) {
        logger.info("ini PUT /team/" + id);
        TeamOutDto teamOutDto = teamService.updateTeam(id, teamInDto);
        logger.info("end PUT /team/" + id);
        return ResponseEntity.ok(teamOutDto);
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable long id) {
        logger.info("ini DELETE /team/" + id);
        teamService.deleteTeam(id);
        logger.info("end DELETE /team/" + id);
        return ResponseEntity.noContent().build();
    }
}

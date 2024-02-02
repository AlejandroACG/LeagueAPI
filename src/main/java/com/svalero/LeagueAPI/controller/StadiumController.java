package com.svalero.LeagueAPI.controller;
import com.svalero.LeagueAPI.dto.StadiumInDto;
import com.svalero.LeagueAPI.dto.StadiumOutDto;
import com.svalero.LeagueAPI.service.StadiumService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StadiumController {
    @Autowired
    private StadiumService stadiumService;
    private final Logger logger = LoggerFactory.getLogger(StadiumController.class);

    @GetMapping("/stadiums")
    public ResponseEntity<List<StadiumOutDto>> getStadiums(@RequestParam(required = false) String name) {
        logger.info("ini GET /stadiums");
        List<StadiumOutDto> stadiumOutDtoList = stadiumService.getStadiums(name);
        logger.info("end GET /stadiums");
        return ResponseEntity.ok(stadiumOutDtoList);
    }

    @PostMapping("/stadiums")
    public ResponseEntity<StadiumOutDto> addStadium(@Valid @RequestBody StadiumInDto stadiumInDto) {
        logger.info("ini POST /stadiums");
        StadiumOutDto stadiumOutDto = stadiumService.addStadium(stadiumInDto);
        logger.info("end POST /stadiums");
        return ResponseEntity.status(HttpStatus.CREATED).body(stadiumOutDto);
    }

    @GetMapping("/stadium/{id}")
    public ResponseEntity<StadiumOutDto> getStadiumById(@PathVariable long id) {
        logger.info("ini GET /stadium/" + id);
        StadiumOutDto stadiumOutDto = stadiumService.getStadiumById(id);
        logger.info("end GET /stadium/" + id);
        return ResponseEntity.ok(stadiumOutDto);
    }

    @PutMapping("/stadium/{id}")
    public ResponseEntity<StadiumOutDto> updateStadium(@PathVariable long id,
                                                       @Valid @RequestBody StadiumInDto stadiumInDto) {
        logger.info("ini PUT /stadium/" + id);
        StadiumOutDto stadiumOutDto = stadiumService.updateStadium(id, stadiumInDto);
        logger.info("end PUT /stadium/" + id);
        return ResponseEntity.ok(stadiumOutDto);
    }

    @DeleteMapping("/stadium/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable long id) {
        logger.info("ini DELETE /stadium/" + id);
        stadiumService.deleteStadium(id);
        logger.info("end DELETE /stadium/" + id);
        return ResponseEntity.noContent().build();
    }
}

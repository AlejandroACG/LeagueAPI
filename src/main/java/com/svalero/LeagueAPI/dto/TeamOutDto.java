package com.svalero.LeagueAPI.dto;
import com.svalero.LeagueAPI.domain.Stadium;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamOutDto {
    private long id;
    private String name;
    private LocalDate foundationDate;
    private Boolean areChampions;
    private int leaguePoints;
    private List<Stadium> stadiums;
}

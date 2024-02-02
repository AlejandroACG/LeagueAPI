package com.svalero.LeagueAPI.dto;
import com.svalero.LeagueAPI.domain.Team;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadiumOutDto {
    private long id;
    private String name;
    private LocalDate constructionDate;
    private Boolean adaptedAccess;
    private float latitude;
    private float longitude;
    private List<Team> teams;
}

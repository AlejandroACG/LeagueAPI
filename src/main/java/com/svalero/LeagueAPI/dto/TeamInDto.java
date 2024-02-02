package com.svalero.LeagueAPI.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamInDto {

    @NotNull(message = "Team name is obligatory.")
    private String name;
    private LocalDate foundationDate;
    private Boolean areChampions;
    @PositiveOrZero(message = "The lowest score is zero.")
    private int leaguePoints;
}

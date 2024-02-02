package com.svalero.LeagueAPI.dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StadiumInDto {

    @NotNull(message = "Stadium name is obligatory.")
    private String name;
    private LocalDate constructionDate;
    private Boolean adaptedAccess;
    private float latitude;
    private float longitude;
    private List<Long> teamIds;
}

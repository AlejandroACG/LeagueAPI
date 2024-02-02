package com.svalero.LeagueAPI.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "teams")

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;
    @Column(name = "are_champions")
    private Boolean areChampions;
    @Column(name = "league_points")
    private int leaguePoints;
    @OneToMany(mappedBy = "teams")
    @JsonManagedReference
    private List<Stadium> stadiums;
}

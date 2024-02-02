package com.svalero.LeagueAPI.domain;

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
    private long id;
    @Column
    private String name;
    @Column
    private LocalDate foundationDate;
    @Column
    private Boolean areChampion;
    @Column
    private int leaguePoints;


    @OneToMany(mappedBy = "team")
    private List<Stadium> stadiums;
}

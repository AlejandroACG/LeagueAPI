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
@Entity(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private LocalDate constructionDate;
    @Column
    private Boolean adaptedAccess;
    @Column
    private float latitude;
    @Column
    private float longitude;


    @OneToOne(mappedBy = "stadium")
    private List<Teams> teams;

}

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
    @Column
    private long id;
    @Column
    private String name;
    @Column(name = "construction_date")
    private LocalDate constructionDate;
    @Column(name = "adapted_access")
    private Boolean adaptedAccess;
    @Column
    private float latitude;
    @Column
    private float longitude;
    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private List<Team> teams;
}

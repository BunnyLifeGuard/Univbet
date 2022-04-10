package com.univbet.Entities;

import com.univbet.Enums.Status;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllGames", query = "select m from MatchEntity m"),
        @NamedQuery(name = "updateStatus", query = "update MatchEntity m SET m.status = :status where m.id = :id"),
        @NamedQuery(name = "findThreeOldGames", query = "select m from MatchEntity m where m.status = 0"),
        @NamedQuery(name = "findThreeNewGames", query = "select m from MatchEntity m where m.status = 1")
})
public class MatchEntity {
    @GeneratedValue
    @Id
    private Long id;
    @NotNull
    private String equipeA;
    @NotNull
    private String equipeB;
    @Column(nullable = true)
    private String resultat;
    @NotNull
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipeA() {
        return equipeA;
    }

    public void setEquipeA(String equipeA) {
        this.equipeA = equipeA;
    }

    public String getEquipeB() {
        return equipeB;
    }

    public void setEquipeB(String equipeB) {
        this.equipeB = equipeB;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

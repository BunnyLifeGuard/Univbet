package com.univbet.DTO;

import com.univbet.Ejbs.Match;
import com.univbet.Entities.MatchEntity;
import com.univbet.Enums.Status;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("Match")
@SessionScoped
public class MatchDto implements Serializable {

    @EJB
    private Match matchBean;

    private long id;
    private String equipeA;
    private String equipeB;
    private String resultat;
    private String status;

    public MatchDto() {}

    public MatchDto(MatchEntity match){
        this.id = match.getId();
        this.equipeA = match.getEquipeA();
        this.equipeB = match.getEquipeB();
        this.resultat = match.getResultat();
        this.status = match.getStatus().toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getStatus() {
        return status;
    }

    public List<Status> getStatuts() {
        return Arrays.asList(Status.values());
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addGame(MatchDto match) {
        this.matchBean.addGame(this);
    }

    public List<MatchDto> getMatches() {
        return this.matchBean.getMatches();
    }

    public void updateStatus(ValueChangeEvent event, long id) {
        this.matchBean.updateStatus(event, this.id);
    }

    public List<MatchDto> getOldGames() {
        return this.matchBean.getOldGames();
    }

    public List<MatchDto> getNewGames() {
        return this.matchBean.getNewGames();
    }
}

package com.univbet.DTO;

import com.univbet.Ejbs.League;
import com.univbet.Entities.LeagueEntity;
import jdk.jfr.Name;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("League")
@SessionScoped
public class LeagueDto implements Serializable {
    private String name;

    @EJB
    private League leagueBean;

    private LeagueDto() {}

    public LeagueDto(LeagueEntity league) {
        this.name = league.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

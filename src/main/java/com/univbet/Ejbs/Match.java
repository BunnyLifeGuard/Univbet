package com.univbet.Ejbs;

import com.univbet.DTO.MatchDto;

import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import java.util.List;

public interface Match {
    public List<MatchDto> getMatches();
    public void updateStatus(ValueChangeEvent event, long id);
    public void addGame(MatchDto match);
    public List<MatchDto> getOldGames();
    public List<MatchDto> getNewGames();
}

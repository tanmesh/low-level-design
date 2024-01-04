package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Enum.MatchType;

import java.util.List;

@Getter
@Setter
public class Inning {
    private Team teamBat;
    private Team teamBowl;
    private List<Over> overs;
    private MatchType matchType;
    private int totalRuns;

    public Inning(Team teamBat, Team teamBowl, MatchType matchType) {
        this.teamBat = teamBat;
        this.teamBowl = teamBowl;
        this.matchType = matchType;
    }

    public void start(int i) {
    }
}

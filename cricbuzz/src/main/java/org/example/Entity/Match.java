package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Enum.MatchType;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Match {
    private List<Inning> innings;
    private MatchType matchType;
    private Team teamA;
    private Team teamB;
    private Team tossWinner;
    private Date matchDate;
    private Time matchStartTime;
    private Time matchEndTime;
    private Location location;

    public Match(MatchType matchType, Team a, Team b) {
        this.matchType = matchType;
        this.teamA = a;
        this.teamB = b;
    }

    public void startMatch() {
        tossWinner = toss(teamA, teamB);

        for (int i = 1; i <= 2; ++i) {
            Inning inning;
            Team bowlingTeam;
            Team battingTeam;

            if (i == 1) {
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getName().equals(teamA.getName()) ? teamB : teamA;
                inning = new Inning(battingTeam, bowlingTeam, matchType);
                inning.start(-1);
            } else {
                battingTeam = tossWinner.getName().equals(teamA.getName()) ? teamB : teamA;
                bowlingTeam = tossWinner;
                inning = new Inning(battingTeam, bowlingTeam, matchType);
                inning.start(innings.get(0).getTotalRuns());
                if(bowlingTeam.getTotalRunsScored() > battingTeam.getTotalRunsScored()) {
                    bowlingTeam.setWinner(true);
                } else {
                    battingTeam.setWinner(true);
                }
            }
        }
    }

    private Team toss(Team teamA, Team teamB) {
        if (Math.random() < 0.5) {
            return teamA;
        } else {
            return teamB;
        }
    }
}

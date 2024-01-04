package org.example;

import org.example.Entity.Match;
import org.example.Entity.Team;
import org.example.Enum.MatchType;
import org.example.Enum.PlayerType;

public class Cricbuzz {
    public static void main(String[] args) {
        Team teamA = getTeam();

        Team teamB = getTeamB();

        Match match = new Match(MatchType.T20, teamA, teamB);
        match.startMatch();
    }

    private static Team getTeamB() {
        Team teamB = new Team("Australia");
        teamB.addPlayer("Smith", PlayerType.BATTER);
        teamB.addPlayer("Warner", PlayerType.BATTER);
        teamB.addPlayer("Cummins", PlayerType.BOWLER);
        teamB.addPlayer("Starc", PlayerType.BOWLER);
        teamB.addPlayer("Labuschagne", PlayerType.BATTER);
        teamB.addPlayer("Hazlewood", PlayerType.BOWLER);
        teamB.addPlayer("Wade", PlayerType.BATTER);
        teamB.addPlayer("Lyon", PlayerType.BOWLER);
        teamB.addPlayer("Head", PlayerType.BATTER);
        teamB.addPlayer("Paine", PlayerType.BATTER);
        teamB.addPlayer("Green", PlayerType.ALL_ROUNDER);
        teamB.addPlayer("Neser", PlayerType.BOWLER);
        teamB.addPlayer("Khawaja", PlayerType.BATTER);
        teamB.addPlayer("Agar", PlayerType.ALL_ROUNDER);
        teamB.addPlayer("Richardson", PlayerType.BOWLER);
        return teamB;
    }

    private static Team getTeam() {
        Team teamA = new Team("India");
        teamA.addPlayer("Dhoni", PlayerType.CAPTAIN);
        teamA.addPlayer("Kohli", PlayerType.BATTER);
        teamA.addPlayer("Rohit", PlayerType.BATTER);
        teamA.addPlayer("Bumrah", PlayerType.BOWLER);
        teamA.addPlayer("Jadeja", PlayerType.ALL_ROUNDER);
        teamA.addPlayer("Rahul", PlayerType.BATTER);
        teamA.addPlayer("Shami", PlayerType.BOWLER);
        teamA.addPlayer("Pandya", PlayerType.ALL_ROUNDER);
        teamA.addPlayer("Ashwin", PlayerType.BOWLER);
        teamA.addPlayer("Iyer", PlayerType.BATTER);
        teamA.addPlayer("Chahal", PlayerType.BOWLER);
        teamA.addPlayer("Pant", PlayerType.BATTER);
        teamA.addPlayer("Bhuvi", PlayerType.BOWLER);
        teamA.addPlayer("Shreyas", PlayerType.BATTER);
        teamA.addPlayer("Kuldeep", PlayerType.BOWLER);
        return teamA;
    }
}
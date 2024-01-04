package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Controller.BattingScoreboardUpdater;
import org.example.Controller.BowlingScoreboardUpdater;
import org.example.Controller.ScoreboardUpdater;
import org.example.Enum.BallType;
import org.example.Enum.RunType;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Ball {
    private Player bowler;
    private Player batter;
    private BallType ballType;
    private RunType runType;
    private int number;
    private List<ScoreboardUpdater> scoreboardUpdaterList;

    public Ball(BattingScoreboardUpdater battingScoreboardUpdater, BowlingScoreboardUpdater bowlingScoreboardUpdater) {
        this.scoreboardUpdaterList = Arrays.asList(battingScoreboardUpdater, bowlingScoreboardUpdater);
    }
}

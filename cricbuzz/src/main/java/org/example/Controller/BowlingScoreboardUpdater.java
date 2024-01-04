package org.example.Controller;

import org.example.Entity.Ball;
import org.example.Enum.BallType;
import org.example.Enum.RunType;

public class BowlingScoreboardUpdater implements ScoreboardUpdater {
    @Override
    public void update(Ball ball) {
        if (ball.getNumber() == 6 && ball.getBallType() == BallType.NORMAL) {
            int cnt = ball.getBowler().getBowlingScoreboard().getTotalOverBowled();
            ball.getBowler().getBowlingScoreboard().setTotalOverBowled(cnt + 1);
        }

        int runs = ball.getBowler().getBowlingScoreboard().getTotalRunsGiven();
        if (RunType.ONE == ball.getRunType()) {
            ball.getBowler().getBowlingScoreboard().setTotalRunsGiven(runs + 1);
        } else if (RunType.TWO == ball.getRunType()) {
            ball.getBowler().getBowlingScoreboard().setTotalRunsGiven(runs + 2);
        } else if (RunType.FOUR == ball.getRunType()) {
            ball.getBowler().getBowlingScoreboard().setTotalRunsGiven(runs + 4);
        } else if (RunType.SIX == ball.getRunType()) {
            ball.getBowler().getBowlingScoreboard().setTotalRunsGiven(runs + 6);
        }

        if (ball.getBallType() == BallType.WICKET) {
            int totalWickets = ball.getBowler().getBowlingScoreboard().getWicketTaken();
            ball.getBowler().getBowlingScoreboard().setWicketTaken(totalWickets + 1);
        }
    }
}

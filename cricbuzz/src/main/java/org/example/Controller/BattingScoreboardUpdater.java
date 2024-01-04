package org.example.Controller;

import org.example.Entity.Ball;
import org.example.Enum.BallType;
import org.example.Enum.RunType;

public class BattingScoreboardUpdater implements ScoreboardUpdater {
    @Override
    public void update(Ball ball) {
        int run = ball.getBatter().getBattingScoreboard().getTotalRunScored();

        if (RunType.ONE == ball.getRunType()) {
            ball.getBatter().getBattingScoreboard().setTotalRunScored(run + 1);
        } else if (RunType.TWO == ball.getRunType()) {
            ball.getBatter().getBattingScoreboard().setTotalRunScored(run + 2);
        } else if (RunType.FOUR == ball.getRunType()) {
            ball.getBatter().getBattingScoreboard().setTotalRunScored(run + 4);

            int fours = ball.getBatter().getBattingScoreboard().getTotalFours();
            ball.getBatter().getBattingScoreboard().setTotalFours(fours + 1);
        } else if (RunType.SIX == ball.getRunType()) {
            ball.getBatter().getBattingScoreboard().setTotalRunScored(run + 6);

            int sixs = ball.getBatter().getBattingScoreboard().getTotalSix();
            ball.getBatter().getBattingScoreboard().setTotalSix(sixs + 1);
        }

        int ballFaced = ball.getBatter().getBattingScoreboard().getTotalBowlsFaced();
        ball.getBatter().getBattingScoreboard().setTotalBowlsFaced(ballFaced + 1);

        if (ball.getBallType() == BallType.WICKET) {
            ball.getBatter().getBattingScoreboard().setWicketDetails(ball);
        }
    }
}

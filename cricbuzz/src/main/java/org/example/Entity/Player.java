package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Enum.PlayerType;

@Getter
@Setter
public class Player {
    private String name;
    private PlayerType playerType;
    private BattingScoreboard battingScoreboard;
    private BowlingScoreboard bowlingScoreboard;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }
}

package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Enum.PlayerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Team {
    private List<Player> playing = new ArrayList<>();
    private ArrayList<Player> bench = new ArrayList<>();
    private String name;
    private Integer totalRunsScored;
    private boolean isWinner;
    private PlayerBattingController playerBattingController;
    private PlayerBowlingController playerBowlingController;

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(String playerName, PlayerType playerType) {
        Player player = new Player(playerName, playerType);
        bench.add(player);
    }

    public List<Player> getPlayingEleven() {
        Collections.shuffle(bench, new Random());
        playing = bench.subList(0, 11);
        return playing;
    }
}

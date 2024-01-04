package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Entity.Player;

import java.util.Deque;
import java.util.Map;

@Getter
@Setter
public class PlayerBowlingController {
    private Deque<Player> blowers;
    private Map<Player, Integer> overBowled;
    private Player currentBowler;
}

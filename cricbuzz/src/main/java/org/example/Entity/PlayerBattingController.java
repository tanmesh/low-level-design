package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Entity.Player;

import java.util.Queue;

@Getter
@Setter
public class PlayerBattingController {
    private Queue<Player> yetToPlay;
    private Player atStrikerEnd;
    private Player atNonStrikerEnd;
}

package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BattingScoreboard {
    private int totalBowlsFaced;
    private int totalRunScored;
    private double strikeRate;
    private int totalFours;
    private int totalSix;
    private Ball wicketDetails;
}

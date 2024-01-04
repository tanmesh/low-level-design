package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BowlingScoreboard {
    private int totalOverBowled;
    private int totalRunsGiven;
    private double economy;
    private int wicketTaken;
    private int extras;
}

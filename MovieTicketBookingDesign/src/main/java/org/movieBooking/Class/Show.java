package org.movieBooking.Class;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private int showStartTime;
    private List<Integer> bookedSeatId = new ArrayList<>();

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<Integer> getBookedSeatId() {
        return bookedSeatId;
    }

    public void setBookedSeatId(List<Integer> bookedSeatId) {
        this.bookedSeatId = bookedSeatId;
    }
}

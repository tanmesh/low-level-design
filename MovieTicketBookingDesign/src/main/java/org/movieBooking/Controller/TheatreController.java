package org.movieBooking.Controller;

import org.movieBooking.Class.Movie;
import org.movieBooking.Class.Show;
import org.movieBooking.Enum.City;
import org.movieBooking.Class.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    private Map<City, List<Theatre>> cityVsTheatre;
    private List<Theatre> allTheatre;

    public Map<City, List<Theatre>> getCityVsTheatre() {
        return cityVsTheatre;
    }

    public void setCityVsTheatre(Map<City, List<Theatre>> cityVsTheatre) {
        this.cityVsTheatre = cityVsTheatre;
    }

    public List<Theatre> getAllTheatre() {
        return allTheatre;
    }

    public void setAllTheatre(List<Theatre> allTheatre) {
        this.allTheatre = allTheatre;
    }

    public TheatreController() {
        this.cityVsTheatre = new HashMap<>();
        this.allTheatre = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityVsTheatre.get(city);

        for (Theatre theatre : theatres) {
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShowList();

            for (Show show : shows) {
                if (show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if (!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;

    }
}

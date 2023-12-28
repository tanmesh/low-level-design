package org.movieBooking.Controller;

import org.movieBooking.Enum.City;
import org.movieBooking.Class.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    private Map<City, List<Movie>> cityVsMovies;
    private List<Movie> allMovies;

    public Map<City, List<Movie>> getCityVsMovies() {
        return cityVsMovies;
    }

    public void setCityVsMovies(Map<City, List<Movie>> cityVsMovies) {
        this.cityVsMovies = cityVsMovies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public MovieController() {
        this.cityVsMovies = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {
        for (Movie movie : allMovies) {
            if ((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.get(city);
    }
}

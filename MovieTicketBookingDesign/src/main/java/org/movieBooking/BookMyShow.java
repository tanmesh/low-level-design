package org.movieBooking;

import org.movieBooking.Class.*;
import org.movieBooking.Controller.MovieController;
import org.movieBooking.Controller.TheatreController;
import org.movieBooking.Enum.City;
import org.movieBooking.Enum.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    private MovieController movieController;
    private TheatreController theatreController;

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.Bangalore, "Baahubali");
        //user2
        bookMyShow.createBooking(City.Bangalore, "Baahubali");
    }

    private void createBooking(City city, String movieName) {
        List<Movie> movies = movieController.getMoviesByCity(city);

        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, city);

        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        int seatNumber = 30; // always booking seat number 30
        List<Integer> bookedSeats = interestedShow.getBookedSeatId();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeatList()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeatList(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }


    private void initialize() {
        createMovies();

        createTheatre();
    }

    private void createTheatre() {
        Movie avengerMovie = movieController.getMovieByName("Avengers");
        Movie baahubali = movieController.getMovieByName("Baahubali");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreenList(createScreen());
        inoxTheatre.setCity(City.Bangalore);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreenList().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreenList().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShowList(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreenList(createScreen());
        pvrTheatre.setCity(City.Delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreenList().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreenList().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShowList(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.Bangalore);
        theatreController.addTheatre(pvrTheatre, City.Delhi);
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen = new Screen();
        screen.setScreenId(1);
        screen.setSeatList(createSeats());
        screens.add(screen);
        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }


    private void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("Avengers");
        avengers.setMovieDurationInMinutes(128);

        Movie baahubali = new Movie();
        baahubali.setMovieId(1);
        baahubali.setMovieName("Baahubali");
        baahubali.setMovieDurationInMinutes(180);

        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(baahubali, City.Bangalore);
        movieController.addMovie(baahubali, City.Delhi);
    }
}

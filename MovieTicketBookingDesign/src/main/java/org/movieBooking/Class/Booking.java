package org.movieBooking.Class;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Show show;
    private List<Seat> seatList = new ArrayList<>();
    private Payment payment;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

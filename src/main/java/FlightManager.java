import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FlightManager {

    Flight flight;

    public FlightManager (Flight flight) {
        this.flight = flight;
    }

    public int getPassengerBaggageWeight(Passenger passenger) {
        return passenger.getNumberOfBags() * 15;
    }

    public int getTotalPassengerBaggageWeight() {
        int totalWeight = 0;
        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
        for (Passenger passenger : flightPassengers) {
            totalWeight += getPassengerBaggageWeight(passenger);
        }

        return totalWeight;
    }

    public int getFlightBaggageWeight() {
        return this.flight.getPlane().getTotalWeight() / 2;
    }

    public int calculateRemainingBaggageWeight() {
        return this.getFlightBaggageWeight() - this.getTotalPassengerBaggageWeight();
    }

    public void assignFlightToPassenger() {
        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
        for (Passenger passenger : flightPassengers) {
            passenger.setFlight(this.flight);
        }
    }

    public void bookPassengerOntoFlight(Passenger passenger) {
        this.flight.addPassengerToFlight(passenger);
        this.assignFlightToPassenger();
//        int passengerSeatNumber = this.getRandomSeatNumber();
//        boolean duplicateSeat = true;
//        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
//        while (duplicateSeat) {
//            duplicateSeat = false;
//            for (Passenger flightPassenger : flightPassengers) {
//                if (flightPassenger.getSeatNumber() == passengerSeatNumber) {
//                    duplicateSeat = true;
//                    passengerSeatNumber = this.getRandomSeatNumber();
//                }
//            }
//        }
//        passenger.setSeatNumber(passengerSeatNumber);
//        System.out.println(passengerSeatNumber);
    }

//    public ArrayList getShuffledSeatNumbers() {
//        ArrayList<Integer> seatNumbers = new ArrayList<>();
//        int seatNumber = 1;
//        int totalSeats = this.flight.getTotalSeats();
//
//        while (seatNumbers.size() < totalSeats) {
//            seatNumbers.add(seatNumber);
//            seatNumber ++;
//        }
//        Collections.shuffle(seatNumbers);
//        return seatNumbers;
//    }
//
//    public int getRandomSeatNumber() {
//        ArrayList<Integer> seatNumbers = this.getShuffledSeatNumbers();
//        int seatNumber = seatNumbers.remove(0);
////        System.out.println(seatNumber);
//        return seatNumber;
//    }
}

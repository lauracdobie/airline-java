import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FlightManager {

    Flight flight;

    public FlightManager (Flight flight) {
        this.flight = flight;
    }

    public int getPassengerBaggageWeight(Passenger passenger) {
        int bagWeight = getFlightBaggageWeight() / this.flight.getPlane().getCapacity();
        return passenger.getNumberOfBags() * bagWeight;
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

    public void assignFlightToPassenger(Passenger passenger) {
//        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
//        for (Passenger passenger : flightPassengers) {
//            passenger.setFlight(this.flight);
//        }
        passenger.setFlight(this.flight);
    }

    public void assignSeatNumberToPassenger(Passenger passenger) {
        int passengerSeatNumber = this.flight.getPlane().getSeatNumbers().remove(0);
        passenger.setSeatNumber(passengerSeatNumber);
    }

    public void bookPassengerOntoFlight(Passenger passenger) {
        this.flight.addPassengerToFlight(passenger);
        this.assignSeatNumberToPassenger(passenger);
        this.assignFlightToPassenger(passenger);
    }

    public ArrayList<Integer> getPassengerSeatNumbers() {
        ArrayList<Integer> seatNumbers = new ArrayList<>();
        ArrayList<Passenger> passengerList = this.flight.getPassengerList();
        for (Passenger flightPassenger : passengerList){
            seatNumbers.add(flightPassenger.getSeatNumber());
        }
        System.out.println(seatNumbers);
        return seatNumbers;
    }

    public ArrayList<Passenger> passengerSeatBubbleSort(){
        boolean swapped = true;
        ArrayList<Passenger> passengerList = this.flight.getPassengerList();
        while (swapped == true){
            for (int i = 0; i < passengerList.size() - 1; i++) {
//                int passengerIndex = passengerList.indexOf(flightPassenger);
                Passenger flightPassenger = passengerList.get(i);
                Passenger adjacentPassenger = passengerList.get(i + 1);
//                int adjacentPassengerIndex = passengerList.indexOf(adjacentPassenger);
                swapped = false;
                if (flightPassenger.getSeatNumber() > adjacentPassenger.getSeatNumber()) {
                    Collections.swap(passengerList, i, i +1);
                    swapped = true;
                }

            }
        }
        return passengerList;
    }
}

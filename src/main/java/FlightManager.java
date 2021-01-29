import java.util.ArrayList;

public class FlightManager {

    Flight flight;
    int baggageWeight;

    public FlightManager (Flight flight) {
        this.flight = flight;
        this.baggageWeight = this.flight.getPlane().getTotalWeight() / 2;
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
        return this.baggageWeight;
    }
//
//    public int calculateRemainingBaggageWeight() {
//        return this.getFlightBaggageWeight() - this.getTotalPassengerBaggageWeight();
//    }
}

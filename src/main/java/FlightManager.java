public class FlightManager {

    Flight flight;

    public FlightManager (Flight flight) {
        this.flight = flight;
    }

    public int getPassengerBaggageWeight(Passenger passenger) {
        return passenger.getNumberOfBags() * 15;
    }
}

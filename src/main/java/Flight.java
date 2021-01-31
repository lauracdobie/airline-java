import java.util.ArrayList;
import java.util.Date;

public class Flight {
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private IATACode destination;
    private IATACode departureAirport;
    private String departureTime;

    public Flight (Plane plane, String flightNumber, IATACode destination, IATACode departureAirport, String departureTime) {
        this.plane = plane;
        this.passengers = new ArrayList<Passenger>();
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public int getNumberOfPassengers() {
        return this.passengers.size();
    }

    public ArrayList getPassengerList() {
        return this.passengers;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getRemainingSeats() {
        return this.plane.getSeatNumbers().size();
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public IATACode getDestination() {
        return this.destination;
    }

    public void setDestination(IATACode destination) {
        this.destination = destination;
    }

    public IATACode getDepartureAirport() {
        return this.departureAirport;
    }

    public void setDepartureAirport(IATACode departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void addPassengerToFlight(Passenger passenger) {
        if (this.plane.getSeatNumbers().size() > 0){
            this.passengers.add(passenger);
//            this.plane.getSeatNumbers().remove(0);
        }
    }
}

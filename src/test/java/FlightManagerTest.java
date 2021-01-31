import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightManagerTest {

    Passenger jetSetter1;
    Passenger jetSetter2;
    Passenger jetSetter3;
    Passenger jetSetter4;
    Plane hopefulPuffin;
    Plane busyPlane;
    Flight flight1;
    Flight flight2;
    FlightManager flightManager;
    FlightManager flightManager2;

    @Before
    public void before() {
        jetSetter1 = new Passenger("Giovanni Rosso", 2);
        jetSetter2 = new Passenger("Mercedes Lindo", 1);
        jetSetter3 = new Passenger("Ludovine Le Mercier", 3);
        jetSetter4 = new Passenger("Rudolph Brun", 1);
        hopefulPuffin = new Plane(PlaneType.HOPEFULPUFFIN404, 200, 10000);
        busyPlane = new Plane(PlaneType.GLIDINGGUILLEMOT403, 1, 15000);
        flight1 = new Flight(hopefulPuffin, "EZY3498", IATACode.EDI, IATACode.GLA, "14:00");
        flight2 = new Flight(busyPlane, "EZY6142", IATACode.LGW, IATACode.NCL, "07:00");
        flightManager = new FlightManager(flight1);
        flightManager2 = new FlightManager(flight2);
        flightManager.bookPassengerOntoFlight(jetSetter1);
        flightManager.bookPassengerOntoFlight(jetSetter2);
    }

    @Test
    public void canCreateFlightManger() {
        assertNotNull(flightManager);
    }

    @Test
    public void canCalculatePassengerBaggageWeight(){
        assertEquals(50, flightManager.getPassengerBaggageWeight(jetSetter1));
    }

    @Test
    public void canCalculateBaggageWeightForAllPassengers() {
        assertEquals(75, flightManager.getTotalPassengerBaggageWeight());
    }

    @Test
    public void canGetFlightBaggageWeight() {
        assertEquals(7500, flightManager2.getFlightBaggageWeight());
    }

    @Test
    public void canGetRemainingBaggageWeight() {
        assertEquals(4925, flightManager.calculateRemainingBaggageWeight());
    }

    @Test
    public void canAssignFlightToPassenger() {
        flightManager.assignFlightToPassenger(jetSetter1);
        assertEquals(flight1, jetSetter1.getFlight());
    }

    @Test
    public void canBookPassengerOntoFlight() {
        flightManager.bookPassengerOntoFlight(jetSetter3);
        flightManager.bookPassengerOntoFlight(jetSetter4);
        assertEquals(flight1, jetSetter3.getFlight());
        assertEquals(flight1, jetSetter4.getFlight());
        assertEquals(4825, flightManager.calculateRemainingBaggageWeight());
        assertEquals(196, flightManager.flight.getRemainingSeats());
        assertEquals(4, flightManager.flight.getNumberOfPassengers());
    }

    @Test
    public void canSortPassengersByFlightNumber(){
        flightManager.bookPassengerOntoFlight(jetSetter3);
        flightManager.bookPassengerOntoFlight(jetSetter4);
        flightManager.getPassengerSeatNumbers();
        flightManager.passengerSeatBubbleSort();
        flightManager.getPassengerSeatNumbers();
    }

    @Test
    public void canGetPassengerBySeatNumber() {
        flightManager.bookPassengerOntoFlight(jetSetter3);
        flightManager.bookPassengerOntoFlight(jetSetter4);
        int numberToSearchFor = jetSetter3.getSeatNumber();
        flightManager.passengerSeatBubbleSort();
        Passenger foundPassenger = flightManager.findPassengerBySeatNumber(numberToSearchFor);
        assertEquals(jetSetter3.getName(), foundPassenger.getName());

    }
}

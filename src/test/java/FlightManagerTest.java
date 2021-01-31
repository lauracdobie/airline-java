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
        hopefulPuffin = new Plane(PlaneType.HOPEFULPUFFIN404, 200, 30000);
        busyPlane = new Plane(PlaneType.GLIDINGGUILLEMOT403, 1, 15000);
        flight1 = new Flight(hopefulPuffin, "EZY3498", IATACode.EDI, IATACode.GLA, "14:00");
        flight2 = new Flight(busyPlane, "EZY6142", IATACode.LGW, IATACode.NCL, "07:00");
        flightManager = new FlightManager(flight1);
        flightManager2 = new FlightManager(flight2);
        flight1.addPassengerToFlight(jetSetter1);
        flight1.addPassengerToFlight(jetSetter2);
    }

    @Test
    public void canCreateFlightManger() {
        assertNotNull(flightManager);
    }

    @Test
    public void canCalculatePassengerBaggageWeight(){
        assertEquals(30, flightManager.getPassengerBaggageWeight(jetSetter1));
    }

    @Test
    public void canCalculateBaggageWeightForAllPassengers() {
        assertEquals(45, flightManager.getTotalPassengerBaggageWeight());
    }

    @Test
    public void canGetFlightBaggageWeight() {
        assertEquals(7500, flightManager2.getFlightBaggageWeight());
    }

    @Test
    public void canGetRemainingBaggageWeight() {
        assertEquals(14955, flightManager.calculateRemainingBaggageWeight());
    }

    @Test
    public void canAssignFlightToPassenger() {
        flightManager.assignFlightToPassenger();
        assertEquals(flight1, jetSetter1.getFlight());
        assertEquals(flight1, jetSetter2.getFlight());
    }

    @Test
    public void canBookPassengerOntoFlight() {
        flightManager.bookPassengerOntoFlight(jetSetter3);
        flightManager.bookPassengerOntoFlight(jetSetter4);
        int passengerSeatNumber = jetSetter3.getSeatNumber();
        boolean seatNumberGreaterThan0 = passengerSeatNumber > 0;
        boolean seatNumberLessThan200 = passengerSeatNumber < 200;
        assertEquals(flight1, jetSetter3.getFlight());
        assertEquals(14895, flightManager.calculateRemainingBaggageWeight());
        assertTrue(seatNumberGreaterThan0);
        assertTrue(seatNumberLessThan200);
    }

//    @Test
//    public void canGetShuffledListOfSeatNumbers() {
//        assertEquals(200, flightManager.getShuffledSeatNumbers().size());
//    }
//
//    @Test
//    public void canGetRandomSeatNumber() {
//        assertNotNull(flightManager.getRandomSeatNumber());
//    }
}

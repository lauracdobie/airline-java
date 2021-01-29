import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightManagerTest {

    Passenger jetSetter1;
    Passenger jetSetter2;
    Plane hopefulPuffin;
    Plane busyPlane;
    Flight flight1;
    Flight flight2;
    FlightManager flightManager;

    @Before
    public void before() {
        jetSetter1 = new Passenger("Giovanni Rosso", 2);
        jetSetter2 = new Passenger("Mercedes Lindo", 1);
        hopefulPuffin = new Plane(PlaneType.HOPEFULPUFFIN404, 200, 30000);
        busyPlane = new Plane(PlaneType.GLIDINGGUILLEMOT403, 1, 15000);
        flight1 = new Flight(hopefulPuffin, "EZY3498", IATACode.EDI, IATACode.GLA, "14:00");
        flight2 = new Flight(busyPlane, "EZY6142", IATACode.LGW, IATACode.NCL, "07:00");
        flightManager = new FlightManager(flight1);
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
        assertEquals(15000, flightManager.getFlightBaggageWeight());
    }

//    @Test
//    public void canCalculateRemainingBaggageWeight() {
//        assertEquals(14955, flightManager.calculateRemainingBaggageWeight());
//    }
}

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightTest {

    Passenger jetSetter1;
    Passenger jetSetter2;
    Plane hopefulPuffin;
    Plane fullPlane;
    Flight flight1;
    Flight flight2;

    @Before
    public void before() {
        jetSetter1 = new Passenger("Giovanni Rosso", 2);
        jetSetter2 = new Passenger("Mercedes Lindo", 1);
        hopefulPuffin = new Plane(PlaneType.HOPEFULPUFFIN404, 200, 30000);
        fullPlane = new Plane(PlaneType.GLIDINGGUILLEMOT403, 0, 15000);
        flight1 = new Flight(hopefulPuffin, "EZY3498", IATACode.EDI, IATACode.GLA, "14:00");
        flight2 = new Flight(fullPlane, "EZY6142", IATACode.LGW, IATACode.NCL, "07:00");
    }

    @Test
    public void canCreateFlight() {
        assertNotNull(flight1);
        assertEquals(hopefulPuffin, flight1.getPlane());
        assertEquals(200, flight1.getAvailableSeats());
        assertEquals(IATACode.GLA, flight1.getDepartureAirport());
        assertEquals(IATACode.EDI, flight1.getDestination());
        assertEquals("14:00", flight1.getDepartureTime());
    }

    @Test
    public void checkPassengerListStartsEmpty() {
        assertEquals(0, flight1.getNumberOfPassengers());
    }

    @Test
    public void canSetPlane() {
        flight1.setPlane(fullPlane);
        assertEquals(fullPlane, flight1.getPlane());
    }

    @Test
    public void canSetDestination() {
        flight1.setDestination(IATACode.ABZ);
        assertEquals(IATACode.ABZ, flight1.getDestination());
    }

    @Test
    public void canSetDepartureAirport() {
        flight1.setDepartureAirport(IATACode.CWL);
        assertEquals(IATACode.CWL, flight1.getDepartureAirport());
    }

    @Test
    public void canSetDepartureTime() {
        flight1.setDepartureTime("08:00");
        assertEquals("08:00", flight1.getDepartureTime());
    }

    @Test
    public void canBookPassengerOntoFlightIfSpaces() {
        flight1.addPassengerToFlight(jetSetter1);
        flight1.addPassengerToFlight(jetSetter2);
        assertEquals(198, flight1.getAvailableSeats());
    }
}

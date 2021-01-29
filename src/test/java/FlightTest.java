import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        flight2 = new Flight(fullPlane, "EZY3498", IATACode.EDI, IATACode.GLA, "14:00");
    }

    @Test
    public void checkPassengerListStartsEmpty() {
        assertEquals(0, flight1.getNumberOfPassengers());
    }

    @Test
    public void checkFlightHasPlane() {
        assertEquals(hopefulPuffin, flight1.getPlane());
    }

    @Test
    public void canSetPlane() {
        flight1.setPlane(fullPlane);
        assertEquals(fullPlane, flight1.getPlane());
    }
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PassengerTest {

    Passenger jetSetter;
    Flight flight;
    Plane hopefulPuffin;

    @Before
    public void before() {
        jetSetter = new Passenger("Giovanni Rosso", 2);
        hopefulPuffin = new Plane(PlaneType.HOPEFULPUFFIN404, 200, 30000);
        flight = new Flight(hopefulPuffin, "EZY3498", IATACode.EDI, IATACode.GLA, "14:00");
    }

    @Test
    public void checkPassengerHasName() {
        assertEquals("Giovanni Rosso", jetSetter.getName());
    }

    @Test
    public void checkPassengerNameCanBeSet() {
        jetSetter.setName("John Red");
        assertEquals("John Red", jetSetter.getName());
    }

    @Test
    public void checkPassengerHasBags() {
        assertEquals(2, jetSetter.getNumberOfBags());
    }

    @Test
    public void checkPassengerBagsCanBeSet() {
        jetSetter.setNumberOfBags(3);
        assertEquals(3, jetSetter.getNumberOfBags());
    }

    @Test
    public void checkFlightPropertyStartsAsNull() {
        assertNull(jetSetter.getFlight());
    }

    @Test
    public void canSetPassengerFlight() {
        jetSetter.setFlight(flight);
        assertEquals(flight, jetSetter.getFlight());
    }
}

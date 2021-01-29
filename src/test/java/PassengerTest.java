import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger jetSetter;

    @Before
    public void before() {
        jetSetter = new Passenger("Giovanni Rosso", 2);
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

//    @Test
//    public void canGetBaggageWeight() {
//        assertEquals(30, jetSetter.getBaggageWeight());
//    }
}

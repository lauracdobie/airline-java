import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane hopefulPuffin;

    @Before
    public void before() {
        hopefulPuffin = new Plane(PlaneType.HOPEFULPUFFIN404, 200,20000);
    }

    @Test
    public void canGetModel() {
        assertEquals(PlaneType.HOPEFULPUFFIN404, hopefulPuffin.getModel());
    }

    @Test
    public void canSetModel() {
        hopefulPuffin.setModel(PlaneType.BULLETSPARROW301);
        assertEquals(PlaneType.BULLETSPARROW301, hopefulPuffin.getModel());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(200, hopefulPuffin.getCapacity());
    }

    @Test
    public void canSetCapacity() {
        hopefulPuffin.setCapacity(150);
        assertEquals(150, hopefulPuffin.getCapacity());
    }

    @Test
    public void canGetSeats() {
        assertEquals(200, hopefulPuffin.getSeatNumbers().size());
    }

    @Test
    public void canSetSeats() {
        ArrayList<Integer> updatedSeatNumbers = new ArrayList<>();
        updatedSeatNumbers.add(1);
        updatedSeatNumbers.add(2);
        hopefulPuffin.setSeatNumbers(updatedSeatNumbers);
        assertEquals(2, hopefulPuffin.getSeatNumbers().size());
    }

    @Test
    public void canGetTotalWeight() {
        assertEquals(20000, hopefulPuffin.getTotalWeight());
    }

    @Test
    public void canSetTotalWeight() {
        hopefulPuffin.setTotalWeight(25000);
        assertEquals(25000, hopefulPuffin.getTotalWeight());
    }

}

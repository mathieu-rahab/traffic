package ulco.traffic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Story_0 {

    @Test
    @DisplayName("Segment is created")
    public void testSegment() {
        Segment segment = new Segment(200,10);

        assertNotEquals(null, segment);
    }

    @Test
    @DisplayName("Vehicle is created")
    public void testVehicle() {
        Vehicle vehicle = new Vehicle();

        assertNotEquals(null, vehicle);
    }
}
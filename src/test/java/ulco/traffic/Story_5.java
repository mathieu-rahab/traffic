package ulco.traffic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Story_5 {
    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testSegment() {

        Segment segment1 = new Segment(200, 10);
        Segment segment2 = new Segment(150, 7);

        segment1.setNextSegment(segment2);

        Vehicle vehicle = new Vehicle();

        segment1.addVehicle(vehicle);

        for (int i = 0; i < 20; i += 1) {
            segment1.run(1.0);
        }

        assertFalse(segment1.hasVehicule(vehicle.getId()));
        assertTrue(segment2.hasVehicule(vehicle.getId()));
    }

}
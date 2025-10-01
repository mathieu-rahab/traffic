package ulco.traffic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Story_8 {
    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testSegment() {

        Segment segment1 = new Segment(200, 10, Segment.TypeEnd.YELDING_SIGN);
        Segment segment2 = new Segment(150, 7, Segment.TypeEnd.STOP_SIGN);

        segment1.setNextSegment(segment2);

        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();


        segment1.addVehicle(vehicle1);
        segment1.addVehicle(vehicle2);

        for (int i = 0; i < 20; i += 1) {
            segment1.run(1.0);
        }

        assertFalse(segment1.hasVehicule(vehicle1.getId()));
        assertTrue(segment2.hasVehicule(vehicle1.getId()));

        double distance = vehicle2.getDistance();
        for (int i = 0; i <= 15; i += 1) {
            assertEquals(distance, vehicle2.getDistance());
            segment1.run(1.0);
            segment2.run(1.0);
        }

        assertFalse(segment1.hasVehicule(vehicle2.getId()));
        assertTrue(segment2.hasVehicule(vehicle2.getId()));

    }

}
package ulco.traffic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Story_4 {
    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testSegment() {

        Segment segment = new Segment(200, 10);

        Vehicle vehicle = new Vehicle();

        segment.addVehicle(vehicle);

        for (int i = 0; i < 19; i += 1) {
            Double initDistance = vehicle.getDistance();

            segment.run(1.0);
            assertEquals(initDistance + (segment.getSpeed() * 1.0), vehicle.getDistance());
        }
        System.out.println(vehicle.getDistance());
        assertFalse(segment.vehiculeAtEnd(vehicle.getId()));
        segment.run(1.0);
        assertTrue(segment.vehiculeAtEnd(vehicle.getId()));

    }

}
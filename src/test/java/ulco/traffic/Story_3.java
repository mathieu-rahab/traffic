package ulco.traffic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Story_3 {
    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testSegment() {

        Segment segment = new Segment(200, 10);

        Vehicle vehicle = new Vehicle();

        segment.addVehicle(vehicle);

        for (double time = 0; time <= 20; time += 1) {
            Double initDistance = vehicle.getDistance();

            segment.run(time);
            assertEquals(initDistance + (segment.getSpeed() * time), vehicle.getDistance());
        }

    }

}
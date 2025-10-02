package ulco.traffic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Story_10 {
    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testJameSize() {

        Segment segment1 = new Segment(200, 10, Segment.TypeEnd.STOP_SIGN);
        Segment segment2 = new Segment(150, 7, Segment.TypeEnd.STOP_SIGN);
        Segment segment3 = new Segment(150, 7, Segment.TypeEnd.STOP_SIGN);
        Segment segment4 = new Segment(150, 7, Segment.TypeEnd.STOP_SIGN);

        segment1.addNextSegment(segment2);
        segment2.addNextSegment(segment3);
        segment2.addNextSegment(segment4);

        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();

        vehicle1.set


        segment1.addVehicle(vehicle1);
        segment1.addVehicle(vehicle2);

        for (int i = 0; i < 20; i += 1) {
            segment1.run(1.0);
        }

        assertTrue(segment1.hasVehicule(vehicle1.getId()));
        assertTrue(segment1.hasVehicule(vehicle2.getId()));

        double size = vehicle1.getSize() + vehicle2.getSize();

        assertEquals(segment1.getTotalJamSize(), size);

        segment1.run(5.0);

    }


}
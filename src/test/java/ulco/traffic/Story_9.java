package ulco.traffic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Story_9 {
    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testJameSize() {

        Segment segment1 = new Segment(200, 10, Segment.TypeEnd.STOP_SIGN);
        Segment segment2 = new Segment(150, 7, Segment.TypeEnd.STOP_SIGN);

        segment1.setNextSegment(segment2);

        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();


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

    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testJameSize2() {

        Segment segment1 = new Segment(200, 10, Segment.TypeEnd.YELDING_SIGN);
        Segment segment2 = new Segment(150, 7, Segment.TypeEnd.STOP_SIGN);

        segment1.setNextSegment(segment2);

        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Vehicle vehicle3 = new Vehicle();


        segment1.addVehicle(vehicle1);
        segment1.addVehicle(vehicle2);


        segment1.run(5.0);
        segment1.addVehicle(vehicle3);
        segment1.run(15.0);

        assertFalse(segment1.hasVehicule(vehicle1.getId()));
        assertTrue(segment1.hasVehicule(vehicle2.getId()));
        assertTrue(segment1.hasVehicule(vehicle3.getId()));


        assertEquals(segment1.getTotalJamSize(), 0.0);

        segment1.run(5.0);
        segment2.run(5.0);

        double size = vehicle2.getSize() + vehicle3.getSize();
        System.out.println("Postion vehicle 1 : " + vehicle1.getDistance());
        System.out.println("Postion vehicle 2 : " + vehicle2.getDistance());
        System.out.println("Postion vehicle 3 : " + vehicle3.getDistance());

        assertEquals(segment1.getTotalJamSize(), size);

        segment1.run(5.0);

    }

}
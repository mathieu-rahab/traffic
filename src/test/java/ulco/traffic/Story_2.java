
package ulco.traffic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Story_2 {

    @Test
    @DisplayName("Segment is created  Vehicule_Segment")
    public void testSegment() {
        Segment segment = new Segment(200, 10);
        // creation d ’ un vehicule
        Vehicle vehicle = new Vehicle();
        // placement du vehicule au debut du segment
        segment.addVehicle(vehicle);

        assertEquals(segment.hasVehicule(vehicle.getId()), true);

    }
}

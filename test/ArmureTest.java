import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import equipement.Armure;
import org.junit.Test;

public class ArmureTest {
    @Test
    public void testGetProtection() {
        Armure armure = new Armure("cuir", 10, 5);
        assertEquals(10, armure.getProtection());
    }

    @Test
    public void testTrierArmure() {
        List<Armure> listeArmure = new ArrayList<>();
        listeArmure.add(new Armure("cuir", 10, 5));
        listeArmure.add(new Armure("plastique", 20, 10));
        listeArmure.add(new Armure("acier", 15, 8));
        Armure.trierArmure(listeArmure);
        assertNotNull(listeArmure);
    }

    @Test
    public void testCompareTo() {
        Armure armure1 = new Armure("cuir", 10, 5);
        Armure armure2 = new Armure("plastique", 20, 10);
        Armure armure3 = new Armure("acier", 15, 8);
        assertEquals(-1, armure1.compareTo(armure2));
        assertEquals(1, armure2.compareTo(armure1));
        assertEquals(1, armure2.compareTo(armure3));
        assertEquals(-1, armure3.compareTo(armure2));
    }
}
import donjons.Boss;
import personnages.Mage;
import personnages.Personnages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MageTest {
    @Test
    public void testGetMULTIPL() {
        assertEquals(1.25, Mage.getMULTIPL(), 0);
    }

    @Test
    public void testAttaque_Spéciale_Mage() {
        Mage.Mana = 100;
        Mage.setDegat(10);
        Mage.attaque_Spéciale_Mage();
        assertEquals(11, Mage.getDegat(), 0);
    }

}

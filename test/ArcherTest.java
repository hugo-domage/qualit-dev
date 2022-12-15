import donjons.*;
import personnages.Archer;
import personnages.Personnages;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.junit.Before;
public class ArcherTest {
    @Test
    public void testGetMultipl() {
        assertEquals(1.25, Archer.getMULTIPL(), 0.0);
    }

        private Archer archer;

        @Before
        public void setUp() throws Exception {
            archer = new Archer("Archer", "M", 70, 180, 30, 5, "Arc");
        }


        @Test
        public void testDouble_Attaque_Chance() {
            int pourcentage_Chance = 0;
            archer.dexterite = 35;

            if (archer.dexterite > 0 && archer.dexterite <= 10) {
                pourcentage_Chance = 20;
            } else if (archer.dexterite > 10 && archer.dexterite <= 20) {
                pourcentage_Chance = 40;
            } else if (archer.dexterite > 20 && archer.dexterite <= 30) {
                pourcentage_Chance = 60;
            } else if (archer.dexterite > 30 && archer.dexterite <= 40) {
                pourcentage_Chance = 80;
            } else if (archer.dexterite > 40 && archer.dexterite <= 50) {
                pourcentage_Chance = 100;
            }
            assertEquals(80, pourcentage_Chance);
        }
    }



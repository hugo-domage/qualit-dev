import Donjons.Boss;
import Personnages.Mage;
import Personnages.Personnages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class MageTest {


        @BeforeEach
        void setUp() {
            Personnages personnages = new Mage("nom", "sexe", 90, 180, 20, 5, 1, 50, 10, 0, "sort");
        }

        @Test
        void getMULTIPL() {
            Assertions.assertEquals(1.25, Mage.getMULTIPL());
        }



        @Test
        void est_En_Vie() {
            assertTrue(Mage.est_En_Vie());
        }

        @Test
        void attaquer1_Mage() {
            Mage.attaquer1_Mage();
            assertEquals(-5, Boss.getSanté());
        }

        @Test
        void attaque_Spéciale_Mage() {
            Mage.attaquer1_Mage();


        }
    }

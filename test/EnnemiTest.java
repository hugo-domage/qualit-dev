import static org.junit.Assert.*;

import donjons.Ennemi;
import org.junit.Test;

public class EnnemiTest {

    @Test
    public void testSetSante() {
        Ennemi.setSante(5);
        assertEquals(5, Ennemi.sante);
    }

    @Test
    public void testEst_En_Vie() {
        Ennemi.setSante(1);
        assertTrue(Ennemi.est_En_Vie());
    }
}
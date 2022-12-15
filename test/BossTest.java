import static org.junit.Assert.assertEquals;

import donjons.Boss;
import donjons.Ennemi;
import org.junit.Test;

public class BossTest {

    @Test
    public void testGetSante() {
        Boss.getSante();
        assertEquals(300, Boss.getSante());
    }

    @Test
    public void testResurection() {
        Boss.setSante(0);
        Boss.resurection();
        assertEquals(300, Boss.getSante());
    }

    @Test
    public void testAttaquer1_Boss() {
        int degats = 25;
        Boss.attaquer1_Boss();
        assertEquals(325 - degats, Boss.getSante());
    }

    @Test
    public void testAttaquer_Speciale_Boss() {
        int degats = 35;
        Boss.attaquer_Spéciale_Boss();
        assertEquals(335 - degats, Boss.getSante());
    }

    @Test
    public void testPerdre_Vie_Boss() {
        int degats = 25;
        Boss.perdre_vie_Boss();
        assertEquals(290 - degats, Boss.getSante());
    }
}
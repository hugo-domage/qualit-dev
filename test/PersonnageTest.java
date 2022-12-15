import donjons.Boss;
import personnages.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static donjons.Boss.degats_Boss;
import static org.junit.Assert.*;

public class PersonnageTest {
    @Test
    public void testGetForce() {
        int expectedForce = 25;
        int actualForce = Personnages.getForce();
        assertEquals(expectedForce, actualForce);
    }

    @Test
    public void testGetSante() {
        int expectedSante = 100;
        int actualSante = Personnages.getSanté();
        assertEquals(expectedSante, actualSante);
    }

    @Test
    public void testGetDegat() {
        int expectedDegat = (int) (Personnages.getForce() + Personnages.getMULTIPL());
        int actualDegat = Personnages.getDegat();
        assertEquals(expectedDegat, actualDegat);
    }

    @Test
    public void testPerdreVieJoueur() {
        int expectedSante = Personnages.sante - degats_Boss;
        Personnages.perdre_vie_Joueur();
        int actualSante = Personnages.sante;
        assertEquals(expectedSante, actualSante);
    }

    @Test
    public void testUtiliserUnObjet() {
        HashMap<Integer, String> inventaire = new HashMap<Integer, String>();
        inventaire.put(2, " potion de rage");
        inventaire.put(1, "potion de vie");
        Personnages.sante = 80;
        int expectedSante = 100;
        Personnages.utiliser_un_objet();
        int actualSante = Personnages.sante;
        assertEquals(expectedSante, actualSante);
    }


    @Test
    public void testSystemeDeNv() {
        Personnages.Xp = 1000;
        Personnages.nv = 1;
        int expectedNv = 2;
        Personnages.Systeme_de_nv();
        int actualNv = Personnages.nv;
        assertEquals(expectedNv, actualNv);
    }

    @Test
    public void testEstEnVie() {
        Personnages.sante = 0;
        boolean expectedEnVie = false;
        boolean actualEnVie = Personnages.est_En_Vie();
        assertEquals(expectedEnVie, actualEnVie);
    }
}







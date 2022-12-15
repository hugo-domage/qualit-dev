import Personnages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static Personnages.Personnages.utiliser_un_objet;
import static org.junit.Assert.*;

public class PersonnageTest {

    @Test
    public void testPersonnages() {
        Personnages personnage = new Guerrier("Joueur1", "Homme",
                60, 180, 20, 25, 1, 0, 0, "Sort");

        assertNotNull(personnage);
        assertEquals("Joueur1", personnage.getNom());
        assertEquals("Homme", personnage.getSexe());
        assertEquals(60, personnage.getPoids());
        assertEquals(180, personnage.getTaille());
        assertEquals(20, personnage.getAge());
        assertEquals(25, personnage.getForce());
        assertEquals(100, personnage.getNv());
        assertEquals(100, personnage.getPo());
        assertEquals(0, personnage.getXp());
        assertEquals(325, personnage.getDegat());
        assertEquals("Sort", personnage.getSort());
        assertEquals(100, Personnages.getSanté());
        assertEquals(100, Personnages.getFaim());
        assertNotNull(personnage.getInventaire());
        assertEquals(300.0, Personnages.getMULTIPL(), 0.0);
    }
    @Test
    void perdre_vie_Joeur_Test() {
        int sante = 10;
        int degat_Boss = 3;
        int result = 7;
        assertEquals(result, sante - degat_Boss);
    }
    @Test
    public void gagner_Xp() {
        Personnages.Xp = 0;
        Personnages.gagner_Xp();
        assertTrue(Personnages.Xp > 0);
    }

    @Test
    public void niveau2() {
        Personnages.nv = 1;
        Personnages.Xp = 1000;
        Personnages.Systeme_de_nv();
        assertEquals(2 ,Personnages.nv);
        assertEquals(0 ,Personnages.Xp);
    }

    @Test
    public void niveau3() {
        Personnages.Xp = 2000;
        Personnages.nv = 2;
        Personnages.Systeme_de_nv();
        assertEquals(3 ,Personnages.nv);
        assertEquals(0 ,Personnages.Xp);
    }

    @Test
    public void niveau4() {
        Personnages.Xp = 3000;
        Personnages.nv = 3;
        Personnages.Systeme_de_nv();
        assertEquals(4 ,Personnages.nv);
        assertEquals(0 ,Personnages.Xp);
    }

    private int sante;
    private HashMap<Integer,String> inventaire;

    @Before
    public void setUp() {
        this.sante = 100;
        this.inventaire = new HashMap<>();
        this.inventaire.put(2," potion de rage");
        this.inventaire.put(1,"potion de vie");
    }

    @Test
    public void testUtiliserUnObjet() {
        Personnages personnage = new Guerrier("Joueur1", "Homme",
                60, 180, 20, 25, 1, 0, 0, "Sort");
        HashMap<Integer,String> inventaire = new HashMap<Integer,String>();
        inventaire.put(2," potion de rage");
        inventaire.put(1,"potion de vie");
        Personnages.utiliser_un_objet();
        assertEquals(100, personnage.getSanté());
        assertTrue(inventaire.containsKey(1) && inventaire.containsValue("potion de vie"));
    }
}






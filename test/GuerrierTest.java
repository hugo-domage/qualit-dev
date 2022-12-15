import donjons.Boss;
import personnages.Personnages;
import  personnages.Guerrier;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GuerrierTest {

    Personnages guerrier = new Guerrier("Nom", "Sexe", 0, 0, 0, 0, "Sort");



    @Test
    public void testAttaque_Speciale_Guerrier() {
        Guerrier.attaque_Spéciale_Guerrier();
        assertEquals(55, Guerrier.getDegat());
    }

}
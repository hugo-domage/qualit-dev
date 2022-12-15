import Personnages.Personnages;
import  Personnages.Guerrier;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GuerrierTest {

    @Test
    public void getMULTIPL() {
        HashMap<String, Integer> inventaire = new HashMap<>();
        inventaire.put("potion de vie", 1);
        Personnages personnages = new Guerrier("zozo","Homme",55,150,15,35,25,1000,1,"aezaea" );

        Assertions.assertEquals(325,personnages.getDegat());

    }
    @Test
    public void  nom_Guerrier(){
        Personnages personnages = new Guerrier("zozo","Homme",55,150,15,35,25,1000,1,"aezaea" );
        Assertions.assertEquals("zozo",personnages.getNom());
    }
    @Test
    public void attaque_Spéciale(){
        Personnages personnages = new Guerrier("zozo","Homme",55,150,15,35,25,1000,1,"aezaea" );

    }

}
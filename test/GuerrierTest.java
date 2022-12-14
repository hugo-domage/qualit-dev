import Personnages.Personnages;
import  Personnages.Guerrier;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GuerrierTest {
    Personnages personnages = new Guerrier("zozo","Homme",55,150,15,35,25,1000,1,1,"aezaea" );


    @Test
    public void getMULTIPL() {
        Assertions.assertEquals(26,personnages.getDegat());

    }
    @Test
    public void  nom_Guerrier(){
        Assertions.assertEquals("zozo",personnages.getNom());
    }
    @Test
    public void attaque_Spéciale(){

    }

}
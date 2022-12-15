import Donjons.*;
import Personnages.Archer;
import Personnages.Personnages;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ArcherTest {




    @Before
    public void setUp() throws Exception {
        Personnages personnages = new Archer("zozo","Homme",55,150,15,35,25,1000,1,"aezaea" );
        enemy  enemy= new Boss("Dragon",100,1000);
    }

    @Test
    public void attaque1_Archer(){
        int vieBossAvantAttaque = Boss.getSanté();
        Archer.attaquer1_Archer();
        int vieBossApresAttaque = Boss.getSanté();
        assertEquals(vieBossAvantAttaque - Archer.getDegat(), vieBossApresAttaque);
    }

    @Test
    public void attaque_Speciale_Archer(){
        int vieBossAvantAttaque = Boss.getSanté();
        Archer.attaque_Spéciale_Archer();
        int vieBossApresAttaque = Boss.getSanté();
        assertEquals(vieBossAvantAttaque - Archer.getDegat(), vieBossApresAttaque);
    }



}
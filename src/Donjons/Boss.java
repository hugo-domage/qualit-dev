package Donjons;

import static Personnages.Personnages.*;

public class Boss extends enemy {

    public static int degat_Boss = 25;
    public static int Xp = 10000;

    static int santé = 300;
    public Boss(String nom, int santé,  int XP) {
        super("Dragon", 300, 10000);
    }
    public static void attaquer1_Boss(){ // attaque classique du Boss
        System.out.println("Le Boss attaque avec son attaque de base, il fait " + degat_Boss +" degat ");
        perdre_vie_Boss();
    }

    public static void perdre_vie_Boss() {
        if (santé > 0) {
            System.out.println("Boss perd " + degat + " points de vie");
            santé = (santé - degat);
            System.out.println("Boss " + santé + " points de vie");
        }
        else  {
            System.out.println("Le Boss est mort");
        }
    }

}

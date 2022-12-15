package personnages;

import static donjons.Boss.perdre_vie_Boss;

public class Mage extends Personnages{

    private static final double MULTIPL = 1.25;

    static int Mana =2000;

    public Mage(String nom, String sexe, int poids, int taille, int age, int nv, String sort) {
        super(nom, sexe, poids, taille, age, nv, sort);
    }

    public static double getMULTIPL() {
        return MULTIPL;
    }

    public static void attaque_Spéciale_Mage() {
        degat += Mana/100 ;
        perdre_vie_Boss();
    }


}


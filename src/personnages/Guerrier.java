package personnages;

import static donjons.Boss.*;


public class Guerrier extends Personnages {
    private static final double MULTIPL = 1.25;

    static int rage =20;

    public Guerrier(String nom, String sexe, int poids, int taille, int age, int nv, String sort) {
        super(nom, sexe, poids, taille, age, nv, sort);
    }


    public static double getMULTIPL() {
        return MULTIPL;
    }


    public static void attaque_Spéciale_Guerrier() {
         degat += rage ;
        perdre_vie_Boss();
        }
    }


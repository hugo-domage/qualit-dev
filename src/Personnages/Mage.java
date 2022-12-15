package Personnages;

import java.util.HashMap;

import static Donjons.Boss.perdre_vie_Boss;

public class Mage extends Personnages{
    public Mage(String nom, String sexe, int poids, int taille, int age, int force, int nv, int po, int degat, int i, String sort, HashMap<Integer, String> inventaire) {
        super(nom, sexe, poids, taille, age, force, nv, po, degat, i, sort, inventaire);
    }
    private static final double MULTIPL = 1.25;

    static int rage =20;

    public static double getMULTIPL() {
        return MULTIPL;
    }

    public static int getdegats() {
        return degats;
    }

    public static boolean est_En_Vie() {
        return santé > 0;
    }

    public static void attaquer1_Mage(){ // attque de base joueur
        System.out.println("joueur attaque avec son attaque de base, il fait " + degat +" degat ");
        perdre_vie_Boss();
    }
    public static void attaque_Spéciale_Mage() {
        degat += rage ;
        perdre_vie_Boss();
    }
}


package Personnages;

import Type_Attaque.Attaque_Distance;

import java.util.HashMap;
import java.util.Random;

import static Donjons.Boss.perdre_vie_Boss;

public class Archer extends Personnages implements Attaque_Distance {
    public Archer(String nom, String sexe, int poids, int taille, int age, int force, int nv, int po, int degat, String sort) {
        super(nom, sexe, poids, taille, age, force, nv, po, degat, sort);
    }
    private static final double MULTIPL = 1.25;

   private static int dextérité = 60;

    public static double getMULTIPL() {
        return MULTIPL;
    }



    public static boolean est_En_Vie() {
        return santé > 0;
    }

    public static void attaquer1_Archer(){ // attque de base joueur
        System.out.println("joueur attaque avec son attaque de base, il fait " + degat +" degat ");
        perdre_vie_Boss();
    }
    public static void attaque_Spéciale_Archer() {
        double_Attaque_Chance();
        perdre_vie_Boss();
    }
    public static void double_Attaque_Chance() { // double_Attaque_Chance
        int deux_Attaques = 0;
        int pourcentage_Chance = 0;

        if (dextérité > 0 && dextérité <= 10) {
            pourcentage_Chance = 20;
        } else if (dextérité > 10 && dextérité <= 20) {
            pourcentage_Chance = 40;
        } else if (dextérité > 20 && dextérité <= 30) {
            pourcentage_Chance = 60;
        } else if (dextérité > 30 && dextérité <= 40) {
            pourcentage_Chance = 80;
        } else if (dextérité > 40 && dextérité <= 50) {
            pourcentage_Chance = 100;
        }

        Random random = new Random();
        int chance = random.nextInt(100);

        if (chance <= pourcentage_Chance) {
            deux_Attaques = 1;
        }

        if (deux_Attaques == 1) {
            System.out.println("L'archer réussie a faire une double attaque");
            attaque_Spéciale_Archer();
            attaque_Spéciale_Archer();
        }
    }

}
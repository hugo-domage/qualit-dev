package personnages;

import typeAttaque.AttaqueDistance;

import java.util.Random;

import static donjons.Boss.perdre_vie_Boss;

public class Archer extends Personnages implements AttaqueDistance {

    private static final double MULTIPL = 1.25;

   public static int dexterite = 35;

    public Archer(String nom, String sexe, int poids, int taille, int age, int nv, String sort) {
        super(nom, sexe, poids, taille, age, nv, sort);
    }

    public static double getMULTIPL() {
        return MULTIPL;
    }

    public static void attaque_Spéciale_Archer() {
        double_Attaque_Chance();
        perdre_vie_Boss();
    }
    public static void double_Attaque_Chance() { // double_Attaque_Chance
        int deux_Attaques = 0;
        int pourcentage_Chance = 0;

        if (dexterite > 0 && dexterite <= 10) {
            pourcentage_Chance = 20;
        } else if (dexterite > 10 && dexterite <= 20) {
            pourcentage_Chance = 40;
        } else if (dexterite > 20 && dexterite <= 30) {
            pourcentage_Chance = 60;
        } else if (dexterite > 30 && dexterite <= 40) {
            pourcentage_Chance = 80;
        } else if (dexterite > 40 && dexterite <= 50) {
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
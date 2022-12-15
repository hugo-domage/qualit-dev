package Donjons;

import static Personnages.Personnages.*;

public class Boss extends enemy {

    public static int degat_Boss = 25;
    public static int Xp = 10000;

    static int santé = 300;

    public static void resurection() {
        santé = 300;
    }
    public Boss(String nom, int santé,  int XP) {
        super("Dragon", 300, 10000);
    }

    public static int getDegat_Boss() {
        return degat_Boss;
    }

    public static void setDegat_Boss(int degat_Boss) {
        Boss.degat_Boss = degat_Boss;
    }

    public static int getXp() {
        return Xp;
    }

    public static void setXp(int xp) {
        Xp = xp;
    }

    public static int getSanté() {
        return santé;
    }

    public static void setSanté(int santé) {
        Boss.santé = santé;
    }

    public static void attaquer1_Boss(){ // attaque classique du Boss
        System.out.println("Le Boss attaque avec son attaque de base, il fait " + degat_Boss +" degat ");
        perdre_vie_Joueur();
    }

    public static void attaquer_Spéciale_Boss(){ // attaque classique du Boss
        degat_Boss += 10;
        System.out.println("Le Boss attaque avec son attaque de base, il fait " + degat_Boss +" degat ");
        perdre_vie_Joueur();
    }
    public static void perdre_vie_Boss() {
        if (Boss.santé >= 0) {
            System.out.println("Boss perd " + degat + " points de vie");
            santé = (santé - degat);
            System.out.println("Boss " + santé + " points de vie");
        }
        else  {
            System.out.println("Le Boss est mort");
        }
    }



}

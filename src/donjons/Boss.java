package donjons;

import static personnages.Personnages.*;
/**
 * La classe Boss hérite de la classe Ennemi et représente un Boss final du jeu.
 * Elle possède deux méthodes statiques : resurection() et perdre_vie_Boss().
 */
public class Boss extends Ennemi {

    public static int degats_Boss = 25;
    public static int Xp = 10000;

    static int sante = 300;

    /**
     * resurection() permet de réinitialiser la santé du Boss à 300 points.
     */
    public static void resurection() {
        sante = 300;
    }
    public Boss(String nom, int sante,  int XP) {
        super("Dragon", 300, 10000);
    }

    public static int getSante() {
        return sante;
    }

    /**
     * attaquer1_Boss() permet au Boss d'infliger des dégâts de base de 25 points au joueur.
     */
    public static void attaquer1_Boss(){ // attaque classique du Boss
        System.out.println("Le Boss attaque avec son attaque de base, il fait " + degats_Boss +" degats ");
        perdre_vie_Joueur();
    }

    /**
     * attaquer_Spéciale_Boss() permet au Boss d'infliger des dégâts plus élevés de 35 points au joueur.
     */
    public static void attaquer_Spéciale_Boss(){ // attaque spéciale// du Boss
        degats_Boss += 10;
        System.out.println("Le Boss attaque avec son attaque de base, il fait " + degats_Boss +" degats ");
        perdre_vie_Joueur();
    }

    /**
     * perdre_vie_Boss() permet de réduire la santé du Boss en fonction des dégâts subis.
     */
    public static void perdre_vie_Boss() {
        if (Boss.sante >= 0) {
            System.out.println("Boss perd " + getDegat() + " points de vie");
            sante = (sante - getDegat());
            if(sante < 0){
                sante = 0;
            }
            System.out.println("Boss " + getDegat() + " points de vie");
        }
        else  {
            System.out.println("Le Boss est mort");
        }
    }



}

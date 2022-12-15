package donjons;

import static personnages.Personnages.*;

public class Boss extends Ennemi {

    public static int degats_Boss = 25;
    public static int Xp = 10000;

    static int sante = 300;

    public static void resurection() {
        sante = 300;
    }
    public Boss(String nom, int sante,  int XP) {
        super("Dragon", 300, 10000);
    }

    public static int getSante() {
        return sante;
    }

    public static void attaquer1_Boss(){ // attaque classique du Boss
        System.out.println("Le Boss attaque avec son attaque de base, il fait " + degats_Boss +" degats ");
        perdre_vie_Joueur();
    }

    public static void attaquer_Spéciale_Boss(){ // attaque spéciale// du Boss
        degats_Boss += 10;
        System.out.println("Le Boss attaque avec son attaque de base, il fait " + degats_Boss +" degats ");
        perdre_vie_Joueur();
    }
    public static void perdre_vie_Boss() {
        if (Boss.sante >= 0) {
            System.out.println("Boss perd " + degats + " points de vie");
            sante = (sante - degats);
            if(sante < 0){
                sante = 0;
            }
            System.out.println("Boss " + sante + " points de vie");
        }
        else  {
            System.out.println("Le Boss est mort");
        }
    }



}

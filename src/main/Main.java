package main;

import equipement.Armure;
import jeu.*;
import personnages.Personnages;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<Armure> listeArmure = new ArrayList<Armure>();

        Armure armure = new Armure("Armure en maille",25,10);
        Armure armure2 = new Armure("Armure en cuir",15,5);
        Armure armure3 = new Armure("Armure en cuir",15,8);
        Armure armure4 = new Armure("Armure en cuir",15,7);

        listeArmure.add(armure);
        listeArmure.add(armure2);
        listeArmure.add(armure3);
        listeArmure.add(armure4);

        Armure.trierArmure(listeArmure);

       Jeu.Creation_personange(listeArmure);
       while (Personnages.est_En_Vie()) {
           Jeu.Choix_Du_Donjons();
           Jeu.Combat();
       }
    }
}
package Main;

import Personnages.Guerrier;
import Armure.Armure;
import Game.*;
import Personnages.Personnages;
import thread.TimeoutThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        /*

        HashMap<String, Integer> sort = new HashMap<String, Integer>();
        sort.put("charge", 25);
        sort.put("Tempête de lames", 45);
        sort.put("Frappe du colosse", 55);

        HashMap<Integer,String> inventaire = new HashMap<Integer,String>();
        inventaire.put(2," potion de rage");





        guerrier.manger();

        System.out.println(guerrier.getInventaire());
        //Guerrier.utiliser_un_objet();
        System.out.println(guerrier.getSanté());
        //Guerrier.attaquer1(12,  "épée du revenant");
        System.out.println(guerrier.getSort());
        guerrier.attaquer();
        System.out.println(guerrier.getSort());
        */

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
package Armure;

import java.util.ArrayList;
import java.util.List;

public class Armure {

    private String nom;
    private int  Protection;
    private int Poids;



    public int getProtection() {
        return Protection;
    }

    public void setProtection(int protection) {
        Protection = protection;
    }

    public int getPoids() {
        return Poids;
    }

    public void setPoids(int poids) {
        Poids = poids;
    }

    public Armure( String nom, int protection, int poids) {
        this.nom = nom;
        Protection = protection;
        Poids = poids;
    }

    public static void trierArmure(List<Armure> listeArmure) {
        for (Armure armureActuelle : listeArmure) {
            int protection = armureActuelle.getProtection();
            int poids = armureActuelle.getPoids();
            int position = 0;

            for (Armure armureComparee : listeArmure) {
                if (protection > armureComparee.getProtection() || (protection == armureComparee.getProtection() && poids < armureComparee.getPoids())) {
                    position++;
                }
            }

            listeArmure.remove(armureActuelle);
            listeArmure.add(position, armureActuelle);
        }

        System.out.println(listeArmure);
    }
}

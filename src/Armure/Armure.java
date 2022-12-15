package Armure;

import java.util.List;

public class Armure {

    private String nom;
    private int  Protection;
    private int poids_Armure;

    public Armure(String nom, int protection, int poids_Armure) {
        this.nom = nom;
        Protection = protection;
        this.poids_Armure = poids_Armure;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getProtection() {
        return Protection;
    }

    public void setProtection(int protection) {
        Protection = protection;
    }

    public int getPoids_Armure() {
        return poids_Armure;
    }

    public void setPoids_Armure(int poids_Armure) {
        this.poids_Armure = poids_Armure;
    }

    public static void trierArmure(List<Armure> listeArmure) {
        for (Armure armureActuelle : listeArmure) {
            int protection = armureActuelle.getProtection();
            int poids = armureActuelle.getPoids_Armure();
            int position = 0;

            for (Armure armureComparee : listeArmure) {
                if (protection > armureComparee.getProtection() || (protection == armureComparee.getProtection() && poids < armureComparee.getPoids_Armure())) {
                    position++;
                }
            }

            listeArmure.remove(armureActuelle);
            listeArmure.add(position, armureActuelle);
        }

        System.out.println("Liste triée " + listeArmure);
    }
}

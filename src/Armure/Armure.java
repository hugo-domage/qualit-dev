package Armure;

import java.util.Collections;
import java.util.List;

public class Armure implements Comparable<Armure>{

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
        Collections.sort(listeArmure);
        System.out.println("Liste triée " + listeArmure);
    }

    @Override
    public int compareTo(Armure o) {
        if (getProtection() == o.Protection) {
            if (poids_Armure == o.poids_Armure) {
                return 0;
            }
            return poids_Armure > o.poids_Armure ? 1 : -1;
        }

        return getProtection() > o.getProtection() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Armure{" +
                "nom='" + nom + '\'' +
                ", Protection=" + Protection +
                ", poids_Armure=" + poids_Armure +
                '}';
    }
}

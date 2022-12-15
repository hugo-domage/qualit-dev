package equipement;

import java.util.Collections;
import java.util.List;

public class Armure implements Comparable<Armure>{

    private String nom;
    private int  protection;
    private int poids_Armure;

    public Armure(String nom, int protection, int poids_Armure) {
        this.nom = nom;
        this.protection = protection;
        this.poids_Armure = poids_Armure;
    }

    public int getProtection() {
        return this.protection;
    }

    public static void trierArmure(List<Armure> listeArmure) {
        Collections.sort(listeArmure);
        System.out.println("Liste triée " + listeArmure);
    }

    @Override
    public int compareTo(Armure o) {
        if (getProtection() == o.protection) {
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
                ", Protection=" + protection +
                ", poids_Armure=" + poids_Armure +
                '}';
    }
}

package equipement;

import java.util.Collections;
import java.util.List;
/**
 * Cette classe représente une armure avec son nom, sa protection et son poids.
 */
public class Armure implements Comparable<Armure>{

    private String nom;
    private int  protection;
    private int poids_Armure;

    /**
     * Constructeur de l'armure
     *
     * @param nom Le nom de l'armure
     * @param protection La protection de l'armure
     * @param poids_Armure Le poids de l'armure
     */
    public Armure(String nom, int protection, int poids_Armure) {
        this.nom = nom;
        this.protection = protection;
        this.poids_Armure = poids_Armure;
    }

    public int getProtection() {
        return this.protection;
    }

    /**
     * Tri la liste des armures selon leurs protections et leurs poids
     *
     * @param listeArmure La liste des armures à trier
     */
    public static void trierArmure(List<Armure> listeArmure) {
        Collections.sort(listeArmure);
        System.out.println("Liste triée " + listeArmure);
    }

    /**
     * Comparer une armure avec une autre
     *
     * @param o L'armure avec laquelle comparer
     * @return Un entier représentant le résultat de la comparaison
     */
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

    /**
     * Retourne une chaine de caractère représentant l'armure
     *
     * @return La chaine de caractère représentant l'armure
     */
    @Override
    public String toString() {
        return "Armure{" +
                "nom='" + nom + '\'' +
                ", Protection=" + protection +
                ", poids_Armure=" + poids_Armure +
                '}';
    }
}

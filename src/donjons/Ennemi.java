package donjons;
import static personnages.Personnages.getForce;
import static personnages.Personnages.getMULTIPL;
/**
 * Classe abstraite représentant un ennemi
 */
public abstract class Ennemi {
    private String nom;
    public static int sante ;
    private int XP;

    static int degats = (int) (getForce() +  getMULTIPL());

    public static void setSante(int sante) {
        Ennemi.sante = sante;
    }

    /**
     * Constructeur d'un ennemi
     *
     * @param nom le nom de l'ennemi
     * @param sante le nombre de points de santé de l'ennemi
     * @param XP le nombre de points d'experience obtenus à la mort de l'ennemi
     */
    public Ennemi(String nom, int sante, int XP) {
        this.nom = nom;
        this.sante = sante;
        this.XP = XP;
    }

    /**
     * Permet de vérifier si l'ennemi est toujours en vie
     *
     * @return true si l'ennemi est en vie, false sinon
     */
    public static boolean est_En_Vie() {
        return Boss.sante > 0;
    }
}


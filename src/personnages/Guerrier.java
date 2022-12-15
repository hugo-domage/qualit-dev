package personnages;

import static donjons.Boss.*;

/**
 * Cette classe permet de créer des objets de type guerrier qui héritent de la classe Personnages.
 * Elle contient également une constante MULTIPL et une variable rage.
 * */
public class Guerrier extends Personnages {
    private static final double MULTIPL = 1.25;

    static int rage =20;
    /**
     * Constructeur de la classe guerrier
     * @param nom Le nom du guerrier
     * @param sexe Le sexe du guerrier
     * @param poids Le poids du guerrier
     * @param taille La taille du guerrier
     * @param age L'âge du guerrier
     * @param nv Le niveau du guerrier
     * @param sort Le sort du guerrier
     */
    public Guerrier(String nom, String sexe, int poids, int taille, int age, int nv, String sort) {
        super(nom, sexe, poids, taille, age, nv, sort);
    }


    public static double getMULTIPL() {
        return MULTIPL;
    }

    /**
     * La méthode permet d'infliger des dégâts supplémentaires au boss.
     */
    public static void attaque_Spéciale_Guerrier() {
         degat += rage ;
        perdre_vie_Boss();
        }
    }


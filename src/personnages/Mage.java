package personnages;

import static donjons.Boss.perdre_vie_Boss;
/**
 * Classe Mage
 * La classe Mage permet de créer des instances de personnages de type Mage.
 * Les Mages ont un attribut Mana propre.
 *
 */
public class Mage extends Personnages{

    private static final double MULTIPL = 1.25;

    public static int Mana =2000;

    /**
     * Constructeur de Mage
     * @param nom Nom du Mage
     * @param sexe Sexe du Mage
     * @param poids Poids du Mage
     * @param taille Taille du Mage
     * @param age Age du Mage
     * @param nv Niveau du Mage
     * @param sort Sort du Mage
     */
    public Mage(String nom, String sexe, int poids, int taille, int age, int nv, String sort) {
        super(nom, sexe, poids, taille, age, nv, sort);
    }

    public static double getMULTIPL() {
        return MULTIPL;
    }
    /**
     * Attaque spéciale du Mage
     * Attaque puissante du Mage et fait perdre de la vie au Boss
     */
    public static void attaque_Spéciale_Mage() {
        degat += Mana/100 ;
        perdre_vie_Boss();
    }
}


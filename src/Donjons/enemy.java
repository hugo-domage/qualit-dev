package Donjons;
import Donjons.*;
import static Personnages.Personnages.getForce;
import static Personnages.Personnages.getMULTIPL;

public abstract class enemy {
    private String nom;
    private static int santé ;
    private int XP;

    static int degat = (int) (getForce() +  getMULTIPL());

    public enemy(String nom, int santé, int XP) {
        this.nom = nom;
        this.santé = santé;
        this.XP = XP;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public static boolean est_En_Vie() {
        return Boss.santé > 0;
    }

    }


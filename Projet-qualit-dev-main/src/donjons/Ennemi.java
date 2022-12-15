package donjons;
import static personnages.Personnages.getForce;
import static personnages.Personnages.getMULTIPL;

public abstract class Ennemi {
    private String nom;
    private static int sante ;
    private int XP;

    static int degats = (int) (getForce() +  getMULTIPL());

    public Ennemi(String nom, int sante, int XP) {
        this.nom = nom;
        this.sante = sante;
        this.XP = XP;
    }


    public static boolean est_En_Vie() {
        return Boss.sante > 0;
    }
}


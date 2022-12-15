package Personnages;


import Donjons.Boss;

import java.util.HashMap;

import static Donjons.Boss.*;
import static Donjons.Boss.perdre_vie_Boss;


public abstract class Personnages {

    String nom;
    String sexe;
    static int poids;
    int taille;
    int age;
    static int degats;

    static int force = 25;
    private int playerNumber;
    static int faim = 100;
    public static int santé = 100;

    static int degat = (int) (getForce() +  getMULTIPL());
    int po;
    int niveau;
    public static int nv =1;
    public static int Xp = 0;

    private static final double MULTIPL=300;

    public static int getDegat() {
        return degat;
    }

    public static void setDegat(int degat) {
        Personnages.degat = degat;
    }

    public static double getMULTIPL() {
        return MULTIPL;
    }


    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }

    public int getXp() {
        return Xp;
    }

    public void setXp(int xp) {
        Xp = xp;
    }

    static HashMap<Integer, String> inventaire = new HashMap<>(); // numero du sac 1,2,3,4; nom de l'objet

    static String sort ; //  nom du sort


    public Personnages(String nom, String sexe, int poids, int taille, int age, int force, int nv, int po, int degat, String sort ) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.nv = nv;
        this.po = po;
        this.sort = sort;
        this.inventaire = inventaire;
        this.santé = santé;
        this.force = force;
        this.Xp = Xp;

    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public static int getFaim() {
        return faim;
    }

    public void setFaim(int faim) {
        Personnages.faim = faim;
    }

    public static int getSanté() {
        return santé;
    }

    public static void setSanté(int santé) {
        Personnages.santé = santé;
    }

    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }





    public HashMap<Integer, String> getInventaire() {
        return inventaire;
    }

    public void setInventaire(HashMap<Integer, String> inventaire) {
        Personnages.inventaire = inventaire;
    }




    public static String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }




    public static void perdre_vie_Joeur() {

        System.out.println("joueur perd " + degat_Boss + " points de vie");
        santé=(santé - degat_Boss);
        if (santé > 0) {
            System.out.println("Joueur " + santé + " points de vie");
        }
        if (santé == 0) {
            System.out.println("Joueur " + santé + " points de vie");
        }
    }



    public void manger() {
        int barre_de_faim = getFaim();
        System.out.println("joueur mange " + faim + " barre de nourriture ");
        setFaim(faim + 35);
        if (getFaim() == 100) {
            System.out.println("Le personnage est nourit");
        }

    }



        public static void utiliser_un_objet() {
            HashMap<Integer,String> inventaire = new HashMap<Integer,String>();
            inventaire.put(2," potion de rage");
            inventaire.put(1,"potion de vie");
            if (santé == 100) {
                System.out.println("personnage est deja 100% HP");

            } else if (santé < 100 && inventaire.containsKey(1) && inventaire.containsValue("potion de vie")) {
                santé = santé + 20;
                System.out.println("personnage utilise une potion de vie");
                System.out.println("personnage est soigné, elle se retrouve avec : " + santé +" Hp");
            } else {
                System.out.println("pas de potion dans l'inventaire ");

            }
        }





    public static void gagner_Xp(){
        if (!Boss.est_En_Vie()) {
            Personnages.Xp += Boss.Xp;
            System.out.println("tu gagnes "+ Xp + "Xp");
        }
        Systeme_de_nv();
    }

    public static void Systeme_de_nv() {
        if (Personnages.Xp <= 1000 && Personnages.nv == 1) {
            Personnages.nv = 2;
            Personnages.Xp = 0; //retour a 0 d'xp car le peronnage passe un nv
            System.out.println("tu viens de passer un nv, tu es maintenant au niveau 2");
        } else if (Personnages.Xp <= 2000 && Personnages.nv == 2) {
            Personnages.nv = 3;
            Personnages.Xp = 0;
            System.out.println("tu viens de passer un nv, tu es maintenant au niveau 3");
        } else if (Personnages.Xp <= 3000 && Personnages.nv == 3) {
            Personnages.nv = 4;
            Personnages.Xp = 0;
            System.out.println("tu viens de passer un nv, tu es maintenant au niveau 4");
        }
    }

    public static boolean est_En_Vie() {
        return santé > 0;
    }

    public static void attaquer1(){ // attque de base joueur
        System.out.println("joueur attaque avec son attaque de base, il fait " + degat +" degat ");
        perdre_vie_Boss();
    }
        public static boolean esquive() {
            int chance = (int) (Math.random() * 3);
            return chance == 0;
        }
    }





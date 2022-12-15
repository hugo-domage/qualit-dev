package Personnages;

import static Donjons.Boss.*;


public class Guerrier extends Personnages {
    private static final double MULTIPL = 1.25;

    static int rage =20;

    public Guerrier(String nom, String sexe, int poids, int taille, int age, int force, int degat, int po, int niveau, String sort) {
        super(nom, sexe,
                poids,
                taille,
                age,
                force,
                faim,
                santé,
                po,
                sort
        );




    }




    public static double getMULTIPL() {
        return MULTIPL;
    }

    public static int getdegats() {
        return degats;
    }


    /*
        public void attaquer() {
            if (arme != null) {
                for(HashMap.Entry<String, Integer> entry : sort.entrySet()) {
                    entry.setValue((int)(entry.getValue()*MULTIPL));
                }
            }
        }*/

    public static void attaque_Spéciale_Guerrier() {
         degat += rage ;
        perdre_vie_Boss();
        }
    }


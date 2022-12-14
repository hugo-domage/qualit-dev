package Personnages;

import Armure.Armure_en_maille;
import Donjons.*;

import java.util.HashMap;

import static Donjons.Boss.*;
import Personnages.Personnages.*;


public class Guerrier extends Personnages implements Armure_en_maille {
    private static final double MULTIPL = 1.25;

    static int rage =20;

    public Guerrier(String nom, String sexe, int poids, int taille, int age, int force, int degat, int po, int niveau, int honneur, String sort) {
        super(nom, sexe,
                poids,
                taille,
                age,
                force,
                faim,
                santé,
                po,
                degat,
                sort,
                inventaire
        );

        this.inventaire = inventaire;


    }




    public static double getMULTIPL() {
        return MULTIPL;
    }

    public static int getdegats() {
        return degats;
    }

    @Override
    public void Armure_en_maille() {

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


package Personnages;

import Armure.Armure_en_maille;
import Donjons.*;

import java.util.HashMap;

import static Donjons.Boss.*;
import Personnages.Personnages.*;


public class Guerrier extends Personnages implements Armure_en_maille {
    static int degats;
    private static final double MULTIPL = 1.25;

    public Guerrier(String nom, String sexe, int poids, int taille, int age, int force, int degats, int po, int niveau, int honneur, String sort, HashMap<Integer, String> inventaire) {
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

        this.inventaire = inventaire;
        arme.put(12, "épée du revenant");

    }


    @Override
    public int getDegats() {
        return degats;
    }

    @Override
    public void setDegats(int degats) {
        Guerrier.degats = degats;
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
/*
    public void attaquer_de_base(Personnages p){
       int degat = (int) (getForce() +  getMULTIPL());
        System.out.println("joueur"  + getSort() +degat +"degat");
        Boss.perdre_vie_Boss();
    }*/
    public static void attaque_Spéciale_Guerrier() {
        int degat = degat + 35;
        perdre_vie_Boss();
        }
    }


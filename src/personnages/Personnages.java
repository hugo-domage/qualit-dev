package personnages;


import donjons.Boss;

import java.util.HashMap;

import static donjons.Boss.*;


    public abstract class Personnages {

        String nom;
        String sexe;
        static int poids;
        int taille;
        int age;


        static int force = 25;

        public static int sante = 100;

        static int degat = (int) (getForce() + getMULTIPL());
        public static int nv = 1;
        public static int Xp = 0;

        private static final double MULTIPL = 10;

        public static double getMULTIPL() {
            return MULTIPL;
        }

        public static int getForce() {
            return force;
        }

        public static int getSanté() {
            return sante;
        }

        public static int getDegat() {
            return degat;
        }

        public static void setDegat(int degat) {
            Personnages.degat = degat;
        }

        static HashMap<Integer, String> inventaire = new HashMap<>(); // numero du sac 1,2,3,4; nom de l'objet

        static String sort; //  nom du sort


        public Personnages(String nom, String sexe, int poids, int taille, int age, int nv, String sort) {
            this.nom = nom;
            this.sexe = sexe;
            this.poids = poids;
            this.taille = taille;
            this.age = age;
            this.nv = nv;
            this.sort = sort;
        }





        public HashMap<Integer, String> getInventaire() {
            return inventaire;
        }


        public static void perdre_vie_Joueur() {

            System.out.println("joueur perd " + degats_Boss + " points de vie");
            sante = (sante - degats_Boss);
            if (sante > 0) {
                System.out.println("Joueur " + sante+ " points de vie");
            }
            if (sante == 0) {
                System.out.println("Joueur " + sante + " points de vie");
            }
        }

        public static void utiliser_un_objet() {
            HashMap<Integer, String> inventaire = new HashMap<Integer, String>();
            inventaire.put(2, " potion de rage");
            inventaire.put(1, "potion de vie");
            if (sante == 100) {
                System.out.println("personnage est deja 100% HP");

            } else if (sante < 100 && inventaire.containsKey(1) && inventaire.containsValue("potion de vie")) {
                sante = sante + 20;
                System.out.println("personnage utilise une potion de vie");
                System.out.println("personnage est soigné, elle se retrouve avec : " + sante + " Hp");
            } else {
                System.out.println("pas de potion dans l'inventaire ");

            }
        }


        public static void gagner_Xp() {
            if (!Boss.est_En_Vie()) {
                Personnages.Xp += Boss.Xp;
                System.out.println("tu gagnes " + Xp + "Xp");
            }
            Systeme_de_nv();
        }

        public static void Systeme_de_nv() {
            if (Personnages.Xp >= 1000 && Personnages.nv == 1) {
                Personnages.nv = 2;
                Personnages.Xp = 0; //retour a 0 d'xp car le peronnage passe un nv
                System.out.println("tu viens de passer un nv, tu es maintenant au niveau 2");
            } else if (Personnages.Xp >= 2000 && Personnages.nv == 2) {
                Personnages.nv = 3;
                Personnages.Xp = 0;
                System.out.println("tu viens de passer un nv, tu es maintenant au niveau 3");
            } else if (Personnages.Xp >= 3000 && Personnages.nv == 3) {
                Personnages.nv = 4;
                Personnages.Xp = 0;
                System.out.println("tu viens de passer un nv, tu es maintenant au niveau 4");
            }
        }

        public static boolean est_En_Vie() {
            return sante > 0;
        }

        public static void attaquer1() { // attque de base joueur
            System.out.println("joueur attaque avec son attaque de base, il fait " + degat + " degat ");
            perdre_vie_Boss();
        }



        public static void bouclier() {
            double bouclierGuerrier = sante * 0.25;
            sante += bouclierGuerrier;
            System.out.println("Votre bouclier a été activé et vous protège avec " + bouclierGuerrier + " points de vie!");
            System.out.println("Votre vie est maintenant de" + sante + " point de vie");
        }
    }




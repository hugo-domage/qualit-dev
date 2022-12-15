package Game;

import Donjons.Boss;
import Personnages.Personnages;
import Personnages.*;
import thread.TimeoutThread;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;



public class Jeu {


    private static int classe;

    public static void Creation_personange() { //Création du personnage
        System.out.println("Veuillez créer votre personnage");
        System.out.println("Quel est la classe que vous choisissez?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Guerrier");
        System.out.println("2. Archer");
        System.out.println("3. Mage");
        classe = scanner.nextInt();
        String classeChoisit = "";
        switch (classe) {
            case 1:
                classeChoisit = "Guerrier";
                break;
            case 2:
                classeChoisit = "Archer";
                break;
            case 3:
                classeChoisit = "Mage";
                break;
            default:
                classeChoisit= "Guerrier";
                break;
        }



        System.out.println("La classe de ton personnage : " + classeChoisit);

        System.out.println("Quel est votre nom ?");
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();
        System.out.println("Le nom de ton personnage : " + nom);

        System.out.println("Choisit le sexe de ton personnage");
        Scanner sc1 = new Scanner(System.in);
        String sexe = sc1.nextLine();
        System.out.println("Le sexe de ton personnage : " + sexe);

        System.out.println("Choisit le poids de ton personnage");
        Scanner sc2 = new Scanner(System.in);
        int poids = sc2.nextInt();
        System.out.println("Le poids de ton personnage : " + poids + "kg");

        System.out.println("Choisit la taille de ton personnage");
        Scanner sc3 = new Scanner(System.in);
        int taille = sc3.nextInt();
        System.out.println("La taille de ton personnage : " + taille + "cm");

    }

    public static void Choix_Du_Donjons() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel donjon veux-tu visiter?");
        System.out.println("1. Tanière du dragon");
        System.out.println("2. Marécage");
        System.out.println("3. La grotte");
        int choixDonjon = sc.nextInt();
        String nomDonjon = "";
        String nomBoss = "";
        switch (choixDonjon) {
            case 1:
                nomDonjon = "Tanière du dragon";
                nomBoss = "Dragon";
                break;
            case 2:
                nomDonjon = "Marécage";
                nomBoss = "Monstre marin";
                break;
            case 3:
                nomDonjon = "La grotte";
                nomBoss = "Yéti";
                break;
        }
        System.out.println("--- Tu rentres dans le donjon " + nomDonjon + " ---");
        System.out.println("Tu es face a face avec le Boss");
        System.out.println(nomBoss);
    }


    // combat
    public static void Combat() {

        Scanner sc = new Scanner(System.in);
        while (Boss.est_En_Vie() || Personnages.est_En_Vie()) {

            System.out.println("Quelle est le nom du sort que tu souhaite utiliser ? ");
            if (classe == 1)// Guerrier
                 {
                     System.out.println("1. attaque de base");
                     System.out.println("2. attaque spéciale");
                     System.out.println("3. esquive");
                     int CHoixDesAttaques = sc.nextInt();
                     String attaqueChoisit = "";

                     switch (CHoixDesAttaques) {
                         case 1:
                             Guerrier.attaquer1();
                             break;
                         case 2:Guerrier.attaque_Spéciale_Guerrier();
                             break;
                         case 3:
                             Personnages.esquive();
                             break;
                     }

            }
            if (classe == 2)// Archer
            {
                System.out.println("1. attaque de base");
                System.out.println("2. attaque spéciale");
                System.out.println("3. esquive");
                int CHoixDesAttaques = sc.nextInt();
                String attaqueChoisit = "";
                switch (CHoixDesAttaques) {
                    case 1:
                        Archer.attaquer1();
                        break;
                    case 2:
                        Archer.attaque_Spéciale_Archer();
                        break;
                    case 3:
                        Personnages.esquive();


                        break;
                }

            }
            if (classe == 3)// Mage
            {
                System.out.println("1. attaque de base");
                System.out.println("2. attaque spéciale");
                System.out.println("3. esquive");
                int CHoixDesAttaques = sc.nextInt();
                String attaqueChoisit = "";
                String nomAttaque ="";
                switch (CHoixDesAttaques) {
                    case 1:
                        Mage.attaquer1();
                        break;
                    case 2:
                        Mage.attaque_Spéciale_Mage();
                        break;
                    case 3:
                        Personnages.esquive();
                        break;
                }

            }

        }




        int random1 = (int) (Math.random() * 2);
        if (random1 == 1) {
            System.out.println("--- Le Boss attaque !!! ---");

            int random = (int) (Math.random() * 10); // Génère un nombre entier entre 0 et 10
            if (random <= 5) { // La chance de réussir l'attaque est de 50%
                Boss.attaquer1_Boss();
            } else {
                System.out.println("L'attaque du Boss a échoué !");
            }
        }

        if (random1 == 2) {
            // Le boss peut attaquer soit avec son attaque de base sois une attaque spéciale
            System.out.println("--- Le Boss attaque avec son attaque spéciale !!! ---");
            int random2 = (int) (Math.random() * 10); // Génère un nombre entier entre 0 et 10
            if (random2 <= 3) { // La chance de réussir l'attaque est de 30%
                Boss.attaquer_Spéciale_Boss();
            } else {
                System.out.println("L'attaque spéciale du Boss a échoué !");
            }
        }

        if (Personnages.getSanté() <= 30) {
            System.out.println("Tes points de vie commence a diminuer, souhaites-tu utiliser une potion de vie ? ");
            Scanner sc1 = new Scanner(System.in);
            String Choix_potion_oui_non = sc1.nextLine();
            if (Objects.equals(Choix_potion_oui_non, "oui")) {
                System.out.println("tu utilises une potion de vie");
                Personnages.utiliser_un_objet();
            } else if (Objects.equals(Choix_potion_oui_non, "non")) {
                System.out.println("tu n'utilises pas de potion de vie");
            }

        }


        System.out.println("~ Le Boss est mort, Le joueur gagne ~");
        Personnages.gagner_Xp();
        Personnages.Systeme_de_nv();
        if (!Personnages.est_En_Vie()) {
            System.out.println("~ Le Joueur est mort, Le joueur perd ~");

        }
    }

    public void endGame() {
        System.exit(0);
    }

}



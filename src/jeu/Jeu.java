package jeu;

import equipement.Armure;
import donjons.Boss;
import personnages.Personnages;
import personnages.*;

import java.util.*;


public class Jeu {


    private static int classe;

    public static void Creation_personange(List<Armure> armureList) { //Création du personnage
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

        System.out.println("Choix de l'armure  ");
        Scanner sc4 = new Scanner(System.in);
        for (int i = 0; i < armureList.size(); i++) {
            System.out.printf("%d . %s%n", i, armureList.get(i).toString());
        }
        Armure armure = armureList.get(sc4.nextInt());

        System.out.printf("Armure choisi : %s%n", armure.toString());

    }

    public static void Choix_Du_Donjons() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel donjon veux-tu visiter?");
        System.out.println("1. Tanière du dragon");
        System.out.println("2. Marécage");
        System.out.println("3. La Grotte");
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
                nomDonjon = "La Grotte";
                nomBoss = "Yéti";
                break;
            default:
                nomDonjon= "Abysse infernale";
                nomBoss="Kyllian Mbappe";
        }
        System.out.println("--- Tu rentres dans le donjon " + nomDonjon + " ---");
        System.out.println("Tu es face a face avec le Boss");
        System.out.println(nomBoss);
    }


    // combat
    public static void Combat() {
        Boss.resurection();
        while (Boss.est_En_Vie() && Personnages.est_En_Vie()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Quelle est le nom du sort que tu souhaite utiliser ? ");
            switch (classe) {
                case 1:
                    sortGuerrier(sc);
                    break;
                case 2:
                    sortArcher(sc);
                    break;
                case 3:
                    sortMage(sc);
                    break;
            }

            if (!Boss.est_En_Vie()) {
                System.out.println("~ Le Boss est mort, Le joueur gagne ~");
                Personnages.gagner_Xp();
                Personnages.Systeme_de_nv();
                break;
            }
            else {
                int random1 = (int) (Math.random() * 2);
                if (random1 == 0) {
                    attaqueDuBoss();
                }

                if (random1 == 1) {
                    attaqueSpecialeBoss();
                }
            }

            if (Personnages.getSanté() <= 30) {
                potion();

            }

            if (!Personnages.est_En_Vie()) {
                System.out.println("~ Le Joueur est mort, Le joueur perd ~");
                break;
            }
        }
    }

    private static void attaqueSpecialeBoss() {
        // Le boss peut attaquer soit avec son attaque de base soit avec une attaque spéciale
        System.out.println("--- Le Boss attaque avec son attaque spéciale !!! ---");
        int random2 = (int) (Math.random() * 10); // Génère un nombre entier entre 0 et 10
        if (random2 <= 3) { // La chance de réussir l'attaque est de 30%
            Boss.attaquer_Spéciale_Boss();
        } else {
            System.out.println("L'attaque spéciale du Boss a échoué !");
        }
    }

    private static void attaqueDuBoss() {
        System.out.println("--- Le Boss attaque !!! ---");

        int random = (int) (Math.random() * 10); // Génère un nombre entier entre 0 et 10
        if (random <= 5) { // La chance de réussir l'attaque est de 50%
            Boss.attaquer1_Boss();
        }
        else {
            System.out.println("L'attaque du Boss a échoué !");
        }
    }

    private static void sortMage(Scanner sc) {
        System.out.println("1. attaque de base");
        System.out.println("2. attaque spéciale");
        System.out.println("3. bouclier");
        int ChoixDesAttaques = sc.nextInt();
        String attaqueChoisit = "";
        String nomAttaque = "";
        switch (ChoixDesAttaques) {
            case 1:
                Mage.attaquer1();
                break;
            case 2:
                Mage.attaque_Spéciale_Mage();
                break;
            case 3:
                Personnages.bouclier();
                break;
            default:
                Personnages.attaquer1();
        }
    }

    private static void sortArcher(Scanner sc) {
        System.out.println("1. attaque de base");
        System.out.println("2. attaque spéciale");
        System.out.println("3. bouclier");
        int ChoixDesAttaques = sc.nextInt();
        String attaqueChoisit = "";
        switch (ChoixDesAttaques) {
            case 1:
                Archer.attaquer1();
                break;
            case 2:
                Archer.attaque_Spéciale_Archer();
                break;
            case 3:
                Personnages.bouclier();
                break;
            default:
                Personnages.attaquer1();
        }
    }

    private static void sortGuerrier(Scanner sc) {
        System.out.println("1. attaque de base");
        System.out.println("2. attaque spéciale");
        System.out.println("3. bouclier");
        int ChoixDesAttaques = sc.nextInt();
        String attaqueChoisit = "";

        switch (ChoixDesAttaques) {
            case 1:
                Guerrier.attaquer1();
                break;
            case 2:
                Guerrier.attaque_Spéciale_Guerrier();
                break;
            case 3:
                Personnages.bouclier();
                break;
            default:
                Personnages.attaquer1();
        }
    }

    private static void potion() {
        System.out.println("Tes points de vie commence à diminuer, souhaites-tu utiliser une potion de vie ? ");
        Scanner sc1 = new Scanner(System.in);
        String Choix_potion_oui_non = sc1.nextLine();
        if (Objects.equals(Choix_potion_oui_non, "oui")) {
            System.out.println("tu utilises une potion de vie");
            Personnages.utiliser_un_objet();
        } else if (Objects.equals(Choix_potion_oui_non, "non")) {
            System.out.println("tu n'utilises pas de potion de vie");
        }
    }
}



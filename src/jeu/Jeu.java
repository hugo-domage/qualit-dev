package jeu;

import equipement.Armure;
import donjons.Boss;
import personnages.Personnages;
import personnages.*;

import java.util.*;

/**
 * Classe Jeu qui permet de créer un personnage.
 * Elle permet de choisir une classe (Guerrier, Archer ou Mage), un nom, un sexe, un poids et une taille ainsi qu'une armure.
 * Elle permet de combattre des boss et d'explorer des donjons
 */
public class Jeu {


    public static int classe;

    /**
     * Cette méthode permet de créer un personnage à l'aide d'une liste d'armures.
     * L'utilisateur doit choisir la classe, le nom, le sexe, le poids et la taille du personnage, ainsi qu'une armure de la liste fournie.
     *
     * @param armureList La liste des armures disponibles pour le personnage.
     */
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

    /**
     * Cette fonction permet à l'utilisateur de choisir un donjon à visiter. Il peut choisir entre la tanière du dragon, le marécage et la grotte. En fonction du donjon choisi, un boss différent sera affiché à l'utilisateur.
     */
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

    /**
     * Cette fonction permet de simuler un combat entre un personnage et un boss.
     * Elle commence par la résurrection du boss, et se poursuit tant que le personnage et le boss sont encore en vie.
     * A chaque tour de combat, le personnage peut choisir un sort selon sa classe et l'utiliser sur le Boss.
     * Le Boss peut à chaque tour utiliser une attaque normale ou une attaque spéciale, aléatoirement.
     * En cas de santé très faible, le personnage peut prendre une potion afin de se soigner.
     * Si le Boss est vaincu, le personnage gagne de l'expérience et peut monter de niveau.
     * Si le personnage est vaincu, le joueur perd. C'est le seul moyen d'arrêter la partie.
     */
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

    /**
     * Cette fonction modélise l'attaque spéciale du Boss. Il y a une chance de 30 % qu'elle réussisse.
     * Si elle réussit, la fonction attaquer_Spéciale_Boss() du Boss est appellée.
     */
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

    /**
     * Cette méthode simule une attaque du Boss dans un jeu.
     * Elle génère un nombre aléatoire entre 0 et 10, et si ce nombre est inférieur ou égal à 5, elle lance l'attaque du Boss.
     * Sinon, elle affiche un message indiquant que l'attaque a échoué.
     */
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

    /**
     * Cette méthode permet de choisir une des attaques disponibles pour le Mage.
     * @param sc un Scanner qui permet de récupérer le choix de l'utilisateur
     */
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

    /**
     * Méthode utilisée pour déterminer l'attaque à effectuer par l'archer.
     * @param sc Scanner permettant la saisie du choix de l'attaque.
     * Les attaques disponibles sont :
     * 1. attaque de base
     * 2. attaque spéciale
     * 3. bouclier
     * Si un choix non valide est entré, l'attaque de base sera effectuée.
     */
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

    /**
     * Cette méthode permet à l'utilisateur de choisir l'attaque qu'il souhaite effectuer.
     * Il a le choix entre une attaque de base, une attaque spéciale ou le bouclier.
     *
     * @param sc Le scanner qui sert à récupérer le choix de l'utilisateur
     */
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

    /**
     * Cette méthode permet de gérer l'utilisation des potions de vie.
     * Elle demande à l'utilisateur s'il souhaite utiliser une potion de vie.
     * Si l'utilisateur répond "oui", alors la méthode Personnages.utiliser_un_objet() est appelée.
     * Si l'utilisateur répond "non", alors l'utilisation de la potion est annulée.
     */
    public static void potion() {
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



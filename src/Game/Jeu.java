package Game;

import Donjons.Boss;
import Personnages.Personnages;
import Personnages.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;



public class Jeu {


    public Jeu(String nom, String sexe, int poids, int taille, int age, int force, int degats, int playerNumber, int po, int niveau) {

    }

    public static void Creation_personange() { //Création du personnage
        System.out.println("Veuillez créer votre personnage");
        System.out.println("Quel est la classe que vous choisissez?");
        Scanner scanner = new Scanner(System.in);
        String classe = scanner.nextLine();
        System.out.println("La classe de ton personnage : " + classe);

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
        if (Objects.equals(classe, "guerrier")) {
            int force = 25;
        }
    }

    public static void Choix_Du_Donjons() {
        System.out.println("--- Vous entrez dans la selection du Donjons ---");
        Scanner sc = new Scanner(System.in);
        String Donjons = sc.nextLine();
        if (Objects.equals(Donjons, "Dragon")) {
            System.out.println("le donjons choisit : " + Donjons);
        }
    }


    // combat
    public static void Combat() {
        System.out.println("--- Tu rentres dans le donjons la taniére des Dragon ---");
        System.out.println("Tu es face a face avec le Boss");
        System.out.println("Dragon");
        Scanner sc = new Scanner(System.in);

        System.out.println("Choisissez votre classe : Guerrier, Archer ou Mage");
        String classe = sc.nextLine();

        while (Boss.est_En_Vie() || Personnages.est_En_Vie()) {

            System.out.println("Quelle est le nom du sort que tu souhaite utiliser ? ");
            String nom_sort = sc.nextLine();
            System.out.println("Le nom du sort que tu souhaite utiliser : " + nom_sort);

            if (classe.equals("Guerrier")) {
                if (Objects.equals(nom_sort, "attaque de base")) {
                    Personnages.attaquer1();
                } else if (Objects.equals(nom_sort, "attaque Spéciale")) {
                    Guerrier.attaque_Spéciale_Guerrier();
                } else {
                    System.out.println("tu as raté ton attaque");
                }
            } else if (classe.equals("Archer")) {
                if (Objects.equals(nom_sort, "attaque de base")) {
                    Archer.attaquer1_Archer();
                } else if (Objects.equals(nom_sort, "attaque Spéciale")) {
                    Archer.attaque_Spéciale_Archer();
                } else {
                    System.out.println("tu as raté ton attaque");
                }
            } else if (classe.equals("Mage")) {
                if (Objects.equals(nom_sort, "attaque de base")) {
                    Mage.attaquer1_Mage();
                } else if (Objects.equals(nom_sort, "attaque Spéciale")) {
                    Mage.attaque_Spéciale_Mage();
                } else {
                    System.out.println("tu as raté ton attaque");
                }
            }
            
            System.out.println("--- Le Boss attaque !!! ---");
            Boss.attaquer1_Boss();
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
        }
        if (!Boss.est_En_Vie()) {
            System.out.println("~ Le Boss est mort, Le joueur gagne ~");
            Personnages.gagner_Xp();
            Personnages.Systeme_de_nv();
        }
        if (!Personnages.est_En_Vie()) {
            System.out.println("~ Le Joueur est mort, Le joueur perd ~");

        }
    }
}

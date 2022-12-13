package Game;
import java.util.Scanner;
public class Menu {
    // Attributs

    // Constructors :
    public Menu() {
    }

    // Méthodes
    public int displayMainMenu(){
        System.out.println("1 - Gestion des personnages");
        System.out.println("2 - CHoisir le donjon");
        System.out.println("9 - Quitter");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }

    public int displayCharacterMenu(){
        System.out.println("1 - Créer personnage");
        System.out.println("2 - Modifier personnage");
        System.out.println("3 - Supprimer personnage");
        System.out.println("9 - Menu principal");
        System.out.println("Votre choix : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }

    public void badMenuChoice(){

        System.out.println("mauvais choix de menu");
    }
}
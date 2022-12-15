package typeAttaque;

public interface Attaquemelee {

    public default void Attaque_melee() {
        System.out.println("Attaque au corps a corps ");
    }
}

package typeAttaque;
/**
 * Interface permettant d'effectuer une attaque au corps à corps.
 */
public interface Attaquemelee {

    public default void Attaque_melee() {
        System.out.println("Attaque au corps a corps ");
    }
}

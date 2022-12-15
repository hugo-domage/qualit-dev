package typeAttaque;

/**
 * Interface qui définit une méthode de type AttaqueDistance.
 * La méthode Attaque_Distance() affiche "Attaque a distance" à l'écran.
 */
public interface AttaqueDistance {

    public default void Attaque_Distance(){
        System.out.println("Attaque a distance");
    }


}

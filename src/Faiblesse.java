import java.util.Random;

public class Faiblesse {
    private String[] listeFaiblesse = new String[]{
            "Feu",
            "Eau",
            "Vent"
    };


    public String donneFaiblesse(){
        Random r = new Random();
        int aleatoire = r.nextInt(4); // Nombre aléatoire entre 0 et 4 non compris
        return listeFaiblesse[aleatoire];
    }

}

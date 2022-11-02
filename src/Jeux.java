import java.util.Scanner;

public class Jeux {

    private int vague=1;
    /*
    Création monstre
     */
    Dragon dragon = new Dragon();
    Goblin goblin = new Goblin(15,5);
    Orque orque = new Orque();

    Action action = new Action();

    public void tourDeJeu (Personnage personnage){


        while (personnage.getVie() > 0){
            switch (vague) {
                case 1:
                    while (goblin.getVie() > 0) {
                        action.attaquer(goblin, null, null, personnage);
                        System.out.println(goblin.getVie());
                    }
                    vague++;
                    break;
                case 2:
                    vague++;
                    break;
                case 3:
                    vague++;
                    break;
            }
            if (vague>3){break ;}

        }

    }




}

import java.util.Scanner;

public class Jeux {

    private int vague=1;
    /*
    Création monstre
     */
    Dragon dragon = new Dragon(30);
    Goblin goblin = new Goblin(15,5);
    Orque orque = new Orque(20,5);

    Action action = new Action();

    public void tourDeJeu (Personnage personnage){
        Scanner sc= new Scanner(System.in);

        while (personnage.getVie() > 0){
            switch (vague) {
                case 1:

                    System.out.println("Un goblin apparait devant vous avec " + goblin.getVie() + " points de vie et " + goblin.getForce() + " points de force");
                    System.out.println("Vous voyez que sa faiblesse est de type : " + goblin.getFaiblesse());

                    while (goblin.getVie() > 0) {

                        if (choixAction(sc) == 1) {
                            action.attaquer(goblin, null, null, personnage);
                            System.out.println("Il reste "+ goblin.getVie() + " points de vie");
                        }
                        System.out.println("Le goblin vous attaque");
                        personnage.setVie(personnage.getVie()- goblin.getForce());

                        System.out.println("Il vous reste " + personnage.getVie() + " points de vie");
                    }
                    System.out.println("Goblin mort");
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

    private int choixAction(Scanner sc){
        String[] choix = new String[]{
                "Attaquer",
                "Passer son tour",
        };
        int choixActionInt;

        for (int i=0; i < choix.length; i++){
            System.out.println(i+1 + "-" + choix[i]);
        }
        String choixPris = sc.nextLine();

        //Convert du choix de l'utilisateur passage de String à int
        return choixActionInt = obtenirChoixActionInt(sc, choix, choixPris);


    }

    private static int obtenirChoixActionInt(Scanner sc, String[] choix, String choixPris) {
        int choixActionInt;
        while(true) {
            try {
                choixActionInt = Integer.parseInt(choixPris);
                break;
            } catch (Exception e) {
                System.out.println("Saisie invalide !");
                System.out.print("Veuillez faire votre choix entre les " + choix.length + " effets à appliquer à votre personnage : ");
                choixPris = sc.nextLine();
            }
        }
        return choixActionInt;
    }




}

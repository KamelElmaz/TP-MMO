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

        String[] armeTomber = new String[]{
                "grand baton",
                "épée longue",
                "grand arc"
        };

        String[] classe = personnage.getClasse().attributClasse().split("\\|");

        while (personnage.getVie() > 0){
            switch (vague) {
                case 1:
                    debutVague();

                    System.out.println("Un goblin apparait devant vous avec " + goblin.getVie() + " points de vie et " + goblin.getForce() + " points de force");
                    System.out.println("Vous voyez que sa faiblesse est de type : " + goblin.getFaiblesse());

                    while (goblin.getVie() > 0) {

                        if (choixAction(sc) == 1) {
                            System.out.println("Vous attaquez le goblin");
                            action.attaquer(goblin, null, null, personnage);
                            if (goblin.getVie()<= 0){break;}
                            System.out.println("Il reste "+ goblin.getVie() + " points de vie");
                        }

                        System.out.println("Le goblin vous attaque");
                        personnage.setVie(personnage.getVie()- goblin.getForce());

                        System.out.println("Il vous reste " + personnage.getVie() + " points de vie");
                    }
                    System.out.println("Le Goblin est mort");
                    if (classe[0].equals("Guerrier")){
                        System.out.println("Une arme est tombé, c'est une " + armeTomber[1]);
                        choixRamasserArme(sc,personnage,armeTomber[1]);

                    } else if (classe[0].equals("Mage")) {
                        System.out.println("Une arme est tombé, c'est un " + armeTomber[0]);
                        choixRamasserArme(sc,personnage,armeTomber[0]);
                    }
                    else if (classe[0].equals("Archer")){
                        System.out.println("Une arme est tombé, c'est un " + armeTomber[2]);
                        choixRamasserArme(sc,personnage,armeTomber[2]);
                    }
                    finVague();
                    vague++;
                    break;
                case 2:
                    debutVague();

                    System.out.println("Un orque apparait devant vous avec " + orque.getVie() + " points de vie et " + orque.getForce() + " points de force");
                    System.out.println("Vous voyez que sa faiblesse est de type : " + orque.getFaiblesse());

                    while (orque.getVie() > 0) {

                        if (choixAction(sc) == 1) {
                            System.out.println("Vous attaquez l'orque");
                            action.attaquer(null, orque, null, personnage);
                            if (orque.getVie()<= 0){break;}
                            System.out.println("Il reste "+ orque.getVie() + " points de vie");
                        }

                        System.out.println("L'orque vous attaque");
                        personnage.setVie(personnage.getVie()- orque.getForce());

                        System.out.println("Il vous reste " + personnage.getVie() + " points de vie");
                    }
                    System.out.println("L'orque est mort");
                    finVague();

                    vague++;
                    break;
                case 3:
                    debutVague();

                    System.out.println("Un dragon apparait devant vous avec " + dragon.getVie() + " points de vie et " + dragon.getForce() + " points de force");
                    System.out.println("Vous voyez que sa faiblesse est de type : " + dragon.getFaiblesse());

                    while (dragon.getVie() > 0) {

                        if (choixAction(sc) == 1) {
                            System.out.println("Vous attaquez le dragon");
                            action.attaquer(null, null, dragon, personnage);
                            dragon.miseAJourEtat();
                            if (dragon.getVie()<= 0){break;}
                            System.out.println("Il reste "+ dragon.getVie() + " points de vie");
                        }

                        System.out.println("Le dragon vous attaque");
                        personnage.setVie(personnage.getVie()- dragon.getForce());

                        System.out.println("Il vous reste " + personnage.getVie() + " points de vie");
                    }
                    System.out.println("Le dragon est mort");
                    finVague();

                    vague++;
                    messageGagnant();
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

        for (int i=0; i < choix.length; i++){
            System.out.println(i+1 + "-" + choix[i]);
        }
        String choixPris = sc.nextLine();

        //Convert du choix de l'utilisateur passage de String à int
        return obtenirChoixActionInt(sc, choix, choixPris);


    }

    private void choixRamasserArme(Scanner sc, Personnage personnage, String arme){
        String choix = new String();
        while (!choix.equals("O")) {
            System.out.println("Voulez-vous ramasser l'arme ? O:oui, N:non");
            choix = sc.nextLine();
            if (choix.equals("o")){
                choix = "O";
                action.ramasserArme(personnage, arme);
            }
            if (choix.equals("n") || choix.equals("N") ){break;}
        }


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

    private void debutVague(){
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println("La vague " + vague + " commence ! ");
        System.out.println("****************************************************************************");
        System.out.println();
    }
    private  void finVague(){
        System.out.println();
        System.out.println("****************************************************************************");
        System.out.println("La vague " + vague + " est terminé ! ");
        System.out.println("****************************************************************************");
        System.out.println();
    }

    private void messageGagnant(){
        System.out.println("Vous avez gagné !! ");
        System.out.println("   ____  ____ \n" +
                "  / ___|/ ___|\n" +
                " | |  _| |  _ \n" +
                " | |_| | |_| |\n" +
                "  \\____|\\____|\n" +
                "              ");

    }


}

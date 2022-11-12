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
        ConsoleColors consoleColors = new ConsoleColors();
        Scanner sc= new Scanner(System.in);
        SaveVie saveVie = new SaveVie();

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

                    System.out.println("Un " + ConsoleColors.RED_BOLD_BRIGHT + "GOBLIN" + ConsoleColors.RESET + " apparait devant vous avec " +
                            ConsoleColors.GREEN_BOLD_BRIGHT + goblin.getVie() + ConsoleColors.RESET + " points de vie et " +
                            ConsoleColors.PURPLE_BOLD_BRIGHT + goblin.getForce() + ConsoleColors.RESET + " points de force");
                    System.out.println("Vous voyez que sa faiblesse est de type : " + ConsoleColors.BLUE_BOLD_BRIGHT + goblin.getFaiblesse() + ConsoleColors.RESET);

                    saveVie.add(saveViesToMemento(personnage.getVie(),goblin.getVie()));

                    while (goblin.getVie() > 0) {

                        if (personnage.getVie()<=0){
                            break;
                        }

                        if (choixAction(sc) == 1) {
                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Vous attaquez le " + ConsoleColors.RED_BOLD_BRIGHT + "GOBLIN"+ ConsoleColors.RESET);
                            action.attaquer(goblin, null, null, personnage);
                            if (goblin.getVie()<= 0){break;}
                            System.out.println("Il reste "+ ConsoleColors.GREEN_BOLD_BRIGHT + goblin.getVie() + ConsoleColors.RESET +
                                    " points de vie au " + ConsoleColors.RED_BOLD_BRIGHT +"GOBLIN"+ ConsoleColors.RESET);
                        }

                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Le GOBLIN vous attaque" + ConsoleColors.RESET);
                        personnage.setVie(personnage.getVie()- goblin.getForce());

                        System.out.println("Il vous reste " + ConsoleColors.GREEN_BOLD_BRIGHT + personnage.getVie() + ConsoleColors.RESET + " points de vie");
                    }
                    if (goblin.getVie() <= 0){
                        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Le " + ConsoleColors.RED_BOLD_BRIGHT + "GOBLIN" + ConsoleColors.GREEN_BOLD_BRIGHT + " est mort" + ConsoleColors.RESET);

                        switch (classe[0]){
                            case "Guerrier" :
                                System.out.println("Une arme est tombé, c'est une " + ConsoleColors.BLUE_BOLD_BRIGHT + armeTomber[1] + ConsoleColors.RESET);
                                choixRamasserArme(sc,personnage,armeTomber[1]);
                                break;
                            case "Mage" :
                                System.out.println("Une arme est tombé, c'est un " + ConsoleColors.BLUE_BOLD_BRIGHT + armeTomber[0] + ConsoleColors.RESET);
                                choixRamasserArme(sc,personnage,armeTomber[0]);
                                break;
                            case "Archer" :
                                System.out.println("Une arme est tombé, c'est un " + ConsoleColors.BLUE_BOLD_BRIGHT + armeTomber[2] + ConsoleColors.RESET);
                                choixRamasserArme(sc,personnage,armeTomber[2]);
                                break;
                        }

                        finVague();
                        vague++;
                    }
                    recommencer(personnage, saveVie, goblin, orque, dragon);
                    break;
                case 2:
                    debutVague();

                    System.out.println("Un " + ConsoleColors.RED_BOLD_BRIGHT + "ORQUE" + ConsoleColors.RESET + " apparait devant vous avec " +
                            ConsoleColors.GREEN_BOLD_BRIGHT + orque.getVie() + ConsoleColors.RESET + " points de vie et " +
                            ConsoleColors.PURPLE_BOLD_BRIGHT + orque.getForce() + ConsoleColors.RESET + " points de force");
                    System.out.println("Vous voyez que sa faiblesse est de type : " + ConsoleColors.BLUE_BOLD_BRIGHT + orque.getFaiblesse() + ConsoleColors.RESET);

                    saveVie.add(saveViesToMemento(personnage.getVie(),orque.getVie()));

                    while (orque.getVie() > 0) {

                        if (personnage.getVie()<=0){
                            break;
                        }

                        if (choixAction(sc) == 1) {
                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Vous attaquez l'" + ConsoleColors.RED_BOLD_BRIGHT + "ORQUE" + ConsoleColors.RESET);
                            action.attaquer(null, orque, null, personnage);
                            if (orque.getVie()<= 0){break;}
                            System.out.println("Il reste " + ConsoleColors.GREEN_BOLD_BRIGHT + orque.getVie() + ConsoleColors.RESET + " points de vie à l'"+ ConsoleColors.RED_BOLD_BRIGHT + "ORQUE"+ ConsoleColors.RESET);
                        }

                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "L'ORQUE vous attaque" + ConsoleColors.RESET);
                        personnage.setVie(personnage.getVie()- orque.getForce());

                        System.out.println("Il vous reste " + ConsoleColors.GREEN_BOLD_BRIGHT + personnage.getVie() + ConsoleColors.RESET + " points de vie");
                    }

                    if (orque.getVie() <= 0){
                        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "L'" + ConsoleColors.RED_BOLD_BRIGHT + "ORQUE" + ConsoleColors.GREEN_BOLD_BRIGHT + " est mort"+ ConsoleColors.RESET);
                        finVague();
                        vague++;
                    }
                    recommencer(personnage, saveVie, null, orque, null);
                    break;
                case 3:
                    debutVague();

                    System.out.println("Un " + ConsoleColors.RED_BOLD_BRIGHT + "DRAGON" + ConsoleColors.RESET + " apparait devant vous avec " +
                            ConsoleColors.GREEN_BOLD_BRIGHT + dragon.getVie() + ConsoleColors.RESET + " points de vie et " +
                            ConsoleColors.PURPLE_BOLD_BRIGHT + dragon.getForce() + ConsoleColors.RESET + " points de force");
                    System.out.println("Vous voyez que sa faiblesse est de type : " + ConsoleColors.BLUE_BOLD_BRIGHT + dragon.getFaiblesse() + ConsoleColors.RESET);

                    saveVie.add(saveViesToMemento(personnage.getVie(),dragon.getVie()));

                    while (dragon.getVie() > 0) {

                        if (personnage.getVie()<=0){
                            break;
                        }

                        if (choixAction(sc) == 1) {
                            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Vous attaquez le " + ConsoleColors.RED_BOLD_BRIGHT + "DRAGON" + ConsoleColors.RESET);
                            action.attaquer(null, null, dragon, personnage);
                            dragon.miseAJourEtat();
                            if (dragon.getVie()<= 0){break;}
                            System.out.println("Il reste " + ConsoleColors.GREEN_BOLD_BRIGHT + dragon.getVie() + ConsoleColors.RESET + " points de vie au " + ConsoleColors.RED_BOLD_BRIGHT + "DRAGON"+ ConsoleColors.RESET);
                        }

                        System.out.println(ConsoleColors.RED + "Le DRAGON vous attaque" + ConsoleColors.RESET);
                        personnage.setVie(personnage.getVie()- dragon.getForce());

                        System.out.println("Il vous reste " + ConsoleColors.GREEN_BOLD_BRIGHT + personnage.getVie() + ConsoleColors.RESET + " points de vie");
                    }
                    if (dragon.getVie() <= 0){
                        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Le " +ConsoleColors.RED_BOLD_BRIGHT + "DRAGON" + ConsoleColors.GREEN_BOLD_BRIGHT + " est mort"+ ConsoleColors.RESET);
                        finVague();
                        vague++;
                        messageGagnant();
                    }
                    recommencer(personnage, saveVie, null, null, dragon);
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
        System.out.print("Quelle action souhaitez vous faire ? Veuillez entrer le numéro de l'action souhaitée : ");
        String choixPris = sc.nextLine();

        //Convert du choix de l'utilisateur passage de String à int
        return obtenirChoixActionInt(sc, choix, choixPris);


    }

    private void choixRamasserArme(Scanner sc, Personnage personnage, String arme){
        String choix = new String();
        while (!choix.equals("O")) {
            System.out.print("Voulez-vous ramasser l'arme ? (O:oui, N:non) : ");
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
                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Saisie invalide !" + ConsoleColors.RESET);
                System.out.print("Veuillez faire votre choix entre les " + choix.length + " possibilités : ");
                choixPris = sc.nextLine();
            }
        }
        return choixActionInt;
    }

    private void debutVague(){
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println("****************************************************************************");
        System.out.println("La vague " + vague + " commence ! ");
        System.out.println("****************************************************************************");
        System.out.println(ConsoleColors.RESET);
    }
    private  void finVague(){
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT);
        System.out.println("****************************************************************************");
        System.out.println("La vague " + vague + " est terminé ! ");
        System.out.println("****************************************************************************");
        System.out.println(ConsoleColors.RESET);
    }

    private void messageGagnant(){
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Vous avez gagné !! ");
        System.out.println("   ____  ____ \n" +
                "  / ___|/ ___|\n" +
                " | |  _| |  _ \n" +
                " | |_| | |_| |\n" +
                "  \\____|\\____|\n" +
                "              " + ConsoleColors.RESET);

    }

    private void messagePerdant(){
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT +"Dommage vous avez perdu !! ");
        System.out.println(" _           _   \n" +
                "| |         | |  \n" +
                "| | ___  ___| |_ \n" +
                "| |/ _ \\/ __| __|\n" +
                "| | (_) \\__ \\ |_ \n" +
                "|_|\\___/|___/\\__|" + ConsoleColors.RESET);

    }

    private int choixrecommencerPartie(Scanner sc){
        String[] choix = new String[]{
                "Recommencer",
                "Je ne souhaite plus jouer",
        };

        System.out.println();
        System.out.println("Faites votre choix : ");
        for (int i=0; i < choix.length; i++){
            System.out.println(i+1 + "-" + choix[i]);
        }
        String choixPris = sc.nextLine();

        return obtenirChoixRecommencerInt(sc, choix, choixPris);
    }

    private static int obtenirChoixRecommencerInt(Scanner sc, String[] choix, String choixPris) {
        int choixRecommencerInt;
        while(true) {
            try {
                choixRecommencerInt = Integer.parseInt(choixPris);
                break;
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Saisie invalide !" + ConsoleColors.RESET);
                System.out.print("Veuillez faire votre choix entre les " + choix.length + " pour continuer votre partie : ");
                choixPris = sc.nextLine();
            }
        }
        return choixRecommencerInt;
    }

    public Memento saveViesToMemento(int viePersonnage, int vieMonstre){
        return new Memento(viePersonnage, vieMonstre);
    }

    private void recommencer (Personnage personnage, SaveVie saveVie, Goblin goblin, Orque orque, Dragon dragon){
        Scanner sc = new Scanner(System.in);
        if (personnage.getVie()<=0){
            finVague();
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Vous êtes mort !" + ConsoleColors.RESET);
            messagePerdant();
            if (choixrecommencerPartie(sc) == 1) {
                Memento vies = saveVie.getLast();
                personnage.setVie(vies.getViePersonnage());
                if (goblin != null) {
                    goblin.setVie(vies.getVieMonstre());
                } else if (orque != null) {
                    orque.setVie(vies.getVieMonstre());
                } else if (dragon != null) {
                    dragon.setVie(vies.getVieMonstre());
                }
                tourDeJeu(personnage);
            }

        }

    }
}

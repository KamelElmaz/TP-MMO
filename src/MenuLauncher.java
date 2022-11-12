import java.util.Scanner;

public class MenuLauncher {
    private Personnage joueur;

    public void menuLauncher () {
        //Création du scanner permettant la récupération des saisies de l'utilisateur
        Scanner sc= new Scanner(System.in);

        //Création de la liste des personnages et de la variable contenant le choix de l'utilisateur (au format integer)
        String[] listePersonnage = new String[]{
                "Guerrier",
                "Archer",
                "Mage"
        };
        int choixPersonnageInt;

        //Création de la liste des effets et de la variable contenant le choix de l'utilisateur (au format integer)
        String[] listeEffet = new String[]{
                "Feu",
                "Eau",
                "Vent"
        };
        int choixEffetInt;

        //Log d'accueil, sélection du pseudo, affichage des personnages et sélection utilisateur
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "Bienvenue sur le jeu de MMO !" + ConsoleColors.RESET);

        System.out.print("Veuillez entrer votre pseudo pour la partie : ");
        String pseudo = sc.nextLine();

        System.out.println("Voici la liste des personnages à jouer :");

        for (int i=0; i < listePersonnage.length; i++){
            System.out.println(i+1 + " - " + listePersonnage[i]);
        }

        System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + pseudo + ConsoleColors.RESET + " veuillez faire votre choix entre les " +
                listePersonnage.length + " personnages en entrant numéro de personnage : ");
        String personnage = sc.nextLine();

        //Convert du choix de l'utilisateur passage de String à int
        choixPersonnageInt = obtenirChoixPersonnageInt(sc, listePersonnage, personnage);

        //Boucle pour vérifier que l'utilisateur à saisie une valeur correcte
        while (choixPersonnageInt < 1 || choixPersonnageInt > listePersonnage.length){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Saisie invalide !" + ConsoleColors.RESET);
            System.out.print("Veuillez faire votre choix entre les " + listePersonnage.length + " personnages en entrant numéro de personnage : ");
            personnage = sc.nextLine();

             choixPersonnageInt = obtenirChoixPersonnageInt(sc, listePersonnage, personnage);
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + pseudo + ConsoleColors.RESET +" a choisi le personnage : " + ConsoleColors.BLUE_BOLD_BRIGHT + listePersonnage[choixPersonnageInt-1] + ConsoleColors.RESET);

        //Affichage des effets à appliquer sur le personnage et sélection effet
        System.out.println("Voici la liste des effets à appliquer à votre personnage :");
        for (int i=0; i < listeEffet.length; i++){
            System.out.println(i+1 + " - " + listeEffet[i]);
        }

        System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + pseudo + ConsoleColors.RESET +" veuillez faire votre choix entre les " + listeEffet.length + " effets à appliquer à votre personnage : ");
        String effet = sc.nextLine();

        //Convert du choix de l'utilisateur passage de String à int
        choixEffetInt = obtenirChoixEffetInt(sc, listeEffet, effet);

        //Boucle pour vérifier que l'utilisateur à saisie une valeur correcte
        while (choixEffetInt < 1 || choixEffetInt > listeEffet.length){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Saisie invalide !" + ConsoleColors.RESET);
            System.out.print("Veuillez faire votre choix entre les " + listeEffet.length + " effets à appliquer à votre personnage : ");
            effet = sc.nextLine();

             choixEffetInt = obtenirChoixEffetInt(sc, listeEffet, effet);
        }

        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + pseudo + ConsoleColors.RESET +" a choisi l'effet : " + ConsoleColors.BLUE_BOLD_BRIGHT + listeEffet[choixEffetInt-1] + ConsoleColors.RESET);

        //Création personnage
        creation(listePersonnage[choixPersonnageInt-1],listeEffet[choixEffetInt-1]);

        //Demande pour jouer
        String commencerPartie = new String();
        while (!commencerPartie.equals("O")) {
            System.out.print("Souhaitez-vous commencer à jouer ? (O=oui, N=non) : ");
            commencerPartie = sc.nextLine();
            if (commencerPartie.equals("o")){
                commencerPartie="O";}
        }


        //Début jeux
        Jeux jeux = new Jeux();
        jeux.tourDeJeu(joueur);

    }

    private static int obtenirChoixEffetInt(Scanner sc, String[] listeEffet, String effet) {
        int choixEffetInt;
        while(true) {
            try {
                choixEffetInt = Integer.parseInt(effet);
                break;
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Saisie invalide !" + ConsoleColors.RESET);
                System.out.print("Veuillez faire votre choix entre les " + listeEffet.length + " effets à appliquer à votre personnage : ");
                effet = sc.nextLine();
            }
        }
        return choixEffetInt;
    }

    private static int obtenirChoixPersonnageInt(Scanner sc, String[] listePersonnage, String personnage) {
        int choixPersonnageInt;
        while(true) {
            try {
                choixPersonnageInt = Integer.parseInt(personnage);
                break;
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Saisie invalide !" + ConsoleColors.RESET);
                System.out.print("Veuillez faire votre choix entre les " + listePersonnage.length + " personnages en entrant numéro de personnage : ");
                personnage = sc.nextLine();
            }
        }
        return choixPersonnageInt;
    }
    public void creation(String typePersonnage, String effet) {
        PersonnageBuilder personnageBuilder = new PersonnageBuilder();

        switch (typePersonnage){
            case "Guerrier":
                switch (effet) {
                    case "Feu" :
                        joueur = personnageBuilder.guerrierFeu();
                        break;
                    case "Eau" :
                        joueur = personnageBuilder.guerrierEau();
                        break;
                    case "Vent" :
                        joueur = personnageBuilder.guerrierVent();
                        break;
                }
                break;
            case "Archer":
                switch (effet) {
                    case "Feu" :
                        joueur = personnageBuilder.archerFeu();
                        break;
                    case "Eau" :
                        joueur = personnageBuilder.archerEau();
                        break;
                    case "Vent" :
                        joueur = personnageBuilder.archerVent();
                        break;
                }
                break;
            case "Mage":
                switch (effet) {
                    case "Feu" :
                        joueur = personnageBuilder.mageFeu();
                        break;
                    case "Eau" :
                        joueur = personnageBuilder.mageEau();
                        break;
                    case "Vent" :
                        joueur = personnageBuilder.mageVent();
                        break;
                }
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Personnage inexistant !" + ConsoleColors.RESET);
        }
    }

}

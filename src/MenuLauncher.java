import java.util.Scanner;

public class MenuLauncher {
    public static void main(String[] args) {
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

        //Log d'accueil, sélection du pseudo, affichage des personnages et séléction utilisateur
        System.out.println("Bienvenue sur le jeu de MMO !");

        System.out.print("Veuillez entrer votre pseudo pour la partie : ");
        String pseudo = sc.nextLine();

        System.out.println("Voici la liste des personnages à jouer :");

        for (int i=0; i < listePersonnage.length; i++){
            System.out.println(i+1 + " - " + listePersonnage[i]);
        }

        System.out.print(pseudo + " veuillez faire votre choix entre les " + listePersonnage.length + " personnages en entrant numéro de personnage : ");
        String personnage = sc.nextLine();

        //Convert du choix de l'utilisateur passage de String à int
        while(true) {
            try {
                choixPersonnageInt = Integer.parseInt(personnage);
                break;
            } catch (Exception e) {
                System.out.println("Saisie invalide !");
                System.out.print("Veuillez faire votre choix entre les " + listePersonnage.length + " personnages en entrant numéro de personnage : ");
                personnage = sc.nextLine();
            }
        }

        //Boucle pour vérifier que l'utilisateur à saisie une valeur correcte
        while (choixPersonnageInt < 1 || choixPersonnageInt > listePersonnage.length){
            System.out.println("Saisie invalide !");
            System.out.print("Veuillez faire votre choix entre les " + listePersonnage.length + " personnages en entrant numéro de personnage : ");
            personnage = sc.nextLine();

            while(true) {
                try {
                    choixPersonnageInt = Integer.parseInt(personnage);
                    break;
                } catch (Exception e) {
                    System.out.println("Saisie invalide !");
                    System.out.print("Veuillez faire votre choix entre les " + listePersonnage.length + " personnages en entrant numéro de personnage : ");
                    personnage = sc.nextLine();
                }
            }
        }

        System.out.println(pseudo+" a choisi le personnage : " + listePersonnage[choixPersonnageInt-1]);

        //Affichage des effets à appliquer sur le personnage et séléction effet
        System.out.println("Voici la liste des effets à appliquer à votre personnage :");
        for (int i=0; i < listeEffet.length; i++){
            System.out.println(i+1 + " - " + listeEffet[i]);
        }

        System.out.print(pseudo+" veuillez faire votre choix entre les " + listeEffet.length + " effets à appliquer à votre personnage : ");
        String effet = sc.nextLine();

        //Convert du choix de l'utilisateur passage de String à int
        while(true) {
            try {
                choixEffetInt = Integer.parseInt(effet);
                break;
            } catch (Exception e) {
                System.out.println("Saisie invalide !");
                System.out.print("Veuillez faire votre choix entre les " + listeEffet.length + " effets à appliquer à votre personnage : ");
                effet = sc.nextLine();
            }
        }

        //Boucle pour vérifier que l'utilisateur à saisie une valeur correcte
        while (choixEffetInt < 1 || choixEffetInt > listeEffet.length){
            System.out.println("Saisie invalide !");
            System.out.print("Veuillez faire votre choix entre les " + listeEffet.length + " effets à appliquer à votre personnage : ");
            effet = sc.nextLine();

            while(true) {
                try {
                    choixEffetInt = Integer.parseInt(effet);
                    break;
                } catch (Exception e) {
                    System.out.println("Saisie invalide !");
                    System.out.print("Veuillez faire votre choix entre les " + listeEffet.length + " effets à appliquer à votre personnage : ");
                    effet = sc.nextLine();
                }
            }
        }

        System.out.println(pseudo+" a choisi l'effet : " + listeEffet[choixEffetInt-1]);

        Launcher launcher = new Launcher(listePersonnage[choixPersonnageInt-1],listeEffet[choixEffetInt-1]);

        System.out.println(launcher);
    }
}

public class Launcher {
    public static void main(String[] args) {

        /*
        Exemple création personnage pour tester
         */
        PersonnageBuilder personnageBuilder = new PersonnageBuilder();

        Personnage personnage = personnageBuilder.guerrierFeu();
        System.out.println(personnage.getClasse().attributClasse());
        System.out.println(personnage.getArme());
        System.out.println(personnage.getVie());
        System.out.println(personnage.getForce());

        Jeux jeux = new Jeux();
        jeux.tourDeJeu(personnage);

        /*
        Exemple changement Etat Dragon
         */
        /*
        Dragon dragon = new Dragon();
        System.out.println(dragon.getVie()+" "+ dragon.getForce());
        dragon.setVie(2);
        dragon.miseAJourEtat();
        System.out.println(dragon.getForce());

         */

    }
}

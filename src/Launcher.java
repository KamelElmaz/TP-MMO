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

    }
}

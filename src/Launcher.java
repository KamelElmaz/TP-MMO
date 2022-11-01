public class Launcher {
    private Personnage personnage;

    public Launcher(String typePersonnage, String effet) {
        PersonnageBuilder personnageBuilder = new PersonnageBuilder();

        switch (typePersonnage){
            case "Guerrier":
                if (effet.equals("Feu")){
                    personnage = personnageBuilder.guerrierFeu();
                } else if (effet.equals("Eau")){
                    personnage = personnageBuilder.guerrierEau();
                } else if (effet.equals("Vent")){
                    personnage = personnageBuilder.guerrierVent();
                }
                break;
            case "Archer":
                if (effet.equals("Feu")){
                    personnage = personnageBuilder.archerFeu();
                } else if (effet.equals("Eau")){
                    personnage = personnageBuilder.archerEau();
                } else if (effet.equals("Vent")){
                    personnage = personnageBuilder.archerVent();
                }
                break;
            case "Mage":
                if (effet.equals("Feu")){
                    personnage = personnageBuilder.mageFeu();
                } else if (effet.equals("Eau")){
                    personnage = personnageBuilder.mageEau();
                } else if (effet.equals("Vent")){
                    personnage = personnageBuilder.mageVent();
                }
                break;
            default:
                System.out.println("Personnage inexistant !");
        }
    }

    public Personnage getPersonnage() {
        return personnage;
    }

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

        /*
        Exemple changement Etat Dragon
         */

        Dragon dragon = new Dragon();
        System.out.println(dragon.getVie()+" "+ dragon.getForce());
        dragon.setVie(2);
        dragon.miseAJourEtat();
        System.out.println(dragon.getForce());

    }
}

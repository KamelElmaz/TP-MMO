import com.sun.org.apache.xpath.internal.operations.Or;

public class Personnage {
    private int vie;
    private int force;

    private Classe classe;

    private Arme arme;

    public Classe getClasse(){
        return classe;
    }

    public Arme getArme(){
        return arme;
    }


    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    /*
    Création du personnage en fonction du type et de la classe renvoyer par le builder
     */
    public void creerClasse(String nomClasse, String element){
        ClasseFactory classeFactory = new ClasseFactory();// On utilise la Factory pour créer la classe du personnage
        Context context = new Context(null);// On utilise la stratégie pour attribuer la première arme au personnage
        /*
        On utilise le décorateur pour attribuer un élément au personnage
         */
        switch (element){
            case "Feu":
                classe = new PersonnageFeuDecorateur(classeFactory.getClasse(nomClasse));
                break;
            case "Eau":
                classe = new PersonnageEauDecorateur(classeFactory.getClasse(nomClasse));
                break;
            case "Vent":
                classe = new PersonnageVentDecorateur(classeFactory.getClasse(nomClasse));
                break;
        }

        /*
        Attribution de l'arme, de la force et de la vie en fonction du type du personnage
         */
        switch (nomClasse){
            case "Guerrier":
                context = new Context(new AttributEpee());
                force = 10;
                vie = 100;
                break;
            case "Mage":
                context = new Context(new AttributBaton());
                force = 10;
                vie = 100;
                break;
            case "Archer":
                context = new Context(new AttributArc());
                force = 10;
                vie = 100;
                break;

        }

        arme= context.executeStrategie();
        miseAJourForce();

    }

    public void miseAJourArme(String armeRamasser){
        Context context = new Context(null);

        if (armeRamasser.equals("grand arc")){
            context = new Context(new AttributGrandArc());
        }

        if ((armeRamasser.equals("grand baton"))){
            context = new Context(new AttributGrandBaton());
        }

        if (armeRamasser.equals("épée longue")){
            context = new Context(new AttributEpeeLongue());
        }

        arme = context.executeStrategie();
        miseAJourForce();


    }

    private void miseAJourForce(){
        force=force+ arme.getForce();
    }

}

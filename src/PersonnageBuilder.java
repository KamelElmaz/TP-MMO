public class PersonnageBuilder {
    /*
    Création personnage par rapport au type et à l'élément
     */
    public Personnage guerrierFeu (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Guerrier", "Feu");
        return personnage;
    }
    public Personnage guerrierEau (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Guerrier", "Eau");
        return personnage;
    }
    public Personnage guerrierVent (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Guerrier", "Vent");
        return personnage;
    }
    public Personnage mageFeu (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Mage", "Feu");
        return personnage;
    }
    public Personnage mageEau (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Mage", "Eau");
        return personnage;
    }
    public Personnage mageVent (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Mage", "Vent");
        return personnage;
    }
    public Personnage archerFeu (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Archer", "Feu");
        return personnage;
    }
    public Personnage archerEau (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Archer", "Eau");
        return personnage;
    }
    public Personnage archerVent (){
        Personnage personnage = new Personnage();
        personnage.creerClasse("Archer", "Vent");
        return personnage;
    }
}

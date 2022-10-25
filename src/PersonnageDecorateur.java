public abstract class PersonnageDecorateur implements Classe{
    protected Classe classeDecorateur;

    public PersonnageDecorateur(Classe classeDecorateur){
        this.classeDecorateur=classeDecorateur;
    }

    public String attributClasse() {
        return classeDecorateur.attributClasse();
    }
}

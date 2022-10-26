public class PersonnageFeuDecorateur extends PersonnageDecorateur{
    public PersonnageFeuDecorateur (Classe classeDecorateur){
        super(classeDecorateur);
    }

    @Override
    public String attributClasse(){

        return  classeDecorateur.attributClasse()+"|"+personnageFeu(classeDecorateur);

    }
    private String personnageFeu(Classe classeDecorateur){
        return "Feu";
    }
}

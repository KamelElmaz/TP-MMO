public class PersonnageEauDecorateur extends PersonnageDecorateur{
    public PersonnageEauDecorateur (Classe classeDecorateur){
        super(classeDecorateur);
    }

    @Override
    public String attributClasse(){

        return  classeDecorateur.attributClasse()+"|"+personnageEau(classeDecorateur);

    }
    private String personnageEau(Classe classeDecorateur){
        return "Eau";
    }
}

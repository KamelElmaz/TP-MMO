public class PersonnageVentDecorateur extends PersonnageDecorateur{
    public PersonnageVentDecorateur (Classe classeDecorateur){
        super(classeDecorateur);
    }

    @Override
    public String attributClasse(){

        return  classeDecorateur.attributClasse()+"|"+personnageVent(classeDecorateur);

    }
    private String personnageVent(Classe classeDecorateur){
        return "Vent";
    }
}

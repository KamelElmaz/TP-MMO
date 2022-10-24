public class ClasseFactory {
    public Classe getClasse(String ClasseType){
        if(ClasseType == null){
            return  null;
        }
        if(ClasseType.equals("Guerrier")){
            return new Guerrier();
        }
        if(ClasseType.equals("Archer")){
            return new Archer();
        }
        if(ClasseType.equals("Mage")){
            return new Mage();
        }
        return null;
    }
}

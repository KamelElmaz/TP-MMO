public class EtatVieFaible implements Etat{
    @Override
    public void faireAction(ContextEtat contextEtat) {
        contextEtat.setEtat(this);
    }

    public int force (){
        return 2;
    }
}

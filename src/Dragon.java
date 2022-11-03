public class Dragon {
    private int vie;
    private int force;
    private String faiblesse;

    ContextEtat contextEtat = new ContextEtat();

    public Dragon(int vie){
        this.vie = vie;
        EtatVieNormal etatVieNormal = new EtatVieNormal();
        etatVieNormal.faireAction(contextEtat);
        this.force= etatVieNormal.force();
    }


    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public String getFaiblesse() {
        return faiblesse;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void miseAJourEtat(){
        if (vie < 2.5){
            EtatVieFaible etatVieFaible = new EtatVieFaible();
            etatVieFaible.faireAction(contextEtat);
            force = etatVieFaible.force();
        }
    }
}

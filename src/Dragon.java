public class Dragon {

    private int vie;
    private int force;
    private String faiblesse;
    private int vieDeBase;

    ContextEtat contextEtat = new ContextEtat();

    public Dragon(int vie){
        this.vie = vie;
        EtatVieNormal etatVieNormal = new EtatVieNormal();
        etatVieNormal.faireAction(contextEtat);
        this.force= etatVieNormal.force();
        this.vieDeBase = vie;

        //Donne faiblesse aléatoire
        Faiblesse choixFaiblesse = new Faiblesse();
        this.faiblesse = choixFaiblesse.donneFaiblesse();
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
        if (vie <= (vieDeBase/2)){
            EtatVieFaible etatVieFaible = new EtatVieFaible();
            etatVieFaible.faireAction(contextEtat);
            force = etatVieFaible.force();
            System.out.println("Le dragon se met en rage sa force devient " + force);
        } else{
            EtatVieNormal etatVieNormal = new EtatVieNormal();
            etatVieNormal.faireAction(contextEtat);
            force = etatVieNormal.force();
        }
    }
}

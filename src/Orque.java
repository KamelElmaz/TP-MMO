public class Orque {
    private int vie;
    private int force;
    private String faiblesse;

    public Orque(int vie, int force){
        this.vie=vie;
        this.force=force;

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
}

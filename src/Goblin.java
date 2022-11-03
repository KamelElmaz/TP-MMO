public class Goblin {

    private int vie;
    private int force;
    private String faiblesse;

    public Goblin(int vie, int force){
        this.vie=vie;
        this.force=force;
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

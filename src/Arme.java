public class Arme {
    private String nom;
    private int force;

    public Arme (String nom, int force){
        this.nom = nom;
        this.force = force;
    }


    public int getForce() {
        return force;
    }

    public String getNom() {
        return nom;
    }
}

public class Memento {
    private int viePersonnage;
    private int vieMonstre;

    public Memento(int viePersonnage, int vieMonstre) {
        this.viePersonnage = viePersonnage;
        this.vieMonstre = vieMonstre;
    }

    public int getViePersonnage() {
        return viePersonnage;
    }

    public int getVieMonstre() {
        return vieMonstre;
    }
}

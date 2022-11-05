public class Context {
    private StrategieArme strategieArme;

    public Context (StrategieArme strategieArme){
        this.strategieArme=strategieArme;
    }

    public Arme executeStrategie(){
        return strategieArme.donneArme();
    }
}

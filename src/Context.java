public class Context {
    private StrategieArme strategieArme;

    public Context (StrategieArme strategieArme){
        this.strategieArme=strategieArme;
    }

    public String executeStrategie(){
        return strategieArme.donneArme();
    }
}

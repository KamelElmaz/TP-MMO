public class AttributGrandBaton implements StrategieArme{
    @Override
    public Arme donneArme(){
        Arme grandBaton = new Arme("grand baton", 10);
        return grandBaton;}
}

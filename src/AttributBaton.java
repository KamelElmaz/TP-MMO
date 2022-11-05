public class AttributBaton implements StrategieArme{
    @Override
    public Arme donneArme() {
        Arme baton = new Arme("baton", 3);
        return baton;
    }
}

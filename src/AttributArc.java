public class AttributArc implements StrategieArme{
    @Override
    public Arme donneArme() {
        Arme arc = new Arme("arc", 2);
        return arc;
    }
}

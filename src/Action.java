public class Action {

    public void attaquer(Goblin goblin, Orque orque, Dragon dragon, Personnage personnage){

        String classe = personnage.getClasse().attributClasse();
        String[] parse = classe.split("\\|");
        String faiblesse = parse[1];

        /*
        on attaque le monstre entrer en paramettre et on multiplie par 2 l'attaque si on a la bonne faiblesse
         */
        if (goblin != null){
            if (faiblesse.equals(goblin.getFaiblesse())){
                goblin.setVie(goblin.getVie()-(personnage.getForce()*2));
            }
            else {
                goblin.setVie(goblin.getVie()- personnage.getForce());
            }
        } else if (orque != null) {
            if (faiblesse.equals(orque.getFaiblesse())){
                orque.setVie(orque.getVie()-(personnage.getForce()*2));
            }
            else{
                orque.setVie(orque.getVie()- personnage.getForce());
            }
        } else if (dragon != null) {
            if (faiblesse.equals(dragon.getFaiblesse())){
                dragon.setVie(dragon.getVie()-(personnage.getForce()*2));
            }
            else {
                dragon.setVie(dragon.getVie()- personnage.getForce());
            }

        }
    }

    public void ramasserArme(Personnage personnage, String arme){
        personnage.miseAJourArme(arme);
    }

}

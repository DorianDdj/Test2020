//Les musiciens sont crés en fonction de leur type d'instrumenet : utilisation du design pattern Factory
public class MusicianFactory {
    //Methode statique, accessible sans instanciation de la classe, pour la création des musiciens
    static Musician createMusician(String name, String instrument) {
        switch(instrument) {
            case "Piano":
                return new PianoMusician(name, instrument);
            case "Violin":
                return new ViolinMusician(name, instrument);
            case "Trumpet":
                return new TrumpetMusician(name, instrument);
            default:
                break;
        }
        //Si le type n'est pas reconnu, on retourne null
        return null;
    }
}

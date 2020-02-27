public class MusicianFactory {
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
        return null;
    }
}

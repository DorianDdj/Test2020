
public class Partition {
    String m_name;

    //Utilisation d'un enum pour limiter les parametres admis
    //Remarque : ce n'est pas la seule possibilite d'implementation!
    enum Tone {
        A,B,C,D,E,F,G
    }
    Tone m_tone;

    //Constructeur
    public Partition(String name, Tone tone) {
        m_name = name;
        m_tone = tone;
    }

    public String getName() {
        return m_name;
    }
}

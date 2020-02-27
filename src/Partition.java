public class Partition {
    String m_name;
    enum Tone {
        A,B,C,D,E,F,G
    }
    Tone m_tone;

    public Partition(String name, Tone tone) {
        m_name = name;
        m_tone = tone;
    }

    public String getName() {
        return m_name;
    }
}

import java.util.ArrayList;

public class Server {

    ArrayList<Musician> m_listMusicians;
    ArrayList<Partition> m_listPartitions;

    private static Server m_instance = new Server();

    private Server () {
        m_listMusicians = new ArrayList<>();
        m_listPartitions = new ArrayList<>();
    }

    public static Server getInstance() {
        return m_instance;
    }

    public void clean() {
        m_listMusicians.clear();
        m_listPartitions.clear();
    }

    public void addPartition(Partition partition) {
        if (partition != null) {
            m_listPartitions.add(partition);
            for (Musician m : m_listMusicians) {
                m.addPartition(partition);
            }
        }
    }

    public void addMusician(Musician musician) {
        if (musician != null) {
            m_listMusicians.add(musician);
        }
    }

    public void removeMusician(Musician musician) {
        if (musician != null) {
            m_listMusicians.remove(musician);
        }
    }

    public int getNbMusician() {
        return m_listMusicians.size();
    }

    public int getNbPartitions() {
        return m_listPartitions.size();
    }

    public static void main(String[] args) {
        Musician mp = MusicianFactory.createMusician("Pianiste", "Piano");
        Musician mv = MusicianFactory.createMusician("Violioniste", "Violin");
        Musician mt = MusicianFactory.createMusician("Trompettiste", "Trumpet");
        Musician merror = MusicianFactory.createMusician("Unknown", "AnotherOne");
        Server.getInstance().addMusician(mp);
        Server.getInstance().addMusician(mv);
        Server.getInstance().addMusician(mt);
        Server.getInstance().addMusician(merror);

        Partition p1 = new Partition("p1", Partition.Tone.A);
        Partition p2 = new Partition("p2", Partition.Tone.E);
        Server.getInstance().addPartition(p1);
        Server.getInstance().addPartition(p2);
    }
}

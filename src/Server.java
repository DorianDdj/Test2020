import java.util.ArrayList;

public class Server {

    ArrayList<Musician> m_listMusicians;
    ArrayList<Partition> m_listPartitions;

    private static Server m_instance;

    public static Server getInstance() {
        return m_instance;
    }

    public void addPartition(Partition partition) {
        m_listPartitions.add(partition);
        for (Musician m : m_listMusicians) {
            m.addPartition(partition);
        }
    }

    public void addMusician(Musician musician) {
        m_listMusicians.add(musician);
    }

    public void removeMusician(Musician musician) {
        m_listMusicians.remove(musician);
    }

    public int getNbMusician() {
        return m_listMusicians.size();
    }

    public int getNbPartitions() {
        return m_listPartitions.size();
    }

    public static void main(String[] args) {

    }
}

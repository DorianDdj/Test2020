import java.util.ArrayList;

public class Musician {
    String m_name;
    String m_instrument;
    ArrayList<Partition> m_listPartitions;

    public Musician(String name, String instrument) {
        m_name = name;
        m_instrument = instrument;
    }

    public void addPartition(Partition partition) {
        m_listPartitions.add(partition);
    }
}

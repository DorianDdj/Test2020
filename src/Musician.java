import java.util.ArrayList;

//Classe mere Musician
public class Musician {
    String m_name;
    String m_instrument;
    ArrayList<Partition> m_listPartitions;

    public Musician(String name, String instrument) {
        m_name = name;
        m_instrument = instrument;
        m_listPartitions = new ArrayList<>();
    }

    //Enregistrement d'une nouvelle partition
    public void addPartition(Partition partition) {
        m_listPartitions.add(partition);
        //Ajout d'une trace pour la validation
        System.out.println("Add partition '" + partition.getName() + "' to '" + m_name + "'");
    }

    public int getNbPartitions() {
        return m_listPartitions.size();
    }
}

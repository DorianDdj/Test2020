import java.util.ArrayList;

/*
Le serveur doit etre unique -> utilisation du design pattern "Singleton"
Il permet de
    - ajouter un musicien
    - enlever un musicien
    - ajouter une partition
    - enlever une partition
Il enregistre la liste de musiciens et de partitions
 */
public class Server {

    //Declaration des listes
    ArrayList<Musician> m_listMusicians;
    ArrayList<Partition> m_listPartitions;

    //Declaration de l'instance du singleton
    private static Server m_instance = null;

    //Constructeur privé
    private Server () {
        m_listMusicians = new ArrayList<>();
        m_listPartitions = new ArrayList<>();
    }

    //Methode statique d'acces au serveur unique
    public static Server getInstance() {
        if (m_instance == null) {
            m_instance = new Server();
        }
        return m_instance;
    }

    //Remise a zero des listes (utilisé dans les tests)
    public void clean() {
        m_listMusicians.clear();
        m_listPartitions.clear();
    }

    //Ajout d'une partition
    public void addPartition(Partition partition) {
        if (partition != null) {
            m_listPartitions.add(partition);
            //Notification de l'ensemble des musiciens (design pattern Observer)
            for (Musician m : m_listMusicians) {
                m.addPartition(partition);
            }
        }
    }

    //Ajout et enregistrement d'un musicien
    public void addMusician(Musician musician) {
        if (musician != null) {
            m_listMusicians.add(musician);
        }
    }

    //Suppression d'un musicien
    public void removeMusician(Musician musician) {
        if (musician != null) {
            m_listMusicians.remove(musician);
        }
    }

    //Lecture du nombre de musiciens enregistrés
    public int getNbMusician() {
        return m_listMusicians.size();
    }

    //Lecture du nombre de partitions enregistrées
    public int getNbPartitions() {
        return m_listPartitions.size();
    }

    //main du programme
    public static void main(String[] args) {
        //Creation de musiciens
        Musician mp = MusicianFactory.createMusician("Pianiste", "Piano");
        Musician mv = MusicianFactory.createMusician("Violioniste", "Violin");
        Musician mt = MusicianFactory.createMusician("Trompettiste", "Trumpet");
        //Test de création d'un musicien avec un instrument inexistant
        Musician merror = MusicianFactory.createMusician("Unknown", "AnotherOne");

        //Enregistrement des musiciens
        Server.getInstance().addMusician(mp);
        Server.getInstance().addMusician(mv);
        Server.getInstance().addMusician(mt);
        Server.getInstance().addMusician(merror);

        //Creation des partitions
        Partition p1 = new Partition("p1", Partition.Tone.A);
        Partition p2 = new Partition("p2", Partition.Tone.E);

        //Ajout des musiciens
        Server.getInstance().addPartition(p1);
        Server.getInstance().addPartition(p2);
    }
}

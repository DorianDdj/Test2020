import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

//Classe de test de la factory
class MusicianFactoryTest {

    //Reinitialisation avec chaque test
    @BeforeEach
    void setUp() {
        Server.getInstance().clean();
    }

    //Test de creation d'un musicien avec un instrument connu
    @org.junit.jupiter.api.Test
    void createKnownMusician() {
        Musician piano = MusicianFactory.createMusician("Test", "Piano");
        assertNotNull(piano);
    }

    //Test de creation d'un musicien avec un instrument inconnu
    @org.junit.jupiter.api.Test
    void createUnknownMusician() {
        Musician piano = MusicianFactory.createMusician("Test", "Unknown");
        assertNull(piano);
    }

    //Test d'ajout d'un musicien
    @org.junit.jupiter.api.Test
    void addMusician() {
        //Creation du musicien et validation
        Musician piano = MusicianFactory.createMusician("Test", "Piano");
        assertEquals(Server.getInstance().getNbMusician(), 0);
        //Ajout du musicien et validation
        Server.getInstance().addMusician(piano);
        assertEquals(Server.getInstance().getNbMusician(), 1);
    }

    //Test de suppression d'un musicien
    @org.junit.jupiter.api.Test
    void removeMusician() {
        //Creation d'un musicien et validation
        Musician piano = MusicianFactory.createMusician("Test", "Piano");
        assertEquals(Server.getInstance().getNbMusician(), 0);
        //Ajout du musicien et validation
        Server.getInstance().addMusician(piano);
        assertEquals(Server.getInstance().getNbMusician(), 1);
        //Suppression du musicien et validation
        Server.getInstance().removeMusician(piano);
        assertEquals(Server.getInstance().getNbMusician(), 0);
    }

    //Test d'ajout d'une partition
    @org.junit.jupiter.api.Test
    void addScore() {
        Musician piano = MusicianFactory.createMusician("Test", "Piano");
        Server.getInstance().addMusician(piano);
        assertEquals(Server.getInstance().getNbPartitions(), 0);
        assertEquals(piano.getNbPartitions(), 0);
        Partition p1 = new Partition("name", Partition.Tone.A);
        Server.getInstance().addPartition(p1);
        assertEquals(Server.getInstance().getNbPartitions(), 1);
        assertEquals(piano.getNbPartitions(), 1);
    }
}
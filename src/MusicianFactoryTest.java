import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class MusicianFactoryTest {

    @BeforeEach
    void setUp() {
        Server.getInstance().clean();
    }

    @org.junit.jupiter.api.Test
    void createKnownMusician() {
        Musician piano = MusicianFactory.createMusician("Test", "Piano");
        assertNotNull(piano);
    }

    @org.junit.jupiter.api.Test
    void createUnknownMusician() {
        Musician piano = MusicianFactory.createMusician("Test", "Unknown");
        assertNull(piano);
    }

    @org.junit.jupiter.api.Test
    void addMusician() {
        Musician piano = MusicianFactory.createMusician("Test", "Piano");
        assertEquals(Server.getInstance().getNbMusician(), 0);
        Server.getInstance().addMusician(piano);
        assertEquals(Server.getInstance().getNbMusician(), 1);
    }

    @org.junit.jupiter.api.Test
    void removeMusician() {
        Musician piano = MusicianFactory.createMusician("Test", "Piano");
        assertEquals(Server.getInstance().getNbMusician(), 0);
        Server.getInstance().addMusician(piano);
        assertEquals(Server.getInstance().getNbMusician(), 1);
        Server.getInstance().removeMusician(piano);
        assertEquals(Server.getInstance().getNbMusician(), 0);
    }

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
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTest {

    public Hash<Faculty> table = Hash.getInstance();
    @Test public void getNumElements() {

        assertEquals(0, table.getNumElements());
        Faculty faculty = new Faculty("Uriel", "Garcia", "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        assertEquals(0, table.getNumElements());
    }

    @Test public void search() {
        Faculty faculty = new Faculty("Uriel", "Garcia", "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");
        assertFalse(!table.search(faculty));
    }

    @Test public void insert() {
        Faculty faculty = new Faculty("Uriel", "Garcia", "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        table.insert(faculty);

        assertEquals(true, table.search(faculty));
    }

}
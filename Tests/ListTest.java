import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {

    List<Faculty> list = new List<>();

    @Test public void getFirst() {
        Faculty faculty = new Faculty("Uriel", "Garcia", "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        list.addLast(faculty);

        assertEquals(faculty, list.getFirst());

    }

    @Test public void getLast() {
        Faculty faculty = new Faculty("Uriel", "Garcia", "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        list.addLast(faculty);

        assertEquals(faculty, list.getLast());
    }

    @Test public void getLength() {
        Faculty faculty = new Faculty("Uriel", "Garcia", "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        list.addLast(faculty);

        assertEquals(1, list.getLength());
    }
}
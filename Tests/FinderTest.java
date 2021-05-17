import org.junit.Test;

import static org.junit.Assert.*;

public class FinderTest {

    Finder find = new Finder("Uriel", "Garcia", "Political Science");

    @Test public void getFirstName() {

        assertEquals("Uriel", find.getFirstName());
    }

    @Test public void getLastName() {
        assertEquals("Garcia", find.getLastName());
    }

    @Test public void getDepartment() {
        assertEquals("Political Science", find.getDepartment());
    }
}
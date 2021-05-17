import org.junit.Test;

import static org.junit.Assert.*;

/** Model Tests */

public class FacultyTest {

    Faculty faculty = new Faculty("Uriel", "Garcia",
            "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

    @Test public void getFirstName() {
        assertEquals("Uriel", faculty.getFirstName());
    }

    @Test public void getLastName() {
        assertEquals("Garcia", faculty.getLastName());
    }

    @Test public void getEmail() {
        assertEquals("uriel.garcia@sjsu.edu", faculty.getEmail());
    }

    @Test public void getInterest() {
        assertEquals("Front-End Web Developer", faculty.getInterest());
    }

    @Test public void getDepartment() {
        assertEquals("Computer Science", faculty.getDepartment());
    }

    @Test public void setFirstName() {
        Faculty facultyTest = new Faculty("Uriel", "Garcia",
                "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");


        facultyTest.setFirstName("Tester");

        assertEquals("Tester", facultyTest.getFirstName());

    }


    @Test public void setLastName() {
        Faculty facultyTest = new Faculty("Uriel", "Garcia",
                "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        facultyTest.setLastName("Tester");

        assertEquals("Tester", facultyTest.getLastName());
    }


    @Test public void setEmail() {
        Faculty facultyTest = new Faculty("Uriel", "Garcia",
                "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        facultyTest.setEmail("tester@sjsu.edu");

        assertEquals("tester@sjsu.edu", facultyTest.getEmail());
    }

    @Test public void setInterest() {
        Faculty facultyTest = new Faculty("Uriel", "Garcia",
                "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        facultyTest.setInterest("Full Stack Developer");

        assertEquals("Full Stack Developer", facultyTest.getInterest());
    }

    @Test public void setDepartment() {
        Faculty facultyTest = new Faculty("Uriel", "Garcia",
                "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        facultyTest.setDepartment("Political Science");

        assertEquals("Political Science", facultyTest.getDepartment());
    }

    @Test public void testEquals() {

        Faculty faculty1 = new Faculty("Mariia", "Surmenok",
                "mariia.surmenok@sjsu.edu", "Cloud Computing, Big Data, Machine Learning",
                "Computer Science");

        Faculty faculty3 = new Faculty("Uriel", "Garcia",
                "uriel.garcia@sjsu.edu", "Front-End Web Developer", "Computer Science");

        assertEquals(false, faculty.equals(faculty1));

        assertEquals(true, faculty.equals(faculty3));
    }
}
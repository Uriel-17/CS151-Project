/**
 * @author Uriel Garcia
 * Finder.java
 */
public class Finder implements Search {
    private String firstName;
    private String lastName;
    private String department;


    /**
     * Constructor for the Finder class
     * @param firstName the faculties first name
     * @param lastName the faculties last name
     */
    public Finder(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    /* Accessor's */

    /**
     * Accesses the first name of the faculty member
     * @return the faculties first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Accesses the last name of the faculty member
     * @return the faculties last name
     */
    public String getLastName() {
        return this.lastName;
    }


    public String getDepartment() {
        return this.department;
    }

}

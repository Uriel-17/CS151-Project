/**
 * @author Uriel Garcia
 * Faculty.java
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Faculty implements Comparable<Faculty> {
    private static final String file = "Computer_Science.txt";
    public Hash<Faculty> table = Hash.getInstance();

    private String firstName;
    private String lastName;
    private String email;
    private String interest;
    private String department;

    /**
     * Constructor for the Faculty class
     * @param firstName the faculties first name
     * @param lastName the faculties last name
     * @param email the faculties email
     * @param interest what the professors interested professionally
     */
    public Faculty(String firstName, String lastName, String email, String interest, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.interest = interest;
        this.department = department;
    }

    /**
     * Constructor for the Faculty class
     * Assigns default values
     */
    public Faculty() {
        this.firstName = "Default Name";
        this.lastName = "Default last name";
        this.email = "Default email";
        this.interest = "Default Interest";
        this.department = "Default Department";
    }

    /**
     * Constructor for the Faculty class
     * @param firstName the faculties first name
     * @param lastName the faculties last name
     */
    public Faculty(String firstName, String lastName, String department) {
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

    /**
     * Accesses the email of the faculty member
     * @return the faculties email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Accesses the professional interest
     * of the faculty member
     * @return the faculties interest
     */
    public String getInterest() {
        return this.interest;
    }

    /**
     * Accesses the department of the faculty member
     * @return the department the faculty is in
     */
    public String getDepartment() {
        return this.department;
    }

    /* Mutator's*/

    /**
     * Sets the faculties first name
     * @param firstName of the faculty member
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    /**
     * Sets the faculties last name
     * @param lastName of the faculty member
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    /**
     * Sets the faculties email
     * @param email of the faculty member
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the faculties professional interest
     * @param interest of the faculty member
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * Sets the faculties department
     * @param department of the faculty member
     */
    public void setDepartment(String department) {
        this.department = department;
    }


    /**
     * Fills the HashTable with CS faculty data
     * @throws FileNotFoundException if the file does not exist
     */
    public void getData() throws FileNotFoundException {

        File input = new File(file);

        if(input == null) {
            throw new FileNotFoundException("File does not exist");
        }

        String firstName, lastName, email, department, research;

        Scanner scan = new Scanner(input);

        while(scan.hasNextLine()) {

            firstName = scan.nextLine();

            lastName = scan.nextLine();

            email = scan.nextLine();

            research = scan.nextLine();

            department = scan.nextLine();

            Faculty faculty = new Faculty(firstName, lastName, email, research, department);

            table.insert(faculty);
        }
    }


    /**
     * Determines whether two classes objects are
     * equal by comparing first name's
     * if the first names are the same then compare
     * by department
     * @param //object of the second Classes
     * @return whether the Faculty are equal
     */
    @Override public boolean equals(Object o) {

        if(o == this) {

            return true;

        } else if(!(o instanceof Faculty)) {

            return false;

        } else {

            Faculty L = (Faculty) o;

            if(this.getFirstName().equalsIgnoreCase(L.getFirstName()) && this.getLastName().equalsIgnoreCase(L.getLastName())) {

                if(this.getDepartment().equalsIgnoreCase(L.getDepartment())) {

                    return true;
                }
            }
            return false;
        }
    }



    /**
     * Compares two Faculty objects to determine ordering
     * Returns 0 if the two items are equal
     * Return -1 if this Faculty's name comes alphabetically
     * before the other Faculty's name.
     * Returns 1 if the other Faculty's name comes
     * alphabetically before this Faculty's name
     * If the two faculty's names are the same, will
     * differentiate by last's name (alphabetical
     * comparison)
     * @param o the other Faculty object to compare to this
     * @return 0 (same faculty), -1 (this faculty ordered first)
     * or 1 (the other faculty ordered first)
     */
    @Override public int compareTo(Faculty o) {

        if(this.equals(o)) {

            return 0;

        } else if(!(this.getFirstName().equals(o.firstName))) {

            if(getLastName().compareTo(o.getLastName()) < 0) {

                return -1;

            } else {

                return 1;

            }

        } else {

            return getEmail().compareTo(o.getEmail());

        }
    }

    /**
     * Returns a consistent hash code for
     * each Faculty by summing the Unicode values
     * of each character in the key
     * Key = firstName + lastName + department
     * @return the hash code
     */
    @Override public int hashCode() {
        int sum = 0;

        String key = firstName + lastName + department;

        for(int i = 0; i < key.length(); i++) {

            sum += (int) key.charAt(i);
        }

        return sum;
    }

    /**
     * List with each value separated by a space
     * At the end of the List is a new line
     * @return the string with the format First Name Last Name Email Interest Department
     */
    @Override public String toString() {

        String result = "First Name: " + firstName
                + "\nLast Name: " + lastName
                + "\nEmail: " + email
                + "\nInterest: " + interest
                + "\nDepartment: " + department;
        return result;
    }
}


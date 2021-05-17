/**
 * @author Uriel Garcia
 * View.java
 */

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame{
    BlockingQueue<Search> queue;
    JTextField faculty_name;
    JTextField department;
    JButton searchButton;

    JLabel header;
    JLabel facultyName;
    JLabel departmentLabel;

    /**
     * Constructor for View.java class
     * @param queue holds the messages awaiting to be carried out
     */
    public View(BlockingQueue<Search> queue) {

        this.queue = queue;

        //Labels

        this.header = new JLabel("San Jose State Database");
        this.header.setBounds(48, 20, 250, 33);
        this.header.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));

        this.facultyName = new JLabel("Faculty Name:");
        this.facultyName.setBounds(48, 50, 250, 60);
        this.facultyName.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));

        this.departmentLabel = new JLabel("Department:");
        this.departmentLabel.setBounds(48, 120, 250, 60);
        this.departmentLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));


        //Text Fields
        this.faculty_name = new JTextField();
        this.faculty_name.setBounds(48, 95, 180, 26);

        this.department = new JTextField();
        this.department.setBounds(48, 165, 180, 26);

        //Buttons
        this.searchButton = new JButton("Search");
        this.searchButton.setBounds(48, 210, 100, 30);


        //Action Listeners

        this.searchButton.addActionListener(e -> {

            String fullName = faculty_name.getText();
            String dept = department.getText();

            String split[] = fullName.split(" ");

            try {

                Search msg;

                if(split.length > 2) { // Middle name

                     msg = new Finder(split[0], split[2], dept);

                } else {

                     msg = new Finder(split[0], split[1], dept);
                }

                queue.put(msg);

            } catch (Exception x) {
                errorMessage("Error Please Try Again!");
            }


        });


        this.add(header);
        this.add(searchButton);
        this.add(departmentLabel);
        this.add(department);
        this.add(facultyName);
        this.add(faculty_name);
        this.setSize(330, 450);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Opens a new window with the data that has been found
     * @param firstName the first name of the faculty
     * @param lastName the last name of the faculty
     * @param email the email of the the faculty
     * @param interestIn the interest of the faculty in terms of the field of CS
     */
    public void DisplaySearch(String firstName, String lastName, String email, String interestIn) {

        JFrame frame = new JFrame("Faculty");

        //Header
        JLabel header2 = new JLabel("Faculty");
        header2.setBounds(20, 20, 250, 33);
        header2.setFont(new Font("Helvetica Neue", Font.BOLD, 20));

        JLabel nameHeader = new JLabel("Name");
        nameHeader.setBounds(20, 60, 250, 33);
        nameHeader.setFont(new Font("helvetica Neue", Font.PLAIN, 18));

        JLabel emailHeader = new JLabel("Email");
        emailHeader.setBounds(140, 60, 250, 33);
        emailHeader.setFont(new Font("helvetica Neue", Font.PLAIN, 18));

        JLabel interestHeader = new JLabel("Interest");
        interestHeader.setBounds(360, 60, 250, 33);
        interestHeader.setFont(new Font("helvetica Neue", Font.PLAIN, 18));


        //Data
        JLabel name = new JLabel(firstName + " " + lastName);

        name.setBounds(20, 100, 250, 33);
        name.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));

        JLabel emailLabel = new JLabel(email);

        emailLabel.setBounds(140, 100, 250, 33);
        emailLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));

        JLabel interest = new JLabel(interestIn);
        interest.setBounds(360, 100, 500, 33);
        interest.setFont(new Font("helvetica Neue", Font.PLAIN, 15));

        frame.setSize(750, 360);
        frame.add(emailHeader);
        frame.add(interestHeader);
        frame.add(interest);
        frame.add(emailLabel);
        frame.add(header2);
        frame.add(nameHeader);
        frame.add(name);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Opens a new error message window to let the user
     * know that the there was a problem
     * @param message the programmer can pass a unique message that will be
     * displayed in the error window
     */
    public void errorMessage(String message) {
        JFrame frame = new JFrame("Error!");

        JLabel error = new JLabel(message);

        error.setBounds(25, 20, 300, 33);
        error.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        error.setOpaque(true);
        error.setForeground(Color.RED);
        frame.add(error);
        frame.setSize(320, 100);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}



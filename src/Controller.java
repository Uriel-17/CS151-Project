/**
 * @author Uriel Garcia
 * Controller.java
 */

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Search> queue;
    Faculty model;
    View view;


    /**
     *  Constructor for Controller.java class
     *  Initializes the queue, model, view to be set according
     *  to the values passes in as a parameter
     * @param queue the blocking queue
     * @param model Faculty model
     * @param view the GUI class
     */
    public Controller(BlockingQueue<Search> queue, Faculty model, View view) {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }


    /**
     * Mainloop runs the GUI interface
     * it uses the queue, model, and view classes to control the flow
     * of information being typed by the user
     */
    public void mainLoop() {

        while(view.isDisplayable()) {

            Search message = null;

            try {
                message = queue.take();

            } catch(InterruptedException ex) {
                // do something or nothing
            }

            if(message.getClass() == Finder.class) {

                Finder find = (Finder) message;

                Faculty staff = new Faculty(find.getFirstName(), find.getLastName(), find.getDepartment());

                Faculty temp = model.table.getElement(staff);

                if(temp == null) {

                    view.errorMessage("Sorry, Faculty Not Found! :(");

                } else {

                    view.DisplaySearch(temp.getFirstName(), temp.getLastName(), temp.getEmail(), temp.getInterest());
                }
            }
        }
    }
}

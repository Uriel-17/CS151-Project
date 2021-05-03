/**
 * @author Uriel Garcia
 * Controller.java
 */

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Search> queue;
    Faculty model;
    View view;

    public Controller(BlockingQueue<Search> queue, Faculty model, View view) {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }


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
                view.DisplaySearch(find, model);
            }
        }
    }
}

/**
 * @author Uriel Garcia
 * App.java
 */
import java.io.FileNotFoundException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        BlockingDeque<Search> queue = new LinkedBlockingDeque<>();

        Faculty model = new Faculty();

        model.getData(); //Fills Hashtable with data

        View view = new View(queue);

        Controller controller = new Controller(queue, model, view);

        controller.mainLoop();

    }
}

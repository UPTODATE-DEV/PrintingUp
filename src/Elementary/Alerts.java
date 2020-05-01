package Elementary;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  30/01/2019
 */
public class Alerts {

    public static void warning(String title, String content){
        Dialog.createAlert(Dialog.Type.WARNING, title, content);
    }

    @SafeVarargs
    public static void warning(String title, String content, EventHandler<MouseEvent>... confirm){
        Dialog.createAlert(Dialog.Type.WARNING, title, content, confirm);
    }

    public static void error(String title, String content){
        Dialog.createAlert(Dialog.Type.ERROR, title, content);
    }

    @SafeVarargs
    public static void error(String title, String content, EventHandler<MouseEvent>... confirm){
        Dialog.createAlert(Dialog.Type.ERROR, title, content, confirm);
    }

    public static void info(String title, String content){
        Dialog.createAlert(Dialog.Type.INFO, title, content);
    }

    @SafeVarargs
    public static void info(String title, String content, EventHandler<MouseEvent>... confirm){
        Dialog.createAlert(Dialog.Type.INFO, title, content, confirm);
    }

    public static void success(String title, String content){
        Dialog.createAlert(Dialog.Type.SUCCESS, title, content);
    }

    @SafeVarargs
    public static void success(String title, String content, EventHandler<MouseEvent>... confirm){
        Dialog.createAlert(Dialog.Type.SUCCESS, title, content, confirm);
    }
}

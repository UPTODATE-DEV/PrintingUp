package conf;

import com.gn.decorator.GNDecorator;
import com.jfoenix.controls.JFXButton;
import static conf.ConfigApp.getInstance_conf;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import org.controlsfx.control.PopOver;

public class ConfigController implements Initializable {

    public static final PopOver popup = new PopOver();

    public static final PopOver popConfig = new PopOver();
    @FXML
    private JFXButton btn_theme;

    @FXML
    public VBox options;
    private static final HashMap<String, Node> SCREENS = new HashMap<>();
    public static final GNDecorator decorator = new GNDecorator();
    public static final Scene scene = decorator.getScene();
    public static ConfigController ctrl;
    public static ObservableList<String> stylesheets;
    public static HostServices hostServices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ctrl = this;
        System.out.println("Je suis presque a la fin");
    }

    private boolean invert = false;

    @FXML
    private void altTheme() {
        invertTheme(!invert);
    }

    private void invertTheme(boolean dark) {
        String theme;
//        stylesheets.clear();
        String path = "/css/";

        if (dark) {
            decorator.initTheme(GNDecorator.Theme.DARKULA);
            theme = "dark.css";
            btn_theme.setText("Theme dark : active");
            invert = true;
        } else {
            decorator.initTheme(GNDecorator.Theme.DEFAULT);
            theme = "light.css";
            btn_theme.setText("Theme dark : désactive");
            invert = false;
        }

        ObservableList<String> stylesheets = decorator.getStage().getScene().getStylesheets();

        stylesheets.addAll(
                getClass().getResource(path + "fonts.css").toExternalForm(),
                getClass().getResource(path + "material-color.css").toExternalForm(),
                getClass().getResource(path + "skeleton.css").toExternalForm(),
                getClass().getResource(path + "" + theme).toExternalForm(),
                getClass().getResource(path + "bootstrap.css").toExternalForm(),
                getClass().getResource(path + "simple-green.css").toExternalForm(),
                getClass().getResource(path + "shape.css").toExternalForm(),
                getClass().getResource(path + "typographic.css").toExternalForm(),
                getClass().getResource(path + "helpers.css").toExternalForm(),
                getClass().getResource(path + "master.css").toExternalForm()
        );

        getInstance_conf().getStylesheets().setAll(stylesheets);

        for (Node node : getAll()) {
            ((StackPane) node).getStylesheets().clear();
            ((StackPane) node).getStylesheets().setAll(stylesheets);
        }

        ConfigApp.popConfig.hide();

        Platform.runLater(() -> {
//          force pop's transition

            popup.getRoot().getStylesheets().remove(popup.getRoot().getStylesheets().size() - 1);
            popConfig.getRoot().getStylesheets().remove(popConfig.getRoot().getStylesheets().size() - 1);

            popup.getRoot().getStylesheets().add(path + "pop" + theme);
            popConfig.getRoot().getStylesheets().add(path + "pop" + theme);
        });

    }

    private static String nameView;

    public void put(String name, Node node) {
        nameView = name;
        SCREENS.put(name, node);
    }

    public Node get(String view) {
        return SCREENS.get(view);
    }

    public int getSize() {
        return SCREENS.size();
    }

    Node getCurrentView() {
        return SCREENS.get(nameView);
    }

    public ObservableList<Node> getAll() {
        return FXCollections.observableArrayList(SCREENS.values());
    }

}

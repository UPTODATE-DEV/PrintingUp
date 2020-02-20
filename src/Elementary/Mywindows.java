/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

//import Others.ElementaryCode;
import static Elementary.Connexion.isConnected;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import controller.commande.AddcommandeController;
import controller.commande.PrintCommandeController;
import static controllers.PrincipaleController.Rcotent;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.BufferedReader;
//import static controllers.PrincipaleController.Indexstack;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Authentique
 */
public class Mywindows {

    private static Mywindows window;

    /**
     * @param URL
     * @param title
     * @param parentStage
     * @param resizable
     * @Fonction qui permet de mettre en grand le boutton selectionner
     */
    public static void createWindow(URL URL, String title, Stage parentStage, Boolean resizable) {
        try {
            Parent root = FXMLLoader.load(URL);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
                stage.initModality(Modality.APPLICATION_MODAL);
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            stage.setResizable(resizable);
            stage.setTitle(title);
            stage.setScene(new Scene(root));

            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * @param lab
     * @Fonction qui permet de mettre en grand le boutton selectionner
     */

    private static PopOver over;

    public static PopOver getOver() {
        if (over == null) {
            over = new PopOver();
            System.out.println(over.toString());
        }
        return over;
    }

    public static void popOverMenu(Node node, URL url, PopOver.ArrowLocation arrowLocation) throws IOException {
        if (!getOver().isShowing()) {
            VBox box = FXMLLoader.load(url);
            getOver().setArrowLocation(arrowLocation);
            getOver().setAutoHide(true);
            getOver().setContentNode(box);
            getOver().show(node, 5);
        } else {
            getOver().hide();
        }
    }

    /**
     * @param lab
     * @Fonction qui permet de mettre en grand le boutton selectionner
     */
    public void IsSeleted(Label... lab) {
        try {
            for (Label tr : lab) {
                tr.setTextFill(Color.web("#8b8f98"));
//                tr.setFont(Font.font("Century Gothic", FontPosture.REGULAR, 13));
            }
            lab[0].setTextFill(Color.web("#1493D7"));
//            lab[0].setFont(Font.font("Century Gothic", FontWeight.BOLD, 13));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param bt
     * @Fonction qui permet de mettre en grand le boutton selectionner
     */
    public void SelectDataFor1(Button... bt) {
        try {
            for (Button tr : bt) {
                //tr.setTextFill(Color.web("#8b8f98"));
                tr.setStyle("-fx-background-color: #fff;-fx-text-fill: #000000;");
//                tr.setFont(Font.font("System", FontPosture.REGULAR, 13));
            }
            bt[0].setStyle("-fx-background-color: #176FE5;-fx-text-fill: #fff;");
            //  bt [0].setTextFill(Color.web("#1493D7"));
            // bt[0].setTextFill(Color.web("#1493D7"));
            //bt[0].setFont(Font.font("System", FontWeight.BOLD, 13));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void SelectDataFor(AnchorPane... pans) {
        try {
            for (int i = 1; i < pans.length; i++) {
                // pans[i].setStyle("-fx-border-color: #F6F7F9;");
                pans[i].getStylesheets().clear();
            }
            //   pans[0].setStyle("-fx-border-color: #176FE5;-fx-border-width: 0px 0px 0px 1px");
            pans[0].getStylesheets().add(getClass().getResource("/styles/selector.css").toExternalForm());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param node
     * @param url
     * @Fonction permetant de recevoir d'autre Fichier fxml
     */
    public static void makejira(Node node, URL url) {
        try {
            Node child = FXMLLoader.load(url);
            if (node instanceof StackPane) {
                StackPane contain_area = (StackPane) node;
                contain_area.getChildren().removeAll();
                contain_area.getChildren().setAll(child);
            } else if (node instanceof VBox) {
                VBox contain_area = (VBox) node;
                contain_area.getChildren().removeAll();
                contain_area.getChildren().setAll(child);
            } else if (node instanceof AnchorPane) {
                AnchorPane contain_area = (AnchorPane) node;
                contain_area.getChildren().removeAll();
                contain_area.getChildren().setAll(child);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param vbx
     * @param data
     * @param url
     * @throws java.io.IOException
     * @Creatiom de l'Objet pour cette Classe
     */
    int i;

//    public void scrollVBX(VBox vbx, ArrayList data, String url) throws IOException {
    public void scrollVBX(VBox vbx, String url, int size) throws IOException {
        Node node[] = new Node[size];
        vbx.getChildren().clear();
        for (i = 0; i < size; i++) {
            node[i] = FXMLLoader.load(getClass().getResource(url));
            vbx.getChildren().add(node[i]);
        }
//            str = (String) array;
//            System.err.println("Peronne Id: " + str);
//            desi = str;

//    }
    }

    /**
     * @param princi
     * @param size
     * @param url
     * @param receved
     * @throws java.io.IOException
     * @Creatiom de l'Objet pour cette Classe
     */
    int somme;
    static int size;
    public static int resutatId;
    private ArrayList num, service, quantite, punitaire;
    public String num1, service1, quantite1, punitaire1;

//    public void ScrollwithHBX(VBox princi, ArrayList data, String url, Node... receved) throws IOException {
    public void ScrollwithHBX(GridPane grid, int tr, String url) throws IOException, SQLException {
        unit();

              pst = isConnected().prepareStatement("SELECT * FROM `vs_test`");
        rst = pst.executeQuery();
        while (rst.next()) {
            num.add(rst.getString(1));
            service.add(rst.getString(2));
            quantite.add(rst.getString(3));
            punitaire.add(rst.getString(4));
        }

        Node[] node = new Node[num.size()];
        grid.getChildren().clear();

        int x = 0;
        int i = 0;
        while (i < num.size()) {
           
                HBox hbx = new HBox();
                hbx.setStyle("-fx-fill: #F8F8F8");
                for (int a = 0; a < tr; a++) {
                    System.out.println(service1);
                    num1 = num.get(a).toString();
                    service1 = service.get(a).toString();
                    quantite1 = quantite.get(a).toString();
                    punitaire1 = punitaire.get(a).toString();
                    node[a] = FXMLLoader.load(getClass().getResource(url));
                    grid.add(node[i], a, x);
                    i++;
                    if (i >= num.size()) {
                        a = 5;
                    }
                }
                i++;
            
        }
    }

    /**
     * @param location
     * @param transition
     * @param width
     * @param height
     * @throws java.io.IOException
     * @Creatiom de l'Objet pour cette Classe
     */
    public static void showFormDialog(URL location, JFXDialog.DialogTransition transition, int width, int height) throws IOException {
        JFXDialog dialog;
        Node node = FXMLLoader.load(location);
        JFXDialogLayout dl = new JFXDialogLayout();
        dl.setPrefSize(width, height);
        dl.setBody(node);
        dialog = new JFXDialog(Rcotent, dl, transition, false);
        dialog.setPrefSize(width, height);
        dialog.show(Rcotent);
//
    }

    /**
     * @param node
     * @param str
     * @Methode de legende sur Button ou Label
     */
    public static void SetToolTip(Node node, String str) {
        Tooltip tooltip = new Tooltip();
        tooltip.setText(str);
        if (node instanceof Label) {
            Label txt = (Label) node;
            txt.setTooltip(tooltip);
        } else if (node instanceof JFXButton) {
            JFXButton txt = (JFXButton) node;
            txt.setTooltip(tooltip);
        }
    }

    // Others
    /**
     * Methode de verification des champs.
     *
     * @param nodes
     * @return
     */
    public boolean isFieldsempty(Node... nodes) {
        int i = 0;
        for (Node node : nodes) {
            if (node instanceof TextField) {
                TextField pass = (TextField) node;
                if (pass.getText() == null || pass.getText().isEmpty()) {
                    break;
                }
                i++;
            } else if (node instanceof TextArea) {
                TextArea area = (TextArea) node;
                if (area.getText() == null || area.getText().trim().isEmpty()) {
                    break;
                }
                i++;
            } else if (node instanceof Label) {
                Label txt = (Label) node;
                if (txt.getText() == null || txt.getText().isEmpty()) {
                    break;
                }
                i++;
                i++;
            } else {
                TextField text = (TextField) node;
                if (text.getText() == null || text.getText().isEmpty()) {
                    break;
                }
                i++;
            }
        }
        return i != nodes.length;
    }

    /**
     * Methode d'Initialisation.
     *
     * @param isSave
     * @param field
     */
    public static void initFields(boolean isSave, Object... field) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(3500);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            if (isSave) {
                                Thread.sleep(2500);
                                for (Object f : field) {
                                    if (f instanceof TextField) {
                                        TextField text = (TextField) f;
                                        text.setText(null);
                                    } else if (f instanceof DatePicker) {
                                        DatePicker text = (DatePicker) f;
                                        text.setValue(null);
                                    } else if (f instanceof TextArea) {
                                        TextArea text = (TextArea) f;
                                        text.setText(null);
                                    } else if (f instanceof ComboBox) {
                                        ComboBox text = (ComboBox) f;
                                        text.setValue(null);
                                    } else if (f instanceof Label) {
                                        Label txt = (Label) f;
                                        txt.setText(null);
                                    } else if (f instanceof PasswordField) {
                                        PasswordField txt = (PasswordField) f;
                                        txt.setText(null);
                                    }
                                }
                            } else {
                                for (Object f : field) {
                                    if (f instanceof TextField) {
                                        TextField text = (TextField) f;
                                        text.setText(null);
                                    } else if (f instanceof DatePicker) {
                                        DatePicker text = (DatePicker) f;
                                        text.setValue(null);
                                    } else if (f instanceof TextArea) {
                                        TextArea text = (TextArea) f;
                                        text.setText(null);
                                    } else if (f instanceof ComboBox) {
                                        ComboBox text = (ComboBox) f;
                                        text.setValue(null);
                                    } else if (f instanceof Label) {
                                        Label txt = (Label) f;
                                        txt.setText(null);
                                    } else if (f instanceof PasswordField) {
                                        PasswordField txt = (PasswordField) f;
                                        txt.setText(null);

                                    }
                                }
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Mywindows.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                return null;
            }
        };
        new Thread(task).start();
    }

    /**
     * @Methode de verification de virgule d'un Nombre
     */
    public static int FullValor(String input) {
        int i = 0;
        try {
            char[] monText = input.toCharArray();
            for (char tr : monText) {
                if (tr == '.') {
                    i++;
                }
            }
        } catch (Exception e) {
            System.err.println("Errreur de Ferification Des Points");
            e.printStackTrace();
        }
        return i;
    }
    /**
     * @Methode de verification de virgule d'un Nombre
     */
    static Thread out;

    public static void Loading(ImageView image) {

        try {

            image.setVisible(true);
        } catch (Exception e) {
            System.err.println("Errreur de Ferification Des Points");
            e.printStackTrace();
        }
        out = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    image.setVisible(false);
                } catch (InterruptedException ex) {
//                    Logger.getLogger(ElementaryCode.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        out.start();
    }

    /**
     * @param str
     * @return
     * @throws java.lang.Exception
     * @Methode de verification d'un Entier
     */
    public static boolean TovalidedInt(String str) throws Exception {
        int i = 0;
        try {
            char[] cart = str.toCharArray();
            for (char tr : cart) {
                if (tr == '0' | tr == '1' | tr == '2' | tr == '3' | tr == '4'
                        | tr == '5' | tr == '6' | tr == '7' | tr == '8' | tr == '9') {
                    System.out.println("T'es 0");
                } else {
                    System.out.println("Mort c'est moi");
                    i = 1;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("I: " + i);
        return i != 0;
    }

    /**
     * @param str
     * @return
     * @throws java.lang.Exception
     * @Methode de verification d'un Decimal
     */
    public static boolean TovalideDouble(String str) throws Exception {
        int i = 0;
        try {
            char[] cart = str.toCharArray();
            if (cart.length == 2 && cart[1] == '.') {
                i = 1;
            } else {
                for (char tr : cart) {
                    if (tr == '.' | tr == '0' | tr == '1' | tr == '2' | tr == '3' | tr == '4'
                            | tr == '5' | tr == '6' | tr == '7' | tr == '8' | tr == '9' && FullValor(str) <= 1) {
                    } else {
                        i = 1;
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("I: " + i);
        return i != 0;
    }

    /**
     * @Creatiom de l'Objet pour cette Classe
     */
    public static Mywindows getInstanceL() {
        if (window == null) {
            window = new Mywindows();
            System.out.println(window.toString());
        }
        return window;
    }
    /**
     *
     * @Mes variables
     */
    //static int size;
    static PreparedStatement pst;
    static ResultSet rst;
    static String _p = "?";
    static String ident;

    static int ip;

    public static boolean isSaved(String nameT, String typeQuerry, Object... DataExt) throws IOException, Exception {
        /**
         * @Initialisation des variables i & size
         */
        ip = 0;
        size = DataExt.length;
        Object dataInt[] = new Object[size];

        for (Object f : DataExt) {
            if (f instanceof TextField) {
                TextField text = (TextField) f;
                dataInt[ip] = text.getText();
            } else if (f instanceof DatePicker) {
                DatePicker text = (DatePicker) f;
                dataInt[ip] = text.getValue();
            } else if (f instanceof TextArea) {
                TextArea text = (TextArea) f;
                dataInt[ip] = text.getText();
            } else if (f instanceof ComboBox) {
                ComboBox text = (ComboBox) f;
                dataInt[ip] = text.getValue();
            } else if (f instanceof Label) {
                Label text = (Label) f;
                dataInt[ip] = text.getText();
            } else if (f instanceof Text) {
                Text text = (Text) f;
                dataInt[ip] = text.getText();
            } else if (f instanceof PasswordField) {
                PasswordField text = (PasswordField) f;
                dataInt[ip] = text.getText();
            } else if (f instanceof String) {
                String str2 = (String) f;
                dataInt[ip] = str2;
            } else if (f instanceof Integer) {
                Integer inter = (Integer) f;
                dataInt[ip] = inter;
            } else if (f instanceof Float) {
                Float flt = (Float) f;
                dataInt[ip] = flt;
            } else if (f instanceof Double) {
                Double dble = (Double) f;
                dataInt[ip] = dble;
            } else if (f instanceof Boolean) {
                Boolean bool = (Boolean) f;
                dataInt[ip] = bool;
            }
            ip++;
        }
        /**
         * @Bouble permetant de creer les pointeurs "?"
         *
         */
        for (int j = 1; j < size; j++) {
            if (size == 1) {
                _p = "" + _p;
            } else {
                _p = _p + ",?";
            }
        }
        _p = "(" + _p + ")";
        ip = 0;
        /**
         * @verification du Type de requette (Procedurale ou simple insertion)
         */
        try {
            if ("PROCEDURE".equals(typeQuerry)) {
                pst = isConnected().prepareCall("call " + nameT + "" + _p);
                System.out.println("call " + nameT + "" + _p);
            } else if ("QUERRY".equals(typeQuerry)) {
                pst = isConnected().prepareStatement("insert into " + nameT + " values" + _p);
            }
            System.out.println("Querry: insert into " + nameT + " values" + _p);
            /**
             * @Bouble permetant de remplir les pointeurs avec des données "?"
             */
            System.out.println("data size" + dataInt.length);
//            for (Object data : dataInt) {
            for (int k = 0; k < dataInt.length; k++) {
                System.out.println("data[" + (ip + 1) + "] " + dataInt[k]);
                pst.setObject((k + 1), dataInt[k].toString());
                ip++;
            }
            /**
             * @Execution de PrepareStatement
             */
            int x = pst.executeUpdate();
            if (x == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
//            BD.Disconnect();
            _p = "?";
            System.out.println("Para: " + _p);
        }

        return false;
    }

    public String ismac_up(String query) {
        try {
            pst = Connexion.isConnected().prepareStatement(query);
            rst = pst.executeQuery();
            if (rst.next()) {
                if (rst.getString("x").equals(null) || Double.parseDouble(rst.getString("x")) == 0.0) {
                    return "0.0";
                } else {
                    return rst.getString("x");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Mywindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String sexe_change(int x) {
        if (x == 0) {
            return "MASCULIN";
        } else if (x != 0) {
            return "FEMININ";
        }
        return null;

    }

    public ObservableList AutoCompression(String Table, String Colone, String cond) {
        ObservableList list = FXCollections.observableArrayList();
        try {
            if (cond == null) {
                pst = Connexion.isConnected().prepareStatement("SELECT " + Colone + " FROM " + Table);
            } else {
                pst = Connexion.isConnected().prepareStatement("SELECT " + Colone + " FROM " + Table + " " + cond);
            }
            rst = pst.executeQuery();
            while (rst.next()) {
                list.addAll(rst.getString(Colone));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return list;
    }

    public boolean Isnumeric(String x) {
        try {
            if (x.contentEquals("D")) {
                x = null;
            }
            double v = Double.parseDouble(x);
        } catch (NumberFormatException e) {
            x = null;
        }
        return false;

    }
    // FOnction D'affichage

    public void ChargememtCompression(TextField textFied, String Table, String Colonne, String cnd) {
        textFied.setOnMouseClicked((e) -> {
            TextFields.bindAutoCompletion(textFied, AutoCompression(Table, Colonne, cnd));
        });
    }
    /**
     * @param princi
     * @param size
     * @param url
     * @param receved
     * @throws java.io.IOException
     * @Creatiom de l'Objet pour cette Classe
     */

    /**
     * @param message
     * @param icon
     * @param str
     * @param error
     * @Oupt put
     */
    static MaterialDesignIconView mat;
    static Thread loading;
    public static boolean isSave;

    public static void Ouput(Text message, Label icon, String str, ImageView image, Button bt, boolean load, boolean error) {
        if (error) {
            mat = new MaterialDesignIconView(MaterialDesignIcon.ALERT_OUTLINE);
            mat.setGlyphSize(27);
            message.setFill(Color.web("#c95a5a"));
            mat.setStyle("-fx-fill:#c95a5a");
        } else {
            mat = new MaterialDesignIconView(MaterialDesignIcon.CHECKBOX_MULTIPLE_MARKED_OUTLINE);
            mat.setGlyphSize(27);
            message.setFill(Color.web("#6A75CA"));
            mat.setStyle("-fx-fill:#6A75CA");

        }
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(1000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        icon.setGraphic(mat);
                    }
                });
                icon.setVisible(true);
                message.setText(str);
                Thread.sleep(3000);
                message.setText("");
                icon.setVisible(false);
                bt.setDisable(false);

                return null;
            }
        };
        loading = new Thread() {
            @Override
            public void run() {
                try {
                    image.setVisible(true);
                    Thread.sleep(1500);
                    image.setVisible(false);
                    new Thread(task).start();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mywindows.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        out = new Thread() {
            @Override
            public void run() {
                try {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            icon.setGraphic(mat);
                        }
                    });
                    icon.setVisible(true);
                    message.setText(str);
                    Thread.sleep(3500);
                    message.setText("");
                    icon.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mywindows.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        if (load) {
            bt.setDisable(true);
            loading.start();
        } else {
            out.start();
        }

    }

    public ObservableList<String> getArray(String query) {
        ObservableList<String> oblist = FXCollections.observableArrayList();
        try {
            pst = isConnected().prepareStatement(query);
            rst = pst.executeQuery();
            while (rst.next()) {
                // ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rst.getMetaData().getColumnCount(); i++) {
                    oblist.addAll(rst.getString(i) + "\n");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mywindows.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oblist;
    }
// public void Scroll(BufferedReader read) throws IOException, SQLException {
//        unit();
//        String ligne;
//        while ((rst.next())) {
//           // System.err.println(ligne);
//            AddcommandeController.service1.add(getJson(ligne, "code"));
//            NOM.add(getJson(ligne, "nom"));
//            EXP.add(getJson(ligne, "exp"));
//            SEXE.add(getJson(ligne, "sexe"));
//            FONCTION.add(getJson(ligne, "fonction"));
//            LEVEL.add(getJson(ligne, "level"));
//            TEL.add(getJson(ligne, "tel"));
//        }
//        txtInfos_.setText("Liste des Utilisateurs (" + CODE.size() + ")");
//
//        AnchorPane[] node = new AnchorPane[CODE.size()];
//        grid.getChildren().clear();
//        int x = 0;
//        int i = 0;
//        while (i < CODE.size()) {
//            System.err.println("I " + i);
//            for (int ii = 0; ii < 2; ii++) {
//                System.err.println(i + "       II " + ii);
//                LoadUsersController.ID = CODE.get(i);
//                LoadUsersController.NAME = NOM.get(i);
//                LoadUsersController.NUMBER = String.valueOf(i + 1);
//                LoadUsersController.FONCTION = FONCTION.get(i);
//                LoadUsersController.EXP = EXP.get(i);
//                LoadUsersController.LEVE = LEVEL.get(i);
//                LoadUsersController.SEXE = SEXE.get(i);
//                LoadUsersController.TEL = TEL.get(i);
//                try {
//                    node[i] = FXMLLoader.load(getClass().getResource("/Chargement/loadUsers.fxml"));
//                } catch (IOException ex) {
//                    ev.Dialog(ex.getMessage());
//                }
//                grid.add(node[i], ii, x);
//                i++;
//                if (i >= CODE.size()) {
//                    ii = 5;
//                }
//            }
//            x++;
//        }
//    }
//

    private void unit() {
        num.clear();
        service.clear();
        quantite.clear();
        punitaire.clear();
    }
    // AddcommandeController.service1.setText("OK");
}

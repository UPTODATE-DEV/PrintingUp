/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import static Elementary.Connexion.isConnected;
import static Elementary.Mywindows.size;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Akim
 */
public class Pagination_ {

    private int from;
    private int to;
    int intpage = 7;
    public static int count = 0;
    public static int pageCout = 0;

    public static String rqte = null;
    public static VBox vb_;
    public static String url_;
    public static int index = 0;
    public static int index_aff = 0;

    public List<List> data = new ArrayList<>();
    public static int t = 0;
    int c, g;

    public Pagination_(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public Pagination_(Pagination pgi, String counts) {
        try {
            principaleokbien(pgi, counts);
        } catch (Exception ex) {
        }
    }

    public Pagination_() {
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
    //pagination
    private ResultSet rs;

    public Pagination principaleokbien(Pagination pgi, String counts) {
        try {
            rs = isConnected().createStatement().executeQuery(counts);
            rs.first();
            count = rs.getInt(1);
            rs.close();
            pageCout = (count / intpage) + 1;
            pgi.setPageCount(count);
            pgi.setPageFactory(this::create);
            System.out.println(count);
        } catch (SQLException e) {
            System.out.println("attention  " + e);
        }
        return null;

    }

    //chargement table 
//    public List tableCharge(String SQL, TableView v) throws ClassNotFoundException, SQLException, Exception {
//        ResultSet res = null;
//
//        ObservableList<ObservableList> oblist = FXCollections.observableArrayList();
//        try {
//            data.clear();
//            v.getColumns().clear();
//            v.setColumnResizePolicy(v.CONSTRAINED_RESIZE_POLICY);
//            rst = MysSqlConnection.Connect().createStatement().executeQuery(SQL);
//
//            for (int i = 0; i < res.getMetaData().getColumnCount(); i++) {
//                final int j = i;
//                TableColumn col = new TableColumn(rst.getMetaData().getColumnName(i + 1).toUpperCase());
//                col.setPrefWidth((v.getPrefWidth() / rst.getMetaData().getColumnCount()));
//                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, Object>, ObservableValue<Object>>() {
//                    @Override
//                    public ObservableValue<Object> call(TableColumn.CellDataFeatures<ObservableList, Object> param) {
//                        return new SimpleObjectProperty(param.getValue().get(j)); //To change body of generated methods, choose Tools | Templates.
//                    }
//                });
//                v.getColumns().addAll(col);
//            }
//
//            while (rst.next()) {
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= rst.getMetaData().getColumnCount(); i++) {
//                    row.add(rst.getString(i));
//                }
//                oblist.add(row);
//            }
//            v.setItems(oblist);
//            Object ob[] = new Object[oblist.size()];
//            for (int i = 0; i < oblist.size(); i++) {
//                ob[i] = oblist.get(i);
//                data.add(oblist.get(i));
//            }
////             data=ob;
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            res.close();
//        }
//        return data;
//    }
    String str;

    public Node create(int pageIndex) {
        try {
            setFrom(pageIndex * intpage);
            setTo(intpage);
            new Pagination_(pageIndex * intpage, intpage);
            System.out.println(getFrom());
            System.out.println("____________________________________________________");
            System.out.println(getTo());
            System.out.println("____________________________________________________");
            System.out.println(rqte);
            ScrollwithHBX(vb_, View_gui.getIns().getService(index, rqte + " LIMIT " + getFrom() + "," + getTo()), url_, index_aff);
        } catch (IOException | SQLException ex) {
            // Logger.getLogger(Paginationnale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int i;
    public int somme;
    public int resulta;
    public int code;

    public void ScrollwithHBX(VBox princi, ArrayList data, String url, int nbr) throws IOException {
//    public void ScrollwithHBX(VBox princi, int tr, String url, int nbr) throws IOException {
        i = 0;

        //  somme = tr;
        //  size = tr;
        somme = data.size();
        size = data.size();
        resulta = data.size();

        Node[] node = new Node[somme];
        princi.getChildren().clear();
        code = 0;
        while (i < somme) {
            if ((size - nbr) >= 0) {

                HBox hbx = new HBox();
                hbx.setStyle("-fx-fill: #F8F8F8");
                for (int a = 0; a < nbr; a++) {
//                    loadData(i, data);
                    node[a] = FXMLLoader.load(getClass().getResource(url));
                    hbx.getChildren().add(node[a]);
                    i++;
                    code++;
                }
                size = size - nbr;
                princi.getChildren().add(hbx);

            } else {
                HBox hbx2 = new HBox();
                hbx2.setStyle("-fx-fill: #F8F8F8");
                for (int b = 0; b < size; b++) {
                    node[b] = FXMLLoader.load(getClass().getResource(url));
                    hbx2.getChildren().add(node[b]);
                    i++;
                    code++;
                }
                size = size - size;
                princi.getChildren().add(hbx2);
            }

        }

    }
    private static Pagination_ instance;

    public static Pagination_ getInstancePage() {
        if (instance == null) {
            instance = new Pagination_();
        }
        return instance;
    }
}

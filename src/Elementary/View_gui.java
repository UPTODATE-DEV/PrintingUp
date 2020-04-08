/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Akim
 */
public class View_gui extends Connexion {

    public ArrayList<String> list = new ArrayList();
    public volatile static View_gui view;

    public ArrayList getService(int z, String query) throws SQLException {
        list.clear();
        String id;
        PreparedStatement pst = isConnected().prepareStatement(query);
        rst = pst.executeQuery();
        // rst = stm.executeQuery(query);
        while (rst.next()) {
            switch (z) {
                case 1:
                    id = rst.getString("id");
                    if (Integer.parseInt(id) < 10) {
                        id = "00" + id;
                    } else {
                        id = "0" + id;
                    }
                    list.add(
                            id
                            + "#" + rst.getString("service")
                            + "%" + rst.getString("type")
                            + "$" + rst.getString("pu") + " FC"
                    );
                    break;
                case 2:
                    id = rst.getString("id");
                    if (Integer.parseInt(id) < 10) {
                        id = "00" + id;
                    } else {
                        id = "0" + id;
                    }
                    list.add(
                            id
                            + "#" + rst.getString("nom")
                            + "^" + rst.getString("tel")
                            + "*" + rst.getString("mail")
                            + "&&" + rst.getString("adress")
                    );
                    break;
                case 3:
                    String cmd = rst.getString("id");
                    int x = rst.getString("id").length();
                    if (Integer.parseInt(cmd) < 10) {
                        cmd = "000" + cmd;
                    } else if (Integer.parseInt(cmd) > 10 && Integer.parseInt(cmd) < 100) {
                        cmd = "00" + cmd;
                    } else {
                        cmd = "0" + cmd;
                    }
                    String payer = rst.getString("payer");
                    if (payer == null) {
                        payer = "0";
                    }
                    int log = rst.getString("nom").length();
                    list.add(
                            rst.getString("nom").substring(x, log)
                            + "|" + rst.getString("qte")
                            + "#" + rst.getString("a_payer")
                            + "$" + payer
                            + "!" + cmd
                    );
                    break;
                case 4:
                    String dateFin = rst.getString("date_fn");
                    if (dateFin == null) {
                        dateFin = "En attente";
                    } else {
                        dateFin = dateFin;
                    }
                    list.add(
                            rst.getString("id")
                            + "|" + rst.getString("nom")
                            + "^" + rst.getString("date_db")
                            + "%" + dateFin
                            + "&" + rst.getString("statis")
                    );
                    break;
                case 5:
                    String montant = rst.getString("montant");
                    if (montant == null) {
                        montant = "0.0";
                    }
                    int loge = rst.getString("nom").length();
                    int log2 = rst.getString("id").length();
                    list.add(
                            rst.getString("id")
                            + "&" + rst.getString("a_payer")
                            + "^" + rst.getString("nom").substring(log2, loge)
                            + "#" + (rst.getDouble("a_payer") - Double.parseDouble(montant))
                    );
                    break;
                case 6:

                    list.add(
                            rst.getString("codecmd")
                            + "^" + rst.getString("service")
                            + "#" + rst.getString("type_")
                            + "&" + rst.getString("Punitaire")
                            + "%" + rst.getString("qte")
                    );
                    break;
                case 7:
                    String nbre = rst.getString("nbre");

                    if (Integer.parseInt(nbre) < 10) {
                        nbre = "00" + nbre;
                    } else if (Integer.parseInt(nbre) >= 10 && Integer.parseInt(nbre) < 100) {
                        nbre = "0" + nbre;
                    } else {
                        nbre = nbre;
                    }
                    list.add(
                            nbre
                            + "^" + rst.getString("service")
                            + "#" + rst.getString("date_")
                    );
                    break;
                case 8:
                    String niveau = rst.getString("niveau");
                    if (niveau == null) {
                        niveau = "Invalide";
                    }
                    list.add(
                            rst.getString(1)
                            + "#>" + capitalize(rst.getString(2))
                            + "<#" + rst.getString(3).substring(0, 1)
                            + "<&" + rst.getString(4)
                            + "&>" + rst.getString(5)
                            + "<$" + capitalize(rst.getString(6))
                            + "$>" + niveau
                    );
                    break;
            }
        }
        return list;
    }

    public static View_gui getIns() {
        if (view == null) {
            synchronized (View_gui.class) {
                if (view == null) {
                    view = new View_gui();
                }
            }
        }
        return view;
    }

    public String capitalize(String txt) {
        return txt.substring(0, 1) + "" + (txt.toLowerCase()).substring(1, txt.length());
    }
}

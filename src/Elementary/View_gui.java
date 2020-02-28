/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akim
 */
public class View_gui extends Traitement {

    public ArrayList<String> list = new ArrayList();
    public static View_gui view;

    public ArrayList getService(int z, String query) throws SQLException {
        list.clear();
        String id;
        rs = stm.executeQuery(query);
        while (rs.next()) {
            switch (z) {
                case 1:
                    id = rs.getString("id");
                    if (Integer.parseInt(id) < 10) {
                        id = "00" + id;
                    } else {
                        id = "0" + id;
                    }
                    list.add(
                            id
                            + "#" + rs.getString("service")
                            + "%" + rs.getString("type")
                            + "$" + rs.getString("pu") + " FC"
                    );
                    break;
                case 2:
                    id = rs.getString("id");
                    if (Integer.parseInt(id) < 10) {
                        id = "00" + id;
                    } else {
                        id = "0" + id;
                    }
                    list.add(
                            id
                            + "#" + rs.getString("nom")
                            + "^" + rs.getString("tel")
                            + "*" + rs.getString("mail")
                            + "&&" + rs.getString("adress")
                    );
                    break;
                case 3:
                    String cmd = rs.getString("id");
                    if (Integer.parseInt(cmd) < 10) {
                        cmd = "000" + cmd;
                    } else if (Integer.parseInt(cmd) > 10 && Integer.parseInt(cmd) < 100) {
                        cmd = "00" + cmd;
                    } else {
                        cmd = "0" + cmd;
                    }
                    String payer = rs.getString("payer");
                    if (payer == null) {
                        payer = "0";
                    }
                    int log = rs.getString("nom").length();
                    list.add(
                            rs.getString("nom").substring(1, log)
                            + "|" + rs.getString("nb_srvc")
                            + "#" + rs.getString("a_payer")
                            + "$" + payer
                            + "!" + cmd
                    );
                    break;

            }
        }
        return list;
    }
    public ArrayList<String> list1;

    public ArrayList isPayer(int x) throws SQLException {
        list1 = new ArrayList();
        switch (x) {
            case 1:
                rs = stm.executeQuery("SELECT montant FROM vs_charger_nom WHERE a_payer=montant");
                break;
            case 2:
                rs = stm.executeQuery("SELECT montant FROM vs_charger_nom WHERE a_payer<>montant");
                break;
            default:
                rs = stm.executeQuery("SELECT montant FROM vs_charger_nom WHERE montant is null");
                break;
        }
        while (rs.next()) {
            list1.add(
                    rs.getString(1)
            );

        }

        return list1;

    }

    public static View_gui getIns() {
        if (view == null) {
            view = new View_gui();
        }
        return view;
    }
}

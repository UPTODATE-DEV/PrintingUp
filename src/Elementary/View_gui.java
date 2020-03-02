/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import java.sql.SQLException;
import java.util.ArrayList;

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
                    int x = rs.getString("id").length();
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
                            rs.getString("nom").substring(x, log)
                            + "|" + rs.getString("qte")
                            + "#" + rs.getString("a_payer")
                            + "$" + payer
                            + "!" + cmd
                    );
                    break;
                case 4:
                    list.add(
                            rs.getString("id")
                            + "|" + rs.getString("nom")
                            + "^" + rs.getString("date")
                    );
                    break;
                case 5:
                    String montant = rs.getString("montant");
                    if (montant == null) {
                        montant = "0.0";
                    }
                    int loge = rs.getString("nom").length();
                    int log2 = rs.getString("id").length();
                    list.add(
                            rs.getString("id")
                            + "&" + rs.getString("a_payer")
                            + "^" + rs.getString("nom").substring(log2, loge)
                            + "#" + (rs.getDouble("a_payer") - Double.parseDouble(montant))
                    );
                    break;
                case 6:

                    list.add(
                            rs.getString("codecmd")
                            + "^" + rs.getString("service")
                            + "#" + rs.getString("type_")
                            + "&" + rs.getString("Punitaire")
                            + "%" + rs.getString("qte")
                    );
                    break;
            }
        }
        return list;
    }

    public static View_gui getIns() {
        if (view == null) {
            view = new View_gui();
        }
        return view;
    }
}

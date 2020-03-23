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
public class View_gui extends Connexion {

    public ArrayList<String> list = new ArrayList();
    public static View_gui view;

    public ArrayList getService(int z, String query) throws SQLException {
        list.clear();
        String id;
        rst = stm.executeQuery(query);
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
                    list.add(
                            rst.getString("id")
                            + "|" + rst.getString("nom")
                            + "^" + rst.getString("date_db")
                            + "%" + rst.getString("date_fn")
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

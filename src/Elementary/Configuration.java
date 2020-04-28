/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

import java.time.LocalDateTime;
import java.util.prefs.Preferences;

/**
 *
 * @author Akim
 */
public class Configuration {

    private static final Preferences pref = Preferences.userNodeForPackage(Configuration.class);

    public static boolean RedKey(String url, String db, String login, String pwd, String port) {

        if (port.isEmpty() || port.equals("") || port == null) {
            pref.put("url", "jdbc:mysql://" + url + "/" + db + "");
        } else {
            pref.put("url", "jdbc:mysql://" + url + ":" + port + "/" + db + "");
        }

        pref.put("login", login);
        pref.put("pwd", pwd);
        return true;
    }

    public static String localhost() {
        String url = pref.get("url", "url");
        return url;
    }

    public static String pwd1() {
        String pwd = pref.get("pwd", "pwd");
        return pwd;
    }

    public static String login1() {
        return pref.get("login", "login");
    }

    public static String url_print() {
        return pref.get("imprimer", "imprimer");
    }

    public static String url_backup() {
        return pref.get("backup", "backup");
    }

    public static float taux() {
        return pref.getFloat("taux", 1);
    }

    public static String nomBase() {
        return pref.get("DB", "DB");
    }

    public static String TimeBackup() {
        return pref.get("heure", "heure");
    }

    public static String cheminDynamyc() {
        return pref.get("accespoint", "accespoint");
    }

    public void setDate(LocalDateTime da) {
        pref.put("maintenant", da.toString());
    }

    public String getDate() {
        return pref.get("maintenant", "maintenant");
    }
}

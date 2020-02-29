/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

/**
 *
 * @author Authentique
 */
public class references {

    /**
     *
     * @Gui
     */
    public static final String PRINCIPAL = "/gui/principale.fxml";
    public static final String DASHBORD = "/gui/dashbord.fxml";
    public static final String OTHERMENU = "/gui/other.fxml";
    public static final String OTHEPAIEMENT = "/guis/commande/other_paiement.fxml";
    public static final String OTHEINFO = "/guis/commande/other_commande.fxml";

    /**
     *
     * @Gui
     */
    public static final String NOUVEAU = "/guis/nouveau/nouveau.fxml";
    public static final String COMMANDE = "/guis/commande/commande.fxml";
    public static final String PARAMETRE = "/guis/parametrer/parametrer.fxml";
    public static final String ADDCLIENT = "/guis/nouveau/addclient.fxml";
    public static final String LOADCOMMANDE = "/guis/nouveau/printService.fxml";
    public static final String LOAD_COMMANDE = "/guis/commande/printl_commande.fxml";
    public static final String LOAD_DETTE = "/guis/commande/orher_dette.fxml";
    public static final String LOAD_PRINT_DETTE = "/guis/commande/orther_verifier_dette.fxml";
    public static final String LOAD_PRINT_LISTDETTE = "/guis/commande/orther_v_dette.fxml";

    public static final String ADDSERVICE = "/guis/nouveau/addservice.fxml";
    public static final String ADDAGENT = "/guis/nouveau/addagent.fxml";
    public static final String PRINT_CLIENT = "/guis/nouveau/printClient.fxml";
    public static final String ADDCOMMANDE = "/guis/commande/Addcommande.fxml";
    public static final String PRINT_CMD = "/guis/commande/PrintCommandeAll.fxml";
    
    public static final String PRINT_DETTE = "/guis/commande/orther_paiement_dette.fxml";
    public static final String PRINT_PAIEMENT_DETTE = "/guis/commande/other_regle_dette.fxml";

    /**
     * *
     *
     * INITIALISATION DE MESSAGE D'ALERT
     */
    public final String MESSAGE_SAVE = "Vous avez enregistrer avec succès";
    public final String MESSAGE_MODIFY = "Vous avez modifier avec succès";
    public final String MESSAGE_DELETE = "Vous avez supprimer avec succès";
    public final String MESSAGE_ISMPTY = "Completer les champ()s svp";
    public final String MESSAGE_INFERIEUR = "Vous avez entrer le nontant invalider";
    public final String MESSAGE_FACT = "Créé d'abord la facture svp";

    /**
     * *
     * INITIALISATION DE LA CLASSE references TEST L'OBJECT
     *
     */
    private static references refere;

    /**
     * ******
     * Initialisation de la class references
     *
     * @return
     */
    public static references getInstanceE() {
        if (refere == null) {
            refere = new references();
        }
        return refere;
    }

}

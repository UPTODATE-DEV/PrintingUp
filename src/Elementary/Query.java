/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementary;

/**
 *
 * @author Akim
 */
public class Query {

    public String montant = "SELECT montant x FROM tbl_facture WHERE codecmdE";
    public String query = "SELECT MAX(id) x FROM tbl_entecommande";

    public String getQuery(String nom, String id) {
        return "SELECT *FROM vs_paiement WHERE codefcr= '" + id + "'AND nom='" + nom + "'";
    }
}

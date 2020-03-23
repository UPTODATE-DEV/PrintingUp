/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.commande.entete;

/**
 *
 * @author Akim
 */
public class EnteteCommendeDao {
    // sp_commande`(IN `code_` BIGINT, IN `codeclient_` VARCHAR(255), IN `status_` INT)

    private String code_;
    private String nomClient;
    private String status;

    public EnteteCommendeDao() {
    }

    public EnteteCommendeDao(String code_, String nomClient, String status) {
        this.code_ = code_;
        this.nomClient = nomClient;
        this.status = status;
    }

    /**
     * @return the code_
     */
    public String getCode_() {
        return code_;
    }

    /**
     * @param code_ the code_ to set
     */
    public void setCode_(String code_) {
        this.code_ = code_;
    }

    /**
     * @return the nomClient
     */
    public String getNomClient() {
        return nomClient;
    }

    /**
     * @param nomClient the nomClient to set
     */
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}

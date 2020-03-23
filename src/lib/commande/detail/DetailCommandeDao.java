/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.commande.detail;

/**
 *
 * @author Akim
 */
public class DetailCommandeDao {
//sp_Dcommande`(IN `code_` INT, IN `pu_` FLOAT, IN `nb_srvc_` INT, IN `codecmd_` BIGINT, IN `Service_` VARCHAR(255), IN `status_` INT, IN `type_service` VARCHAR(80))   \

    private String code;
    private float pu;
    private int nb_srvc;
    private String codecmd;
    private String service;
    private String status;
    private String type_service;

    public DetailCommandeDao(String code, float pu, int nb_srvc, String codecmd, String service, String status) {
        this.code = code;
        this.pu = pu;
        this.nb_srvc = nb_srvc;
        this.codecmd = codecmd;
        this.service = service;
        this.status = status;
    }

    public DetailCommandeDao() {
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the pu
     */
    public float getPu() {
        return pu;
    }

    /**
     * @param pu the pu to set
     */
    public void setPu(float pu) {
        this.pu = pu;
    }

    /**
     * @return the nb_srvc
     */
    public int getNb_srvc() {
        return nb_srvc;
    }

    /**
     * @param nb_srvc the nb_srvc to set
     */
    public void setNb_srvc(int nb_srvc) {
        this.nb_srvc = nb_srvc;
    }

    /**
     * @return the codecmd
     */
    public String getCodecmd() {
        return codecmd;
    }

    /**
     * @param codecmd the codecmd to set
     */
    public void setCodecmd(String codecmd) {
        this.codecmd = codecmd;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
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

    /**
     * @return the type_service
     */
    public String getType_service() {
        return type_service;
    }

    /**
     * @param type_service the type_service to set
     */
    public void setType_service(String type_service) {
        this.type_service = type_service;
    }

}

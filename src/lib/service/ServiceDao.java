/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

/**
 *
 * @author Akim
 */
public class ServiceDao {
    private String code_;
    private String designation;
    private float pu_;
    private String type_o;
    private String status;

    public ServiceDao(String code_, String designation, float pu_, String type_o, String status) {
        this.code_ = code_;
        this.designation = designation;
        this.pu_ = pu_;
        this.type_o = type_o;
        this.status = status;
    }

    public ServiceDao() {
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
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the pu_
     */
    public float getPu_() {
        return pu_;
    }

    /**
     * @param pu_ the pu_ to set
     */
    public void setPu_(float pu_) {
        this.pu_ = pu_;
    }

    /**
     * @return the type_o
     */
    public String getType_o() {
        return type_o;
    }

    /**
     * @param type_o the type_o to set
     */
    public void setType_o(String type_o) {
        this.type_o = type_o;
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

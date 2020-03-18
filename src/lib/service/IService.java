/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import java.util.List;

/**
 *
 * @author Akim
 */
public interface IService {
    boolean Enregistrer(ServiceDao service);
    List<ServiceDao> service();
}

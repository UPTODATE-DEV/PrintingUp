/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.client;

import java.util.List;

/**
 *
 * @author Akim
 */
public interface IClient {

    void Enregistrer(ClientDao client);

    List<Object> client();
}

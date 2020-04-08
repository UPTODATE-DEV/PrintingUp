/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.user;

import javafx.scene.control.ListView;

/**
 *
 * @author Akim
 */
public interface IUser {

    void ajouter(UserDao user);

    void modifier(UserDao user);

    void retire(UserDao user);

    ListView<UserDao> list();
}

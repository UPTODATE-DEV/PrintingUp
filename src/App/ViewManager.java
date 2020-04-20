/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 *
 * @author Akim
 */
public class ViewManager {
        private static ViewManager instance;
    private static final HashMap<String, Node> SCREENS = new HashMap<>();
    private static String nameView;

    private ViewManager(){}

    public static ViewManager getInstance() {
        if(instance == null){
            instance =  new ViewManager();
        }
        return instance;
    }

    public void put(String name, Node node){
        nameView = name;
        SCREENS.put(name, node);
    }

    public Node get(String view){
        return SCREENS.get(view);
    }

    public int getSize(){
        return SCREENS.size();
    }

    Node getCurrentView(){
        return SCREENS.get(nameView);
    }

    public ObservableList<Node> getAll(){
        return FXCollections.observableArrayList(SCREENS.values());
    }
}

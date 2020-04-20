/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis.parametrer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author Akim
 */
public class SectionManager {
    public static Section get(){
        try {
            File file = new File("dashboard.properties");
            Properties properties = new Properties();

            if(!file.exists()){
                file.createNewFile();
            }
            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);

            return new Section(Boolean.valueOf(properties.getProperty("logged")), properties.getProperty("userLogged"));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void save(Section section) {
        try {
            File file = new File("dashboard.properties");
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            FileOutputStream outputStream = new FileOutputStream(file);
            properties.setProperty("logged", String.valueOf(section.isLogged()));
            properties.setProperty("userLogged", section.getUserLogged());
            properties.store(outputStream, "Update Section");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

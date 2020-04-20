/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.entreprise_;

import java.util.ArrayList;

/**
 *
 * @author Akim
 */
public interface IEntreprise {
    boolean save(FEntreprise entreprise);
    boolean update(FEntreprise entreprise);
    boolean delete(FEntreprise entreprise);
    ArrayList<String> FetchLoading();
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsm;

import dsm.repository.SimpleRepositoryParser;


/**
 *
 * @author morteza
 */
public class DSM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SimpleRepositoryParser rp = new SimpleRepositoryParser();
            
            rp.loadRepositoryFromFile("configurations/Repositories.xml");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

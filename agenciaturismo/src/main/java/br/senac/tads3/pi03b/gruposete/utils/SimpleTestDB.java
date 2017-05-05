/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.gruposete.utils;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danimo
 */
public class SimpleTestDB {
    
    public static void main(String[] args) {
        try {
            Connection con = DbUtil.getConnection();
            System.out.println("Conectou");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SimpleTestDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DOESNT");
        }
    }
    
}

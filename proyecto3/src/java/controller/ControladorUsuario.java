/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDAO;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author cesar
 */
public class ControladorUsuario {
    
    public boolean validate(Usuario u){
        boolean valid = false;
        try {
            LoginDAO log = new LoginDAO();
            valid = log.autenticationUser(u);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return valid;
    }
}

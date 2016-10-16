/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.UsuarioLoginDAO;
import DTO.UsuarioLogin;

/**
 *
 * @author Francisco
 */
public class VentanaPrincipalControlador {
        UsuarioLoginDAO ulogdao = new UsuarioLoginDAO();
       
        public boolean borrarLogin(UsuarioLogin ulog){
        if(ulogdao.usuarioLogin_Del(ulog)){
            return true;
        } else {
            return false;
        }
    }
        
        public boolean actualizarLogin(UsuarioLogin ulog){
        if(ulogdao.usuarioLogin_Upd(ulog)){
            return true;
        } else {
            return false;
        }
    }
}

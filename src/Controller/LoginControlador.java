/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioLoginDAO;
import DTO.Usuario;
import DTO.UsuarioLogin;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author Francisco
 */
public class LoginControlador {
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioLoginDAO ulogdao = new UsuarioLoginDAO();

    public String hash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//
//        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
//        crypt.reset();
//        crypt.update(password.getBytes("UTF-8"));
//
//        return new BigInteger(1, crypt.digest()).toString(16);
        
         MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(password.getBytes());        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
    
    public Usuario loginUsuario(String user, String password, int perfil){
        
        Usuario u = udao.LoginUsuario(user, password, perfil);
        if(u!=null){
            return u;
        }
        else {
            return null;
        }
    }
    
    public boolean registrarLogin(UsuarioLogin ulog){
        if(ulogdao.usuarioLogin_Ins(ulog)){
            return true;
        } else {
            return false;
        }
    }
    
        public boolean validarSesiones(String rut){
        if(ulogdao.usuarioLogin_cumpleSesionesMaxima(rut)){
            return true;
        } else {
            return false;
        }
    }

}

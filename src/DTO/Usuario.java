/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Francisco
 */
public class Usuario {
    private String rut;
    private String pass;
    private int id_tipo_perfil;

    public Usuario() {
    }

    public Usuario(String rut, String pass, int id_tipo_perfil) {
        this.rut = rut;
        this.pass = pass;
        this.id_tipo_perfil = id_tipo_perfil;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_tipo_perfil() {
        return id_tipo_perfil;
    }

    public void setId_tipo_perfil(int id_tipo_perfil) {
        this.id_tipo_perfil = id_tipo_perfil;
    }
    
    
}

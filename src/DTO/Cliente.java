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
public class Cliente {
//    <RUT1>16985608</RUT1>
//                     <DV>7</DV>
//                     <NOMBRE>Francisco</NOMBRE>
//                     <APELLIDO>Fuentes</APELLIDO>
//                     <SEXO>M</SEXO>
//                     <CORREO>dyic@dyic.cl</CORREO>
//                     <TELEFONO>256256258</TELEFONO>
//                     <BLOQUEADO>0</BLOQUEADO>

    private String rut;
    private char dv;
    private String nombre;
    private String apellido;
    private char sexo;
    private String correo;
    private int telefono;
    private int bloqueado;

    public Cliente() {
    }

    public Cliente(String rut, char dv, String nombre, String apellido, char sexo, String correo, int telefono, int bloqueado) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.correo = correo;
        this.telefono = telefono;
        this.bloqueado = bloqueado;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }
    
    
}

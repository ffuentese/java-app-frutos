/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Windows 7
 */
public class Productor {
    private int rut;
    private char dv;
    private String nombre;
    private String apellido;
    private char sexo;
    private int id_direccion_particular;
    private int telefono;
    private String correo;
    private int id_direccion_negocio;
    private int misma_direccion;

    public Productor() {
    }

    public Productor(int rut, char dv, String nombre, String apellido, char sexo, int id_direccion_particular, int telefono, String correo, int id_direccion_negocio, int misma_direccion) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.id_direccion_particular = id_direccion_particular;
        this.telefono = telefono;
        this.correo = correo;
        this.id_direccion_negocio = id_direccion_negocio;
        this.misma_direccion = misma_direccion;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
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

    public int getId_direccion_particular() {
        return id_direccion_particular;
    }

    public void setId_direccion_particular(int id_direccion_particular) {
        this.id_direccion_particular = id_direccion_particular;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_direccion_negocio() {
        return id_direccion_negocio;
    }

    public void setId_direccion_negocio(int id_direccion_negocio) {
        this.id_direccion_negocio = id_direccion_negocio;
    }

    public int getMisma_direccion() {
        return misma_direccion;
    }

    public void setMisma_direccion(int misma_direccion) {
        this.misma_direccion = misma_direccion;
    }

    
}

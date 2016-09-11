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
    private String rut;
    private String dv;
    private String nombre;
    private String apellido;
    private String sexo;
    private String id_direccion_negocio;
    private String id_direccion_particular;
    private String direccion_particular;
    private String numero_particular;
    private String comuna_particular;
    private String telefono;
    private String correo;
    private String direccion_negocio;
    private String numero_negocio;
    private String comuna_negocio;
    private String misma_direccion;
    private String id_regionparticular;
    private String regionparticular;
    private String id_regioncomercial;
    private String regioncomercial;

    public Productor() {
    }

    public Productor(String rut, String dv, String nombre, String apellido, String sexo, String id_direccion_negocio, String id_direccion_particular, String direccion_particular, String numero_particular, String comuna_particular, String telefono, String correo, String direccion_negocio, String numero_negocio, String comuna_negocio, String misma_direccion, String id_regioncomercial, String regioncomercial,String id_regionparticular, String regionparticular) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.id_direccion_negocio = id_direccion_negocio;
        this.id_direccion_particular = id_direccion_particular;
        this.direccion_particular = direccion_particular;
        this.numero_particular = numero_particular;
        this.comuna_particular = comuna_particular;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion_negocio = direccion_negocio;
        this.numero_negocio = numero_negocio;
        this.comuna_negocio = comuna_negocio;
        this.misma_direccion = misma_direccion;
        this.id_regionparticular = id_regionparticular;
        this.regionparticular = regionparticular;
        this.id_regioncomercial = id_regioncomercial;
        this.regioncomercial = regioncomercial;
    }

    
    
    public Productor(String rut, String dv, String nombre, String apellido, String sexo, String id_direccion_negocio, String id_direccion_particular, String direccion_particular, String numero_particular, String comuna_particular, String telefono, String correo, String direccion_negocio, String numero_negocio, String comuna_negocio, String misma_direccion) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.id_direccion_negocio = id_direccion_negocio;
        this.id_direccion_particular = id_direccion_particular;
        this.direccion_particular = direccion_particular;
        this.numero_particular = numero_particular;
        this.comuna_particular = comuna_particular;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion_negocio = direccion_negocio;
        this.numero_negocio = numero_negocio;
        this.comuna_negocio = comuna_negocio;
        this.misma_direccion = misma_direccion;
    }
    
    public Productor(String rut, String dv, String nombre, String apellido, String sexo, String direccion_particular, String numero_particular, String comuna_particular, String telefono, String correo, String direccion_negocio, String numero_negocio, String comuna_negocio, String misma_direccion) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.direccion_particular = direccion_particular;
        this.numero_particular = numero_particular;
        this.comuna_particular = comuna_particular;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion_negocio = direccion_negocio;
        this.numero_negocio = numero_negocio;
        this.comuna_negocio = comuna_negocio;
        this.misma_direccion = misma_direccion;
    }

    public String getId_regionparticular() {
        return id_regionparticular;
    }

    public void setId_regionparticular(String id_regionparticular) {
        this.id_regionparticular = id_regionparticular;
    }

    public String getRegionparticular() {
        return regionparticular;
    }

    public void setRegionparticular(String regionparticular) {
        this.regionparticular = regionparticular;
    }

    public String getId_regioncomercial() {
        return id_regioncomercial;
    }

    public void setId_regioncomercial(String id_regioncomercial) {
        this.id_regioncomercial = id_regioncomercial;
    }

    public String getRegioncomercial() {
        return regioncomercial;
    }

    public void setRegioncomercial(String regioncomercial) {
        this.regioncomercial = regioncomercial;
    }
    
    public String getId_direccion_particular() {
        return id_direccion_particular;
    }

    public void setId_direccion_particular(String id_direccion_particular) {
        this.id_direccion_particular = id_direccion_particular;
    }
    
    public String getId_direccion_negocio() {
        return id_direccion_negocio;
    }

    public void setId_direccion_negocio(String id_direccion_negocio) {
        this.id_direccion_negocio = id_direccion_negocio;
    }
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion_particular() {
        return direccion_particular;
    }

    public void setDireccion_particular(String direccion_particular) {
        this.direccion_particular = direccion_particular;
    }

    public String getNumero_particular() {
        return numero_particular;
    }

    public void setNumero_particular(String numero_particular) {
        this.numero_particular = numero_particular;
    }

    public String getComuna_particular() {
        return comuna_particular;
    }

    public void setComuna_particular(String comuna_particular) {
        this.comuna_particular = comuna_particular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion_negocio() {
        return direccion_negocio;
    }

    public void setDireccion_negocio(String direccion_negocio) {
        this.direccion_negocio = direccion_negocio;
    }

    public String getNumero_negocio() {
        return numero_negocio;
    }

    public void setNumero_negocio(String numero_negocio) {
        this.numero_negocio = numero_negocio;
    }

    public String getComuna_negocio() {
        return comuna_negocio;
    }

    public void setComuna_negocio(String comuna_negocio) {
        this.comuna_negocio = comuna_negocio;
    }

    public String getMisma_direccion() {
        return misma_direccion;
    }

    public void setMisma_direccion(String misma_direccion) {
        this.misma_direccion = misma_direccion;
    }

    

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    
}

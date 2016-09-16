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
public class Producto {
    private int id_producto;
    private int rut_productor;
    private int id_tipo_producto;
    private int oferta;
    private String descripcion;
    private int id_direccion;
    private String zona_cultivo;
    private int stock;
    private int precio;
    private int id_medida;
    private int id_tipo_cultivo;
    private int activo;

    public Producto() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getRut_productor() {
        return rut_productor;
    }

    public void setRut_productor(int rut_productor) {
        this.rut_productor = rut_productor;
    }

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getZona_cultivo() {
        return zona_cultivo;
    }

    public void setZona_cultivo(String zona_cultivo) {
        this.zona_cultivo = zona_cultivo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_medida() {
        return id_medida;
    }

    public void setId_medida(int id_medida) {
        this.id_medida = id_medida;
    }

    public int getId_tipo_cultivo() {
        return id_tipo_cultivo;
    }

    public void setId_tipo_cultivo(int id_tipo_cultivo) {
        this.id_tipo_cultivo = id_tipo_cultivo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
    
}

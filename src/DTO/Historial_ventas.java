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
public class Historial_ventas {
    private String nombre_producto;
    private String tipo_producto;
    private String tipo_unidad;
    private String precio_unitario;
    private String cantidad;
    private String precio_final;
    private String num_venta;
    private String nombre_cliente;

    public Historial_ventas() {
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getTipo_unidad() {
        return tipo_unidad;
    }

    public void setTipo_unidad(String tipo_unidad) {
        this.tipo_unidad = tipo_unidad;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio_final() {
        return precio_final;
    }

    public void setPrecio_final(String precio_final) {
        this.precio_final = precio_final;
    }

    public String getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(String num_venta) {
        this.num_venta = num_venta;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    
}

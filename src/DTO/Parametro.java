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
public class Parametro {
    private int id_parametro;
    private String nombre;
    private String valor1;
    private String valor2;

    public Parametro() {
    }

    public int getId_parametro() {
        return id_parametro;
    }

    public void setId_parametro(int id_parametro) {
        this.id_parametro = id_parametro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }
    
    
}

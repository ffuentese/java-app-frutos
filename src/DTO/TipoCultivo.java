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
public class TipoCultivo {
    private int id_tipo_cultivo;
    private String nombre;

    public TipoCultivo() {
    }

    public int getId_tipo_cultivo() {
        return id_tipo_cultivo;
    }

    public void setId_tipo_cultivo(int id_tipo_cultivo) {
        this.id_tipo_cultivo = id_tipo_cultivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id_tipo_cultivo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoCultivo other = (TipoCultivo) obj;
        if (this.id_tipo_cultivo != other.id_tipo_cultivo) {
            return false;
        }
        return true;
    }
    
    
    
}

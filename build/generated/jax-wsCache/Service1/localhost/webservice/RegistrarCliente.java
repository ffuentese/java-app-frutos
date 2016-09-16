
package localhost.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dv" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexo" type="{http://microsoft.com/wsdl/types/}char"/>
 *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_direccionparticular" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_comuna" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rut",
    "dv",
    "nombre",
    "apellido",
    "sexo",
    "correo",
    "telefono",
    "idDireccionparticular",
    "idComuna"
})
@XmlRootElement(name = "registrarCliente")
public class RegistrarCliente {

    protected int rut;
    protected int dv;
    protected String nombre;
    protected String apellido;
    protected int sexo;
    protected String correo;
    protected int telefono;
    @XmlElement(name = "id_direccionparticular")
    protected int idDireccionparticular;
    @XmlElement(name = "id_comuna")
    protected int idComuna;

    /**
     * Obtiene el valor de la propiedad rut.
     * 
     */
    public int getRut() {
        return rut;
    }

    /**
     * Define el valor de la propiedad rut.
     * 
     */
    public void setRut(int value) {
        this.rut = value;
    }

    /**
     * Obtiene el valor de la propiedad dv.
     * 
     */
    public int getDv() {
        return dv;
    }

    /**
     * Define el valor de la propiedad dv.
     * 
     */
    public void setDv(int value) {
        this.dv = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Define el valor de la propiedad apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad sexo.
     * 
     */
    public int getSexo() {
        return sexo;
    }

    /**
     * Define el valor de la propiedad sexo.
     * 
     */
    public void setSexo(int value) {
        this.sexo = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreo(String value) {
        this.correo = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     */
    public void setTelefono(int value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad idDireccionparticular.
     * 
     */
    public int getIdDireccionparticular() {
        return idDireccionparticular;
    }

    /**
     * Define el valor de la propiedad idDireccionparticular.
     * 
     */
    public void setIdDireccionparticular(int value) {
        this.idDireccionparticular = value;
    }

    /**
     * Obtiene el valor de la propiedad idComuna.
     * 
     */
    public int getIdComuna() {
        return idComuna;
    }

    /**
     * Define el valor de la propiedad idComuna.
     * 
     */
    public void setIdComuna(int value) {
        this.idComuna = value;
    }

}

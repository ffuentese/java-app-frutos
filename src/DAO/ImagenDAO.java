/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Imagen;
import DTO.Medida;
import DTO.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Francisco
 */
public class ImagenDAO {

    public boolean SubirImagen(File f, String filename) {
        try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestSubirImagen(f, filename), url);

            // Recibe la respuesta SOAP y la procesa.
            String result = getSOAPResponseSubirImagen(soapResponse);
//            System.out.println("RESULT " + result);
            soapConnection.close();
            if ("OK".equals(result)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
            return false;
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }

    }

    private SOAPMessage createSOAPRequestSubirImagen(File f, String filename) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://localhost/WebService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", serverURI);

        /*
         Constructed SOAP Request Message:
         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
         <SOAP-ENV:Header/>
         <SOAP-ENV:Body>
         <example:VerifyEmail>
         <example:email>mutantninja@gmail.com</example:email>
         <example:LicenseKey>123</example:LicenseKey>
         </example:VerifyEmail>
         </SOAP-ENV:Body>
         </SOAP-ENV:Envelope>
         */
        // SOAP Body
        String imagen = Base64.encodeBase64String(Files.readAllBytes(f.toPath()));
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("SubirArchivo", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("f", "web");
        soapBodyElem1.addTextNode(imagen);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("fileName", "web");
        soapBodyElem2.addTextNode(filename);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/SubirArchivo");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private String getSOAPResponseSubirImagen(SOAPMessage soapResponse) throws Exception {
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "SubirArchivo");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("SubirArchivoResult");
        String result = nl.item(0).getFirstChild().getNodeValue();
        return result;
    }

    public byte[] ObtenerImagen(String filename) {
        try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestObtenerImagen(filename), url);

            // Recibe la respuesta SOAP y la procesa.
            byte[] imagen = getSOAPResponseObtenerImagen(soapResponse);
//            System.out.println("RESULT " + result);
            soapConnection.close();
            return imagen;

        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
            return null;
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }

    }

    private SOAPMessage createSOAPRequestObtenerImagen(String filename) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://localhost/WebService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", serverURI);

        /*
         Constructed SOAP Request Message:
         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
         <SOAP-ENV:Header/>
         <SOAP-ENV:Body>
         <example:VerifyEmail>
         <example:email>mutantninja@gmail.com</example:email>
         <example:LicenseKey>123</example:LicenseKey>
         </example:VerifyEmail>
         </SOAP-ENV:Body>
         </SOAP-ENV:Envelope>
         */
        // SOAP Body
//        String imagen = Base64.encodeBase64String(Files.readAllBytes(f.toPath()));
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("ObtenerImagen", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("fileName", "web");
        soapBodyElem1.addTextNode(filename);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/ObtenerImagen");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private byte[] getSOAPResponseObtenerImagen(SOAPMessage soapResponse) throws Exception {
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "ObtenerImagen");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("ObtenerImagenResult");
        byte[] imagen = Base64.decodeBase64(nl.item(0).getFirstChild().getNodeValue());
        return imagen;
    }

    // Métodos base de datos
    public boolean Update(Imagen img) {
        try {
            //Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestUpdImagen(img), url);

            // Recibe la respuesta SOAP y la procesa.
            String result = getSOAPResponseUpdImagen(soapResponse);

            soapConnection.close();
            if (result != null) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la conexión.");
            e.printStackTrace();
            return false;
        }
    }

    private SOAPMessage createSOAPRequestUpdImagen(Imagen p) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://localhost/WebService";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", serverURI);

        /*
         Constructed SOAP Request Message:
         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
         <SOAP-ENV:Header/>
         <SOAP-ENV:Body>
         <example:VerifyEmail>
         <example:email>mutantninja@gmail.com</example:email>
         <example:LicenseKey>123</example:LicenseKey>
         </example:VerifyEmail>
         </SOAP-ENV:Body>
         </SOAP-ENV:Envelope>
         */
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("Imagenes_Upd", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id_producto", "web");
        soapBodyElem1.addTextNode(Integer.toString(p.getId_producto()));
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("nombre", "web");
        soapBodyElem2.addTextNode(p.getNombre());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("descripcion", "web");
        soapBodyElem3.addTextNode(p.getDescripcion());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("orden", "web");
        soapBodyElem4.addTextNode(Integer.toString((p.getOrden())));
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("fecha", "web");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String date = sdf.format(p.getFecha());
        soapBodyElem5.addTextNode(date);
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("ubicacion", "web");
        soapBodyElem6.addTextNode(p.getUbicacion());
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Imagenes_Upd");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private String getSOAPResponseUpdImagen(SOAPMessage soapResponse) throws Exception {
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Imagen_upd");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("Imagenes_UpdResult");
        String response = nl.item(0).getFirstChild().getNodeValue();
        return response;
    }

    // insertar datos de imagen en base de datos.
    public boolean create(Imagen img) {
        try {
            //Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestInsImagen(img), url);

            // Recibe la respuesta SOAP y la procesa.
            String result = getSOAPResponseInsImagen(soapResponse);

            soapConnection.close();
            if (result != null) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la conexión.");
            e.printStackTrace();
            return false;
        }
    }

    private SOAPMessage createSOAPRequestInsImagen(Imagen p) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://localhost/WebService";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", serverURI);

        /*
         Constructed SOAP Request Message:
         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
         <SOAP-ENV:Header/>
         <SOAP-ENV:Body>
         <example:VerifyEmail>
         <example:email>mutantninja@gmail.com</example:email>
         <example:LicenseKey>123</example:LicenseKey>
         </example:VerifyEmail>
         </SOAP-ENV:Body>
         </SOAP-ENV:Envelope>
         */
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("Imagenes_Ins", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id_producto", "web");
        soapBodyElem1.addTextNode(Integer.toString(p.getId_producto()));
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("nombre", "web");
        soapBodyElem2.addTextNode(p.getNombre());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("descripcion", "web");
        soapBodyElem3.addTextNode(p.getDescripcion());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("orden", "web");
        soapBodyElem4.addTextNode(Integer.toString((p.getOrden())));
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("fecha", "web");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String date = sdf.format(p.getFecha());
        System.out.println(date);
        soapBodyElem5.addTextNode(date);
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("ubicacion", "web");
        soapBodyElem6.addTextNode(p.getUbicacion());
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Imagenes_Ins");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private String getSOAPResponseInsImagen(SOAPMessage soapResponse) throws Exception {
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Imagenes_Ins");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("Imagenes_InsResult");
        String response = nl.item(0).getFirstChild().getNodeValue();
        return response;
    }

    // Seleccionar imagen
    public Imagen getImagen(int id_prod) {
        try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestGetImagen(id_prod), url);

            // Recibe la respuesta SOAP y la procesa.
            Imagen img = getSOAPResponseGetImagen(soapResponse);

            soapConnection.close();
            return img;
        } catch (Exception e) {
            System.err.println("Hubo un error en la conexión con el webservice");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
        return null;
    }

    private SOAPMessage createSOAPRequestGetImagen(int id_prod) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://localhost/WebService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", serverURI);

        /*
         Constructed SOAP Request Message:
         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
         <SOAP-ENV:Header/>
         <SOAP-ENV:Body>
         <example:VerifyEmail>
         <example:email>mutantninja@gmail.com</example:email>
         <example:LicenseKey>123</example:LicenseKey>
         </example:VerifyEmail>
         </SOAP-ENV:Body>
         </SOAP-ENV:Envelope>
         */
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("Imagenes_Sel", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id", "web");
        soapBodyElem1.addTextNode(Integer.toString(id_prod));

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Imagenes_Sel");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private Imagen getSOAPResponseGetImagen(SOAPMessage soapResponse) throws Exception {
        ArrayList<Imagen> arrimg = new ArrayList<>();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Imagenes_Sel");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//IMAGENES").evaluate(XMLDoc, XPathConstants.NODESET);
        Imagen ima = new Imagen();
        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :"
//                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
//                System.out.println("COMUNA : "
//                        + eElement.getAttribute("msdata:rowOrder"));
                int val = Integer.parseInt(eElement.getAttribute("msdata:rowOrder"));
//                usu.setRut(eElement.getElementsByTagName("RUT").item(0).getTextContent());
//                usu.setPass(eElement.getElementsByTagName("CONTRASENA").item(0).getTextContent());
//                usu.setId_tipo_perfil(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PERFIL").item(0).getTextContent()));

                ima.setId_producto(Integer.parseInt(eElement.getElementsByTagName("ID_PRODUCTO").item(0).getTextContent()));
                ima.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
                ima.setDescripcion(eElement.getElementsByTagName("DESCRIPCION").item(0).getTextContent());
                ima.setOrden(Integer.parseInt(eElement.getElementsByTagName("ORDEN").item(0).getTextContent()));
                String fecha = (eElement.getElementsByTagName("FECHA").item(0).getTextContent());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                ima.setFecha(sdf.parse(fecha));
                ima.setUbicacion(eElement.getElementsByTagName("UBICACION").item(0).getTextContent());

            }

        }
        return ima;
    }

}

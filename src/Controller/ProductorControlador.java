/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.Direccion;
import DTO.Productor;
import DTO.Usuario;
import Vistas.Listar_Productores;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Node;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Windows 7
 */
public class ProductorControlador {
    
    ArrayList<Productor> arrproductor=new ArrayList<>();
    ArrayList<Direccion> arrdireccion= new ArrayList<>();
    
    public ArrayList<Productor> listaProductores(){
         try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            String url = "http://localhost:49193/Service1.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestListaProd(), url);

 
            // Recibe la respuesta SOAP y la procesa.
            arrproductor = getSOAPResponseListaProd(soapResponse);
            
            
            

            soapConnection.close();
            return arrproductor;
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
         return null;
    }
    
    private SOAPMessage createSOAPRequestListaProd() throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("Productor_Sel_All", "web");
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Productor_Sel_All");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }
    
    private ArrayList<Productor> getSOAPResponseListaProd(SOAPMessage soapResponse) throws Exception {
        Productor pro = new Productor();
        ArrayList<Productor> arrpro = new ArrayList<>();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Productor_Sel_All");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//Productor").evaluate(XMLDoc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
            System.out.println("\nCurrent Element :"
                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Productor : "
                        + eElement.getAttribute("msdata:rowOrder"));
//                usu.setRut(eElement.getElementsByTagName("RUT").item(0).getTextContent());
//                usu.setPass(eElement.getElementsByTagName("CONTRASENA").item(0).getTextContent());
//                usu.setId_tipo_perfil(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PERFIL").item(0).getTextContent()));
//                cli.setRut(eElement.getElementsByTagName("RUT").item(0).getTextContent());
//                cli.setDv(eElement.getElementsByTagName("DV").item(0).getTextContent().charAt(0));
//                cli.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
//                cli.setApellido(eElement.getElementsByTagName("APELLIDO").item(0).getTextContent());
//                cli.setSexo(eElement.getElementsByTagName("SEXO").item(0).getTextContent().charAt(0));
//                cli.setCorreo(eElement.getElementsByTagName("CORREO").item(0).getTextContent());
//                cli.setTelefono(Integer.parseInt(eElement.getElementsByTagName("TELEFONO").item(0).getTextContent()));
//                cli.setBloqueado(eElement.getElementsByTagName("BLOQUEADO").item(0).getTextContent().charAt(0));
                pro.setRut(Integer.parseInt(eElement.getElementsByTagName("RUT").item(0).getTextContent()));
                pro.setDv(eElement.getElementsByTagName("DV").item(0).getTextContent().charAt(0));
                pro.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
                pro.setApellido(eElement.getElementsByTagName("APELLIDO").item(0).getTextContent());
                pro.setSexo(eElement.getElementsByTagName("SEXO").item(0).getTextContent().charAt(0));
                pro.setId_direccion_particular(Integer.parseInt(eElement.getElementsByTagName("ID_DIRECCIONPARTICULAR").item(0).getTextContent()));
                pro.setTelefono(Integer.parseInt(eElement.getElementsByTagName("TELEFONO").item(0).getTextContent()));
                pro.setCorreo(eElement.getElementsByTagName("CORREO").item(0).getTextContent());
                pro.setId_direccion_negocio(Integer.parseInt(eElement.getElementsByTagName("ID_DIRECCIONNEGOCIO").item(0).getTextContent()));
                pro.setMisma_direccion(Integer.parseInt(eElement.getElementsByTagName("MISMADIRECCION").item(0).getTextContent()));
            }
             arrpro.add(pro);
        }
        return arrpro;
    }
    
    private ArrayList<Direccion> getSOAPResponseListaDireccion(SOAPMessage soapResponse) throws Exception {
        Direccion dir = new Direccion();
        ArrayList<Direccion> arrpro = new ArrayList<>();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Direcciones_Sel_All");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//Direcciones").evaluate(XMLDoc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
            System.out.println("\nCurrent Element :"
                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Direccion : "
                        + eElement.getAttribute("msdata:rowOrder"));
                dir.setId_direccion(Integer.parseInt(eElement.getElementsByTagName("ID_DIRECCION").item(0).getTextContent()));
                dir.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
                dir.setNumero(eElement.getElementsByTagName("NUMERO").item(0).getTextContent());
                dir.setId_comuna(Integer.parseInt(eElement.getElementsByTagName("ID_COMUNA").item(0).getTextContent()));
                dir.setCoordenadaX(eElement.getElementsByTagName("COORDENADA_X").item(0).getTextContent());
                dir.setCoordenadaX(eElement.getElementsByTagName("CORRDENADA_Y").item(0).getTextContent());
//                pro.setRut(Integer.parseInt(eElement.getElementsByTagName("RUT").item(0).getTextContent()));
//                pro.setDv(eElement.getElementsByTagName("DV").item(0).getTextContent().charAt(0));
//                pro.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
//                pro.setApellido(eElement.getElementsByTagName("APELLIDO").item(0).getTextContent());
//                pro.setSexo(eElement.getElementsByTagName("SEXO").item(0).getTextContent().charAt(0));
//                pro.setId_direccion_particular(Integer.parseInt(eElement.getElementsByTagName("ID_DIRECCIONPARTICULAR").item(0).getTextContent()));
//                pro.setTelefono(Integer.parseInt(eElement.getElementsByTagName("TELEFONO").item(0).getTextContent()));
//                pro.setCorreo(eElement.getElementsByTagName("CORREO").item(0).getTextContent());
//                pro.setId_direccion_negocio(Integer.parseInt(eElement.getElementsByTagName("ID_DIRECCIONNEGOCIO").item(0).getTextContent()));
//                pro.setMisma_direccion(Integer.parseInt(eElement.getElementsByTagName("MISMADIRECCION").item(0).getTextContent()));
            }
             arrdireccion.add(dir);
                     }
        return arrdireccion;
    }
    
    private SOAPMessage createSOAPRequestListaDireccion() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://localhost/WebService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("Direcciones_Sel_All", "web");
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Direcciones_Sel_All");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }
    
    public ArrayList<Direccion> listaDirecciones(){
         try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            String url = "http://localhost:49193/Service1.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestListaDireccion(), url);

 
            // Recibe la respuesta SOAP y la procesa.
            arrdireccion = getSOAPResponseListaDireccion(soapResponse);
            
            
            

            soapConnection.close();
            return arrdireccion;
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
         return null;
    }
}

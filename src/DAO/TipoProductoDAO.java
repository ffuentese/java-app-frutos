/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.TipoCultivo;
import DTO.TipoProducto;
import java.io.FileInputStream;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Francisco
 */
public class TipoProductoDAO {
     public ArrayList<TipoProducto> listaTipoProducto(){
        ArrayList<TipoProducto> arrtipopro = new ArrayList<>();
        
         try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
             Properties props = new Properties();
          props.load(new FileInputStream("ws.properties"));
    
        String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestListaTipoProducto(), url);

 
            // Recibe la respuesta SOAP y la procesa.
            arrtipopro = getSOAPResponseListaTipoProducto(soapResponse);
            
            
            

            soapConnection.close();
            return arrtipopro;
        } catch (Exception e) {
            System.err.println("Hubo un error en la conexión con el webservice");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
         return arrtipopro;
    }
    
    
    private SOAPMessage createSOAPRequestListaTipoProducto() throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("Tipo_Producto_Sel_All", "web");
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Tipo_Producto_Sel_All");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }
    
    private ArrayList<TipoProducto> getSOAPResponseListaTipoProducto(SOAPMessage soapResponse) throws Exception {
        ArrayList<TipoProducto> arrtprod = new ArrayList<>();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Tipo_Producto_Sel_All");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//TipoProducto").evaluate(XMLDoc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :"
//                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
//                System.out.println("COMUNA : "
//                        + eElement.getAttribute("msdata:rowOrder"));
                int val = Integer.parseInt(eElement.getAttribute("msdata:rowOrder"));
                TipoProducto tpr = new TipoProducto();
//                usu.setRut(eElement.getElementsByTagName("RUT").item(0).getTextContent());
//                usu.setPass(eElement.getElementsByTagName("CONTRASENA").item(0).getTextContent());
//                usu.setId_tipo_perfil(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PERFIL").item(0).getTextContent()));
                tpr.setId_tipo_producto(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PRODUCTO").item(0).getTextContent()));
                tpr.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
                arrtprod.add(tpr);
            }
             
        }
        return arrtprod;
    }
    
    // Test
        public TipoProducto getTipoProducto(int id_tipo) {
        try {
            //Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
             Properties props = new Properties();
          props.load(new FileInputStream("ws.properties"));
    
        String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestGetTipoProducto(id_tipo), url);

            // Recibe la respuesta SOAP y la procesa.
            TipoProducto result = getSOAPResponseGetTipoProducto(soapResponse);

            soapConnection.close();
            return result;

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la conexión.");
            e.printStackTrace();
            return null;
        }
    }

    private SOAPMessage createSOAPRequestGetTipoProducto(int id_tipo) throws Exception {
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
        TipoProducto p = new TipoProducto();
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("Tipo_Producto_Sel", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id", "web");
        soapBodyElem1.addTextNode(Integer.toString(id_tipo));
//        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("NOMBRE", "web");
//        soapBodyElem2.addTextNode(p.getNombre());
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Tipo_Producto_Sel");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private TipoProducto getSOAPResponseGetTipoProducto(SOAPMessage soapResponse) throws Exception {
        TipoProducto tpr = new TipoProducto();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Tipo_Producto_Sel");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//TipoProducto").evaluate(XMLDoc, XPathConstants.NODESET);
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
                tpr.setId_tipo_producto(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PRODUCTO").item(0).getTextContent()));
                tpr.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
//                return tcu;
                
            }
             
        }
        return tpr;
    }
}

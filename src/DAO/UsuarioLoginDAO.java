/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UsuarioLogin;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class UsuarioLoginDAO {

    public boolean usuarioLogin_Ins(UsuarioLogin ulog) {
        try {
            //Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestUlogIns(ulog), url);

            // Recibe la respuesta SOAP y la procesa.
//            String result = getSOAPResponseUlogIns(soapResponse);

            soapConnection.close();
            return true;
//            if (result != null) {
//                return true;
//            } else {
//                return false;
//            }

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la conexión.");
            e.printStackTrace();
            return false;
        }
    }

    private SOAPMessage createSOAPRequestUlogIns(UsuarioLogin ulog) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("usuarioLogin_Ins", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("RUT", "web");
        soapBodyElem1.addTextNode(ulog.getRut());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("FECHA", "web");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String date = sdf.format(ulog.getFecha());
        soapBodyElem2.addTextNode(date);
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("VALOR1", "web");
        soapBodyElem3.addTextNode(ulog.getValor1());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("VALOR2", "web");
        soapBodyElem4.addTextNode(ulog.getValor2());
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("VALOR3", "web");
        soapBodyElem5.addTextNode(ulog.getValor3());
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("VALOR4", "web");
        soapBodyElem6.addTextNode(ulog.getValor4());
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("VALOR5", "web");
        soapBodyElem7.addTextNode(ulog.getValor5());
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("SISTEMA", "web");
        soapBodyElem8.addTextNode(ulog.getSistema());        
//        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("NOMBRE", "web");
//        soapBodyElem2.addTextNode(p.getNombre());
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/usuarioLogin_Ins");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private String getSOAPResponseUlogIns(SOAPMessage soapResponse) throws Exception {
        UsuarioLogin ulog = new UsuarioLogin();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "usuarioLogin_Ins");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("usuarioLogin_InsResult");
        String result = nl.item(0).getFirstChild().getNodeValue();
        return result;

    }
    
    public boolean usuarioLogin_Del(UsuarioLogin ulog) {
        try {
            //Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestUlogDel(ulog), url);

            // Recibe la respuesta SOAP y la procesa.
//            String result = getSOAPResponseUlogDel(soapResponse);

            soapConnection.close();
            return true;
//            if (result != null) {
//                return true;
//            } else {
//                return false;
//            }

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la conexión.");
            e.printStackTrace();
            return false;
        }
    }

    private SOAPMessage createSOAPRequestUlogDel(UsuarioLogin ulog) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("usuarioLogin_del", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("RUT", "web");
        soapBodyElem1.addTextNode(ulog.getRut());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("VALOR4", "web");
        soapBodyElem2.addTextNode(ulog.getValor4());
//        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("NOMBRE", "web");
//        soapBodyElem2.addTextNode(p.getNombre());
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/usuarioLogin_del");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private String getSOAPResponseUlogDel(SOAPMessage soapResponse) throws Exception {
        UsuarioLogin ulog = new UsuarioLogin();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "usuarioLogin_del");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("usuarioLogin_DelResult");
        String result = nl.item(0).getFirstChild().getNodeValue();
        return result;

    }
    
    public boolean usuarioLogin_Upd(UsuarioLogin ulog) {
        try {
            //Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            ulog.setFecha(new Date());
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestUlogUpd(ulog), url);

            // Recibe la respuesta SOAP y la procesa.
//            String result = getSOAPResponseUlogUpd(soapResponse);

            soapConnection.close();
            return true;
//            if (result != null) {
//                return true;
//            } else {
//                return false;
//            }

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en la conexión.");
            e.printStackTrace();
            return false;
        }
    }

    private SOAPMessage createSOAPRequestUlogUpd(UsuarioLogin ulog) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("usuarioLogin_upd", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("RUT", "web");
        soapBodyElem1.addTextNode(ulog.getRut());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("FECHA", "web");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String date = sdf.format(ulog.getFecha());
        soapBodyElem2.addTextNode(date);
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("VALOR1", "web");
        soapBodyElem3.addTextNode(ulog.getValor1());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("VALOR2", "web");
        soapBodyElem4.addTextNode(ulog.getValor2());
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("VALOR3", "web");
        soapBodyElem5.addTextNode(ulog.getValor3());
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("VALOR4", "web");
        soapBodyElem6.addTextNode(ulog.getValor4());
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("VALOR5", "web");
        soapBodyElem7.addTextNode(ulog.getValor5());
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("SISTEMA", "web");
        soapBodyElem8.addTextNode(ulog.getSistema());        
//        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("NOMBRE", "web");
//        soapBodyElem2.addTextNode(p.getNombre());
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/usuarioLogin_upd");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private String getSOAPResponseUlogUpd(SOAPMessage soapResponse) throws Exception {
        UsuarioLogin ulog = new UsuarioLogin();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "usuarioLogin_upd");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("usuarioLogin_UpdResult");
        String result = nl.item(0).getFirstChild().getNodeValue();
        return result;

    }
    
     public boolean usuarioLogin_cumpleSesionesMaxima(String rut) {
        try {
            //Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            Properties props = new Properties();
            props.load(new FileInputStream("ws.properties"));

            String url = props.getProperty("ws");
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestcumpleSesionesMaxima(rut), url);

            // Recibe la respuesta SOAP y la procesa.
            String result = getSOAPResponsecumpleSesionesMaxima(soapResponse);

            soapConnection.close();
            if (Integer.parseInt(result) == 1) {
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

    private SOAPMessage createSOAPRequestcumpleSesionesMaxima(String rut) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("usuarioLogin_cumpleSesionesMaxima", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("RUT", "web");
        soapBodyElem1.addTextNode(rut);
//        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("NOMBRE", "web");
//        soapBodyElem2.addTextNode(p.getNombre());
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/usuarioLogin_cumpleSesionesMaxima");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private String getSOAPResponsecumpleSesionesMaxima(SOAPMessage soapResponse) throws Exception {
        UsuarioLogin ulog = new UsuarioLogin();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "usuarioLogin_cumpleSesionesMaxima");
        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();

        NodeList nl = XMLDoc.getElementsByTagName("usuarioLogin_cumpleSesionesMaximaResult");
        String result = nl.item(0).getFirstChild().getNodeValue();
        return result;

    }
    

}

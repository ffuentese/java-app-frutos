/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Comuna;
import DTO.Productor;
import java.util.ArrayList;
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
public class ComunaDAO {
    
    public ArrayList<Comuna> listaComunas(){
        ArrayList<Comuna> arrcomunas = new ArrayList<>();
        
         try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            String url = "http://localhost:49193/Service1.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestListaComunas(), url);

 
            // Recibe la respuesta SOAP y la procesa.
            arrcomunas = getSOAPResponseListaComunas(soapResponse);
            
            
            

            soapConnection.close();
            return arrcomunas;
        } catch (Exception e) {
            System.err.println("Hubo un error en la conexión con el webservice");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
         return null;
    }
    
    
    private SOAPMessage createSOAPRequestListaComunas() throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("Comunas_Sel_All", "web");
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Comunas_Sel_All");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }
    
    private ArrayList<Comuna> getSOAPResponseListaComunas(SOAPMessage soapResponse) throws Exception {
        ArrayList<Comuna> arrcom = new ArrayList<Comuna>();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Comunas_Sel_All");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//Comunas").evaluate(XMLDoc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :"
//                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("COMUNA : "
                        + eElement.getAttribute("msdata:rowOrder"));
                int val = Integer.parseInt(eElement.getAttribute("msdata:rowOrder"));
                Comuna com = new Comuna();
//                usu.setRut(eElement.getElementsByTagName("RUT").item(0).getTextContent());
//                usu.setPass(eElement.getElementsByTagName("CONTRASENA").item(0).getTextContent());
//                usu.setId_tipo_perfil(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PERFIL").item(0).getTextContent()));
                com.setId_comuna(Integer.parseInt(eElement.getElementsByTagName("ID_COMUNA").item(0).getTextContent()));
                com.setId_region(Integer.parseInt(eElement.getElementsByTagName("ID_REGION").item(0).getTextContent()));
                com.setNombre(eElement.getElementsByTagName("NOMBRE").item(0).getTextContent());
                System.out.println(com);
                arrcom.add(com);
            }
             
        }
        return arrcom;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.Direccion;
import DTO.Productor;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 *
 * @author Francisco
 */
public class DireccionDAO {
    public void Update(Direccion dir){
        try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            String url = "http://localhost:49193/Service1.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestupd(dir), url);

 
            // Recibe la respuesta SOAP y la procesa.
            //arrproductor = getSOAPResponseListaProd(soapResponse);
            
          
            soapConnection.close();
            
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
         
    }
        
    private SOAPMessage createSOAPRequestupd(Direccion d) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("Direccion_upd", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id_direccion", "web");
        soapBodyElem1.addTextNode(Integer.toString(d.getId_direccion()));
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("nombre", "web");
        soapBodyElem2.addTextNode(d.getNombre());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("numero", "web");
        soapBodyElem3.addTextNode(d.getNumero());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("id_comuna", "web");
        soapBodyElem4.addTextNode(Integer.toString(d.getId_comuna()));
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("coordenadaX", "web");
        soapBodyElem5.addTextNode(d.getCoordenadaX());
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("coordenadaY", "web");
        soapBodyElem6.addTextNode(d.getCoordenadaY());
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Direccion_upd");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }
}

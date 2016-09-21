/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.Productor;
import DTO.Historial_ventas;
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
public class HistorialVentasControlador {
    ArrayList<Historial_ventas> arrventas=new ArrayList<>();
    
    public ArrayList<Historial_ventas> listaVentas(String rut){
         try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            String url = "http://localhost:49193/Service1.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestListaVentas(rut), url);

 
            // Recibe la respuesta SOAP y la procesa.
            arrventas = getSOAPResponseListaVentas(soapResponse);
            
            
            

            soapConnection.close();
            return arrventas;
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
         return null;
    }
    
    private SOAPMessage createSOAPRequestListaVentas(String rut) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("Historial_ventas_Man", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("rut", "web");
        soapBodyElem1.addTextNode(rut);
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Historial_ventas_Man");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }
    
    private ArrayList<Historial_ventas> getSOAPResponseListaVentas(SOAPMessage soapResponse) throws Exception {
        Historial_ventas ventas=new Historial_ventas();
        ArrayList<Historial_ventas> arrventas = new ArrayList<>();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Historial_ventas_Man");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//PRODUCTOR").evaluate(XMLDoc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
            System.out.println("\nCurrent Element :"
                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("PRODUCTOR : "
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
                ventas.setCantidad(eElement.getElementsByTagName("CANTIDAD").item(0).getTextContent());
                ventas.setNombre_cliente(eElement.getElementsByTagName("NOMBRE_CLIENTE").item(0).getTextContent());
                ventas.setNombre_producto(eElement.getElementsByTagName("NOMBRE_PRODUCTO").item(0).getTextContent());
                ventas.setNum_venta(eElement.getElementsByTagName("NUM_VENTA").item(0).getTextContent());
                ventas.setPrecio_final(eElement.getElementsByTagName("PRECIO_FINAL").item(0).getTextContent());
                ventas.setPrecio_unitario(eElement.getElementsByTagName("PRECIO_UNITARIO").item(0).getTextContent());
                ventas.setTipo_producto(eElement.getElementsByTagName("TIPO_PRODUCTO").item(0).getTextContent());
                ventas.setTipo_unidad(eElement.getElementsByTagName("TIPO_UNIDAD").item(0).getTextContent());
                //pro.setMisma_direccion(eElement.getElementsByTagName("MISMADIRECCION").item(0).getTextContent());
            }
             arrventas.add(ventas);
        }
        return arrventas;
    }
}

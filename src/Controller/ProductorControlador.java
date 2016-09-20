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
        SOAPElement soapBodyElem = soapBody.addChildElement("Productos_Sel_All_Productor_Man", "web");
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Productos_Sel_All_Productor_Man");

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
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Productos_Sel_All_Productor_Man");

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
                pro.setRut(eElement.getElementsByTagName("RUT").item(0).getTextContent());
                pro.setDv(eElement.getElementsByTagName("DV").item(0).getTextContent());
                pro.setNombre((eElement.getElementsByTagName("NOMBRE").item(0).getTextContent()));
                pro.setApellido((eElement.getElementsByTagName("APELLIDO").item(0).getTextContent()));
                pro.setSexo((eElement.getElementsByTagName("SEXO").item(0).getTextContent()));
                pro.setId_direccion_particular((eElement.getElementsByTagName("ID_DIRECCIONPARTICULAR").item(0).getTextContent()));
                pro.setDireccion_particular(eElement.getElementsByTagName("DIRECCION_PARTICULAR").item(0).getTextContent());
                pro.setNumero_particular(eElement.getElementsByTagName("NUMERO_PARTICULAR").item(0).getTextContent());
                pro.setComuna_particular(eElement.getElementsByTagName("COMUNA_PARTICULAR").item(0).getTextContent());
               pro.setId_comunaparticular(eElement.getElementsByTagName("ID_COMUNA_PARTICULAR").item(0).getTextContent());
                pro.setRegionparticular(eElement.getElementsByTagName("REGION_PARTICULAR").item(0).getTextContent());
                pro.setId_direccion_negocio((eElement.getElementsByTagName("ID_DIRECCIONNEGOCIO").item(0).getTextContent()));
                pro.setDireccion_negocio(eElement.getElementsByTagName("DIRECCION_NEGOCIO").item(0).getTextContent());
                pro.setNumero_negocio(eElement.getElementsByTagName("NUMERO_NEGOCIO").item(0).getTextContent());
                pro.setComuna_negocio(eElement.getElementsByTagName("COMUNA_NEGOCIO").item(0).getTextContent());
                pro.setId_comunanegocio(eElement.getElementsByTagName("ID_COMUNA_NEGOCIO").item(0).getTextContent());
                pro.setRegioncomercial(eElement.getElementsByTagName("REGION_NEGOCIO").item(0).getTextContent());
                pro.setTelefono((eElement.getElementsByTagName("TELEFONO").item(0).getTextContent()));
                pro.setCorreo((eElement.getElementsByTagName("CORREO").item(0).getTextContent()));
                //pro.setMisma_direccion(eElement.getElementsByTagName("MISMADIRECCION").item(0).getTextContent());
            }
             arrpro.add(pro);
        }
        return arrpro;
    }
    
    public void Update(Productor pro){
        try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            String url = "http://localhost:49193/Service1.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestupdprod(pro), url);

 
            // Recibe la respuesta SOAP y la procesa.
            //arrproductor = getSOAPResponseListaProd(soapResponse);
            
          
            soapConnection.close();
            
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
         
    }
        
    private SOAPMessage createSOAPRequestupdprod(Productor p) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("Productor_upd", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("rut", "web");
        soapBodyElem1.addTextNode(p.getRut());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("dv", "web");
        soapBodyElem2.addTextNode(p.getDv());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("nombre", "web");
        soapBodyElem3.addTextNode(p.getNombre());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("apellido", "web");
        soapBodyElem4.addTextNode(p.getApellido());
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("sexo", "web");
        soapBodyElem5.addTextNode(p.getSexo());
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("id_direccionparticular", "web");
        soapBodyElem6.addTextNode(p.getId_direccion_particular());
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("correo", "web");
        soapBodyElem7.addTextNode(p.getCorreo());
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("id_direccionnegocio", "web");
        soapBodyElem8.addTextNode(p.getId_direccion_negocio());
        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("mismadireccion", "web");
        soapBodyElem9.addTextNode(p.getMisma_direccion());
        SOAPElement soapBodyElem10 = soapBodyElem.addChildElement("telefono", "web");
        soapBodyElem10.addTextNode(p.getTelefono());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Productor_upd");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }
    
//    private String getSOAPResponseupdateprod(SOAPMessage soapResponse) throws Exception {
//        Productor pro = new Productor();
//        SOAPBody sb = soapResponse.getSOAPBody();
//        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
//        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Productor_upd");
//
//        Document XMLDoc = sb.extractContentAsDocument();
//        XPath xpath = XPathFactory.newInstance().newXPath();
////        XPathExpression expr = xpath.compile("//Usuario");
////        String result = String.class.cast(expr.evaluate(XMLDoc,
////                XPathConstants.STRING));
//        NodeList nodeList = (NodeList) xpath.compile("//PRODUCTOR").evaluate(XMLDoc, XPathConstants.NODESET);
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            org.w3c.dom.Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :"
//                    + nNode.getNodeName());
//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                Element eElement = (Element) nNode;
//                System.out.println("PRODUCTOR : "
//                        + eElement.getAttribute("msdata:rowOrder"));
//                pro.setRut(eElement.getElementsByTagName("").item(0).getTextContent());
//            }
//             
//        }
//        return pro.getRut();
//    }
        
        
    }

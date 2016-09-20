/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Medida;
import DTO.Producto;
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
public class ProductoDAO {

    public ArrayList<Producto> listaProductosRUT(int rut) {
        ArrayList<Producto> arrproducto = new ArrayList<>();

        try {
            // Crea SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Envía Mensaje SOAP a Servidor SOAP 
            String url = "http://localhost:49193/Service1.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestListaProductosRUT(rut), url);

            // Recibe la respuesta SOAP y la procesa.
            arrproducto = getSOAPResponseListaProductosRUT(soapResponse);

            soapConnection.close();
            return arrproducto;
        } catch (Exception e) {
            System.err.println("Hubo un error en la conexión con el webservice");
            e.printStackTrace();
            //lblError.setText("Hubo un error en la conexión con el servidor");
        }
        return null;
    }

    private SOAPMessage createSOAPRequestListaProductosRUT(int rut) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("Productos_Sel_All_Prod", "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("rut", "web");
        soapBodyElem1.addTextNode(Integer.toString(rut));

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "/Productos_Sel_All_Prod");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        String x = soapMessage.toString();
        System.out.println();

        return soapMessage;
    }

    private ArrayList<Producto> getSOAPResponseListaProductosRUT(SOAPMessage soapResponse) throws Exception {
        ArrayList<Producto> arrprod = new ArrayList<Producto>();
        SOAPBody sb = soapResponse.getSOAPBody();
        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        QName bodyName1 = new QName("http://localhost:49193/Service1.asmx", "Productos_Sel_All_Prod");

        Document XMLDoc = sb.extractContentAsDocument();
        XPath xpath = XPathFactory.newInstance().newXPath();
//        XPathExpression expr = xpath.compile("//Usuario");
//        String result = String.class.cast(expr.evaluate(XMLDoc,
//                XPathConstants.STRING));
        NodeList nodeList = (NodeList) xpath.compile("//Productos").evaluate(XMLDoc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :"
//                    + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
//                System.out.println("COMUNA : "
//                        + eElement.getAttribute("msdata:rowOrder"));
                int val = Integer.parseInt(eElement.getAttribute("msdata:rowOrder"));
                Producto prod = new Producto();
//                usu.setRut(eElement.getElementsByTagName("RUT").item(0).getTextContent());
//                usu.setPass(eElement.getElementsByTagName("CONTRASENA").item(0).getTextContent());
//                usu.setId_tipo_perfil(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PERFIL").item(0).getTextContent()));
                prod.setId_producto(Integer.parseInt(eElement.getElementsByTagName("ID_PRODUCTO").item(0).getTextContent()));
                prod.setRut_productor(Integer.parseInt(eElement.getElementsByTagName("RUT_PRODUCTOR").item(0).getTextContent()));
                prod.setId_tipo_producto(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_PRODUCTO").item(0).getTextContent()));
                prod.setOferta(Integer.parseInt(eElement.getElementsByTagName("OFERTA").item(0).getTextContent()));
                prod.setDescripcion(eElement.getElementsByTagName("DESCRIPCION_ELABORACION").item(0).getTextContent());
                prod.setId_direccion((Integer.parseInt(eElement.getElementsByTagName("ID_DIRECCION").item(0).getTextContent())));
                prod.setZona_cultivo(eElement.getElementsByTagName("ZONA_CULTIVO").item(0).getTextContent());
                prod.setStock(Integer.parseInt(eElement.getElementsByTagName("STOCK").item(0).getTextContent()));
                prod.setPrecio(Integer.parseInt(eElement.getElementsByTagName("PRECIO_UNITARIO").item(0).getTextContent()));
                prod.setId_medida(Integer.parseInt(eElement.getElementsByTagName("ID_MEDIDA").item(0).getTextContent()));
                prod.setId_tipo_cultivo(Integer.parseInt(eElement.getElementsByTagName("ID_TIPO_CULTIVO").item(0).getTextContent()));
                prod.setActivo(Integer.parseInt(eElement.getElementsByTagName("ACTIVO").item(0).getTextContent()));
                arrprod.add(prod);
            }

        }
        return arrprod;
    }
}

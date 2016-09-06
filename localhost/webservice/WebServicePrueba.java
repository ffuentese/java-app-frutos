
package localhost.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Servicio Prueba
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServicePrueba", targetNamespace = "http://localhost/WebService", wsdlLocation = "file:/C:/Users/Francisco/Documents/NetBeansProjects/java-app-frutos/src/META-INF/wsdl/localhost_49193/Service1.asmx.wsdl")
public class WebServicePrueba
    extends Service
{

    private final static URL WEBSERVICEPRUEBA_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEPRUEBA_EXCEPTION;
    private final static QName WEBSERVICEPRUEBA_QNAME = new QName("http://localhost/WebService", "WebServicePrueba");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Francisco/Documents/NetBeansProjects/java-app-frutos/src/META-INF/wsdl/localhost_49193/Service1.asmx.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEPRUEBA_WSDL_LOCATION = url;
        WEBSERVICEPRUEBA_EXCEPTION = e;
    }

    public WebServicePrueba() {
        super(__getWsdlLocation(), WEBSERVICEPRUEBA_QNAME);
    }

    public WebServicePrueba(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEPRUEBA_QNAME, features);
    }

    public WebServicePrueba(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEPRUEBA_QNAME);
    }

    public WebServicePrueba(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEPRUEBA_QNAME, features);
    }

    public WebServicePrueba(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicePrueba(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServicePruebaSoap
     */
    @WebEndpoint(name = "WebServicePruebaSoap")
    public WebServicePruebaSoap getWebServicePruebaSoap() {
        return super.getPort(new QName("http://localhost/WebService", "WebServicePruebaSoap"), WebServicePruebaSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicePruebaSoap
     */
    @WebEndpoint(name = "WebServicePruebaSoap")
    public WebServicePruebaSoap getWebServicePruebaSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost/WebService", "WebServicePruebaSoap"), WebServicePruebaSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEPRUEBA_EXCEPTION!= null) {
            throw WEBSERVICEPRUEBA_EXCEPTION;
        }
        return WEBSERVICEPRUEBA_WSDL_LOCATION;
    }

}

package servicesClient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StudentWebServices", targetNamespace = "http://services/", wsdlLocation = "http://localhost:8080/StudentSOAP/StudentWebServices?WSDL")
public class StudentWebServices_Service
    extends Service
{

    private final static URL STUDENTWEBSERVICES_WSDL_LOCATION;
    private final static WebServiceException STUDENTWEBSERVICES_EXCEPTION;
    private final static QName STUDENTWEBSERVICES_QNAME = new QName("http://services/", "StudentWebServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/StudentSOAP/StudentWebServices?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STUDENTWEBSERVICES_WSDL_LOCATION = url;
        STUDENTWEBSERVICES_EXCEPTION = e;
    }

    public StudentWebServices_Service() {
        super(__getWsdlLocation(), STUDENTWEBSERVICES_QNAME);
    }

    public StudentWebServices_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), STUDENTWEBSERVICES_QNAME, features);
    }

    public StudentWebServices_Service(URL wsdlLocation) {
        super(wsdlLocation, STUDENTWEBSERVICES_QNAME);
    }

    public StudentWebServices_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STUDENTWEBSERVICES_QNAME, features);
    }

    public StudentWebServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StudentWebServices_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StudentWebServices
     */
    @WebEndpoint(name = "StudentWebServicesPort")
    public StudentWebServices getStudentWebServicesPort() {
        return super.getPort(new QName("http://services/", "StudentWebServicesPort"), StudentWebServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StudentWebServices
     */
    @WebEndpoint(name = "StudentWebServicesPort")
    public StudentWebServices getStudentWebServicesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services/", "StudentWebServicesPort"), StudentWebServices.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STUDENTWEBSERVICES_EXCEPTION!= null) {
            throw STUDENTWEBSERVICES_EXCEPTION;
        }
        return STUDENTWEBSERVICES_WSDL_LOCATION;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import localhost.webservice.AutenticarResponse;

/**
 *
 * @author Francisco
 */
public class LoginControlador {
     public static AutenticarResponse.AutenticarResult autenticar(java.lang.String user, java.lang.String pas) {
        localhost.webservice.WebServicePrueba service = new localhost.webservice.WebServicePrueba();
        localhost.webservice.WebServicePruebaSoap port = service.getWebServicePruebaSoap();
        return port.autenticar(user, pas);
    }
}

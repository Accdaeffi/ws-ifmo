/**
 * PersonCreateService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.create;

public class PersonCreateService_ServiceLocator extends org.apache.axis.client.Service implements client.service.create.PersonCreateService_Service {

    public PersonCreateService_ServiceLocator() {
    }


    public PersonCreateService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonCreateService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonCreateServicePort
    private java.lang.String PersonCreateServicePort_address = "http://localhost:8080/PersonCreateService";

    public java.lang.String getPersonCreateServicePortAddress() {
        return PersonCreateServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PersonCreateServicePortWSDDServiceName = "PersonCreateServicePort";

    public java.lang.String getPersonCreateServicePortWSDDServiceName() {
        return PersonCreateServicePortWSDDServiceName;
    }

    public void setPersonCreateServicePortWSDDServiceName(java.lang.String name) {
        PersonCreateServicePortWSDDServiceName = name;
    }

    public client.service.create.PersonCreateService_PortType getPersonCreateServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonCreateServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonCreateServicePort(endpoint);
    }

    public client.service.create.PersonCreateService_PortType getPersonCreateServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.service.create.PersonCreateServicePortBindingStub _stub = new client.service.create.PersonCreateServicePortBindingStub(portAddress, this);
            _stub.setPortName(getPersonCreateServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonCreateServicePortEndpointAddress(java.lang.String address) {
        PersonCreateServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.service.create.PersonCreateService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                client.service.create.PersonCreateServicePortBindingStub _stub = new client.service.create.PersonCreateServicePortBindingStub(new java.net.URL(PersonCreateServicePort_address), this);
                _stub.setPortName(getPersonCreateServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PersonCreateServicePort".equals(inputPortName)) {
            return getPersonCreateServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonCreateService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.services.webservice/", "PersonCreateServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonCreateServicePort".equals(portName)) {
            setPersonCreateServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

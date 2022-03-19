/**
 * PersonCreateService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client.service.create;

public interface PersonCreateService_PortType extends java.rmi.Remote {
    public client.model.Person createPerson(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault;
}

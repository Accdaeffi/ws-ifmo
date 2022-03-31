package client.service.create;

public class PersonCreateServiceProxy implements client.service.create.PersonCreateService_PortType {

	public boolean isFree = true;
	
  private String _endpoint = null;
  private client.service.create.PersonCreateService_PortType personCreateService_PortType = null;
  
  public PersonCreateServiceProxy() {
    _initPersonCreateServiceProxy();
  }
  
  public PersonCreateServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonCreateServiceProxy();
  }
  
  private void _initPersonCreateServiceProxy() {
    try {
      personCreateService_PortType = (new client.service.create.PersonCreateService_ServiceLocator()).getPersonCreateServicePort();
      if (personCreateService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personCreateService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personCreateService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personCreateService_PortType != null)
      ((javax.xml.rpc.Stub)personCreateService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public client.service.create.PersonCreateService_PortType getPersonCreateService_PortType() {
    if (personCreateService_PortType == null)
      _initPersonCreateServiceProxy();
    return personCreateService_PortType;
  }
  
  public client.model.Person createPerson(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3) throws java.rmi.RemoteException, client.model.faults.IncorrectArgumentFault, client.model.faults.WorkWithSQLFault, client.model.faults.EmptyArgumentFault{
    if (personCreateService_PortType == null)
      _initPersonCreateServiceProxy();
    return personCreateService_PortType.createPerson(arg0, arg1, arg2, arg3);
  }
  
  
}
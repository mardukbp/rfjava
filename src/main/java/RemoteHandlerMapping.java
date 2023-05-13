import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcHandler;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcNoSuchHandlerException;

public class RemoteHandlerMapping extends PropertyHandlerMapping {
    @Override
    public XmlRpcHandler getHandler(String pHandlerName) throws XmlRpcException {
        if (pHandlerName.equals("get_library_information")) {
            try {
                super.getHandler(pHandlerName);
            }
            catch (Exception e) {
                throw new XmlRpcNoSuchHandlerException("The handler get_library_information is not implemented");
            }
        }

        return super.getHandler("RobotRemote." + pHandlerName);
    }
}

import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Main {
    private static final int port = 8270;

    public static void main(String[] args) throws Exception {
        org.apache.log4j.PropertyConfigurator.configure(Main.class.getResourceAsStream("log4j.properties"));

        WebServer webServer = new WebServer(port);
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
        RemoteHandlerMapping phm = new RemoteHandlerMapping();

        RobotRemote robotRemote = new RobotRemote(new TestLibrary());

        phm.setRequestProcessorFactoryFactory(new RobotRemoteFactoryFactory(robotRemote));
        phm.setVoidMethodEnabled(true);
        phm.addHandler(RobotRemote.class.getName(), RobotRemote.class);

//        phm.addHandler(RobotRemote.class.getName(), robotRemote.getClass());
        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig =
                (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        webServer.start();
    }
}
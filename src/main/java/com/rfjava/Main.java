package com.rfjava;

import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Main {
    private static final int port = 8270;

    public static void main(String[] args) throws Exception {
        org.apache.log4j.PropertyConfigurator.configure(Main.class.getClassLoader().getResourceAsStream("log4j.properties"));

        WebServer webServer = new WebServer(port);
        RobotRemote robotRemote = new RobotRemote(new TestLibrary());

        RemoteHandlerMapping phm = new RemoteHandlerMapping();
        phm.setRequestProcessorFactoryFactory(new RobotRemoteFactoryFactory(robotRemote));
        phm.setVoidMethodEnabled(true);
        phm.addHandler(RobotRemote.class.getName(), RobotRemote.class);

        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
        xmlRpcServer.setHandlerMapping(phm);
        XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        webServer.start();

        System.out.println("The RF Remote server is listening on http://127.0.0.1:" + port);
        System.out.println("Press Ctrl-C to stop it");
    }
}
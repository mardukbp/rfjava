package com.rfjava;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.server.RequestProcessorFactoryFactory;

public class RobotRemoteFactoryFactory implements RequestProcessorFactoryFactory {
    private final RequestProcessorFactory factory = new RobotRemoteRequestProcessorFactory();
    private final RobotRemote robotRemote;

    public RobotRemoteFactoryFactory(RobotRemote robotRemote) {
        this.robotRemote = robotRemote;
    }

    public RequestProcessorFactory getRequestProcessorFactory(Class aClass) throws XmlRpcException {
        return factory;
    }

    private class RobotRemoteRequestProcessorFactory implements RequestProcessorFactory {
        public Object getRequestProcessor(XmlRpcRequest xmlRpcRequest) throws XmlRpcException {
            return robotRemote;
        }
    }
}

package org.shag;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.log.Log;

import java.lang.management.ManagementFactory;


/**
 * A Normal Jetty Runner\
 * Created by Twosmiles on 21.05.2017.
 */
public class JettyRunner {

    public static void main(String[] args) throws Exception {

        Server server = new Server(7777);
        server.addBean(Log.getLog());

        // Setup JMX.
        MBeanContainer mbeanContainer = new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
        server.addEventListener(mbeanContainer);
        server.addBean(mbeanContainer);

        // Add My Bean
        server.addBean(new HelloMBean());

        server.start();
        server.join();
    }

}

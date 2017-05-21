package org.shag;

import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.annotation.Name;

import java.util.logging.Logger;

import static org.shag.Message.MessageBuilder;

/**
 * ManagedBean Example for Jetty with Operation
 * Created by Twosmiles on 21.05.2017.
 */
@ManagedObject("org.shag.HelloMBean")
public class HelloMBean {

    public static final Logger LOG = Logger.getLogger(HelloMBean.class.getName());

    @ManagedOperation
    public void printMessageOnConsole(@Name(value = "Sender Information", description = "From - Sender Information") final String From) {
        //formatter:off
        final Message helloMessage = MessageBuilder.
                aMessage().
                from(From).
                to("Sansoune").
                text("Hello").
                build();
        //fomatter:on

        //Do some log
        LOG.info(helloMessage.toString());
    }

}

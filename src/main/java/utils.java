import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * Created by juhunuque on 7/21/16.
 */
public class utils {

    static final String url = "tcp://192.168.99.100:61616"; // You also can use the failover string
    static final String user = "admin";
    static final String password = "admin";
    /*
     * Function that create a connection to the ACTIVEMQ and returns as a "ConnectionFactory" object
     */
    public static ConnectionFactory createActiveMQFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        activeMQConnectionFactory.setBrokerURL(url);
        activeMQConnectionFactory.setUserName(user);
        activeMQConnectionFactory.setPassword(password);
        ConnectionFactory factory = activeMQConnectionFactory;
        return factory;
    }
}

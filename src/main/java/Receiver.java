/**
 * Created by juhunuque on 7/21/16.
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Receiver {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;

    public Receiver(){}

    /*
     * Function that access the ACTIVEMQ and pull a message from a QUEUE
     */
    public void receiveMessage(){
        try {
            factory = utils.createActiveMQFactory();
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("SAMPLEQUEUE");
            consumer = session.createConsumer(destination);
            Message message = consumer.receive();

            if(message instanceof TextMessage){
                TextMessage text = (TextMessage) message;
                System.out.println("Message is: " + text.getText());
            }
        }catch (JMSException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        org.apache.log4j.BasicConfigurator.configure();
        Receiver receiver = new Receiver();
        receiver.receiveMessage();
    }
}

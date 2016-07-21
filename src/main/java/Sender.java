/**
 * Created by juhunuque on 7/21/16.
 */

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;


public class Sender {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public Sender(){}


    /*
     * Function on charge of connect to the ActiveMQ, connect to a QUEUE and send a message( or event )
     */
    public void sendMessage(){
        try{
            factory = utils.createActiveMQFactory();
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination =  session.createQueue("SAMPLEQUEUE");
            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText("This is a sample message by Julio NQ");
            producer.send(message);
            System.out.println("Sent: " + message.getText());

        }catch (JMSException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        org.apache.log4j.BasicConfigurator.configure();
        Sender senderObj = new Sender();
        senderObj.sendMessage();
    }

}

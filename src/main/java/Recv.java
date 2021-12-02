import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.nio.charset.StandardCharsets;

public class Recv {

    private final static String QUEUE_NAME = "hello";
	private final static String QUEUE_NAMEbr = "br";
	private final static String QUEUE_NAMEem = "em";
	private final static String QUEUE_NAMEmic = "mic";
	private final static String QUEUE_NAMEmot = "mot";
	private final static String QUEUE_NAMEtemp = "temp";
	private final static String QUEUE_NAMEhum = "hum";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        
        Channel channel = connection.createChannel();
		Channel brchannel = connection.createChannel();
		Channel emchannel = connection.createChannel();
		Channel micchannel = connection.createChannel();
		Channel motchannel = connection.createChannel();
		Channel tempchannel = connection.createChannel();
		Channel humchannel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		brchannel.queueDeclare(QUEUE_NAMEbr, false, false, false, null);
		emchannel.queueDeclare(QUEUE_NAMEem, false, false, false, null);
		micchannel.queueDeclare(QUEUE_NAMEmic, false, false, false, null);
		motchannel.queueDeclare(QUEUE_NAMEmot, false, false, false, null);
		tempchannel.queueDeclare(QUEUE_NAMEtemp, false, false, false, null);
		humchannel.queueDeclare(QUEUE_NAMEhum, false, false, false, null);
		
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        brchannel.basicConsume(QUEUE_NAMEbr, true, deliverCallback, consumerTag -> { });
        emchannel.basicConsume(QUEUE_NAMEem, true, deliverCallback, consumerTag -> { });
        micchannel.basicConsume(QUEUE_NAMEmic, true, deliverCallback, consumerTag -> { });
        motchannel.basicConsume(QUEUE_NAMEmot, true, deliverCallback, consumerTag -> { });
        tempchannel.basicConsume(QUEUE_NAMEtemp, true, deliverCallback, consumerTag -> { });
        humchannel.basicConsume(QUEUE_NAMEhum, true, deliverCallback, consumerTag -> { });
    }
}
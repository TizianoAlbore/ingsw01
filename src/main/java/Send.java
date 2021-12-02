import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Send {

	private final static String QUEUE_NAME = "hello";
	private final static String QUEUE_NAMEbr = "br";
	private final static String QUEUE_NAMEem = "em";
	private final static String QUEUE_NAMEmic = "mic";
	private final static String QUEUE_NAMEmot = "mot";
	private final static String QUEUE_NAMEtemp = "temp";
	private final static String QUEUE_NAMEhum = "hum";

	public static void main(String[] argv) throws Exception {
		
		Brightness br = new Brightness();
		ElectroMagn em = new ElectroMagn();
		Mic mic = new Mic();
		Motion mot = new Motion();
		Temperature temp = new Temperature();

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		try (Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				Channel brchannel = connection.createChannel();
				Channel emchannel = connection.createChannel();
				Channel micchannel = connection.createChannel();
				Channel motchannel = connection.createChannel();
				Channel tempchannel = connection.createChannel();
				Channel humchannel = connection.createChannel();) 
		{
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			brchannel.queueDeclare(QUEUE_NAMEbr, false, false, false, null);
			emchannel.queueDeclare(QUEUE_NAMEem, false, false, false, null);
			micchannel.queueDeclare(QUEUE_NAMEmic, false, false, false, null);
			motchannel.queueDeclare(QUEUE_NAMEmot, false, false, false, null);
			tempchannel.queueDeclare(QUEUE_NAMEtemp, false, false, false, null);
			humchannel.queueDeclare(QUEUE_NAMEhum, false, false, false, null);

			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
			System.out.println(" [x] Sent '" + message + "'");
			
			while(true) {
				message.valueOf(br.genBright());
				brchannel.basicPublish("", QUEUE_NAMEbr, null, message.getBytes(StandardCharsets.UTF_8));
				message.valueOf(em.getMagn());
				emchannel.basicPublish("", QUEUE_NAMEem, null, message.getBytes(StandardCharsets.UTF_8));
				message.valueOf(mic.genLoud());
				micchannel.basicPublish("", QUEUE_NAMEmic, null, message.getBytes(StandardCharsets.UTF_8));
				message.valueOf(mot.genMove());
				motchannel.basicPublish("", QUEUE_NAMEmot, null, message.getBytes(StandardCharsets.UTF_8));
				message.valueOf(temp.genHum());
				tempchannel.basicPublish("", QUEUE_NAMEtemp, null, message.getBytes(StandardCharsets.UTF_8));
				message.valueOf(temp.genHum());
				humchannel.basicPublish("", QUEUE_NAMEhum, null, message.getBytes(StandardCharsets.UTF_8));
				System.out.println(" [x] Sent");
				Thread.sleep(5*1000);
			}
			
		}

	}
}
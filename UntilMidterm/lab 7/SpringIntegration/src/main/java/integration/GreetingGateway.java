package integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface GreetingGateway {

	@Gateway(requestChannel = "inputChannel")
	String handleRequest(Message<Order> message);
}

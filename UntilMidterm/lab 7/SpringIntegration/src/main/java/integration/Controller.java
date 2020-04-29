package integration;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	@Autowired
	private GreetingGateway gateway;
	
	@RequestMapping("/greeting/{name}")
	public String getGreeting(@PathVariable("name") Double value) {

		Order order = new Order("123", String.valueOf(value));

		Message<Order> orderMessage =  MessageBuilder.withPayload(order).build();

		String result = gateway.handleRequest(orderMessage);
		return result;
	}
}

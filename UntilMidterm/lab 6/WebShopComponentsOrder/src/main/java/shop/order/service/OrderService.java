package shop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.order.domain.Order;
import shop.order.domain.OrderFactory;
import shop.order.integration.CustomerServiceProxy;
import shop.order.integration.EmailSender;
import shop.order.integration.Logger;
import shop.order.repository.OrderRepository;

import java.util.Optional;


@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerServiceProxy customerService;
	@Autowired
	EmailSender emailSender;
	@Autowired
	Logger logger;

	public OrderDTO getOrder(String orderNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			return OrderAdapter.getOrderDTO(optOrder.get());
		} else
			return null;
	}
	
	public void createOrder(ShoppingCartDTO shoppingCartDTO) {	
		Order order = OrderFactory.createOrder(shoppingCartDTO);
		orderRepository.save(order);
	}
	
	public void confirm(String orderNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			Order order= optOrder.get();
			order.confirm();
			emailSender.sendEmail("Thank you for your order with order number "+order.getOrdernumber(), "customer@gmail.com");
			logger.log("new order with order number "+order.getOrdernumber());
		} 
	}

	public void setCustomer(String orderNumber, String customerNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			Order order = optOrder.get();
			OrderCustomerDTO customerDTO = customerService.getOrderCustomer(customerNumber);
			if(customerDTO!=null) {
				order.setCustomer(OrderCustomerAdapter.getCustomer(customerDTO));
			}
			orderRepository.save(order);
		}		
	}

}
